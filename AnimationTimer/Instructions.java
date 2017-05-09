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


public class Instructions {
	Stage instructStage;
	Scene instructScene;
	double width, height;
	Canvas canvas = new Canvas(400, 300);
    Image bg = new Image("Bug.png");
    //ImageView bgView = new ImageView(bg);
    GraphicsContext g = canvas.getGraphicsContext2D();
	BorderPane borderPane = new BorderPane();
	Scene scene = new Scene(borderPane, 400, 300);
	Button back = new Button("back");
	MMenu menu = new MMenu();
	ScrollBar sc = new ScrollBar();


	public Instructions(){}

	private void draw(GraphicsContext g, Image bg) {
	  	g.drawImage(bg, 0, 0);
	}

	public Instructions(Scene scene, Stage stage, double width, double height){
		this.instructScene = scene;
		this.instructStage = stage;
		this.width = width;
		this.height = height;
	}


	private void setLayout(){

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setStyle("-fx-background-color: #336699;");
		hbox.getChildren().add(back);

		borderPane.getChildren().add(canvas);
		borderPane.setStyle("-fx-background-color: GREEN;");
		borderPane.setBottom(hbox);
		sc.setLayoutX(scene.getWidth()-sc.getWidth());
        //sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        //sc.setPrefHeight(900);
        //sc.setMax(600);
		borderPane.getChildren().add(sc);
		sc.valueProperty().addListener((ov, old_val, new_val) -> {
            sc.setLayoutY(-new_val.doubleValue());
        });
	}
	private void press(ActionEvent event) {
		//setLayout();
		// replace scene
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

	private void redraw() {
		System.out.println("start redraw");
		g.clearRect(0, 0, scene.getWidth(), scene.getHeight());
	    g.drawImage(bg, canvas.getWidth()/4, canvas.getHeight()/4);
	}


	public Scene instructionShow() {
		setLayout();
		back.setOnAction(this::press);
		canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

        // redraw when resized
        canvas.widthProperty().addListener(observable -> redraw());
        canvas.heightProperty().addListener(observable -> redraw());
	 	return scene;
	}
}