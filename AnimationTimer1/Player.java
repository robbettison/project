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


  double Channel1 = 98.06;
  double Channel2 = 196.02;
  double Channel3 = 294;
  double Channel4 = 391.94;

  double XPosition = Channel1;

  Group collisionFruit;


  Player(Group g, Scene scene, Group fruit) {

    animationSetup = new AnimationSetup();

    playerAnimation = animationSetup.makeImageViewsArray("pic/frame", "png", 75, 125, 24);
    animationSetup.makeAnimation(playerAnimation, g, 1);
//set initialPosition
    changePlayerPosition(Channel2, caterPillarY);

    scene.setOnKeyPressed(this::leftright);
    collisionFruit=fruit;
  }

  public void leftright(KeyEvent e) {
    if(e.getCode()==KeyCode.LEFT&&XPosition>Channel1) {
      changePlayerPosition(playerAnimation[0].getX()-98, caterPillarY);
      XPosition=playerAnimation[0].getX();
    }
    else if(e.getCode()==KeyCode.RIGHT&&XPosition<Channel4){
      changePlayerPosition(playerAnimation[0].getX()+98, caterPillarY);
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
