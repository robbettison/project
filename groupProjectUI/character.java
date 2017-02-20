package groupProjectUI;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import groupProject.characterBody;

enum Move{
	Up,Down,Left,Right;
}

@SuppressWarnings("serial")
public class character extends JPanel{
	private Move move;
	JButton star = new JButton("oli");
	//LinkedList star = new LinkedList();
	public character() {
		
		// we need create a character:here!!and then add keylistener to him
		// to be finished------>character
		addKeyListener(new KeyListener() {
			
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
				switch(e.getKeyCode()){
					case KeyEvent.VK_UP:
						move=Move.Up;
						break;
					case KeyEvent.VK_DOWN:
						move=Move.Down;
						break;
					case KeyEvent.VK_LEFT:
						move=Move.Left;
						break;
					case KeyEvent.VK_RIGHT:
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
