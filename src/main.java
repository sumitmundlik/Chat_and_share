import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class main {

	public JFrame frame;
	JLabel lblA;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 601, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		login l=new login();
		//String s1;
		lblA = new JLabel("Activity");
		lblA.setForeground(new Color(255, 0, 0));
		lblA.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblA.setBounds(225, 24, 162, 28);
		frame.getContentPane().add(lblA);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(51, 0, 204));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 65, 589, 9);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Chatt");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\cht\\com\\if_share__sharing__community__network__socialnetwork__media__social_2528082.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				send s=new send();
				s.frame.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(290, 166, 288, 250);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnShare = new JButton("Share");
		btnShare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				cht s1=new cht();
				s1.frame.setVisible(true);
				
				
			}
		});
		btnShare.setIcon(new ImageIcon("C:/Users/user/eclipse-workspace/cht/com/if_social_38_492952.png"));
		btnShare.setForeground(Color.YELLOW);
		btnShare.setBackground(new Color(176, 224, 230));
		btnShare.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShare.setBounds(12, 166, 278, 250);
		frame.getContentPane().add(btnShare);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBackground(Color.RED);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login l=new login();
				l.frame.setVisible(true);
			}
		});
		btnLogOut.setBounds(459, 16, 97, 25);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setForeground(new Color(0, 100, 0));
		lblChat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblChat.setBounds(48, 112, 185, 28);
		frame.getContentPane().add(lblChat);
		
		JLabel lblFileSharing = new JLabel("File Sharing");
		lblFileSharing.setForeground(new Color(0, 100, 0));
		lblFileSharing.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblFileSharing.setBounds(326, 112, 185, 28);
		frame.getContentPane().add(lblFileSharing);
	}

}
