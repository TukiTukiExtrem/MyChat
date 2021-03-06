package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Wortha Simon
 * 
 *         Die GUI zum Willkommen-Anzeigefenster
 *
 */
public class StartScreen extends Application {

	private GridPane grid;
	private Scene scene;
	private Text willkommen;
	private Label ip;
	private Label port;
	private Label user;
	private TextField iptext;
	private TextField porttext;
	private TextField usertext;
	private Button btn;
	private HBox hbBtn;
	private Text meldung;

	private StartScreenController con;

	private Stage stage;

	@Override
	public void start(Stage s) throws Exception {
		stage = s;
		stage.setTitle("Simon's Chat");
		stage.centerOnScreen();

		this.con = new StartScreenController(this);

		this.grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		this.scene = new Scene(grid, 510, 400);
		scene.getStylesheets().add(
				StartScreen.class.getResource("/style/Button.css")
						.toExternalForm());

		this.willkommen = new Text("Willkommen");
		willkommen.setId("willkommen");
		grid.add(willkommen, 0, 0, 2, 1);

		this.ip = new Label("IP Adresse:");
		grid.add(ip, 0, 1);

		this.iptext = new TextField();
		grid.add(iptext, 1, 1);

		this.port = new Label("Port:");
		grid.add(port, 0, 2);

		this.porttext = new TextField();
		grid.add(porttext, 1, 2);
		
		this.user = new Label("Benutzername:");
		grid.add(user, 0, 3);
		
		this.usertext = new TextField();
		grid.add(usertext, 1, 3);

		this.btn = new Button("zum Chat");
		this.hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 5);

		btn.setOnAction(con);

		this.meldung = new Text();
		grid.add(meldung, 1, 7);
		meldung.setId("meldung");

		stage.setOnCloseRequest(t -> System.exit(0));
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	/**
	 * startet startscreen => die Stage (das Fenster) öffnet sich
	 * 
	 * @param args
	 *            es muss nichts uebergeben werden
	 */
	public static void main(String[] args) {
		launch();
	}

	/**
	 * @return gibt die IP bzw. den Text im Texfield zurueck
	 */
	public String getIP() {
		return iptext.getText();
	}

	/**
	 * @return gibt den Port bzw. den Text im Texfield zurueck
	 */
	public String getPort() {
		return porttext.getText();
	}

	/**
	 * @param s
	 *            setzt die Stage auf eine neue Scene
	 */
	public void switchScene(Scene s) {
		this.stage.setScene(s);
		this.stage.setResizable(true);
	}

	/**
	 * @param s
	 *            setzt den Text Meldung auf den zu üebergebenden String
	 */
	public void setMeldung(String s) {
		this.meldung.setText(s);
	}
	
	public String getUser() {
		return usertext.getText();
	}
}
