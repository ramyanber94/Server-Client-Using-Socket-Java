package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import business.Customer;

public class DataIO {
	private static Socket socket = null;
	private static DataInputStream dIn = null;
	private static DataOutputStream dOut = null;
	private static boolean connectedToServer = false;

	
	public static boolean isConnectedToServer() {
		return connectedToServer;
	}
	
	public static void connectToServer() throws Exception {
		int port = 8100;
		String host = "localhost";
		socket = new Socket(host,port);
		dIn = new DataInputStream(socket.getInputStream());
		dOut = new DataOutputStream(socket.getOutputStream());
		connectedToServer = true;
	}
	
	public static void closeConnectionToServer() throws Exception {
		if (connectedToServer) {
			char choice = 'e';
			dOut.writeChar(choice);
			if (dOut != null)
				dOut.close();
			if (dIn != null)
				dIn.close();
			if (socket != null)
				socket.close();
			connectedToServer = false;
		}
	}

	public static boolean addCustomer(Customer customer) throws Exception {
		if (connectedToServer) {
			char choice = 'a';
			dOut.writeChar(choice);
			dOut.writeUTF(customer.getFirstName());
			dOut.writeUTF(customer.getLastName());
			dOut.writeUTF(customer.getPhone());
			dOut.writeUTF(customer.getEmail());
			dOut.writeUTF(customer.getAddress());
			dOut.writeUTF(customer.getCity());
			dOut.writeUTF(customer.getProvince());
			dOut.writeUTF(customer.getPostalCode());
			String feedback = dIn.readUTF();
			if (feedback.equals("success")) {
				System.out.println("success");
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Customer> findCustomers(String firstName) throws Exception {
		if (connectedToServer) {
			char choice = 'f';
			dOut.writeChar(choice);
			
			dOut.writeUTF(firstName);
			
			int numCustomers = dIn.readInt();
			if (numCustomers > 0) {
				ArrayList<Customer> customers = new ArrayList<Customer>();
				for (int i = 0; i < numCustomers; i++) {
					var customer = new Customer();
					customer.setCustomerID(dIn.readInt());
					customer.setFirstName(dIn.readUTF());
					customer.setLastName(dIn.readUTF());
					customer.setPhone(dIn.readUTF());
					customer.setEmail(dIn.readUTF());
					customer.setAddress(dIn.readUTF());
					customer.setCity(dIn.readUTF());
					customer.setProvince(dIn.readUTF());
					customer.setPostalCode(dIn.readUTF());
					customers.add(customer);
				}
				return customers;
			}
		}
		
		return null;
	}

	public static boolean UpdateCustomer(Customer customer) throws Exception  {
		if (connectedToServer) {
			char choice = 'u';
			dOut.writeChar(choice);
			dOut.writeInt(customer.getCustomerID());
			dOut.writeUTF(customer.getFirstName());
			dOut.writeUTF(customer.getLastName());
			dOut.writeUTF(customer.getPhone());
			dOut.writeUTF(customer.getEmail());
			dOut.writeUTF(customer.getAddress());
			dOut.writeUTF(customer.getCity());
			dOut.writeUTF(customer.getProvince());
			dOut.writeUTF(customer.getPostalCode());
			String result = dIn.readUTF();
			if (result.equals("success")) {
				return true;
			}
		}
		return false;
	}
}