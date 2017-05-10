import java.util.*;
import java.util.Random;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.beans.property.*;
import javafx.scene.image.*;


public class Questions {
  private int[] answers = new int[30];
  Random rand = new Random();
  private int keepTrack = -1;
  Label questionLabel = new Label();
 // Map<Integer, String> myMap = new HashMap<Integer, String>();
  ArrayList<String> questionsArray = new ArrayList<>();

//make hashmap
//hashmap of questions, and possible answers 

HashMap<String, ArrayList<String>> qAndA = new HashMap<String, ArrayList<String>>();



  Questions(Group G) {

//set questions and answers: [0] is the correct answer
qAndA.put("11 is the first letter", new ArrayList<>(Arrays.asList("A", "B", "C","D")));
qAndA.put("22 is the second letter", new ArrayList<>(Arrays.asList("S", "E", "Q","W")));
qAndA.put("33 is the third letter", new ArrayList<>(Arrays.asList("P", "Z", "X","V")));


    rand = new Random();


//putting questions into an array (maybe make it random)
    for(String question: qAndA.keySet()) {
     questionsArray.add(question);

    }

//print out first question
    questionLabel.setText(questionsArray.get(0));

System.out.println(questionsArray.get(0) + "XXXXXXXXXXXXXXXXXXXXXXX");

//putting question on top right
    questionLabel.setTranslateX(100);

    G.getChildren().add(questionLabel);
  }

  public String getNextAnswer() {


    if(keepTrack<questionsArray.size()) {


//print out next question
      /*if(currentAnswer!=0)*/ questionLabel.setText(questionsArray.get(keepTrack));

//assuming the first input in array is the answer
    keepTrack+=1;
      return qAndA.get(questionsArray.get(keepTrack-1)).get(0);
    }
    else {
      System.out.println("Level complete");

      return "aaa";
    }
  }
  ArrayList<String> getNewFruitAnswers(){
//check inbound
if (keepTrack == -1){
keepTrack = 0;
}
    return qAndA.get(questionsArray.get(keepTrack));
  }

}
