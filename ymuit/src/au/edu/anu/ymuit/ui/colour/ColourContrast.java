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

import java.lang.reflect.Field;
import java.util.*;

import au.edu.anu.omhtk.rng.Pcg32;
import fr.cnrs.iees.uit.indexing.BoundedRegionIndexingTree;
import fr.cnrs.iees.uit.indexing.RegionIndexingTree;
import fr.cnrs.iees.uit.space.Box;
import fr.cnrs.iees.uit.space.Point;
import fr.cnrs.iees.omhtk.utils.Duple;
import javafx.scene.paint.Color;

/**
 * A method to select a set of contrasting colours from 3d colour space. The
 * distance between colours is based on perceived difference {@link ColourItem}.
 * </p>
 * <p>
 * <li>Add all javafx named colours to an indexer that are a sufficient distance
 * (3d space) from the background. They need to be from the set of named colours
 * because for css we just use names rather than colours.Alternatively, generate
 * 4096 colours (without real names).</li>
 * <p>
 * <li>Divide the 3d space into n volumes and select one colour nearest to the
 * center of each volume. Then select from that list those which have a user
 * supplied difference in luminosity from the given background.</li>
 *
 * @see ColourItem
 * @author Ian Davies- 2 Dec. 2018
 */

public class ColourContrast {
	private final static long seed = 2L;// Trial and error
	private static Map<ColourItem, RegionIndexingTree<String>> colourQts = new HashMap<>();
	private static Map<String, ColourItem> colourMap = new HashMap<>();

	/**
	 * Up to 64 colours from 4096 generated colours. The number will be less than 64
	 * depending on contrast required with background.
	 *
	 * @param ps       palette size
	 * @param bkg      background colour
	 * @param contrast (0.0 - 1.0)
	 * @return List of Color
	 */
	public static List<Color> getContrastingColours64(PaletteSize ps, Color bkg, double contrast) {
		return createColours64(ps, bkg, contrast);
	}

	/**
	 * Creates a list of named colours that contrast with the given background
	 * colour and are distant in perceived colour from each other in 3d space. The
	 * methods will return up to a maximum of 27 out of approx 148 named colours.
	 * The number return depends on the background colour choice and the contrast
	 * requested. Use these colour names to set the css style sheet of the
	 * scene.node in question.
	 *
	 * @param ps       palette size
	 * @param bkg      background colour
	 * @param contrast (0.0 - 1.0)
	 * @return Array of Javafx color names for contrasting colours.
	 */
	public static List<String> getContrastingColourNames(PaletteSize ps, Color bkg, double contrast) {
		List<Duple<String, Color>> colours = getContrastingColourNamePairs(ps, bkg, contrast);
		List<String> result = new ArrayList<>();
		colours.forEach((d) -> {
			result.add(d.getFirst());
		});
		return result;
	}

	/**
	 * Creates a list of named colours that contrast with the given background
	 * colour and are distant in perceived colour from each other in 3d space. The
	 * methods will return up to a maximum of 27 out of approx 148 named colours.
	 * The number return depends on the background colour choice and the contrast
	 * requested. Use these colour names to set the css style sheet of the
	 * scene.node in question.
	 *
	 * @param ps       palette size
	 * @param bkg      background colour
	 * @param contrast (0.0 - 1.0)
	 * @return Array of constrasting Javafx colors.
	 */
	public static List<Color> getContrastingColours(PaletteSize ps, Color bkg, double contrast) {
		List<Duple<String, Color>> colours = getContrastingColourNamePairs(ps, bkg, contrast);
		List<Color> result = new ArrayList<>();
		colours.forEach((d) -> {
			result.add(d.getSecond());
		});
		return result;
	}

