import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cht {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cht window = new cht();
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
	public cht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.getContentPane().setForeground(new Color(107, 142, 35));
		frame.setBounds(100, 100, 375, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChatAs = new JLabel("Chat as");
		lblChatAs.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblChatAs.setBackground(new Color(0, 255, 127));
		lblChatAs.setForeground(new Color(255, 69, 0));
		lblChatAs.setBounds(119, 29, 186, 37);
		frame.getContentPane().add(lblChatAs);
		
		JButton btnC = new JButton("Server");
		btnC.setForeground(Color.GREEN);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				chat_server c1=new chat_server();
				c1.setVisible(true);
				
			}
		});
		btnC.setBounds(133, 118, 97, 25);
		frame.getContentPane().add(btnC);
		
		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				chat_client c2=new chat_client();
				c2.setVisible(true);
			}
		});
		btnClient.setForeground(Color.GREEN);
		btnClient.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClient.setBounds(133, 190, 97, 25);
		frame.getContentPane().add(btnClient);
	}

}
