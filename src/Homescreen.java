import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusAdapter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Homescreen implements Runnable {

	private JFrame frmHomescreen;
	private JTextField txtEmail;
	private JPasswordField pwPassword;
	public static String struseremail;

	private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
	private ResultSet objResultSet;

	public void run() {
		try {
			Homescreen window = new Homescreen();
			window.frmHomescreen.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	Homescreen() {
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
            HomescreenGUI();
        }  // if (boolConn2Db)
    }  // Homescreen() 

	public void HomescreenGUI() {
		frmHomescreen = new JFrame();
		frmHomescreen.setTitle("Homescreen");
		frmHomescreen.setBackground(new Color(128, 0, 0));
		frmHomescreen.getContentPane().setBackground(SystemColor.menu);
		frmHomescreen.setBounds(100, 100, 650, 500);
		frmHomescreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomescreen.getContentPane().setLayout(null);
		
		JLabel lblPuP = new JLabel("New label");
		lblPuP.setIcon(new ImageIcon(Homescreen.class.getResource("/image/pupfront.png")));
		lblPuP.setBounds(64, 119, 180, 180);
		frmHomescreen.getContentPane().add(lblPuP);
		
		JLabel lblKeyIcon = new JLabel("New label");
		lblKeyIcon.setIcon(new ImageIcon(Homescreen.class.getResource("/image/key.png")));
		lblKeyIcon.setBounds(551, 246, 25, 25);
		frmHomescreen.getContentPane().add(lblKeyIcon);
		
		JLabel lblEmailIcon = new JLabel("New label");
		lblEmailIcon.setIcon(new ImageIcon(Homescreen.class.getResource("/image/email.png")));
		lblEmailIcon.setBounds(551, 185, 25, 25);
		frmHomescreen.getContentPane().add(lblEmailIcon);
		
		JLabel lblPUPLogo = new JLabel("puplogo");
		lblPUPLogo.setForeground(new Color(128, 0, 0));
		lblPUPLogo.setBackground(new Color(128, 0, 0));
		lblPUPLogo.setIcon(new ImageIcon(Homescreen.class.getResource("/image/PUPLogo (1).png")));
		lblPUPLogo.setBounds(20, 11, 50, 50);
		frmHomescreen.getContentPane().add(lblPUPLogo);
		
		JLabel lblPOS = new JLabel("PUP ORGANIZATION");
		lblPOS.setForeground(new Color(128, 0, 0));
		lblPOS.setHorizontalAlignment(SwingConstants.CENTER);
		lblPOS.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPOS.setBounds(314, 62, 310, 36);
		frmHomescreen.getContentPane().add(lblPOS);
		
		JLabel lblCreatedBy = new JLabel("Created by:");
		lblCreatedBy.setForeground(new Color(255, 255, 255));
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedBy.setBounds(76, 326, 152, 36);
		frmHomescreen.getContentPane().add(lblCreatedBy);
		
		JLabel lblCMicaela = new JLabel("Cerilla, Micaela T.");
		lblCMicaela.setForeground(new Color(255, 255, 255));
		lblCMicaela.setHorizontalAlignment(SwingConstants.CENTER);
		lblCMicaela.setBounds(76, 352, 152, 36);
		frmHomescreen.getContentPane().add(lblCMicaela);
		
		JLabel lblFBKristoffer = new JLabel("Ferrer, Bryan Kristoffer M.");
		lblFBKristoffer.setForeground(new Color(255, 255, 255));
		lblFBKristoffer.setHorizontalAlignment(SwingConstants.CENTER);
		lblFBKristoffer.setBounds(76, 368, 152, 53);
		frmHomescreen.getContentPane().add(lblFBKristoffer);
		
		JLabel lblIRAngelie = new JLabel("Inocencio, Roni Angelie A.");
		lblIRAngelie.setForeground(new Color(255, 255, 255));
		lblIRAngelie.setHorizontalAlignment(SwingConstants.CENTER);
		lblIRAngelie.setBounds(76, 400, 152, 36);
		frmHomescreen.getContentPane().add(lblIRAngelie);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setText("  Email");
		txtEmail.setBounds(362, 179, 226, 35);
		frmHomescreen.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		pwPassword = new JPasswordField();
		pwPassword.setHorizontalAlignment(SwingConstants.LEFT);
		pwPassword.setText(" Password");
		pwPassword.setColumns(10);
		pwPassword.setBounds(362, 240, 226, 36);
		frmHomescreen.getContentPane().add(pwPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setBounds(431, 338, 89, 23);
		frmHomescreen.getContentPane().add(btnLogin);
		
		txtEmail.addMouseListener(new MouseAdapter() {
           		 public void mouseClicked(MouseEvent objME) {
				txtEmail.setText(null); 
                		
           	 }  // public void mouseClicked(MouseEvent objME)
        	});

		pwPassword.addMouseListener(new MouseAdapter() {
           		 public void mouseClicked(MouseEvent objME) {
				pwPassword.setText(null); 
                		
           	 }  // public void mouseClicked(MouseEvent objME)
        	});

		pwPassword.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if (pwPassword.getText().equals("Password")){
					pwPassword.setEchoChar('*');
					pwPassword.setText("");
				}
				else {
					pwPassword.selectAll();
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {//need to edit
				try {
                    		boolean boolFound = false;
                    		String strSQLQuery = "SELECT *FROM tbluser ";
                   		
                    		String strComp, strData;
                    		objResultSet = objSQLQuery.executeQuery(strSQLQuery);

                    		strComp = txtEmail.getText().trim();
           
                    		while (objResultSet.next()) {
                        	strData = objResultSet.getString("stremail").trim();  
                       
                        		if (strComp.equals(strData)) {
                        				String strpass = pwPassword.getText();
                        				String dbpass = objResultSet.getString("strpass").trim();
                        				boolFound = true;
                        				if (strpass.contentEquals(dbpass)) {
                        					struseremail = strData;
                            				MainActivity.ActivityNewsFeed();
                            				frmHomescreen.dispose();
                        				}
                        				else {
                        					JOptionPane.showMessageDialog(null, "Wrong email or password","info",JOptionPane.ERROR_MESSAGE);
                        				}
                       			 }  // if (strComp.equals(strData))
                    		}  // while (objResultSet.next()) 

                    		if (!boolFound) {
                       			JOptionPane.showMessageDialog(null, "User email not found!");
                    		}  // if (!boolFound) 
                		} catch (Exception objEx) {
                    			System.out.println("Problem retrieving information..");
                    			System.out.println(objEx);
               			 }  // try
			}
		});
		
		JButton btnCreateAppAcc = new JButton("Create Applicant Account");
		btnCreateAppAcc.setBackground(new Color(255, 255, 255));
		btnCreateAppAcc.setBounds(384, 374, 180, 26);
		frmHomescreen.getContentPane().add(btnCreateAppAcc);
		btnCreateAppAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivitySignUp();
				frmHomescreen.dispose();
			}
		});
		
		JLabel lblPolytechnicU = new JLabel("Polytechnic University");
		lblPolytechnicU.setBackground(new Color(255, 255, 255));
		lblPolytechnicU.setForeground(new Color(255, 255, 255));
		lblPolytechnicU.setHorizontalAlignment(SwingConstants.CENTER);
		lblPolytechnicU.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblPolytechnicU.setBounds(80, 11, 206, 32);
		frmHomescreen.getContentPane().add(lblPolytechnicU);
		
		JLabel lblOfThePhilippines = new JLabel("of the Philippines");
		lblOfThePhilippines.setBackground(new Color(255, 255, 255));
		lblOfThePhilippines.setForeground(new Color(255, 255, 255));
		lblOfThePhilippines.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfThePhilippines.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblOfThePhilippines.setBounds(80, 29, 206, 32);
		frmHomescreen.getContentPane().add(lblOfThePhilippines);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(new Color(128, 0, 0));
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSearch.setBounds(419, 100, 101, 36);
		frmHomescreen.getContentPane().add(lblSearch);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 0, 0));
		separator.setBounds(362, 308, 226, 36);
		frmHomescreen.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(128, 0, 0));
		separator_1.setBounds(338, 29, 269, 36);
		frmHomescreen.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Homescreen.class.getResource("/image/maroon.png")));
		lblNewLabel_1.setBackground(new Color(128, 0, 0));
		lblNewLabel_1.setBounds(0, 0, 310, 461);
		frmHomescreen.getContentPane().add(lblNewLabel_1);
	}
}
