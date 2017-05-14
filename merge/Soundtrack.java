/*This class acts as a repository of sounds that are called upon during the game.*/

import javafx.scene.media.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.*;
import java.util.*;
import javafx.beans.property.*;
import java.io.*;

public class Soundtrack {

  private static File file=new File("FinalFantasy.mp3");
  private static final String source=file.toURI().toString();

  Media soundTrack = new Media(source);
  MediaPlayer player = new MediaPlayer(soundTrack);
  MediaView mediaView = new MediaView(player);

  /*public Soundtrack(Group g) {
    //g.getChildren().addAll(mediaView, shootView);
    //player.play();
  }*/

  public void backgroundMusic() {
    player.play();
  }

  public void stopbackgroundMusic() {
    player.stop();
  }

  public void stop() {
    player.stop();
  }
}
