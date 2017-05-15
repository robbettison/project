import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
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
    private TableView<TopScore> table;
    private TextField nameInput;
    private Button confirm;
    private Button back;
    private int sc = 99;
    Scene newScene, oldScene;
    double width, height;
    MMenu menu = new MMenu();
    String s1;

    // The name of the file where the highscores will be saved
    private static final String HIGHSCORE_FILE = "score.txt";

    public LeaderBoard(Scene scene, Stage stage, double width, double height) {
        leaderStage = stage;
        leaderStage.setTitle("Leaderboard");
        this.oldScene = scene;
        this.width = width;
        this.height = height;

        //Name column
        TableColumn<TopScore, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<TopScore, Double> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setMinWidth(100);
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        nameInput = new TextField();
        nameInput.setPromptText("NEW HIGHSCORE, ENTER YOUR NAME!");
        nameInput.setMinWidth(120);

        confirm = new Button("Confirm");
        confirm.setTranslateX(110);
        confirm.setOnAction(e -> confirmFunc());

        back = new Button("Back");
        back.setTranslateX(140);
        back.setOnAction(e -> backFunc());

        table = new TableView<>();
        table.getColumns().add(nameColumn);
        table.getColumns().add(scoreColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        BorderPane bp = new BorderPane();
        bp.setCenter(vBox);
        bp.setTop(nameInput);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(confirm, back);
        bp.setBottom(hBox);

        newScene = new Scene(bp, 800, 600);
      //  window.setScene(scene);
        //window.show();
    }

    //Get all of the TopScores
    public ObservableList<TopScore> getTopScore(List<String> list){
        ObservableList<TopScore> topScores = FXCollections.observableArrayList();
        for(int i=0;i<list.size();i++){
                int len = list.get(i).indexOf(" ");
                String s = list.get(i);
                String username = s.substring(0, len);
                int score = Integer.valueOf(s.substring(len+1)).intValue();
                topScores.add(new TopScore(username,score));
        }
        table.setItems(topScores);
        return topScores;
    }

    void confirmFunc(){
      TopScore newScore = new TopScore();
      newScore.setName(nameInput.getText());
      newScore.setScore(sc);
      table.getItems().add(newScore);
      confirm.setOnAction(null);
    }


    void backFunc(){
        leaderStage.setScene(oldScene);
        menu.show(leaderStage);
    }


    void setSc(int sc1){
      sc = sc1;
    }

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
        leaderStage.setScene(oldScene);
        menu.show(leaderStage);
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

        return newScene;
    }
}
