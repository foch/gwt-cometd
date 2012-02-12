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

public class BayeuxMessage extends JavaScriptObject {

	protected BayeuxMessage() {
	}

	public final native String getChannel() /*-{
		return this.channel;
	}-*/;

	public final native String getVersion() /*-{
		return this.version;
	}-*/;

	public final native String getMinimumVersion() /*-{
		return this.minimumVersion;
	}-*/;

	public final native String getSupportedConnectionTypes() /*-{
		return this.supportedConnectionTypes;
	}-*/;

	public final native String getClientId() /*-{
		return this.clientId;
	}-*/;

	public final native String getConnectionType() /*-{
		return this.connectionType;
	}-*/;

	public final native String getId() /*-{
		return this.id;
	}-*/;

	public final native String getTimestamp() /*-{
		return this.timestamp;
	}-*/;
	
	public final JSONObject getData() {
		return new JSONObject(getDataAsJavaScriptObject());
	}

	private final native JavaScriptObject getDataAsJavaScriptObject() /*-{
		return this.data;
	}-*/;

	public final native boolean isSuccessful() /*-{
		return this.successful;
	}-*/;

	public final native String getSubscription() /*-{
		return this.subscription;
	}-*/;

	public final native String getError() /*-{
		return this.error;
	}-*/;

	public final native String getExt() /*-{
		return this.ext;
	}-*/;
}
