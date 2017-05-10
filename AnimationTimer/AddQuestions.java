import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.scene.image.*;
import java.util.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.canvas.*;
import javafx.geometry.Orientation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class AddQuestions {
	Stage instructStage;
	Scene instructScene;
	double width, height;
	Canvas canvas = new Canvas(400, 300);
    Image bg = new Image("Bug.png");
    //Group root = new Group();
    //ImageView bgView = new ImageView(bg);
    GraphicsContext g = canvas.getGraphicsContext2D();
	GridPane gridPane = new GridPane();
	
	Scene scene = new Scene(gridPane, 1000, 1000);
	Button addbtn = new Button("add");
	Button savebtn = new Button("save");
	Button backbtn = new Button("back");
	MMenu menu = new MMenu();
	Label label1 = new Label("Question");
	Label label2 = new Label("Correct Answer");
	
	Label label3 = new Label("Wrong Answer");
	
	Label label4 = new Label("Wrong Answer");
	
	Label label5 = new Label("Wrong Answer");

	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	TextField tf3 = new TextField();
	TextField tf4 = new TextField();
	TextField tf5 = new TextField();

	int finalRow = 2;
		




	private void draw(GraphicsContext g, Image bg) {
	  	g.drawImage(bg, 0, 0);
	}

	public AddQuestions(Scene scene, Stage stage, double width, double height){
		this.instructScene = scene;
		this.instructStage = stage;
		this.width = width;
		this.height = height;
		setLayout();

	}


	private void setLayout(){

	//	gridPane.getChildren().add(addbtn);
gridPane.setHgap(10);
gridPane.setHgap(5);
gridPane.getChildren().addAll(label1,label2,label3,label4,label5, tf1,tf2,tf3,tf4,tf5,addbtn,backbtn,savebtn);

		gridPane.setConstraints(label1,0,0,3,1);
		gridPane.setConstraints(label2,3,0);
		gridPane.setConstraints(label3,4,0);	
		gridPane.setConstraints(label4,5,0);	
		gridPane.setConstraints(label5,6,0);	

		gridPane.setConstraints(tf1, 0,1,3,1);
		gridPane.setConstraints(tf2, 3,1);
		gridPane.setConstraints(tf3, 4,1);
		gridPane.setConstraints(tf4, 5,1);
		gridPane.setConstraints(tf5, 6,1);
	/*
		gridPane.setConstraints(addbtn, 0,3);
		gridPane.setConstraints(savebtn, 1,3);
		gridPane.setConstraints(backbtn, 2,3);
	*/		

		gridPane.setConstraints(addbtn, 8,20);
		gridPane.setConstraints(savebtn, 9,20);
		gridPane.setConstraints(backbtn, 10,20);



	}
	private void backPress(ActionEvent event) {
		//setLayout();
		//replace scene
		//g.clearRect(0, 0, scene.getWidth(), scene.getHeight());
		//menu.bindControl();
		//menu.animate(scene.getWidth(),scene.getHeight());
	    //menu.setButton();
		//menu.fixPosition();
		System.out.println(instructScene);
		//Scene backScene = new Scene(menu.borderPane, 400, 300);
		instructStage.setScene(instructScene);
		//instructStage.setTitle("Bug Bits!");
		menu.show(instructStage);
	}


	private void addRow(ActionEvent event){

		
		TextField new1 = new TextField();
		TextField new2 = new TextField();
		TextField new3 = new TextField();
		TextField new4 = new TextField();
		TextField new5 = new TextField();

		gridPane.getChildren().addAll(new1,new2,new3,new4,new5);
		gridPane.setConstraints(new1, 0,finalRow,3,1);
		gridPane.setConstraints(new2, 3,finalRow);
		gridPane.setConstraints(new3, 4,finalRow);
		gridPane.setConstraints(new4, 5,finalRow);
		gridPane.setConstraints(new5, 6,finalRow);
	
		finalRow+=1;

	}

	void updateTextFieldValue(){


		
	}

	private void saveRecord(ActionEvent event){
		MFileReader mfr = new MFileReader("questions.txt");

		StringBuilder sb = new StringBuilder();

//row 0 is label
		for (int i = 1; i < finalRow; i++){
			for (int j = 0; j < 7; j++){
					
//possible from if empty field, will cause problem
				String temp = getStringFromGridPane(i,j);
				if (!temp.isEmpty()){
					sb.append(temp);
					sb.append("`");
				}
				
			}
			sb.append("\n");
		}

		
		mfr.writeFile(sb.toString());
		

	}

	private String getStringFromGridPane(int row, int col){

		TextField tf = null;
		try{
			tf = (TextField) getNodeFromGridPane(row,col);	
		} catch (Exception e){
		//	e.printStackTrace();
			return "";
		}
		if (tf!=null){
			return tf.getText();
		}
		else return "";
	}

	private Node getNodeFromGridPane(int row, int col){
		for (Node node: gridPane.getChildren()){
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row){
				return node;
			}

		}
		return null;
	}

	private void redraw() {
		System.out.println("start redraw");
		g.clearRect(0, 0, scene.getWidth(), scene.getHeight());
	    g.drawImage(bg, canvas.getWidth()/4, canvas.getHeight()/4);
	}



	public Scene instructionShow() {
		backbtn.setOnAction(this::backPress);
		addbtn.setOnAction(this::addRow);
		savebtn.setOnAction(this::saveRecord);
		canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

        // redraw when resized
        canvas.widthProperty().addListener(observable -> redraw());
        canvas.heightProperty().addListener(observable -> redraw());
	 	return scene;
	}
}
