import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx. scene.image.*;
import javafx.animation.*;
import javafx.util.*;

public class Background {

  ImageView background;
  ImageView[] backgroundAnimation;
  AnimationSetup animationSetup;


  Background(Group g) {
    animationSetup = new AnimationSetup();
    roadAnimation(g);
  }


//STUFF BELOW ADDED
     void setBackGround(Group root) {
         ImageView back = new ImageView(new Image("pic/Road_anim_3d_0.png"));
         back.setFitWidth(607);
         back.setFitHeight(1080);
         root.getChildren().add(back);
         back.toBack();
     }

  void roadAnimation(Group root) {


         backgroundAnimation = animationSetup.makeImageViewsArray("pic/Road_anim_3d_", "png", 607, 1080, 30);

         animationSetup.makeAnimation(backgroundAnimation, root, 0);

         setBackGround(root);
     }

}
