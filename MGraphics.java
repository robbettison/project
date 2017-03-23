/**
 *This is the graphics class. Created by @star》》rob.
 *
 *
 *
 *
 */
import java.util.*;
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
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;



 public class MGraphics {

  Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  Image ball = new Image("ball1.png");

  //deck.add(new Image("player.png"));
  //Image[] balls = new Image[2];
  //ystem.out.println(getClass().getResource("ball1.png"));
  //balls[0] = Toolkit.getDefaultToolkit().createImage("ball1.png")



 // ImageView ball1 = new ImageView(ball);
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane ballPane = new StackPane();
  IntegerProperty score;
  Group root = new Group(canvas);
  Scene road = new Scene(root);
  Label playerScore = new Label();
  StackPane scorePane = new StackPane();
  Circle[] circles = new Circle[4];


 // Circle circle1,circle2;
 //

 String randImage(){
  Random aa = new Random();
  int x = aa.nextInt(2);

  if (x == 0){
    return "ball1.png";
  }
  else return "player.png";
 }



  MGraphics(int x) {
    score = new SimpleIntegerProperty(x);

  }
  IntegerProperty getScore(){
    return this.score;
  }

  Scene getScene(){
    return this.road;
  }

  void setCircle(int x, int y, int radius){
    for(int i=0;i<4;i++) {
      circles[i] = new Circle(x+i*100-100, y, radius, Color.BLUEVIOLET);
      //circles[].add(circle);
    }
    // circle1 = new Circle(x, y, radius, Color.BLUEVIOLET);
    // circle2 = new Circle(x+ 40, y, radius, Color.BLUEVIOLET);
    // circle[2] = new Circle(x + 80, y, radius, Color.BLUEVIOLET);
    // circle[3] = new Circle(x + 120, y, radius, Color.BLUEVIOLET);
  }

  void setUp(Stage stage) {
    setCircle(140, 150, 20);
    playerScore.textProperty().bind(score.asString());
    scorePane.getChildren().addAll(whiteBox1, playerScore);


    setRandCircle();

    // ballPane.getChildren().addAll(ball1, scorePane);

    root.getChildren().add(scorePane);

    stage.setScene(road);
  }

  void setRandCircle(){
      for(int i=0;i<4;i++) {
      root.getChildren().add(circles[i]);
      circles[i].setFill(new ImagePattern(new Image(randImage())));
    }
  }



  void draw(int x) {
    g.drawImage(bg, 0, 0);
    g.drawImage(player, x,250);
  }

  void show(Stage stage) {
  	stage.show();
  }

}
