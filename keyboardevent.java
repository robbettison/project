import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;



public class keyboardevent extends Application {
  private int n = 0;

  public void start (Stage stage) {
    Canvas canvas = new Canvas(400, 300);
    Group root = new Group(canvas);
    Scene road = new Scene(root);
    stage.setScene(road);
    GraphicsContext g =
      canvas.getGraphicsContext2D();
    draw(g, 175);
    stage.show();
    road.setOnKeyPressed(this::handle);
  }

  private void draw(GraphicsContext g, int x) {
    g.fillOval(x, 175, 50, 50);
  }

  public void handle(KeyEvent event) {
    if(event.getCode() == KeyCode.RIGHT) {
      System.out.println("RIGHT");
    }
    else if(event.getCode() == KeyCode.LEFT) {
      System.out.println("LEFT");
    }
  }
}
