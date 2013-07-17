package faolan.graphics;

import javax.swing.event.MouseInputListener;

import faolan.entities.Player;
import faolan.land.Area;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Screen extends Canvas implements KeyListener, MouseInputListener,
		Serializable {

	private static final long serialVersionUID = -7452150000807143969L;

	private Area _area;
	private Player _player;
	private int _xoffset, _yoffset, _xoffsetv, _yoffsetv;
	private boolean _running, _up, _down, _right, _left;
	private long _prevTime;
	

	public Screen() {
		_area = new Area();
		_xoffset = _yoffset = 0;
		_running = _up = _down = _left = _right = false;
		_prevTime = System.currentTimeMillis();
		_player = new Player();

	}

	public void setup() {

		setPreferredSize(new Dimension(1024, 728));
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	public void run() {
		_running = true;
		while (_running) {
			if (System.currentTimeMillis() - _prevTime > (50/3)) {
				update();
				repaint();
			}
		}
	}

	public void update() { // YOU SHOULD UPDATE PLAYER POS. ETC HERE!!
		_prevTime = System.currentTimeMillis();
		if (_up){
			_yoffsetv = 2;
			_player.moveUp();
		} else if (_down) {
			_yoffsetv = -2;
			_player.moveDown();
		} else if (_left) {
			_xoffsetv = 2;
			_player.moveLeft();
		} else if (_right) {
			_xoffsetv = -2;
			_player.moveRight();
		} else if (_player.isOnGrid())
			_player.stopMoving();
		_xoffset += _xoffsetv;
		_yoffset += _yoffsetv;
		
		_xoffsetv = _yoffsetv = 0;
		
		_player.update();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		_area.draw(g2, _xoffset, _yoffset);
		_player.draw(g2, _xoffset, _yoffset, 0, 0 );
	}

	public void shutdown() {
		_running = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			_up = true;
		}
		if (key == KeyEvent.VK_A) {
			_left = true;
		}
		if (key == KeyEvent.VK_S) {
			_down = true;
		}
		if (key == KeyEvent.VK_D) {
			_right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			_up = false;
		}
		if (key == KeyEvent.VK_A) {
			_left = false;
		}
		if (key == KeyEvent.VK_S) {
			_down = false;
		}
		if (key == KeyEvent.VK_D) {
			_right = false;
		}
	}

}
