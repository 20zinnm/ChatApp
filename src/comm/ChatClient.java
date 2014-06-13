package comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	// Send message to server.
	public static void sendMessage(PrintWriter out, Scanner in, String message) {
		out.append(message);
		out.println();
		out.flush();
	}

	// Send exit message to server.
	public static void exit(PrintWriter out, Scanner in) {
		out.append("exit");
		out.println();
		out.flush();
	}

	// the command line args
	public static void main(String[] args) {

		// Logical Operators
		if (args == null || (args.length != 3)) {
			System.out.println("Run as : java Client host port username");
			System.exit(-1);
		}

		// Read server information.
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		String userName = args[2];

		System.out.println("Welcome, " + userName);

		// Input/Output
		PrintWriter out = null;
		Scanner in = null;

		try {
			Socket socket = new Socket(host, port);

			// Input/Output to socket strings
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new Scanner(socket.getInputStream());

			while (true) {
				// Check for input
				Scanner input = new Scanner(System.in);

				while (input.hasNextLine()) {

					String inputLine = input.nextLine();
					if (inputLine.equalsIgnoreCase("exit")) {

						System.out.println("Exiting chat...");
						Thread.sleep(3000);
						exit(out, input);
						System.exit(0);
					} else {

						String message = "message" + "," + userName + ","
								+ inputLine;
						sendMessage(out, input, message);
					}
					input.close();
				}
				break;

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}
}