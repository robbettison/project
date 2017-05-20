import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.image.*;


public class Fruit {

  Circle fruit;
  private int fruitPosition;
  private double XPosition;
  private double YPosition;
  private double initialX;
  private double initialY;
  private double initialRadius = 15;
  boolean impacted = false;
  int fruitBit;

  Fruit(int x, int y, Group G, int Position, int bitValue, Image fruitImage) {

    fruit = new Circle(x, y, 15);
    fruit.setFill(new ImagePattern(fruitImage));
    G.getChildren().add(fruit);
    XPosition=x;
    YPosition=y;
    initialX=x;
    initialY=y;
    fruitPosition = Position;
    fruitBit = bitValue;
  }

  public void update(double x, double y) {
    if(!(YPosition>650)&&fruitPosition==3) {
      XPosition = XPosition+x/3;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>650)&&fruitPosition==0) {
      XPosition = XPosition-x/3;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>650)&&fruitPosition==1) {
      XPosition = XPosition-x/10;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>650)&&fruitPosition==2) {
      XPosition = XPosition+x/10;
      YPosition = YPosition+y;
    }
    else {
      XPosition = initialX;
      YPosition = initialY;
      impacted =false;
      fruit.setRadius(initialRadius);
    }
    size(y);
  }

  public void draw() {
    fruit.setCenterX(XPosition);
    fruit.setCenterY(YPosition);
  }

  private void size(double radiusProportion) {
    fruit.setRadius(fruit.getRadius() + radiusProportion/40);

  }

  public boolean impacts(Bounds b) {
    return fruit.intersects(b);
  }

  public void setFill(ImagePattern color) {
    fruit.setFill(color);
  }

  public double getY() {
    return YPosition;
  }

  public int getfruitBit() {
    return fruitBit;
  }

  public void setFruitBit(int i) {
    fruitBit = i;
  }

  public boolean getImpacted() {
    return impacted;
  }

  public void setImpacted() {
    impacted = true;
  }
}
