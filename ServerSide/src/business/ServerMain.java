package business;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import presentation.MainServerGUI;

public class ServerMain implements Runnable {
	private boolean exit;
	private ArrayList<ServerEchoThread> serverEchos = new ArrayList<ServerEchoThread>();
	private static ServerSocket server;
	
	@Override
	public void run() {
		int port = 8100;

		try {
			server = new ServerSocket(port);
			
			MainServerGUI.appendStatusMessage("Server is running and waiting for client on port " + server.getLocalPort() + "...");
			
			do {
				var socket = server.accept();
				if (!exit) {
					var serverEcho = new ServerEchoThread(socket);
					var thServerEcho = new Thread(serverEcho);
					serverEchos.add(serverEcho);
					thServerEcho.start();
				}
			} while(!exit);
		} catch (SocketException se) {
			if (!se.getMessage().equals("Socket closed")) {
				MainServerGUI.appendStatusMessage(se.getMessage());
			}
		} catch (IOException e) {
			MainServerGUI.appendStatusMessage(e.getMessage());
		}
	}
	
	public void stop()
    {
		try {
			if (serverEchos.size() != 0) {
				for (var s : serverEchos) {
					s.stop();
				}
			}
			server.close();
		} catch (IOException e) {
			MainServerGUI.appendStatusMessage(e.getMessage());
		}
        exit = true;
    }
}
