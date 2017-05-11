import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Created by hugo on 10/05/17.
 */
public class MFileReader {

    public MFileReader(String filename){
        readFile(filename);
    }
    private Scanner scanner;
    private HashMap<String, ArrayList<String>> result = new HashMap<>();


    void readFile(String filename){
        String temp, question;
        ArrayList<String> answers = new ArrayList<>();

       try {
           scanner = new Scanner(new FileReader(filename));
           while (scanner.hasNext()) {
               temp = scanner.nextLine();
               question = question(temp);
               answers = answers(temp);

               result.put(question, answers);

           }
       }catch (Exception e){
           e.printStackTrace();
       }

       scanner.close();



    }

    private String question(String input){

        String temp;
        temp = input.substring(0, input.indexOf("`"));

        System.out.println(temp);
        return temp;

    }

    private ArrayList<String> answers(String input){

        ArrayList<String> answers = new ArrayList<>();
        String[] tempArray;

        String temp = input.substring(input.indexOf("`")+1);
        System.out.println(temp);

        tempArray = temp.split("`");

        for (String answer: tempArray){
            answers.add(answer);
        }

        System.out.println(answers);
        return answers;

    }

    private HashMap<String, ArrayList<String>> getQAndA(){
        return result;


    }

    public static void main(String args[]){
        MFileReader fr = new MFileReader();
        fr.readFile("test.txt");
    }

}
