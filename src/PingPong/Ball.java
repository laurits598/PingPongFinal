package PingPong;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.jspace.RemoteSpace;
//dd
public class Ball extends Rectangle {  
	//Global variable  ddds dd dd d

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	private RemoteSpace ballMovement;
	private boolean isPlayerOne;

	Ball(int x, int y, int width, int height, RemoteSpace ballMovement, boolean isPlayerOne){

		super(x,y,width,height);
		random = new Random();
		this.ballMovement = ballMovement;
		this.isPlayerOne = isPlayerOne;
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);	

		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection*initialSpeed);

	}

	public void setXDirection(int randomXDirection) {
		if(isPlayerOne) {
			xVelocity = randomXDirection;
			try {
				ballMovement.put("xv",xVelocity,this.x,this.y);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setYDirection(int randomYDirection) {
		if(isPlayerOne) {
			yVelocity = randomYDirection;
			try {
				ballMovement.put("yv",yVelocity,this.x,this.y);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setYDirectionRemote(int yDirection){
		yVelocity = yDirection;
	}
	
	public void setXDirectionRemote(int xDirection){
		xVelocity = xDirection;
	}

	public void move() {
		x += xVelocity;
		y += yVelocity;

	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);

	}

	
//------------------------------------------------------------------------------//
	
}  