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

package au.edu.anu.fses.ui.colour.functions;

/**
 * Author Ian Davies
 *
 * Date 2 Dec. 2018
 */
public class Logistic implements Function {
	private double x0;// inflexion point
	private double k;// gradient
	private static double l = 1;// amplitude

	/**
	 * Logistic curve with inflexion point of 0.5 and gradient of 1.0
	 */
	public Logistic() {
		this(0.5, 1.0);
	}

	/**
	 * Logistic curve
	 * 
	 * @param x0 inflexion point
	 * @param k  gradient
	 */

	public Logistic(double x0, double k) {
		this.x0 = x0;
		this.k = k;
	}

	/**
	 * logistic function
	 * 
	 * @param x 0.0 - 1.0
	 * @return f(x) 0.0 - 1.0
	 */
	@Override
	public double ofX(double x) {
		x = (x - x0) * 12;
		double n = 1 + Math.exp(-k * (x - x0));
		double r = l / n;
		return clamp(r);
	}
}
