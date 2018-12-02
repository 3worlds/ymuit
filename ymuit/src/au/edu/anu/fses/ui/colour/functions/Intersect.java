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
 * @author Ian Davies
 *
 * @Date 1 Dec. 2018
 */
//The minimum of two intersecting lines
public class Intersect implements Function {
	double m1;
	double m2;
	double b2;

	// Default is a triangle
	public Intersect() {
		this(2, -1, 1.5);
	}

	public Intersect(double m1, double m2, double b2) {
		this.m1 = m1;
		this.m2 = m2;
		this.b2 = b2;
	}

	@Override
	public double ofX(double x) {
		double y1 = m1 * x;
		double y2 = m2 * x + b2;
		double y = Math.min(y1, y2);
		return clamp(y);
	}

}
