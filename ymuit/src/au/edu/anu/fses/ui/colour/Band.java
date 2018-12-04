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

import au.edu.anu.fses.ui.colour.functions.Function;
import au.edu.anu.fses.ui.colour.functions.FunctionTypes;

/**
 * Author Ian Davies
 * 
 * Date 28 Nov. 2018
 *
 */

public class Band {
	
	private double[] values;

	/**
	 * A Band is an array of colour (RG or B) values. Three of these bands are used
	 * by a Palette to create a colour. A function supplies the band range values
	 * over a domain of 0.0 to 1.0. The function can be compressed between two
	 * values (min,max) and flipped around either or both the x and y axis.
	 * 
	 * @param min   minimum RGB value
	 * @param max   maximum RBG values
	 * @param flipx flip result around the x axis
	 * @param flipy flip result around the y axis
	 * @param ft    The function used to map x to y.
	 */
	public Band(double min, double max, boolean flipx, boolean flipy, FunctionTypes ft) {
		values = new double[Function.length];

		for (int i = 0; i < Function.length; i++) {
			double x = i / (double) (Function.length - 1);
			if (flipx)
				x = 1.0 - x;
			double y = ft.getFunction().ofX(x);
			if (flipy)
				y = 1.0 - y;
			y = scale(y, min, max);
			values[i] = y;
		}
	}

	/**
	 * Scales y to be within the range max - min assuming y is within 0.0 - 1.0
	 * 
	 * @param y
	 * @param min
	 * @param max
	 * @return
	 */
	private double scale(double y, double min, double max) {
		assert (max >= min);
		double r = max - min;
		if (r <= 0.0)
			return min;
		return r * y + min;
	}

	/**
	 * Returns the value of a colour band in the range 0.0 - 1.0 at the given index
	 * 
	 * @param idx (0..255)
	 * @return band value (0.0..1.0) at index idx
	 */
	public double getValueAt(int idx) {
		return values[idx];
	}

}
