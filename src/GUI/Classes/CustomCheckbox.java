package GUI.Classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class CustomCheckbox extends JCheckBox {
	public CustomCheckbox(String text, Color background, boolean borderPainted, boolean focusPainted, Point pos, Dimension dimension, JPanel parentPane) {
		super(text);
		setBackground(background);
		setBorderPainted(borderPainted);
		setFocusPainted(focusPainted);
		setBounds(pos.x, pos.y, dimension.width, dimension.height);
		parentPane.add(this);
	}
}
