import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.shape.*;


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
import javafx.animation.SequentialTransition;

public class Try extends Application{


    public static void main(String [] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        stage.setScene(scene);
        Group circles = new Group();
        Group newC = new Group();
        root.getChildren().add(circles);
        root.getChildren().add(newC);


        for (int i = 0; i < 4; i++){
            Circle circle = new Circle(150, Color.RED);

            circles.getChildren().add(setRandCircle(circle));

        }
        for (int i = 0; i < 4; i++){
            Circle circle = new Circle(150, Color.BLUE);
            newC.getChildren().add(setRandCircle(circle));

        }
        int xChange = -90;
        Timeline timeLine = new Timeline();
//        for(Node circle : circles.getChildren()){
//
//            xChange += 100;
//
//            double scale = 2.5;
//            timeLine.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
//            new KeyValue(circle.translateXProperty(), xChange),
//            new KeyValue(circle.translateYProperty(), 1000)));
//
//
//
//        }
       timeLine = addKeyFrame(timeLine, circles, 2000);
        timeLine = addKeyFrame(timeLine, circles, 1000);
        timeLine = addKeyFrame(timeLine, circles, 3000);



        timeLine.play();
        System.out.println("asd");

        stage.show();

    }

    Group newRand(Group group){

        group.getChildren().clear();
        group.getChildren().add(setRandCircle(new Circle()));
        return group;

    }

    Timeline addKeyFrame(Timeline timeline, Group group, int time){
        int xChange = 0;
      //  group = newRand(group);
        for(Node circle : group.getChildren()){

            xChange += 100;

            double scale = 2.5;
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(time + 1000),
                            new KeyValue(circle.translateXProperty(), xChange),
                            new KeyValue(circle.translateYProperty(), 1000)));

        }
        return timeline;

    }






    String randImage(){
        Random aa = new Random();
        int x = aa.nextInt(2);

        if (x == 0){
            return "ball1.png";
        }
        else return "player.png";
    }
    Circle setRandCircle(Circle circle){


            circle.setFill(new ImagePattern(new Image(randImage())));

        return circle;

    }











//    Group makeCircleGroup() {
//        Group circles = new Group();
//
//        for (int i = 0; i < 4; i++){
//            Circle circle = new Circle(150, Color.RED);
//            circles.getChildren().add(circle);
//        }
//
//
//        For(Node circle:circles.getChildren()){
//            timeLine.getKeyFrames.addAll(new KeyFrame(Duration.millis(5000)),
//                    new KeyValue(circle.scaleXProperty(), scale),
//                    new KeyValue(circle.scaleYProperty(), scale);
//            new KeyValue(circle.translateXProperty(), xChange);
//            new KeyValue(circle.translateYProperty(), 300);
//			)
//        }
//
//    }



}