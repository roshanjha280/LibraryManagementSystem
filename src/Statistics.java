import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Statistics extends JFrame {

	private JPanel contentPane;

	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Statistics() {
		super("Statistics");
		conn = JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 41, 868, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139)), "Issue Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel.setBounds(15, 16, 900, 288);
		contentPane.add(panel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 352, 868, 254);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(199, 21, 133)), "Return Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(15, 326, 900, 293);
		contentPane.add(panel_1);
		
		jTable1();
		jTable2();
	}
	
	public void jTable1(){
		try{
			String sql = "Select Book_ID,Name,Edition,Publisher,Price,Pages from Issue";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void jTable2(){
		try{
			String sql = "Select Student_ID,Name,FName,Course,Branch,Year from Return";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
}














