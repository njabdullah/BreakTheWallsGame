// kelas gameplay digunakan untuk mengatur cara bermain game ini
package id.its.breakthewalls;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

// kelas meng-extend kelas JPanel dan meng-implements interface KeyListener dan ActionListener
public class Gameplay extends JPanel implements KeyListener, ActionListener{
	// inisialisasi variabel
	private boolean play = false;
	private int score = 0;
	private int level = 1;
	private int totalBricks = 21;
	
	private Timer time;
	private int delay = 8;
	
	public static int playerX = 245;
	
	private MapGenerator map;
	private Ball ball;
	private Menu menu;
	public static enum STATE{MENU, GAME};
	
	public static STATE state = STATE.MENU;

	public Gameplay() {
		map = new MapGenerator(3,7,0); // baris, kolom, dan score
		ball = new Ball(Color.GREEN);
		time = new Timer(delay, this);
		menu = new Menu();
		time.start();
		addKeyListener(this);
		this.addMouseListener(new MouseInput());
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	// menyetting tampilan
	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		
		if(state == STATE.GAME) {
			// map
			map.draw((Graphics2D)g);
			
			// bola
			ball.draw(g);
			
			//papan bawah
			g.setColor(Color.red);
			g.fillRect(playerX, 550, 150, 8);
			
			// skor
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Score : "+score, 560, 35);
			
			// level
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Level : "+level, 10, 35);
		}
		
		else if(state == STATE.MENU) {
			// tampilan menu
			menu.draw(g);
		}
		
		// menyetting tampilan saat menang
		if(totalBricks <= 0) {
			play = false;
			ball.setBallXdir(0);
			ball.setBallYdir(0);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Congratulation, Scores: "+score, 160, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Continue", 240, 325);
		}
		
		// menyetting tampilan saat kalah
		if(ball.getBallposY() > 570) {
			play = false;
			ball.setBallXdir(0);
			ball.setBallYdir(0);
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over, Scores: "+score, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 250, 325);
		}
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(state == STATE.GAME){
			if(play) {
				A: for(int i = 0; i < map.row; i++) {
					for(int j = 0; j <map.col; j++) {
						if(map.map[i][j].getValue() > 0) {
							// inisialisasi
							int brickX = j * map.brickWidth + 80;
							int brickY = i * map.brickHeight + 50;
							int brickWidth = map.brickWidth;
							int brickHeight = map.brickHeight;
							
							Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
							Rectangle ballRect = new Rectangle(ball.getBallposX(), ball.getBallposY(), 20,20);
							Rectangle brickRect = rect;
							
							if(ballRect.intersects(brickRect)) {
								// untuk level 2 dst
								if(score > 105){
									map.setBrickColor(i, j);
									totalBricks--;
								}
								// untuk level awal (level 1)
								else{
									map.setBrickValue(0, i, j);
									totalBricks--;
								}
								
								// setiap brick yang hilang poin akan bertambah 5
								score += 5;
								
								// setiap bola menyentuh brick di sumbu X, bola akan bertabrakan dan memantul
								if(ball.getBallposX()+ 19 <= brickRect.x || ball.getBallposX() + 1 >= brickRect.x + brickRect.width) {
									ball.collide(1);
								}
								// setiap bola menyentuh brick di sumbu Y, bola akan bertabrakan dan memantul
								else {
									ball.collide(2);
								}
								break A;
							}
						}
					}
				}
				ball.ballaction();
			}
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(state == STATE.GAME) {
			// menyetting pergerakan papan dengan implements keylistener
			if(e.getKeyCode() == KeyEvent.VK_D) {
				if(playerX >= 540) {
					playerX = 520;
				}
				else {
					moveRight();
				}
				
				if(new Rectangle(ball.getBallposX(), ball.getBallposY(), 20, 20).intersects(new Rectangle(playerX, 550,150,8))) {
					ball.setBallXdir(ball.getBallXdir() * -1);
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_A) {
				if(playerX < 10) {
					playerX = 20;
				}
				else {
					moveLeft();
				}
				
				if(new Rectangle(ball.getBallposX(), ball.getBallposY(), 20, 20).intersects(new Rectangle(playerX, 550,150,8))) {
					ball.setBallXdir(ball.getBallXdir() * -1);
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(!play) {
					if(score == 105) {
						this.level = 2;
						play = true;
						totalBricks = 96;
						map = new MapGenerator(4,12, 120);
						ball.setBallposX(300);
						ball.setBallposY(530);
						ball.setBallXdirRand();
						ball.setBallYdirRand();
						playerX = 310;
						this.score = 120;
					}
					else if(score == 600) {
						this.level = 3;
						play = true;
						totalBricks = 240;
						map = new MapGenerator(8,10, 600);
						ball.setBallposX(300);
						ball.setBallposY(530);
						ball.setBallXdirRand();
						ball.setBallYdirRand();
						playerX = 310;
						this.score = 600;
					}
					else if(score == 1800) {
						this.level = 4;
						play = true;
						totalBricks = 480;
						map = new MapGenerator(10,12, 1800);
						ball.setBallposX(300);
						ball.setBallposY(530);
						ball.setBallXdirRand();
						ball.setBallYdirRand();
						playerX = 310;
						this.score = 1800;
					}
					else if(score == 4200) {
						this.level = 5;
						play = true;
						totalBricks = 840;
						map = new MapGenerator(12,14, 4200);
						ball.setBallposX(300);
						ball.setBallposY(530);
						ball.setBallXdirRand();
						ball.setBallYdirRand();
						playerX = 310;
						this.score = 4200;
					}
					else{
						this.level = 1;
						play = true;
						totalBricks = 21;
						map = new MapGenerator(3,7, 0);
						ball.setBallposX(300);
						ball.setBallposY(530);
						ball.setBallXdirRand();
						ball.setBallYdirRand();
						playerX = 310;
						this.score = 0;
					}
					repaint();
				}
			}
		}
	}
	
	// method pergerakan papan
	public void moveRight() {
		play = true;
		playerX += 50;
	}
	
	public void moveLeft() {
		play = true;
		playerX -= 50;
	}
}