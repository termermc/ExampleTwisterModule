package net.termer.example.module.handler;

import net.termer.twister.handler.PreRequestHandler;
import net.termer.twister.handler.PreRequestOptions;

public class WordBanningPreRequestHandler implements PreRequestHandler {

	public void handle(PreRequestOptions options) {
		// Cancel requests whose paths contain any or the following words:
		String[] bannedWords = {"python", "javascript", "php"};
		
		// Check if path contains any of the words
		for(String word : bannedWords) {
			if(options.getPath().contains(word)) {
				// Cancel the request if the word is found
				options.cancel("You're not allowed to include "+word+" in your path!");
			}
		}
	}
	
}
