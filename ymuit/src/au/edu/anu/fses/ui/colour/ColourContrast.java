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

	/**
	 * https://stackoverflow.com/questions/17464906/how-to-list-all-colors-in-javafx
	 * 
	 * Finds all named colours in javaFx through reflection
	 * 
	 * @return: map (Name, Color) of all named colours in the
	 *          javafx.scene.paint.Color
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

	private static double distance(double... x) {
		assert (x.length % 2 == 0);
		double sum = 0;
		for (int c = 1; c < x.length; c += 2) {
			double x1 = x[c - 1];
			double x2 = x[c];
			double dx = x2 - x1;
			sum += dx * dx;
		}
		if (sum > 0)
			return Math.sqrt(sum);
		return 0;
	}

	private static double colourDistance(Color c1, Color c2) {
		return distance(c1.getRed(), c2.getRed(), c1.getGreen(), c2.getGreen(), c1.getBlue(), c2.getBlue());
	}

}
