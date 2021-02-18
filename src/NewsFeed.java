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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class NewsFeed extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsFeed frame = new NewsFeed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewsFeed() {
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
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("Search an Organization");
		txtSearch.setBounds(123, 130, 200, 36);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(69, 130, 36, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 177, 254, 206);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}
