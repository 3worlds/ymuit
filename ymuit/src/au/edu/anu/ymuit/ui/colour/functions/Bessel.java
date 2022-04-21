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
 * Date Dec 5, 2018
 */
public class Bessel implements Function {
	private static final double minimum = -0.2172268187;
	private static final double range = 1.2171760499;
	private double domain;

	/**
	 * Default constructor
	 */
	public Bessel() {
		this(7.0 / 3.0);
	}

	/**
	 * @param p the number of waves
	 */
	public Bessel(double p) {
		domain = Math.PI * p;
	}

	/**
	 * A Bessel like wave function with variable number of waves
	 * 
	 * @param x
	 *            domain 0.0..1.0
	 * 
	 */
	@Override
	public double ofX(double x) {
		if (x <= 0.0)
			return 1.0;
		double x1 = domain * x;
		double s = Math.sin(x1) / x1;
		double result = (s - minimum) / range;
		return clamp(result);
	}

}
