import java.util.*;
import java.util.Random;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.beans.property.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.control.*;

public class Questions {
  private int[] answers = new int[30];
  Random rand = new Random();
  private int currentAnswer = 0;
  Label currentFruit = new Label();
  Map<Integer, String> myMap = new HashMap<Integer, String>();
  Group root;
  inGameText Correct;


  Questions(Group G) {
    /*myMap.put(0, "00");
    myMap.put(1, "01");
    myMap.put(2, "10");
    myMap.put(3, "11");*/
    root = G;
    rand = new Random();
    for(int i=0;i<10;i++) {
      answers[i]=rand.nextInt(15);
      System.out.println(answers[i]);
    }
    currentFruit.setTranslateX(450);
    currentFruit.setText(Integer.toString(answers[0]));
    G.getChildren().add(currentFruit);
  }

  public int getcurrentAnswer() {
    return answers[currentAnswer];
  }

  public int getNextAnswer() {
    currentAnswer+=1;
    if(currentAnswer<10) {
      //System.out.println(answers[currentAnswer]);
      Correct = new inGameText(root);
      /*if(currentAnswer!=0)*/ currentFruit.setText(Integer.toString(answers[currentAnswer]));
      return answers[currentAnswer];
    }
    else {
      System.out.println("Level complete");
      return -1;
    }
  }
}
