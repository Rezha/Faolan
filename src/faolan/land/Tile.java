package faolan.land;

public class Tile {
	private boolean _display;
	private boolean _type;
	private double _xcor;
	private double _ycor;
	private int _xGridCor; // x and y cor counting starting from top left!
	private int _yGridCor; // also, the CENTER is the physical cor of the tile;
	
	//private Texture (I'm not sure how this is going to work. Perhaps a texture, or just
	// a reference to a texture map or something. Probably going be an actual texture I guess.
	
	public Tile(/* Texture t, */ int x, int y){
		_xcor = x;
		_ycor = y;
	}
	
}
