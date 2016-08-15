package movingBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class movingBox implements KeyListener {
	static int x = 0;
	static int y = 0;
	static boolean velXP = false;
	static boolean velXN = false;
	static boolean velYN = false;
	static boolean velYP = false;
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.black);
			g.fillRect(x, y, 50, 50);
		}
	};

	public void start() {
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.add(panel);
		panel.setPreferredSize(new Dimension(1500, 1050));
		frame.pack();

	}

	public static void main(String[] args) {
		movingBox box = new movingBox();
		box.start();
		while (true) {
			panel.repaint();
			if (velYP && (velYN == false)) {
				y--;
			}
			if (velYN && (velYP == false)) {
				y++;
			}
			if (velXP && (velXN == false)) {
				x++;
			}
			if (velXN && (velXP == false)) {
				x--;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			velYP = true;
			break;
		case KeyEvent.VK_S:
			velYN = true;
			break;
		case KeyEvent.VK_A:
			velXN = true;
			break;
		case KeyEvent.VK_D:
			velXP = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			velYP = false;
			break;
		case KeyEvent.VK_S:
			velYN = false;
			break;
		case KeyEvent.VK_A:
			velXN = false;
			break;
		case KeyEvent.VK_D:
			velXP = false;
			break;
		}
	}
}
