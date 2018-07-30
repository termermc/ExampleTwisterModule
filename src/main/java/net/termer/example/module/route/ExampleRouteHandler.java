package net.termer.example.module.route;

import net.termer.twister.handler.RouteHandler;
import spark.Request;
import spark.Response;

public class ExampleRouteHandler implements RouteHandler {

	public String handle(Request req, Response res, String[] wildcards) {
		// Send "Hello, " plus the first * in the route,
		// so for the route "/hello/*" and path "/hello/world"
		// this would send "Hello, world".
		return "Hello, "+wildcards[0];
	}
	
}