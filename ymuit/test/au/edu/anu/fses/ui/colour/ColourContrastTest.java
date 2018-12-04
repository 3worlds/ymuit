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

import java.util.Map;

import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

class ColourContrastTest {

	@Test
	void test() {
		Color bkg = Color.WHITE;
		int n = 2*2*2;
//		String[] names = ColourContrast.allContrastingColourNames(bkg, n);
		Map<String, Color> res = ColourContrast.allContrastingColours(bkg, n);
		double min = Double.MAX_VALUE;
		assertTrue(res.size() <= n);
		for (Map.Entry<String, Color> e1 : res.entrySet()) {
			Color c1 = e1.getValue();
			double d1 = ColourContrast.colourDistance(bkg, c1);
			assertTrue(d1 >= ColourContrast.distanceFromBkg());
//			for (Map.Entry<String, Color> e2 : res.entrySet()) {
//				Color c2 = e2.getValue();
//				if (!c2.equals(c1)) {
//					double d2 = ColourContrast.colourDistance(c1, c2);
////					System.out.println(d2);
//					min = Math.min(min, d2);
//				}
//			}
//			System.out.println("----------");
		}
//System.out.println("Min: " + min);
	}

}
