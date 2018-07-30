package net.termer.example.module.handler;

import spark.Request;
import spark.Response;
import net.termer.twister.handler.RequestHandler;

public class FormPageHandler implements RequestHandler {

	public String handle(Request req, Response res) {
		// Send a form
		return "<form method=\"POST\">"+
				"<input type=\"text\" name=\"text\">"+
				"<input type=\"submit\">"+
				"</form>";
	}
	
}
