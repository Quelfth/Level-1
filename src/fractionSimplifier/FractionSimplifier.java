package fractionSimplifier;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FractionSimplifier{
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
		frame.pack();
		int num = 0;
		int denom = 0;
		try{
			num = Integer.parseInt(numerator.getText());
			denom = Integer.parseInt(denominator.getText());
		}catch(Exception e){
		}
		result.setText(sf(simplify(num,denom)));
	}
	
	public static void main(String[] args){
		FractionSimplifier me = new FractionSimplifier();
		while(true){
			me.update();
		}
	}
	
	public String sf(int[] f){
		switch(f[1]){
		case 0:
			return "NaN";
		case 1:
			return f[0]+"";
		default:
			return f[0]+"/"+f[1];
		}
	}
	
	public int[] td(int div, int n, int d){
		if(n%div==0&&d%div==0){
			n/=div;
			d/=div;
		}
		int[] result = new int[2];
		result[0]=n;
		result[1]=d;
		return result;
	}
	
	public int[] td(int div, int[] f){
		return td(div, f[0], f[1]);
	}
	
	public boolean tdc(int div, int n, int d){
		if(n%div==0&&d%div==0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean tdc(int div, int[] f){
		return tdc(div, f[0], f[1]);
	}
	
	public int[] simplify(int numerator, int denominator){
		int[] f = new int[2];
		f[0]=numerator;
		f[1]=denominator;
		int LS = 0;
		if(f[0]<f[1]){
			LS = f[0];
		}else{
			LS = f[1];
		}
		for(int i = 2; i < LS;i++){
			System.out.println("Testing divisor "+i);
			f = td(i, f);
			if(tdc(i, f)){
				i=2;
			}
			System.out.println(sf(td(i, f)));
		}
		return f;
	}
}
