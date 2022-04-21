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

package au.edu.anu.ymuit.ui.colour;

import static au.edu.anu.ymuit.ui.colour.functions.FunctionTypes.*;

import java.util.Random;

import au.edu.anu.ymuit.ui.colour.functions.FunctionTypes;

/**
 * @author Ian Davies 18 Apr 2022
 * 
 * Pre-defined palettes
 */
public class PaletteFactory {

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/brownYellowGreen.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette brownYellowGreen() {
		Band red = new Band(0, 1, true, false, INTERSECT2B);
		Band green = new Band(0, 1, false, false, INTERSECT2B);
		Band blue = new Band(0, 0, false, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/greenYellowBrown.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette greenYellowBrown() {
		Band red = new Band(0, 1, false, false, INTERSECT2B);
		Band green = new Band(0, 1, true, false, INTERSECT2B);
		Band blue = new Band(0, 0, false, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/blackAndWhite.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette blackWhite() {
		Band red = new Band(0, 1, false, false, LINE3);
		Band green = new Band(0, 1, false, false, LINE3);
		Band blue = new Band(0, 1, false, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/whiteAndBlack.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette whiteBlack() {
		Band red = new Band(0, 1, true, false, LINE3);
		Band green = new Band(0, 1, true, false, LINE3);
		Band blue = new Band(0, 1, true, false, LINE3);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/blueMauveOrange.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette blueMauveOrange() {
		Band red = new Band(0, 1, false, false, LINE3);
		Band green = new Band(0, 1, false, false, TRIANGLE21);
		Band blue = new Band(0, 1, true, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/orangeMauveBlue.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette orangeMauveBlue() {
		Band red = new Band(0, 1, true, false, LINE3);
		Band green = new Band(0, 1, false, false, TRIANGLE21);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/brownYellowLightBlue.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette brownYellowLightBlue() {
		Band red = new Band(0, 1, true, false, INTERSECT2B);
		Band green = new Band(0, 1, false, false, INTERSECT2B);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/lightBlueYellowBrown.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette lightBlueYellowBrown() {
		Band red = new Band(0, 1, false, false,INTERSECT2B);
		Band green = new Band(0, 1, true, false, INTERSECT2B);
		Band blue = new Band(0, 1, true, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/lightBlueYellowBrown.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static  Palette lightBlueYellowPurple() {
		Band red = new Band(0, 1, false, false,INTERSECT2B);
		Band green = new Band(0, 1, true, false,INTERSECT2B);
		Band blue = new Band(0, 1, false, false, SINE11);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/purpleYellowLightBlue.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static  Palette purpleYellowLightBlue() {
		Band red = new Band(0, 1, true, false, INTERSECT2B);
		Band green = new Band(0, 1, false, false, INTERSECT2B);
		Band blue = new Band(0, 1, false, false, SINE11);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/blueLimeRed.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static  Palette blueLimeRed() {
		Band red = new Band(0, 1, true, true, LOGISTIC2A);
		Band green = new Band(0, 1, false, false, TRIANGLE31);
		Band blue = new Band(0, 1, true, false,POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/redLimeBlue.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 * @return this palette
	 */
	public static  Palette redLimeBlue() {
		Band red = new Band(0, 1, false, true, LOGISTIC2A);
		Band green = new Band(0, 1, false, false, TRIANGLE31);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

//	/**
//	 * @return
//	 */
//	public static  Palette randomPalette() {
//		Random rnd = new Random();
//		return new Palette(getRandomBand(rnd), getRandomBand(rnd), getRandomBand(rnd), 1.0);
//	}
//
//	/**
//	 * @param rnd
//	 * @return
//	 */
//	private static Band getRandomBand(Random rnd) {
//		double v1 = Math.round(rnd.nextDouble() * 100) / 100.0;
//		double v2 = Math.round(rnd.nextDouble() * 100) / 100.0;
//		return new Band(Math.min(v1, v2), Math.max(v1, v2), rnd.nextBoolean(), rnd.nextBoolean(),
//				getRandomFunction(rnd));
//	}
//
//	/**
//	 * @param rnd
//	 * @return
//	 */
//	private static FunctionTypes getRandomFunction(Random rnd) {
//		FunctionTypes[] funcs = FunctionTypes.values();
//		return funcs[rnd.nextInt(funcs.length)];
//	}

}
