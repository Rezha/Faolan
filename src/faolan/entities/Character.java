package faolan.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

import faolan.graphics.Dialogue;
import faolan.io.Sprite;

public class Character extends Entity implements Dynamic {
	
	protected int _direction, _frame;
	protected int _xgridoffset, _ygridoffset;
	protected int _xcor, _ycor, _xGridCor, _yGridCor;
	protected boolean _up, _down, _left, _right;
	protected boolean _isOnGrid;
	protected boolean _framedir;
	
	protected ArrayList<Dialogue> _dialogues;

	public Character() {
		_direction = 1;
		_frame = 1;
		_xcor = 0;
		_ycor = 0;
		_xGridCor = 5;
		_yGridCor = 5;
		_xgridoffset = 0;
		_ygridoffset = 0;
		_isOnGrid = true; // next step: make the player only move by 1 grid
							// square.
		_framedir = true;
	}
	
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
		
		if (Math.abs(_xgridoffset) % 32 == 2 || Math.abs(_ygridoffset % 32) == 2){
			if (_framedir && _frame < 2)
				_frame++;
			else if (_frame > 0){
				_framedir = false;
				_frame--;
			} else {
				_framedir = true;
				_frame++;
			}
		}
		System.out.println(_frame);
				

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
			_direction = 0;
		}
	}

	public void moveDown() {
		if (_isOnGrid) {
			_down = true;
			_up = _left = _right = false;
			_direction = 2;
		}
	}

	public void moveLeft() {
		if (_isOnGrid) {
			_left = true;
			_up = _down = _right = false;
			_direction = 3;
		}
	}

	public void moveRight() {
		if (_isOnGrid) {
			_right = true;
			_up = _down = _left = false;
			_direction = 1;
		}
	}

	public void stopMoving() {
		_up = _down = _left = _right = false;
	}

	public void draw(Graphics2D g2, int xoffset, int yoffset, int texturex,
			int texturey) {
		_xcor = xoffset + _xgridoffset + _xGridCor * 64; // these two lines
		_ycor = yoffset + _ygridoffset + _yGridCor * 64; // update player?

		g2.drawImage(Sprite.getTextures("Char1"), _xcor, _ycor - 30, _xcor + 64,
				_ycor + 64, _frame * 24, _direction * 32, _frame * 24 + 24,
				_direction * 32 + 32, null);
	}

	public int getXGridCor(){
		return _xGridCor;
	}
	
	public int getYGridCor(){
		return _yGridCor;
	}
	
	public void speak(String line){
		
	}
	
}