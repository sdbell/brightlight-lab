package dev.brightlight.battleships.entities;

public abstract class Entity {

	protected int x, y; // position coordinates
	protected int width, height;
	
	public Entity(int x, int y, int width, int height){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
}
