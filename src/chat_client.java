

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class chat_client extends JFrame {
	
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
	public JPanel contentPane;
	public JTextField txtMsgtext;
	static JTextArea textArea;
	public JLabel lblClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat_client frame = new chat_client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			s=new Socket("localhost",1201);//ere the ip address is local as server and client is on 1 pc
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			String msgn="";
			while(!msgn.equals("exit")) {
				msgn=din.readUTF();
				textArea.setText(textArea.getText().trim()+"\nServer : "+msgn);
			}
			
		}catch(Exception e) {
			
		}
	}

	/**
	 * Create the frame.
	 */
	public chat_client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 53, 414, 178);
		contentPane.add(textArea);
		
		txtMsgtext = new JTextField();
		txtMsgtext.setBounds(10, 256, 297, 20);
		contentPane.add(txtMsgtext);
		txtMsgtext.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBackground(new Color(144, 238, 144));
		btnSend.setForeground(Color.DARK_GRAY);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String msgou="";
					msgou=txtMsgtext.getText().trim();
					dout.writeUTF(msgou);
					
				}catch(Exception es) {
					
				}
				
			}
		});
		btnSend.setBounds(335, 255, 89, 23);
		contentPane.add(btnSend);
		
		lblClient = new JLabel("CLIENT");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClient.setBounds(190, 11, 95, 31);
		contentPane.add(lblClient);
	}
}
