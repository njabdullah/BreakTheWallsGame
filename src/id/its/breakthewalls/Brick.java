// kelas bricks digunakan untuk menyetting balok(bricks) yang disusun
package id.its.breakthewalls;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick {
	// inisialisasi
	private int value;
	private int brickWidth;
	private int brickHeight;
	private int x;
	private int y;

	// membuat method level, ukuran, dan posisi balok
	public Brick(int value, int brickWidth, int brickHeight, int X, int Y) {
		this.value = value;
		this.brickHeight = brickHeight;
		this.brickWidth = brickWidth;
		this.x = X;
		this.y = Y;
	}
	
	// membuat method tingkatan kekerasan balok
	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public void plusValue() {
		this.value++;
	}

	// membuat method ukuran balok
	public void setBrickWidth(int brickWidth) {
		this.brickWidth = brickWidth;
	}

	public void setBrickHeight(int brickHeight) {
		this.brickHeight = brickHeight;
	}
	
	public int getBrickWidth() {
		return brickWidth;
	}

	public int getBrickHeight() {
		return brickHeight;
	}
	
	// membuat method grafis mapping
	public void draw (Graphics2D g, int score) {
		// saat tingkatan bricks paling rendah hanya butuh satu sentuh agar hancur
		if(this.value == 1) {
			// saat level 1
			if(score == 0) {
				g.setColor(Color.GRAY);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 2
			if(score == 120) {
				g.setColor(Color.YELLOW);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 3
			if(score == 600) {
				g.setColor(Color.ORANGE);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 4
			if(score == 1800) {
				g.setColor(Color.PINK);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 5
			if(score == 4200) {
				g.setColor(Color.RED);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
		}
		
		// saat tingkatan bricks kedua paling rendah hanya butuh dua sentuh agar hancur
		if(this.value == 2) {
			// saat level 2
			if(score == 120) {
				g.setColor(Color.GRAY);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 3
			if(score == 600) {
				g.setColor(Color.YELLOW);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 4
			if(score == 1800) {
				g.setColor(Color.ORANGE);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 5
			if(score == 4200) {
				g.setColor(Color.PINK);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
		}
		
		// saat tingkatan bricks ketiga paling rendah butuh tiga sentuh agar hancur
		if(this.value == 3) {
			// saat level 3
			if(score == 600) {
				g.setColor(Color.GRAY);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 4
			if(score == 1800) {
				g.setColor(Color.YELLOW);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 5
			if(score == 4200) {
				g.setColor(Color.ORANGE);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
		}
		
		// saat tingkatan bricks kedua paling tinggi butuh empat sentuh agar hancur
		if(this.value == 4) {
			// saat level 4
			if(score == 1800) {
				g.setColor(Color.GRAY);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
			// saat level 5
			if(score == 4200) {
				g.setColor(Color.YELLOW);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
		}
		
		// saat tingkatan bricks paling tinggi butuh lima sentuh agar hancur
		if(this.value == 5) {
			// saat level 5
			if(score == 4200) {
				g.setColor(Color.GRAY);
				g.fillRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(y * brickWidth + 80, x * brickHeight + 50, brickWidth, brickHeight);
			}
		}
	}
}