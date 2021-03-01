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
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCollege;
	private JTextField txtStudNum;
	private JLabel txtEmail;
	private JPasswordField pwPassword;
	
	private JButton btnEdit;
	private JButton btnEdit1;
	private JButton btnEdit2;
	private JButton btnEdit3;
	private JButton btnEdit4;
	private JButton btnCreateAnOrganization;
	private JButton btnLeaveAnOrganization;
	private JButton btnBack;

	private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
	private ResultSet objResultSet;
	
	private String dbname = null;
	private String dbcollege = null;
	private String dbstudnum = null;
	private String dbemail = null;
	private String dbpass = null;

	public void run() {
		try {
			Profile frame = new Profile();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Profile() {
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
            ProfileGUI();
	    setupListener();
        }  // if (boolConn2Db)
    }  // Profile() 

	public void ProfileGUI() {
		System.out.println("homescreen: "+Homescreen.struseremail);
		try {
			String strSQLQuery = "SELECT *FROM tbluser;";// 
			objResultSet = objSQLQuery.executeQuery(strSQLQuery);//
			while (objResultSet.next()) {
				dbemail = (objResultSet.getString("stremail").trim()); 
				System.out.println("db: "+dbemail);
				if(dbemail.contentEquals(Homescreen.struseremail)) {
					System.out.println("true");
					dbname = (objResultSet.getString("strname").trim());
					dbcollege = (objResultSet.getString("strcollege").trim());
					dbstudnum = (objResultSet.getString("strstudnum").trim());
					dbemail = (objResultSet.getString("stremail").trim());
					dbpass = (objResultSet.getString("strpass").trim());
					break;
				}		
			}
		} catch (SQLException e) {
			System.out.println("Problem adding information..");
			e.printStackTrace();
		}
		System.out.println(dbname+" "+dbcollege+" "+dbstudnum+" "+dbemail+" "+dbpass);
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name: "+dbname);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblName.setBounds(46, 76, 160, 26);
		contentPane.add(lblName);
		
		txtName = new JTextField("Name: "+dbname);
		txtName.setBackground(SystemColor.text);
		txtName.setBounds(46, 99, 189, 23);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setForeground(SystemColor.windowText);
		btnEdit.setBackground(SystemColor.text);
		btnEdit.setBounds(264, 99, 58, 23);
		contentPane.add(btnEdit);
		
		JLabel lblCollege = new JLabel("College: "+dbcollege);
		lblCollege.setForeground(new Color(255, 255, 255));
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCollege.setBounds(46, 127, 160, 26);
		contentPane.add(lblCollege);
		
		txtCollege = new JTextField("College: "+dbcollege);
		txtCollege.setBackground(SystemColor.text);
		txtCollege.setColumns(10);
		txtCollege.setBounds(46, 150, 189, 23);
		contentPane.add(txtCollege);
		
		btnEdit1 = new JButton("Edit");
		btnEdit1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit1.setForeground(SystemColor.windowText);
		btnEdit1.setBackground(SystemColor.text);
		btnEdit1.setBounds(264, 150, 58, 23);
		contentPane.add(btnEdit1);
		
		JLabel lblStudentNumber = new JLabel("Student Number: "+dbstudnum);
		lblStudentNumber.setForeground(new Color(255, 255, 255));
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblStudentNumber.setBounds(46, 179, 160, 26);
		contentPane.add(lblStudentNumber);
		
		txtStudNum = new JTextField("Student Number: "+dbstudnum);
		txtStudNum.setBackground(SystemColor.text);
		txtStudNum.setColumns(10);
		txtStudNum.setBounds(46, 202, 189, 23);
		contentPane.add(txtStudNum);
		
		btnEdit2 = new JButton("Edit");
		btnEdit2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit2.setForeground(SystemColor.windowText);
		btnEdit2.setBackground(SystemColor.text);
		btnEdit2.setBounds(264, 202, 58, 23);
		contentPane.add(btnEdit2);
		
		JLabel lblEmail = new JLabel("Email: "+dbemail);
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(46, 232, 160, 26);
		contentPane.add(lblEmail);
		
		txtEmail = new JLabel("Email: "+dbemail);
		txtEmail.setForeground(new Color(255,255,255));
		txtEmail.setBounds(46, 255, 189, 23);
		contentPane.add(txtEmail);
		/*
		btnEdit3 = new JButton("Edit");
		btnEdit3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit3.setForeground(SystemColor.windowText);
		btnEdit3.setBackground(SystemColor.text);
		btnEdit3.setBounds(264, 255, 58, 23);
		contentPane.add(btnEdit3);
		*/
		JLabel lblPassword = new JLabel("Password: "+"---");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPassword.setBounds(46, 285, 160, 26);
		contentPane.add(lblPassword);
		
		btnEdit4 = new JButton("Edit");
		btnEdit4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit4.setForeground(SystemColor.windowText);
		btnEdit4.setBackground(SystemColor.text);
		btnEdit4.setBounds(264, 308, 58, 23);
		contentPane.add(btnEdit4);
		
		pwPassword = new JPasswordField("Password: "+"---");
		pwPassword.setBackground(SystemColor.text);
		pwPassword.setBounds(46, 308, 189, 23);
		contentPane.add(pwPassword);
		
		btnCreateAnOrganization = new JButton("Create an Org");
		btnCreateAnOrganization.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreateAnOrganization.setForeground(SystemColor.windowText);
		btnCreateAnOrganization.setBackground(SystemColor.text);
		btnCreateAnOrganization.setBounds(68, 358, 121, 33);
		contentPane.add(btnCreateAnOrganization);
		
		btnLeaveAnOrganization = new JButton("Leave an Org");
		btnLeaveAnOrganization.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLeaveAnOrganization.setForeground(SystemColor.windowText);
		btnLeaveAnOrganization.setBackground(SystemColor.text);
		btnLeaveAnOrganization.setBounds(195, 358, 115, 33);
		contentPane.add(btnLeaveAnOrganization);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBack.setForeground(SystemColor.windowText);
		btnBack.setBackground(SystemColor.text);
		btnBack.setBounds(158, 411, 66, 23);
		contentPane.add(btnBack);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(Profile.class.getResource("/image/PUPLogo (1).png")));
		lblLogo.setBounds(46, 15, 53, 50);
		contentPane.add(lblLogo);
		
		JLabel lblPOS = new JLabel("PUP ORGANIZATION");
		lblPOS.setHorizontalAlignment(SwingConstants.CENTER);
		lblPOS.setForeground(Color.WHITE);
		lblPOS.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPOS.setBounds(108, 11, 230, 36);
		contentPane.add(lblPOS);
		
		//what is this 
		JLabel lblSearch = new JLabel("SEARCHhhhhhhhhhhhhhhhhh");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSearch.setBounds(108, 41, 99, 36);
		contentPane.add(lblSearch);
		
		
	}

	public void setupListener() {
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				try {
					String strName=txtName.getText().trim();
					String strSQLQuery = "UPDATE tbluser SET strname = '"+strName+"' WHERE stremail = '"+dbemail+"';";
					objSQLQuery.executeUpdate(strSQLQuery);//
				} catch (SQLException e) {
					System.out.println("Problem adding information..");
					e.printStackTrace();
				}
			}
		});
		btnEdit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				try {
					String strCollege=txtCollege.getText().trim();
					String strSQLQuery = "UPDATE tbluser SET strcollege = '"+strCollege+"' WHERE stremail= '"+dbemail+"';";
					objSQLQuery.executeUpdate(strSQLQuery);//
				} catch (SQLException e) {
					System.out.println("Problem adding information..");
					e.printStackTrace();
				}
			}
		});
		
		btnEdit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				try {
					String strStudNum=txtStudNum.getText().trim();
					String strSQLQuery = "UPDATE tbluser SET strstudnum = '"+strStudNum+"' WHERE stremail= '"+dbemail+"';";
					objSQLQuery.executeUpdate(strSQLQuery);//
				} catch (SQLException e) {
					System.out.println("Problem adding information..");
					e.printStackTrace();
				}
			}
		});
		btnEdit4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				try {
					String strPassword=pwPassword.getText().trim();
					String strSQLQuery = "UPDATE tbluser SET strpass = '"+strPassword+"' WHERE stremail= '"+dbemail+"';";
					objSQLQuery.executeUpdate(strSQLQuery);//
				} catch (SQLException e) {
					System.out.println("Problem adding information..");
					e.printStackTrace();
				}
			}
		});
		txtName.addMouseListener(new MouseAdapter() {
           		 public void mouseClicked(MouseEvent objME) {
				txtName.setText(null); 
                		
           	 }  // public void mouseClicked(MouseEvent objME)
        	});

		txtCollege.addMouseListener(new MouseAdapter() {
           		 public void mouseClicked(MouseEvent objME) {
				txtCollege.setText(null); 
                		
           	 }  // public void mouseClicked(MouseEvent objME)
        	});

		txtStudNum.addMouseListener(new MouseAdapter() {
           		 public void mouseClicked(MouseEvent objME) {
				txtStudNum.setText(null); 
                		
           	 }  // public void mouseClicked(MouseEvent objME)
        	});

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

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				String strName = txtName.getText().trim();
				txtName.setText(strName);
			}
		});

		btnEdit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				String strCollege = txtCollege.getText().trim();
				txtCollege.setText(strCollege);
			}
		});
		
		btnEdit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				String strStudNum = txtStudNum.getText().trim();
				txtStudNum.setText(strStudNum );
			}
		});
		/*
		btnEdit3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				String strEmail = txtEmail.getText().trim();
				txtEmail.setText(strEmail);
			}
		});
		*/
		btnEdit4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				String strPassword = pwPassword.getText().trim();
				pwPassword.setText(strPassword);
			}
		});

		btnCreateAnOrganization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityCreateOrg();
				Profile.this.dispose();
			}
		});
		
		btnLeaveAnOrganization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityLeaveOrg();
				Profile.this.dispose();
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityNewsFeed();
				Profile.this.dispose();
			}
		});
	}
}
