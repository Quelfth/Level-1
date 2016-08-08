package photoQuiz;

// Copyright Wintriss Technical Schools 2013
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public static void main(String[] args) throws Exception {
		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image URL”)
		String URL = "http://www.printablee.com/postpic/2009/08/origami-paper-green-color_313344.jpg";
		// 2. create a variable of type "Component" that will hold your image
		Component img;
		// 3. use the "createImage()" method below to initialize your Component
		img = createImage(URL);
		// 4. add the image to the quiz window
		quizWindow.add(img);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		// 6. ask a question that relates to the image
		String answer = JOptionPane.showInputDialog("What color is this?");
		// 7. print "CORRECT" if the user gave the right answer
		if (answer.equalsIgnoreCase("green")) {
			JOptionPane.showMessageDialog(null, "CORRECT");
		}
		// 8. print "INCORRECT" if the answer is wrong
		else {
			JOptionPane.showMessageDialog(null, "INCORRECT");
		}
		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(img);
		// 10. find another image and create it (might take more than one line
		// of code)
		URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/2000px-Red_flag.svg.png";
		img = createImage(URL);
		// 11. add the second image to the quiz window
		quizWindow.add(img);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		answer = JOptionPane.showInputDialog("What color is this?");
		// 14+ check answer, say if correct or incorrect, etc.
		if (answer.equalsIgnoreCase("red")) {
			JOptionPane.showMessageDialog(null, "CORRECT");
		} else {
			JOptionPane.showMessageDialog(null, "INCORRECT");
		}
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
