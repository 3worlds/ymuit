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
 * Power function with radical.
 * 
 * @author Ian Davies - 2 Dec. 2018
 */
public class Power implements Function {
	double radical;

	/**
	 * Power function with radical 2
	 */
	public Power() {
		this(2);
	}

	/**
	 * Power function with radical r
	 * 
	 * @param r power radical
	 */
	public Power(double r) {
		radical = r;
	}

	/**
	 * power function
	 * 
	 * @param x 0.0 - 1.0
	 * @return x^radical
	 */
	@Override
	public double ofX(double x) {
		double result = Math.pow(x, radical);
		return clamp(result);
	}

}
