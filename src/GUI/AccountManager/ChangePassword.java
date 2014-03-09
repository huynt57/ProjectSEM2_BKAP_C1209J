package GUI.AccountManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomPasswordField;
import GUI.Classes.CustomTextField;

public class ChangePassword extends JPanel {
	public ChangePassword(Point pos, Dimension d, JPanel parentPanel) {
		super();
		this.setBounds(pos.x, pos.y, d.width, d.height);
		setBackground(Configure.DEFAULT_RIGHT_PANEL_COLOR);
		setLayout(null);
		parentPanel.add(this);
		
		int beginPos = (d.height - 280)/2;
		int step = 35;
		int posLeft = 120;
		
		CustomLabel oldPassLabel = new CustomLabel("Current password: ",
				Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
				new Point(posLeft, beginPos), new Dimension(150, 30), true,
				SwingConstants.LEFT, SwingConstants.CENTER, ChangePassword.this);

		final CustomPasswordField oldPass = new CustomPasswordField("",
				Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
						Font.PLAIN, 13), new Point(posLeft, beginPos + step -5), new Dimension(
						d.width - posLeft * 2, 30), ChangePassword.this);

		CustomLabel newPassLabel = new CustomLabel("New password: ",
				Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
				new Point(posLeft, beginPos + step * 2), new Dimension(150, 30), true,
				SwingConstants.LEFT, SwingConstants.CENTER, ChangePassword.this);
		
		final CustomPasswordField newPass = new CustomPasswordField("",
				Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
						Font.PLAIN, 13), new Point(posLeft, beginPos + step * 3 - 5), new Dimension(
						d.width - posLeft * 2, 30), ChangePassword.this);
		
		CustomLabel confirmLabel = new CustomLabel("Confirm new password: ",
				Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
				new Point(posLeft, beginPos + step * 4), new Dimension(200, 30), true,
				SwingConstants.LEFT, SwingConstants.CENTER, ChangePassword.this);
		
		final CustomPasswordField confirmField = new CustomPasswordField("",
				Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
						Font.PLAIN, 13), new Point(posLeft, beginPos + step * 5 - 5), new Dimension(
						d.width - posLeft * 2, 30), ChangePassword.this);
		
		CustomButton submit = new CustomButton("Submit", Color.WHITE,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
				false, false, Color.GRAY, true, new Point(posLeft, beginPos + step * 6 + 10),
				new Dimension(80, 30), ChangePassword.this);
		
		CustomButton clear = new CustomButton("Clear", Color.WHITE,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
				false, false, Color.LIGHT_GRAY, true, new Point(posLeft + 90, beginPos + step * 6 + 10),
				new Dimension(80, 30), ChangePassword.this);
		
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				oldPass.setText("");
				newPass.setText("");
				confirmField.setText("");
			}
		});
	}
}
