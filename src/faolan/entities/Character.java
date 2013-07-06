package faolan.entities;

public abstract class Character extends Entity implements Dynamic {
	
	abstract void move();
	
	abstract void speak(String line);
	
}