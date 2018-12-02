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

package au.edu.anu.fses.ui.colour.functions;

/**
 * @author Ian Davies
 *
 * @Date 2 Dec. 2018
 */

// sine wave with frequency and phase
public class Sine implements Function{
	double phase;
	double frequency;
	public Sine() {
		// 4.0/1.0 -ve min at x= 0.5
		// 4.0/2.0 90 deg -starts -ve
		// 4.0/3.0 180 +ve max at x=0.5
		// 4.0/4.0 270 deg starts +ve
		this(4.0/3.0,1.0);
	}
	public Sine(double offsetPar, double nCycles) {
		this.phase=2*Math.PI/offsetPar;
		this.frequency = 2*Math.PI*nCycles;
	}

	@Override
	public double ofX(double x) {
		double y = (Math.sin(x*frequency+phase)+1.0)/2.0;
		return clamp(y);
	}

}
