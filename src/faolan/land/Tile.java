package faolan.land;

import java.awt.Graphics2D;

import faolan.io.Texture;

public class Tile {
	
	private String _key;
	private boolean _display;
	private boolean _walk;
	private int _texturex;
	private int _texturey;
	
	//private Texture (I'm not sure how this is going to work. Perhaps a texture, or just
	// a reference to a texture map or something. Probably going be an actual texture I guess.
	
	public Tile(String key, int texturex, int texturey){
		_key = key;
		_texturex = texturex;
		_texturey = texturey;
	}
	
	public void draw(Graphics2D g2, int xGridCor, int yGridCor, int xoffset, int yoffset){
		
		g2.drawImage(Texture.getTextures(_key), 
				xoffset + xGridCor * 64, yoffset + yGridCor * 64, 
				xoffset + xGridCor * 64 + 64, yoffset + yGridCor * 64 + 64, 
				_texturex * 16, _texturey * 16, 
				_texturex * 16 + 16, _texturey * 16 + 16, null);
		
	}
	
	public void update(){
		
	}
	
}
