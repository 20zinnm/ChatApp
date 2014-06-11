package app;

import java.io.File;

import messages.Message;

import comm.ChatClient;

/*
 *  This class is for the main chat application.
 */

public class ChatApp {

	/*
	 * This is the first method which will be called when we run the java
	 * application.
	 */

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\Meyer Zinn\\Desktop\\EclipseWorkspace\\ChatApp\\abc.txt");
		Message message = new Message("\n(\\_(\\\n( o.o)\no__(\")(\")", file);

		System.out.println("I am sending: " + message.getText());
		System.out.println("I am also sending the file '" + file.getName() +"' located at: '" + file.getPath() + "'");
		ChatClient client = new ChatClient();
		client.send(message);

	}

}