	/**
	 * Creates a list of color name pairs that contrast with the given background
	 * colour and are distant in perceived colour from each other in 3d space. The
	 * methods will return up to a maximum of 27 out of approx 148 named colours.
	 * The number return depends on the background colour choice and the contrast
	 * requested. Use these colour names to set the css style sheet of the
	 * scene.node in question.
	 *
	 * @param size     palette size
	 * @param bkg      background colour
	 * @param contrast (0.0 - 1.0)
	 * @return Array of constrasting Javafx colors.
	 */
	public static List<Duple<String, Color>> getContrastingColourNamePairs(PaletteSize size, Color bkg,
			double contrast) {
		int dim;
		switch (size) {
		case small: {
			dim = 2;// 8 max
			break;
		}
		case medium: {
			dim = 3;
			break;
		}
		case large: {
			dim = 4;
			break;
		}
		default: {
			dim = 5;
		}
		}
		List<Duple<String, Color>> result = new ArrayList<>();
		List<Duple<String, ColourItem>> list = new ArrayList<>();
		Map<String, ColourItem> colours = _getContrastingColoursMap(dim, bkg, contrast * 100);

		colours.forEach((k, v) -> {
			list.add(new Duple<String, ColourItem>(k, v));
		});
		// sort in consistent but random order (consistent because the rnd seed never
		// varies)
		list.sort((d1, d2) -> d1.getSecond().getIndex().compareTo(d2.getSecond().getIndex()));
		list.forEach((v) -> {
			result.add(new Duple<String, Color>(v.getFirst(), v.getSecond().getColour()));
		});
		return result;
	}

	/**
	 * Run an app to display both methods: Method 1 selects only from colours named
	 * by Javafx Color; Method 2 selects from 4096 generated colours.
	 */
	public static void show() {
		ColourContrastShow.main(new String[0]);

	}

	private static RegionIndexingTree<String> getKTree(ColourItem key) {
		if (colourQts.containsKey(key))
			return colourQts.get(key);
		else
			return createKTree(key);
	}

