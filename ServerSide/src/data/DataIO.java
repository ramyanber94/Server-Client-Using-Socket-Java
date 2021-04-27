package data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Customer;

public class DataIO {
	private static java.sql.Connection con = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	private static int currentCustomerId = 0; 

	private static java.sql.Connection getConnection() throws SQLException {
		if (con == null) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok", "N01379722", "oracle");
			currentCustomerId = getCustomerID();
			}
		return con;
	}
		
	public static int getCustomerID() throws SQLException {
		if (rs == null) {
			String sql = "Select customersJavaDB.* FROM customersJavaDB";
			con = getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			int maxId = 0;
			while (rs.next()) {
				var id = rs.getInt("Customer_ID");
				if (id > maxId)
					maxId = id;
			}
			currentCustomerId = maxId;
		}
		return currentCustomerId;
	}

	public static void AddCustomer(Customer customer) throws SQLException {
		String sql = "INSERT INTO customersJavaDB" + "(Customer_ID, First_Name, Last_Name, Phone, Email, Street, City, Province, Postal_Code)" + "VALUES (?,?,?,?,?,?,?,?,?)";
		con = getConnection();
		pst = con.prepareStatement(sql);
		pst.setInt(1, ++currentCustomerId);
		pst.setString(2, customer.getFirstName());
		pst.setString(3, customer.getLastName());
		pst.setString(4, customer.getPhone());
		pst.setString(5, customer.getEmail());
		pst.setString(6, customer.getAddress());
		pst.setString(7, customer.getCity());
		pst.setString(8, customer.getProvince());
		pst.setString(9, customer.getPostalCode());
		pst.executeUpdate();
	}
	public static ArrayList<Customer> FindCustomer(String FirstName) throws SQLException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String sql = "Select * FROM customersJavaDB WHERE First_Name = ?";
		con = getConnection();
		pst = con.prepareStatement(sql);
		pst.setString(1, FirstName);
		rs = pst.executeQuery();
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerID(rs.getInt("Customer_ID"));
			customer.setFirstName(rs.getString("First_Name"));
			customer.setLastName(rs.getString("Last_Name"));
			customer.setPhone(rs.getString("Phone"));
			customer.setEmail(rs.getString("Email"));
			customer.setAddress(rs.getString("Street"));
			customer.setCity(rs.getString("City"));
			customer.setProvince(rs.getString("Province"));
			customer.setPostalCode(rs.getString("Postal_Code"));
			customers.add(customer);		
			}
		return customers;
	} 
		
	
	public static void UpdateCustomer(Customer customer) throws SQLException {
		String sql = "UPDATE customersJavaDB SET First_Name = ?, Last_Name = ?, Phone = ?, Email = ?, Street = ?, City = ?, Province = ?, Postal_Code = ? WHERE Customer_ID = ?";
		con = getConnection();
		pst = con.prepareStatement(sql);
		pst.setString(1, customer.getFirstName());
		pst.setString(2, customer.getLastName());
		pst.setString(3, customer.getPhone());
		pst.setString(4, customer.getEmail());
		pst.setString(5, customer.getAddress());
		pst.setString(6, customer.getCity());
		pst.setString(7, customer.getProvince());
		pst.setString(8, customer.getPostalCode());
		pst.setInt(9, customer.getCustomerID());
		pst.executeUpdate();
	}
}