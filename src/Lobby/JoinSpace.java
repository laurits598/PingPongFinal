package Lobby;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jspace.RemoteSpace;

public class JoinSpace {
	public void join() throws UnknownHostException, IOException, InterruptedException {
		String uri = "tcp://127.0.0.1:9001/lobby?keep";
		RemoteSpace lobby = new RemoteSpace(uri);
		lobby.put("Join", "Username");

	}
}
