package groupProjectUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * the main UI for us to show all of things
 * @author zhongjiafeng
 *
 */
public class MainUI {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				character star = new character();
				frame.add(star);
				frame.setSize(300, 200);
				frame.setVisible(true);
			}
		});
	}
}
