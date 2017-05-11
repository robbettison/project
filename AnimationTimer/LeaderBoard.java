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
import java.io.*;



public class LeaderBoard{

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
	InputStream is = null;
	OutputStream os = null;

	// The name of the file where the highscores will be saved
    private static final String HIGHSCORE_FILE = "test.txt";



	LeaderBoard(Scene scene, Stage stage, double width, double height){
		this.leaderScene = scene;
		this.leaderStage = stage;
		this.width = width;
		this.height = height;
	}



	private void press(ActionEvent event) {
		//setLayout();
		leaderStage.setScene(leaderScene);
		//instructStage.setTitle("Bug Bits!");
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
		//root.getChildren().add(borderPane);
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
		String s = null;
		try{
			File file = new File(HIGHSCORE_FILE);
			is = new FileInputStream(file);
			int len;
			while((len = is.read(b)) != -1){
				s = new String(b, "utf-8");
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
		return s;

    }


    public void fillFile(){

	    try{
	    // create a new output stream
	         os = new FileOutputStream(new File("test.txt"));
  	         // write something
	         os.write('A');
	         // flush the stream but it does nothing
	         os.flush();
		}catch (Exception ex) {
         	ex.printStackTrace();
      	} finally{
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