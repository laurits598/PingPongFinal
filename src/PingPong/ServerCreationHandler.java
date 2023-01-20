package PingPong;

import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.SequentialSpace;
import org.jspace.SpaceRepository;

public class ServerCreationHandler {
	
	private int serverID = 0;
	
	private SpaceRepository repository;
	private SequentialSpace servers;
	private SequentialSpace requestServer;
	//Player p = new Player(false); 

	public ServerCreationHandler(SpaceRepository repository, SequentialSpace servers, SequentialSpace requestServer) {
		this.repository = repository;
		this.servers = servers;
		this.requestServer = requestServer;
	}

	public int createServer(int hostID) throws InterruptedException {
		//p.serverID
		serverID++;
		servers.put(hostID,serverID);

		// Create two spaces for player movement
		SequentialSpace playerOneMovement = new SequentialSpace();
		SequentialSpace playerTwoMovement = new SequentialSpace();
		SequentialSpace ballMovement = new SequentialSpace();
		SequentialSpace scoreSpace = new SequentialSpace();
		
		
		// Add the space to the repository
		repository.add("playerOneMovement"+serverID, playerOneMovement);
		repository.add("playerTwoMovement"+serverID, playerTwoMovement);
		repository.add("ballMovement"+serverID, ballMovement);
		repository.add("scoreSpace"+serverID, scoreSpace);
		
		System.out.println("####CreateServer#### ServerID="+serverID);
		
		return serverID;
		
	}
	
	public int requestServerID(int hostID) throws InterruptedException {
		Object[] t = servers.get(new ActualField(hostID),new FormalField(Integer.class));
		return (int)t[1];
	}

}
