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

/**
 * Author Ian Davies
 *
 * Date 2 Dec. 2018
 */
import static au.edu.anu.fses.ui.colour.functions.FunctionTypes.*;

import java.util.Random;

import au.edu.anu.fses.ui.colour.functions.FunctionTypes;

// Pre-defined palettes built with a viewer.
public class PaletteFactory {

	public static Palette brownYellowGreen() {
		Band red = new Band(0, 1, true, false, INTERSECT2B);
		Band green = new Band(0, 1, false, false, INTERSECT2B);
		Band blue = new Band(0, 0, false, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette greenYellowBrown() {
		Band red = new Band(0, 1, false, false, INTERSECT2B);
		Band green = new Band(0, 1, true, false, INTERSECT2B);
		Band blue = new Band(0, 0, false, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette blackWhite() {
		Band red = new Band(0, 1, false, false, LINE3);
		Band green = new Band(0, 1, false, false, LINE3);
		Band blue = new Band(0, 1, false, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette whiteBlack() {
		Band red = new Band(0, 1, true, false, LINE3);
		Band green = new Band(0, 1, true, false, LINE3);
		Band blue = new Band(0, 1, true, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette blueGreenRed() {
		Band red = new Band(0, 1, false, false, LINE3);
		Band green = new Band(0, 1, false, false, TRIANGLE21);
		Band blue = new Band(0, 1, true, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette redGreenBlue() {
		Band red = new Band(0, 1, true, false, LINE3);
		Band green = new Band(0, 1, false, false, TRIANGLE21);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette brownYellowLightBlue() {
		Band red = new Band(0, 1, true, false, INTERSECT2B);
		Band green = new Band(0, 1, false, false, INTERSECT2B);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette lightBlueYellowBrown() {
		Band red = new Band(0, 1, false, false,INTERSECT2B);
		Band green = new Band(0, 1, true, false, INTERSECT2B);
		Band blue = new Band(0, 1, true, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static Palette purpleYellowGreenRed() {
		Band red = new Band(0.5, 1, true, false, BESSEL2);
		Band green = new Band(0, 1, false, false, BESSEL2);
		Band blue = new Band(0, 1, true, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static  Palette redGreenYellowPurple() {
		Band red = new Band(0.5, 1, false, false, BESSEL2);
		Band green = new Band(0, 1, true, false, BESSEL2);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static  Palette greenWhiteBrown() {
		Band red = new Band(0, 1, false, false,INTERSECT2B);
		Band green = new Band(0, 1, true, false,INTERSECT2B);
		Band blue = new Band(0, 1, false, false, SINE11);
		return new Palette(red, green, blue, 1.0);
	}

	public static  Palette brownWhiteGreen() {
		Band red = new Band(0, 1, true, false, INTERSECT2B);
		Band green = new Band(0, 1, false, false, INTERSECT2B);
		Band blue = new Band(0, 1, false, false, SINE11);
		return new Palette(red, green, blue, 1.0);
	}

	public static  Palette blueLimeRed() {
		Band red = new Band(0, 1, true, true, LOGISTIC2A);
		Band green = new Band(0, 1, false, false, TRIANGLE31);
		Band blue = new Band(0, 1, true, false,POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static  Palette redLimeBlue() {
		Band red = new Band(0, 1, false, true, LOGISTIC2A);
		Band green = new Band(0, 1, false, false, TRIANGLE31);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	public static  Palette randomPalette() {
		Random rnd = new Random();
		return new Palette(getRandomBand(rnd), getRandomBand(rnd), getRandomBand(rnd), 1.0);
	}

	private static Band getRandomBand(Random rnd) {
		double v1 = Math.round(rnd.nextDouble() * 100) / 100.0;
		double v2 = Math.round(rnd.nextDouble() * 100) / 100.0;
		return new Band(Math.min(v1, v2), Math.max(v1, v2), rnd.nextBoolean(), rnd.nextBoolean(),
				getRandomFunction(rnd));
	}

	private static FunctionTypes getRandomFunction(Random rnd) {
		FunctionTypes[] funcs = FunctionTypes.values();
		return funcs[rnd.nextInt(funcs.length)];
	}

}
