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

/**
 * Pre-defined palettes that have been found useful.
 * 
 * @author Ian Davies 18 Apr 2022
 * 
 */
public class PaletteFactory {

	/**
	 * * <img src="{@docRoot}/../doc/images/brownYellowGreen.png" width="210" alt=
	 * "Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotBrownYellowGreen.png" width="300" alt=
	 * "Colour palette system"/>
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
	 * * <img src="{@docRoot}/../doc/images/greenYellowBrown.png" width="210" alt=
	 * "Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotGreenYellowBrown.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
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
	 * <img src="{@docRoot}/../doc/images/blackAndWhite.png" width="210" alt="Colour
	 * palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotBlackWhite.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette blackWhite() {
		Band red = new Band(0, 1, false, false, LINE4);
		Band green = new Band(0, 1, false, false, LINE4);
		Band blue = new Band(0, 1, false, false, LINE4);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/whiteAndBlack.png" width="210" alt="Colour
	 * palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotWhiteBlack.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette whiteBlack() {
		Band red = new Band(0, 1, true, false, LINE4);
		Band green = new Band(0, 1, true, false, LINE4);
		Band blue = new Band(0, 1, true, false, LINE4);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * * <img src="{@docRoot}/../doc/images/blueMauveOrange.png" width="210" alt=
	 * "Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotBlueMauveOrange.png" width="300" alt=
	 * "Colour palette system"/>
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
	 * * <img src="{@docRoot}/../doc/images/orangeMauveBlue.png" width="210" alt=
	 * "Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotOrangeMauveBlue.png" width="300" alt=
	 * "Colour palette system"/>
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
	 * <img src="{@docRoot}/../doc/images/brownYellowLightBlue.png" width="210" alt=
	 * "Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotBrownYellowLightBlue.png" width="300"
	 * alt="Colour palette system"/>
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
	 * <img src="{@docRoot}/../doc/images/lightBlueYellowBrown.png" width="210" alt=
	 * "Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotLightBlueYellowBrown.png" width="300"
	 * alt="Colour palette system"/>
	 * 
	 * 
	 * @return this palette
	 */
	public static Palette lightBlueYellowBrown() {
		Band red = new Band(0, 1, false, false, INTERSECT2B);
		Band green = new Band(0, 1, true, false, INTERSECT2B);
		Band blue = new Band(0, 1, true, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/lightBlueYellowBrown.png" width="210" alt=
	 * "Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotLightBlueYellowPurple.png" width="300"
	 * alt="Colour palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette lightBlueYellowPurple() {
		Band red = new Band(0, 1, false, false, INTERSECT2B);
		Band green = new Band(0, 1, true, false, INTERSECT2B);
		Band blue = new Band(0, 1, false, false, SINE11);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/purpleYellowLightBlue.png" width="210" alt
	 * ="Colour palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotPurpleYellowLightBlue.png" width="300"
	 * alt="Colour palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette purpleYellowLightBlue() {
		Band red = new Band(0, 1, true, false, INTERSECT2B);
		Band green = new Band(0, 1, false, false, INTERSECT2B);
		Band blue = new Band(0, 1, false, false, SINE11);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * * <img src="{@docRoot}/../doc/images/blueLimeRed.png" width="210" alt="Colour
	 * palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotRedLimeBlue.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 * @return this palette
	 */
	public static Palette blueLimeRed() {
		Band red = new Band(0, 1, true, true, LOGISTIC2A);
		Band green = new Band(0, 1, false, false, TRIANGLE31);
		Band blue = new Band(0, 1, true, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}

	/**
	 * * <img src="{@docRoot}/../doc/images/redLimeBlue.png" width="210" alt="Colour
	 * palette system"/>
	 * <p>
	 * <img src="{@docRoot}/../doc/images/plotRedLimeBlue.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 * 
	 * @return this palette
	 */
	public static Palette redLimeBlue() {
		Band red = new Band(0, 1, false, true, LOGISTIC2A);
		Band green = new Band(0, 1, false, false, TRIANGLE31);
		Band blue = new Band(0, 1, false, false, POWER2);
		return new Palette(red, green, blue, 1.0);
	}
//	public static void main(String[] args) {
//		String sep = "\t";
//		Band red = new Band(0, 1, true, false, INTERSECT2B);
//		Band green = new Band(0, 1, false, false, INTERSECT2B);
//		Band blue = new Band(0, 0, false, false, LINE3);
//
//		System.out.println(INTERSECT2B.name()+sep+INTERSECT2B.name()+sep+LINE3.name());
//		for (int i = 0; i < Function.length; i++) {
//			double x = i / (double) Function.length;
//			System.out.println( red.getValueAt(i)+sep+green.getValueAt(i)+sep+blue.getValueAt(i));
//		}
//	
//	}
}