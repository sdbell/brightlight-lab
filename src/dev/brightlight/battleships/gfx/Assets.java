package dev.brightlight.battleships.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage water, patrolboat, submarine, cruiser, battleship, carrier; 

	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		
		water = sheet.crop(256, 32, width, height);
		patrolboat = sheet.crop(96, 32, width*2, height);
		submarine = sheet.crop(160, 32, width*3, height);
		cruiser = sheet.crop(0, 32, width*3, height);
		battleship = sheet.crop(160, 0, width*4, height);
		carrier = sheet.crop(0, 0, width*5, height);
		
	}
	
}
