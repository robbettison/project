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



public class MUI{
    private int n = 0;
    int x=275;
    int channel = 2;
    MGraphics mgraphics;
Circle temp = null;

  /*Canvas canvas = new Canvas(400, 300);
  Image bg = new Image("road.jpeg");
  Image player = new Image ("player.png");
  Image whiteBox = new Image("Box.png");
  ImageView whiteBox1 = new ImageView(whiteBox);
  GraphicsContext g = canvas.getGraphicsContext2D();
  StackPane stackPane = new StackPane();
  IntegerProperty score = new SimpleIntegerProperty(0);*/
  public MUI (MGraphics mgraphics){
    this.mgraphics = mgraphics;
  }



  public void checkWin(){

	Circle winningCircle = null;
	try{ 
		winningCircle = mgraphics.checkIntersect();
	} catch (Exception e){
	
	}
	mgraphics.restoreCheck1(temp);

      if (winningCircle != null && winningCircle != temp){

		temp = winningCircle;

        mgraphics.getScore().set(mgraphics.getScore().get()+1);

mgraphics.removeGraphic(winningCircle);
 
      }

  }

    public void handle(KeyEvent event) {


        if(event.getCode() == KeyCode.RIGHT) {
            System.out.println("RIGHT");

            if (channel < 3){
                channel +=1;
                x+=125;
                //set score in logic not graphics

                //draw(g, x, bg, player);
                mgraphics.changePlayerPosition(x, 800);


            }
        }
        else if(event.getCode() == KeyCode.LEFT) {
            System.out.println("LEFT");
            if (channel >0){
                channel -=1;
                x-=125;

                mgraphics.changePlayerPosition(x, 800);
                //mgraphics.getSeq().play();

                //draw(g, x, bg, player);
            }
        }
    }

}
