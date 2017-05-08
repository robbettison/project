import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.geometry.*;


public class Player {

  Rectangle player;


  double Channel1 = 98.06;
  double Channel2 = 196.02;
  double Channel3 = 294;
  double Channel4 = 391.94;

  double XPosition = Channel1;

  Group collisionFruit;


  Player(Group g, Scene scene, Group fruit) {
    player = new Rectangle(Channel1, 630, 30, 70);
    g.getChildren().add(player);
    scene.setOnKeyPressed(this::leftright);
    collisionFruit=fruit;
  }

  /*public void updatePlayerPosition() {

  }*/



  public void leftright(KeyEvent e) {
    if(e.getCode()==KeyCode.LEFT&&XPosition>Channel1) {
      player.setX(player.getX()-98);
      XPosition=player.getX();
    }
    else if(e.getCode()==KeyCode.RIGHT&&XPosition<Channel4){
      player.setX(player.getX()+98);
      XPosition=player.getX();
    }
  }

  public Bounds getBounds() {
    return player.getBoundsInLocal();
  }





}
