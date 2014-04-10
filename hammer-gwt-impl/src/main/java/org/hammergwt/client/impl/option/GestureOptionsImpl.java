/*
 * This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
 *
 * Copyright 2008-2014 Geosparc nv, http://www.geosparc.com/, Belgium.
 *
 * The program is available in open source according to the GNU Affero
 * General Public License. All contributions in this program are covered
 * by the Geomajas Contributors License Agreement. For full licensing
 * details, see LICENSE.txt in the project root.
 */

package org.hammergwt.client.impl.option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Dosi Bingov
 */
public class GestureOptionsImpl implements GestureOptions {

	public static final Integer DEFAULT_ANIMATION_TIME = 400;

	public static final Integer DEFAULT_FADE_IN_TIME = 250;

	public static final Boolean DEFAULT_ANIMATION_CANCEL_SUPPORT = false;

	private Map<GestureOption<?>, Object> options;

	// ------------------------------------------------------------------------
	// Constructor:
	// ------------------------------------------------------------------------

	public GestureOptionsImpl() {
		options = new HashMap<GestureOption<?>, Object>();

		// Now apply the default values:
		/*setHintValue(MapConfiguration.ANIMATION_TIME, DEFAULT_ANIMATION_TIME);
		setHintValue(MapConfiguration.FADE_IN_TIME, DEFAULT_FADE_IN_TIME);
		setHintValue(MapConfiguration.ANIMATION_CANCEL_SUPPORT, DEFAULT_ANIMATION_CANCEL_SUPPORT);
		setHintValue(MapConfiguration.DPI, DEFAULT_DPI);
		setHintValue(MapConfiguration.MAXIMUM_BOUNDS, DEFAULT_BOUNDS);
		setHintValue(MapConfiguration.INITIAL_BOUNDS, DEFAULT_BOUNDS);
		setHintValue(MapConfiguration.CRS, DEFAULT_CRS);
		setHintValue(MapConfiguration.UNIT_LENGTH, DEFAULT_UNIT_LENGTH);
		setHintValue(MapConfiguration.MINIMUM_RESOLUTION, DEFAULT_MINIMUM_RESOLUTION);
		setHintValue(MapConfiguration.RESOLUTIONS, new ArrayList<Double>());*/
	}

	public <T> void setOptionValue(GestureOption<T> option, T value) {
		if (value == null) {
			throw new IllegalArgumentException("Null value passed.");
		}
		options.put(option, value);
	}

	public <T> T getOptionValue(GestureOption<T> hint) {
		return (T) options.get(hint);
	}

	// ------------------------------------------------------------------------
	// Getters and setters:
	// ------------------------------------------------------------------------

}
