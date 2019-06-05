import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class send {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					send window = new send();
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
	public send() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 255, 127));
		frame.setBounds(100, 100, 575, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShareFile = new JLabel("Share file");
		lblShareFile.setForeground(new Color(100, 149, 237));
		lblShareFile.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblShareFile.setBounds(209, 33, 128, 32);
		frame.getContentPane().add(lblShareFile);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				fclient f=new fclient();
				f.frame.setVisible(true);
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSend.setForeground(new Color(138, 43, 226));
		btnSend.setBounds(54, 249, 152, 25);
		frame.getContentPane().add(btnSend);
		
		JButton btnRecieve = new JButton("Recieve");
		btnRecieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				jserver j=new jserver();
				j.frame.setVisible(true);
			}
		});
		btnRecieve.setForeground(new Color(138, 43, 226));
		btnRecieve.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRecieve.setBounds(316, 249, 152, 25);
		frame.getContentPane().add(btnRecieve);
		
		JLabel lblRecieverFirstEnter = new JLabel("Reciever first Enter the name of file");
		lblRecieverFirstEnter.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecieverFirstEnter.setForeground(new Color(255, 0, 255));
		lblRecieverFirstEnter.setBounds(292, 287, 232, 32);
		frame.getContentPane().add(lblRecieverFirstEnter);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(178, 34, 34));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(427, 41, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}
