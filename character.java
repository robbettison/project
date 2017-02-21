package groupproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
HELLO ZHONG
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
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
  }

  public static void main(String[] args) {
	character aCharacter = new character();

  }
}
