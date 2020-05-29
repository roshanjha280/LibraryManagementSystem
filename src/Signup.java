import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JTextField txtAnswer;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		super("Login");
		conn = JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(34, 66, 89, 20);
		contentPane.add(lblUsername);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 117, 56, 20);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 174, 69, 20);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(34, 228, 134, 20);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(34, 285, 69, 20);
		contentPane.add(lblAnswer);
		
		txtName = new JTextField();
		txtName.setBounds(197, 114, 209, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(197, 63, 209, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(197, 171, 209, 26);
		contentPane.add(pwdPassword);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your mother tongue?", "What is your nick name?", "Who is your first childhood friend?", "What is your school name?"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(197, 225, 209, 26);
		contentPane.add(comboBox);
		
		txtAnswer = new JTextField();
		txtAnswer.setBounds(197, 282, 209, 26);
		contentPane.add(txtAnswer);
		txtAnswer.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				try{
					String sql = "insert into Account (Username, Name, Password, Sec_Q, Answer) values (?,?,?,?,?)";
					pst=conn.prepareStatement(sql);
					pst.setString(1, txtUsername.getText());
					pst.setString(2, txtName.getText());
					pst.setString(3, pwdPassword.getText());
					pst.setString(4, (String)comboBox.getSelectedItem());
					pst.setString(5, txtAnswer.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Account Created");
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnCreate.setBounds(84, 350, 115, 29);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Login ob = new Login();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(254, 350, 115, 29);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 2), "New Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(15, 16, 413, 392);
		contentPane.add(panel);
	}
}
