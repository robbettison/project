/*created by Jiafeng Zhong*/
import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.beans.property.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class MMenu extends Application{


	private void draw(GraphicsContext g, Image bg) {
	    g.drawImage(bg, 0, 0);
	}

	Button createButton(String name){
		Button button = new Button(name);
		return button;
	}


	public void start (Stage stage){

		Canvas canvas = new Canvas(400, 300);
		Image bg = new Image("Bug.png");
		//ImageView bgView = new ImageView(bg);

		Group root = new Group(canvas);

		Label gameName = new Label("BUG BITS");


		String[] name = {"Start", "Instructions", "Leader Board", "Quit"};

		// set four buttons
		List<Button> buttonList = new ArrayList<Button>();

		for(String s: name){
			Button b = createButton(s);
			buttonList.add(b);
		}

		// set style
		String cssButton = "-fx-border-radius: 20.0;-fx-background-color: green;"
					+ "-fx-background-radius: 20;"
					+ "-fx-border-color: white;";
		for(int i=0;i<name.length;i++){
			buttonList.get(i).setStyle(cssButton);
		}
		gameName.setStyle("-fx-font-size: 80px;-fx-text-fill: greenyellow;");

		// set vertical layout of buttons
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.getChildren().addAll(buttonList);
		vbox.setAlignment(Pos.CENTER);
		root.getChildren().add(vbox);

		// set horizontal layout off buttons
		HBox hbox = new HBox();
		hbox.getChildren().add(gameName);
		hbox.setAlignment(Pos.CENTER);
		root.getChildren().add(hbox);


		// put all into BorderPane and then put into parent root
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(vbox);
		borderPane.setTop(hbox);
		root.getChildren().add(borderPane);


		Scene scene = new Scene(root);
		stage.setTitle("Bug Bits!");
		stage.setScene(scene);
	 	GraphicsContext g = canvas.getGraphicsContext2D();
   	    draw(g, bg);
		stage.show();
	}


}