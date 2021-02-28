import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class LeaveAnOrg extends JFrame implements Runnable {

	private JPanel contentPane;
	private ArrayList<String> objorgs;
	public static String selectedOrg;
	private String struseremail;

	private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
	private ResultSet objResultSet;

	public void run() {
		try {
			LeaveAnOrg frame = new LeaveAnOrg();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	LeaveAnOrg() {
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
        }  // try

        if (boolConn2Db) {
            LeaveAnOrgGUI();
        }  // if (boolConn2Db)
    }  // Profile() 

	public void LeaveAnOrgGUI() {
		setTitle("Leave An Organization");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LeaveAnOrg.class.getResource("/image/PUPLogo (1).png")));
		lblLogo.setBounds(50, 44, 53, 50);
		contentPane.add(lblLogo);
		
		JLabel lblPOS = new JLabel("PUP ORGANIZATION");
		lblPOS.setHorizontalAlignment(SwingConstants.CENTER);
		lblPOS.setForeground(Color.WHITE);
		lblPOS.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPOS.setBounds(112, 40, 230, 36);
		contentPane.add(lblPOS);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSearch.setBounds(112, 70, 99, 36);
		contentPane.add(lblSearch);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(150, 393, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityProfile();
				LeaveAnOrg.this.dispose();
			}
		});
		
		try {
		    struseremail = Homescreen.struseremail;
		    //struseremail.getUserEmail();//seems like this doesn't works 
                    String strSQLQuery = "SELECT strorgsjoined FROM tblorgsjoin " +
					 "WHERE strusercreator = '" + struseremail + "';";
		    /*String strSQLQuery = "SELECT strorgsjoined FROM tblorgsjoin " +
					 "WHERE strusercreator = 'micaela.cerilla@gmail.com';";*/           
      		    objorgs = new ArrayList<String>();
                    objResultSet = objSQLQuery.executeQuery(strSQLQuery);
           
                    while (objResultSet.next()) {
               		 String strorgsjoined = objResultSet.getString("strorgsjoined");              

			 objorgs.add(strorgsjoined);
           	 	}  // while (objResultSet.next())
		   objResultSet.close();             
       		 } catch (Exception objEx) {
           		 System.out.println("Problem retrieving information..");
           		 System.out.println(objEx);
       		 }// try

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 146, 222, 212);
		contentPane.add(scrollPane);		
		JList list = new JList(objorgs.toArray());
		scrollPane.setViewportView(list);

		list.addListSelectionListener(new ListSelectionListener() {

            		public void valueChanged(ListSelectionEvent objLE) {
             
                		int intIndex = list.getSelectedIndex();
				selectedOrg = list.getSelectedValue().toString();

                		if (intIndex != -1) {
                
                    		MainActivity.ActivityClickingAnOrg();
				LeaveAnOrg.this.dispose();
         
               			 }  // if (intIndex != -1)

           		 }  // public void valueChanged(ListSelectionEvent objLE)

        	});
	}

}
