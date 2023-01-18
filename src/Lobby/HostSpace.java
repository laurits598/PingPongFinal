package Lobby;

import java.net.URI;
import java.net.URISyntaxException;

import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.SequentialSpace;
import org.jspace.SpaceRepository;

public class HostSpace implements Runnable{
	public void host() throws URISyntaxException, InterruptedException {
		SpaceRepository repository = new SpaceRepository();
		SequentialSpace lobby = new SequentialSpace();
		repository.add("lobby", lobby);
		String uri = "tcp://127.0.0.1:9001/?keep";
		
		URI myUri = new URI(uri);
		String gateUri = "tcp://" + myUri.getHost() + ":" + myUri.getPort() +  "?keep" ;
		System.out.println("Opening repository gate at " + gateUri + "...");
		repository.addGate(gateUri);
		
		while (true) {
			Object[] t = lobby.query(new ActualField("Join"), new FormalField(String.class));
			System.out.println(t[0] + ": " + t[1]);
		}
	}

	@Override
	public void run() {
		
		
	}
}













