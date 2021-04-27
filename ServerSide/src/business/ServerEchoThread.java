package business;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import data.DataIO;
import presentation.MainServerGUI;

public class ServerEchoThread implements Runnable {
	private Socket socket = null;
	private boolean exit;
	private DataInputStream dIN;
	
	public ServerEchoThread(Socket socket) {
		this.socket = socket;
	}
	
	public void stop()
    {
		if (dIN != null) {
			try {
				dIN.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        exit = true;
    }

	@Override
	public void run() {
		var cAddress = socket.getInetAddress();
		MainServerGUI.appendStatusMessage("Host Name: " + cAddress.getHostName() + "Host Address: " + cAddress.getHostAddress());
		MainServerGUI.appendStatusMessage("Received a client");
		
		try (var dOut = new DataOutputStream(socket.getOutputStream())) {	
			dIN = new DataInputStream(socket.getInputStream());
			
			char choice;
			do {
				choice = dIN.readChar();
				
				switch(choice) {
					case 'a' -> {
						Customer customer = new Customer();
						customer.setFirstName(dIN.readUTF());
						customer.setLastName(dIN.readUTF());
						customer.setPhone(dIN.readUTF());
						customer.setEmail(dIN.readUTF());
						customer.setAddress(dIN.readUTF());
						customer.setCity(dIN.readUTF());
						customer.setProvince(dIN.readUTF());
						customer.setPostalCode(dIN.readUTF());
						DataIO.AddCustomer(customer);
						dOut.writeUTF("success");
					}
						
					case 'f' -> {
						System.out.println("Find");
						ArrayList<Customer> customers = DataIO.FindCustomer(dIN.readUTF());
						dOut.writeInt(customers.size());
						for(var c : customers) {
							dOut.writeInt(c.getCustomerID());
							dOut.writeUTF(c.getFirstName());
							dOut.writeUTF(c.getLastName());
							dOut.writeUTF(c.getPhone());
							dOut.writeUTF(c.getEmail());
							dOut.writeUTF(c.getAddress());
							dOut.writeUTF(c.getCity());
							dOut.writeUTF(c.getProvince());
							dOut.writeUTF(c.getPostalCode());
						}
					}
						
					case 'e' -> MainServerGUI.appendStatusMessage("Client is exit.");
					
					case 'u' ->
					{
						System.out.println("Update");
						Customer customer = new Customer();
						customer.setCustomerID(dIN.readInt());
						customer.setFirstName(dIN.readUTF());
						customer.setLastName(dIN.readUTF());
						customer.setPhone(dIN.readUTF());
						customer.setEmail(dIN.readUTF());
						customer.setAddress(dIN.readUTF());
						customer.setCity(dIN.readUTF());
						customer.setProvince(dIN.readUTF());
						customer.setPostalCode(dIN.readUTF());
						DataIO.UpdateCustomer(customer);
						dOut.writeUTF("success");
						
					}	
					default -> dOut.writeUTF("Invalid Choice --> " + choice);
				}
			} while(Character.toUpperCase(choice) != 'e' || exit);
		} catch (IOException | SQLException e) {
			MainServerGUI.appendStatusMessage(e.getMessage());
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			MainServerGUI.appendStatusMessage(e.getMessage());
		}
	}
}
