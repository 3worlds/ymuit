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

package au.edu.anu.ymuit.ui.colour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import au.edu.anu.ymuit.ui.colour.functions.FunctionTypes;

/**
 * Author Ian Davies
 *
 * Date 2 Dec. 2018
 */
class BandTest {

	@Test
	void test() {
		Band b = new Band(0.0, 1.0, false, false, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 0.0);
		assertEquals(b.getValueAt(153), 0.36);
		assertEquals(b.getValueAt(255), 1.0);

		b = new Band(0.0, 1.0, true, false, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 1.0);
		assertEquals(b.getValueAt(102), 0.36);
		assertEquals(b.getValueAt(255), 0.0);

		b = new Band(0.0, 1.0, false, true, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 1.0);
		assertEquals(b.getValueAt(51), 0.96);
		assertEquals(b.getValueAt(102), 0.84);
		assertEquals(b.getValueAt(153), 0.64);
		assertEquals(b.getValueAt(255), 0.0);

		b = new Band(0.0, 1.0, true, true, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 0.0);
		assertEquals(b.getValueAt(102), 0.64);
		assertEquals(b.getValueAt(153), 0.84);
		assertEquals(b.getValueAt(204), 0.96);
		assertEquals(b.getValueAt(255), 1.0);

		b = new Band(0.25, 0.75, false, false, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 0.25);
		assertEquals(b.getValueAt(51), 0.27);
		assertEquals(b.getValueAt(102), 0.33);
		assertEquals(b.getValueAt(153), 0.43);
		assertEquals(b.getValueAt(255), 0.75);

		b = new Band(0.25, 0.75, true, false, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 0.75);
		assertEquals(b.getValueAt(102), 0.43);
		assertEquals(b.getValueAt(153), 0.33);
		assertEquals(b.getValueAt(204), 0.27);
		assertEquals(b.getValueAt(255), 0.25);

		b = new Band(0.25, 0.75, false, true, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 0.75);
		assertEquals(b.getValueAt(51), 0.73);
		assertEquals(b.getValueAt(255), 0.25);

		b = new Band(0.25, 0.75, true, true, FunctionTypes.POWER2);
		assertEquals(b.getValueAt(0), 0.25);
		assertEquals(b.getValueAt(204), 0.73);
		assertEquals(b.getValueAt(255), 0.75);
	}

}
