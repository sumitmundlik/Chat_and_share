import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class fclient {

	public JFrame frame;
	static Socket socket;
	String str;
	TextField textField;
	static InputStream in;
	static OutputStream out;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fclient window = new fclient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			socket=new Socket("localhost",4000);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the application.
	 */
	public fclient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 572, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectFile = new JLabel("Select file");
		lblSelectFile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectFile.setBounds(12, 58, 106, 30);
		frame.getContentPane().add(lblSelectFile);
		
		JButton b2 = new JButton("Browse");
		b2.setForeground(new Color(123, 104, 238));
		b2.setFont(new Font("Tahoma", Font.BOLD, 18));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filech=new JFileChooser();
				filech.showOpenDialog(b2);
				str=filech.getSelectedFile().getAbsolutePath();
				textField.setText(str);
			}
		});
		b2.setBounds(429, 63, 113, 25);
		frame.getContentPane().add(b2);
		
		textField = new TextField();
		textField.setBounds(113, 64, 310, 24);
		frame.getContentPane().add(textField);
		
		JButton b1 = new JButton("Send");
		b1.setFont(new Font("Tahoma", Font.BOLD, 18));
		b1.setForeground(new Color(138, 43, 226));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file=new File(str);
				
				byte[] b=new byte[99*1024];
				
				try {
					in=new FileInputStream(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					out=socket.getOutputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
			//0*963.-+
			e1.printStackTrace();
				}
				int count;
				try {
					while((count=in.read(b))>0)
					{
					out.write(b,0,count);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		b1.setBounds(235, 125, 97, 40);
		frame.getContentPane().add(b1);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBackground(new Color(51, 102, 153));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDone.setForeground(new Color(204, 255, 204));
		btnDone.setBounds(235, 209, 97, 30);
		frame.getContentPane().add(btnDone);
	}
}
