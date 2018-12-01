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
 * @date 28 Nov. 2018
 *
 */
// Pre-defined parameterised functions for generating palettes
public enum FunctionTypes {
//	GAUSSIAN/*-       */(new Gaussian()), //
	INTERSECT1A/*-    */(new Intersect(4, -1.0 / 3.0, 13.0 / 12.0)), //
	INTERSECT1B/*-    */(new Intersect(4, -2.0 / 3.0, 7.0 / 6.0)), //
	INTERSECT1C/*-    */(new Intersect(4, -1, 5.0 / 4.0)), //
	INTERSECT2A/*-    */(new Intersect(2, -1.0 / 2.0, 5.0 / 4.0)), //
	INTERSECT2B/*-    */(new Intersect(2, -1.0, 3.0 / 2.0)), //
	INTERSECT2C/*-    */(new Intersect(2, -3.0/2.0, 7.0 / 4.0)), //
	INTERSECT3A/*-    */(new Intersect(4.0/3.0, -1.0, 7.0 / 4.0)), //
	INTERSECT3B/*-    */(new Intersect(4.0/3.0, -2.0,5.0 / 2.0)), //
	INTERSECT3C/*-    */(new Intersect(4.0/3.0, -3.0,13.0 / 4.0)), //
    LINE1/*-          */(new Line(4)), //
	LINE2/*-          */(new Line(2)), //
	LINE3/*-          */(new Line(4.0/3.0)), //
	LINE4/*-          */(new Line(1)), //
//	LOG/*-            */(new Log()), //
//	LOGISTIC1A/*-     */(new Logistic(0.25, 1.0)), //
//	LOGISTIC2A/*-     */(new Logistic(0.5, 1.0)), //
//	LOGISTIC3A/*-     */(new Logistic(0.75, 1.0)), //
//	LOGISTIC1B/*-     */(new Logistic(0.25, 2.0)), //
//	LOGISTIC2B/*-     */(new Logistic(0.5, 2.0)), //
//	LOGISTIC3B/*-     */(new Logistic(0.75, 2.0)), //
//	POWER2/*-         */(new Power()), //
//	POWER4/*-         */(new Power(4)), //
//	POWER6/*-         */(new Power(6)), //
//	POWER8/*-         */(new Power(8)), //
//	POWER16/*-        */(new Power(16)), //	
//	SINC/*-           */(new Sinc()),
//	SINEWAVE11/*-     */(new SineWave(4.0 / 1.0, 1.0)), //
//	SINEWAVE21/*-     */(new SineWave(4.0 / 2.0, 1.0)), //
//	SINEWAVE31/*-     */(new SineWave(4.0 / 3.0, 1.0)), //
//	SINEWAVE41/*-     */(new SineWave(4.0 / 4.0, 1.0)), //
//	SINEWAVE12/*-     */(new SineWave(4.0 / 1.0, 2.0)), //
//	SINEWAVE22/*-     */(new SineWave(4.0 / 2.0, 2.0)), //
//	SINEWAVE32/*-     */(new SineWave(4.0 / 3.0, 2.0)), //
//	SINEWAVE42/*-     */(new SineWave(4.0 / 4.0, 2.0)), //
//	SQUAREWAVE2/*-    */(new SquareWave(4.0 / 1.0, 256.0 / 2.0)), //
//	SQUAREWAVE4/*-    */(new SquareWave(4.0 / 1.0, 256.0 / 4.0)), //
//	SQUAREWAVE8/*-    */(new SquareWave(4.0 / 1.0, 256.0 / 8.0)), //
//	SQUAREWAVE16/*-   */(new SquareWave(4.0 / 1.0, 256.0 / 16.0)), //
//	TRIANGLEWAVE11/*- */(new TriangleWave(4.0 / 1.0, 1.0)), //
//	TRIANGLEWAVE21/*- */(new TriangleWave(4.0 / 2.0, 1.0)), //
//	TRIANGLEWAVE31/*- */(new TriangleWave(4.0 / 3.0, 1.0)), //
//	TRIANGLEWAVE41/*- */(new TriangleWave(4.0 / 4.0, 1.0)), //
//	TRIANGLEWAVE12/*- */(new TriangleWave(4.0 / 1.0, 2.0)), //
//	TRIANGLEWAVE22/*- */(new TriangleWave(4.0 / 2.0, 2.0)), //
//	TRIANGLEWAVE32/*- */(new TriangleWave(4.0 / 3.0, 2.0)), //
//	TRIANGLEWAVE42/*- */(new TriangleWave(4.0 / 4.0, 2.0)), //
	;
	private final Function func;

	private FunctionTypes(Function func) {
		this.func = func;
	}

	public Function getFunction() {
		return func;
	}

}
