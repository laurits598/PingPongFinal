package PingPong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.jspace.Space;
/*public class AL extends KeyAdapter implements Runnable  {
	private Space space;
	//	private String name;
	public String KEY;
	public boolean KEY_STATE = false;
	
	public AL(Space space) {
		this.space = space;
	}
	
	public void setKEY(char c) throws InterruptedException {		
		this.KEY = "" + c;
		space.put("setKEY");
	}
	public void setState() {		
		this.KEY_STATE = !KEY_STATE;
	}

	public void keyPressed(KeyEvent e){
		Panel.paddle1.keyPressed(e);
//		System.out.println(e.getKeyChar());
//		KEY_STATE = true;
		try {
			space.put("Player", "Test");
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//run();
		Panel.paddle2.keyPressed(e);	
	}

	public void keyReleased(KeyEvent e) {
		Panel.paddle1.keyReleased(e);
		KEY_STATE = false;
		Panel.paddle2.keyReleased(e);
	}

	@Override
	public void run() {
		try {
			space.put("Player", "Test");
			Thread.sleep(1000);
//			while (true) {
//				space.put("test");
//				if (KEY_STATE == true) {
//					String s = "true";
//					game.put(s);
//					KEY_STATE = false;
//				}
//				String s = "Test";
//				game.put(s);
//			}
			

		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}
}*/


