import java.util.ArrayList;

public class MovableSpriteUniverse implements Universe {

	private boolean complete = false;	
	private Background background = null;	
	private DisplayableSprite player1 = null;
	private ArrayList<DisplayableSprite> sprites = new ArrayList<DisplayableSprite>();
	private long elapsedTime = 0;
	private String status = "";

	private final double VELOCITY = 200;	
	
//	//require a separate list for sprites to be removed to avoid a concurence exception
	private ArrayList<DisplayableSprite> disposalList = new ArrayList<DisplayableSprite>();

	
	public MovableSpriteUniverse () {
	
	this.setXCenter(0);
	this.setYCenter(0);

	player1 = new ByteSprite(0);
	sprites.add(player1);

	MovableSprite movable = (MovableSprite)player1;
	movable.setCenterX(-300);
	movable.setCenterY(-200);
	
}
	
	public double getScale() {
		return 1;
	}

	public double getXCenter() {
		return this.player1.getCenterX();
	}

	public double getYCenter() {
		return this.player1.getCenterY();
	}
	
	public void setXCenter(double xCenter) {
	}

	public void setYCenter(double yCenter) {
	}
	
	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
	}

	public ArrayList<Background> getBackgrounds() {
		return null;
	}

	public DisplayableSprite getPlayer1() {
		return player1;
	}

	public ArrayList<DisplayableSprite> getSprites() {
		return sprites;
	}
		
//	public boolean centerOnPlayer() {
//		return true;
//	}		
	
	public void update(KeyboardInput keyboard, long actual_delta_time) {

		for (int i = 0; i < sprites.size(); i++) {
			DisplayableSprite sprite = sprites.get(i);
			
			sprite.update(this, keyboard, actual_delta_time);
    	}    	

		
		
		
		
		
		
		
		
		
		
		
		
		
		//do all of the bullet calculation in here, and the cooldowns
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public String toString() {
		return this.status;
	}	

}
