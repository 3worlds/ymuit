/**************************************************************************
 *  YMUIT - Yet More User-Interface Tools                                 *
 *                                                                        *
 *  Copyright 2018: Jacques Gignoux & Ian D. Davies                       *
 *       jacques.gignoux@upmc.fr                                          *
 *       ian.davies@anu.edu.au                                            * 
 *                                                                        *
 *  YMUIT contains a number of classes and helper methods for working     *
 *  with java fx classes.                                                 *
 *                                                                        *
 **************************************************************************                                       
 *  This file is part of  YMUIT (Yet More User-Interface Tools).          *
 *                                                                        *
 *  YMUIT is free software: you can redistribute it and/or modify         *
 *  it under the terms of the GNU General Public License as published by  *
 *  the Free Software Foundation, either version 3 of the License, or     *
 *  (at your option) any later version.                                   *
 *                                                                        *
 *  YMUIT is distributed in the hope that it will be useful,              *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *  GNU General Public License for more details.                          *                         
 *                                                                        *
 *  You should have received a copy of the GNU General Public License     *
 *  along with YMUIT.                                                     *
 *  If not, see <https://www.gnu.org/licenses/gpl.html>.                  *
 *                                                                        *
 **************************************************************************/

package au.edu.anu.ymuit.ui.colour;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math.util.MathUtils;

import fr.cnrs.iees.uit.indexing.BoundedRegionIndexingTree;
import fr.cnrs.iees.uit.indexing.RegionIndexingTree;
import fr.cnrs.iees.uit.space.Box;
import fr.cnrs.iees.uit.space.Point;
import fr.ens.biologie.generic.utils.Duple;
import fr.ens.biologie.generic.utils.Tuple;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;

/**
 * Author Ian Davies
 *
 * Date 2 Dec. 2018
 */
/**
 * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
 * 
 * 1) Add all javafx named colours to an indexer that are a sufficient distance
 * (3d space) from the background. They need to be from the set of named colours
 * because for css we just use names rather than colours.
 * 
 * 2) Divide the space into n voxels and select one colour nearest to the center
 * of each voxel.
 * 
 * 3) Add to list of contrasting colours
 * 
 * But all this needs correcting : blues and red should be in a different range
 * relative to green (most sensitive) cf:
 * https://stackoverflow.com/questions/596216/formula-to-determine-brightness-of-rgb-color
 * 
 * For just colours without names see: Colour displays for categorical images:
 * C.A. Glasbey 2006
 */

public class ColourContrast {
	private static Map<Color, RegionIndexingTree<String>> colourQts = new HashMap<>();
	private static Map<String, Color> colourMap = new HashMap<>();
	private final static double distanceFromBackground = 0.4; // max is sqrt(3);

	public static double distanceFromBkg() {
		return distanceFromBackground;
	}

	/**
	 * Creates a list of named colours that contrast with the given background
	 * colour up to a maximum of maxChoices. Use these colour names to set the css
	 * style sheet of the scene.node in question.
	 * 
	 * @param bkg        background colour
	 * @param maxChoices maximum number of colours. The more colours requested, the
	 *                   less contrast there will be between them.
	 * @return Array of strings of contrasting colours.
	 */
	public static String[] getContrastingColourNames(Color bkg, int maxChoices) {
		Map<String, Duple<Integer, Color>> colours = _getContrastingColoursMap(bkg, maxChoices);
		colours.keySet();
		String[] result = new String[colours.size()];
		colours.forEach((k, v) -> {
			result[v.getFirst()] = k;
		});
		return result;
	}

	public static List<Color> getContrastingColours(Color bkg, int maxChoices) {
		Map<String, Duple<Integer, Color>> colours = _getContrastingColoursMap(bkg, maxChoices);
		List<Color> result = new ArrayList<>();
		colours.forEach((k, v) -> {
			result.add(v.getSecond());
		});
		return result;
	}

	public static Map<String, Color> getContrastingColoursMap(Color bkg, int maxChoices) {
		Map<String, Color> result = new HashMap<>();
		Map<String, Duple<Integer, Color>> colours = _getContrastingColoursMap(bkg, maxChoices);
		colours.forEach((k, v) -> {
			result.put(k, v.getSecond());
		});
		return result;
	}

	private static RegionIndexingTree<String> getKTree(Color key) {
		if (colourQts.containsKey(key))
			return colourQts.get(key);
		else
			return createKTree(key);
	}

