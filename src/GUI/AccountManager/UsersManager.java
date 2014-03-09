package GUI.AccountManager;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import GUI.Classes.Configure;

public class UsersManager extends JPanel {
	public UsersManager(Point pos, Dimension d, JPanel parentPanel) {
		super();
		this.setBounds(pos.x, pos.y, d.width, d.height);
		setBackground(Configure.DEFAULT_RIGHT_PANEL_COLOR);
		setLayout(null);
		parentPanel.add(this);
	}
}
