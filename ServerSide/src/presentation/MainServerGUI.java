package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.ServerMain;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainServerGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnStart;
	private JButton btnStop;
	private static JTextArea txtaOutput;
	private JScrollPane scrollPane;
	
	private ServerMain serverMain = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainServerGUI frame = new MainServerGUI();
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
	public MainServerGUI() {
		setTitle("DB Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (serverMain == null) {
					serverMain = new ServerMain();
					var thread = new Thread(serverMain);
					thread.start();
				}
			}
		});
		btnStart.setBounds(48, 47, 89, 23);
		contentPane.add(btnStart);
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (serverMain != null) {
					serverMain.stop();
					appendStatusMessage("Server is stopped");
				}
				
				serverMain = null;
			}
		});
		btnStop.setBounds(234, 47, 89, 23);
		contentPane.add(btnStop);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 110, 334, 119);
		contentPane.add(scrollPane);
		
		txtaOutput = new JTextArea();
		scrollPane.setViewportView(txtaOutput);
	}
	
	public static void appendStatusMessage(String statusMsg) {
		txtaOutput.append(statusMsg);
		txtaOutput.append("\n");
	}
}
