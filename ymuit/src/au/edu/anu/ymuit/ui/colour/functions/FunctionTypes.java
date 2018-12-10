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
 * Date 28 Nov. 2018
 */

/**
 * 
 * Pre-defined parameterised functions for generating palettes.
 * Naming convention function<first par><second par>
 * 
 */
public enum FunctionTypes {
	GAUSSIAN/*-       */(new Gaussian()), //
	INTERSECT1A/*-    */(new Intersect(4, -1.0 / 3.0, 13.0 / 12.0)), //
	INTERSECT1B/*-    */(new Intersect(4, -2.0 / 3.0, 7.0 / 6.0)), //
	INTERSECT1C/*-    */(new Intersect(4, -1, 5.0 / 4.0)), //
	INTERSECT2A/*-    */(new Intersect(2, -1.0 / 2.0, 5.0 / 4.0)), //
	INTERSECT2B/*-    */(new Intersect(2, -1.0, 3.0 / 2.0)), //
	INTERSECT2C/*-    */(new Intersect(2, -3.0 / 2.0, 7.0 / 4.0)), //
	INTERSECT3A/*-    */(new Intersect(4.0 / 3.0, -1.0, 7.0 / 4.0)), //
	INTERSECT3B/*-    */(new Intersect(4.0 / 3.0, -2.0, 5.0 / 2.0)), //
	INTERSECT3C/*-    */(new Intersect(4.0 / 3.0, -3.0, 13.0 / 4.0)), //
	LINE1/*-          */(new Line(4, 0)), //
	LINE2/*-          */(new Line(2, 0)), //
	LINE3/*-          */(new Line(4.0 / 3.0, 0)), //
	LINE4/*-          */(new Line(1, 0)), //
	LOGISTIC1A/*-     */(new Logistic(0.25, 1.0)), //
	LOGISTIC2A/*-     */(new Logistic(0.5, 1.0)), //
	LOGISTIC3A/*-     */(new Logistic(0.75, 1.0)), //
	LOGISTIC1B/*-     */(new Logistic(0.25, 2.0)), //
	LOGISTIC2B/*-     */(new Logistic(0.5, 2.0)), //
	LOGISTIC3B/*-     */(new Logistic(0.75, 2.0)), //
	POWER2/*-         */(new Power()), //
	POWER4/*-         */(new Power(4)), //
	POWER6/*-         */(new Power(6)), //
	POWER8/*-         */(new Power(8)), //
	POWER16/*-        */(new Power(16)), //
	BESSEL1/*-        */(new Bessel(7.0/3.0)), // 2
	BESSEL2/*-        */(new Bessel(7.0/1.6)), // 3
	BESSEL3/*-        */(new Bessel(7.0/1.08)), // 4
	BESSEL4/*-        */(new Bessel(7.0/0.82)), // 5
	SINE11/*-         */(new Sine(4.0 / 1.0, 1.0)), //
	SINE21/*-         */(new Sine(4.0 / 2.0, 1.0)), //
	SINE31/*-         */(new Sine(4.0 / 3.0, 1.0)), //
	SINE41/*-         */(new Sine(4.0 / 4.0, 1.0)), //
	SINE12/*-         */(new Sine(4.0 / 1.0, 2.0)), //
	SINE22/*-         */(new Sine(4.0 / 2.0, 2.0)), //
	SINE32/*-         */(new Sine(4.0 / 3.0, 2.0)), //
	SINE42/*-         */(new Sine(4.0 / 4.0, 2.0)), //
	SQUARE2/*-        */(new Square(4.0 / 1.0, 256.0 / 2.0)), //
	SQUARE4/*-        */(new Square(4.0 / 1.0, 256.0 / 4.0)), //
	SQUARE8/*-        */(new Square(4.0 / 1.0, 256.0 / 8.0)), //
	SQUARE16/*-       */(new Square(4.0 / 1.0, 256.0 / 16.0)), //
	TRIANGLE11/*-     */(new Triangle(4.0 / 1.0, 1.0)), //
	TRIANGLE21/*-     */(new Triangle(4.0 / 2.0, 1.0)), //
	TRIANGLE31/*-     */(new Triangle(4.0 / 3.0, 1.0)), //
	TRIANGLE41/*-     */(new Triangle(4.0 / 4.0, 1.0)), //
	TRIANGLE12/*-     */(new Triangle(4.0 / 1.0, 2.0)), //
	TRIANGLE22/*-     */(new Triangle(4.0 / 2.0, 2.0)), //
	TRIANGL32/*-      */(new Triangle(4.0 / 3.0, 2.0)), //
	TRIANGL42/*-      */(new Triangle(4.0 / 4.0, 2.0)), //
	;
	private final Function func;

	private FunctionTypes(Function func) {
		this.func = func;
	}

	public Function getFunction() {
		return func;
	}

}
