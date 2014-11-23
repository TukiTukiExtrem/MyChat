package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import main.MyChat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Wortha Simon
 * @version 20141118
 * 
 *          Der Cient der die Nachrichten an den Server des EMpfaengers sendet
 *
 */
public class ChatClient {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(MyChat.class);

	String hostName;
	int portNumber;
	private Socket echoSocket;
	private PrintWriter out;

	/**
	 * Erstellt einen neuen Client
	 * 
	 * @param hostName
	 *            Die IP Adresse des Servers mit dem eine Verbindung aufgebaut
	 *            werden soll
	 * @param portNumber
	 *            Angabe auf welchem Port die Verbindung laeuft
	 */
	public ChatClient(String hostName, int portNumber) {
		this.hostName = hostName;
		this.portNumber = portNumber;
		this.connect();
	}

	private void connect() {
		try {
			// Verbindung zum Server
			this.echoSocket = new Socket(hostName, portNumber);
			// "leitet" Nachricht an den Server
			this.out = new PrintWriter(echoSocket.getOutputStream(), true);
		} catch (UnknownHostException e) {
			LOGGER.info("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			LOGGER.info("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}catch (Exception e) {
			LOGGER.info("Error");
			System.exit(1);
		}
	}

	/**
	 * @param msg
	 *            leitet die Nachricht (bzw. den String) and den Empfaenger
	 *            weiter.
	 */
	public void sendMessage(String msg) {
		this.out.println(msg);
	}
}