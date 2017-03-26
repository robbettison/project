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
  Image bg = new Image("road0.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  Image ball = new Image("ball1.png");

  BackgroundImage bi = new BackgroundImage(bg, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);


  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane ballPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);
  Group root = new Group(canvas);
  Scene scene = new Scene(root);
  Label playerScore = new Label();
  StackPane scorePane = new StackPane();


  Pane road = new Pane();



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


    Scene setUp(Stage stage) {
       // setCircle(140, -200, 20);
        playerScore.textProperty().bind(score.asString());
        scorePane.getChildren().addAll(whiteBox1, playerScore);
      //  root.getChildren().add(circle);
        scorePane.setBackground(new Background(bi));
        root.getChildren().add(scorePane);

        stage.setScene(scene);
        return scene;
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
        sequence.setCycleCount(sequence.INDEFINITE);
        roadAnimation();

        sequence.play();
     }




     Timeline makeRoadTimeLine(int n){

        Timeline tl = new Timeline();

        ImageView road = new ImageView(new Image("road" + n + ".jpeg"));
        root.getChildren().add(road);
        tl.getKeyFrames().add(makeKeyFrame(n*1000,1,1,0,0,road));

         return tl;

     }





     void roadAnimation(){


        SequentialTransition seq = new SequentialTransition();
        ImageView[] slides = makeRoadImageViews();

        for (ImageView image: slides){
         //   PauseTransition pause = new PauseTransition(Duration.millis(1000));
           FadeTransition show = new FadeTransition(Duration.millis(1000), image);
            FadeTransition gone = new FadeTransition(Duration.millis(1000), image);
           show.setFromValue(1);
           show.setToValue(0.1);

            image.setOpacity(0);
            root.getChildren().add(image);
            image.toBack();
            seq.getChildren().add(show);

        }

        /*set Background at the end*/
        setBackGround();

        seq.setCycleCount(seq.INDEFINITE);
        seq.play();

     }

     void setBackGround(){
         ImageView back = new ImageView(new Image("road.jpeg"));
         back.setFitWidth(400);
         back.setFitHeight(300);
         root.getChildren().add(back);
         back.toBack();
     }


     ImageView[] makeRoadImageViews(){
         ImageView[] slides = new ImageView[3];
         for (int i = 0; i < 3; i++){
             Image image = new Image("road" + i + ".jpeg");
             slides[i] = new ImageView(image);
             slides[i].setFitWidth(400);
             slides[i].setFitHeight(300);

         }
  //       road.getChildren().add(slides);

         return slides;




     }





}
