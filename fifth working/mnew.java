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



public class mnew{
    private int n = 0;
    int x=100;
    int channel = 1;
    MGraphics mgraphics;
    MTime mtime = new MTime();

  /*Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane stackPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);*/
  public mnew(MGraphics mgraphics){
    this.mgraphics = mgraphics;
  }


    public void handle(KeyEvent event) {
        if(event.getCode() == KeyCode.RIGHT) {
            System.out.println("RIGHT");

            if (channel < 3){
                channel +=1;
                x+=50;
                //set score in logic not graphics
                mgraphics.getScore().set(mgraphics.getScore().get()+1);
                //draw(g, x, bg, player);
                mgraphics.changePlayerPosition(x, 250);
            }
        }
        else if(event.getCode() == KeyCode.LEFT) {
            System.out.println("LEFT");
            if (channel >0){
                channel -=1;
                x-=50;

                mgraphics.changePlayerPosition(x, 250);
                //mgraphics.getSeq().play();

                //draw(g, x, bg, player);
            }
        }
    }

}
