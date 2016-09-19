package javaGUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JavaGUI implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel;
	JButton button = new JButton();
	JTextField textField = new JTextField(3);
	JLabel a = new JLabel();
	JLabel b = new JLabel();
	JLabel c = new JLabel();
	boolean isPressed = false;
	Random r = new Random();
	int money = 0;

	public static void main(String[] args) {
		JavaGUI gUI = new JavaGUI();
		gUI.update();
	}

	JavaGUI() {
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawString("$"+money, 100, 75);
			}
		};
		update();
	}

	void update() {
		frame.setVisible(true);
		panel.repaint();
		frame.add(panel);
		panel.setPreferredSize(new Dimension(200, 150));
		frame.pack();
		panel.add(button);
		a.setText("1");
		b.setText("2");
		c.setText("3");
		panel.add(a);
		panel.add(b);
		panel.add(c);
		panel.add(textField);
		button.addActionListener(this);
		
	}
	void buttonIsPressed(){
		for (int i = 0; i < 20; i++) {
			a.setText(r.nextInt(9) + "");
			b.setText(r.nextInt(9) + "");
			c.setText(r.nextInt(9) + "");
			panel.repaint();
		}
		int f=r.nextInt(8);
		if (f >= 7)
			f++;
		int s = 0;
		boolean sevens = false;
		boolean throak = false;
		boolean twoak = false;
		sevens = r.nextInt(19)==0;
		if(!sevens){
			throak = r.nextInt(4)==0;
		}
		if(!throak && !sevens){
			twoak = r.nextInt(2)==0;
			s=r.nextInt(2);
		}
		if(sevens){
			a.setText("7");
		}
		if(throak){
			a.setText(f+"");
		}
		if(twoak){
			if(s!=0)
				a.setText(f+"");
		}
		for (int i = 0; i < 5; i++) {
			b.setText(r.nextInt(9)+"");
			c.setText(r.nextInt(9)+"");
			panel.repaint();
		}
		if(sevens){
			b.setText("7");
		}
		if(throak){
			b.setText(f+"");
		}
		if(twoak){
			if(s!=1)
				b.setText(f+"");
		}
		for (int i = 0; i < 5; i++) {
			c.setText(r.nextInt(9)+"");
			panel.repaint();
		}
		if(sevens){
			c.setText("7");
			money += Integer.parseInt(textField.getText())*7;
			
		}
		if(throak){
			c.setText(f+"");
			money += Integer.parseInt(textField.getText());
		}
		if(twoak){
			if(s!=2)
				c.setText(f+"");
		}
		if(!sevens && !throak && !twoak){
			money -= Integer.parseInt(textField.getText());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button)
			buttonIsPressed();
	}
}
