import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class ApplicantSignup extends JFrame {

	private JPanel contentPane;
	private JTextField txtFullName;
	private JTextField txtCollege;
	private JTextField txtStudentNumber;
	private JTextField txtEmail;
	private JTextField txtPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicantSignup frame = new ApplicantSignup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ApplicantSignup() {
		setTitle("Sign Up for Applicant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPupLogo = new JLabel("New label");
		lblPupLogo.setIcon(new ImageIcon(ApplicantSignup.class.getResource("/image/PUPLogo (1).png")));
		lblPupLogo.setBounds(49, 47, 53, 50);
		contentPane.add(lblPupLogo);
		
		JLabel lblPO = new JLabel("PUP ORGANIZATION");
		lblPO.setHorizontalAlignment(SwingConstants.CENTER);
		lblPO.setForeground(Color.WHITE);
		lblPO.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPO.setBounds(111, 43, 230, 36);
		contentPane.add(lblPO);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSearch.setBounds(111, 73, 99, 36);
		contentPane.add(lblSearch);
		
		txtFullName = new JTextField();
		txtFullName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFullName.setText("Full Name");
		txtFullName.setBounds(90, 146, 203, 28);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);
		
		txtCollege = new JTextField();
		txtCollege.setHorizontalAlignment(SwingConstants.CENTER);
		txtCollege.setText("College");
		txtCollege.setColumns(10);
		txtCollege.setBounds(90, 185, 203, 28);
		contentPane.add(txtCollege);
		
		txtStudentNumber = new JTextField();
		txtStudentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentNumber.setText("Student Number");
		txtStudentNumber.setColumns(10);
		txtStudentNumber.setBounds(90, 223, 203, 28);
		contentPane.add(txtStudentNumber);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setText("Email");
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 262, 203, 28);
		contentPane.add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(90, 301, 203, 28);
		contentPane.add(txtPassword);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBackground(SystemColor.text);
		btnFinish.setBounds(148, 381, 89, 28);
		contentPane.add(btnFinish);
	}
}
