import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forgot extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtName;
	private JTextField txtQuestion;
	private JTextField txtAnswer;
	private JTextField txtPassword;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
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
	public Forgot() {
		super("Forgot Password");
		conn = JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(33, 68, 86, 20);
		contentPane.add(lblUsername);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(33, 123, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblYourSecurityQuestion = new JLabel("Your Security Question");
		lblYourSecurityQuestion.setBounds(33, 178, 173, 20);
		contentPane.add(lblYourSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(33, 235, 69, 20);
		contentPane.add(lblAnswer);
		
		JLabel lblYourPassword = new JLabel("Your Password");
		lblYourPassword.setBounds(33, 295, 115, 20);
		contentPane.add(lblYourPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(215, 65, 146, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(215, 120, 146, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtQuestion = new JTextField();
		txtQuestion.setEditable(false);
		txtQuestion.setBounds(215, 175, 146, 26);
		contentPane.add(txtQuestion);
		txtQuestion.setColumns(10);
		
		txtAnswer = new JTextField();
		txtAnswer.setBounds(215, 232, 146, 26);
		contentPane.add(txtAnswer);
		txtAnswer.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setBounds(215, 292, 146, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		btnSearch.setBounds(369, 64, 90, 29);
		contentPane.add(btnSearch);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retrieve();
			}
		});
		btnRetrieve.setBounds(369, 231, 90, 29);
		contentPane.add(btnRetrieve);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login ob = new Login();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(369, 291, 90, 29);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 3, true), "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(15, 27, 456, 331);
		contentPane.add(panel);
	}
	
	public void search(){
		String a1 = txtUsername.getText();
		String sql = "select * from Account where Username='"+a1+"'";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				txtName.setText(rs.getString(2));
				txtQuestion.setText(rs.getString(4));
				rs.close();
				pst.close();
			}
			else{
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void retrieve(){
		String a1 = txtUsername.getText();
		String a2 = txtAnswer.getText();
		String sql = "select * from Account where Username='"+a1+"' and Answer='"+a2+"'";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				txtPassword.setText(rs.getString(3));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
