import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class ByteSprite implements DisplayableSprite, MovableSprite {
	
	
	private double centerX = 0;
	private double centerY = 0;
	private double velocityX = 0;
	private double velocityY = 0;
	private double height;
	private double width;
	private boolean dispose = false;
	private boolean right = true;
	private final int A = 65, W = 87, S = 83, D = 68;
	private final int MOVEMENTSPEED = 4;
	private int deltaX = 0, deltaY = 0;
	private Image[] imageLeft = new Image[4], imageRight = new Image[4];
	private Image standingLeft, standingRight;
	private int movementCounter = 0;
	private boolean moving;

	public ByteSprite(int health){

		// image
		for(int i = 1; i <= 4; i++) {
			try {
				this.imageLeft[i-1] = ImageIO.read(new File("res/ByteMovement/Left" + i + ".png"));
			} catch (IOException e) {}
			try {
				this.imageRight[i-1] = ImageIO.read(new File("res/ByteMovement/Right" + i + ".png"));
			} catch (IOException e) {}	
			}
		
		try {
			this.standingLeft = ImageIO.read(new File("res/ByteMovement/Left1.png"));
			this.height = standingLeft.getHeight(null) * 5;
			this.width = standingLeft.getWidth(null) * 5;
		} catch (IOException e) {}
		
		try {
			this.standingRight = ImageIO.read(new File("res/ByteMovement/Right1.png"));
		} catch (IOException e) {}
		//
	}
	
	
	

	@Override
	public void setCenterX(double centerX) {
		this.centerX = centerX;
		
	}

	@Override
	public void setCenterY(double centerY) {
		this.centerY = centerY;
		
	}

	@Override
	public void setVelocityX(double pixelsPerSecond) {
		this.velocityX = pixelsPerSecond;
		
	}

	@Override
	public void setVelocityY(double pixelsPerSecond) {
		this.velocityY = pixelsPerSecond;

		
	}

	@Override
	public Image getImage() {
		if(this.right) {
			if(this.moving) {
				return this.imageRight[(int) (this.movementCounter / 5) % 4];
			}else {
				return this.standingRight;
			}
		}else {
			if(this.moving) {
				return this.imageLeft[(int) (this.movementCounter / 5) % 4];
			}else {
				return this.standingLeft;
			}
		}
	}

	@Override
	public boolean getVisible() {
 
		return true;
	}

	@Override
	public double getMinX() {
 
		return this.getCenterX() - this.getWidth() / 2;
	}

	@Override
	public double getMaxX() {
 
		return this.getCenterX() + this.getWidth() / 2;
	}

	@Override
	public double getMinY() {
 
		return this.getCenterY() - this.getHeight() / 2;
	}

	@Override
	public double getMaxY() {
 
		return this.getCenterY() + this.getHeight() / 2;
	}

	@Override
	public double getHeight() {
 
		return this.height;
	}

	@Override
	public double getWidth() {
 
		return this.width;
	}

	@Override
	public double getCenterX() {
 
		return this.centerX;
	}

	@Override
	public double getCenterY() {
 
		return this.centerY;
	}

	@Override
	public boolean getDispose() {
 
		return this.dispose;
	}

	@Override
	public void setDispose(boolean dispose) {
		this.dispose = dispose;
		
	}

	@Override
	public void update(Universe universe, KeyboardInput k, long actual_delta_time) {
		
		//direction detection
		if(k.keyDown(A)) {
			this.right = false;
		}else if (k.keyDown(D)) {
			this.right = true;
		}
		
		//movement
		this.deltaX = 0; this.deltaY = 0; this.moving = false;
		if(k.keyDown(A)) {
			this.deltaX -= this.MOVEMENTSPEED;
			this.moving = true;
		}
		if(k.keyDown(D)) {
			this.deltaX += this.MOVEMENTSPEED;
			this.moving = true;
		}
		if(k.keyDown(W)) {
			this.deltaY -= this.MOVEMENTSPEED;
			this.moving = true;
		}
		if(k.keyDown(S)) {
			this.deltaY += this.MOVEMENTSPEED;
			this.moving = true;
		}
		
		this.centerX += this.deltaX;
		this.centerY += this.deltaY;
		
		if(this.moving) {
			this.movementCounter ++;
		}else {
			this.movementCounter = 0;
		}
	}
}
