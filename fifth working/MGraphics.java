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
import javafx.animation.TranslateTransition;
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

  Canvas canvas = new Canvas(607, 1080);
  Image bg = new Image("road0.jpeg");

  Image whiteBox = new Image("Box.png");
  //Image ball = new Image("ball1.png");


  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane ballPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);

  ImageView player = new ImageView(new Image("frame0.png"));
  Group root = new Group(canvas);
  Scene scene = new Scene(root);
  Label playerScore = new Label();
  StackPane scorePane = new StackPane();

  ImageView[] playerAnimation;



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
          Circle newCircle= new Circle(x + i * 5, y, radius, Color.BLUEVIOLET);
          setRandCircle(newCircle, temp);
          circle.getChildren().add(newCircle);
      }
      return circle;

    }

     void setRandCircle(Circle circle, ArrayList<Integer> temp){
        circle.setFill(new ImagePattern(new Image(randImage(temp))));
     }


    Scene setUp(Stage stage) {
        playerScore.textProperty().bind(score.asString());
        scorePane.getChildren().addAll(whiteBox1, playerScore);


        root.getChildren().add(scorePane);
//        player.setX(275);
//        player.setY(800);
//        player.setFitHeight(250);
//        player.setFitWidth(150);
//        root.getChildren().add(player);

        stage.setScene(scene);
        changePlayerPosition(275, 800);

        return scene;
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
        group = setCircle(290,267,2);
        root.getChildren().add(group);
        int xChange = -475;
        for (Node node: group.getChildren()) {
            xChange += 200;
            tl.getKeyFrames().add(makeKeyFrame(time,40,40,xChange,1200,node));
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
        playerAnimation();

        sequence.play();
     }




     Timeline makeRoadTimeLine(int n){

        Timeline tl = new Timeline();

        ImageView road = new ImageView(new Image("road" + n + ".jpeg"));
        root.getChildren().add(road);
        tl.getKeyFrames().add(makeKeyFrame(n*1000,1,1,0,0,road));

         return tl;

     }


     void playerAnimation(){

         makePlayerImageViews();
         makeAnimation(playerAnimation, 1);

     }
    //0 for animation at back, 1 for front
    void makeAnimation(ImageView[] slides, int position){

        SequentialTransition seq = new SequentialTransition();
        SequentialTransition try1 = new SequentialTransition();
        for (ImageView image: slides){

            FadeTransition show = new FadeTransition(Duration.millis(50), image);
            FadeTransition gone = new FadeTransition(Duration.millis(1), image);

            if (position == 0) {
                show.setFromValue(1);
                show.setToValue(0);

            }
            else{
                show.setFromValue(0);
                show.setToValue(1);


            //     gone.setToValue(1);
              //  gone.setToValue(0);
            }

            image.setOpacity(1);
            root.getChildren().add(image);

            if (position == 0) {
                image.toBack();
            }
            else {
                image.toFront();
                System.out.println(image);
            }
            seq.getChildren().addAll(show, gone);


        }

        seq.setAutoReverse(true);
        seq.setCycleCount(seq.INDEFINITE);
        seq.play();



    }

    /*SequentialTransition getSeq(){
        return this.tempSeq;
    }*/

     void roadAnimation(){



        ImageView[] slides = makeRoadImageViews();

        makeAnimation(slides, 0);

        /*set Background at the end*/
        setBackGround();
     }

     void setBackGround(){
         ImageView back = new ImageView(new Image("Road_anim_3d_20000.png"));
         back.setFitWidth(607);
         back.setFitHeight(1080);
         root.getChildren().add(back);
         back.toBack();
     }



     ImageView[] makeRoadImageViews(){
         ImageView[] slides = new ImageView[30];
         int temp;
         for (int i = 0; i < 30; i++){
             temp = 20000+i;
             Image image = new Image("Road_anim_3d_" + temp + ".png");
             slides[i] = new ImageView(image);
             slides[i].setFitWidth(607);
             slides[i].setFitHeight(1080);

         }


         return slides;
     }

     void makePlayerImageViews(){
         playerAnimation = new ImageView[24];
         for (int i = 0; i < 24; i++){
             Image image = new Image("frame" + i + ".png");
             playerAnimation[i] = new ImageView(image);
             playerAnimation[i].setFitWidth(150);
             playerAnimation[i].setFitHeight(250);
             //playerAnimation[i].setX(0);
             //playerAnimation[i].setY(150);

        // following line not working
        // bindPlayerXY(playerAnimation[i], 200, 250);

         }
     }

    void changePlayerPosition(int x, int y){
        for (ImageView iv: playerAnimation){
            iv.setX(x);
            iv.setY(y);
        }
        player.setX(x);
        player.setY(y);
    }


}
