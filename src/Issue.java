import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Issue extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookId;
	private JTextField txtName;
	private JTextField txtEdition;
	private JTextField txtPublisher;
	private JTextField txtPrice;
	private JTextField txtPages;
	private JTextField txtStudentId;
	private JTextField txtName_1;
	private JTextField txtFatherName;
	private JTextField txtCourse;
	private JTextField txtBranch;
	private JTextField txtYear;
	private JTextField txtSemester;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue frame = new Issue();
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
	public Issue() {
		super("Issue Book");
		conn = JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(35, 71, 69, 20);
		contentPane.add(lblBookId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(35, 135, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(35, 203, 69, 20);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(35, 267, 69, 20);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(35, 329, 69, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(35, 391, 69, 20);
		contentPane.add(lblPages);
		
		txtBookId = new JTextField();
		txtBookId.setBounds(140, 68, 171, 26);
		contentPane.add(txtBookId);
		txtBookId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(140, 132, 171, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEdition = new JTextField();
		txtEdition.setBounds(140, 200, 171, 26);
		contentPane.add(txtEdition);
		txtEdition.setColumns(10);
		
		txtPublisher = new JTextField();
		txtPublisher.setBounds(140, 264, 171, 26);
		contentPane.add(txtPublisher);
		txtPublisher.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(140, 326, 171, 26);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtPages = new JTextField();
		txtPages.setBounds(140, 388, 171, 26);
		contentPane.add(txtPages);
		txtPages.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sql = "select * from Book where Book_ID=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, txtBookId.getText());
					rs= pst.executeQuery();
					if(rs.next()){
						String add1 = rs.getString("Name");
						txtName.setText(add1);
						String add2 = rs.getString("Edition");
						txtEdition.setText(add2);
						String add3 = rs.getString("Publisher");
						txtPublisher.setText(add3);
						String add4 = rs.getString("Price");
						txtPrice.setText(add4);
						String add5 = rs.getString("Pages");
						txtPages.setText(add5);
						rs.close();
						pst.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "Book Id Not Found");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}finally{
					try{
						rs.close();
						pst.close();
					}catch(Exception e){
						
					}
				}
			}
		});
		btnSearch.setBounds(328, 67, 79, 29);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Book Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 69, 0)));
		panel.setBounds(15, 16, 411, 452);
		contentPane.add(panel);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(478, 71, 86, 20);
		contentPane.add(lblStudentId);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(478, 122, 69, 20);
		contentPane.add(lblName_1);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(478, 172, 96, 20);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(478, 227, 69, 20);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(478, 288, 69, 20);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(478, 346, 69, 20);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(478, 402, 69, 20);
		contentPane.add(lblSemester);
		
		txtStudentId = new JTextField();
		txtStudentId.setBounds(596, 68, 174, 26);
		contentPane.add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtName_1 = new JTextField();
		txtName_1.setBounds(596, 119, 174, 26);
		contentPane.add(txtName_1);
		txtName_1.setColumns(10);
		
		txtFatherName = new JTextField();
		txtFatherName.setBounds(596, 169, 174, 26);
		contentPane.add(txtFatherName);
		txtFatherName.setColumns(10);
		
		txtCourse = new JTextField();
		txtCourse.setBounds(596, 224, 174, 26);
		contentPane.add(txtCourse);
		txtCourse.setColumns(10);
		
		txtBranch = new JTextField();
		txtBranch.setBounds(596, 282, 174, 26);
		contentPane.add(txtBranch);
		txtBranch.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setBounds(596, 343, 174, 26);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		txtSemester = new JTextField();
		txtSemester.setBounds(596, 399, 174, 26);
		contentPane.add(txtSemester);
		txtSemester.setColumns(10);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sql = "select * from Student where Student_ID=?";
				
				try {
					pst=conn.prepareStatement(sql);
					pst.setString(1, txtStudentId.getText());
					rs = pst.executeQuery();
					if(rs.next()){
						String add1 = rs.getString("Name");
						txtName_1.setText(add1);
						String add2 = rs.getString("Father");
						txtFatherName.setText(add2);
						String add3 = rs.getString("Course");
						txtCourse.setText(add3);
						String add4 = rs.getString("Branch");
						txtBranch.setText(add4);
						String add5 = rs.getString("Year");
						txtYear.setText(add5);
						String add6 = rs.getString("Semester");
						txtSemester.setText(add6);
						rs.close();
						pst.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "Student Id Not Found");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}finally{
					try{
						rs.close();
						pst.close();
					}catch(Exception e){
						
					}
				}
				
			}
		});
		btnSearch_1.setBounds(785, 67, 79, 29);
		contentPane.add(btnSearch_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Student Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(453, 16, 429, 452);
		contentPane.add(panel_1);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setBounds(478, 489, 96, 20);
		contentPane.add(lblDateOfIssue);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(596, 484, 194, 26);
		contentPane.add(dateChooser);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sql = "insert into issue (Book_ID, Name, Edition, Publisher, Price, Pages, Student_Id, SName, FName, Course,Branch,Year,Semester,DateOfIssue) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, txtBookId.getText());
					pst.setString(2, txtName.getText());
					pst.setString(3, txtEdition.getText());
					pst.setString(4, txtPublisher.getText());
					pst.setString(5, txtPrice.getText());
					pst.setString(6, txtPages.getText());
					pst.setString(7, txtStudentId.getText());
					pst.setString(8, txtName_1.getText());
					pst.setString(9, txtFatherName.getText());
					pst.setString(10, txtCourse.getText());
					pst.setString(11, txtBranch.getText());
					pst.setString(12, txtYear.getText());
					pst.setString(13, txtSemester.getText());
					pst.setString(14, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Issued");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnIssue.setBounds(459, 537, 115, 29);
		contentPane.add(btnIssue);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(708, 537, 115, 29);
		contentPane.add(btnBack);
	}
}
