package PingPong;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jspace.RemoteSpace;
import org.jspace.Space;

public class Player {
	
	public Frame frame;
	public boolean isPlayerOne;
	public String uriP1;
	public String uriP2;
	public String uriBall;
	public String uriScore;
	public String uriJoin;
	public String uriHost;
	public RemoteSpace playerOneMovement;
	public RemoteSpace playerTwoMovement;
	public RemoteSpace ballMovement;
	public RemoteSpace scoreSpace;
	public RemoteSpace joinAvailable;
	public RemoteSpace hostAvailable;
	public String name;
	public String opponentName;
	public String IP;
	
	public Player(boolean isPlayerOne) {
		try {
			int port = 9001;
			String localIP = "127.0.0.1";
			String timsIP = "104.248.22.64";
			setIP(timsIP);
			uriP1 = "tcp://" + IP + ":" + port + "/playerOneMovement?keep"; 
			uriP2 = "tcp://" + IP + ":" + port + "/playerTwoMovement?keep";
			uriBall = "tcp://" + IP + ":" + port + "/ballMovement?keep";
			uriScore = "tcp://" + IP + ":" + port + "/scoreSpace?keep";
			uriJoin = "tcp://" + IP + ":" + port + "/joinAvailable?keep";
			uriHost = "tcp://" + IP + ":" + port + "/hostAvailable?keep";
			
			playerOneMovement = new RemoteSpace(uriP1);
			playerTwoMovement = new RemoteSpace(uriP2);
			ballMovement = new RemoteSpace(uriBall);
			scoreSpace = new RemoteSpace(uriBall);
			joinAvailable = new RemoteSpace(uriJoin);
			hostAvailable = new RemoteSpace(uriHost);
			this.isPlayerOne = isPlayerOne;
			//frame = new Frame(this.isPlayerOne, playerOneMovement, playerTwoMovement, ballMovement, scoreSpace);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void join() {
		
	}
	
	public void host() {
		
	}
	
	public void startGame() {
		frame = new Frame(this);
	}

	public RemoteSpace getJoinAvailable() {
		return joinAvailable;
	}

	public void setJoinAvailable(RemoteSpace joinAvailable) {
		this.joinAvailable = joinAvailable;
	}

	public RemoteSpace getHostAvailable() {
		return hostAvailable;
	}

	public void setHostAvailable(RemoteSpace hostAvailable) {
		this.hostAvailable = hostAvailable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpponentName() {
		return opponentName;
	}

	public void setOpponentName(String opponentName) {
		this.opponentName = opponentName;
	}
	public void setIP(String ip) {
		IP = ip;
	}

}


