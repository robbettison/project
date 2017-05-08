import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx. scene.image.*;
import javafx.animation.*;
import javafx.util.*;

public class Player {

  ImageView player;
  ImageView[] playerAnimation;


  double Channel1 = 98.06;
  double Channel2 = 196.02;
  double Channel3 = 294;
  double Channel4 = 391.94;

  double XPosition = Channel1;

  Group collisionFruit;


  Player(Group g, Scene scene, Group fruit) {

  /*  player = new ImageView(new Image("pic/frame.png"));
    player.setFitWidth(150);
    player.setFitHeight(250);
*/

    makePlayerImageViews();
    makeAnimation(playerAnimation, g);
   // g.getChildren().add(player);
    
    scene.setOnKeyPressed(this::leftright);
    collisionFruit=fruit;
  }

  public void leftright(KeyEvent e) {
    if(e.getCode()==KeyCode.LEFT&&XPosition>Channel1) {
      changePlayerPosition(playerAnimation[0].getX()-98, 500);
      XPosition=playerAnimation[0].getX();
    }
    else if(e.getCode()==KeyCode.RIGHT&&XPosition<Channel4){
      changePlayerPosition(playerAnimation[0].getX()+98, 500);
      XPosition=playerAnimation[0].getX();
    }
  }

  public Bounds getBounds() {
    return playerAnimation[0].getBoundsInLocal();
  }

//STUFF BELOW ADDED
     void changePlayerPosition(double x, double y) {
         for (ImageView iv : playerAnimation) {
             iv.setX(x);
             iv.setY(y);
         }

     }

     void makePlayerImageViews() {
         playerAnimation = new ImageView[24];
         for (int i = 0; i < 24; i++) {
             Image image = new Image("pic/frame" + i + ".png");
             playerAnimation[i] = new ImageView(image);
             playerAnimation[i].setFitWidth(150);
             playerAnimation[i].setFitHeight(250);

            
         }
     }

     void makeAnimation(ImageView[] slides, Group root) {

         int i = 0;
         SequentialTransition seq = new SequentialTransition();
         SequentialTransition try1 = new SequentialTransition();
         for (ImageView image : slides) {
           if (i >=23){
	          i = 22;

            }

            FadeTransition show = new FadeTransition(Duration.millis(20), image);
            FadeTransition show2 = new FadeTransition(Duration.millis(1), slides[i+1]);


            FadeTransition gone = new FadeTransition(Duration.millis(1), image);

                 show.setFromValue(0);
                 show.setToValue(1);

		         show2.setFromValue(0);
		         show2.setToValue(1);
                 gone.setFromValue(1);
                 gone.setToValue(0);
             
             image.setOpacity(1);
             root.getChildren().add(image);

                 image.toFront();

         
             seq.getChildren().addAll(show, show2, gone);



            i++;

         }

      //   seq.setAutoReverse(true);
         seq.setCycleCount(seq.INDEFINITE);
         seq.play();


     }
}
