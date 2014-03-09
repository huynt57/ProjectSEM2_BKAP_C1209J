package GUI.Classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class CustomPasswordField extends JPasswordField {
	public CustomPasswordField(String text, Color textColor, Font font, Point pos, Dimension dimension, JPanel parentPanel) {
		super(text);
		setBounds(pos.x, pos.y, dimension.width, dimension.height);
		setForeground(textColor);
		setFont(font);
		parentPanel.add(this);
	}
	public CustomPasswordField(Color textColor, Font font, Point pos, Dimension dimension, JPanel parentPanel) {
		super();
		setBounds(pos.x, pos.y, dimension.width, dimension.height);
		setForeground(textColor);
		setFont(font);
		parentPanel.add(this);
	}
}
