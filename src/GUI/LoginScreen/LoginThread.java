package GUI.LoginScreen;

import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;

public class LoginThread extends Thread {
	public JLabel label;
	public String userName;
	public String password;
	public CustomFrame mainFrame;
	public CustomFrame loginFrame;
	public boolean remember;
	public boolean keeplogged;
	public boolean loginSuccessful;
	public CustomLabel loginStatus;
	public CustomLabel logo;
	public ImageIcon image;
	public CustomLabel appName;
	public LoginThread(JLabel label, String username, String password,
			CustomFrame mainFrame, CustomFrame loginFrame, boolean remember,
			boolean keepLogged, CustomLabel loginStatus, CustomLabel logo, ImageIcon image, CustomLabel appName) {
		super();
		this.label = label;
		this.userName = username;
		this.password = password;
		this.mainFrame = mainFrame;
		this.loginFrame = loginFrame;
		this.remember = remember;
		this.keeplogged = keepLogged;
		this.loginStatus = loginStatus;
		this.logo = logo;
		this.image = image;
		this.appName = appName;
	}
	@Override
	public void run() {
		super.run();
		label.setVisible(true);
		try {
			this.sleep(5000);
			label.setVisible(false);
			
			boolean loginSuccessful = false;
			String loginStatusText = "";
			
			// TODO: Check login information & return TRUE or FALSE to loginSuccessfull 
			
			if (userName.equals("vietzhu")&& password.equals("vietzhu"))loginSuccessful = true;
			else loginSuccessful = false;
			
			// END TODO
			
			try {
				FileWriter writer = new FileWriter("src/GUI/Resources/setting.bin");
				if(remember) writer.write("1\n"); else writer.write("0\n");
				if(keeplogged && loginSuccessful) writer.write("1\n"); else writer.write("0\n");
				writer.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			
			if(loginSuccessful) {
				loginFrame.setVisible(false);
				mainFrame.setVisible(true);
			} else {
				loginStatus.setVisible(true);
				loginStatus.setText("Username and Password not matched.");
				logo.setBounds(75, 290, image.getIconWidth(), image.getIconHeight());
				appName.setBounds(0, 340, 300, 20);
			}
			this.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}