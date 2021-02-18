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
import javax.swing.ImageIcon;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCollege;
	private JTextField txtStudNum;
	private JTextField txtEmail;
	private JPasswordField pwPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Profile() {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(46, 76, 60, 26);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBackground(SystemColor.text);
		txtName.setBounds(46, 99, 189, 23);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit.setForeground(SystemColor.windowText);
		btnEdit.setBackground(SystemColor.text);
		btnEdit.setBounds(264, 99, 58, 23);
		contentPane.add(btnEdit);
		
		JLabel lblCollege = new JLabel("College:");
		lblCollege.setForeground(new Color(255, 255, 255));
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollege.setBounds(46, 127, 60, 26);
		contentPane.add(lblCollege);
		
		txtCollege = new JTextField();
		txtCollege.setBackground(SystemColor.text);
		txtCollege.setColumns(10);
		txtCollege.setBounds(46, 150, 189, 23);
		contentPane.add(txtCollege);
		
		JButton btnEdit1 = new JButton("Edit");
		btnEdit1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit1.setForeground(SystemColor.windowText);
		btnEdit1.setBackground(SystemColor.text);
		btnEdit1.setBounds(264, 150, 58, 23);
		contentPane.add(btnEdit1);
		
		JLabel lblStudentNumber = new JLabel("Student Number:");
		lblStudentNumber.setForeground(new Color(255, 255, 255));
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentNumber.setBounds(46, 179, 121, 26);
		contentPane.add(lblStudentNumber);
		
		txtStudNum = new JTextField();
		txtStudNum.setBackground(SystemColor.text);
		txtStudNum.setColumns(10);
		txtStudNum.setBounds(46, 202, 189, 23);
		contentPane.add(txtStudNum);
		
		JButton btnEdit2 = new JButton("Edit");
		btnEdit2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit2.setForeground(SystemColor.windowText);
		btnEdit2.setBackground(SystemColor.text);
		btnEdit2.setBounds(264, 202, 58, 23);
		contentPane.add(btnEdit2);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(46, 232, 60, 26);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(SystemColor.text);
		txtEmail.setColumns(10);
		txtEmail.setBounds(46, 255, 189, 23);
		contentPane.add(txtEmail);
		
		JButton btnEdit3 = new JButton("Edit");
		btnEdit3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit3.setForeground(SystemColor.windowText);
		btnEdit3.setBackground(SystemColor.text);
		btnEdit3.setBounds(264, 255, 58, 23);
		contentPane.add(btnEdit3);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(46, 285, 60, 26);
		contentPane.add(lblPassword);
		
		JButton btnEdit4 = new JButton("Edit");
		btnEdit4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEdit4.setForeground(SystemColor.windowText);
		btnEdit4.setBackground(SystemColor.text);
		btnEdit4.setBounds(264, 308, 58, 23);
		contentPane.add(btnEdit4);
		
		pwPassword = new JPasswordField();
		pwPassword.setBackground(SystemColor.text);
		pwPassword.setBounds(46, 308, 189, 23);
		contentPane.add(pwPassword);
		
		JButton btnCreateAnOrganization = new JButton("Create an Org");
		btnCreateAnOrganization.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreateAnOrganization.setForeground(SystemColor.windowText);
		btnCreateAnOrganization.setBackground(SystemColor.text);
		btnCreateAnOrganization.setBounds(68, 358, 121, 33);
		contentPane.add(btnCreateAnOrganization);
		
		JButton btnLeaveAnOrganization = new JButton("Leave an Org");
		btnLeaveAnOrganization.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLeaveAnOrganization.setForeground(SystemColor.windowText);
		btnLeaveAnOrganization.setBackground(SystemColor.text);
		btnLeaveAnOrganization.setBounds(195, 358, 115, 33);
		contentPane.add(btnLeaveAnOrganization);
		
		JButton btnBack = new JButton("Back");
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
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSearch.setBounds(108, 41, 99, 36);
		contentPane.add(lblSearch);
	}
}
