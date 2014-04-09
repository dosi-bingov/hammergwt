package org.hammergwt.client.impl;

import java.util.Objects;

/**
 * Created by dosib on 19/03/14.
 */
public enum  GestureOption {

	DRAG(true),
	DRAG_BLOCK_HORIZONTAL(false),
	DRAG_BLOCK_VERTICAL(false),
	DRAG_LOCK_TO_AXIS(false),
	DRAG_MAX_TOUCHES(1),
	DRAG_MIN_DISTANCE(10),
	HOLD(true),
	HOLD_THRESHOLD(3),
	HOLD_TIMEOUT(500),
	PREVENT_DEFAULT(true),
	PREVENT_MOUSEEVENTS(false),
	RELEASE(true),
	SHOW_TOUCHES(true),
	/* TODO: stop_browser_behavior: Object*/
	SWIPE(true),
	SWIPE_MAX_TOUCHES(1),
	SWIPE_VELOCITY(0.7),
	TAP(true),
	TAP_ALWAYS(true),
	TAP_MAX_DISTANCE(10),
	TAP_MAX_TOUCHTIME(250),
	DOUBLETAP_DISTANCE(20),
	DOUBLETAP_INTERVAL(300),
	TOUCH(true),
	TRANSFORM(true),
	TRANSFORM_ALWAYS_BLOCK(false),
	TRANSFORM_MIN_ROTATION(1),
	TRANSFORM_MIN_SCALE(0.01);

	private Object value;

	GestureOption(Object value) {
		this.value = value;
	}

	public Object getVal() {
		return this.value;
	}

	public void setVal(Object value) {
		this.value = value;
	}
}