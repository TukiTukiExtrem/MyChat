package gui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import message.Badwordfilter;
import message.ChatMessage;
import message.WriteAble;
import connection.ChatClient;
import connection.ChatServer;

/**
 * @author Wortha Simon
 * @version 20141118
 *
 *          Implementiert den Actionlistener für View, weiters werden die View,
 *          der Server und derClient hier gestartet
 */
public class Controller implements EventHandler<ActionEvent> {
	private ChatClient cc;
	private StartScreen screen;
	private String host;
	private int port;
	private ChatScreen chat;
	Button verbinden;
	Button senden;
	TextArea area;
	TextField nachricht;
	CheckBox paul;

	/**
	 * @param hostName
	 *            Die IP Adresse es Hosts mit dem sich verbunden werden moechte
	 * @param port
	 *            Der Port ueber dem die Verbindung laeuft
	 * @param s
	 *            Dem Controller muss der Startscreen uebergeben werden, damit
	 *            er der Stage eine neue scene uebergeben kann
	 * @throws IOException
	 */
	public Controller(String hostName, int port, StartScreen s)
			throws IOException {
		this.port = port;
		this.host = hostName;
		this.screen = s;

		this.chat = new ChatScreen();
		screen.switchScene(chat.getScene());

		verbinden = (Button) chat.getScene().lookup("#verbinden");
		verbinden.setOnAction(this);

		senden = (Button) chat.getScene().lookup("#senden");
		senden.setOnAction(this);

		area = (TextArea) chat.getScene().lookup("#chatarea");
		area.setWrapText(true);

		nachricht = (TextField) chat.getScene().lookup("#message");
		nachricht.setOnAction(this);

		paul = (CheckBox) chat.getScene().lookup("#filter");

		Thread server = new Thread(new ChatServer(port, this));
		server.start();
	}

	@Override
	public void handle(ActionEvent e) {
		if (e.getSource() == verbinden) {
			cc = new ChatClient(host, port, screen.getUser());
			senden.setDisable(false);
			nachricht.setDisable(false);
			verbinden.setDisable(true);
		}
		if (e.getSource() == senden || e.getSource() == nachricht) {
			cc.sendMessage(nachricht.getText());
			changeArea("Ich: " + nachricht.getText() + "\n");
			nachricht.setText("");
		}

	}

	/**
	 * Fuegt der Textarea neuen Text hinzu
	 * 
	 * @param text
	 *            String der in der Textarea angezegt werden soll
	 */
	public void changeArea(String text) {
		Platform.runLater(() -> {
			WriteAble message = new ChatMessage(text);
			if (paul.isSelected())
				message = new Badwordfilter(message);
			area.appendText(message.getString());
		});

	}
}
