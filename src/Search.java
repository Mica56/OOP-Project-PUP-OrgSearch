import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.Scrollbar;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Search extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField txtSearch;
	private ArrayList<String> objOrgFound;
	private JList list;

	private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
	private ResultSet objResultSet;

	public static String selectedSOrg;
	public static boolean boolSearch = false;

	public void run() {
		try {
			Search frame = new Search();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	Search() {
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
            SearchGUI();
        }  //if(boolConn2Db)
    }  //Search() 

	public void SearchGUI() {
		setTitle("Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSearch.setBounds(110, 62, 99, 36);
		contentPane.add(lblSearch);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Search.class.getResource("/image/PUPLogo (1).png")));
		lblLogo.setBounds(48, 36, 53, 50);
		contentPane.add(lblLogo);
		
		JLabel lblPOS = new JLabel("PUP ORGANIZATION");
		lblPOS.setHorizontalAlignment(SwingConstants.CENTER);
		lblPOS.setForeground(Color.WHITE);
		lblPOS.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPOS.setBounds(110, 32, 230, 36);
		contentPane.add(lblPOS);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("Search");
		txtSearch.setBounds(121, 130, 148, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 173, 237, 205);
		contentPane.add(scrollPane);		
		list = new JList();
		scrollPane.setViewportView(list);
		
		txtSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				txtSearch.setText(null); 
            }  //public void mouseClicked(MouseEvent objME)
        }); //txtSearch.addMouseListener(new MouseAdapter()
	
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				try {
					boolean boolFound = false;
					String strSQLQuery = "SELECT strorgname FROM tblorg ";            

					String strComp, strorgname;
					objOrgFound = new ArrayList<String>();
					objResultSet = objSQLQuery.executeQuery(strSQLQuery);

					String strComplower = (txtSearch.getText().trim()).toLowerCase();
					String strCompupper = (txtSearch.getText().trim()).toUpperCase();
					
					while (objResultSet.next()) {
                    			    			 
						String strDatalower = (objResultSet.getString("strorgname").trim()).toLowerCase();
						String strDataupper = (objResultSet.getString("strorgname").trim()).toUpperCase();

						if (strComplower.contains(strDatalower)||strCompupper.contains(strDataupper)||strDatalower.contains(strComplower)||strDataupper.contains(strCompupper)) {
							strorgname = objResultSet.getString("strorgname");
							objOrgFound.add(strorgname);
							boolFound=true;
						} //if (strComplower.contains(strDatalower)||strCompupper.contains(strDataupper)||strDatalower.contains(strComplower)||strDataupper.contains(strCompupper))
                   	}  // while (objResultSet.next()) 
					
                    	if (!boolFound) {
                    		strorgname = "Organization not found";
                        	objOrgFound.add(strorgname);
                   	 	}  //if (!boolFound) 
                    	
                    	list = new JList(objOrgFound.toArray());
                    	scrollPane.setViewportView(list);

                    	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    	list.addListSelectionListener(new ListSelectionListener() {
                    		public void valueChanged(ListSelectionEvent objLE) {             
                    			int intIndex = list.getSelectedIndex();
                    			selectedSOrg = list.getSelectedValue().toString();

                				if (intIndex != -1) {               
                					MainActivity.ActivityClickingAnOrg();
                					Search.this.dispose();
                					boolSearch = true;
                				}  //if (intIndex != -1)
                    		}  //public void valueChanged(ListSelectionEvent objLE)

        				}); //list.addListSelectionListener(new ListSelectionListener()
                	} catch (Exception objEx) {
                		System.out.println("Problem retrieving information..");
                		System.out.println(objEx);
               	 	}  //try
			}  //public void actionPerformed(ActionEvent objAE)
        }); //txtSearch.addActionListener(new ActionListener()

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(151, 407, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityNewsFeed();				
				Search.this.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});	//btnNewButton.addActionListener(new ActionListener()
	} //public void SearchGUI()
} //public class Search extends JFrame implements Runnable
