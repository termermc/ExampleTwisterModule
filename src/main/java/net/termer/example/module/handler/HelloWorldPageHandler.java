package net.termer.example.module.handler;

import spark.Request;
import spark.Response;

import java.io.IOException;

import net.termer.twister.Twister;
import net.termer.twister.handler.RequestHandler;
import net.termer.twister.utils.Domain;

public class HelloWorldPageHandler implements RequestHandler {

	@Override
	public String handle(Request req, Response res) {
		// A good way to start a document is to make an empty String
		// and start adding to it.
		String r = "";
		
		// When displaying a page with a reuqest handler, it is
		// a good idea to make it blend in with static pages, so
		// that your site doesn't look half-baked.
		// A way this can be done is loading your domain's top
		// and bottom, ensuring it has the same layout as static pages.
		
		// You can instantiate a new Domain class to get data about
		// a domain. Below a new Domain is instantiated for the
		// configured default domain.
		Domain domain = new Domain(Twister.current().getDefaultDomain());
		
		// First check if the domain has a top
		if(domain.hasTop()) {
			// Then add it to the String
			try {
				// Using getProcessedTop() rather than getTop() ensures
				// that the top gets run through any registered
				// DocumentProcessors, ensuring the same output
				// as would be rendered on a static document
				
				r += domain.getProcessedTop(req, res);
			} catch (IOException e) {
				// If reading the domain's top file fails, print an error message
				
				Twister.current().logError("Failed to render domain top");
				e.printStackTrace();
			}
		}
		
		// Now that the top is rendered, you can add some content!
		
		r += "<h1>Hello World</h1>";
		
		// Now we render the domain's bottom, if any
		if(domain.hasBottom()) {
			try {
				r += domain.getProcessedBottom(req, res);
			} catch (IOException e) {
				Twister.current().logError("Failed to render domain bottom");
				e.printStackTrace();
			}
		}
		
		// Returns the words "Hello World" as a header, sandwiched between
		// the default domain's top and bottom, if any
		return r;
	}
	
}
