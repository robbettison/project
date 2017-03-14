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
		for(int i=0;i<4;i++){
			double randScale = (Math.random() * 4) + 1;
			KeyValue kValueX = new KeyValue(circle[i].scaleXProperty() , randScale);
			KeyValue kValueY = new KeyValue(circle[i].scaleYProperty() , randScale);

			KeyFrame kFrame = new KeyFrame(Duration.millis(5000 + (Math.random() * 5000)) , kValueX , kValueY);

			Timeline timeL = new Timeline();
			timeL.getKeyFrames().add(kFrame);
			timeL.setAutoReverse(true);
			timeL.setCycleCount(Animation.INDEFINITE);
			timeL.play();
		}
	}
}
