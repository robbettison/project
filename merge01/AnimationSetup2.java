import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.event.*;

public class AnimationSetup2 {
  ImageView[] playerImages;
  Group G;
  double time=0;
  int j=0;

  AnimationSetup2(String source, String extension, int width, int height, int slides, Group root) {
    playerImages = new ImageView[slides];
    for (int j = 0; j < slides; j++) {
      Image image = new Image(source + j + "." + extension);
      playerImages[j] = new ImageView(image);
      playerImages[j].setFitWidth(width);
      playerImages[j].setFitHeight(height);
    }
    G = root;
  }



  public void updateAnimation(double elapsedTime) {
    time = time + elapsedTime;
    if(time>1) {
      G.getChildren().setAll(playerImages[j]);
      if(j<23) j++;
      else j=0;
      time=0;
    }
  }

  public void changeCaterpillarChannel(double x, double y, int angle) {
    for (ImageView iv : playerImages) {
      iv.setX(x);
      iv.setY(y);
      iv.setRotate(angle);
    }
  }

  public Bounds getBounds() {
    return playerImages[0].getBoundsInLocal();
  }

  public double getX() {
    return playerImages[0].getX();
  }



}
