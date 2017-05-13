import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.scene.image.*;
import java.util.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.canvas.*;
import javafx.geometry.Orientation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.io.BufferedReader;
import java.util.Map;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.TreeMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Comparator;


public class LeaderBoard {

	Stage leaderStage;
	double width, height;
	Button back = new Button("back");
	Canvas canvas = new Canvas(400, 300);
	BorderPane bp = new BorderPane();
	BorderPane borderPane1 = new BorderPane();
	Scene scene = new Scene(bp, 400, 300);
	ScrollPane sp = new ScrollPane();

	Scene leaderScene;
	MMenu menu = new MMenu();
	String s1;

	// The name of the file where the highscores will be saved
    private static final String HIGHSCORE_FILE = "score.txt";
    //private static final String ANOTHER_FILE = "score_name.txt";

    public LeaderBoard(){

    }

	public LeaderBoard(Scene scene, Stage stage, double width, double height){
		this.leaderScene = scene;
		this.leaderStage = stage;
		this.width = width;
		this.height = height;
	}



	/*@Override
	public int compareTo(LeaderBoard lb){
		return lb.getScore()-this.score;
	}*/

	/* compare(Object o1,Object o2)
    * -1:o1 < o2,
    * 0:o1 = o2,
    * 1:o1 >o2
    */

	public List<String> seperate() {
		List<String> list = new ArrayList<String>();
		//char[] c = new char[10];
		BufferedReader is = null;
		try{
			File file = new File(HIGHSCORE_FILE);
			is = new BufferedReader(new FileReader(file));
			String len = "";
			// read every line, even/odd reprsent username and score
			while((len = is.readLine()) != null){
				//s1 = String.valueOf(c);
				list.add(len);
				System.out.println(len);
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally{
			if(is != null){
				try{
					is.close();
				}catch(Exception e) {
					System.err.println("close file wrong");
				}
			}
		}
		return list;
    }

	private void press(ActionEvent event) {
		String username = "";
		int score = 0;
		String s = "";
		int len;
		List<String> list = seperate();
		Map<insertField, Integer> map = new TreeMap<insertField, Integer>(new insertField());
		//Here should add new user and new score
		//user = textField.getText();
		//score = ?;
		//map.put(user, score);
		for(int i=0;i<list.size();i++){
			len = list.get(i).indexOf(" ");
			System.out.println(len);
			s = list.get(i);
			System.out.println(s);
  	    	username = s.substring(0, len);
  	    	score = Integer.valueOf(s.substring(len+1)).intValue();
	  	    map.put(new insertField(username,score), score);
	  	}
		Iterator itrator=map.entrySet().iterator();
		List<String> nameList = new ArrayList<String>();
		List<Integer> scoreList = new ArrayList<Integer>();
        Object key,value;
        String str;
        while(itrator.hasNext()){
            Map.Entry entry = (Map.Entry)itrator.next();
            key = entry.getKey();
            value = entry.getValue();
            //list.add(value);
            //Collections.sort(list);
			//str = list.get(i)+":          "+value;
			//str = key + "          " + value;
            //System.out.println(str);
            nameList.add(((insertField)key).getName());
            scoreList.add((Integer)value);
        }
        fillFile(nameList, scoreList);
		/*for (Integer o : list) {
			str = o +":          "+map.get(o);
            System.out.println(o.getScore() + "-->" + o.getName());
        }*/
		leaderStage.setScene(leaderScene);
		menu.show(leaderStage);
	}

	private void setLayout(){

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setStyle("-fx-background-color: #336699;");
		hbox.getChildren().add(back);

		bp.getChildren().add(canvas);
		bp.setStyle("-fx-background-color: GREEN;");
		bp.setBottom(hbox);
		bp.setCenter(sp);
	}


	public void scroll(Label content){
		sp.setPrefSize(200,200);
		borderPane1.setCenter(content);
		borderPane1.setStyle("-fx-background-color: GREEN;");
	  	sp.setContent(borderPane1);
		sp.vvalueProperty().addListener(new ChangeListener<Number>() {
     		public void changed(ObservableValue<? extends Number> ov,
          	Number old_val, Number new_val) {
              content.setLayoutY(-new_val.intValue());
              System.out.println(new_val.intValue());
     	 	}
		});
		sp.hvalueProperty().addListener(new ChangeListener<Number>() {
          	public void changed(ObservableValue<? extends Number> ov,
              Number old_val, Number new_val) {
              	content.setLayoutY(-new_val.intValue());
                System.out.println(new_val.intValue());
        	}
	    });
	    setLayout();
	}

	public String readFile() {

		byte[] b = new byte[2048];
		InputStream is = null;
		String s1 = "";
		try{
			File file = new File(HIGHSCORE_FILE);
			is = new FileInputStream(file);
			int len;
			while((len = is.read(b)) != -1){
				s1 = new String(b, "utf-8");
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally{
			if(is != null){
				try{
					is.close();
				}catch(Exception e) {
					System.err.println("close file wrong");
				}
			}
		}
		return s1;
    }


    // use BufferWriter and there is a function can jump into newline
    public void fillFile(List<String> name, List<Integer> score){
		//byte bt[] = new byte[1024];
        //bt = str.getBytes();
        BufferedWriter os = null;
	    try{
	    	// create a new output stream
	         os = new BufferedWriter(new FileWriter(HIGHSCORE_FILE));
	         //os1 = new BufferedWriter(new FileWriter(ANOTHER_FILE));
  	         // write something
			 for(int i=0;i<name.size();i++){
			 	os.write(name.get(i) + " " + score.get(i));
			 	os.newLine();
			 }
			/*for(int i=0;i<name.size();i++){
			 	os1.write(name.get(i) + " ");
			 	os1.write(score.get(i));
			 	os1.newLine();
			 }*/
	         // flush the stream but it does nothing
	         os.flush();
		}catch (Exception ex) {
         	ex.printStackTrace();
      	}finally{
      		if(os != null){
				try{
					os.close();
				}catch(Exception e) {
					System.err.println("close file wrong");
				}
			}
      	}
    }


	public Scene leaderBoardShow() {
		back.setOnAction(this::press);
		canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

	 	return scene;
	}

}