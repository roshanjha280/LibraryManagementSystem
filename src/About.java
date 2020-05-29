import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLibraryManagementSystem.setBounds(94, 52, 235, 20);
		contentPane.add(lblLibraryManagementSystem);
		
		JLabel lblVersion = new JLabel("Version - 1.0.1");
		lblVersion.setBounds(155, 89, 116, 20);
		contentPane.add(lblVersion);
		
		JLabel lblCopyright = new JLabel("Copyright @2020");
		lblCopyright.setBounds(142, 125, 133, 20);
		contentPane.add(lblCopyright);
		
		JLabel lblContactRoshantechgmailcom = new JLabel("Contact - roshantech999@gmail.com");
		lblContactRoshantechgmailcom.setBounds(77, 201, 274, 20);
		contentPane.add(lblContactRoshantechgmailcom);
		
		JLabel lblGithubroshanjha = new JLabel("Github - //roshanjha280/");
		lblGithubroshanjha.setBounds(77, 233, 197, 20);
		contentPane.add(lblGithubroshanjha);
	}

}
