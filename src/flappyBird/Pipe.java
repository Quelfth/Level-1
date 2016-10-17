package flappyBird;

import java.awt.Color;
import java.awt.Graphics;

public class Pipe {
	int x = 0;
	int y = 0;
	static int yF = 0;
	public static Graphics g;
	static boolean hasCollided;
	
	public void update(){
		
		if((112 > x-24 && 88 < x+24) && !(yF > y - 48 && yF < y + 48)){
			
		}
	}
	
	
	public void paint(){
		g.setColor(Color.BLACK);
		g.fillRect(x - 24, 0, 48, 700);
		g.setColor(Color.WHITE);
		g.fillRect(x - 24, y - 48, 48, 96);
		g.setColor(Color.BLACK);
	}
}
