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

package au.edu.anu.ymuit.ui.colour.functions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import au.edu.anu.ymuit.ui.colour.functions.Function;
import au.edu.anu.ymuit.ui.colour.functions.Intersect;

class TestIntersect {

	@Test
	@DisplayName("Intersect() - default constructor")
	void testIntersect() {
		Function f = new Intersect();
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.25), 0.5);
		assertEquals(f.ofX(0.5), 1.0);
		assertEquals(f.ofX(0.75), 0.75);
		assertEquals(f.ofX(1.0), 0.5);
	}

	@Test
	@DisplayName("Intersect - parameterised")
	void testIntersetParameterised() {
		Function f = new Intersect(4, -1.0 / 3.0, 13.0 / 12.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.8);
		assertEquals(f.ofX(0.4), 0.95);
		assertEquals(f.ofX(1.0), 0.75);

		f = new Intersect(4, -2.0 / 3.0, 7.0 / 6.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.8);
		assertEquals(f.ofX(0.4), 0.9000000000000001);
		assertEquals(f.ofX(0.6), 0.7666666666666668);
		assertEquals(f.ofX(0.8), 0.6333333333333334);
		assertEquals(f.ofX(1.0), 0.5000000000000001);

		f = new Intersect(4, -1, 5.0 / 4.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.8);
		assertEquals(f.ofX(0.4), 0.85);
		assertEquals(f.ofX(0.6), 0.65);
		assertEquals(f.ofX(1.0), 0.25);

		f = new Intersect(2, -1.0 / 2.0, 5.0 / 4.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.4);
		assertEquals(f.ofX(0.4), 0.8);
		assertEquals(f.ofX(0.6), 0.95);
		assertEquals(f.ofX(0.8), 0.85);
		assertEquals(f.ofX(1.0), 0.75);

		f = new Intersect(2, -1.0, 3.0 / 2.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.4);
		assertEquals(f.ofX(0.4), 0.8);
		assertEquals(f.ofX(0.6), 0.9);
		assertEquals(f.ofX(0.8), 0.7);
		assertEquals(f.ofX(1.0), 0.5);

		f = new Intersect(2, -3.0 / 2.0, 7.0 / 4.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.4);
		assertEquals(f.ofX(0.4), 0.8);
		assertEquals(f.ofX(0.5333333333333333), 0.95);
		assertEquals(f.ofX(0.8), 0.5499999999999998);
		assertEquals(f.ofX(1.0), 0.25);
		
		f = new Intersect(4.0/3.0, -1.0, 7.0 / 4.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.26666666666666666);
		assertEquals(f.ofX(0.4), 0.5333333333333333);
		assertEquals(f.ofX(0.6), 0.7999999999999999);
		assertEquals(f.ofX(0.8), 0.95);
		assertEquals(f.ofX(1.0), 0.75);		
		
		f = new Intersect(4.0/3.0, -2.0,5.0 / 2.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.26666666666666666);
		assertEquals(f.ofX(0.4), 0.5333333333333333);
		assertEquals(f.ofX(0.6), 0.7999999999999999);
		assertEquals(f.ofX(0.8), 0.8999999999999999);
		assertEquals(f.ofX(1.0), 0.5);
	
		f = new Intersect(4.0/3.0, -3.0,13.0 / 4.0);
		assertEquals(f.ofX(0.0), 0.0);
		assertEquals(f.ofX(0.2), 0.26666666666666666);
		assertEquals(f.ofX(0.4), 0.5333333333333333);
		assertEquals(f.ofX(0.6), 0.7999999999999999);
		assertEquals(f.ofX(0.8), 0.8499999999999996);
		assertEquals(f.ofX(1.0), 0.25);
	}

}
