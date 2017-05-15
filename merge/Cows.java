import javafx.scene.shape.*;
import javafx.scene.paint.*;
import java.util.*;
import javafx.scene.*;
import javafx.beans.property.*;
import javafx.scene.image.*;
import java.lang.Math.*;


public class Cows {

  ImageView cows;
  ImageView bird;
  int cowSpeed = 1;
  int birdSpeed = 1;
  Random rand = new Random();

  Cows(Group root) {
      cows = new ImageView(new Image("Images/cow.png"));
      cows.setX(600);
      cows.setY(200);
      root.getChildren().add(cows);
      bird = new ImageView(new Image("Images/bird.png"));
      bird.setX(-100);
      bird.setY(200);
      root.getChildren().add(bird);
  }

  public void updateCow(double elapsedTime) {
    double cowMoved = elapsedTime*cowSpeed;
    cows.setX(cows.getX()-cowMoved);
    if(cows.getX()>150&&cows.getX()<250) {
      cows.setY(cows.getY()+1);
      cows.setRotate(cows.getRotate()+5);
    }
    if(cows.getX()>250&&cows.getX()<350) {
      cows.setY(cows.getY()-1);
      cows.setRotate(cows.getRotate()-5);
    }
    if(cows.getX()<rand.nextInt(600)-1400) cows.setX(600);
    double birdMoved = elapsedTime*birdSpeed;
    bird.setX(bird.getX()+birdMoved);
    bird.setY(20*Math.sin(bird.getX()*0.1)+50);
    if(bird.getX()>rand.nextInt(600)+1200) bird.setX(-100);
  }

}
