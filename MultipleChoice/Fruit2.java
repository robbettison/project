import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.geometry.*;
import java.util.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import java.io.*;


public class Fruit2 {

  Circle fruit;
  private int fruitPosition;
  private double XPosition;
  private double YPosition;
  private double initialX;
  private double initialY;
  private double initialRadius = 15;
private Label label = new Label();
  String currentFontFile = "CabinSketch-Bold.ttf";
  InputStream fontStream = Main2.class.getResourceAsStream(currentFontFile);
  Font bgFont = Font.loadFont(fontStream, 17);

  //ArrayList<Color> Colours = new ArrayList<Color>();
  ArrayList<Image> Fruits = new ArrayList<Image>();
  Image fruitImage;
  String fruitAnswer;

  Fruit2(int x, int y, Group G, int i, Image fruitImage) {
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

G.getChildren().add(label);
    XPosition=x;
    YPosition=y;
    initialX=x;
    initialY=y;
    fruitPosition = i;
    fruitAnswer = "asda";
  }

void setLabel (String ans){





label.setText(ans);
label.setFont(bgFont);
if (fruitPosition == 0){
label.setTextFill(Color.BLUE);
}
else if (fruitPosition == 1){
label.setTextFill(Color.RED);
}
else if (fruitPosition == 2){
label.setTextFill(Color.GREEN);
}
else if (fruitPosition == 3){
label.setTextFill(Color.PURPLE);
}
label.setTranslateX(XPosition-10);
label.setTranslateY(YPosition+20);
label.toFront();

}


  public void update(double x, double y) {
    if(!(YPosition>640)&&fruitPosition==3) {
      XPosition = XPosition+x/3;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>640)&&fruitPosition==0) {
      XPosition = XPosition-x/3;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>640)&&fruitPosition==1) {
      XPosition = XPosition-x/10;
      YPosition = YPosition+y;
    }
    else if(!(YPosition>640)&&fruitPosition==2) {
      XPosition = XPosition+x/10;
      YPosition = YPosition+y;
    }
    else {
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

  public int getfruitPosition() {
    return fruitPosition;
  }

  public void setFruitPosition(int i) {
    fruitPosition = i;
  }

  public void setFruitImage(Image fruit) {
    fruitImage = fruit;
  }

  public String getFruitAnswer() {
    return fruitAnswer;
  }

void setFruitAnswer(String ans){
fruitAnswer = ans;
}

  public void setXstarting(int i) {
    initialX=i;
  }
}
