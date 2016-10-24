package colorTeacher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorTeacher implements ActionListener{
	JButton yellow = new JButton();
	JButton red = new JButton();
	JButton blue = new JButton();
	JButton green = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	void run(){
		frame.setVisible(true);
		frame.add(panel);
		panel.add(yellow);
		panel.add(red);
		panel.add(blue);
		panel.add(green);
		frame.pack();
		yellow.setBackground(Color.YELLOW);
		red.setBackground(Color.RED);
		blue.setBackground(Color.BLUE);
		green.setBackground(Color.GREEN);
		yellow.setOpaque(true);
		red.setOpaque(true);
		blue.setOpaque(true);
		green.setOpaque(true);
		yellow.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
	}
	void speak(String words){
		try{
			Runtime.getRuntime().exec("say " + words);
		}catch(Exception e){
		}
	}
	public static void main(String[] args){
		ColorTeacher me = new ColorTeacher();
		me.run();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == yellow)
			speak("yellow");
		if(e.getSource() == red)
			speak("red");
		if(e.getSource() == blue)
			speak("blue");
		if(e.getSource() == green)
			speak("green");
	}
}
