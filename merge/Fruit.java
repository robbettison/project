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

  //ArrayList<Color> Colours = new ArrayList<Color>();
  ArrayList<Image> Fruits = new ArrayList<Image>();
  Image fruitImage;
  int fruitBit;

  Fruit(int x, int y, Group G, int Position, int bitValue, Image fruitImage) {
    /*Fruits.add(new Image("Images/apple.png"));
    Fruits.add(new Image("Images/pineapple.png"));
    Fruits.add(new Image("Images/banana.png"));
    Fruits.add(new Image("Images/pear.png"));*/

    /*Colours.add(Color.BLUE);
    Colours.add(Color.GREEN);
    Colours.add(Color.RED);
    Colours.add(Color.YELLOW);*/

    fruit = new Circle(x, y, 15);
    //fruit.setFill(Colours.get(i));
    fruit.setFill(new ImagePattern(fruitImage));
    this.fruitImage = fruitImage;
    G.getChildren().add(fruit);
    XPosition=x;
    YPosition=y;
    initialX=x;
    initialY=y;
    fruitPosition = Position;
    fruitBit = bitValue;
  }

  public void update(double x, double y) {
    if(!(YPosition>700)&&fruitPosition==3) {
      XPosition = XPosition+x/3;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>700)&&fruitPosition==0) {
      XPosition = XPosition-x/3;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>700)&&fruitPosition==1) {
      XPosition = XPosition-x/10;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>700)&&fruitPosition==2) {
      XPosition = XPosition+x/10;
      YPosition = YPosition+y;
    }
    else {
    //System.out.println(XPosition);
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
    System.out.println(fruit.intersects(b));
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

  public int getfruitPosition() {
    return fruitPosition;
  }

  public void setFruitPosition(int i) {
    fruitPosition = i;
  }

  public void setFruitImage(Image fruit) {
    fruitImage = fruit;
  }

  public int getfruitBit() {
    return fruitBit;
  }

  public void setFruitBit(int i) {
    fruitBit = i;
  }

  public void setXstarting(int i) {
    initialX=i;
  }
}
