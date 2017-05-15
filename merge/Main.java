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
  Group caterpillar = new Group();
  Group back = new Group();
  Scene scene = new Scene(root, 600, 700, Color.WHITE);
  Fruits allFruit;
  final LongProperty lastUpdateTime = new SimpleLongProperty();
  Player player;
  Background background;
  IntegerProperty score = new SimpleIntegerProperty(0);
  Label scoreboard = new Label();
  double time=0;
  Label timer = new Label();
  StopWatch ST = new StopWatch();
  AnimationSetup Background1;
  IntegerProperty T = new SimpleIntegerProperty(0);
  String currentFontFile = "CabinSketch-Bold.ttf";
  InputStream fontStream = Main.class.getResourceAsStream(currentFontFile);
  Font bgFont = Font.loadFont(fontStream, 36);
  Label TIME = new Label("Time:");
  Stage tempStage,backStage;
  Scene backScene;
  Soundtrack S = new Soundtrack();
  Cows cowField;
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
    scoreboard.setFont(bgFont);
    scoreboard.setTextFill(Color.YELLOW);
    TIME.setFont(bgFont);
    TIME.setTextFill(Color.GREEN);
    timer.setFont(bgFont);
    timer.setTextFill(Color.GREEN);
    timer.textProperty().bind(T.asString());
    TIME.setTranslateX(100);
    timer.setTranslateX(200);
    root.getChildren().addAll(back, fruit, caterpillar);
    player = new Player(caterpillar, scene, fruit);
    allFruit = new Fruits(4, fruit);
    Background1 = new AnimationSetup("pic/Main_Project_File_output", "png", 607, 1080, 30, back);
    //background = new Background(root);
    root.getChildren().addAll(scoreboard, timer, TIME);
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

	tempStage.setScene(lb.leaderBoardShow());
	tempStage.show();


  }

  AnimationTimer beginFruit = new AnimationTimer() {
    public void handle(long now) {
       //System.out.println(now/1000000000);
       if(lastUpdateTime.get()>0) {
         final double elapsedTime = (now - lastUpdateTime.get()) / 10000000;
         if(ST.isRunning()) T.set((int)ST.UpdateTimer()/1000);
         else ST.start();
         player.updateCaterpillarAnimation(elapsedTime, 1/allFruit.getQuestionMomentum());
         Background1.updateAnimation(elapsedTime, 1/allFruit.getQuestionMomentum());
         allFruit.updatePositions(elapsedTime, player, score, S);
         cowField.updateCow(elapsedTime);
        	 if (allFruit.isEnd()){
			beginFruit.stop();
			switchToLeaderBoard();

	 	}
       }
       lastUpdateTime.set(now);
    }
  };


}
