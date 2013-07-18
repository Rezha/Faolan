package faolan.land;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Area{

	// this is basically one area you can cover w/o changescrn 
	protected Tile[][] _tiles;
	protected Building[] _buildings;
	protected int _xGridMin, _xGridMax, _yGridMin, _yGridMax;
	
	public Area(){
		_tiles = new Tile[100][100];
		for(int y = 0; y < 100; y++) {
			for(int x = 0; x < 100; x++) {
				if (y == 2 && x == 2)
					_tiles[x][y] = new Tile("Outside1A",4,0);
				else
					_tiles[x][y] = new Tile("Grass1A",0,0);
				if (y == 0 || y == 99 || x == 0 || x == 99)
					_tiles[x][y].setCanWalk(false);
				if (y == 2 && x == 2)
					_tiles[x][y].setCanWalk(false);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		return _tiles[x][y];
	}
	
	public void draw(Graphics2D g2, int xoffset, int yoffset, int startx, int maxx, int starty, int maxy){
		if (starty < 0)
			starty = 0;
		if (startx < 0)
			startx = 0;
		if (maxy > 100)
			maxy = 100;
		if (maxx > 100)
			maxx = 100;
		for(int y = starty; y < maxy; y++) {
			for(int x = startx; x < maxx; x++) {
				_tiles[x][y].draw(g2, x, y, xoffset, yoffset);
			}
		}	
	}
	
}
