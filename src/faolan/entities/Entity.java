package faolan.entities;

import java.awt.Graphics2D;

public abstract class Entity {
	protected double _xcor;
	protected double _ycor;
	protected boolean _animated;
	//image file
	
	abstract void tick();
	
	public void draw(Graphics2D g2d){
		//g2d.paint(whatever);
	}
	
	public double getX() {
		return _xcor;
	}
	public void setX(double x) {
		_xcor = x;
	}
	public double getY() {
		return _ycor;
	}
	public void setY(double y) {
		_ycor = y;
	}
	
}
