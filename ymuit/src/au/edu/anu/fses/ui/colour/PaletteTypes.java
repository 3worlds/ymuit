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

import static au.edu.anu.fses.ui.colour.PaletteFactory.*;

/**
 * Author Ian Davies
 *
 * Date 4 Dec. 2018
 */
public enum PaletteTypes {
	BLACKWHITE/*-           */(blackWhite()), //
	WHITEBLACK/*-           */(whiteBlack()), //
	BLUEGREENRED/*-         */(blueGreenRed()), //
	REDGREENBLUE/*-         */(redGreenBlue()), //
	BROWNYELLOWLIGHTBLUE/*- */(brownYellowLightBlue()), //
	LIGHTBLUEYELLOWBROWN/*- */(lightBlueYellowBrown()), //
	BROWNYELLOWGREEN/*-     */(brownYellowGreen()), //
	GREENYELLOWBROWN/*-     */(greenYellowBrown()), //
//	PURPLEYELLOWGREENRED/*- */(purpleYellowGreenRed()), //
//	REDGREENYELLOWPURPLE/*- */(redGreenYellowPurple()), //
	GREENWHITEBROWN/*-      */(greenWhiteBrown()), //
	BROWNWHITEGREEN/*-      */(brownWhiteGreen()), //
	BLUELIMERED/*-          */(blueLimeRed()), //
	REDLIMEBLUE/*-          */(redLimeBlue()), //
	RANDOM/*-               */(randomPalette()),//
	;
	private final Palette palette;

	private PaletteTypes(Palette palette) {
		this.palette = palette;
	}

	public Palette getPalette() {
		return palette;
	}
}
