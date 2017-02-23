package groupProjectUI;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;

enum Move{
	Left,Right;
}


public class character extends Application{
	private Move move;
	Button star = new Button("oli");
	//LinkedList star = new LinkedList();
	public character() {

		// we need create a character:here!!and then add keylistener to him
		// to be finished------>character
		static EventType<keyPressed> () {

		}
		setOnAction(new KeyListener()) {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			// I search from java API that keyEvent has keyPressed function,VK_UP(reprent up)
			// and I can also transfer into code by getKeyCode(),it can be comparabled.
			public void keyPressed(KeyEvent e) {
				switch(e.getCode()){
					case KeyEvent.LEFT:
						move=Move.Left;
						break;
					case KeyEvent.RIGHT:
						move=Move.Right;
						break;
				}
			}
		});
		add(BorderLayout.SOUTH,star);
	}
	void doMove(){
		// when he moves,it will change his position in characterBody by creating construction
		characterBody star = null;
		switch(move){
			case Up:
				//star.getX(), star.getY()+1;
				break;
			case Down:
				//star.getX(), star.getY()-1;
				break;
			case Left:
				//star.getX()-1, star.getY();
				break;
			case Right:
				//star.getX()+1, star.getY();
				break;
		}
	}
}
