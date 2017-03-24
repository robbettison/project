/**
 *This is the graphics class. Created by @rob.
 *
 *
 *
 *
 */
import java.util.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.SequentialTransition;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.shape.*;
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
  IntegerProperty score = new SimpleIntegerProperty(0);
  Group root = new Group(canvas);
  Scene road = new Scene(root);
  Label playerScore = new Label();
  StackPane scorePane = new StackPane();
 // Group circle = new Group();
  Timeline timeL = new Timeline();


 // Circle circle1,circle2;
 //


 MGraphics(){

 }

  IntegerProperty getScore(){
    return this.score;
  }

  Scene getScene(){
    return this.road;
  }

  //put 4 new rand circle into circle group
    Group setCircle(int x, int y, int radius) {
      ArrayList<int> temp = new ArrayList<int>();

      Group circle = new Group();
      for (int i = 0; i < 4; i++) {
          //keep track of rand
          Circle newCircle= new Circle(x + i * 20, y, radius, Color.BLUEVIOLET);
          setRandCircle(newCircle, temp);
          circle.getChildren().add(newCircle);
      }
      return circle;

    }

     void setRandCircle(Circle circle, ArrayList<int> temp){
             circle.setFill(new ImagePattern(new Image(randImage(temp))));
     }


    void setUp(Stage stage) {
       // setCircle(140, -200, 20);
        playerScore.textProperty().bind(score.asString());
        scorePane.getChildren().addAll(whiteBox1, playerScore);
      //  root.getChildren().add(circle);

        root.getChildren().add(scorePane);

        stage.setScene(road);
    }




  void draw(int x) {
    g.drawImage(bg, 0, 0);
    g.drawImage(player, x,250);
  }

  void show(Stage stage) {
  	stage.show();
  }



     String randImage(ArrayList<int> temp){
         Random aa = new Random();
         int x = aa.nextInt(4);
         while (temp.contains(aa)){
             x=aa.nextInt(4);
         }
         temp.add(x);

         return getImage(x);

     }

     String getImage(int x){
         if (x == 0){
             return "0.png";
         }
         else if (x == 1){
             return "1.png";
         }
         else if (x==2){
             return "2.png";
         }
         else if (x==3){
             return "3.png";
         }
     }



     KeyFrame makeKeyFrame(int time, int scaleX, int scaleY, int endX, int endY, Node currentCircle){


             KeyFrame keyF = new KeyFrame(Duration.millis(time),
                     new KeyValue(currentCircle.scaleXProperty() , scaleX),
                     new KeyValue(currentCircle.scaleYProperty() , scaleY),
                     new KeyValue(currentCircle.translateXProperty(), endX),
                     new KeyValue(currentCircle.translateYProperty(), endY));

            return keyF;

     }

     Timeline makeTimeline(){
        Timeline tl = new Timeline();
        Group group = new Group();
        group = setCircle(140,-50,20);
        root.getChildren().add(group);
        int xChange = 0;
        for (Node node: group.getChildren()) {
            xChange += 50;
            tl.getKeyFrames().add(makeKeyFrame(2000,2,2,xChange,600,node));
        }

        return tl;
     }


    void circleAnimation(){

        SequentialTransition sequence = new SequentialTransition();
        for (int i = 0; i < 40; i++) {
            sequence.getChildren().add(makeTimeline());
        }
        sequence.play();

     }
}
