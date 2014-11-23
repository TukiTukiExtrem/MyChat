package gui;

import java.io.IOException;

import main.MyChat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartScreenController implements EventHandler<ActionEvent> {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(MyChat.class);
	
	private StartScreen screen;
	
	public StartScreenController(StartScreen s) {
		this.screen = s;
	}

	@Override
	public void handle(ActionEvent e) {
		try {
			new Controller(screen.getIP(), Integer.parseInt(screen.getPort()), screen);
		} catch (NumberFormatException e1) {
			LOGGER.info("Ungueltiger Port");
			screen.setMeldung("Ungueltiger Port");
		} catch (IOException e1) {
			LOGGER.info("Fehler");
		e1.printStackTrace();
			screen.setMeldung("IO-Fehler");
		}		
	}
}
