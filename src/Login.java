import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends JFrame {
	private JTextField txtUsername;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private JPasswordField pwdPassword;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		super("Login");
		conn = JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 457);
		getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(43, 99, 88, 20);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(43, 165, 88, 20);
		getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(208, 96, 191, 26);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sql = "select * from Account where Username=? and Password=?";
				try{
					pst = conn.prepareStatement(sql);
					pst.setString(1, txtUsername.getText());
					pst.setString(2, pwdPassword.getText());
					rs=pst.executeQuery();
					if(rs.next()){
						rs.close();
						pst.close();
						
						setVisible(false);
						Loading ob = new Loading();
						ob.setUpLoading();
						ob.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
				finally{
					try{
						rs.close();
						pst.close();
					}
					catch(Exception e){
						
					}
				}
			}
		});
		btnLogin.setBounds(208, 223, 71, 29);
		getContentPane().add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signup ob= new Signup();
				ob.setVisible(true);
			}
		});
		btnSignUp.setBounds(311, 223, 88, 29);
		getContentPane().add(btnSignUp);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Forgot ob = new Forgot();
				ob.setVisible(true);
			}
		});
		btnForgotPassword.setBounds(208, 277, 191, 29);
		getContentPane().add(btnForgotPassword);
		
		JLabel lblTroubleLogin = new JLabel("Trouble Login!");
		lblTroubleLogin.setForeground(new Color(255, 0, 0));
		lblTroubleLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTroubleLogin.setBounds(43, 280, 117, 20);
		getContentPane().add(lblTroubleLogin);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(208, 163, 191, 26);
		getContentPane().add(pwdPassword);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 2), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(15, 45, 400, 318);
		getContentPane().add(panel);
	}
}
