// kelas MapGenerator digunakan untuk menyetting map & background
package id.its.breakthewalls;

import java.awt.Graphics2D;

public class MapGenerator {
	// inisialisasi awal
	public Brick[][] map = new Brick[20][30];
	public int row;
	public int col;
	public int brickWidth;
	public int brickHeight;
	public int score;
	
	// membuat method untuk map awal
	public MapGenerator(int row, int col, int score) {
		// inisialisasi
		this.col = col;
		this.row = row;
		this.score = score;
		brickWidth = 540/col; //lebar balok
		brickHeight = 150/row; //panjang balok
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				map[i][j] = new Brick(1, 540/col, 150/row, i, j);
			}
		}	
	}
	
	public void draw (Graphics2D g) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				map[i][j].draw(g, this.score);
			}
		}
	}
	
	// method untuk tingkatan value
	public void setBrickValue(int value, int row, int col) {
		map[row][col].setValue(value);
	}
	
	// method untuk menyetting warna tingkatan value
	public void setBrickColor(int row, int col) {
		map[row][col].plusValue();
		if(map[row][col].getValue() == 3 && this.score == 120) {
			setBrickValue(0,row,col);
		}
		if(map[row][col].getValue() == 4 && this.score == 600) {
			setBrickValue(0,row,col);
		}
		if(map[row][col].getValue() == 5 && this.score == 1800) {
			setBrickValue(0,row,col);
		}
		if(map[row][col].getValue() == 6 && this.score == 4200) {
			setBrickValue(0,row,col);
		}
	}
}