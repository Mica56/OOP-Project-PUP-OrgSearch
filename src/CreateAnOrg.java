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

public class CreateAnOrg extends JFrame {

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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAnOrg frame = new CreateAnOrg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateAnOrg() {
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
		
		txtNameOfOrganization = new JTextField();
		txtNameOfOrganization.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameOfOrganization.setText("Name of Organization");
		txtNameOfOrganization.setBounds(64, 144, 254, 31);
		contentPane.add(txtNameOfOrganization);
		txtNameOfOrganization.setColumns(10);
		
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
		
		btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.menu);
		btnBack.setBounds(95, 377, 89, 30);
		contentPane.add(btnBack);
		
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
	}

}
