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

package au.edu.anu.ymuit.scrolling;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * @author Ian Davies
 *
 * @date 4 Sep 2019
 */
public class CenteredZooming {
	private CenteredZooming() {
	};

	/*
	 * This code is mostly taken from the web - sorry can't find reference.
	 * provides property wiring to ensure zooming stays centered over the mouse
	 * position
	 */
	public static void center(ScrollPane scrollPane, StackPane scrollContent, Group group, Region zoomRegion) {
		Tooltip.install(zoomRegion, new Tooltip("Zoom: Ctrl+mouse wheel"));

		// Manage zooming
		group.layoutBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
			scrollContent.setMinWidth(newBounds.getWidth());
			scrollContent.setMinHeight(newBounds.getHeight());
		});
		scrollPane.viewportBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
			// use viewport size, if not too small for zoomTarget
			scrollContent.setPrefSize(newBounds.getWidth(), newBounds.getHeight());
		});
		scrollContent.setOnScroll(event -> handleContentOnScroll(event, scrollPane, group, zoomRegion));

	}

	private static void handleContentOnScroll(ScrollEvent event, ScrollPane scrollPane, Group group,
			Region zoomRegion) {

		if (event.isControlDown()) {
			event.consume();
			final double zoomFactor = event.getDeltaY() > 0 ? 1.05 : 1 / 1.05;
			Bounds groupBounds = group.getLayoutBounds();
			final Bounds viewportBounds = scrollPane.getViewportBounds();

			// calculate pixel offsets from [0, 1] range
			double valX = scrollPane.getHvalue() * (groupBounds.getWidth() - viewportBounds.getWidth());
			double valY = scrollPane.getVvalue() * (groupBounds.getHeight() - viewportBounds.getHeight());
			// convert content coordinates to zoomTarget coordinates
			Point2D posInZoomTarget = zoomRegion
					.parentToLocal(group.parentToLocal(new Point2D(event.getX(), event.getY())));

			// calculate adjustment of scroll position (pixels)
			Point2D adjustment = zoomRegion.getLocalToParentTransform()
					.deltaTransform(posInZoomTarget.multiply(zoomFactor - 1));

			// do the resizing
			zoomRegion.setScaleX(zoomFactor * zoomRegion.getScaleX());
			zoomRegion.setScaleY(zoomFactor * zoomRegion.getScaleY());

			// refresh ScrollPane scroll positions & content bounds
			scrollPane.layout();

			/**
			 * Convert back to [0, 1] range. Values that are too large or small are
			 * automatically corrected by ScrollPane.
			 */
			groupBounds = group.getLayoutBounds();
			scrollPane.setHvalue((valX + adjustment.getX()) / (groupBounds.getWidth() - viewportBounds.getWidth()));
			scrollPane.setVvalue((valY + adjustment.getY()) / (groupBounds.getHeight() - viewportBounds.getHeight()));
		}
	}
}
