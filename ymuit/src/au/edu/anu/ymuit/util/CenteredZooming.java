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

package au.edu.anu.ymuit.util;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * Static function to zoom in and out of a drawing pane centered on the mouse
 * position.
 * 
 * @author Ian Davies, 4 Sep 2019
 */
public class CenteredZooming {

	private CenteredZooming() {
	};

	/**
	 * Ensures zooming stays centered over the mouse position
	 * 
	 * @param scrollPane    The containing scroll pane
	 * @param scrollContent The content - should be a stackpane
	 * @param group         a Group that contains the zoomRegion.
	 * @param zoomRegion    the active pane to be zoomed - usually an anchorPane
	 */
	public static void center(ScrollPane scrollPane, StackPane scrollContent, Group group, Region zoomRegion) {
//		Tooltip.install(zoomRegion, new Tooltip("Zoom: Ctrl+mouse wheel")); it's too annoying to have tool tips for this.

		// Manage zooming
		group.layoutBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
			double w = newBounds.getWidth();
			double h = newBounds.getHeight();
			scrollContent.setMinWidth(w);
			scrollContent.setMinHeight(h);
		});
		scrollPane.viewportBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
			// use viewport size, if not too small for zoomTarget
			double w = newBounds.getWidth();
			double h = newBounds.getHeight();
			scrollContent.setPrefSize(w, h);
		});
		scrollContent.setOnScroll(event -> {
			// Most important to avoid events with delta y=0.0!!!
			if (event.isControlDown() && event.getDeltaY() != 0.0) {
				event.consume();
				handleContentOnScroll(event, scrollPane, group, zoomRegion);
			}
		});

	}

//	private static int count = 0;

	private static void handleContentOnScroll(ScrollEvent event, ScrollPane scrollPane, Group group,
			Region zoomRegion) {

		// use the vertical scroll amount
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
		double zx = zoomFactor * zoomRegion.getScaleX();
		double zy = zoomFactor * zoomRegion.getScaleY();
		zoomRegion.setScaleX(zx);
		zoomRegion.setScaleY(zy);

		// refresh ScrollPane scroll positions & content bounds
		scrollPane.layout();

		/**
		 * Convert back to [0, 1] range. Values that are too large or small are
		 * automatically corrected by ScrollPane.
		 */
		groupBounds = group.getLayoutBounds();
		double newHVal = (valX + adjustment.getX()) / (groupBounds.getWidth() - viewportBounds.getWidth());
		double newVVal = (valY + adjustment.getY()) / (groupBounds.getHeight() - viewportBounds.getHeight());
		scrollPane.setHvalue(newHVal);
		scrollPane.setVvalue(newVVal);
	}
}
