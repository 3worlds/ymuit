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
 * Two sides of a triangle implemented as to intersecting lines.
 * 
 * @author Ian Davies -1 Dec. 2018
 */
public class Intersect implements Function {
	double m1;
	double m2;
	double b2;

	/**
	 * Default constructor: slope1 = 2 slope 2 = -1
	 */
	public Intersect() {
		this(2, -1, 1.5);
	}

	/**
	 * 
	 * @param m1 Slope of first line (intersect = 0)
	 * @param m2 Slope of second line (opposite sign to first line)
	 * @param b2 Intersection of second line
	 */
	public Intersect(double m1, double m2, double b2) {
		this.m1 = m1;
		this.m2 = m2;
		this.b2 = b2;
	}

	/**
	 * The minimum of two intersecting lines
	 * 
	 * @param x 0.0 - 1.0
	 * @return f(x) 0.0 - 1.0
	 */
	@Override
	public double ofX(double x) {
		double y1 = m1 * x;
		double y2 = m2 * x + b2;
		double y = Math.min(y1, y2);
		return clamp(y);
	}

}
