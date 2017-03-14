import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.beans.property.*;
import javafx.scene.layout.*;



public class Main extends Application {
  
  MGraphics graphic = new MGraphics(0);
  Event Mevent = new Event();


  /*Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane stackPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);*/

  public void start(Stage stage) {

    graphic.setUp(stage);
    /*Group root = new Group(canvas);
    Scene road = new Scene(root);

    Label playerScore = new Label();
    playerScore.textProperty().bind(score.asString());

    StackPane stack = new StackPane();
    stack.getChildren().addAll(whiteBox1, playerScore);
    root.getChildren().add(stack);

    stage.setScene(road);*/
    //int x;
    //x = event.handle();
    //graphic.draw(Mevent.getCoordinate());
    graphic.show(stage);
    //graphic.getScene().setOnKeyPressed(Mevent::handle);
    //graphic.draw(Mevent.getCoordinate());
    //System.out.println(!(Mevent));
    while(false){
      graphic.getScene().setOnKeyPressed(Mevent::handle);
      graphic.draw(Mevent.getCoordinate());
    }

    //playerScore.setGraphic()

  }


  /*void draw(GraphicsContext g, int x, Image bg, Image player) {
    g.drawImage(bg, 0, 0);
    g.drawImage(player, x,175);
  }*/





}
