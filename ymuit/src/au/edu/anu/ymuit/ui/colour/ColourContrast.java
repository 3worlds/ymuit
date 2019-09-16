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
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math.util.MathUtils;

import fr.cnrs.iees.uit.indexing.BoundedRegionIndexingTree;
import fr.cnrs.iees.uit.indexing.RegionIndexingTree;
import fr.cnrs.iees.uit.space.Box;
import fr.cnrs.iees.uit.space.Point;
import javafx.scene.paint.Color;

/**
 * Author Ian Davies
 *
 * Date 2 Dec. 2018
 */
/**
 * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
 * 
 * 1) Add all colours to an indexer that are a sufficient distance (3d space)
 * from the background.
 * 
 * 2) Divide the space into n voxels and select one colour nearest to the center
 * of each voxel.
 * 
 * 3) Add to list of contrasting colours
 */

public class ColourContrast {
	private static Map<Color, RegionIndexingTree<String>> colourQts = new HashMap<>();
	private static Map<String, Color> colourMap = new HashMap<>();
	private final static double distanceFromBackground = 0.4; // max is sqrt(3);

	public static double distanceFromBkg() {
		return distanceFromBackground;
	}

	/**
	 * Creates a map of colour names and colours that contrast with the given
	 * background colour up to a maximum of maxChoices. Use these colour names to
	 * set the css style sheet of the scene.node in question.
	 * 
	 * @param bkg
	 *            background colour
	 * @param maxChoices
	 *            maximum number of colours. The more colours requested, the less
	 *            contrast there will be between them.
	 * @return Map of colour names and colours.
	 */
	public static Map<String, Color> allContrastingColours(Color bkg, int maxChoices) {
		Map<String, Color> res = new HashMap<>();
		int dim = (int) Math.cbrt(maxChoices);
		double separation = 1.0 / (double) dim;
		RegionIndexingTree<String> qt = getKTree(bkg);
		int size = (int) (1.0 / separation);
		for (int x = 0; x < size; x++) {
			double px = x * separation + separation / 2.0;
			for (int y = 0; y < size; y++) {
				double py = y * separation + separation / 2.0;
				for (int z = 0; z < size; z++) {
					double pz = z * separation + separation / 2.0;
					Point p = Point.newPoint(px, py, pz);
					String name = qt.getNearestItem(p);
					if (!res.containsKey(name))
						res.put(name, colourMap.get(name));
				}
			}
		}
		return res;
	}

	/**
	 * Creates a list of named colours that contrast with the given background
	 * colour up to a maximum of maxChoices. Use these colour names to set the css
	 * style sheet of the scene.node in question.
	 * 
	 * @param bkg
	 *            background colour
	 * @param maxChoices
	 *            maximum number of colours. The more colours requested, the less
	 *            contrast there will be between them.
	 * @return Array of strings of contrasting colours.
	 */
	public static String[] allContrastingColourNames(Color bkg, int maxChoices) {
		Map<String, Color> colours = allContrastingColours(bkg, maxChoices);
		colours.keySet();
		String[] res = colours.keySet().toArray(new String[0]);
		return res;
	}

	private static RegionIndexingTree<String> getKTree(Color key) {
		if (colourQts.containsKey(key))
			return colourQts.get(key);
		else
			return createKTree(key);
	}

	private static RegionIndexingTree<String> createKTree(Color key) {
		Box limits = Box.boundingBox(Point.newPoint(0, 0, 0), Point.newPoint(1, 1, 1));
		RegionIndexingTree<String> q = new BoundedRegionIndexingTree<>(limits);
		q.setOptimisation(true);
		colourQts.put(key, q);
		try {
			if (colourMap.isEmpty())
				colourMap = getNamedColourMap();
			for (Map.Entry<String, Color> entry : colourMap.entrySet()) {
				Color c = entry.getValue();
				double d = colourDistance(key, c);
				// System.out.println("bkg:\t" + key + "\tcolour:\t" + c + "\tdistance:\t" + d);
				if ((d > distanceFromBackground) && (!entry.getKey().contains("TRANSPARENT"))) {
					Point p = Point.newPoint(c.getRed(), c.getGreen(), c.getBlue());
					q.insert(entry.getKey(), p);
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
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
		Class<?> clazz = Class.forName("javafx.scene.paint.Color",true,Thread.currentThread().getContextClassLoader());
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
	 * @param c1
	 *            first colour
	 * @param c2
	 *            second colour
	 * @return distance in RGB space between colours c1 and c2 
	 */
	public static double colourDistance(Color c1, Color c2) {
		double [] p1 = {c1.getRed(),c1.getGreen(),c1.getBlue()};
		double [] p2 = {c2.getRed(),c2.getGreen(),c2.getBlue()};
		return MathUtils.distance(p1,p2);
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
}
