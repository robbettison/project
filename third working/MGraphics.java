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
import javafx.animation.FadeTransition;
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
 // Image bg = new Image("road.jpeg");
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
  Scene scene = new Scene(root);
  Label playerScore = new Label();
  StackPane scorePane = new StackPane();


    String[] roads = new String[3];



 MGraphics(){

 }

  IntegerProperty getScore(){
    return this.score;
  }

  Scene getScene(){
    return this.scene;
  }

  //put 4 new rand circle into circle group
    Group setCircle(int x, int y, int radius) {
      ArrayList<Integer> temp = new ArrayList<Integer>();

      Group circle = new Group();
      for (int i = 0; i < 4; i++) {
          //keep track of rand
          Circle newCircle= new Circle(x + i * 20, y, radius, Color.BLUEVIOLET);
          setRandCircle(newCircle, temp);
          circle.getChildren().add(newCircle);
      }
      return circle;

    }

     void setRandCircle(Circle circle, ArrayList<Integer> temp){
        circle.setFill(new ImagePattern(new Image(randImage(temp))));
     }


    void setUp(Stage stage) {
       // setCircle(140, -200, 20);
        playerScore.textProperty().bind(score.asString());
        scorePane.getChildren().addAll(whiteBox1, playerScore);
      //  root.getChildren().add(circle);

        root.getChildren().add(scorePane);

        stage.setScene(scene);
    }


     void draw(int x) {
   // g.drawImage(bg, 0, 0);
         g.drawImage(player, x,250);
     }

  void show(Stage stage) {
  	stage.show();
  }


//array to ensure 4 differnt rand
     String randImage(ArrayList<Integer> temp){
         Random aa = new Random();
         int x = aa.nextInt(4);
         while (temp.contains(x)){
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
         else
             return "3.png";

     }



     KeyFrame makeKeyFrame(int time, double scaleX, double scaleY, int endX, int endY, Node currentCircle){


             KeyFrame keyF = new KeyFrame(Duration.millis(time),
                     new KeyValue(currentCircle.scaleXProperty() , scaleX),
                     new KeyValue(currentCircle.scaleYProperty() , scaleY),
                     new KeyValue(currentCircle.translateXProperty(), endX),
                     new KeyValue(currentCircle.translateYProperty(), endY));

            return keyF;

     }

     Timeline makeCircleTimeline(int time){
        Timeline tl = new Timeline();
        Group group = new Group();
        group = setCircle(140,-50,10);
        root.getChildren().add(group);
        int xChange = 0;
        for (Node node: group.getChildren()) {
            xChange += 50;
            tl.getKeyFrames().add(makeKeyFrame(time,2.5,2.5,xChange,600,node));
        }
        return tl;
     }

//time so is quicker
    void circleAnimation(){

        SequentialTransition sequence = new SequentialTransition();
        int time = 5000;
        for (int i = 0; i < 40; i++) {
            sequence.getChildren().add(makeCircleTimeline(time));
            time -= 100;
        }
        //roadAnimation();

        SequentialTransition sequence1 = new SequentialTransition();
        int time1 = 7000;
        for (int i = 0; i < 3; i++) {
            sequence1.getChildren().add(makeRoadTimeLine(i));
            time1 -= 100;
        }

        sequence1.play();
        sequence.play();

     }

     Timeline makeRoadTimeLine(int n){

        Timeline tl = new Timeline();

        ImageView road = new ImageView(new Image("road" + n + ".jpeg"));
        root.getChildren().add(road);
        tl.getKeyFrames().add(makeKeyFrame(10000,1,1,0,0,road));

         return tl;

     }



/*

     void roadAnimation(){
        initRoad();
        ImageView imageview = new ImageView(new Image(road[0]));
        Group road = new Group();
        road.getChildren().add(imageview);
       for (int i = 0; i < 3; i++) {
            road.getChildren().add(makeRoadTimeLine(i));
       }
       road.play();

     }

     void initRoad(){
         for (int i = 0; i < 3; i++){
             roads[i] =  "road" + i +".jpeg";
             System.out.println(roads[i]);
         }
     }

     */



}
