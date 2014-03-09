package GUI.LoginScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomCheckbox;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomPasswordField;
import GUI.Classes.CustomTextField;
import GUI.Classes.HintTextField;
import GUI.Classes.RemovablePanel;
import GUI.Classes.VButton;

public class LoginScreen extends CustomFrame {
	public LoginScreen(String title, boolean visible, boolean undecorate,
			boolean resizeable, Dimension dimension,
			final CustomFrame switchingFrame, final boolean rememberState, final boolean keepLoggedState) {
		super(title, visible, undecorate, resizeable, dimension);
		RemovablePanel loginPane = new RemovablePanel(this);
		this.setContentPane(loginPane);
		loginPane.setLayout(null);
		
		final CustomButton loginButton = new CustomButton("Login", Color.WHITE,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
				false, false, Color.GREEN, true, new Point(30, 185),
				new Dimension(80, 30), loginPane);

		CustomLabel loginTitle = new CustomLabel("Login to your account",
				Color.DARK_GRAY, Color.RED, CustomFont.getFont(
						Configure.DEFAULT_FONT, Font.PLAIN, 20), new Point(0,
						20), new Dimension(300, 30), true,
				SwingConstants.CENTER, SwingConstants.CENTER, loginPane);
		final CustomLabel loginStatus = new CustomLabel(
				"Username and password not match !", Color.RED,
				Configure.LOGIN_SCREEN_COLOR, CustomFont.getFont(
						Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(0,
						40), new Dimension(300, 40), false, 
				SwingConstants.CENTER, SwingConstants.CENTER, loginPane);
		
		final CustomTextField userNameTextField = new CustomTextField("Username", Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(50, 80), new Dimension(220, 25), loginPane);
		userNameTextField.setBorder(null);
		
		
		final ImageIcon image = new ImageIcon("src/GUI/Resources/username.bin");
		final CustomLabel username = new CustomLabel(image, new Point(19, 75),
				new Dimension(image.getIconWidth(), image.getIconHeight()),
				true, loginPane);
		
		final CustomPasswordField passwordTextField = new CustomPasswordField("Password", Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(50, 129), new Dimension(220, 25), loginPane);
		passwordTextField.setBorder(null);
		
		final ImageIcon image2 = new ImageIcon("src/GUI/Resources/password.bin");
		final CustomLabel password = new CustomLabel(image2,
				new Point(19, 125), new Dimension(image2.getIconWidth(),
						image2.getIconHeight()), true, loginPane);
		final CustomButton forgotPassword = new CustomButton(
				"Forgot your password ? Click here", Color.BLUE,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
				false, false, Configure.LOGIN_SCREEN_COLOR, true, new Point(0,
						250), new Dimension(300, 30), loginPane);
		forgotPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				forgotPassword.setForeground(Color.RED);
				
				// TODO : set Action when clicking forgot password
				
			}
		});

//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception ex) {
//			System.out.println("Unable to load Windows look and feel");
//		}

		final CustomCheckbox remember = new CustomCheckbox("",
				Configure.LOGIN_SCREEN_COLOR, false, false,
				new Point(130, 180), new Dimension(20, 20), loginPane);
		
		final CustomLabel rememberLabel = new CustomLabel("Remember me",
				Color.BLACK, Configure.LOGIN_SCREEN_COLOR, CustomFont.getFont(
						Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(153,
						181), new Dimension(83, 20), true,
				SwingConstants.CENTER, SwingConstants.CENTER, loginPane);
		final CustomCheckbox keepLogged = new CustomCheckbox("",
				Configure.LOGIN_SCREEN_COLOR, false, false,
				new Point(130, 200), new Dimension(20, 20), loginPane);
		final CustomLabel keepLoggedLabel = new CustomLabel(
				"Keep me logged in", Color.BLACK, Configure.LOGIN_SCREEN_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12),
				new Point(153, 201), new Dimension(103, 20), true,
				SwingConstants.CENTER, SwingConstants.CENTER, loginPane);
		final ImageIcon spinIcon = new ImageIcon("src/GUI/Resources/metro.bin");
		final CustomLabel loading = new CustomLabel(spinIcon,
				new Point(40, 297), new Dimension(spinIcon.getIconWidth(),
						spinIcon.getIconHeight()), false, loginPane);
		final ImageIcon image3 = new ImageIcon("src/GUI/Resources/devide.bin");
		final CustomLabel devider = new CustomLabel(image3, new Point(0, 240),
				new Dimension(image3.getIconWidth(), image3.getIconHeight()),
				true, loginPane);
		final ImageIcon image4 = new ImageIcon("src/GUI/Resources/msb.bin");
		final CustomLabel logo = new CustomLabel(image4, new Point(75, 290),
				new Dimension(image4.getIconWidth(), image4.getIconHeight()),
				true, loginPane);
		final CustomLabel appName = new CustomLabel("Medical Store Billing",
				Color.BLACK, Configure.LOGIN_SCREEN_COLOR, CustomFont.getFont(
						Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(0,
						340), new Dimension(300, 20), true,
				SwingConstants.CENTER, SwingConstants.CENTER, loginPane);

		if(rememberState) {
			userNameTextField.setText("vietzhu");
			passwordTextField.setText("vietzhu");
		} 
		remember.setSelected(rememberState);
		keepLogged.setSelected(keepLoggedState);
		
		loginPane.setBackground(Configure.LOGIN_SCREEN_COLOR);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String userName = userNameTextField.getText();
				String password = passwordTextField.getText();
				loginStatus.setVisible(false);
				if (userName.length() < 6 || password.length() < 6) {
					loginStatus.setVisible(true);
					loginStatus
							.setText("Username or Password must be 6 characters at least.");
				} else {
					logo.setBounds(100, 290, image4.getIconWidth(),
							image4.getIconHeight());
					appName.setBounds(115, 340, 120, 20);

					final LoginThread loadingThread = new LoginThread(loading,
							userName, password, switchingFrame,
							LoginScreen.this, remember.isSelected(), keepLogged
									.isSelected(), loginStatus, logo, image4,
							appName);
					loadingThread.start();
				}
				
			}
		});
		this.setVisible(true);
	}
}