	private static RegionIndexingTree<String> createKTree(ColourItem key) {
		Box limits = Box.boundingBox(Point.newPoint(0, 0, 0), Point.newPoint(1, 1, 1));
		RegionIndexingTree<String> result = new BoundedRegionIndexingTree<>(limits);
		result.setOptimisation(true);
		colourQts.put(key, result);
		try {
			if (colourMap.isEmpty())
				colourMap = getNamedColourMap();
			for (Map.Entry<String, ColourItem> entry : colourMap.entrySet()) {
				ColourItem c = entry.getValue();
				if (!entry.getKey().contains("TRANSPARENT")) {
					Point p = Point.newPoint(c.getpRed(), c.getpGreen(), c.getpBlue());
					result.insert(entry.getKey(), p);
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * From:
	 * https://stackoverflow.com/questions/17464906/how-to-list-all-colors-in-javafx
	 *
	 * Finds all named colours in javafx through reflection
	 *
	 * @return: map (Name, Color) of all named colours in javafx.scene.paint.Color
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 */
	private static Map<String, ColourItem> getNamedColourMap() throws ClassNotFoundException, IllegalAccessException {
		Random rnd = new Pcg32();
		rnd.setSeed(seed);
		Map<String, ColourItem> map = new HashMap<>();
		Class<?> clazz = Class.forName("javafx.scene.paint.Color", true,
				Thread.currentThread().getContextClassLoader());
		if (clazz != null) {
			Field[] field = clazz.getFields();
			for (int i = 0; i < field.length; i++) {
				Field f = field[i];
				Object obj = f.get(null);
				if (obj instanceof Color) {
					map.put(f.getName(), new ColourItem(rnd.nextDouble(), f.getName(), (Color) obj));
				}
			}
		}
		return map;
	}

	/**
	 * Creates a map of colour names and colours that contrast with the given
	 * background colour up to a maximum of maxChoices. Use these colour names to
	 * set the css style sheet of the scene.node in question. The value is a duple
	 * with first entry an index. This is used to maintain consistent order
	 *
	 * @param bkg        background colour
	 * @param maxChoices maximum number of colours. The more colours requested, the
	 *                   less contrast there will be between them.
	 * @return Map of colour names and colours.
	 */

	private static Map<String, ColourItem> _getContrastingColoursMap(int dim, Color bkg, double threshold) {
		Random rnd = new Pcg32();
		rnd.setSeed(seed);

		Map<String, ColourItem> res = new HashMap<>();
		double separation = 1.0 / (double) dim;
		ColourItem bkgItem = new ColourItem(rnd.nextDouble(), "BKG", bkg);

//		int counter = 0;
		RegionIndexingTree<String> qt = getKTree(bkgItem);
		int size = (int) (1.0 / separation);
		for (int x = 0; x < size; x++) {
			double px = x * separation + separation / 2.0;
			for (int y = 0; y < size; y++) {
				double py = y * separation + separation / 2.0;
				for (int z = 0; z < size; z++) {
					double pz = z * separation + separation / 2.0;
					Point p = Point.newPoint(px, py, pz);
					String name = qt.getNearestItem(p);
					if (!res.containsKey(name)) {
						ColourItem ci = colourMap.get(name);
						// perceived luminosity ("L*") threshold black=0, white = 100
						double delta = Math.abs(ci.getpLum() - bkgItem.getpLum());
						if (delta > threshold) {
							res.put(name, ci);
						}
					}
				}
			}
		}
		return res;
	}

	private static List<Color> createColours64(PaletteSize ps, Color bkg, double contrast) {
		Random rnd = new Pcg32();
		rnd.setSeed(seed);
		double dSize;
		switch (ps) {
		case small: {
			dSize = 2.0;// 8
			break;
		}
		case medium: {
			dSize = 3.0;// 27
			break;
		}
		case large: {
			dSize = 4.0;// 64
			break;
		}
		default: {
			dSize = 5.0;// 125
		}
		}

		List<ColourItem> cList = createBigColourItems(dSize, new ColourItem(rnd.nextDouble(), "BKG", bkg),
				contrast * 100);
		List<Color> result = new ArrayList<>();
		cList.forEach((ci) -> {
			result.add(ci.getColour());
		});
		return result;
	}

	/**
	 * Create a list of {@link ColourItems} evenly spaced in 3d colour space that
	 * are sufficently different in perceived luminosity.
	 * 
	 * @param dSize     number of items in one dimension i.e it's a cubic space.
	 * @param bkgItem   background colour
	 * @param threshold minimum difference in perceived luminosity.
	 * @return
	 */
	private static List<ColourItem> createBigColourItems(double dSize, ColourItem bkgItem, double threshold) {
		Random rnd = new Pcg32();
		rnd.setSeed(seed);
		Map<String, ColourItem> lookupMap = new HashMap<>();
		Integer name = 0;
		Box limits = Box.boundingBox(Point.newPoint(0, 0, 0), Point.newPoint(1, 1, 1));
		RegionIndexingTree<String> tree = new BoundedRegionIndexingTree<>(limits);
		tree.setOptimisation(true);
		for (int r = 1; r <= 16; r++) {
			int red = r * 16 - 1;
			for (int g = 1; g <= 16; g++) {
				int green = g * 16 - 1;
				for (int b = 1; b <= 16; b++) {
					int blue = b * 16 - 1;
					Color c = Color.rgb(red, green, blue);
					ColourItem ci = new ColourItem(rnd.nextDouble(), name.toString(), c);
					Point p = Point.newPoint(ci.getpRed(), ci.getpGreen(), ci.getpBlue());
					tree.insert(ci.getName(), p);
					lookupMap.put(ci.getName(), ci);
					name++;
				}
			}
		}
		List<ColourItem> result = new ArrayList<>();
		double separation = 1.0 / dSize; // 5*5*5 colours
		int iSize = (int) dSize;
		for (int x = 0; x < iSize; x++) {
			double px = x * separation + separation / 2.0;
			for (int y = 0; y < iSize; y++) {
				double py = y * separation + separation / 2.0;
				for (int z = 0; z < iSize; z++) {
					double pz = z * separation + separation / 2.0;
					Point p = Point.newPoint(px, py, pz);
					String pname = tree.getNearestItem(p);
					ColourItem ci = lookupMap.get(pname);
					double delta = Math.abs(ci.getpLum() - bkgItem.getpLum());
					if (delta > threshold) {
						result.add(ci);
					}
				}
			}
		}
		result.sort((c1, c2) -> c1.getIndex().compareTo(c2.getIndex()));

		return result;
	}

	/**
	 * Show dialog box for displaying results.
	 * 
	 * @param args no args required
	 */
	public static void main(String[] args) {
		show();
	}

}
