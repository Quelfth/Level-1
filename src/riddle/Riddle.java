package riddle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Riddle implements ActionListener {
	JFrame frame = new JFrame();
	 JPanel panel = new JPanel();
	 JLabel riddle = new JLabel();
	 JButton submit = new JButton();
	 JButton hint = new JButton();
	 JTextField answer = new JTextField(30);
	
	public Riddle(){
		frame.add(panel);
		panel.add(riddle);
		panel.add(submit);
		panel.add(hint);
		panel.add(answer);
		submit.addActionListener(this);
		hint.addActionListener(this);
		frame.setVisible(true);
		riddle.setText("Why did the chicken cross the road?");
		submit.setText("Submit");
		hint.setText("Hint");
	}
	
	void update(){
		frame.pack();
	}
	
	public static void main(String[] args) {
		Riddle me = new Riddle();
		while(true){
			me.update();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			if (answer.getText().equalsIgnoreCase("to get to the other side")||answer.getText().equalsIgnoreCase("to get to the other side.")||answer.getText().equalsIgnoreCase("to get to the other side!")) {
				JOptionPane.showMessageDialog(null, "Correct!");
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect; try again!");
			}
		}
		if(e.getSource() == hint) {
			JOptionPane.showMessageDialog(null, "It's not a trick question; you know this.");
		}
	}
}
