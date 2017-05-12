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
  Group back = new Group();
  Group caterpillar = new Group();
  Scene scene = new Scene(root, 500, 700, Color.WHITE);
  Fruits allFruit;
  final LongProperty lastUpdateTime = new SimpleLongProperty();
  Player player;

  IntegerProperty score = new SimpleIntegerProperty(0);
  Label scoreboard = new Label();
  Stage tempStage,backStage;
  Scene backScene;
  AnimationSetup Background1;




  /*public void start(Stage stage) {
    stage.show();
    beginFruit.start();
  }*/

  public Main (Stage stage, Scene scene){
	backStage = stage;
	backScene = scene;

  }

  Scene setUp(Stage stage) {
    scoreboard.textProperty().bind(score.asString());

    root.getChildren().addAll(back,fruit,caterpillar);
    allFruit = new Fruits(4, fruit);
    player = new Player(caterpillar, scene, fruit);
  Background1 = new AnimationSetup("pic/Road_anim_3d_", "png", 607, 1080, 30, back);

    root.getChildren().addAll(scoreboard);
    stage.setScene(scene);

    return scene;
  }

  void show(Stage stage) {
    stage.show();
    tempStage = stage;
    beginFruit.start();
    
  }


  void switchToLeaderBoard(){

	Stage stage = new Stage();
	LeaderBoard lb = new LeaderBoard(backScene,backStage,500,700);
	Label lblabel = new Label(lb.readFile());
	lb.scroll(lblabel);
	tempStage.setScene(lb.leaderBoardShow());
	tempStage.show();


  }


  AnimationTimer beginFruit = new AnimationTimer() {
    public void handle(long now) {
       if(lastUpdateTime.get()>0) {
         final double elapsedTime = (now - lastUpdateTime.get()) / 10000000;
         player.updateCaterpillarAnimation(elapsedTime);
         Background1.updateAnimation(elapsedTime);
boolean check = allFruit.updatePositions(elapsedTime, player, score);

         if ( check== false){

	 	beginFruit.stop();
                switchToLeaderBoard();
		}


       }
       lastUpdateTime.set(now);
    }

  };
  
}
