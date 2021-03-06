package gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * @author Wortha Simon
 * 
 * Die GUI zu dem Chat-Anzeigefenster
 *
 */
public class ChatScreen {
	
	Parent root;
	Scene scene;

	/**
	 * holte sich alle Anzeige Felder von einem FXML-File und uebergibt sie einer scene
	 * 
	 * @throws IOException
	 */
	public ChatScreen() throws IOException {
		this.root = FXMLLoader.load(getClass().getResource("/style/chat.fxml"));

		this.scene = new Scene(root, 510, 400);
	}

	/**
	 * @return gibt die scene zurück, da diese in der Stage verwendet werden kann
	 */
	public Scene getScene() {
		return scene;
	}
}
