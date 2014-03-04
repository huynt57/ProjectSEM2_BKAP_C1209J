package GUI;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainScreen {
	public static void main(String args[]) {

		final CustomFrame mainFrame = new CustomFrame("MSB Portal", false,
				true, false, new Dimension(1000, 600));
		RemovablePanel mainPanel = new RemovablePanel(mainFrame);
		mainFrame.setContentPane(mainPanel);

		final CustomFrame loginFrame = new CustomFrame("Login", true, true,
				false, new Dimension(300, 380));
		RemovablePanel loginPane = new RemovablePanel(loginFrame);
		loginFrame.setContentPane(loginPane);
		loginPane.setLayout(null);

		CustomButton loginButton = new CustomButton("Login", Color.WHITE,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false,
				Color.GREEN, true, new Point(30, 185), new Dimension(80, 30),
				loginPane);

		CustomLabel loginTitle = new CustomLabel("Login to your account",
				Color.DARK_GRAY, Color.RED, CustomFont.getFont(Configure.DEFAULT_FONT,
						Font.PLAIN, 20), new Point(0, 20), new Dimension(300,
						30), true, SwingConstants.CENTER,
				SwingConstants.CENTER, loginPane);
		final CustomLabel loginStatus = new CustomLabel(
				"Username and password not match !", Color.RED,
				Configure.LOGIN_SCREEN_COLOR, CustomFont.getFont(Configure.DEFAULT_FONT,
						Font.PLAIN, 12), new Point(0, 40), new Dimension(300,
						40), false, SwingConstants.CENTER,
				SwingConstants.CENTER, loginPane);

		final HintTextField userNameTextField = new HintTextField("Username",
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(50,
						80), new Dimension(220, 25), loginPane);
		final ImageIcon image = new ImageIcon("src/username.bin");
		final CustomLabel username = new CustomLabel(image, new Point(19, 75),
				new Dimension(image.getIconWidth(), image.getIconHeight()),
				true, loginPane);

		final HintTextField passwordTextField = new HintTextField("Password",
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(50,
						129), new Dimension(220, 25), loginPane);
		final ImageIcon image2 = new ImageIcon("src/password.bin");
		final CustomLabel password = new CustomLabel(image2,
				new Point(19, 125), new Dimension(image2.getIconWidth(),
						image2.getIconHeight()), true, loginPane);

		final CustomButton forgotPassword = new CustomButton(
				"Forgot your password ? Click here", Color.BLUE,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14), false, false,
				Configure.LOGIN_SCREEN_COLOR, true, new Point(0, 250),
				new Dimension(300, 30), loginPane);
		forgotPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				forgotPassword.setForeground(Color.RED);
				// TODO : set Action when clicking forgot password
			}
		});

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			System.out.println("Unable to load Windows look and feel");
		}

		final CustomCheckbox remember = new CustomCheckbox("",
				Configure.LOGIN_SCREEN_COLOR, false, false,
				new Point(130, 180), new Dimension(20, 20), loginPane);
		final CustomLabel rememberLabel = new CustomLabel("Remember me",
				Color.BLACK, Configure.LOGIN_SCREEN_COLOR, CustomFont.getFont(
						Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(153, 181),
				new Dimension(83, 20), true, SwingConstants.CENTER,
				SwingConstants.CENTER, loginPane);
		final CustomCheckbox keepLogged = new CustomCheckbox("",
				Configure.LOGIN_SCREEN_COLOR, false, false,
				new Point(130, 200), new Dimension(20, 20), loginPane);
		final CustomLabel keepLoggedLabel = new CustomLabel(
				"Keep me logged in", Color.BLACK, Configure.LOGIN_SCREEN_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(153,
						201), new Dimension(103, 20), true,
				SwingConstants.CENTER, SwingConstants.CENTER, loginPane);
		final ImageIcon spinIcon = new ImageIcon("src/metro.bin");
		final CustomLabel loading = new CustomLabel(spinIcon,
				new Point(40, 297), new Dimension(spinIcon.getIconWidth(),
						spinIcon.getIconHeight()), false, loginPane);
		final ImageIcon image3 = new ImageIcon("src/devide.bin");
		final CustomLabel devider = new CustomLabel(image3, new Point(0, 240),
				new Dimension(image3.getIconWidth(), image3.getIconHeight()),
				true, loginPane);
		final ImageIcon image4 = new ImageIcon("src/msb.bin");
		final CustomLabel logo = new CustomLabel(image4, new Point(75, 290),
				new Dimension(image4.getIconWidth(), image4.getIconHeight()),
				true, loginPane);
		final CustomLabel appName = new CustomLabel("Medical Store Billing",
				Color.BLACK, Configure.LOGIN_SCREEN_COLOR, CustomFont.getFont(
						Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(0, 340),
				new Dimension(300, 20), true, SwingConstants.CENTER,
				SwingConstants.CENTER, loginPane);

		loginPane.setBackground(Configure.LOGIN_SCREEN_COLOR);
		mainPanel.setBackground(Configure.BACKGROUND_COLOR);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = userNameTextField.getText();
				String password = passwordTextField.getText();
				loginStatus.setVisible(false);
				boolean loginSuccessful = false;
				if (userName.length() < 6 || password.length() < 6) {
					loginStatus.setVisible(true);
					loginStatus.setText("Username or Password must be 6 characters at least.");
				} else {
					logo.setBounds(100, 290, image4.getIconWidth(),
							image4.getIconHeight());
					appName.setBounds(115, 340, 120, 20);

					
					
					// TODO: Check login information and return TRUE or FALSE to loginSuccessful
					
					if (userName.equals("vietzhu")&& password.equals("vietzhu"))loginSuccessful = true;
					else loginSuccessful = false;
					
					// TODO: Check login information and return TRUE or FALSE to loginSuccessful

					
					String loginStatusText = "";
					if (!loginSuccessful)
						loginStatusText = "Username and Password not matched.";

					final LoginThread loadingThread = new LoginThread(loading,
							loginSuccessful, mainFrame, loginFrame, remember
									.isSelected(), keepLogged.isSelected(),
							loginStatus, loginStatusText, logo, image4, appName);
					loadingThread.start();
				}
			}
		});
	}
}
