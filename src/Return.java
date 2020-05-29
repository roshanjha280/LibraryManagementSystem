import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Return extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentId;
	private JTextField txtName;
	private JTextField txtFatherName;
	private JTextField txtCourse;
	private JTextField txtBranch;
	private JTextField txtYear;
	private JTextField txtSemester;
	private JTextField txtBookId;
	private JTextField txtName_1;
	private JTextField txtEdition;
	private JTextField txtPublisher;
	private JTextField txtPrice;
	private JTextField txtPages;
	private JTextField txtDateOfIssue;
	private JDateChooser dateChooser;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return frame = new Return();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Return() {
		super("Return Book");
		conn=JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(41, 74, 86, 20);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(41, 129, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(41, 187, 98, 20);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(41, 247, 69, 20);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(41, 307, 69, 20);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(41, 366, 69, 20);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(41, 425, 69, 20);
		contentPane.add(lblSemester);
		
		txtStudentId = new JTextField();
		txtStudentId.setBounds(178, 71, 182, 26);
		contentPane.add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(178, 126, 182, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtFatherName = new JTextField();
		txtFatherName.setBounds(178, 184, 182, 26);
		contentPane.add(txtFatherName);
		txtFatherName.setColumns(10);
		
		txtCourse = new JTextField();
		txtCourse.setBounds(178, 244, 182, 26);
		contentPane.add(txtCourse);
		txtCourse.setColumns(10);
		
		txtBranch = new JTextField();
		txtBranch.setBounds(178, 304, 182, 26);
		contentPane.add(txtBranch);
		txtBranch.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setBounds(178, 363, 182, 26);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		txtSemester = new JTextField();
		txtSemester.setBounds(178, 422, 182, 26);
		contentPane.add(txtSemester);
		txtSemester.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(492, 74, 69, 20);
		contentPane.add(lblBookId);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(492, 129, 69, 20);
		contentPane.add(lblName_1);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(492, 187, 69, 20);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(492, 247, 69, 20);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(492, 307, 69, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(492, 366, 69, 20);
		contentPane.add(lblPages);
		
		JLabel lblDateOfIssue = new JLabel("Date Of Issue");
		lblDateOfIssue.setBounds(492, 425, 98, 20);
		contentPane.add(lblDateOfIssue);
		
		txtBookId = new JTextField();
		txtBookId.setBounds(634, 71, 182, 26);
		contentPane.add(txtBookId);
		txtBookId.setColumns(10);
		
		txtName_1 = new JTextField();
		txtName_1.setBounds(634, 126, 182, 26);
		contentPane.add(txtName_1);
		txtName_1.setColumns(10);
		
		txtEdition = new JTextField();
		txtEdition.setBounds(634, 184, 182, 26);
		contentPane.add(txtEdition);
		txtEdition.setColumns(10);
		
		txtPublisher = new JTextField();
		txtPublisher.setBounds(634, 244, 182, 26);
		contentPane.add(txtPublisher);
		txtPublisher.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(634, 304, 182, 26);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtPages = new JTextField();
		txtPages.setBounds(634, 363, 182, 26);
		contentPane.add(txtPages);
		txtPages.setColumns(10);
		
		txtDateOfIssue = new JTextField();
		txtDateOfIssue.setBounds(634, 422, 182, 26);
		contentPane.add(txtDateOfIssue);
		txtDateOfIssue.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sql = "select * from Issue where Student_ID=?";
				try {
					pst=conn.prepareStatement(sql);
					pst.setString(1, txtStudentId.getText());
					rs=pst.executeQuery();
					if(rs.next()){
						String add1 = rs.getString("SName");
						txtName.setText(add1);
						String add2 = rs.getString("FName");
						txtFatherName.setText(add2);
						String add3 = rs.getString("Course");
						txtCourse.setText(add3);
						String add4 = rs.getString("Branch");
						txtBranch.setText(add4);
						String add5 = rs.getString("Year");
						txtYear.setText(add5);
						String add6 = rs.getString("Semester");
						txtSemester.setText(add6);
						String add7 = rs.getString("Book_ID");
						txtBookId.setText(add7);
						String add8 = rs.getString("Name");
						txtName_1.setText(add8);
						String add9 = rs.getString("Edition");
						txtEdition.setText(add9);
						String add10 = rs.getString("Publisher");
						txtPublisher.setText(add10);
						String add11 = rs.getString("Price");
						txtPrice.setText(add11);
						String add12 = rs.getString("Pages");
						txtPages.setText(add12);
						String add13 = rs.getString("DateOfIssue");
						txtDateOfIssue.setText(add13);
						rs.close();
						pst.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "Book is not issued with this Student ID");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				} finally{
					try{
						rs.close();
						pst.close();
					}catch(Exception e){
						
					}
				}
				
			}
		});
		btnSearch.setBounds(375, 70, 86, 29);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 2), "Return Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(15, 16, 827, 456);
		contentPane.add(panel);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setBounds(41, 494, 98, 20);
		contentPane.add(lblReturnDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(178, 488, 182, 26);
		contentPane.add(dateChooser);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				delete();
				returnUpdate();
			}
		});
		btnReturn.setBounds(504, 490, 86, 29);
		contentPane.add(btnReturn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(677, 490, 86, 29);
		contentPane.add(btnBack);
	}
	
	public void delete(){
		String sql = "delete from Issue where Student_ID=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, txtStudentId.getText());
			pst.execute();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void returnUpdate(){
		String sql="insert into Return(Student_ID,Name,FName,Course,Branch,Year,Semester,Book_ID,BName,Edition,Publisher,Price,Pages,DOI,DOR) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, txtStudentId.getText());
			pst.setString(2, txtName.getText());
			pst.setString(3, txtFatherName.getText());
			pst.setString(4, txtCourse.getText());
			pst.setString(5, txtBranch.getText());
			pst.setString(6, txtYear.getText());
			pst.setString(7, txtSemester.getText());
			pst.setString(8, txtBookId.getText());
			pst.setString(9, txtName_1.getText());
			pst.setString(10, txtEdition.getText());
			pst.setString(11, txtPublisher.getText());
			pst.setString(12, txtPrice.getText());
			pst.setString(13, txtPages.getText());
			pst.setString(14, txtDateOfIssue.getText());
			pst.setString(15, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
			
			pst.execute();
			JOptionPane.showMessageDialog(null, "Book Returned");
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
}


















