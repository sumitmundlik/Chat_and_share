import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;

public class newlog {

	public JFrame frame;
	TextField user1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newlog window = new newlog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
private JPasswordField pass1;
private JPasswordField pass2;
	/**
	 * Create the application.
	 */
	public newlog() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Connection con;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 255));
		frame.setBounds(100, 100, 534, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Enter Username");
		lblUsername.setForeground(new Color(124, 252, 0));
		lblUsername.setBounds(57, 130, 152, 32);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setForeground(new Color(124, 252, 0));
		lblEnterPassword.setBounds(57, 185, 152, 32);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(lblEnterPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(124, 252, 0));
		lblConfirmPassword.setBounds(37, 237, 162, 32);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(lblConfirmPassword);
		
		user1 = new TextField();
		user1.setBounds(215, 138, 188, 24);
		frame.getContentPane().add(user1);
		
		JButton btnDone = new JButton("Done");
		btnDone.setForeground(new Color(245, 255, 250));
		btnDone.setBackground(new Color(25, 25, 112));
		btnDone.addActionListener(new ActionListener() {
			//@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
					
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/log", "root", "GARINplz");
					String sql="insert into login values(?,?)";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1,user1.getText());
					stmt.setString(2, pass1.getText());
					
					if(pass2.getText().equals(pass1.getText()))
					{
					stmt.execute();
					JOptionPane.showMessageDialog(null, "new user added ");
					}
					else
						{
						JOptionPane.showMessageDialog(null, "Enter correct Password");
						}
					con.close();
						}
				catch (Exception e1) {
					System.out.print(e1);
				}	
			}
		});
		btnDone.setBounds(112, 326, 97, 25);
		frame.getContentPane().add(btnDone);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(240, 255, 255));
		btnCancel.setBackground(new Color(25, 25, 112));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login l=new login();
				l.frame.setVisible(true);
				
			}
		});
		btnCancel.setBounds(273, 326, 97, 25);
		frame.getContentPane().add(btnCancel);
		
		pass1 = new JPasswordField();
		pass1.setBounds(221, 192, 182, 22);
		frame.getContentPane().add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setBounds(221, 244, 182, 22);
		frame.getContentPane().add(pass2);
	}
}
