package net.termer.example.module.handler;

import spark.Request;
import spark.Response;
import net.termer.twister.Twister;
import net.termer.twister.handler.RequestHandler;

public class ShutdownPageHandler implements RequestHandler {

	@Override
	public String handle(Request req, Response res) {
		// Shutdown Twister and return an empty String,
		// as the server will be shutdown before the
		// response arrives.
		
		Twister.current().shutdown();
		
		return "";
	}
	
}
