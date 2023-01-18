package PingPong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.SequentialSpace;
import org.jspace.SpaceRepository;


public class Server {

	public static void main(String[] args) {
		try {
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			// Create a repository 
			SpaceRepository repository = new SpaceRepository();

			// Create two spaces for player movement
			SequentialSpace playerOneMovement = new SequentialSpace();
			SequentialSpace playerTwoMovement = new SequentialSpace();
			SequentialSpace ballMovement = new SequentialSpace();
			SequentialSpace scoreSpace = new SequentialSpace();
			SequentialSpace servers = new SequentialSpace();
			SequentialSpace requestServer = new SequentialSpace();
			
			// Create spaces for pre-game actions
			SequentialSpace joinAvailable = new SequentialSpace();
			SequentialSpace hostAvailable = new SequentialSpace();
			//SequentialSpace lock = new SequentialSpace();
			//SequentialSpace player1Search = new SequentialSpace();
			//SequentialSpace player2Search = new SequentialSpace();
			//SequentialSpace player1_Lobby = new SequentialSpace();
			//SequentialSpace player2_Lobby = new SequentialSpace();
			//SequentialSpace initSession = new SequentialSpace();

			// Add the space to the repository
			repository.add("playerOneMovement", playerOneMovement);
			repository.add("playerTwoMovement", playerTwoMovement);
			repository.add("ballMovement", ballMovement);
			repository.add("scoreSpace", scoreSpace);
			
			repository.add("joinAvailable", joinAvailable);
			repository.add("hostAvailable", hostAvailable);
			
			repository.add("servers",servers);
			repository.add("requestServer",requestServer);
			//repository.add("lock", lock);
			//repository.add("player1Search", player1Search);
			//repository.add("player2Search", player2Search);
			//repository.add("player1_Lobby", player1_Lobby);
			//repository.add("player2_Lobby", player2_Lobby);
			//repository.add("initSession", initSession);
			
			// Set the URI of the chat space
			System.out.print("Enter URI of the chat server or press enter for default: ");
			String uri = input.readLine();
			// Default value
			if (uri.isEmpty()) { 
				uri = "tcp://127.0.0.1:9001/?keep";
			}

			// Open a gate
			URI myUri = new URI(uri);
			String gateUri = "tcp://" + myUri.getHost() + ":" + myUri.getPort() +  "?keep" ;
			System.out.println("Opening repository gate at " + gateUri + "...");
			repository.addGate(gateUri);

			// Keep reading chat messages and printing them 
			//while (true) {
				//requestServer.get(new FormalField(String.class));
			//}
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch blockk
			e.printStackTrace();
		}
	}
}










