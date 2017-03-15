import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.shape.*;



public class MTime{
	MTime(){

	}
	void time(Circle[] circle){
int xChange = -60;
		for(int i=0;i<4;i++){

xChange += 30;

			double scale = 2.5;
			KeyValue kValueX = new KeyValue(circle[i].scaleXProperty() , scale);
			KeyValue kValueY = new KeyValue(circle[i].scaleYProperty() , scale);
			KeyValue xC = new KeyValue(circle[i].translateXProperty(), xChange);
			KeyValue yC = new KeyValue(circle[i].translateYProperty(), 100);

			KeyFrame kFrame = new KeyFrame(Duration.millis(5000 ) , kValueX , kValueY, xC, yC);

			Timeline timeL = new Timeline();
			timeL.getKeyFrames().add(kFrame);
			timeL.setAutoReverse(false);
			timeL.setCycleCount(Animation.INDEFINITE);
			timeL.play();
		}

	}
}
