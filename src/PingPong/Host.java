package PingPong;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.RemoteSpace;

public class Host extends Player{
	
	RemoteSpace servers;
	RemoteSpace createServerRequest;
	
	public Host(boolean isPlayerOne) {
		super(isPlayerOne);
		String serverURI = "tcp://" + IP + ":" + 9001 + "/servers?keep";
		String serverRequestURI = "tcp://" + IP + ":" + 9001 + "/requestServer?keep";
		try {
			servers = new RemoteSpace(serverURI);
			createServerRequest = new RemoteSpace(serverRequestURI);
			isPlayerOne = true; // the host is always player 1
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int[] createHost() {
		Object[] t = null;
		int hostID = 0;
		try {
			t = servers.queryp(new FormalField(Integer.class),new FormalField(Integer.class));
			if(t!=null) {
				hostID = (int)t[0];
				hostID++;
			}else {
				hostID = 0;
			}
			//Create a server
			createServerRequest.put(hostID);
			//Wait for the server to be created
			t = servers.get(new ActualField(hostID),new FormalField(Integer.class));
			this.serverID = (int)t[1];
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new int[]{hostID,serverID};
	}

}
