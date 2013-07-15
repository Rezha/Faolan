package faolan.graphics;

import javax.swing.event.MouseInputListener;

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
	private int _xoffset, _yoffset, _xoffsetv, _yoffsetv;
	private boolean _running;
	private long _prevTime;

	public Screen() {
		_area = new Area();
		_xoffset = _yoffset = 0;
		_running = false;
		_prevTime = System.currentTimeMillis();
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

	public void update() {
		_prevTime = System.currentTimeMillis();
		_xoffset += _xoffsetv;
		_yoffset += _yoffsetv;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		_area.draw(g2, _xoffset, _yoffset);
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
			_yoffsetv = -2;
		}
		if (key == KeyEvent.VK_A) {
			_xoffsetv = -2;
		}
		if (key == KeyEvent.VK_S) {
			_yoffsetv = 2;
		}
		if (key == KeyEvent.VK_D) {
			_xoffsetv = 2;
		}
		System.out.println("x" + _xoffset + "y" + _yoffset);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			_yoffsetv = 0;
		}
		if (key == KeyEvent.VK_A) {
			_xoffsetv = 0;
		}
		if (key == KeyEvent.VK_S) {
			_yoffsetv = 0;
		}
		if (key == KeyEvent.VK_D) {
			_xoffsetv = 0;
		}
	}

}
