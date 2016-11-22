package dev.brightlight.battleships.gfx;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage waterH, patrolboatH, submarineH, cruiserH, battleshipH, carrierH;
	public static BufferedImage waterV, patrolboatV, submarineV, cruiserV, battleshipV, carrierV; 

	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		
		waterH = sheet.crop(256, 32, width, height);
		patrolboatH = sheet.crop(96, 32, width*2, height);
		submarineH = sheet.crop(160, 32, width*3, height);
		cruiserH = sheet.crop(0, 32, width*3, height);
		battleshipH = sheet.crop(160, 0, width*4, height);
		carrierH = sheet.crop(0, 0, width*5, height);
		
		waterV = rotate(waterH, 90.0); // use as alternate tile to emulate "moving" water?
		patrolboatV = rotate(patrolboatH, 90.0);
		submarineV = rotate(submarineH, 90.0);
		cruiserV = rotate(cruiserH, 90.0);
		battleshipV = rotate(battleshipH, 90.0);
		carrierV = rotate(carrierH, 90.0);
		
	}
	
	public static BufferedImage rotate(BufferedImage image, double angle) {
		
		angle = Math.toRadians(angle);
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
	    GraphicsConfiguration gc = getDefaultConfiguration();
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
	    Graphics2D g = result.createGraphics();
	    g.translate((neww - w) / 2, (newh - h) / 2);
	    g.rotate(angle, w / 2, h / 2);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return result;
	    
	}

	private static GraphicsConfiguration getDefaultConfiguration() {
		
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    return gd.getDefaultConfiguration();
	    
	}
	
}
