import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

	public class EditOrg extends JFrame implements Runnable {

		private JPanel contentPane;
		private JTextField txtNameOfOrganization;
		private JTextField txtTypeOfOrganization;
		private JTextField txtDescription;
		private JTextField txtOrganizationEmail;
		private JButton btnUploadOrgPhoto;
		private JButton btnDone;
		private JButton btnBack;
		private JLabel lblSearch;
		private JLabel lblNewLabel;

		private Connection objConn;
		private boolean boolConn2Db;
		private Statement objSQLQuery;
		
		private String strOrgName;

		public void run() {
			try {
				EditOrg frame = new EditOrg(strOrgName);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			} //try
		} //public void run()

		EditOrg(String strOrgName) {
			this.strOrgName=strOrgName;
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
	            EditOrgGUI();
	        }  //if (boolConn2Db)
	    }  //EditOrg(String strOrgName)  

		public void EditOrgGUI() {
			setTitle("Create an Organization");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 400, 500);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(128, 0, 0));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblPOS = new JLabel("PUP ORGANIZATION");
			lblPOS.setHorizontalAlignment(SwingConstants.CENTER);
			lblPOS.setForeground(new Color(255, 255, 255));
			lblPOS.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblPOS.setBounds(116, 48, 230, 36);
			contentPane.add(lblPOS);
			
			JLabel lblorgname = new JLabel(this.strOrgName);
			lblorgname.setHorizontalAlignment(SwingConstants.CENTER);
			lblorgname.setText(this.strOrgName);
			lblorgname.setBounds(64, 144, 254, 31);
			contentPane.add(lblorgname);
			
			txtTypeOfOrganization = new JTextField();
			txtTypeOfOrganization.setText("Type of Organization");
			txtTypeOfOrganization.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeOfOrganization.setColumns(10);
			txtTypeOfOrganization.setBounds(64, 186, 254, 31);
			contentPane.add(txtTypeOfOrganization);
			
			txtDescription = new JTextField();
			txtDescription.setText("Description");
			txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
			txtDescription.setColumns(10);
			txtDescription.setBounds(64, 228, 254, 31);
			contentPane.add(txtDescription);
			
			txtOrganizationEmail = new JTextField();
			txtOrganizationEmail.setText("Organization Email");
			txtOrganizationEmail.setHorizontalAlignment(SwingConstants.CENTER);
			txtOrganizationEmail.setColumns(10);
			txtOrganizationEmail.setBounds(64, 270, 254, 31);
			contentPane.add(txtOrganizationEmail);
			
			btnUploadOrgPhoto = new JButton("Upload Organization Photo");
			btnUploadOrgPhoto.setBackground(SystemColor.menu);
			btnUploadOrgPhoto.setBounds(64, 312, 254, 31);
			contentPane.add(btnUploadOrgPhoto);
			
			btnDone = new JButton("Done");
			btnDone.setBackground(SystemColor.menu);
			btnDone.setBounds(194, 377, 89, 30);
			contentPane.add(btnDone);
			btnDone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent objAE) {
					try {
						String strorgtype = txtTypeOfOrganization.getText().trim();
						String strorgemail = txtOrganizationEmail.getText().trim();
						String strorgdes = txtDescription.getText().trim();
						System.out.println(strOrgName);
					
						String strSQLInsert = "UPDATE tblorg SET " + "strorgtype = '" + strorgtype + "',strorgdes = '" + strorgdes + "',strorgemail = '" + strorgemail +"' WHERE strorgname = '" + strOrgName + "';"; 	            
						objSQLQuery.executeUpdate(strSQLInsert);
						System.out.println("Rows inserted on the table..");

					} catch (Exception objEx) {
						System.out.println("Problem adding information..");
						System.out.println(objEx);

					} finally {
						if (objConn != null) {
							try {
								objConn.close();
							} catch (Exception objEx) {
								System.out.println("Problem closing the database!");
								System.out.println(objEx.toString());
							}  // try
						}  // if (objConn != null)
					}  // try
					
					MainActivity.ActivityClickingAnOrg();
					EditOrg.this.dispose();		
				} //public void actionPerformed(ActionEvent objAE)
			}); //btnDone.addActionListener(new ActionListener()
			
			btnBack = new JButton("Back");
			btnBack.setBackground(SystemColor.menu);
			btnBack.setBounds(95, 377, 89, 30);
			contentPane.add(btnBack);
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent objAE) {
					MainActivity.ActivityProfile();
					EditOrg.this.dispose();
				} //public void actionPerformed(ActionEvent objAE)
			}); //btnBack.addActionListener(new ActionListener()
			
			lblSearch = new JLabel("SEARCH");
			lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearch.setForeground(Color.WHITE);
			lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblSearch.setBounds(116, 78, 99, 36);
			contentPane.add(lblSearch);
			
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(CreateAnOrg.class.getResource("/image/PUPLogo (1).png")));
			lblNewLabel.setBounds(54, 52, 53, 50);
			contentPane.add(lblNewLabel);
			
		} //public void EditOrgGUI()
	} //public class EditOrg extends JFrame implements Runnable
