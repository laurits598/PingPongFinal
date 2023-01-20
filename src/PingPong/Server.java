package PingPong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedList;

import org.jspace.ActualField;
import org.jspace.FormalField;
import org.jspace.PileSpace;
import org.jspace.SequentialSpace;
import org.jspace.SpaceRepository;


public class Server {
	public SequentialSpace servers;
	public SequentialSpace requestServer;
	public SequentialSpace joinAvailable;
	public SequentialSpace hostAvailable;
	
	public Server() {
		servers = new PileSpace();
		requestServer = new SequentialSpace();
		joinAvailable = new SequentialSpace();
		hostAvailable = new SequentialSpace();
		LogThread logThread = new LogThread();
		Thread logThread2 = new Thread(logThread);
		//logThread2.start();
	}

	public static void main(String[] args) {
		try {
			
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			// Create a repository 
			SpaceRepository repository = new SpaceRepository();
			
			Server server = new Server();
			
			repository.add("servers",server.servers);
			repository.add("requestServer",server.requestServer);
			repository.add("joinAvailable", server.joinAvailable);
			repository.add("hostAvailable", server.hostAvailable);
			
			// Create two spaces for player movement
			/*SequentialSpace playerOneMovement = new SequentialSpace();
			SequentialSpace playerTwoMovement = new SequentialSpace();
			SequentialSpace ballMovement = new SequentialSpace();
			SequentialSpace scoreSpace = new SequentialSpace();*/
			
			
			// Create spaces for pre-game actions
			
			//SequentialSpace lock = new SequentialSpace();
			//SequentialSpace player1Search = new SequentialSpace();
			//SequentialSpace player2Search = new SequentialSpace();
			//SequentialSpace player1_Lobby = new SequentialSpace();
			//SequentialSpace player2_Lobby = new SequentialSpace();
			//SequentialSpace initSession = new SequentialSpace();

			// Add the space to the repository
			/*repository.add("playerOneMovement", playerOneMovement);
			repository.add("playerTwoMovement", playerTwoMovement);
			repository.add("ballMovement", ballMovement);
			repository.add("scoreSpace", scoreSpace);
			
			repository.add("joinAvailable", joinAvailable);
			repository.add("hostAvailable", hostAvailable);*/
			
			
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
			
			ServerCreationHandler serverCreationHandler = new ServerCreationHandler(repository, server.servers, server.requestServer);


			 //Server listening to requests from Host to create a session 
			while (true) {
				try {
					Object[] t = server.requestServer.get(new FormalField(Integer.class));
					int hostID = (int)t[0];
					int serverID = serverCreationHandler.createServer(hostID);
					server.servers.put(hostID,serverID);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch blockk
			e.printStackTrace();
		}
	}
	
	public class LogThread implements Runnable {
		private boolean work = false; 
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
					if(work)
						System.out.println("##############################");
					if(servers.size()>0) {
						work = true;
						LinkedList<Object[]> t = servers.queryAll(new FormalField(Integer.class),new FormalField(Integer.class));
						if(t!=null) {
							for (Iterator iterator = t.iterator(); iterator.hasNext();) {
								Object[] o = (Object[]) iterator.next();
								System.out.println("hostID="+o[0]+" serverID="+o[1]);
							}
						}
						Thread.sleep(1000);	
					}
					if(requestServer.size()>0) {
						
					}
					if(joinAvailable.size()>0) {
						work = true;
						LinkedList<Object[]> t = joinAvailable.queryAll(new FormalField(String.class));
						if(t!=null) {
							for (Iterator iterator = t.iterator(); iterator.hasNext();) {
								Object[] o = (Object[]) iterator.next();
								System.out.println("nickname="+o[0]);
							}
						}
						
						LinkedList<Object[]> t1 = joinAvailable.queryAll(new FormalField(Boolean.class));
						if(t!=null) {
							for (Iterator iterator = t1.iterator(); iterator.hasNext();) {
								Object[] o = (Object[]) iterator.next();
								System.out.println("connect="+o[0]);
							}
						}
						Thread.sleep(1000);	
					}
					if(hostAvailable.size()>0) {
						work = true;
						LinkedList<Object[]> t = hostAvailable.queryAll(new FormalField(String.class),new FormalField(Integer.class),new FormalField(Integer.class));
						if(t!=null) {
							for (Iterator iterator = t.iterator(); iterator.hasNext();) {
								Object[] o = (Object[]) iterator.next();
								System.out.println("nickname="+o[0]+" hostID="+o[1]+ " " + "serverID=" + o[2]);
							}
						}
						
						LinkedList<Object[]> t1 = hostAvailable.queryAll(new FormalField(Boolean.class));
						if(t!=null) {
							for (Iterator iterator = t1.iterator(); iterator.hasNext();) {
								Object[] o = (Object[]) iterator.next();
								System.out.println("connect="+o[0]);
							}
						}
						Thread.sleep(1000);
					}
					if(work) {
						System.out.println("##############################");
						work=false;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}










