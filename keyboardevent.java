import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent.*;



public class keyboardevent extends Application {
  private int n = 0;

  public void start (Stage stage) {
    Canvas canvas = new Canvas(400, 300);
    Group root = new Group(canvas);
    Scene road = new Scene(root);
    stage.setScene(road);
    GraphicsContext g =
      canvas.getGraphicsContext2D();
    draw(g);
    stage.show();
    road.setOnKeyPressed(this::arrow);
  }

  private void draw(GraphicsContext g) {
    g.fillOval(175, 175, 50, 50);
  }

  private void arrow(KeyEvent event) {
    String keypressed = event.getKeyCode();
    System.out.println(keypressed);
  }
}
