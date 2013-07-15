package faolan.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Texture {
	private static HashMap<String, BufferedImage> _textures;

	public static void load() {
		_textures = new HashMap<String, BufferedImage>();
		try {
			_textures.put("Outside1A",
					ImageIO.read(new File("res/basic1.png")));
			_textures.put("Grass1A",
					ImageIO.read(new File("res/grass1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage getTextures(String key) {
		if (_textures.containsKey(key)){	
			return _textures.get(key);
		
		}
		else 
			System.out.println("uhoh");
		return new BufferedImage(0, 0, 0);
	}

}
