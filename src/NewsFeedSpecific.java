import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NewsFeedSpecific extends JFrame implements Runnable {

	private JPanel contentPane;
	private JButton btnSearch;
	private ArrayList<String> objPosts;
	private ArrayList<String> objorgsjoined;

	private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
	private ResultSet objResultSet;

	public void run() {
		try {
			NewsFeedSpecific frame = new NewsFeedSpecific();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	NewsFeedSpecific() {
		String strDriver = "com.mysql.cj.jdbc.Driver";
        String strConn = "jdbc:mysql://localhost:3306/puporgsearch";
        String strUser = "linus";
        String strPass = "password123";

        boolConn2Db = false;

        try {        
            Class.forName(strDriver);
            objConn = DriverManager.getConnection(strConn, strUser, strPass);   
            objSQLQuery = objConn.createStatement(); 
             
            boolConn2Db = true;
        } catch (Exception objEx) {
            System.out.println("Problem retrieving information..");
            System.out.println(objEx);
        }  //try

        if (boolConn2Db) {
            NewsFeedSpecificGUI();
        }  //if (boolConn2Db)
    }  //NewsFeedSpecific()

	public void NewsFeedSpecificGUI() {
		setTitle("News Feed");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(NewsFeed.class.getResource("/image/PUPLogo (1).png")));
		lblLogo.setBounds(49, 34, 53, 50);
		contentPane.add(lblLogo);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(147, 410, 89, 23);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityMain();
				NewsFeedSpecific.this.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		}); //btnLogout.addActionListener(new ActionListener()
		
		JLabel lblPOS = new JLabel("PUP ORGANIZATION");
		lblPOS.setHorizontalAlignment(SwingConstants.CENTER);
		lblPOS.setForeground(Color.WHITE);
		lblPOS.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPOS.setBounds(111, 30, 230, 36);
		contentPane.add(lblPOS);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSearch.setBounds(111, 60, 99, 36);
		contentPane.add(lblSearch);
		
		btnSearch = new JButton();
		btnSearch.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearch.setText("Search an Organization");
		btnSearch.setBackground(new Color(220, 220, 220));
		btnSearch.setBounds(143, 130, 180, 36);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivitySearch();
				NewsFeedSpecific.this.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		}); //btnSearch.addActionListener(new ActionListener()
		
		JButton btnProfileButton = new JButton("Profile");
		btnProfileButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnProfileButton.setForeground(new Color(0, 0, 0));
		btnProfileButton.setBackground(new Color(220, 220, 220));
		btnProfileButton.setBounds(69, 130, 70, 36);
		contentPane.add(btnProfileButton);
		btnProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityProfile();
				NewsFeedSpecific.this.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		}); //btnProfileButton.addActionListener(new ActionListener()

		try {
            String strSQLQuery = "SELECT *FROM tblposts;"; 
            objResultSet = objSQLQuery.executeQuery(strSQLQuery);
            objPosts = new ArrayList<String>();
            while (objResultSet.next()) {
            	String strorgname = objResultSet.getString("strorgname");
            	if(strorgname.contentEquals(Search.selectedSOrg)) {
            		objPosts.add(objResultSet.getString("strheading"));
            		objPosts.add(objResultSet.getString("strbody"));
            		objPosts.add(objResultSet.getString("dtime"));
            	} //if(strorgname.contentEquals(Search.selectedSOrg))
            } //while (objResultSet.next())
            
            objResultSet.close();      
            
		} catch (Exception objEx) {
           		 System.out.println("Problem retrieving information..");
           		 System.out.println(objEx);
		}// try

		int count = 0;		
      	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 177, 254, 206);
		contentPane.add(scrollPane);
		JList list = new JList(objPosts.toArray());
		scrollPane.setViewportView(list);
		
	} //public void NewsFeedSpecificGUI()
} // public class NewsFeedSpecific extends JFrame implements Runnable