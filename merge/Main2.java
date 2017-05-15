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

public class Main2{

  Group root = new Group();
  Group fruit = new Group();
  Group back = new Group();
  Group caterpillar = new Group();
  Scene scene = new Scene(root, 500, 700, Color.WHITE);
  Fruits2 allFruit;
  final LongProperty lastUpdateTime = new SimpleLongProperty();
  Player2 player;

  IntegerProperty score = new SimpleIntegerProperty(0);
  Label scoreboard = new Label();
  Stage tempStage,backStage;
  Scene backScene;
  AnimationSetup2 Background1;

  String currentFontFile = "CabinSketch-Bold.ttf";
  InputStream fontStream = Main2.class.getResourceAsStream(currentFontFile);
  Font bgFont = Font.loadFont(fontStream, 36);
  Soundtrack S = new Soundtrack();

  Cows cowField;


  /*public void start(Stage stage) {
    stage.show();
    beginFruit.start();
  }*/

  public Main2 (Stage stage, Scene scene){
	backStage = stage;
	backScene = scene;

  }

  Scene setUp(Stage stage) {
    scoreboard.textProperty().bind(score.asString());
    scoreboard.setFont(bgFont);
    scoreboard.setTextFill(Color.YELLOW);

    root.getChildren().addAll(back,fruit,caterpillar);
    allFruit = new Fruits2(4, fruit);
    player = new Player2(caterpillar, scene, fruit);
  Background1 = new AnimationSetup2("pic/Main_Project_File_output", "png", 607, 1080, 30, back);

    root.getChildren().addAll(scoreboard);
    cowField = new Cows(root);
    stage.setScene(scene);

    return scene;
  }

  void show(Stage stage) {
    stage.show();
    tempStage = stage;
    S.backgroundMusic();
    beginFruit.start();
    
  }


  void switchToLeaderBoard(){

	S.stopbackgroundMusic();
	Stage stage = new Stage();
	LeaderBoard lb = new LeaderBoard(backScene,backStage,500,700);
	lb.setSc(score.get());
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
cowField.updateCow(elapsedTime);
         if ( check== false){

	 	beginFruit.stop();
                switchToLeaderBoard();
		}


       }
       lastUpdateTime.set(now);
    }

  };
  
}
