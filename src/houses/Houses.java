package houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class Houses {
	static Robot r = new Robot();
	static Random R = new Random();

	public static void main(String[] args) {
		r.setX(20);
		r.setY(930);
		r.setSpeed(10);
		r.penDown();
		for (int i = 0; i < 10; i++)
			drawHouse();
	}

	public static void drawHouse() {
		drawHouse("", "", new Color(R.nextInt(256),R.nextInt(256),R.nextInt(256)));
	}

	public static void drawHouse(String height, String pointyOrFlat, Color color) {
		int dist;
		switch (height) {
		case "tall":
			dist = 250;
			break;
		case "medium":
			dist = 120;
			break;
		case "short":
			dist = 60;
			break;
		default:
			int f = R.nextInt(3);
			switch (f) {
			case 0:
				dist = 60;
				break;
			case 1:
				dist = 120;
				break;
			case 2:
				dist = 250;
				break;
			default:
				dist = 0;
				break;
			}
			break;
		}
		boolean roof;
		switch (pointyOrFlat) {
		case "pointy":
			roof = true;
		case "flat":
			roof = false;
		default:
			roof = R.nextBoolean();
		}
		r.setPenColor(color);
		r.move(dist);
		if (roof) {
			r.turn(45);
			r.move(30);
			r.turn(90);
			r.move(30);
			r.turn(45);
		} else {
			r.turn(90);
			r.move(50);
			r.turn(90);
		}

		r.move(dist);
		r.turn(270);
		r.setPenColor(Color.GREEN);
		r.move(50);
		r.setPenColor(color);
		r.turn(270);
	}
}
