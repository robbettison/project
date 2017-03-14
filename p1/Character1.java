import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;


public class Character1 extends Application {
  public void start (Stage stage) {
    Image character = new Image("caterpillar.jpg");
    /*try .png for image?*/
    ImageView view = new ImageView(character);
    Group root = new Group(view);
    Scene road = new Scene(root);
    stage.setTitle("caterpillar!");
    stage.setScene(road);
    stage.show();
  }
}
