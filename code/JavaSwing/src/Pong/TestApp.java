package Pong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestApp {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame f = new JFrame("Pong");
				
				PongPanel pp = new PongPanel();
				f.add(pp);
				
				f.setSize(600, 400);
				f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				f.setResizable(false);
				f.setVisible(true);
				
				pp.init();
			}
		});
	}
}
