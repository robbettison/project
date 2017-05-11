import java.util.*;
import java.util.Random;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.beans.property.*;
import javafx.scene.image.*;
import javafx.stage.*;


public class Questions {
  private int[] answers = new int[30];
  Random rand = new Random();
  private int keepTrack = 0;
  Label questionLabel = new Label();
 // Map<Integer, String> myMap = new HashMap<Integer, String>();
  ArrayList<String> questionsArray = new ArrayList<>();

  MFileReader mfr = new MFileReader("questions.txt");

//make hashmap
//hashmap of questions, and possible answers 

HashMap<String, ArrayList<String>> qAndA = new HashMap<String, ArrayList<String>>();



  Questions(Group G) {
	mfr.readFile();
	qAndA = mfr.getQAndA();


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

System.out.println("keeptrack IS:"+keepTrack);
    if(keepTrack<questionsArray.size()) {
 

//prepare to print out next question as it collides
      /*if(currentAnswer!=0)*/ 
	try{
		questionLabel.setText(questionsArray.get(keepTrack+1));
	} catch (Exception e){
		System.out.println("ended");
		return "";

	
		//GAME FINISH SCREEN
		
	}

//assuming the first input in array is the answer
System.out.println("correct answer is:" + qAndA.get(questionsArray.get(keepTrack)).get(0));
   
      return qAndA.get(questionsArray.get(keepTrack++)).get(0);
    }
    else {
      System.out.println("Level complete");

      return "";
    }
  }
  ArrayList<String> getNewFruitAnswers(){
//check inbound

    return qAndA.get(questionsArray.get(keepTrack));
  }

}
