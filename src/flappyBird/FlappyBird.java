package flappyBird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlappyBird implements KeyListener {
	int points = 0;
	boolean alive = true;
	int flappyY = 12;
	int flappyVel = 0;
	int pipe1X = 1024;
	int pipe1Y = 0;
	Pipe a = new Pipe();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel() {
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			Pipe.g = g;
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1000, 700);
			a.paint();
			g.setColor(Color.BLACK);
			g.fillOval(88, flappyY - 12, 24, 24);
		}
	};

	public static void main(String[] args) {
		FlappyBird me = new FlappyBird();
		me.run();
	}

	void run() {
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setPreferredSize(new Dimension(1000, 700));
		frame.pack();
		frame.setVisible(true);
		Random r = new Random();
		pipe1Y=r.nextInt(602);
		while (alive) {
			try {
				Thread.sleep(1000 / 60);
			} catch (Exception e) {
			}
			panel.repaint();
			flappyVel++;
			flappyY += flappyVel;
			if (flappyY > 688 || ((112 > pipe1X-24 && 88 < pipe1X+24) && !(flappyY > pipe1Y - 48 && flappyY < pipe1Y + 48)))
				alive = false;
			pipe1X -= 3;
			if (pipe1X < -24){
				pipe1X = 1024;
				pipe1Y = r.nextInt(602);
			}
		}
		frame.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		flappyVel = -10;
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
