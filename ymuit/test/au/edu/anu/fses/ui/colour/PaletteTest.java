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

package au.edu.anu.fses.ui.colour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

/**
 * @author Ian Davies
 *
 * @Date 2 Dec. 2018
 */
class PaletteTest {

	@Test
	void test() {
		Palette p = PaletteFactory.blackWhite();
		assertEquals(p.getColour(0, 0,1),Color.BLACK);
		assertEquals(p.getColour(1, 0,1),Color.WHITE);
		assertEquals(p.getColour(0.375, 0,1),Color.GRAY);		
		
		p = PaletteFactory.whiteBlack();
		assertEquals(p.getColour(0, 0,1),Color.WHITE);
		assertEquals(p.getColour(1, 0,1),Color.BLACK);
		assertEquals(p.getColour(1.0-0.375, 0,1),Color.GRAY);		
	}

}
