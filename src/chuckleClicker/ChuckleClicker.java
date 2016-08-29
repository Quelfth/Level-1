package chuckleClicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener{
	JButton joke = new JButton();
	JButton punchline = new JButton();
	JFrame frame = new JFrame();
	public static void main(String[] args) {
		ChuckleClicker c = new ChuckleClicker();
		c.makeButtons();
	}

	void makeButtons() {
		JPanel panel = new JPanel();
		joke.setText("Joke");
		punchline.setText("Punchline");
		frame.add(panel);
		panel.add(joke);
		panel.add(punchline);
		joke.addActionListener(this);
		punchline.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == joke){
			JOptionPane.showMessageDialog(null, "Why did the chicken cross the road?");
		}
			
		if(e.getSource() == punchline){
			JOptionPane.showMessageDialog(null,"To get to the other side!");
			frame.dispose();
		}
	}
}
