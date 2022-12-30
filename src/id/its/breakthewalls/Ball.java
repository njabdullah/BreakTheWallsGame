// kelas ball digunakan untuk menyetting bola
package id.its.breakthewalls;

import java.awt.*; 

public class Ball {
	// inisialisasi variabel
	// menyetting kecepatan bola
	int vel1 = 5;
	int vel2 = 5;
	
	private Color color;
	private int ballposX = 300;
	private int ballposY = 530;
	private int ballXdir = vel1;
	private int ballYdir = vel2;
	
	// membuat method posisi bola
	public void setBallposX(int ballposX) {
		this.ballposX = ballposX;
	}
	
	public int getBallposX() {
		return ballposX;
	}

	public void setBallposY(int ballposY) {
		this.ballposY = ballposY;
	}
	
	public int getBallposY() {
		return ballposY;
	}

	// membuat method kecepatan bola
	public void setBallXdir(int d) {
		this.ballXdir = d;
		if(this.ballXdir == 0) {
			d++;
		}
	}
	
	public int getBallXdir() {
		return ballXdir;
	}
	
	public void setBallXdirRand() {
		this.ballXdir = vel2;
	}
		
	public void setBallYdir(int ballYdir) {
		this.ballYdir = ballYdir;
		if(this.ballYdir == 0) {
			ballYdir++;
		}
	}
	
	public int getBallYdir() {
		return ballYdir;
	}
	
	public void setBallYdirRand() {
		this.ballYdir = vel1;
	}
	
	// membuat method warna bola
	public Ball(Color color) {
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(ballposX, ballposY, 20, 20);
	}
	
	public void ballaction() {
		// posisi akhir bola adalah posisi awal + kecepatan bola
		this.setBallposX(this.getBallXdir() + this.getBallposX());
		this.setBallposY(this.getBallYdir() + this.getBallposY());
		
		if(new Rectangle(this.getBallposX(), this.getBallposY(), 20, 20).intersects(new Rectangle(Gameplay.playerX, 550,150,8))) {
			this.setBallYdir(this.getBallYdir() * -1);
		}
		
		// menyetting agar bola berbalik arah (memantul) saat menabrak dinding kiri
		if(this.getBallposX() < 0) {
			if(this.getBallXdir() == 0) {
				this.setBallXdir(-(vel1));
			}
			System.out.println(this.getBallXdir() + " " + this.getBallYdir());
			this.setBallXdir(this.getBallXdir()*-1);
		}
		
		// menyetting agar bola berbalik arah (memantul) saat menabrak dinding atas
		if(this.getBallposY()< 0) {
			if(this.getBallYdir() == 0) {
				this.setBallYdir(-(vel1));
			}
			System.out.println(this.getBallYdir() + " " + this.getBallYdir());
			this.setBallYdir(this.getBallYdir()*-1);
		}
		
		// menyetting agar bola berbalik arah (memantul) saat menabrak dinding kanan
		if(this.getBallposX() > 670) {
			if(this.getBallXdir() == 0) {
				this.setBallXdir(-(vel1));
			}
			System.out.println(this.getBallXdir() + " " + this.getBallYdir());
			this.setBallXdir(this.getBallXdir()*-1);
		}
	}
	
	public void collide(int i) {
		if(i == 1) {
			this.setBallXdir(this.getBallXdir() * -1);
		}
		else if(i == 2) {
			this.setBallYdir(this.getBallYdir() * -1);
		}
	}
}