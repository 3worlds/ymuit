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
package au.edu.anu.ymuit.exceptions;

import fr.ens.biologie.generic.Textable;

/**
 * @author shayne.flint@anu.edu.au
 *
 *         Policy is to make at least one exception for a library.The general
 *         advice for exceptions is to throw early and catch late.
 */
public class YmuitException extends RuntimeException {
	private static final long serialVersionUID = 5550450272121018603L;

	/**
	 * Instantiate an exception on an object with a message
	 * 
	 * @param item    the item which caused the problem
	 * @param message the error message
	 */
	public YmuitException(Textable item, String message) {
		super("[on " + item + "]\n[" + message + "]");
	}

	/**
	 * Instantiate an exception with a message
	 * 
	 * @param message the error message
	 */
	public YmuitException(String message) {
		super("[" + message + "]");
	}

	/**
	 * Exception wrapper.
	 * @param e the exception to wrap
	 */
	public YmuitException(Exception e) {
		super(e);
	}

	/**
	 * Exception wrapper with additional information
	 * @param message the error message
	 * @param e the exception to wrap
	 */
	public YmuitException(String message, Exception e) {
		super("[" + message + "]\n[original exception: " + e + "]");
		e.printStackTrace();
	}

}
