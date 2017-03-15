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


public class MTime{
	MTime(){

	}
	void time(Circle[] circle){
int xChange = -90;
		for(int i=0;i<4;i++){

xChange += 40;

			double scale = 2.5;
			KeyValue kValueX = new KeyValue(circle[i].scaleXProperty() , scale);
			KeyValue kValueY = new KeyValue(circle[i].scaleYProperty() , scale);
			KeyValue xC = new KeyValue(circle[i].translateXProperty(), xChange);
			KeyValue yC = new KeyValue(circle[i].translateYProperty(), 330);

			KeyFrame kFrame = new KeyFrame(Duration.millis(5000 ) , kValueX , kValueY, xC, yC);

			Timeline timeL = new Timeline();
			timeL.getKeyFrames().add(kFrame);
			timeL.setAutoReverse(false);
			timeL.setCycleCount(Animation.INDEFINITE);
			timeL.play();
		}


	}
}


