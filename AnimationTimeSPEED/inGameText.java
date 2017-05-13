import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.*;
import java.util.EventListener.*;
import javafx.animation.*;
import javafx.beans.property.*;
import java.util.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import java.io.*;
import javafx.scene.text.Font;
import javafx.util.*;

public class inGameText {

  Group root;

  inGameText(Group g) {
    root = g;
    //final Rectangle rect1 = new Rectangle(10, 10, 100, 100);
    Text text = new Text("Correct!");
    //StackPane stack = new StackPane();
    //stack.getChildren().addAll(rect1, text);

    //rect1.setText("Correct!");
    //g.getChildren().add(rect1);
    g.getChildren().add(text);
    text.setFill(Color.RED);
    text.setX(250);
    text.setY(300);
    text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
    text.setFontSmoothingType(FontSmoothingType.LCD);

    //rect1.setArcHeight(20);
    //rect1.setArcWidth(20);
    //rect1.setFill(Color.RED);
    FadeTransition ft = new FadeTransition(Duration.millis(3000), text);
    ft.setFromValue(1.0);
    ft.setToValue(0.0);
    ft.setCycleCount(1);
    ft.setAutoReverse(true);
    ft.play();
  }



  /*public void answerCorrect() {
    g.getChildren().add();
  }*/


}
