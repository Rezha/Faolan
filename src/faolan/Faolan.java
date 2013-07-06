package faolan;

import javax.swing.JFrame;

import faolan.graphics.Screen;

public class Faolan {
	
	private JFrame _frame;
	private Screen _screen;
	
	public Faolan(){
		_frame = new JFrame();
		_screen = new Screen();
	}
	
	public void setup(){
		_screen.setup();
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setResizable(false);
		_frame.add(_screen);
		_frame.pack();
		_frame.setLocationRelativeTo(null);
		_frame.setVisible(true);
	}
	
	public void setScreen(Screen screen){
		_screen = screen;
		_frame.add(_screen);
	}
	
	public static void main(String[] args){
		Faolan game = new Faolan();
		game.setup();
	}
}
