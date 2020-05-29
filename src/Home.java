import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import com.jtattoo.plaf.About;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 822, 31);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		mnFile.add(mntmExit);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login ob = new Login();
				ob.setVisible(true);
			}
		});
		mnFile.add(mntmLogout);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnEdit.add(mntmAbout);
		
		JLabel lblNewBook = new JLabel("New Book");
		lblNewBook.setBounds(82, 175, 83, 20);
		contentPane.add(lblNewBook);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setBounds(358, 175, 69, 20);
		contentPane.add(lblStatistics);
		
		JLabel lblNewStudent = new JLabel("New Student");
		lblNewStudent.setBounds(629, 175, 98, 20);
		contentPane.add(lblNewStudent);
		
		JButton btnNewBook = new JButton("");
		btnNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewBook ob = new NewBook();
				ob.setVisible(true);
			}
		});
		
		btnNewBook.setIcon(new ImageIcon("C:\\Users\\Roshan Jha\\Downloads\\Thvg-Wood-Folders-Glossy-Movies.png"));
		btnNewBook.setBounds(57, 64, 124, 107);
		contentPane.add(btnNewBook);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				Statistics ob = new Statistics();
				ob.setVisible(true);
			}
		});
		btnStatistics.setIcon(new ImageIcon("C:\\Users\\Roshan Jha\\Downloads\\Thvg-Wood-Folders-Glossy-Movies.png"));
		btnStatistics.setBounds(328, 64, 124, 107);
		contentPane.add(btnStatistics);
		
		JButton btnNewStudent = new JButton("New Student");
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student ob = new Student();
				ob.setVisible(true);
			}
		});
		btnNewStudent.setIcon(new ImageIcon("C:\\Users\\Roshan Jha\\Downloads\\Thvg-Wood-Folders-Glossy-Movies.png"));
		btnNewStudent.setBounds(603, 64, 124, 107);
		contentPane.add(btnNewStudent);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(50, 205, 50), 2, true), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 34, 770, 197);
		contentPane.add(panel);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Issue ob = new Issue();
				ob.setVisible(true);
			}
		});
		btnIssueBook.setIcon(new ImageIcon("C:\\Users\\Roshan Jha\\Downloads\\Thvg-Wood-Folders-Glossy-Movies.png"));
		btnIssueBook.setBounds(57, 284, 124, 99);
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Return ob = new Return();
				ob.setVisible(true);
			}
		});
		btnReturnBook.setIcon(new ImageIcon("C:\\Users\\Roshan Jha\\Downloads\\Thvg-Wood-Folders-Glossy-Movies.png"));
		btnReturnBook.setBounds(328, 284, 124, 99);
		contentPane.add(btnReturnBook);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				About ob = new About();
				ob.setVisible(true);
			}
		});
		btnAbout.setIcon(new ImageIcon("C:\\Users\\Roshan Jha\\Downloads\\Thvg-Wood-Folders-Glossy-Movies.png"));
		btnAbout.setBounds(603, 284, 124, 99);
		contentPane.add(btnAbout);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setBounds(82, 399, 83, 20);
		contentPane.add(lblIssueBook);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setBounds(350, 399, 89, 20);
		contentPane.add(lblReturnBook);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setBounds(642, 399, 48, 20);
		contentPane.add(lblAbout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2, true), "Action", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(15, 247, 763, 206);
		contentPane.add(panel_1);
	}
}
