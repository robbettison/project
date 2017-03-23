import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;


public class Instructions {

	Group root = new Group();
	Stage stage = new Stage();

	Scene instructionShow() {
		Scene scene = new Scene(root, 400, 300, Color.GREEN);
		scene.nitStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
	 	//stage.show();
	 	return scene;
	}
}