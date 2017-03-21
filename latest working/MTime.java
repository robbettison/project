import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.scene.shape.*;


import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.beans.property.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.SequentialTransition;



public class MTime{
	MTime(){

	}
	Timeline time(Circle[] circle){
int xChange = -90;

Timeline timeL = new Timeline();
Timeline timeL2 = new Timeline();

		for(int i=0;i<4;i++){

xChange += 40;

			double scale = 2.5;
			KeyValue kValueX = new KeyValue(circle[i].scaleXProperty() , scale);
			KeyValue kValueY = new KeyValue(circle[i].scaleYProperty() , scale);
			//KeyValue kValueY2 = new KeyValue(circle[i].scaleYProperty() , scale);

			KeyValue xC = new KeyValue(circle[i].translateXProperty(), xChange);
			KeyValue yC = new KeyValue(circle[i].translateYProperty(), 300);

			KeyFrame kFrame = new KeyFrame(Duration.millis(3000 ) , kValueX , kValueY, xC, yC);
			KeyFrame k2Frame = new KeyFrame(Duration.millis(4000 ) , kValueX , kValueY, xC, yC);


			timeL.getKeyFrames().add(kFrame);
			//timeL.setAutoReverse(false);
		  timeL.setCycleCount(2);

			timeL2.getKeyFrames().add(k2Frame);
			//timeL2.setAutoReverse(false);
			timeL2.setCycleCount(2);



			SequentialTransition seq = new SequentialTransition(timeL, timeL2);
			seq.play();
		//	timeline.setOnFinished(x -> timeline = null);

			//timeL.play();
			/*try {
				Thread.sleep(1000);
			} catch (Exception e){
				System.out.println("Failed sleep");
			}*/


		}
		//timeL.stop();

  return timeL;
	}
}
