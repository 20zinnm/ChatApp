package messages;

import java.io.File;

public class Message {

	/*
	 *  Private keyword is for encapsulation.
	 */
	
	private String text;
	private File attachment;

	/*
	 * Message constructor takes text and will set it to the message variable in
	 * the class.
	 */

	public Message(String t) {
		text = t;
	}

	/*
	 * This is another constructor. It takes text and file and will set it to
	 * the corresponding veriables in the class.
	 */

	public Message(String t, File file) {
		text = t;
		attachment = file;
	}

	public String getText() {
		return text;
	}

	/*
	 * This is a bunny:
	 * (\_(\ 
	 * ( o.o) 
	 * o__(")(")
	 */

}
