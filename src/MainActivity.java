
public class MainActivity{
	public static void main(String[]args) {
		ActivityMain();
	}
	public static void ActivityMain() {
		Thread HomescreenGUI = new Thread(new Homescreen());
		HomescreenGUI.start();
	}
	public static void ActivitySignUp() {
		Thread SignUpGUI = new Thread(new ApplicantSignup());
		SignUpGUI.start();
	}
	public static void ActivityNewsFeed() {
		Thread NewsFeedGUI = new Thread(new NewsFeed());
		NewsFeedGUI.start();
	}
	public static void ActivityProfile() {
		Thread ProfileGUI = new Thread(new Profile());
		ProfileGUI.start();
	}
	public static void ActivityCreateOrg() {
		Thread CreateOrgGUI = new Thread(new CreateAnOrg());
		CreateOrgGUI.start();
	}	
	public static void ActivityLeaveOrg() {
		Thread LeaveOrgGUI = new Thread(new LeaveAnOrg());
		LeaveOrgGUI.start();
	}
	public static void ActivitySearch() {
		Thread SearchGUI = new Thread(new Search());
		SearchGUI.start();
	}
}