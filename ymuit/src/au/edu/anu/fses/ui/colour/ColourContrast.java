/**************************************************************************
 *  YMUIT - Yet More User-Interface Tools                                       *
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
 *  UIT is free software: you can redistribute it and/or modify           *
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
 *  along with UIT.  If not, see <https://www.gnu.org/licenses/gpl.html>. *
 *                                                                        *
 **************************************************************************/

package au.edu.anu.fses.ui.colour;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import fr.cnrs.iees.uit.indexing.BoundedRegionIndexingTree;
import fr.cnrs.iees.uit.indexing.RegionIndexingTree;
import fr.cnrs.iees.uit.space.Box;
import fr.cnrs.iees.uit.space.Point;
import javafx.scene.paint.Color;

/**
 * @author Ian Davies
 *
 * @Date 2 Dec. 2018
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
	 * Creates a list of named colours that contrast with the given background
	 * colour up to a maximum of maxChoices. Use these colour names to set the css
	 * style sheet of the scene.node in question.
	 * 
	 * @param bkg
	 * @param maxChoices
	 * @return Array of strings of contrasting colours.
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
//				System.out.println("bkg:\t" + key + "\tcolour:\t" + c + "\tdistance:\t" + d);
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
		Class<?> clazz = Class.forName("javafx.scene.paint.Color");
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
	 * @param x: array of pairs: 1 pair = 1 dim, 2 pairs = 2 dim etc...
	 * @return distance between two points in n Dim space.
	 */
	private static double distance(double... x) {
		assert (x.length % 2 == 0);
		double sum = 0;
		for (int c = 1; c < x.length; c += 2) {
			double x1 = x[c - 1];
			double x2 = x[c];
			double dx = x2 - x1;
			sum += (dx * dx);
		}
		if (sum > 0)
			return Math.sqrt(sum);
		return 0;
	}

	/**
	 * Distance between colours in RGB 3D space.
	 * 
	 * @param c1
	 * @param c2
	 * @return distance in RGB space between colours c1 and c2
	 */
	public static double colourDistance(Color c1, Color c2) {
		return distance(c1.getRed(), c2.getRed(), c1.getGreen(), c2.getGreen(), c1.getBlue(), c2.getBlue());
	}

}
