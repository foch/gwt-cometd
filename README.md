gwt-cometd
==========

A GWT module that wraps the CometD JavaScript client.


Installation
------------

Clone the repository and import the `gwt-cometd` project into your Eclipse workspace. Then add the `gwt-cometd`
project to the build path of your GWT module.

Add the following entry to the `.gwt.xml` file of your GWT module:

	<inherits name="org.lutzmann.gwt.cometd.gwtcometd"/>


Usage
-----

### Configuration & Instantiation

	CometDConfiguration config = new CometDConfiguration("http://127.0.0.1:8080/cometd");
	config.setLogLevel(LogLevel.debug);
	...

	CometD cometd = new CometD(config);


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


### Message batching

	cometd.startBatch();
	...
	cometd.endBatch();

NOTE: Do not forget to call `endBatch()` after a call to `startBatch()`!


### Unregister transport

	cometd.unregisterTransport(Transport.websocket);
