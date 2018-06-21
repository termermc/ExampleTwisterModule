package net.termer.example.module;

import net.termer.example.documents.ExampleDocumentProcessor;
import net.termer.example.module.handler.FormPageHandler;
import net.termer.example.module.handler.FormPostHandler;
import net.termer.example.module.handler.HelloWorldPageHandler;
import net.termer.example.module.handler.ShutdownPageHandler;
import net.termer.twister.Twister;
import net.termer.twister.module.ModulePriority;
import net.termer.twister.module.TwisterModule;
import net.termer.twister.utils.Method;

/**
 * 
 * This is the class that contains the methods
 * executed by Twister.
 * In each module jar, Twister looks for a class
 * called "Module" that implements TwisterModule
 * and registers it as a module.
 *
 */
public class Module implements TwisterModule {
	
	private ExampleDocumentProcessor exampleDocProcessor = new ExampleDocumentProcessor();
	
	@Override
	public void initializeModule(Twister instance) {
		// Initialize the module, and get
		// the instance of the server.
		// Here RequestHandlers can be registered
		// and other startup functions.
		
		instance.addRequestHandler(
				// Returns the default domain
				// as defined in twister.ini
				instance.getDefaultDomain(),
				// The path to handle
				"/hello/",
				// The RequestHandler
				new HelloWorldPageHandler(),
				// The request method to handle
				Method.GET);
		
		instance.addRequestHandler(
				instance.getDefaultDomain(),
				"/shutdown/",
				new ShutdownPageHandler(),
				Method.GET);
		
		instance.addRequestHandler(
				instance.getDefaultDomain(),
				"/",
				new FormPageHandler(),
				Method.GET);
		
		instance.addRequestHandler(
				instance.getDefaultDomain(),
				"/",
				new FormPostHandler(),
				// Handle the POST of /
				Method.POST);
		
		// Register DocumentProcessors
		// DocumentProcessors have the ability to manipulate
		// static documents before they get sent to the browser
		instance.addDocumentProcessor(instance.getDefaultDomain(), exampleDocProcessor);
		
		// Registering DocumentProcessors with addDocumentProcessor() only applies
		// to the actual documents, not the domain top and bottom rendered around
		// the documents. To register a DocumentProcessor for a domain's top or bottom,
		// use addTopDocumentProcessor() and addBottomDocumentProcessor(), respectively
		
		
		instance.logInfo("I am the Example Module, and I am starting up!");
	}
	
	@Override
	public String moduleName() {
		// Return the name of the module
		
		return "Example Module";
	}
	
	@Override
	public int modulePriority() {
		// Return the module loading priority
		
		return ModulePriority.MEDIUM;
	}
	
	@Override
	public void shutdownModule() {
		// When the module is shutdown,
		// remove all RequestHandlers.
		// Shutdown is a good time to save
		// files and other such things as well.
		
		Twister.current().removeRequestHandler(
				Twister.current().getDefaultDomain(),
				"/hello/",
				Method.GET);
		
		Twister.current().removeRequestHandler(
				Twister.current().getDefaultDomain(),
				"/shutdown/",
				Method.GET);
		
		Twister.current().removeRequestHandler(
				Twister.current().getDefaultDomain(),
				"/",
				Method.GET);
		
		Twister.current().removeRequestHandler(
				Twister.current().getDefaultDomain(),
				"/",
				Method.POST);
		
		// Unregister DocumentProcessors
		
		Twister.current().removeDocumentProcessor(Twister.current().getDefaultDomain(), exampleDocProcessor);
		
		
		// Twister.current() returns the
		// current instance of Twister.
		Twister.current().logInfo("I am the Example Module, and I am shutting down!");
	}
	
	@Override
	public double twiserVersion() {
		// Return the version of Twister
		// that this module is designed for.
		
		return 0.2;
	}
	
}
