package connection;

import gui.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import main.MyChat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Wortha Simon
 * @version 20141118
 * 
 *          Der Server der die Nachrichten des Seners empfängt
 *
 */
public class ChatServer implements Runnable {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(MyChat.class);

	int portNumber;
	String inputLine;
	private Controller con;
	

	/**
	 * @param portNumber
	 *            Angabe auf welchem Port die Verbindung laeuft
	 * @param c 
	 *            Es muss der Controller, welcher die GUI steuert uebergen werden, da sonst die
	 *            Nachricht nicht weitergegeben werden kann
	 */
	public ChatServer(int portNumber, Controller c) {
		this.portNumber = portNumber;
		this.con = c;
	}

	
	@Override
	public void run() {
		try (
		// Verbindungs auffbau
		ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				// bekommt die Nachricht vom Client
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			while ((inputLine = in.readLine()) != null) {
				con.changeArea("PARTNER: " + inputLine + "\n");
			}
		} catch (IOException e) {
			LOGGER.info("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			LOGGER.info("ungueltige Portnummer");
			System.exit(1);
		}
	}
}
