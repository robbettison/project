import javafx.scene.shape.*;
import javafx.scene.paint.*;
import java.util.*;
import javafx.scene.*;
import javafx.beans.property.*;
import javafx.scene.image.*;
import java.lang.Math.*;


public class Fruits {

  List<Fruit> fruitArray = new ArrayList<Fruit>();
  List<Fruit> fruitSaLaD = new ArrayList<Fruit>();
  private int numberFruits;
  private int initialNumberFruit;
  private double fruitVelocity=1;
  Group allfruit;
  //ArrayList<Color> Colours = new ArrayList<Color>();
  ArrayList<Image> FruitImages = new ArrayList<Image>();
  Questions level1;
  Random rand = new Random();
  boolean end = false;

  Fruits(int numberFruit, Group G) {
    /*Colours.add(Color.BLUE);
    Colours.add(Color.GREEN);
    Colours.add(Color.RED);
    Colours.add(Color.YELLOW);*/
    level1 = new Questions(G);
    FruitImages.add(new Image("Images/applecore0.png"));//representing zero bit value
    FruitImages.add(new Image("Images/apple1.png"));//representing one bit value
    /*FruitImages.add(new Image("Images/banana.png"));
    FruitImages.add(new Image("Images/pear.png"));*/
    for(int i=0;i<numberFruit;i++) {
      int random = rand.nextInt(10)%2;
      Fruit newFruit = new Fruit(290+i*5, 267, G, i, random, FruitImages.get(random));
      fruitArray.add(newFruit);
      fruitSaLaD.add(newFruit);
    }
    numberFruits = numberFruit;
    initialNumberFruit = numberFruit;

    allfruit = G;
  }

  int setRandNum(ArrayList<Integer> temp){
    Random rand = new Random();
    int x = rand.nextInt(4);
    while(temp.contains(x)){
      x = rand.nextInt(4);
    }
    temp.add(x);
    return x;
  }

  void updatePositions(double timeElapsed, Player player, IntegerProperty score) {
    final double fruitMoved = timeElapsed*fruitVelocity;
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      currentFruit.update(fruitMoved, fruitMoved);
    }
    checkCollisions(player, score);
    draw();
  }

  void draw() {
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      currentFruit.draw();
    }
  }

  void checkCollisions(Player player, IntegerProperty score) {
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      if(currentFruit.impacts(player.getBounds())&&currentFruit.getY()==640) {
        if(currentFruit.getfruitBit()==0&&level1.getTargetBit(i)==1) {
          currentFruit.setFill(new ImagePattern(FruitImages.get(1)));
          currentFruit.setFruitBit(1);
        }
        else if(currentFruit.getfruitBit()==1&&level1.getTargetBit(i)==0){
          currentFruit.setFill(new ImagePattern(FruitImages.get(0)));
          currentFruit.setFruitBit(0);
        }
        else {
System.out.println("wrong");
          score.set(score.get()-10);
        }
        break;
      }
    }
    if(fruitBitsValue()==level1.getcurrentAnswer()) {
      score.set(score.get()+40);
System.out.println("correct");
      level1.getNextAnswer();
      end = level1.isEnd();
    }

  }

  boolean isEnd(){
    return end;
  }
  private double fruitBitsValue() {
    double x = 0;
    for(int i=0;i<4;i++) {
      x = x + fruitArray.get(i).getfruitBit()* (Math.pow(2, 3-i));
    }
    return x;
  }
}
