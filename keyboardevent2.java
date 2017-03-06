import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;



public class keyboardevent2 extends Application {
  private int n = 0;
  int x=175;
  Canvas canvas = new Canvas(400, 300);
  GraphicsContext g = canvas.getGraphicsContext2D();

  public void start (Stage stage) {
    Group root = new Group(canvas);
    Scene road = new Scene(root);
    stage.setScene(road);
    draw(g, x);
    stage.show();
    road.setOnKeyPressed(this::handle);
  }

  private void draw(GraphicsContext g, int x) {
    g.fillOval(x, 175, 50, 50);
  }



  public void handle(KeyEvent event) {
    if(event.getCode() == KeyCode.RIGHT) {
      System.out.println("RIGHT");
      x+=50;
      g.clearRect(0, 0, 400, 300);
      draw(g, x);
    }
    else if(event.getCode() == KeyCode.LEFT) {
      System.out.println("LEFT");
      x-=50;
      g.clearRect(0, 0, 400, 300);
      draw(g, x);
    }
  }
}
