

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;


public class login {

	public JFrame frame;
	private JPasswordField pass;
	private final JLabel lblNotHavingAccount = new JLabel("Not having account");
	TextField user;
	String s1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Login Account");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lbl1.setBounds(188, 13, 187, 48);
		frame.getContentPane().add(lbl1);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setToolTipText("Enter the user-ID");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblusername.setBounds(257, 118, 97, 24);
		frame.getContentPane().add(lblusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setToolTipText("Enter the password");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpassword.setBounds(264, 177, 90, 16);
		frame.getContentPane().add(lblpassword);
		
		pass = new JPasswordField();
		pass.setBounds(360, 175, 187, 22);
		frame.getContentPane().add(pass);
		
		user = new TextField();
		user.setBounds(360, 118, 187, 24);
		frame.getContentPane().add(user);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/log", "root", "GARINplz");
					Statement stmt=con.createStatement();
					@SuppressWarnings("deprecation")
					String sql="select * from login where userid='"+user.getText()+"' and pass='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						
							s1=user.getText();
							
						JOptionPane.showMessageDialog(null, "Login Successfully...");
					main m=new main();
					frame.dispose();
					m.frame.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					con.close();
				} catch (Exception e1) {
					System.out.print(e1);
				}
			}
		});
		btnLogin.setBounds(301, 259, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Cancel");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setText(null);
				pass.setText(null);
			}
		});
		btnReset.setBounds(450, 257, 97, 28);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("New Account");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				newlog q=new newlog();
				q.frame.setVisible(true);
			
			}
		});
		btnExit.setBounds(312, 304, 143, 25);
		frame.getContentPane().add(btnExit);
		lblNotHavingAccount.setForeground(Color.BLUE);
		lblNotHavingAccount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNotHavingAccount.setBounds(130, 297, 158, 36);
		frame.getContentPane().add(lblNotHavingAccount);
		
		JLabel label =  new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\cht\\com\\if_desktop_computer_45448.png"));
		label.setBounds(12, 74, 245, 226);
		frame.getContentPane().add(label);
	}
	

	
}
