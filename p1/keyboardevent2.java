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



public class keyboardevent2 extends Application {
  private int n = 0;
  int x=100;
  int channel = 1;


  /*Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane stackPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);*/

  public void start(Stage stage) {

    Graphics mainGame = new Graphics(0);
    mainGame.setUp();
    /*Group root = new Group(canvas);
    Scene road = new Scene(root);

    Label playerScore = new Label();
    playerScore.textProperty().bind(score.asString());

    StackPane stack = new StackPane();
    stack.getChildren().addAll(whiteBox1, playerScore);
    root.getChildren().add(stack);

    stage.setScene(road);*/
    mainGame.draw(x);
    mainGame.show();
    road.setOnKeyPressed(this::handle);
    //playerScore.setGraphic()

  }

  /*void draw(GraphicsContext g, int x, Image bg, Image player) {
    g.drawImage(bg, 0, 0);
    g.drawImage(player, x,175);
  }*/



  public void handle(KeyEvent event) {
    if(event.getCode() == KeyCode.RIGHT) {
      System.out.println("RIGHT");

      if (channel < 4){
      channel +=1;
       x+=50;
    score.set(score.get()+1);
            draw(g, x, bg, player);
      }
    }
    else if(event.getCode() == KeyCode.LEFT) {
      System.out.println("LEFT");
      if (channel >0){
      channel -=1;
            x-=50;

            draw(g, x, bg, player);
      }
    }
  }


}
