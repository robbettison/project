import java.util.*;
import java.util.Random;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.beans.property.*;
import javafx.scene.image.*;


public class Questions {
  private int[] answers = new int[30];
  Random rand = new Random();
  private int currentAnswer = -1;


  Questions() {
    rand = new Random();
    for(int i=0;i<30;i++) {
      answers[i]=rand.nextInt(4);
      System.out.println(answers[i]);
    }
  }

  public int getNextAnswer() {
    currentAnswer+=1;
    if(currentAnswer<30) {
      System.out.println(answers[currentAnswer]);
      return answers[currentAnswer];
    }
    else {
      System.out.println("Level complete");
      return -1;
    }
  }
}
