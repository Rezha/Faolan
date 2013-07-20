package faolan.entities;

import java.awt.Graphics2D;

import faolan.io.Sprite;

public class Player extends Character {
	
	public Player() {
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

	
	@Override
	public void speak(String line) {
		// TODO Auto-generated method stub

	}



}
