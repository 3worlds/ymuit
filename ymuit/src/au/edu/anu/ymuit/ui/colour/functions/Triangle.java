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
 * Author Ian Davies - 2 Dec. 2018
 */
// Triangle wave 
public class Triangle extends Sine {
	private static double twoOnPi = 2 / Math.PI;

	/**
	 * Triangle wave function with offset 4/3 and 1 cycle over domain 0..255
	 */
	public Triangle() {
		this(4.0 / 3.0, 1.0);
	}

	/**
	 * Triangle wave function
	 * 
	 * @param offsetPar phase = 2PI/offset
	 * @param nCycles   frequency = 2PI * nCycles
	 */
	public Triangle(double offsetPar, double nCycles) {
		super(offsetPar, nCycles);
	}

	/**
	 * Triangle wave function // https://en.wikipedia.org/wiki/Triangle_wave
	 * 
	 * @param x 0.0 - 1.0
	 * @return f(x) 0.0 - 1.0
	 */
	@Override
	public double ofX(double x) {
		// https://en.wikipedia.org/wiki/Triangle_wave
		double y = (twoOnPi * Math.asin(Math.sin(frequency * x + phase)) + 1.0) / 2.0;
		return clamp(y);

	}
}
