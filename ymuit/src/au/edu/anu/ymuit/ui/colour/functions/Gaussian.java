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
 * Bell curve
 * 
 * @author Ian Davies 2 Dec 2018
 */
public class Gaussian implements Function {
	private static double d = Math.sqrt(2 * Math.PI);
	private static double m = 1.0 / 0.4;

	/**
	 * bell curve symmetrical about x = 0.5
	 * 
	 * @param x 0.0..1.0
	 * @return f(x) 0.0..1.0
	 */
	@Override
	public final double ofX(double x) {
		x = (x - 0.5) * 6;
		double r = Math.exp(-x * x / 2.0) / d;
		return clamp(r * m);
	}

}
