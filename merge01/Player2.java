import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx. scene.image.*;
import javafx.animation.*;
import javafx.util.*;

public class Player2 {

  ImageView player;
  ImageView[] playerAnimation;
  AnimationSetup2 animationSetup;
  final int caterPillarY = 590;

  /*165.3333333333327
  257.5999999999915
  337.4000000000085
  429.6666666666596*/


  double[] channel = {120, 213, 292, 384};

  int currentChannel = 2;
  double XPosition = channel[currentChannel];

  Group collisionFruit;


  Player2(Group g, Scene scene, Group fruit) {

    /*playerAnimation = */animationSetup = new AnimationSetup2("pic/caterpillar", "png", 75, 125, 24, g);
    //animationSetup.makeAnimation(playerAnimation, g);
//set initialPosition
    changePlayerPosition(294, caterPillarY);

    scene.setOnKeyPressed(this::leftright);
    collisionFruit=fruit;
  }

  public void leftright(KeyEvent e) {
    if(e.getCode()==KeyCode.LEFT && currentChannel > 0) {



      currentChannel -= 1;




      changePlayerPosition(channel[currentChannel], caterPillarY);
      XPosition=animationSetup.getX();


    }
    else if(e.getCode()==KeyCode.RIGHT && currentChannel < 3){
      currentChannel+=1;

      changePlayerPosition(channel[currentChannel], caterPillarY);

      XPosition=animationSetup.getX();
    }
  }

  public void updateCaterpillarAnimation(double elapsedTime) {
    animationSetup.updateAnimation(elapsedTime);
  }



  public Bounds getBounds() {
    return animationSetup.getBounds();
  }

     void changePlayerPosition(double x, double y) {

        // for (ImageView iv : playerAnimation) {
          //   iv.setX(x);
            // iv.setY(y);
            int angle;
             if(currentChannel==0) angle = 20;
             else if(currentChannel==3) angle =-20;
             else if(currentChannel==1) angle = 5;
             else angle=-5;


         animationSetup.changeCaterpillarChannel(x, y, angle);

     }

}
