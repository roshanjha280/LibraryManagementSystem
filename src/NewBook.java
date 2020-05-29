import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class NewBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookid;
	private JTextField txtName;
	private JComboBox comboBox;
	private JTextField txtPublisher;
	private JTextField txtPrice;
	private JTextField txtPages;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
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
	public NewBook() {
		super("New Book");
		conn=JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(53, 68, 69, 20);
		contentPane.add(lblBookId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(53, 126, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(53, 192, 69, 20);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(53, 257, 69, 20);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(53, 320, 69, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(53, 378, 69, 20);
		contentPane.add(lblPages);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String sql = "insert into Book (Book_ID,Name,Edition,Publisher,Price,Pages) values (?,?,?,?,?,?)";
				try {
					pst=conn.prepareStatement(sql);
					pst.setString(1, txtBookid.getText());
					pst.setString(2, txtName.getText());
					pst.setString(3, (String)comboBox.getSelectedItem());
					pst.setString(4, txtPublisher.getText());
					pst.setString(5, txtPrice.getText());
					pst.setString(6, txtPages.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Book Added");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnAdd.setBounds(92, 448, 93, 29);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home ob = new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(278, 448, 93, 29);
		contentPane.add(btnBack);
		
		txtBookid = new JTextField();
		txtBookid.setBounds(225, 65, 182, 26);
		contentPane.add(txtBookid);
		txtBookid.setColumns(10);
		random();
		
		txtName = new JTextField();
		txtName.setBounds(225, 123, 182, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPublisher = new JTextField();
		txtPublisher.setBounds(225, 254, 182, 26);
		contentPane.add(txtPublisher);
		txtPublisher.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(225, 317, 182, 26);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtPages = new JTextField();
		txtPages.setBounds(225, 375, 182, 26);
		contentPane.add(txtPages);
		txtPages.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox.setBounds(225, 189, 182, 26);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 2), "New Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(15, 16, 434, 501);
		contentPane.add(panel);
	}
	
	public void random(){
		Random rd = new Random();
		txtBookid.setText(String.valueOf(rd.nextInt(1001)));
	}
}
