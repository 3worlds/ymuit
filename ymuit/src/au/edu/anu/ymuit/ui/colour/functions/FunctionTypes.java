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
 * Pre-defined parameterised functions for generating palettes. A different
 * function (or customized function) can be used for each colour channel.
 */
//Naming convention is function+integer+alpha to categorise first and second parameters
public enum FunctionTypes {
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/gaussian.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 */
	GAUSSIAN/*-       */(new Gaussian()), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect1a.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT1A/*-    */(new Intersect(4, -1.0 / 3.0, 13.0 / 12.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect1b.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT1B/*-    */(new Intersect(4, -2.0 / 3.0, 7.0 / 6.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect1c.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT1C/*-    */(new Intersect(4, -1, 5.0 / 4.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect2a.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT2A/*-    */(new Intersect(2, -1.0 / 2.0, 5.0 / 4.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect2b.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT2B/*-    */(new Intersect(2, -1.0, 3.0 / 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect2c.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT2C/*-    */(new Intersect(2, -3.0 / 2.0, 7.0 / 4.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect3a.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT3A/*-    */(new Intersect(4.0 / 3.0, -1.0, 7.0 / 4.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect3b.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT3B/*-    */(new Intersect(4.0 / 3.0, -2.0, 5.0 / 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/intersect3c.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	INTERSECT3C/*-    */(new Intersect(4.0 / 3.0, -3.0, 13.0 / 4.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/line1.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LINE1/*-          */(new Line(4, 0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/line2.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LINE2/*-          */(new Line(2, 0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/line3.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LINE3/*-          */(new Line(4.0 / 3.0, 0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/line4.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LINE4/*-          */(new Line(1, 0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/logistic1a.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LOGISTIC1A/*-     */(new Logistic(0.25, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/logistic2a.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LOGISTIC2A/*-     */(new Logistic(0.5, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/logistic3a.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LOGISTIC3A/*-     */(new Logistic(0.75, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/logistic1b.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LOGISTIC1B/*-     */(new Logistic(0.25, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/logistic2b.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LOGISTIC2B/*-     */(new Logistic(0.5, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/logistic3b.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	LOGISTIC3B/*-     */(new Logistic(0.75, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/power2.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	POWER2/*-         */(new Power()), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/power4.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	POWER4/*-         */(new Power(4)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/power6.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	POWER6/*-         */(new Power(6)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/power8.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	POWER8/*-         */(new Power(8)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/power16.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	POWER16/*-        */(new Power(16)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/bessel1.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	BESSEL1/*-        */(new Bessel(7.0 / 3.0)), // 2
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/bessel2.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	BESSEL2/*-        */(new Bessel(7.0 / 1.6)), // 3
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/bessel3.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	BESSEL3/*-        */(new Bessel(7.0 / 1.08)), // 4
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/bessel4.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	BESSEL4/*-        */(new Bessel(7.0 / 0.82)), // 5
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine11.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE11/*-         */(new Sine(4.0 / 1.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine21.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE21/*-         */(new Sine(4.0 / 2.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine31.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE31/*-         */(new Sine(4.0 / 3.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine41.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE41/*-         */(new Sine(4.0 / 4.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine12.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE12/*-         */(new Sine(4.0 / 1.0, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine22.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE22/*-         */(new Sine(4.0 / 2.0, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine32.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE32/*-         */(new Sine(4.0 / 3.0, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/sine42.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SINE42/*-         */(new Sine(4.0 / 4.0, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/square2.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SQUARE2/*-        */(new Square(4.0 / 1.0, 256.0 / 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/square4.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SQUARE4/*-        */(new Square(4.0 / 1.0, 256.0 / 4.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/square8.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SQUARE8/*-        */(new Square(4.0 / 1.0, 256.0 / 8.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/square16.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	SQUARE16/*-       */(new Square(4.0 / 1.0, 256.0 / 16.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle11.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE11/*-     */(new Triangle(4.0 / 1.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle21.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE21/*-     */(new Triangle(4.0 / 2.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle31.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE31/*-     */(new Triangle(4.0 / 3.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle41.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE41/*-     */(new Triangle(4.0 / 4.0, 1.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle12.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE12/*-     */(new Triangle(4.0 / 1.0, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle22.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE22/*-     */(new Triangle(4.0 / 2.0, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle32.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE32/*-      */(new Triangle(4.0 / 3.0, 2.0)), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/triangle42.png" width="200" alt="Colour
	 * palette system"/>
	 * 
	 */
	TRIANGLE42/*-      */(new Triangle(4.0 / 4.0, 2.0)), //
	;

	private final Function func;

	private FunctionTypes(Function func) {
		this.func = func;
	}

	/**
	 * The parameterized function associated with this enum value
	 * 
	 * @return function instance
	 */
	public Function getFunction() {
		return func;
	}

}
