import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;

public class jserver {

	public static JFrame frame;
	static InputStream in;
	static OutputStream out;
	TextField t1;
	static String b4;
	static JLabel lbl4;
	static JLabel lbl5;
	static JLabel lbl6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jserver window = new jserver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			@SuppressWarnings("resource")
			ServerSocket serv=new ServerSocket(4000);
			//lbl4.setText("connected");
			Socket socket=serv.accept();
			lbl5.setText("done");
			
			in=socket.getInputStream();
			out=new FileOutputStream(b4);
			int count;
			byte b[]=new byte[99*1024];
			lbl6.setText("new file recieved");
			
			JButton btnDone = new JButton("Done");
			btnDone.setBackground(new Color(216, 191, 216));
			btnDone.setBounds(169, 294, 97, 25);
			frame.getContentPane().add(btnDone);
			while((count=in.read(b))>0) {
				out.write(b, 0, count);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public jserver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("EditorPane.disabledBackground"));
		frame.setBounds(100, 100, 450, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblServer = new JLabel("Recieve");
		lblServer.setBounds(128, 23, 103, 45);
		lblServer.setFont(new Font("Tahoma", Font.BOLD, 26));
		frame.getContentPane().add(lblServer);
		
		JLabel lblSetFileName = new JLabel("Set file name");
		lblSetFileName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSetFileName.setForeground(new Color(139, 0, 139));
		lblSetFileName.setBounds(12, 96, 94, 16);
		frame.getContentPane().add(lblSetFileName);
		
		t1 = new TextField();
		t1.setBounds(132, 96, 168, 24);
		frame.getContentPane().add(t1);
		
		JButton b1 = new JButton("Set");
		b1.setFont(new Font("Tahoma", Font.BOLD, 18));
		b1.setForeground(new Color(148, 0, 211));
		b1.setBounds(323, 92, 97, 25);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b4=t1.getText();
			}
		});
		frame.getContentPane().add(b1);
		
		JLabel lbl1 = new JLabel("Status");
		lbl1.setBounds(25, 152, 56, 16);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("connection");
		lbl2.setBounds(23, 198, 67, 16);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("files");
		lbl3.setBounds(25, 243, 81, 16);
		frame.getContentPane().add(lbl3);
		
		lbl4 = new JLabel("Running");
		lbl4.setBounds(112, 152, 97, 16);
		frame.getContentPane().add(lbl4);
		
		lbl5 = new JLabel("no connection");
		lbl5.setBounds(128, 198, 81, 16);
		frame.getContentPane().add(lbl5);
		
		lbl6 = new JLabel("waiting for sender");
		lbl6.setBounds(128, 243, 103, 16);
		frame.getContentPane().add(lbl6);
	}
}
