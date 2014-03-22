package GUI.SupplierManager;

import GUI.CustomersManager.*;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierRow extends JPanel {
        public static boolean white = true;
	public SupplierRow(String id, String name, String email, String address, String phone, int idSize, int nameSize, int emailSize, int addressSize, int phoneSize, int optionSize, Point pos, JPanel parentPanel) {
		super();
		setLayout(null);
		Color BackGround = null;
		if(white) BackGround = Color.WHITE;
                else BackGround = Color.getHSBColor(20, 12, 21);
                setBackground(BackGround);
                white = !white;
		setBounds(pos.x, pos.y, idSize + nameSize + emailSize + addressSize + phoneSize + optionSize, 40);
		CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel nameLabel = new CustomLabel(name, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(nameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel emailLabel = new CustomLabel(email, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + nameSize, pos.y), new Dimension(emailSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel addressLabel = new CustomLabel(address, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + emailSize + nameSize, pos.y), new Dimension(addressSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel phoneLabel = new CustomLabel(phone, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + emailSize + addressSize + nameSize, pos.y), new Dimension(phoneSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + nameSize + emailSize + addressSize + phoneSize + optionSize , 1), parentPanel);
		
		CustomButton details = new CustomButton(new ImageIcon("src/GUI/Resources/details.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + emailSize + addressSize + phoneSize + (optionSize-80)/2, 5), new Dimension(20, 30), SupplierRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		details.setRolloverIcon(new ImageIcon("src/GUI/Resources/detailsRollover.bin"));
		details.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                    }
                });
                CustomButton edit = new CustomButton(new ImageIcon("src/GUI/Resources/edit.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + emailSize + addressSize + phoneSize + (optionSize-80)/2 + 25, 5), new Dimension(20, 30), SupplierRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		edit.setRolloverIcon(new ImageIcon("src/GUI/Resources/editRollover.bin"));
		edit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                CustomButton delete = new CustomButton(new ImageIcon("src/GUI/Resources/delete.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + emailSize + addressSize + phoneSize + (optionSize-80)/2 + 48, 5), new Dimension(20, 30), SupplierRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		delete.setRolloverIcon(new ImageIcon("src/GUI/Resources/deleteRollover.bin"));
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
        }
}
