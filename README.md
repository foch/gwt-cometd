gwt-cometd
==========

A GWT module that wraps the [CometD](http://cometd.org/) JavaScript client library.


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

	Subscription quoteSubscription = cometd.subscribe("/FX/EURCHF",
				new CometDListener<BayeuxMessage>() {
					@Override
					public void processMessage(BayeuxMessage message) {
						JSONObject data = new JSONObject(message.getData());
						
						JSONNumber bid = (JSONNumber) data.get("bid");
						JSONNumber ask = (JSONNumber) data.get("ask");
						
						...
					}
				});
	
	...
	
	cometd.unsubscribe(quoteSubscription);


### Publish

	JSONObject data = new JSONObject();
	data.put("bid", new JSONNumber(1.2011));
	data.put("ask", new JSONNumber(1.2014));
	
	cometd.publish("/FX/EURCHF", data.getJavaScriptObject());


### Message batching

	cometd.startBatch();
	...
	cometd.endBatch();

NOTE: Do not forget to call `endBatch()` after a call to `startBatch()`!


### Unregister transport

	cometd.unregisterTransport(Transport.websocket);


For details on the described methods here have a look at the excellent [CometD Reference Manual](http://docs.cometd.org/reference/#javascript).


Contributions
-------------

* Bernhard Lutzmann - project lead
* Ondrej Galik - contributed code to switch to JQuery bindings
* Julien Faucher

Thanks!