gwt-cometd
==========

A GWT module that wraps the CometD JavaScript client.


Installation
------------

Add the following entries to the .gwt.xml file of your GWT module:

	<inherits name="org.lutzmann.gwt.cometd.gwtcometd"/>

Then add the latest gwt-cometd JAR to the classpath of your GWT module.


Usage
-----

### Instantiation

	CometD cometd = new CometD();


### Configuration

	CometDConfiguration config = new CometDConfiguration("http://127.0.0.1:8080/cometd");
	config.setLogLevel(LogLevel.debug);
	...
	cometd.configure(config);


### Add and remove listeners

	Subscription connectSubscription = cometd.addMetaListener(MetaChannel.connect,
				new CometDListener<BayeuxMessage>() {
					@Override
					public void processMessage(BayeuxMessage message) {
						if (message.isSuccessful()) {
							// connected
							...
						} else {
							// disconnected
							...
						}
					}
				});
	...
	cometd.removeListener(connectSubscription);


### Handshake

	cometd.handshake();


### Subscribe and unsubscribe

	Subscription newsSubscription = cometd.subscribe("/latestnews",
				new CometDListener<BayeuxMessage>() {
					@Override
					public void processMessage(BayeuxMessage message) {
						// process news
						...
					}
				});
	...
	cometd.unsubscribe(newsSubscription);


### Publish

It is possible to publish data as a JSONObject:

	JSONObject data = new JSONObject();
	data.put("quote", new JSONNumber(1.2092));
	
	cometd.publish("/FX/EURCHF", data);
