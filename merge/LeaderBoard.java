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

public class LeaderBoard {

    Stage window;
    private TableView<TopScore> table;
    private TextField nameInput;
    private Button confirm;
	private Button back;
    private int sc = 99;
    Scene newScene, oldScene;
	double width, height;
	MMenu menu = new MMenu();

    public LeaderBoard(Scene scene, Stage stage, double width, double height) {
        window = stage;
        window.setTitle("Leaderboard");
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
        table.setItems(getTopScore());
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
    public ObservableList<TopScore> getTopScore(){
        ObservableList<TopScore> topScores = FXCollections.observableArrayList();
        topScores.add(new TopScore("Kev", 100));
        topScores.add(new TopScore("Jiafeng", 80));
        topScores.add(new TopScore("Hugo", 50));
        topScores.add(new TopScore("Rob", 9));
        topScores.add(new TopScore("Oli", 22));
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
		window.setScene(oldScene);
		menu.show(window);
				

	}


    void setSc(int sc1){
      sc = sc1;
    }

	Scene leaderBoardShow(){
		return newScene;
	}
}
