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
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.scene.paint.*;



public class old extends Application {
  private int n = 0;
  int x=100;
  int channel = 1;
  MGraphics mainGame = new MGraphics(0);
  MTime mtime = new MTime();

  /*Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane stackPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);*/

  public void start(Stage stage) {


    mainGame.setUp(stage);
    /*Group root = new Group(canvas);
    Scene road = new Scene(root);

    Label playerScore = new Label();
    playerScore.textProperty().bind(score.asString());

    StackPane stack = new StackPane();
    stack.getChildren().addAll(whiteBox1, playerScore);
    root.getChildren().add(stack);

    stage.setScene(road);*/
    mainGame.draw(x);
    mainGame.show(stage);

    //MGraphics oli_star = new MGraphics(0);
    mtime.time(mainGame.circles);
    //mainGame.setRandCircle();

    System.out.println("here");


    mainGame.getScene().setOnKeyPressed(this::handle);


    //playerScore.setGraphic()

  }

  /*void draw(GraphicsContext g, int x, Image bg, Image player) {
    g.drawImage(bg, 0, 0);
    g.drawImage(player, x,175);
  }*/



  public void handle(KeyEvent event) {
    if(event.getCode() == KeyCode.RIGHT) {
      System.out.println("RIGHT");

      if (channel < 3){
         channel +=1;
          x+=50;
          mainGame.getScore().set(mainGame.getScore().get()+1);
            //draw(g, x, bg, player);
            mainGame.draw(x);
      }
    }
    else if(event.getCode() == KeyCode.LEFT) {
      System.out.println("LEFT");
      if (channel >0){
            channel -=1;
            x-=50;

            mainGame.draw(x);

            //draw(g, x, bg, player);
      }
    }
  }


}
