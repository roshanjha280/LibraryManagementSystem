import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {

	private JPanel contentPane;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	private JTextField txtStudentId;
	private JTextField txtName;
	private JTextField txtFatherName;
	private JTextField textField;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Student() {
		super("New Student");
		conn=JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 105, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(39, 58, 81, 20);
		contentPane.add(lblStudentId);
		
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(39, 156, 95, 20);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(39, 207, 69, 20);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(39, 261, 69, 20);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(39, 315, 69, 20);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(39, 374, 69, 20);
		contentPane.add(lblSemester);
		
		txtStudentId = new JTextField();
		txtStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentId.setEditable(false);
		txtStudentId.setBounds(190, 55, 186, 26);
		contentPane.add(txtStudentId);
		txtStudentId.setColumns(10);
		random();
		
		txtName = new JTextField();
		txtName.setBounds(190, 102, 186, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtFatherName = new JTextField();
		txtFatherName.setBounds(190, 153, 186, 26);
		contentPane.add(txtFatherName);
		txtFatherName.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"B. Tech", "BCA", "BBA", "BSC", "MBA"}));
		comboBox.setBounds(190, 204, 186, 26);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(190, 258, 186, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_1.setBounds(190, 312, 186, 26);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox_2.setBounds(190, 368, 186, 26);
		contentPane.add(comboBox_2);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String sql = "insert into Student (Student_ID,Name,Father,Course,Branch,Year,Semester) values (?,?,?,?,?,?,?)";
				try {
					pst=conn.prepareStatement(sql);
					pst.setString(1, txtStudentId.getText());
					pst.setString(2, txtName.getText());
					pst.setString(3, txtFatherName.getText());
					pst.setString(4, (String)comboBox.getSelectedItem());
					pst.setString(5, textField.getText());
					pst.setString(6, (String)comboBox_1.getSelectedItem());
					pst.setString(7, (String)comboBox_2.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Student Registered");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnRegister.setBounds(85, 435, 115, 29);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(231, 435, 115, 29);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 2), "New Student", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(15, 16, 389, 468);
		contentPane.add(panel);
	}
	
	public void random(){
		Random rd = new Random();
		txtStudentId.setText(String.valueOf(rd.nextInt(1001)));
	}

}
