import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.beans.property.*;

public class countertest extends Application {
  private IntegerProperty n;

  public void start(Stage stage) {
    n = new SimpleIntegerProperty(0);
    Label counter = new Label();
    counter.textProperty().bind(n.asString());
    Group root = new Group(counter);
    Scene scene = new Scene(root);
    scene.setOnMousePressed(this::click);
    stage.setTitle("Counter");
    stage.setScene(scene);
    stage.show();
  }

  private void click(MouseEvent event) {
    n.set(n.get()+1);
  }
}