package dev.brightlight.battleships;

import dev.brightlight.battleships.display.Display;

public class Launcher {
	
	public static void main(String[] args){
		
		Game game = new Game("Battleships", 640, 360);
		game.start();
		
	}

}
