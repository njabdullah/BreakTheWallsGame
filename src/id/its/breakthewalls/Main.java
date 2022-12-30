package id.its.breakthewalls;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		obj.setBounds(10,10,700,600);
		Gameplay gameplay = new Gameplay();
		obj.setTitle("Break The Walls");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}
}