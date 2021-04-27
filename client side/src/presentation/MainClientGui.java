package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import data.DataIO;
import data.Validator;

import javax.swing.JScrollPane;
import java.awt.Color;

public class MainClientGui extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPostalCode;
	private JTextField txtPhone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClientGui frame = new MainClientGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainClientGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 37, 58, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(24, 72, 113, 13);
		contentPane.add(lblFirstName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(25, 109, 83, 13);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(35, 146, 73, 13);
		contentPane.add(lblCity);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(35, 187, 58, 13);
		contentPane.add(lblPhone);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(505, 74, 113, 13);
		contentPane.add(lblLastName);
		
		JLabel lblProvince = new JLabel("Province:");
		lblProvince.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProvince.setBounds(358, 148, 113, 13);
		contentPane.add(lblProvince);
		
		JLabel lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPostalCode.setBounds(629, 148, 113, 13);
		contentPane.add(lblPostalCode);
		
		JLabel lblLastName_2_1 = new JLabel("Email:");
		lblLastName_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName_2_1.setBounds(435, 189, 113, 13);
		contentPane.add(lblLastName_2_1);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setBounds(90, 36, 202, 19);
		contentPane.add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(136, 71, 253, 19);
		contentPane.add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(627, 71, 261, 19);
		contentPane.add(txtLastName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 228, 1016, 106);
		contentPane.add(scrollPane);
		
		
		JTextArea txtaDisplay = new JTextArea();
		txtaDisplay.setBackground(Color.LIGHT_GRAY);
		txtaDisplay.setForeground(new Color(0, 100, 0));
		txtaDisplay.setFont(new Font("Monospaced", Font.BOLD, 15));
		scrollPane.setViewportView(txtaDisplay);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(118, 108, 770, 19);
		contentPane.add(txtAddress);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(90, 145, 202, 19);
		contentPane.add(txtCity);
		
		JComboBox cmboProvince = new JComboBox();
		cmboProvince.setModel(new DefaultComboBoxModel(new String[] {"ON", "QC", "BC", "MB", "AB", "NS"}));
		cmboProvince.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmboProvince.setBounds(465, 144, 94, 21);
		contentPane.add(cmboProvince);
		
		txtPostalCode = new JTextField();
		txtPostalCode.setColumns(10);
		txtPostalCode.setBounds(738, 145, 150, 19);
		contentPane.add(txtPostalCode);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(103, 186, 286, 19);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(493, 186, 395, 19);
		contentPane.add(txtEmail);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConnect.setBounds(938, 35, 123, 21);
		contentPane.add(btnConnect);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(938, 70, 123, 21);
		contentPane.add(btnAdd);
		
		JButton btnFind = new JButton("Find");
		btnFind.setEnabled(false);
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(938, 107, 123, 21);
		contentPane.add(btnFind);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(938, 144, 123, 21);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(938, 185, 123, 21);
		contentPane.add(btnExit);
		
//********************************************* Event Handlers *********************************************************//
		
		// Connect button
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!DataIO.isConnectedToServer()) {
						DataIO.connectToServer();
						JOptionPane.showMessageDialog(null, "Client successfully connected to the server.");
						btnAdd.setEnabled(true);
						btnFind.setEnabled(true);
						btnUpdate.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Already connected to the server.");
					}
				} catch (Exception e1) {
					if(e1.getMessage().equals("Connection refused: connect")) {
						JOptionPane.showMessageDialog(null , "Server is not open");
					}else {
						JOptionPane.showMessageDialog(null , e1.getMessage());
					}
					
					try {
						DataIO.closeConnectionToServer();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				
			}
		});
		
		// Add button
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var customer = new Customer();
				if((Validator.isString(txtFirstName) && Validator.isString(txtLastName) && Validator.isString(txtCity)
						&& Validator.isPresent(txtFirstName) && Validator.isPresent(txtLastName) && Validator.isPresent(txtEmail))) {
					customer.setFirstName(txtFirstName.getText());
					customer.setLastName(txtLastName.getText());
					customer.setAddress(txtAddress.getText());
					customer.setCity(txtCity.getText());
					customer.setPostalCode(txtPostalCode.getText());
					customer.setProvince(cmboProvince.getSelectedItem().toString());
					customer.setPhone(txtPhone.getText());
					customer.setEmail(txtEmail.getText());
					if (customer.wasAllSetDataOk()) {
						try {
							if (DataIO.addCustomer(customer)) {
								JOptionPane.showMessageDialog(null, "Customer added successfuly.");
							} else {
								JOptionPane.showMessageDialog(null, "Failed to add customer.");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Error  " +e1.getMessage());
						}
					} else {
						String[] errInfo = customer.getSetErrorInfo();
						JOptionPane.showMessageDialog(null, errInfo[0] + " is to big. Max size for this field is " + errInfo[1]);
					}
				}
			}
		});
		
		// Find button
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					ArrayList<Customer> customers = DataIO.findCustomers(txtFirstName.getText());
					if (customers != null) {
						txtaDisplay.setText("");
						for (var customer : customers) {
							txtaDisplay.append(customer.toString());
							txtaDisplay.append("\n");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Find failed or no customers found for the given first name.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error --> " + e1.getMessage());
				}
			}
		});
		
		// Update button
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				var customer = new Customer();
				if((Validator.isString(txtFirstName) && Validator.isString(txtLastName) && Validator.isString(txtCity)
						&& Validator.isPresent(txtFirstName) && Validator.isPresent(txtLastName) && Validator.isPresent(txtEmail))) {
					customer.setFirstName(txtFirstName.getText());
					customer.setLastName(txtLastName.getText());
					customer.setAddress(txtAddress.getText());
					customer.setCity(txtCity.getText());
					customer.setPostalCode(txtPostalCode.getText());
					customer.setProvince(cmboProvince.getSelectedItem().toString());
					customer.setPhone(txtPhone.getText());
					customer.setEmail(txtEmail.getText());
					customer.setCustomerID(Integer.parseInt(txtCustomerID.getText()));
					if (customer.wasAllSetDataOk()) {
						try {
							if (DataIO.UpdateCustomer(customer)) {
								JOptionPane.showMessageDialog(null, "Customer updated successfuly.");
							} else {
								JOptionPane.showMessageDialog(null, "Failed to update customer.");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Error --> " + e1.getMessage());
						}
					} else {
						String[] errInfo = customer.getSetErrorInfo();
						JOptionPane.showMessageDialog(null, errInfo[0] + " is to big. Max size for this field is " + errInfo[1]);
					}
				}
			}
		});

		// Exit button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO.closeConnectionToServer();
					System.exit(0);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error --> " + e2.getMessage());
				}
			}
		});
	}
}
