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

public class CometDConfiguration {

	private final String url;

	private LogLevel logLevel = LogLevel.info;

	private int maxConnections = 2;

	private int backoffIncrement = 1000;

	private int maxBackoff = 60000;

	private boolean reverseIncomingExtensions = true;

	private int maxNetworkDelay = 10000;

	private boolean appendMessageTypeToUrl = true;

	private boolean autoBatch = false;

	public CometDConfiguration(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public String getLogLevel() {
		return logLevel.toString();
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public int getBackoffIncrement() {
		return backoffIncrement;
	}

	public int getMaxBackoff() {
		return maxBackoff;
	}

	public boolean isReverseIncomingExtensions() {
		return reverseIncomingExtensions;
	}

	public int getMaxNetworkDelay() {
		return maxNetworkDelay;
	}

	public boolean isAppendMessageTypeToUrl() {
		return appendMessageTypeToUrl;
	}

	public boolean isAutoBatch() {
		return autoBatch;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	public void setBackoffIncrement(int backoffIncrement) {
		this.backoffIncrement = backoffIncrement;
	}

	public void setMaxBackoff(int maxBackoff) {
		this.maxBackoff = maxBackoff;
	}

	public void setReverseIncomingExtensions(boolean reverseIncomingExtensions) {
		this.reverseIncomingExtensions = reverseIncomingExtensions;
	}

	public void setMaxNetworkDelay(int maxNetworkDelay) {
		this.maxNetworkDelay = maxNetworkDelay;
	}

	public void setAppendMessageTypeToUrl(boolean appendMessageTypeToUrl) {
		this.appendMessageTypeToUrl = appendMessageTypeToUrl;
	}

	public void setAutoBatch(boolean autoBatch) {
		this.autoBatch = autoBatch;
	}
}
