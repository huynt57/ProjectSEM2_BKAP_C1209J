package GUI.CustomersManager;

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
import GUI.MedicinesManager.MedicineRow;

public class CustomerRow extends JPanel {
	public CustomerRow(String id, String name, String type, String address, String phone, int idSize, int nameSize, int typeSize, int addressSize, int phoneSize, int optionSize, Point pos, JPanel parentPanel) {
		super();
		setLayout(null);
		Color BackGround = null;
		if(Integer.parseInt(id) % 2 == 1) BackGround = Color.WHITE;
                else BackGround = Color.getHSBColor(20, 12, 21);
                setBackground(BackGround);
		setBounds(pos.x, pos.y, idSize + nameSize + typeSize + addressSize + phoneSize + optionSize, 40);
		CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel nameLabel = new CustomLabel(name, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(nameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel typeLabel = new CustomLabel(type, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + nameSize, pos.y), new Dimension(typeSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel addressLabel = new CustomLabel(address, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + typeSize + nameSize, pos.y), new Dimension(addressSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel ramainLabel = new CustomLabel(phone, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + typeSize + addressSize + nameSize, pos.y), new Dimension(phoneSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + nameSize + typeSize + addressSize + phoneSize + optionSize , 1), parentPanel);
		
		CustomButton details = new CustomButton(new ImageIcon("src/GUI/Resources/details.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + addressSize + phoneSize + (optionSize-80)/2, 5), new Dimension(20, 30), CustomerRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		details.setRolloverIcon(new ImageIcon("src/GUI/Resources/detailsRollover.bin"));
		CustomButton edit = new CustomButton(new ImageIcon("src/GUI/Resources/edit.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + addressSize + phoneSize + (optionSize-80)/2 + 25, 5), new Dimension(20, 30), CustomerRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		edit.setRolloverIcon(new ImageIcon("src/GUI/Resources/editRollover.bin"));
		CustomButton delete = new CustomButton(new ImageIcon("src/GUI/Resources/delete.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + addressSize + phoneSize + (optionSize-80)/2 + 48, 5), new Dimension(20, 30), CustomerRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		delete.setRolloverIcon(new ImageIcon("src/GUI/Resources/deleteRollover.bin"));
	}
}
