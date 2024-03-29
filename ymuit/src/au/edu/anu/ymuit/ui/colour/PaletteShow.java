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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Javafx app to display palettes for testing.
 * 
 * @author Ian Davies 18 Apr 2022
 */
public class PaletteShow extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Palettes");
		BorderPane root = new BorderPane();
		//SplitPane splitPane = new SplitPane();
		VBox box = new VBox();
		box.setSpacing(5);
//		BorderPane right = new BorderPane();
//		splitPane.getItems().addAll(left,right);
//		Canvas canvas = new Canvas();
//		left.setCenter(canvas);
		for (PaletteTypes palette:PaletteTypes.values()) {
			Image image = getLegend(palette.getPalette(),256,20);
			ImageView view = new ImageView(image);
			box.getChildren().add(view);
		}
		
//		ComboBox palettes = new ComboBox();
//		palettes.getItems().addAll(PaletteTypes.values());
//		left.setTop(palettes);
		root.setCenter(box);
		primaryStage.setScene(new Scene(root,1600, 900));
		primaryStage.show();

		
	}
	private WritableImage getLegend(Palette pl, int width, int height) {	
		WritableImage image = new WritableImage(width, height);
		PixelWriter pw = image.getPixelWriter();
//		for (int h = 0; h < height; h++) {
//			Color c = pl.getColour(height - h - 1, 0, height);
//			for (int w = 0; w < width; w++) {
//				pw.setColor(w, h, c);
//			}
//		}
		for (int w = 0;w < width; w++) {
			Color c = pl.getColour(w, 0, width);
			for (int h = 0; h < height; h++) {
				pw.setColor(w, h, c);
			}
		}
		return image;
	}

	/**
	 * @param args no args required
	 */
	public static void main(String[] args) {
		launch(args);		
	}

}
