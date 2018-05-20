package net.termer.example.module.handler;

import spark.Request;
import spark.Response;
import net.termer.twister.handler.RequestHandler;

public class FormPostHandler implements RequestHandler {

	@Override
	public String handle(Request req, Response res) {
		// Print the value of the input, if not null or blank
		
		String r = "<h1>Your input</h1>";
		
		if(req.queryParams("text")==null) {
			r+="<i>You did not send any input</i>";
		} else {
			if(req.queryParams("text").length() > 0) {
				r+="<p>"+req.queryParams("text")+"</p>";
			} else {
				r+="<i>Your input is blank</i>";
			}
		}
		
		return r;
	}
	
}
