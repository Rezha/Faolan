package faolan.graphics;

import java.awt.Rectangle;
import java.util.LinkedList;

public class Dialogue {
	private Rectangle _dframe; // just some rectangle. This might be an image later on.
	private LinkedList<Line> _convo;
	
	// here we should have some mechanism necessary for checking if a convo is valid to occur
	
	public Dialogue(LinkedList<Line> convo){
		_convo = convo;
	}
	
}
