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
  private int QuestionMomentum=1;
  Soundtrack S1;

  Fruits(int numberFruit, Group G) {
    /*Colours.add(Color.BLUE);
    Colours.add(Color.GREEN);
    Colours.add(Color.RED);
    Colours.add(Color.YELLOW);*/
    level1 = new Questions(G);
    FruitImages.add(new Image("Images/applebit0.png"));//representing zero bit value
    FruitImages.add(new Image("Images/applebit1.png"));//representing one bit value
    /*FruitImages.add(new Image("Images/banana.png"));
    FruitImages.add(new Image("Images/pear.png"));*/
    for(int i=0;i<numberFruit;i++) {
      int random = rand.nextInt(10)%2;
      Fruit newFruit = new Fruit(290+i*5, 267, G, i, 0, FruitImages.get(0));
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

  void updatePositions(double timeElapsed, Player player, IntegerProperty score, Soundtrack S) {
    final double fruitMoved = timeElapsed*fruitVelocity;
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      currentFruit.update(fruitMoved, fruitMoved);
    }
    checkCollisions(player, score);
    S1=S;
    draw();
  }

  void draw() {
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      currentFruit.draw();
    }
  }

  private boolean impacted() {
    int noimpact=0;
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      if(currentFruit.getImpacted()==false) noimpact = noimpact + 1;
    }
    if(noimpact==4) return true;
    else return false;
  }

  void checkCollisions(Player player, IntegerProperty score) {
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      if(currentFruit.impacts(player.getBounds())&&currentFruit.getImpacted()==false&&impacted()&&currentFruit.getY()>649) {
        currentFruit.setImpacted();
        if(currentFruit.getfruitBit()==0&&level1.getTargetBit(i)==1) {
          currentFruit.setFill(new ImagePattern(FruitImages.get(1)));
          currentFruit.setFruitBit(1);
          S1.burp();
        }
        else if(currentFruit.getfruitBit()==1&&level1.getTargetBit(i)==0){
          currentFruit.setFill(new ImagePattern(FruitImages.get(0)));
          currentFruit.setFruitBit(0);
          S1.apple();
        }
        else {
          if(QuestionMomentum>1) {
            QuestionMomentum-=0.5;
            fruitVelocity-=0.5;
          }
          score.set(score.get()-10);
        }
        break;
      }
    }
    if(fruitBitsValue()==level1.getcurrentAnswer()) {
      score.set(score.get()+40);
      level1.getNextAnswer();
      if(QuestionMomentum<10) {
        QuestionMomentum+=0.5;
        fruitVelocity+=0.5;
      }
      end = level1.isEnd();
    }

  }

  public int getQuestionMomentum() {
    return QuestionMomentum;
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