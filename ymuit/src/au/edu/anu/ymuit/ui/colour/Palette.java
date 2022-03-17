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

import au.edu.anu.ymuit.ui.colour.functions.Function;
import javafx.scene.paint.Color;

/**
 * Author Ian Davies
 *
 * Date 2 Dec. 2018
 */
public class Palette {
	private Color[] palette;

	/**
	 * Creates a palette of 256 colours based on functions contained within each Band.
	 * 
	 * @param red red band
	 * @param green geen band
	 * @param blue blue band
	 * @param opacity (0.0 - 1.0)
	 */
	public Palette(Band red, Band green, Band blue, double opacity) {
		palette = new Color[Function.length];
		for (int i = 0; i < Function.length; i++)
			palette[i] = Color.color(red.getValueAt(i), green.getValueAt(i), blue.getValueAt(i), opacity);
	}

	/**
	 * Returns the palette colour for the value v. v is assumed to be within the range min to max
	 * @param v value 
	 * @param min minimum value of v
	 * @param max maximum value of v
	 * @return colour for value v
	 */
	public final Color getColour(double v, double min, double max) {
		int idx = getIndex(v, min, max);
		return palette[idx];
	}

	private int getIndex(double v, double min, double max) {
		v = Math.min(max, Math.max(v, min));
		double r = max - min;
		if (r <= 0)
			return 0;
		double p = (v-min) / r;
		double p1 = Math.round(p * (Function.length - 1));
		return (int) p1;
	}

}
