import java.util.*;
import java.util.Random;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.beans.property.*;
import javafx.scene.image.*;
import java.lang.Object.*;


public class Questions {
  private int[] answers = new int[30];
  Random rand = new Random();
  private int currentAnswer = -1;
  Label currentFruit = new Label();
  Map<Integer, String> myMap = new HashMap<Integer, String>();



  Questions(Group G) {
    myMap.put(0, "00");
    myMap.put(1, "01");
    myMap.put(2, "10");
    myMap.put(3, "11");

    rand = new Random();
    for(int i=0;i<30;i++) {
      answers[i]=rand.nextInt(4);
      System.out.println(myMap.get(answers[i]));
    }
    currentFruit.setTranslateX(450);
    currentFruit.setText(myMap.get(answers[0]));
    currentFruit.setStyle("-fx-background-color: green;"
          + "-fx-background-radius: 40;-fx-border-color: white;");
    G.getChildren().add(currentFruit);
  }

  public int getNextAnswer() {
    currentAnswer+=1;
    if(currentAnswer<30) {
      System.out.println(answers[currentAnswer]);
      /*if(currentAnswer!=0)*/ currentFruit.setText(myMap.get(answers[currentAnswer+1]));
      return answers[currentAnswer];
    }
    else {
      System.out.println("Level complete");
      return -1;
    }
  }
}
