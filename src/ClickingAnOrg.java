import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickingAnOrg extends JFrame implements Runnable{

	private JPanel contentPane;

	public void run() {
		try {
			ClickingAnOrg frame = new ClickingAnOrg();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ClickingAnOrg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWriteAPost = new JLabel("Write a post");
		lblWriteAPost.setForeground(new Color(255, 255, 255));
		lblWriteAPost.setHorizontalAlignment(SwingConstants.CENTER);
		lblWriteAPost.setBounds(73, 290, 248, 29);
		contentPane.add(lblWriteAPost);
		
		JLabel lblPupOrganizationSearch = new JLabel("PUP ORGANIZATION SEARCH");
		lblPupOrganizationSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblPupOrganizationSearch.setForeground(Color.WHITE);
		lblPupOrganizationSearch.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPupOrganizationSearch.setBounds(27, 29, 332, 36);
		contentPane.add(lblPupOrganizationSearch);
		
		JLabel lblOrgLogo = new JLabel("");
		lblOrgLogo.setIcon(new ImageIcon(ClickingAnOrg.class.getResource("/image/PUPLogo (1).png")));
		lblOrgLogo.setForeground(new Color(255, 255, 255));
		lblOrgLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrgLogo.setBounds(73, 111, 50, 50);
		contentPane.add(lblOrgLogo);
		
		JLabel lblNewLabel = new JLabel("Organization Type");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 111, 161, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumOfMembers = new JLabel(" Num Of Members");
		lblNumOfMembers.setForeground(new Color(255, 255, 255));
		lblNumOfMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfMembers.setBounds(73, 190, 50, 50);
		contentPane.add(lblNumOfMembers);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(160, 145, 161, 105);
		contentPane.add(lblDescription);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(73, 261, 248, 23);
		contentPane.add(lblEmail);
		
		JLabel lblNewsfeed = new JLabel("NEWS FEED");
		lblNewsfeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewsfeed.setForeground(Color.WHITE);
		lblNewsfeed.setBounds(73, 330, 248, 69);
		contentPane.add(lblNewsfeed);
		
		JButton btnNewButton = new JButton("Join this Org");
		btnNewButton.setBounds(73, 410, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLeaveThisOrg = new JButton("Leave this Org");
		btnLeaveThisOrg.setBounds(201, 410, 120, 23);
		contentPane.add(btnLeaveThisOrg);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(146, 444, 93, 23);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				MainActivity.ActivityNewsFeed();
				ClickingAnOrg.this.dispose();
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(247, 76, 74, 23);
		contentPane.add(btnEdit);
		
		JLabel lblOrganization = new JLabel("Organization #1");
		lblOrganization.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrganization.setForeground(Color.WHITE);
		lblOrganization.setBounds(73, 76, 161, 23);
		contentPane.add(lblOrganization);
	}
}
