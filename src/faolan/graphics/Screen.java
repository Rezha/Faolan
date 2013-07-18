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
	private boolean _isAligned;
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
			if (System.currentTimeMillis() - _prevTime > (50 / 3)) {
				update();
				repaint();
			}
		}
	}

	public void update() { // YOU SHOULD UPDATE PLAYER POS. ETC HERE!!
		_prevTime = System.currentTimeMillis();
		_isAligned = _player.isOnGrid();
		boolean canUp = _area.getTile(_player.getXGridCor(),
				_player.getYGridCor() - 1).getCanWalk();
		boolean canDown = _area.getTile(_player.getXGridCor(),
				_player.getYGridCor() + 1).getCanWalk();
		boolean canLeft = _area.getTile(_player.getXGridCor() - 1,
				_player.getYGridCor()).getCanWalk();
		boolean canRight = _area.getTile(_player.getXGridCor() + 1,
				_player.getYGridCor()).getCanWalk();
		System.out.println(_up);

		if (_up && canUp) {
			if (_isAligned) {
				_yoffsetv = 2;
				_xoffsetv = 0;
			}

			_player.moveUp();
		} else if (_down && canDown) {
			if (_isAligned) {
				_yoffsetv = -2;
				_xoffsetv = 0;
			}
			_player.moveDown();
		} else if (_left && canLeft) {
			if (_isAligned) {
				_xoffsetv = 2;
				_yoffsetv = 0;
			}
			_player.moveLeft();
		} else if (_right && canRight) {
			if (_isAligned) {
				_xoffsetv = -2;
				_yoffsetv = 0;
			}
			_player.moveRight();
		} else if (_player.isOnGrid())
			_player.stopMoving();
		if (_player.isOnGrid() && !_up && !_down && !_left && !_right) {
			_xoffsetv = 0;
			_yoffsetv = 0;
		}
		if (_isAligned) {
			if (((_up && !canUp) || (_down && !canDown)) && !_left && !_right
					&& !(_up && _down)) {
				_yoffsetv = 0;
				_xoffsetv = 0;
				if (_up)
					_up = false;
				if (_down)
					_down = false;
			}
			if (((_left && !canLeft) || (_right && !canRight)) && !_up
					&& !_down && !(_left && _right)) {
				_xoffsetv = 0;
				_yoffsetv = 0;
				if (_left)
					_left = false;
				if (_right)
					_right = false;
			}
		}
		_player.update();
		_xoffset += _xoffsetv;
		_yoffset += _yoffsetv;

	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		_area.draw(g2, _xoffset, _yoffset, -_xoffset / 64, -_xoffset / 64 + 17,
				-_yoffset / 64, -_yoffset / 64 + 13);
		_player.draw(g2, _xoffset, _yoffset, 0, 0);
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
