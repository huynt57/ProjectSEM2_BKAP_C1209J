
package GUI.Report;

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
import static GUI.MedicinesManager.MedicineRow.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportRow extends JPanel {
        public static boolean white = true;
	public ReportRow(final String id, String customerName, String billType, String relationship, String creator, String price, String status, int idSize, int customerNameSize, int billTypeSize, int relationshipSize, int creatorSize, int priceSize, int statusSize, Point pos, JPanel parentPanel) {
		super();
		setLayout(null);
		Color BackGround = null;
		if(white) BackGround = Color.WHITE;
                else BackGround = Color.getHSBColor(20, 12, 21);
                setBackground(BackGround);
                white = !white;
		setBounds(pos.x, pos.y, idSize + customerNameSize + billTypeSize + relationshipSize + creatorSize + priceSize + statusSize, 40);
		CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel customerNameLabel = new CustomLabel(customerName, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(customerNameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel billTypeLabel = new CustomLabel(billType, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + customerNameSize, pos.y), new Dimension(billTypeSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel relationshipLabel = new CustomLabel(relationship, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + billTypeSize + customerNameSize, pos.y), new Dimension(relationshipSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel creatorLabel = new CustomLabel(creator, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + billTypeSize + relationshipSize + customerNameSize, pos.y), new Dimension(creatorSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel priceLabel = new CustomLabel(creator, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + billTypeSize + relationshipSize + customerNameSize + creatorSize, pos.y), new Dimension(creatorSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel statusLabel = new CustomLabel(creator, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + billTypeSize + relationshipSize + customerNameSize + priceSize + creatorSize, pos.y), new Dimension(creatorSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + customerNameSize + billTypeSize + relationshipSize + creatorSize + statusSize + priceSize, 1), parentPanel);
		
		
        }
}
