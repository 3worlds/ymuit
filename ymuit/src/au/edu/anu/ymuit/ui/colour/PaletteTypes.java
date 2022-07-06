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

import static au.edu.anu.ymuit.ui.colour.PaletteFactory.*;

/**
 * A list of palettes and their associated palette instance.
 * 
 * @author Ian Davies 4 Dec. 2018
 */
public enum PaletteTypes {
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/blackAndWhite.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 */
	BlackWhite/*-				*/(blackWhite()), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/whiteAndBlack.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 */
	WhiteBlack/*-				*/(whiteBlack()), //
	/**
	 * * <img src="{@docRoot}/../doc/images/blueMauveOrange.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 */
	BlueMauveOrange/*-			*/(blueMauveOrange()), //
	/**
	 * * <img src="{@docRoot}/../doc/images/orangeMauveBlue.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 */
	OrangeMauveBlue/*-			*/(orangeMauveBlue()), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/brownYellowLightBlue.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 */
	BrownYellowLightBlue/*-		*/(brownYellowLightBlue()), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/lightBlueYellowBrown.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 */
	LightBlueYellowBrown/*-		*/(lightBlueYellowBrown()), //
	/**
	 * * <img src="{@docRoot}/../doc/images/brownYellowGreen.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 */
	BrownYellowGreen/*-			*/(brownYellowGreen()), //
	/**
	 * * <img src="{@docRoot}/../doc/images/greenYellowBrown.png" width="300" alt=
	 * "Colour palette system"/>
	 * 
	 */
	GreenYellowBrown/*-			*/(greenYellowBrown()), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/lightBlueYellowPurple.png" width="300" alt
	 * ="Colour palette system"/>
	 * 
	 */
	LightBlueYellowPurple/*-	*/(lightBlueYellowPurple()), //
	/**
	 * *
	 * <img src="{@docRoot}/../doc/images/purpleYellowLightBlue.png" width="300" alt
	 * ="Colour palette system"/>
	 * 
	 */
	PurpleYellowLightBlue/*-	*/(purpleYellowLightBlue()), //
	/**
	 * * <img src="{@docRoot}/../doc/images/blueLimeRed.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 */
	BlueLimeRed/*-				*/(blueLimeRed()), //
	/**
	 * * <img src="{@docRoot}/../doc/images/redLimeBlue.png" width="300" alt="Colour
	 * palette system"/>
	 * 
	 */
	RedLimeBlue/*-				*/(redLimeBlue()), //
	// TODO: Many more to come
	;

	private final Palette palette;

	private PaletteTypes(Palette palette) {
		this.palette = palette;
	}

	/**
	 * The palette instance for this enum value
	 * 
	 * @return the palette
	 */
	public Palette getPalette() {
		return palette;
	}

	/**
	 * The default palette (BrownYellowGreen - NDVI)
	 * 
	 * @return the palette
	 */
	public static PaletteTypes getDefault() {
		return BrownYellowGreen;
	}

	/**
	 * Display these palettes
	 * 
	 * @param args none required
	 */
	public static void main(String[] args) {
		PaletteShow.main(args);

	}
}
