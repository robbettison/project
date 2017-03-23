/**
 *This is the graphics class. Created by @rob.
 *
 *
 *
 *
 */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.beans.property.*;


public class Graphics {

  Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane stackPane = new StackPane();
  IntegerProperty score;
  Group root = new Group(canvas);
  Scene road = new Scene(root);
  Label playerScore = new Label();
  StackPane stack = new StackPane();

  Graphics(int x) {
    score = new SimpleIntegerProperty(x);

  }

  void setUp(Stage stage) {
    playerScore.textProperty().bind(score.asString());
    stack.getChildren().addAll(whiteBox1, playerScore);
    root.getChildren().add(stack);
    stage.setScene(road);
  }

  void draw(int x) {
    g.drawImage(bg, 0, 0);
    g.drawImage(player, x,175);
  }

  void show(Stage stage) {
  	stage.show();
  }
}