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

package au.edu.anu.ymuit.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DecimalsTest {

	@Test
	void test() {
		double d = 100 + 1.0 / 3.0;
		assertEquals(Decimals.getDecimalFormat(-1).format(d), "100");
		assertEquals(Decimals.getDecimalFormat(0).format(d), "100");
		assertEquals(Decimals.getDecimalFormat(1).format(d), "100.3");
		assertEquals(Decimals.getDecimalFormat(4).format(d), "100.3333");
		assertEquals(Decimals.getDecimalFormat(10).format(d), "100.3333333333");
	}

}
