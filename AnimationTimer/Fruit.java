import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.image.*;


public class Fruit {

  Circle fruit;
  private int fruitNumber;
  private double XPosition;
  private double YPosition;
  private double initialX;
  private double initialY;
  private double initialRadius = 15;

  //ArrayList<Color> Colours = new ArrayList<Color>();
  ArrayList<Image> Fruits = new ArrayList<Image>();


  Fruit(int x, int y, Group G, int i) {
    Fruits.add(new Image("Images/apple.png"));
    Fruits.add(new Image("Images/pineapple.png"));
    Fruits.add(new Image("Images/banana.png"));
    Fruits.add(new Image("Images/pear.png"));

    /*Colours.add(Color.BLUE);
    Colours.add(Color.GREEN);
    Colours.add(Color.RED);
    Colours.add(Color.YELLOW);*/

    fruit = new Circle(x, y, 15);
    //fruit.setFill(Colours.get(i));
    fruit.setFill(new ImagePattern(Fruits.get(i)));
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
    fruit.setRadius(fruit.getRadius() + radiusProportion/20);

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

  public void setFill(ImagePattern color) {
    fruit.setFill(color);
  }

  public double getY() {
    return YPosition;
  }

  public Paint getImage() {
    return fruit.getFill();
  }

}
