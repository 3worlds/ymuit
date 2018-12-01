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
 * @author Ian Davies
 * @date 28 Nov. 2018
 *
 */

public class Band {
	private double[] values;

	/**
	 * Array colour (RG or B) values (0.0..1.0) Ultimately, a colour for value x is
	 * made from three of these bands.
	 * 
	 * @param min : mim RGB value
	 * @param     max: max RBG values
	 * @param     flipx: flip result around the x axis
	 * @param     flipy: flip result around the y axis
	 * @param     ft: function to map x to y. 
	 */
	public Band(double min, double max, boolean flipx, boolean flipy, FunctionTypes ft) {
		values = new double[Function.length];

		for (int i = 0; i < Function.length; i++) {
			double x;
			if (flipx)
				x = ((Function.length - 1) - i) / (double) (Function.length - 1);
			else
				x = i / (double) (Function.length - 1);

			Function func = ft.getFunction();
			double y;
			if (flipy)
				y = 1.0 - func.getY(x);
			else
				y = func.getY(x);

			y = scale(y, min, max);

			values[i] = y;
		}
	}

	/**
	 * Scale y be within the range max - min
	 * 
	 * @param y
	 * @param min
	 * @param max
	 * @return
	 */
	private double scale(double y, double min, double max) {
		double r = max - min;
		if (r <= 0.0)
			return min;
		return r * y + min;
	}

	public double getValueAt(int idx) {
		return values[idx];
	}

}
