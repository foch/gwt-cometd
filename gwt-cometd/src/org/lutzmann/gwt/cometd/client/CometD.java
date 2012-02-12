/*
 * Copyright (c) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.lutzmann.gwt.cometd.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

public class CometD {

	private static final String META_PREFIX = "/meta/";

	public native void disableWebSocketTransport() /*-{
		$wnd.dojox.cometd.websocketEnabled = false;
	}-*/;

	public native void configure(CometDConfiguration config) /*-{
		$wnd.dojox.cometd
				.configure({
					url : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::getUrl()(),
					logLevel : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::getLogLevel()(),
					maxConnections : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::getMaxConnections()(),
					backoffIncrement : config
							.@org.lutzmann.gwt.cometd.client.CometDConfiguration::getBackoffIncrement(),
					maxBackoff : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::getMaxBackoff()(),
					reverseIncomingExtensions : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::isReverseIncomingExtensions()(),
					maxNetworkDelay : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::getMaxNetworkDelay()(),
					requestHeaders : {},
					appendMessageTypeToURL : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::isAppendMessageTypeToUrl()(),
					autoBatch : config.@org.lutzmann.gwt.cometd.client.CometDConfiguration::isAutoBatch()()
				});
	}-*/;

	public native void handshake() /*-{
		$wnd.dojox.cometd.handshake();
	}-*/;

	public native void disconnect() /*-{
		$wnd.dojox.cometd.disconnect(true);
	}-*/;

	public native boolean isDisconnected() /*-{
		return $wnd.dojox.cometd.isDisconnected();
	}-*/;

	public native JavaScriptObject addListener(String channel,
			CometDListener<? extends JavaScriptObject> listener) /*-{
		return $wnd.dojox.cometd
				.addListener(
						channel,
						function(message) {
							listener.@org.lutzmann.gwt.cometd.client.CometDListener::processMessage(Lcom/google/gwt/core/client/JavaScriptObject;)(message);
						});
	}-*/;

	public JavaScriptObject addMetaListener(MetaChannel metaChannel,
			CometDListener<? extends JavaScriptObject> listener) {
		return addListener(META_PREFIX + metaChannel.toString(), listener);
	}

	public native void removeListener(JavaScriptObject subscription) /*-{
		$wnd.dojox.cometd.removeListener(subscription);
	}-*/;

	public native JavaScriptObject subscribe(String channel,
			CometDListener<? extends JavaScriptObject> listener) /*-{
		return $wnd.dojox.cometd
				.subscribe(
						channel,
						function(message) {
							listener.@org.lutzmann.gwt.cometd.client.CometDListener::processMessage(Lcom/google/gwt/core/client/JavaScriptObject;)(message);
						});
	}-*/;

	public native void unsubscribe(JavaScriptObject subscription) /*-{
		$wnd.dojox.cometd.unsubscribe(subscription);
	}-*/;
	
	public void publish(String channel, JSONObject data) {
		publish(channel, data.toString());
	}

	private native void publish(String channel, String data) /*-{
		$wnd.dojox.cometd.publish(channel, data);
	}-*/;

	public native void startBatch() /*-{
		$wnd.dojox.cometd.startBatch();
	}-*/;

	public native void endBatch() /*-{
		$wnd.dojox.cometd.endBatch();
	}-*/;
}
