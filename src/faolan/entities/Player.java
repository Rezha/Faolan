package faolan.entities;

import java.awt.Graphics2D;

import faolan.io.Sprite;

public class Player extends Character {
	private int _direction, _frame;
	private int _xgridoffset, _ygridoffset;
	private int _xcor, _ycor, _xGridCor, _yGridCor;
	private boolean _up, _down, _left, _right;
	private boolean _isOnGrid;

	public Player() {
		_direction = 0;
		_frame = 1;
		_xcor = 0;
		_ycor = 0;
		_xGridCor = 5;
		_yGridCor = 5;
		_xgridoffset = 0;
		_ygridoffset = 0;
		_isOnGrid = true; // next step: make the player only move by 1 grid
							// square.
	}

	@Override
	public void update() {
		if (_up)
			_ygridoffset -= 2;
		if (_down)
			_ygridoffset += 2;
		if (_left)
			_xgridoffset -= 2;
		if (_right)
			_xgridoffset += 2;

		_isOnGrid = false;

		if (_xgridoffset >= 64 || _xgridoffset <= -64) {
			if (_xgridoffset >= 0)
				_xGridCor++;
			else
				_xGridCor--;
			_xgridoffset = 0;

		}
		if (_ygridoffset >= 64 || _ygridoffset <= -64) {
			if (_ygridoffset >= 0)
				_yGridCor++;
			else
				_yGridCor--;
			_ygridoffset = 0;
		}
		if (_xgridoffset == 0 && _ygridoffset == 0) {
			_isOnGrid = true;
		}
	}

	public boolean isOnGrid() {
		return _isOnGrid;
	}

	public void moveUp() {
		if (_isOnGrid) {
			_up = true;
			_down = _left = _right = false;
		}
	}

	public void moveDown() {
		if (_isOnGrid) {
			_down = true;
			_up = _left = _right = false;
		}
	}

	public void moveLeft() {
		if (_isOnGrid) {
			_left = true;
			_up = _down = _right = false;
		}
	}

	public void moveRight() {
		if (_isOnGrid) {
			_right = true;
			_up = _down = _left = false;
		}
	}

	public void stopMoving() {
		_up = _down = _left = _right = false;
	}

	public void draw(Graphics2D g2, int xoffset, int yoffset, int texturex,
			int texturey) {
		_xcor = xoffset + _xgridoffset + _xGridCor * 64; // these two lines
		_ycor = yoffset + _ygridoffset + _yGridCor * 64; // update player?

		g2.drawImage(Sprite.getTextures("Faolan"), _xcor, _ycor, _xcor + 64,
				_ycor + 64, _direction * 16, _frame * 16, _direction * 16 + 16,
				_frame * 16 + 16, null);
	}

	public int getXGridCor(){
		return _xGridCor;
	}
	
	public int getYGridCor(){
		return _yGridCor;
	}
	
	@Override
	void speak(String line) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

}
