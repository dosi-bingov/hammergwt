package org.hammergwt.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.IsWidget;
import org.hammergwt.client.handler.HammerDragHandler;
import org.hammergwt.client.handler.HammerPinchHandler;
import org.hammergwt.client.handler.HammerTapHandler;


/**
 * @author Dosi Bingov
 *
 * @version 1.0
 */

public abstract class HammerWidget implements IsWidget {
	private JavaScriptObject hammertime;

	public HammerWidget() {

	}

	public void addPinchHandler(HammerPinchHandler handler) {
		HammerGWT.onPinch(getHammerInstance(), handler);
	}

	public void addTapHandler(HammerTapHandler handler) {
		HammerGWT.onTap(getHammerInstance(), handler);
	}

	public void addDragHandler(HammerDragHandler handler) {
		HammerGWT.onDrag(getHammerInstance(), handler);
	}

	private JavaScriptObject getHammerInstance() {
		if (hammertime == null) {
			com.google.gwt.user.client.Element el = asWidget().getElement();
			hammertime = HammerGWT.getInstance(el);
		}

		return hammertime;
	}


}
