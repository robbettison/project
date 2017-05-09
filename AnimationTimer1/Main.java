import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.*;
import java.util.EventListener.*;
import javafx.animation.*;
import javafx.beans.property.*;
import java.util.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.scene.text.Font;

public class Main{

  Group root = new Group();
  Group fruit = new Group();
  Scene scene = new Scene(root, 500, 700, Color.WHITE);
  Fruits allFruit;
  final LongProperty lastUpdateTime = new SimpleLongProperty();
  Player player;
  Background background;
  IntegerProperty score = new SimpleIntegerProperty(0);
  Label scoreboard = new Label();

  /*public void start(Stage stage) {
    stage.show();
    beginFruit.start();
  }*/

  Scene setUp(Stage stage) {

    scoreboard.textProperty().bind(score.asString());
    root.getChildren().add(fruit);
    allFruit = new Fruits(4, fruit);
    player = new Player(root, scene, fruit);
    background = new Background(root);
    root.getChildren().add(scoreboard);
    stage.setScene(scene);

    return scene;
  }

  void show(Stage stage) {
    stage.show();
    beginFruit.start();
  }


  AnimationTimer beginFruit = new AnimationTimer() {
    public void handle(long now) {
       if(lastUpdateTime.get()>0) {
         final double elapsedTime = (now - lastUpdateTime.get()) / 10000000;
         allFruit.updatePositions(elapsedTime, player, score);
       }
       lastUpdateTime.set(now);
    }
  };
}
