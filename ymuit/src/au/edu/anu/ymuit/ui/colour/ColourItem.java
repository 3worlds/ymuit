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

//import org.apache.commons.math3.util.MathUtils;

import fr.cnrs.iees.uit.space.Distance;
import fr.cnrs.iees.uit.space.Point;
import javafx.scene.paint.Color;

/**
 * @author Ian Davies
 *
 * @date 11 Mar 2020
 */
public class ColourItem {
	// actual Javafx color
	private Color colour;
	// Javafx color name. Can be null
	private String name;
	// Perceived colour channels. Used for separation of colours in 3d space
	private double pRed;
	private double pGreen;
	private double pBlue;
	// Perceived luminance - use for contrast to background
	private double pLum;
	// order colors were produced
	private double index;

	public ColourItem(double index,String name, Color clr) {
		this.index = index;
		this.colour = clr;
		this.name = name;
		this.pRed = sRGBtoLinear(colour.getRed());
		this.pGreen = sRGBtoLinear(colour.getGreen());
		this.pBlue = sRGBtoLinear(colour.getBlue());
		this.pLum = YtoLstar(luminance(colour));
	}

	public Double getIndex() {
		return index;
	}
	public Color getColour() {
		return colour;
	}

	public String getName() {
		return name;
	}

	public double getpRed() {
		return pRed;
	}

	public double getpGreen() {
		return pGreen;
	}

	public double getpBlue() {
		return pBlue;
	}

	public double getpLum() {
		return pLum;
	}

	public double distance(ColourItem to) {
		double[] p1 = { getpRed(), getpGreen(), getpBlue() };
		double[] p2 = { to.getpRed(), to.getpGreen(), to.getpBlue() };
		// JG: this to remove dependency from apache.commons.math
		return Distance.euclidianDistance(Point.newPoint(p1), Point.newPoint(p2));
//		return MathUtils.distance(p1, p2);
	}

	// -----------------------------------------
	private static double luminance(Color c) {
		return (0.2126 * sRGBtoLinear(c.getRed()) + 0.7152 * sRGBtoLinear(c.getGreen())
				+ 0.0722 * sRGBtoLinear(c.getBlue()));
	}
	private static double YtoLstar(double lum) {
		// Send this function a luminance value between 0.0 and 1.0,
		// and it returns L* which is "perceptual lightness"
		/*
		 * L* is a value from 0 (black) to 100 (white) where 50 is the perceptual
		 * "middle grey". L* = 50 is the equivalent of Y = 18.4, or in other words an
		 * 18% grey card, representing the middle of a photographic exposure (Ansel
		 * Adams zone V).
		 */

		if (lum <= (216.0 / 24389.0)) { // The CIE standard states 0.008856 but 216/24389 is the intent for
										// 0.008856451679036
			return lum * (24389.0 / 27.0); // The CIE standard states 903.3, but 24389/27 is the intent, making
											// 903.296296296296296
		} else {
			return Math.pow(lum, (1.0 / 3.0)) * 116 - 16;
		}
	}

	private static double sRGBtoLinear(double colorChannel) {
		// Send this function a decimal sRGB gamma encoded color value
		// between 0.0 and 1.0, and it returns a linearized value.

		if (colorChannel <= 0.04045) {
			return colorChannel / 12.92;
		} else {
			double t = ((colorChannel + 0.055) / 1.055);
			return Math.pow(t, 2.4);
		}
	}

}
