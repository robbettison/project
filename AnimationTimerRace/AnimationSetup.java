import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import javafx. scene.image.*;
import javafx.animation.*;
import javafx.util.*;

public class AnimationSetup {

  


  AnimationSetup() {

  }



     ImageView[] makeImageViewsArray(String source, String extension, int width, int height, int slides) {
         ImageView[] animation = new ImageView[slides];
         for (int i = 0; i < slides; i++) {

             Image image = new Image(source + i + "." + extension);

             animation[i] = new ImageView(image);
             animation[i].setFitWidth(width);
             animation[i].setFitHeight(height);

         }

	return animation;
     }
//0 for back, 1 for front
 void makeAnimation(ImageView[] slides, Group root, int position) {

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

             if (position == 0) {
                 show.setFromValue(1);
                 show.setToValue(0);

             } else {
                 show.setFromValue(0);
                 show.setToValue(1);

		 show2.setFromValue(0);
		 show2.setToValue(1);
                 gone.setFromValue(1);
                 gone.setToValue(0);
             }

             image.setOpacity(1);
             root.getChildren().add(image);

             if (position == 0) {
                 image.toBack();
             } else {
                 image.toFront();

             }
             seq.getChildren().addAll(show, show2, gone);

            i++;

         }

         seq.setCycleCount(seq.INDEFINITE);
         seq.play();


     }
}