	private static RegionIndexingTree<String> createKTree(Color key) {
		Box limits = Box.boundingBox(Point.newPoint(0, 0, 0), Point.newPoint(1, 1, 1));
		RegionIndexingTree<String> result = new BoundedRegionIndexingTree<>(limits);
		result.setOptimisation(true);
		colourQts.put(key, result);
		try {
			if (colourMap.isEmpty())
				colourMap = getNamedColourMap();
			for (Map.Entry<String, Color> entry : colourMap.entrySet()) {
				Color c = entry.getValue();
				double d = colourDistance(key, c);
				// System.out.println("bkg:\t" + key + "\tcolour:\t" + c + "\tdistance:\t" + d);
				if ((d > distanceFromBackground) && (!entry.getKey().contains("TRANSPARENT"))) {
					Point p = Point.newPoint(c.getRed(), c.getGreen(), c.getBlue());
					result.insert(entry.getKey(), p);
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * From:
	 * https://stackoverflow.com/questions/17464906/how-to-list-all-colors-in-javafx
	 * 
	 * Finds all named colours in javaFx through reflection
	 * 
	 * @return: map (Name, Color) of all named colours in javafx.scene.paint.Color
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 */
	private static Map<String, Color> getNamedColourMap() throws ClassNotFoundException, IllegalAccessException {
		Map<String, Color> map = new HashMap<>();
		Class<?> clazz = Class.forName("javafx.scene.paint.Color", true,
				Thread.currentThread().getContextClassLoader());
		if (clazz != null) {
			Field[] field = clazz.getFields();
			for (int i = 0; i < field.length; i++) {
				Field f = field[i];
				Object obj = f.get(null);
				if (obj instanceof Color)
					map.put(f.getName(), (Color) obj);
			}
		}
		return map;
	}

	/**
	 * Distance between colours in RGB 3D space assuming a unit cube.
	 * 
	 * @param c1 first colour
	 * @param c2 second colour
	 * @return distance in RGB space between colours c1 and c2
	 */
	public static double colourDistance(Color c1, Color c2) {
		// TODO reds and blues need to be further apart
		// https://stackoverflow.com/questions/596216/formula-to-determine-brightness-of-rgb-color
		double[] p1 = { c1.getRed(), c1.getGreen(), c1.getBlue() };
		double[] p2 = { c2.getRed(), c2.getGreen(), c2.getBlue() };
		return MathUtils.distance(p1, p2);
	}

	/**
	 * If this class has been used then display a panel in the background colour
	 * with all selected colours.. but how many?
	 */
	public static void show() {
		if (colourQts.isEmpty())
			return;// nothing to show
		ColourContrastShow.setData(colourQts);
		ColourContrastShow.main(new String[0]);

	}

	/**
	 * Creates a map of colour names and colours that contrast with the given
	 * background colour up to a maximum of maxChoices. Use these colour names to
	 * set the css style sheet of the scene.node in question. The value is a duple
	 * with first entry an index. This is used to maintain consistent order
	 * 
	 * @param bkg        background colour
	 * @param maxChoices maximum number of colours. The more colours requested, the
	 *                   less contrast there will be between them.
	 * @return Map of colour names and colours.
	 */
	private static int minColourChoices = 2 * 2 * 2;

	private static Map<String, Duple<Integer, Color>> _getContrastingColoursMap(Color bkg, int nColours) {
		int dim = (int) Math.cbrt(nextPerfectCube(Math.max(nColours, minColourChoices)));
		Map<String, Duple<Integer, Color>> res = new HashMap<>();
		double separation = 1.0 / (double) dim;
		RegionIndexingTree<String> qt = getKTree(bkg);
		int size = (int) (1.0 / separation);
		int count = 0;
		for (int x = 0; x < size; x++) {
			double px = x * separation + separation / 2.0;
			for (int y = 0; y < size; y++) {
				double py = y * separation + separation / 2.0;
				for (int z = 0; z < size; z++) {
					double pz = z * separation + separation / 2.0;
					Point p = Point.newPoint(px, py, pz);
					String name = qt.getNearestItem(p);
					if (!res.containsKey(name)) {
						res.put(name, new Duple<Integer, Color>(count, colourMap.get(name)));
						count++;
					}
				}
			}
		}
		return res;
	}

	// waste of time doing this by digital sums!
	private static int nextPerfectCube(int p) {
		int t = (int) Math.cbrt(p);
		int p1 = t * t * t;
		if (p1 == p)
			return p;
		else
			return nextPerfectCube(p + 1);
	}

	private static double sRGBtoLinear(double colorChannel) {
		// Send this function a decimal sRGB gamma encoded color value
		// between 0.0 and 1.0, and it returns a linearized value.

		if (colorChannel <= 0.04045) {
			return colorChannel / 12.92;
		} else {
			double t = ((colorChannel + 0.055) / 1.055);
			return Math.pow(t, 2.4);
		}
	}

	private static double luminance(Color c) {
		return (0.2126 * sRGBtoLinear(c.getRed()) + 0.7152 * sRGBtoLinear(c.getGreen())
				+ 0.0722 * sRGBtoLinear(c.getBlue()));
	}

	private static double YtoLstar(double lum) {
		// Send this function a luminance value between 0.0 and 1.0,
		// and it returns L* which is "perceptual lightness"
		/*
		 * L* is a value from 0 (black) to 100 (white) where 50 is the perceptual
		 * "middle grey". L* = 50 is the equivalent of Y = 18.4, or in other words an
		 * 18% grey card, representing the middle of a photographic exposure (Ansel
		 * Adams zone V).
		 */

		if (lum <= (216.0 / 24389.0)) { // The CIE standard states 0.008856 but 216/24389 is the intent for
										// 0.008856451679036
			return lum * (24389.0 / 27.0); // The CIE standard states 903.3, but 24389/27 is the intent, making
											// 903.296296296296296
		} else {
			return Math.pow(lum, (1.0 / 3.0)) * 116 - 16;
		}
	}
	
	private static Color adjustedColour(Color c) {
		return new Color(0.2126 * c.getRed(),0.7152 * c.getGreen() , 0.0722 * c.getBlue(),c.getBrightness());
	}

	public static void main(String[] args) {
		Color c = Color.GRAY;

		
		System.out.println("R: " + c.getRed() + ",\tLin: " + sRGBtoLinear(c.getRed()));
		System.out.println("G: " + c.getGreen() + ",\tLin: " + sRGBtoLinear(c.getGreen()));
		System.out.println("B: " + c.getBlue() + ",\tLin: " + sRGBtoLinear(c.getBlue()));
		double Y = luminance(c);
		System.out.println("Luminance: " + Y);
		System.out.println("Percived lightness: " + YtoLstar(Y));
		Color b = adjustedColour(c);
		System.out.println("Orig: "+c+" Adj: "+b);
//		for (int i = 1; i<100;i++) {
//			int nc= nextPerfectCube(i);
//			System.out.println("Next perfect cube root of "+i +" = " +nc);
//			//System.out.println("Digital sum of "+i +" = " +getDigitalRoot(i));
//		}
	}

}
