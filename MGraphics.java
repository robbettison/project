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
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.beans.property.*;
import javafx.scene.layout.*;


 public class MGraphics {

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

  MGraphics(int x) {
    score = new SimpleIntegerProperty(x);

  }
  IntegerProperty getScore(){
    return this.score;
  }

  Scene getScene(){
    return this.road;
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
