package main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class animate {
	public static void animate_loading() {
		ImageIcon icon = new ImageIcon(Main.class.getResource("/img/animation.gif").getFile());
		JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public static void animate_sucess() {
		JOptionPane.showMessageDialog(null, "Information", "Press Ok", JOptionPane.INFORMATION_MESSAGE);
	}

}

public class animation_file {

	public animation_file() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
