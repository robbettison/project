import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.Writer;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



/**
 * Created by hugo on 10/05/17.
 */
public class MFileReader {

    private String filename;
    public MFileReader(String filename){
	this.filename = filename;
        
    }
    private Scanner scanner;
    private HashMap<String, ArrayList<String>> result = new HashMap<>();


    void readFile(){
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
System.out.println("answers"+answers);

        return answers;

    }

    HashMap<String, ArrayList<String>> getQAndA(){
        return result;


    }

    void writeFile(String string){

	try(PrintWriter out = new PrintWriter(filename)){
		out.println(string);
	} catch (Exception e){
		e.printStackTrace();
	}

System.out.println("writing file" + string);

    }



}
