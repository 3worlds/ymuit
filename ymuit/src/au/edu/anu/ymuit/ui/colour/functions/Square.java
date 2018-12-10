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

package au.edu.anu.ymuit.ui.colour.functions;

/**
 * Author Ian Davies
 *
 * Date 2 Dec. 2018
 */
// Square wave - useful for adding strips to a colour gradiant
public class Square extends Sine {
	/**
	 * Square wave function with starting at 0 with one cycle over domain 0..255
	 */
	public Square() {
		this(4.0 / 3.0, 1.0);
	}

	/**
	 * Square wave function
	 * 
	 * @param offsetPar phase = 2PI/offset
	 * @param nCycles   frequency = 2PI * nCycles
	 */

	public Square(double offsetPar, double nCycles) {
		super(offsetPar, nCycles);
	}

	/**
	 * Square wave function
	 * 
	 * @param x 0.0 - 1.0
	 * @return f(x) 0.0 | 1.0
	 */
	@Override
	public double ofX(double x) {
		double s = Math.sin(x * frequency + phase);
		double y = 1;
		if (s < 0.0)
			y = -1;
		return clamp(y);
	}

}
