package org.hammergwt.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.IsWidget;
import org.hammergwt.client.event.EventType;
import org.hammergwt.client.handler.HammerDragEndHandler;
import org.hammergwt.client.handler.HammerDragHandler;
import org.hammergwt.client.handler.HammerDragStartHandler;
import org.hammergwt.client.handler.HammerHandler;
import org.hammergwt.client.handler.HammerPinchHandler;
import org.hammergwt.client.handler.HammerPinchInHandler;
import org.hammergwt.client.handler.HammerPinchOutHandler;
import org.hammergwt.client.handler.HammerTapHandler;


/**
 * Hammer GWT implementation.
 *
 * @author Dosi Bingov
 *
 * @version 1.0
 */
public final class HammerGWT {

	private HammerGWT() {
	}


	/**
	 * Sets hammer time options
	 * @param gestureOptions
	 */
	private static void setOptions(GestureOption[] gestureOptions, JavaScriptObject hammerGwt) {
		String gestureOptionsStr = "";

		for (GestureOption option: gestureOptions) {
			gestureOptionsStr = gestureOptionsStr + option.toString().toLowerCase() + ": " + option.getVal() + ", ";
		}

		gestureOptionsStr = gestureOptionsStr.substring(0, gestureOptionsStr.lastIndexOf(',')); //trim last comma

		setOptions(hammerGwt);
	}

	/**
	 * Detach event of a widget.
	 *
	 * @param widget
	 * @param eventType
	 */
	public static void off(IsWidget widget, EventType eventType) {
		off(widget.asWidget().getElement(), eventType.getText());
	}

	/**
	 * Add multiple hammer events.
	 *
	 *
	 * @param handler EventType handles all kinds of hammer events
	 * @param eventTypes type that hammer should handle
	 */
	public static void on(IsWidget widget, HammerHandler handler, EventType... eventTypes) {
		on(widget, null, null, handler, eventTypes);
	}

	public static void on(IsWidget widget, GestureOption[] gestureOptions, HammerHandler handler, EventType... eventTypes) {
		on(widget, gestureOptions, null, handler, eventTypes);
	}

	/**
	 * Add multiple hammer events.
	 *
	 * @param handler EventType handles all kinds of hammer events
	 * @param eventTypes type that hammer should handle
	 */
	public static void on(IsWidget widget, GestureOption[] gestureOptions, String eventNamespace, HammerHandler handler, EventType... eventTypes) {
		//JsArrayString arr = JavaScriptObject.createArray().cast();
		String eventTypesStr = "";

		for (EventType hammerEventType: eventTypes) {
			String namespace = "";

			if (null != eventNamespace && !eventNamespace.isEmpty()) {
				namespace = "." + eventNamespace;
			}

			eventTypesStr = eventTypesStr + hammerEventType.getText() + namespace + " ";
		}

		eventTypesStr = eventTypesStr.substring(0, eventTypesStr.lastIndexOf(" ")); //trim last space

		JavaScriptObject obj = getInstance(widget.asWidget().getElement());

		on(obj, eventTypesStr, handler);

		setOptions(obj);

	}

	private static native void off(com.google.gwt.dom.client.Element el, String event) /*-{
        return $wnd.Hammer(el).off(event);
    }-*/;

	private static native void setOptions(JavaScriptObject hammertime) /*-{
        hammertime.options.prevent_default = true;
        hammertime.options.no_mouseevents = true;
    }-*/;


	public static native JavaScriptObject getInstance(com.google.gwt.dom.client.Element el) /*-{
        return $wnd.Hammer(el);
    }-*/;

	private static native void on(JavaScriptObject hammertime, String evenTypes, HammerHandler handler) /*-{

        hammertime.on(evenTypes,

            function(ev) {
                handler.@org.hammergwt.client.handler.HammerHandler::onHammerEvent(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onPinch(JavaScriptObject hammer, HammerPinchHandler handler) /*-{
        hammer.on("pinch",

            function(ev) {
               handler.@org.hammergwt.client.handler.HammerPinchHandler::onPinch(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onTap(JavaScriptObject hammer, HammerTapHandler handler) /*-{
        hammer.on("tap",

            function(ev) {
                handler.@org.hammergwt.client.handler.HammerTapHandler::onTap(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;


	public static native void onDrag(JavaScriptObject hammer, HammerDragHandler handler) /*-{
        hammer.on("drag",

            function(ev) {
                handler.@org.hammergwt.client.handler.HammerDragHandler::onDrag(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);

                if (typeof console == 'object') {
					console.log('Drag Event', ev);
                }
            });
    }-*/;

	public static native void onPinchIn(JavaScriptObject hammer, HammerPinchInHandler handler) /*-{
        hammer.on("pinchin",

            function(ev) {
                handler.@org.hammergwt.client.handler.HammerPinchInHandler::onPinchIn(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onPinchOut(JavaScriptObject hammer, HammerPinchOutHandler handler) /*-{
        hammer.on("pinchout",

            function(ev) {
                handler.@org.hammergwt.client.handler.HammerPinchOutHandler::onPinchOut(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onDragStart(JavaScriptObject hammer, HammerDragStartHandler handler) /*-{
        hammer.on("dragstart",

            function(ev) {
                handler.@org.hammergwt.client.handler.HammerDragStartHandler::onDragStart(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

	public static native void onDragEnd(JavaScriptObject hammer, HammerDragEndHandler handler) /*-{
        hammer.on("dragend",

            function(ev) {
                handler.@org.hammergwt.client.handler.HammerDragEndHandler::onDragEnd(Lorg/hammergwt/client/event/NativeHammerEvent;)(ev);
            });
    }-*/;

}
