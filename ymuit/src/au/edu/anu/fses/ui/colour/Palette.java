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

import au.edu.anu.fses.ui.colour.functions.Function;
import javafx.scene.paint.Color;

/**
 * @author Ian Davies
 *
 * @Date 2 Dec. 2018
 */
public class Palette {
	private Color[] palette;

	public Palette(Band red, Band green, Band blue, double opacity) {
		palette = new Color[Function.length];
		for (int i = 0; i < Function.length; i++)
			palette[i] = Color.color(red.getValueAt(i), green.getValueAt(i), blue.getValueAt(i), opacity);
	}

	public Color getColour(double v, double min, double max) {
		int idx = getIndex(v, min, max);
		return palette[idx];
	}

	private int getIndex(double v, double min, double max) {
		v = Math.min(max, Math.max(v, min));
		double r = max - min;
		if (r <= 0)
			return 0;
		double p = (v-min) / r;
		double p1 = Math.round(p * (Function.length - 1));
		return (int) p1;
	}

}
