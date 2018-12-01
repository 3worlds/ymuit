package au.edu.anu.fses.ui.colour.functions;
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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import au.edu.anu.fses.ui.colour.functions.Function;

class LineTest {

	@Test
	@DisplayName("Line() with default slope (1.0)")
	void testLine() {
		Line l = new Line();
		assertEquals(l.getY(0.0),0.0);
		assertEquals(l.getY(0.25),0.25);
		assertEquals(l.getY(0.5),0.5);
		assertEquals(l.getY(0.75),0.75);
		assertEquals(l.getY(1.0),1.0);
	}

	@Test
	@DisplayName("Line(m) with slope 2 and 0.5")
	void testLineDouble() {
		Line l = new Line(2);
		assertEquals(l.getY(0.0),0.0);
		assertEquals(l.getY(0.25),0.5);
		assertEquals(l.getY(0.5),1.0);
		assertEquals(l.getY(0.75),1.0);
		assertEquals(l.getY(1.0),1.0);
		
		l = new Line(0.5);
		assertEquals(l.getY(0.0),0.0);
		assertEquals(l.getY(0.25),0.125);
		assertEquals(l.getY(0.5),0.25);
		assertEquals(l.getY(0.75),0.375);
		assertEquals(l.getY(1.0),0.5);
	}

	@Test
	@DisplayName("Line getY all values with default slope (1.0)")
	void testGetY() {
		Line l = new Line();
		for (int i = 0 ; i<Function.length;i++) {
			double x = (double)i/(double)(Function.length-1);
			assertEquals(l.getY(x),x);
			assertTrue(l.getY(x)>=0.0);
			assertTrue(l.getY(x)<=1.0);		
		}
	}


}
