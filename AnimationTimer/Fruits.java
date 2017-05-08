import javafx.scene.shape.*;
import javafx.scene.paint.*;
import java.util.*;
import javafx.scene.*;


public class Fruits {

  List<Fruit> fruitArray = new ArrayList<Fruit>();
  List<Fruit> fruitSaLaD = new ArrayList<Fruit>();
  private int numberFruits;
  private int initialNumberFruit;
  private double fruitVelocity=1;
  Group allfruit;
  ArrayList<Color> Colours = new ArrayList<Color>();


  Fruits(int numberFruit, Group G) {
    Colours.add(Color.BLUE);
    Colours.add(Color.GREEN);
    Colours.add(Color.RED);
    Colours.add(Color.YELLOW);
    for(int i=0;i<numberFruit;i++) {
      Fruit newFruit = new Fruit(140+i*70, 30, G, i);
      fruitArray.add(newFruit);
      fruitSaLaD.add(newFruit);
    }
    numberFruits = numberFruit;
    initialNumberFruit = numberFruit;

    allfruit = G;
  }

  private void resetSalad() {
    for(int i=numberFruits-1;i>=0;i--) {
      Fruit currentFruit = fruitArray.get(i);
      currentFruit.remove(allfruit);
    }
    fruitArray=fruitSaLaD;
    shuffleSalad(fruitArray);
    //Collections.shuffle(fruitArray);
    //fruitArray.();
    numberFruits = initialNumberFruit;
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      //currentFruit.setFill();
      currentFruit.addTo(allfruit);
    }
  }

  private void shuffleSalad(List<Fruit> fruit) {
    Collections.shuffle(Colours);
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit=fruit.get(i);
      currentFruit.setFill(Colours.get(i));
    }
  }

  void updatePositions(double timeElapsed, Player player) {
    final double fruitMoved = timeElapsed*fruitVelocity;
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      currentFruit.update(fruitMoved, fruitMoved);
    }
    checkCollisions(player);
    draw();
  }

  void draw() {
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      currentFruit.draw();
    }
  }

  void checkCollisions(Player player) {
    for(int i=0;i<numberFruits;i++) {
      Fruit currentFruit = fruitArray.get(i);
      if(currentFruit.impacts(player.getBounds())&&currentFruit.getY()==640) {
        currentFruit.remove(allfruit);
        //fruitArray.remove(currentFruit);
        //numberFruits-=1;
        resetSalad();
        System.out.println("collides");
        break;
      }
    }
  }



}
