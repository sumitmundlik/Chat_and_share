


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class chat_server extends JFrame {

	public JPanel contentPane;
	public JTextField txtMsgtext;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
    static TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat_server frame = new chat_server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String msgn ="";
		try {
			ss=new ServerSocket(1201);
			s=ss.accept();//now server will accept connection.
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			while(!msgn.equals("exit")) {
				msgn=din.readUTF();
				textArea.setText(textArea.getText().trim()+"\nClient : "+msgn);//displaying the message from client
			}
		}catch(Exception e)
		{
			
		}
	}

	/**
	 * Create the frame.
	 */
	public chat_server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 343);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	 textArea = new TextArea();
	 textArea.setForeground(Color.BLACK);
		textArea.setBounds(10, 41, 414, 176);
		contentPane.add(textArea);
		
		JButton btnSend = new JButton("Send");
		btnSend.setForeground(Color.BLACK);
		btnSend.setBackground(new Color(144, 238, 144));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String msgout="";
					msgout=txtMsgtext.getText().trim();
					dout.writeUTF(msgout);
				}catch(Exception es) {
					
				}
				
			}
		});
		btnSend.setBounds(335, 255, 89, 23);
		contentPane.add(btnSend);
		
		txtMsgtext = new JTextField();
		txtMsgtext.setBounds(10, 256, 313, 20);
		contentPane.add(txtMsgtext);
		txtMsgtext.setColumns(10);
		
		JLabel lblServer = new JLabel("SERVER");
		lblServer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServer.setBounds(189, 13, 70, 24);
		contentPane.add(lblServer);
	}
}
