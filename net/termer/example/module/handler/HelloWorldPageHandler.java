package net.termer.example.module.handler;

import spark.Request;
import spark.Response;
import net.termer.twister.handler.RequestHandler;

public class HelloWorldPageHandler implements RequestHandler {

	@Override
	public String handle(Request req, Response res) {
		// Returns the words "Hello World" as a header.
		return "<h1>Hello World</h1>";
	}
	
}
