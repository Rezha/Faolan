package faolan.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Sprite {
	private static HashMap<String, BufferedImage> _sprites;

	public static void load() {
		_sprites = new HashMap<String, BufferedImage>();
		try {
			_sprites.put("Faolan",
					ImageIO.read(new File("res/faolan.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage getTextures(String key) {
		if (_sprites.containsKey(key)){	
			return _sprites.get(key);
		
		}
		else 
			System.out.println("uhoh");
		return new BufferedImage(0, 0, 0);
	}

}
