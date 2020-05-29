import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

public class Loading extends JFrame implements Runnable{

	private JPanel contentPane;
	private JProgressBar progressBar;
	
	Connection conn;
	int s=0;
	Thread th;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
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
	public Loading() {
		super("Loading");
		th = new Thread((Runnable)this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("# Smart Library 1.1");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setBounds(51, 43, 325, 56);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(95, 158, 160));
		progressBar.setBounds(103, 182, 221, 24);
		contentPane.add(progressBar);
		
		JLabel lblPleaseWait = new JLabel("Please wait...");
		lblPleaseWait.setBounds(161, 211, 105, 20);
		contentPane.add(lblPleaseWait);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 3));
		panel.setBounds(15, 16, 398, 396);
		contentPane.add(panel);
	}
	
	public void setUpLoading(){
		setVisible(false);
		th.start();
	}
	
	public void run(){
		try{
			for(int i=1; i<=200; i++)
			{
				s=s+1;
				int m = progressBar.getMaximum();
				int v = progressBar.getValue();
				if(v<m){
					progressBar.setValue(progressBar.getValue()+1);
					
				}
				else{
					i=201;
					setVisible(false);
					Home ob = new Home();
					ob.setVisible(true);
				}
				Thread.sleep(50);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
