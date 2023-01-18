package Lobby;

import javax.swing.*;

import org.jspace.SequentialSpace;
import org.jspace.SpaceRepository;

import PingPong.Player;

import java.awt.event.*;
import java.net.URI;
import java.net.URISyntaxException;

public class HostOrJoin {
    
    // Create a new window
    private static JFrame window;
    
 public HostOrJoin() {

	}

public static void init() {
        
        // Create the main window
        window = new JFrame("Ping Pong");
        window.setSize(400, 400);
        window.setLayout(null);
        window.setVisible(true);
        
        // Create the title
        JLabel title = new JLabel("Ping Pong");
        title.setBounds(100, 100, 200, 20);
        window.add(title);
        
        // Create the two buttons
        JButton joinButton = new JButton("Join Game");
        joinButton.setBounds(100, 150, 100, 20);
        window.add(joinButton);
        
        JButton hostButton = new JButton("Host Game");
        hostButton.setBounds(200, 150, 100, 20);
        window.add(hostButton);
        
        // Set the action listener for the buttons
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Join game code
            	JoinFrame joinFrame = new JoinFrame();
            	joinFrame.open();
            	//System.out.println("Hey");
            }
        });
        
        hostButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Thread t1 = new Thread(new HostSpace());
				HostFrame guiHost = new HostFrame();
				//t1.start();
				guiHost.open();
				window.setVisible(false);
            	
            	
            }
        });
    }
}


