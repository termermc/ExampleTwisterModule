package net.termer.example.documents;

import net.termer.twister.document.DocumentProcessor;
import net.termer.twister.document.HTMLDocumentResponse;
import spark.Request;
import spark.Response;

// This class is an implementation of a DocumentProcessor - a special
// type of "handler" that gets called when Twister loads a static
// document. It can manipulate static documents before they get
// sent to the browser.
public class ExampleDocumentProcessor implements DocumentProcessor {
	
	public void process(HTMLDocumentResponse doc, Request req, Response res) {
		// Replace all instances of "%name" in static documents with "John Doe"
		doc.replace("%name", "John Doe");
		
		// Replace all instances of "%ip" in static documents with the browser's IP address
		doc.replace("%ip", req.ip());
		
		// Replace all instances of "%path" in static documents with the document's path
		doc.replace("%path", doc.getPath());
	}
	
}
