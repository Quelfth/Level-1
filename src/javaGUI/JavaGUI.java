package javaGUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaGUI implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel;
	JButton button = new JButton();

	public static void main(String[] args) {
		JavaGUI gUI = new JavaGUI();
		gUI.update();
	}

	JavaGUI() {
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawString("Hello World", 300, 200);
			}
		};
		update();
	}

	void update() {
		frame.setVisible(true);
		panel.repaint();
		frame.add(panel);
		panel.setPreferredSize(new Dimension(500, 700));
		frame.pack();
		panel.add(button);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
