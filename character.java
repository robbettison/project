package groupproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class character extends JFrame{
  JButton character = new JButton("kev");
  public character() {
	  character.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	 add(character);
     setVisible(true);
  }
  
  public static void main(String[] args) {
	character aCharacter = new character();
	
  }
}
