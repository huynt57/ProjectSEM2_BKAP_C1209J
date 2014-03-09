package GUI.MedicinesManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;

public class MedicineRow extends JPanel {
	public MedicineRow(String id, String name, String type, String supplier, String remain, int idSize, int nameSize, int typeSize, int supplierSize, int remainSize, int optionSize, Point pos, JPanel parentPanel) {
		super();
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(pos.x, pos.y, idSize + nameSize + typeSize + supplierSize + remainSize + optionSize, 40);
		CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel nameLabel = new CustomLabel(name, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(nameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel typeLabel = new CustomLabel(type, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + nameSize, pos.y), new Dimension(typeSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel supplierLabel = new CustomLabel(supplier, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + typeSize + nameSize, pos.y), new Dimension(supplierSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel ramainLabel = new CustomLabel(remain, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + typeSize + supplierSize + nameSize, pos.y), new Dimension(remainSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + nameSize + typeSize + supplierSize + remainSize + optionSize , 1), parentPanel);
		
		CustomButton edit = new CustomButton(new ImageIcon("src/GUI/Resources/edit.bin"), "", Color.WHITE, null, false, false, Color.WHITE, true, new Point(idSize + nameSize + typeSize + supplierSize + remainSize + (optionSize-60)/2, 5), new Dimension(30, 30), MedicineRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		CustomButton delete = new CustomButton(new ImageIcon("src/GUI/Resources/delete.bin"), "", Color.WHITE, null, false, false, Color.WHITE, true, new Point(idSize + nameSize + typeSize + supplierSize + remainSize + (optionSize-60)/2 + 25, 5), new Dimension(30, 30), MedicineRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		
	}
}
