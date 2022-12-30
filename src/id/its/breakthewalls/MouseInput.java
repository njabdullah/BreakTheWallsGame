// Kelas MouseInput digunakan untuk menyetting hasil inputan dari mouse
package id.its.breakthewalls;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class MouseInput implements MouseInputListener{

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		// bagian ini menyesuaikan ukuran dan posisi kotak playbutton di Menu
		if(mx >= 260 && mx <= 410) {
			if(my >= 220 && my <= 270) {
				Gameplay.state = Gameplay.STATE.GAME;
			}
		}
		// bagian ini menyesuaikan ukuran dan posisi kotak quitbutton di Menu
		if(mx >= 260 && mx <= 410) {
			if(my >= 300 && my <= 350) {
				System.exit(1);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}