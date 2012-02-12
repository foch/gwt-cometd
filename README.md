gwt-cometd
==========

A GWT module that wraps the CometD JavaScript client.


Installation
------------

Add the following entry to the .gwt.xml file of your GWT module:

	<inherits name="org.lutzmann.gwt.cometd.gwtcometd"/>

Then add the latest gwt-cometd JAR to the classpath of your GWT module.


Usage
-----

Instantiation:

	CometD cometd = new CometD();


Configuration:

	CometDConfiguration config = new CometDConfiguration("http://127.0.0.1:8080/cometd");
	config.setLogLevel(LogLevel.debug);
	...
	cometd.configure(config);


Add and remove listeners:

	JavaScriptObject metaListener = cometd.addListener("/meta/*", new CometDListener<BayeuxMessage>() {
			@Override
			public void processMessage(BayeuxMessage message) {
				// do something useful here
			}
		});
	...
	cometd.removeListener(metaListener);


Handshake:

	cometd.handshake();


Subscribe and unsubscribe:

	JavaScriptObject subscription = cometd.subscribe("/latestnews",
				new CometDListener<JavaScriptObject>() {
					@Override
					public void processMessage(JavaScriptObject jso) {
						// do something useful here
					}
				});
	...
	cometd.unsubscribe(subscription);


Publish:

	cometd.publish("/chat", <JavaScriptObject>);
