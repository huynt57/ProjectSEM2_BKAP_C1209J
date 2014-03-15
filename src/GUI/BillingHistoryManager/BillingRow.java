
package GUI.BillingHistoryManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.MedicinesManager.MedicineRow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//int totalWidth = d.width - 230;
//		int nameSize = totalWidth / 4;
//		int typeSize = totalWidth / 6;
//		int addressSize = totalWidth / 4;
//		int priceSize = totalWidth / 6;
//                int statusSize = totalWidth / 6;
//		int idSize = 50;
//		int optionSize = 111;

public class BillingRow extends JPanel {
    public BillingRow(String id, String name, String type, String address, String price, String status, int idSize, int nameSize, int typeSize, int addressSize, int priceSize, int statusSize, int optionSize, Point pos, JPanel parentPanel) {
		super();
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(pos.x, pos.y, idSize + nameSize + typeSize + addressSize + priceSize + optionSize, 40);
		CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel nameLabel = new CustomLabel(name, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(nameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel typeLabel = new CustomLabel(type, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + nameSize, pos.y), new Dimension(typeSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel addressLabel = new CustomLabel(address, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + typeSize + nameSize, pos.y), new Dimension(addressSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel priceLabel = new CustomLabel(price, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + typeSize + addressSize + nameSize, pos.y), new Dimension(priceSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
                CustomLabel statusLabel = new CustomLabel(price, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + typeSize + addressSize + nameSize + priceSize, pos.y), new Dimension(statusSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + nameSize + typeSize + addressSize + priceSize + optionSize , 1), parentPanel);
		
		CustomButton details = new CustomButton(new ImageIcon("src/GUI/Resources/details.bin"), "", Color.WHITE, null, false, false, Color.WHITE, true, new Point(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + (optionSize-80)/2, 5), new Dimension(20, 30), BillingRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		details.setRolloverIcon(new ImageIcon("src/GUI/Resources/detailsRollover.bin"));
		CustomButton edit = new CustomButton(new ImageIcon("src/GUI/Resources/edit.bin"), "", Color.WHITE, null, false, false, Color.WHITE, true, new Point(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + (optionSize-80)/2 + 25, 5), new Dimension(20, 30), BillingRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		edit.setRolloverIcon(new ImageIcon("src/GUI/Resources/editRollover.bin"));
		CustomButton delete = new CustomButton(new ImageIcon("src/GUI/Resources/delete.bin"), "", Color.WHITE, null, false, false, Color.WHITE, true, new Point(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + (optionSize-80)/2 + 48, 5), new Dimension(20, 30), BillingRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		delete.setRolloverIcon(new ImageIcon("src/GUI/Resources/deleteRollover.bin"));
	}
}
