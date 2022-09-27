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

import java.util.List;
import fr.ens.biologie.generic.utils.Duple;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * A small javafx app to display colours.
 * 
 * @author Ian Davies -17 Dec. 2018
 */
//TODO dialog to show contrasting colours
public class ColourContrastShow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Contrasting colours");
		BorderPane root = new BorderPane();
		HBox top = new HBox();
		root.setTop(top);
		Canvas canvas = new Canvas();
		canvas.setWidth(800);
		canvas.setHeight(800);
		ScrollPane sp = new ScrollPane(canvas);
		root.setCenter(sp);
		// Set up a gridpane with scrollpanes with lines drawn each each colour.
		Button btn = new Button("Show 1");
		Button btn2 = new Button("Show 2");

		TextField contrast = new TextField("0.2");
		final ColorPicker colorPicker = new ColorPicker(Color.WHITE);

		top.getChildren().addAll(btn, btn2, contrast, colorPicker);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gc.setFill(colorPicker.getValue());
				gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
				List<Color> colours = ColourContrast.getContrastingColours64(PaletteSize.veryLarge,colorPicker.getValue(),
						Double.parseDouble(contrast.getText()));

				double s = canvas.getWidth() / 8.0;
				for (int i = 0; i < colours.size(); i++) {
					int x = i / 8;
					int y = i % 8;
					gc.setStroke(colours.get(i));
					gc.setFill(colours.get(i));
					gc.fillRect(x * s + 10, y * s + 10, 30, 30);
					gc.strokeRect(x * s + 40, y * s + 10, 30, 30);
				}

			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GraphicsContext gc = canvas.getGraphicsContext2D();
				Color bkg = colorPicker.getValue();
				Color txt = bkg.invert();
				ColourItem bkgci = new ColourItem(-1,"",bkg);
				ColourItem txtci = new ColourItem(-1,"",txt);
				if (bkgci.distance(txtci)<0.05)// mid point gray problem
					txt = Color.WHITE;
				gc.setFill(bkg);
				gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
				List<Duple<String, Color>> colours = ColourContrast
						.getContrastingColourNamePairs(PaletteSize.veryLarge,colorPicker.getValue(), Double.parseDouble(contrast.getText()));

				double s = canvas.getWidth() / 8.0;
				for (int i = 0; i < colours.size(); i++) {
					int x = i / 8;
					int y = i % 8;
					gc.setFill(colours.get(i).getSecond());
					gc.setStroke(colours.get(i).getSecond());
					gc.fillRect(x * s + 10, y * s + 10, 30, 30);
					gc.strokeRect(x * s + 40, y * s + 10, 30, 30);
					gc.setFill(txt);
					if (x % 2 == 0)
						gc.fillText(colours.get(i).getFirst(), x * s + 10, y * s + 8);
					else
						gc.fillText(colours.get(i).getFirst(), x * s + 10, y * s + 52);

				}

			}
		});

		primaryStage.setScene(new Scene(root, 900, 900));
		primaryStage.show();

	}

	/**
	 * Launch javafx app without modules
	 * 
	 * @param args no args required
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
