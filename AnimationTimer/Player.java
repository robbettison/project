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
  AnimationSetup animationSetup;
  final int caterPillarY = 590;

  /*165.3333333333327
  257.5999999999915
  337.4000000000085
  429.6666666666596*/


  double[] channel = {120, 213, 292, 384};

  int currentChannel = 2;
  double XPosition = channel[currentChannel];

  Group collisionFruit;


  Player(Group g, Scene scene, Group fruit) {

    animationSetup = new AnimationSetup();

    playerAnimation = animationSetup.makeImageViewsArray("pic/frame", "png", 75, 125, 24);
    animationSetup.makeAnimation(playerAnimation, g, 1);
//set initialPosition
    changePlayerPosition(294, caterPillarY);

    scene.setOnKeyPressed(this::leftright);
    collisionFruit=fruit;
  }

  public void leftright(KeyEvent e) {
    if(e.getCode()==KeyCode.LEFT && currentChannel > 0) {



      currentChannel -= 1;




      changePlayerPosition(channel[currentChannel], caterPillarY);
      XPosition=playerAnimation[0].getX();


    }
    else if(e.getCode()==KeyCode.RIGHT && currentChannel < 3){
      currentChannel+=1;

      changePlayerPosition(channel[currentChannel], caterPillarY);

      XPosition=playerAnimation[0].getX();
    }
  }



  public Bounds getBounds() {
    return playerAnimation[0].getBoundsInLocal();
  }

     void changePlayerPosition(double x, double y) {
         for (ImageView iv : playerAnimation) {
             iv.setX(x);
             iv.setY(y);
         }

     }

}
