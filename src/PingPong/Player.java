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
	public RemoteSpace servers;
	public RemoteSpace createServerRequest;
	public String name;
	public String opponentName;
	public String IP;
	public int serverID;
	public int hostID;
	public Player(boolean isPlayerOne) {
		try {
			int port = 9001;
			String localIP = "127.0.0.1";
			String timsIP = "104.248.22.64";
			//tcp://104.248.22.64:9001/?keep
			this.IP = timsIP;
			joinAvailable = new RemoteSpace("tcp://" + IP + ":" + 9001 + "/joinAvailable"+"?keep");
			hostAvailable = new RemoteSpace("tcp://" + IP + ":" + 9001 + "/hostAvailable"+"?keep");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		this.isPlayerOne = isPlayerOne;
		//frame = new Frame(this.isPlayerOne, playerOneMovement, playerTwoMovement, ballMovement, scoreSpace);
	}
	
	public void createSpaces(int serverID) {
		try {
			playerOneMovement = new RemoteSpace("tcp://" + IP + ":" + 9001 + "/playerOneMovement"+serverID+"?keep");
			playerTwoMovement = new RemoteSpace("tcp://" + IP + ":" + 9001 + "/playerTwoMovement"+serverID+"?keep");
			ballMovement = new RemoteSpace("tcp://" + IP + ":" + 9001 + "/ballMovement"+serverID+"?keep");
			scoreSpace = new RemoteSpace("tcp://" + IP + ":" + 9001 + "/scoreSpace"+serverID+"?keep");
			
			System.out.println("########createSpace########"+"tcp://" + IP + ":" + 9001 + "/playerOneMovement"+serverID+"?keep");
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

	public int getServerID() {
		return serverID;
	}

	public void setServerID(int serverID) {
		this.serverID = serverID;
	}

	public int getHostID() {
		return hostID;
	}

	public void setHostID(int hostID) {
		this.hostID = hostID;
	}
	
	
	

}


