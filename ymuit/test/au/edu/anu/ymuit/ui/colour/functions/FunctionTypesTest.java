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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FunctionTypesTest {
	private static double round2(double d) {
		double result = Math.round(d * 100.0) / 100.0;
		return result;
	}

	@Test
	void test() {
		Function f;
		f = FunctionTypes.GAUSSIAN.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.01);
		assertTrue(round2(f.ofX(0.25)) == 0.32);
		assertTrue(round2(f.ofX(0.50)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.01);
		assertTrue(round2(f.ofX(0.75)) == 0.32);

		f = FunctionTypes.INTERSECT1A.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.75);

		f = FunctionTypes.INTERSECT1B.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.INTERSECT1C.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.25);

		f = FunctionTypes.INTERSECT2A.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.75);

		f = FunctionTypes.INTERSECT2B.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.INTERSECT2C.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.25);

		f = FunctionTypes.INTERSECT3A.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.75)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.75);

		f = FunctionTypes.INTERSECT3B.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.75)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.INTERSECT3C.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.75)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.25);

		f = FunctionTypes.LINE1.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.LINE2.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.LINE3.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.75)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.LINE4.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 0.5);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.LOGISTIC1A.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.04);
		assertTrue(round2(f.ofX(0.25)) == 0.44);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.POWER2.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 0.25);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.POWER4.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 0.06);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.POWER6.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 0.02);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.POWER8.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.8)) == 0.17);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.POWER16.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.8)) == 0.03);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.BESSEL1.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.61)) == 0.0);
		assertTrue(round2(f.ofX(1.0)) == 0.28);

		f = FunctionTypes.BESSEL2.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.32)) == 0.0);
		assertTrue(round2(f.ofX(0.79)) == 0.1);
		assertTrue(round2(f.ofX(1.0)) == 0.23);

		f = FunctionTypes.BESSEL3.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 0.12);
		assertTrue(round2(f.ofX(1.0)) == 0.22);

		f = FunctionTypes.BESSEL4.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 0.22);
		assertTrue(round2(f.ofX(1.0)) == 0.21);

		f = FunctionTypes.SINE11.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 0.0);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.SINE21.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.5)) == 0.5);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.SINE31.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.0);

		f = FunctionTypes.SINE41.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 0.5);
		assertTrue(round2(f.ofX(0.75)) == 0.0);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.SINE12.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.25)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(0.75)) == 0.0);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.SINE22.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.25)) == 0.5);
		assertTrue(round2(f.ofX(0.5)) == 0.5);
		assertTrue(round2(f.ofX(0.75)) == 0.5);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.SINE32.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 0.0);
		assertTrue(round2(f.ofX(0.75)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.0);

		f = FunctionTypes.SINE42.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.25)) == 0.5);
		assertTrue(round2(f.ofX(0.5)) == 0.5);
		assertTrue(round2(f.ofX(0.75)) == 0.5);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.SQUARE2.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.1)) == 1.0);
		assertTrue(round2(f.ofX(0.2)) == 0.0);
		assertTrue(round2(f.ofX(0.3)) == 0.0);
		assertTrue(round2(f.ofX(0.4)) == 1.0);

		f = FunctionTypes.SQUARE4.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.1)) == 0.0);
		assertTrue(round2(f.ofX(0.2)) == 1.0);
		assertTrue(round2(f.ofX(0.3)) == 1.0);
		assertTrue(round2(f.ofX(0.4)) == 0.0);

		f = FunctionTypes.SQUARE8.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.1)) == 1.0);
		assertTrue(round2(f.ofX(0.2)) == 0.0);
		assertTrue(round2(f.ofX(0.3)) == 0.0);
		assertTrue(round2(f.ofX(0.4)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(0.6)) == 1.0);
		assertTrue(round2(f.ofX(0.7)) == 0.0);
		assertTrue(round2(f.ofX(0.8)) == 0.0);
		assertTrue(round2(f.ofX(0.9)) == 1.0);

		f = FunctionTypes.SQUARE16.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.1)) == 0.0);
		assertTrue(round2(f.ofX(0.2)) == 1.0);
		assertTrue(round2(f.ofX(0.3)) == 1.0);
		assertTrue(round2(f.ofX(0.4)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(0.6)) == 0.0);
		assertTrue(round2(f.ofX(0.7)) == 1.0);
		assertTrue(round2(f.ofX(0.8)) == 1.0);
		assertTrue(round2(f.ofX(0.9)) == 0.0);

		f = FunctionTypes.TRIANGLE11.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.25)) == 0.5);
		assertTrue(round2(f.ofX(0.5)) == 0.0);
		assertTrue(round2(f.ofX(0.75)) == 0.5);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.TRIANGLE21.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.25)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 0.5);
		assertTrue(round2(f.ofX(0.75)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.TRIANGLE31.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.25)) == 0.5);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(0.75)) == 0.5);
		assertTrue(round2(f.ofX(1.0)) == 0.0);

		f = FunctionTypes.TRIANGLE41.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 0.5);
		assertTrue(round2(f.ofX(0.75)) == 0.0);
		assertTrue(round2(f.ofX(1.0)) == 0.5);

		f = FunctionTypes.TRIANGLE12.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 1.0);
		assertTrue(round2(f.ofX(0.25)) == 0.0);
		assertTrue(round2(f.ofX(0.5)) == 1.0);
		assertTrue(round2(f.ofX(0.75)) == 0.0);
		assertTrue(round2(f.ofX(1.0)) == 1.0);

		f = FunctionTypes.TRIANGLE22.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.2)) == 0.3);
		assertTrue(round2(f.ofX(0.4)) == 0.9);
		assertTrue(round2(f.ofX(0.6)) == 0.1);
		assertTrue(round2(f.ofX(0.8)) == 0.7);

		f = FunctionTypes.TRIANGLE32.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.0);
		assertTrue(round2(f.ofX(0.25)) == 1.0);
		assertTrue(round2(f.ofX(0.5)) == 0.0);
		assertTrue(round2(f.ofX(0.75)) == 1.0);
		assertTrue(round2(f.ofX(1.0)) == 0.0);

		f = FunctionTypes.TRIANGLE42.getFunction();
		assertTrue(round2(f.ofX(0.0)) == 0.5);
		assertTrue(round2(f.ofX(0.2)) == 0.7);
		assertTrue(round2(f.ofX(0.4)) == 0.1);
		assertTrue(round2(f.ofX(0.6)) == 0.9);
		assertTrue(round2(f.ofX(0.8)) == 0.3);
		
		
		f = FunctionTypes.INTERSECT2B.getFunction();
//		System.out.println(round2(f.ofX(0.0)));
//		System.out.println(round2(f.ofX(0.2)));
//		System.out.println(round2(f.ofX(0.4)));
//		System.out.println(round2(f.ofX(0.6)));
//		System.out.println(round2(f.ofX(0.8)));
		

//		for (int i = 0; i < Function.length; i++) {
//			double x = i / (double) Function.length;
//			System.out.println(x + "\t" + f.ofX(x));
//		}

	}

}
