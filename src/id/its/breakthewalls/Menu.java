// kelas menu digunakan untuk membuat tampilan menu awal
package id.its.breakthewalls;

import java.awt.*;

public class Menu {
	// membuat method tampilan tombol di halaman menu
	public Rectangle playbutton = new Rectangle(260, 220, 150, 50); //Membuat tampilan kotak
	public Rectangle Quitbutton = new Rectangle(260, 300, 150, 50); //Membuat tampilan kotak
	
	// membuat method tampilan grafik game
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("Poppins", Font.BOLD, 44);
		
		// membuat judul game
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Break The Walls", 160, 175);
		
		// membuat judul game
		Font fnt2 = new Font("Poppins", Font.BOLD, 7);
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Made by JumboMentai", 280, 540);
		
		// membuat tampilan playbutton
		Font fnt1 = new Font("Poppins", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("PLAY", playbutton.x + 40, playbutton.y + 35);
		g2d.draw(playbutton);
		
		// membuat tampilan quit button
		g.setFont(fnt1);
		g.drawString("QUIT", Quitbutton.x + 40, Quitbutton.y + 35);
		g2d.draw(Quitbutton);
	}
}