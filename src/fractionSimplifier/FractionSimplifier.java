package fractionSimplifier;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FractionSimplifier {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField numerator = new JTextField(1);
	JTextField denominator = new JTextField(1);
	JLabel slash = new JLabel();
	JLabel result = new JLabel();
	
	public FractionSimplifier(){
		frame.setVisible(true);
		frame.add(panel);
		panel.add(numerator);
		panel.add(slash);
		panel.add(denominator);
		panel.add(result);
		slash.setText("/");
	}
	
	void update(){
		int num = 0;
		int denom = 0;
		try{
			num = Integer.parseInt(numerator.getText());
			denom = Integer.parseInt(denominator.getText());
		}catch(Exception e){
		}
		int[] res = simplify(num, denom);
	}
	
	public static void main(String[] args){
		FractionSimplifier me = new FractionSimplifier();
		while(true){
			me.update();
		}
	}
	
	public int[] simplify(int numerator, int denominator){
		for(int i = 2; i < numerator/2 && i < denominator/2; i++){
			if(numerator % i == 0 && denominator % i == 0){
				numerator /= i;
				denominator /= i;
			}
		}
		int[] result = new int[2];
		result[0] = numerator;
		result[1] = denominator;
		return result;
	}
}
