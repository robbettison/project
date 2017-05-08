import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.geometry.*;
import java.util.*;


public class Fruit {

  Circle fruit;
  private int fruitNumber;
  private double XPosition;
  private double YPosition;
  private double initialX;
  private double initialY;
  private double initialRadius = 15;

  ArrayList<Color> Colours = new ArrayList<Color>();


  Fruit(int x, int y, Group G, int i) {
    Colours.add(Color.BLUE);
    Colours.add(Color.GREEN);
    Colours.add(Color.RED);
    Colours.add(Color.YELLOW);

    fruit = new Circle(x, y, 15);
    fruit.setFill(Colours.get(i));
    G.getChildren().add(fruit);
    XPosition=x;
    YPosition=y;
    initialX=x;
    initialY=y;
    fruitNumber = i;
  }

  public void update(double x, double y) {
    if(!(YPosition>640)&&fruitNumber==3) {
      XPosition = XPosition+x/16;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>640)&&fruitNumber==0) {
      XPosition = XPosition-x/16;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>640)&&fruitNumber==1) {
      XPosition = XPosition-x/48;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>640)&&fruitNumber==2) {
      XPosition = XPosition+x/48;
      YPosition = YPosition+y;
    }
    else {
      System.out.println(fruit.getCenterX());
      XPosition = initialX;
      YPosition = initialY;
      fruit.setRadius(initialRadius);
    }
    size(y);
  }

  public void draw() {
    fruit.setCenterX(XPosition);
    fruit.setCenterY(YPosition);
  }

  private void size(double radiusProportion) {
    fruit.setRadius(fruit.getRadius() + radiusProportion/30);

  }

  public boolean impacts(Bounds b) {
    return fruit.intersects(b);
  }

  public void remove(Group g) {
    g.getChildren().remove(fruit);
  }

  public void addTo(Group G) {
    G.getChildren().add(fruit);
  }

  public void setFill(Color color) {
    fruit.setFill(color);
  }

  public double getY() {
    return YPosition;
  }

}
