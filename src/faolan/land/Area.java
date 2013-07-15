package faolan.land;

import java.awt.Graphics2D;

public class Area{

	// this is basically one area you can cover w/o changescrn 
	protected Tile[][] _tiles;
	protected Building[] _buildings;
	protected double _xoffset, _yoffset;
	
	public Area(){
		_tiles = new Tile[10][10];
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 10; x++) {
				_tiles[x][y] = new Tile("Grass1A",0,0);
			}
		}
	}
	
	public void draw(Graphics2D g2, int xoffset, int yoffset){
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 10; x++) {
				_tiles[x][y].draw(g2, x, y, xoffset, yoffset);
			}
		}	
	}
	
}
