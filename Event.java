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

public class Event {
   	private int n = 0;
   	private int x=100;
	private int channel = 1;

	Event(){

	}


	public void handle(KeyEvent event) {
    	if(event.getCode() == KeyCode.RIGHT) {
      		System.out.println("RIGHT");

	     	if (channel < 4){
	      		channel +=1;
	       		x+=50;
	   		// graphic.getScore().set(graphic.getScore().get()+1);
	        // draw(g, x, bg, player);
	       	// mainGame.draw(x);
	      	}
	    }
	    else if(event.getCode() == KeyCode.LEFT) {
		    System.out.println("LEFT");
		    if (channel >0){
		      	channel -=1;
		        x-=50;
		        //mainGame.draw(x);

		        //draw(g, x, bg, player);
		    }
		      //return x;
	    }
  }

  int getCoordinate(){
  	//System.out.println(x);
  	return this.x;
  }
}