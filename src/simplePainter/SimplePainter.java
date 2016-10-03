package simplePainter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimplePainter extends JPanel implements MouseListener, KeyListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	JFrame window;
	Color color = new Color(0, 0, 0);
	int radius = 25;

	Random r = new Random();
	ArrayList<Dot> dots = new ArrayList<Dot>();

	public static void main(String[] args) {
		new SimplePainter();
	}

	public SimplePainter() {
		window = new JFrame();
		window.add(this);
		window.getContentPane().setPreferredSize(new Dimension(500, 500));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();

		run();
	}

	private void run() {
		// 1. Make the window respond to mouse clicks
		window.addMouseListener(this);
		// 2. Use the addDot() method to create a new dot at the mouse's x and y
		// position when the mouse is clicked. Call the repaint() method to
		// update the window.

		// 3. Make the window respond to keyboard presses
		window.addKeyListener(this);
		// 4. Use the changeDotColor(Color) method to change the dots color when
		// the number keys are pressed
		// 5. Add a key to make the dot color random

		// 6. Implement the MouseMotionListener interface
		// 7. Draw a stream of dots when the mouse is clicked and dragged
		window.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		for (Dot d : dots) {
			d.draw(g);
		}
	}

	private void addDot(int x, int y) {
		dots.add(new Dot(x - radius, y - (radius+25), radius*2, radius*2, color));
	}

	private void changeDotColor(Color c) {
		color = c;
	}

	private void changeDotColor(int R, int G, int B) {
		changeDotColor(new Color(R, G, B));
	}

	private class Dot {
		int x;
		int y;
		int width;
		int height;

		Color c = new Color(0, 0, 0);

		public Dot(int x, int y, int width, int height, Color c) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.c = c;
		}

		public void draw(Graphics g) {
			g.setColor(c);
			g.fillOval(x, y, width, height);
		}

		public void setColor(Color c) {
			this.c = c;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		addDot(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_1:
			changeDotColor(Color.black);
			break;
		case KeyEvent.VK_2:
			changeDotColor(Color.red);
			break;
		case KeyEvent.VK_3:
			changeDotColor(Color.orange);
			break;
		case KeyEvent.VK_4:
			changeDotColor(Color.yellow);
			break;
		case KeyEvent.VK_5:
			changeDotColor(Color.green);
			break;
		case KeyEvent.VK_6:
			changeDotColor(Color.cyan);
			break;
		case KeyEvent.VK_7:
			changeDotColor(Color.blue);
			break;
		case KeyEvent.VK_8:
			changeDotColor(new Color(127, 0, 255));
			break;
		case KeyEvent.VK_9:
			changeDotColor(Color.magenta);
			break;
		case KeyEvent.VK_0:
			changeDotColor(Color.white);
			break;
		case KeyEvent.VK_MINUS:
			radius = radius>0?radius-1:radius;
			break;
		case KeyEvent.VK_EQUALS:
			radius++;
			break;
		default:
			switch (r.nextInt(5)) {
			case 0:
				changeDotColor(255, 0, r.nextInt(255));
				break;
			case 1:
				changeDotColor(255, r.nextInt(255), 0);
				break;
			case 2:
				changeDotColor(0, 255, r.nextInt(255));
				break;
			case 3:
				changeDotColor(r.nextInt(255), 255, 0);
				break;
			case 4:
				changeDotColor(0, r.nextInt(255), 255);
				break;
			case 5:
				changeDotColor(r.nextInt(255), 0, 255);
				break;
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		addDot(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
