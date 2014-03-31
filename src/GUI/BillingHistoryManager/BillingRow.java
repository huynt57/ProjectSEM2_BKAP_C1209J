package GUI.BillingHistoryManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BillingRow extends JPanel {
    public BillingRow(final String id, String name, String type, String address, String price, String status, int idSize, int nameSize, int typeSize, int addressSize, int priceSize, int statusSize, int optionSize, Point pos, JPanel parentPanel) {
		super();
		setLayout(null);
		Color BackGround = null;
		if(Integer.parseInt(id) % 2 == 1) BackGround = Color.WHITE;
                else BackGround = Color.getHSBColor(20, 12, 21);
                setBackground(BackGround);
		setBounds(pos.x, pos.y, idSize + nameSize + typeSize + addressSize + priceSize + statusSize + optionSize, 40);
		CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel nameLabel = new CustomLabel(name, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(nameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel typeLabel = new CustomLabel(type, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + nameSize, pos.y), new Dimension(typeSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel addressLabel = new CustomLabel(address, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + typeSize + nameSize, pos.y), new Dimension(addressSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomLabel priceLabel = new CustomLabel(price, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + typeSize + addressSize + nameSize, pos.y), new Dimension(priceSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
                CustomLabel statusLabel = new CustomLabel(status, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x +idSize + typeSize + addressSize + nameSize + priceSize, pos.y), new Dimension(statusSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
		CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + optionSize , 1), parentPanel);
                CustomButton pay = new CustomButton(new ImageIcon("src/GUI/Resources/pay.png"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + (optionSize-80)/2 + 53, 5), new Dimension(20, 30), BillingRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		pay.setRolloverIcon(new ImageIcon("src/GUI/Resources/pay_rollover.png"));
		CustomButton details = new CustomButton(new ImageIcon("src/GUI/Resources/details.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + (optionSize-80)/2 - 20 , 5), new Dimension(20, 30), BillingRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		details.setRolloverIcon(new ImageIcon("src/GUI/Resources/detailsRollover.bin"));
		CustomButton edit = new CustomButton(new ImageIcon("src/GUI/Resources/edit.bin"), "", Color.WHITE, null, false, false,BackGround, true, new Point(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + (optionSize-80)/2 + 5, 5), new Dimension(20, 30), BillingRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		edit.setRolloverIcon(new ImageIcon("src/GUI/Resources/editRollover.bin"));
		CustomButton delete = new CustomButton(new ImageIcon("src/GUI/Resources/delete.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + addressSize + priceSize + statusSize + (optionSize-80)/2 + 30, 5), new Dimension(20, 30), BillingRow.this,SwingConstants.CENTER, SwingConstants.CENTER);
		delete.setRolloverIcon(new ImageIcon("src/GUI/Resources/deleteRollover.bin"));
	
                 details.setRolloverIcon(new ImageIcon("src/GUI/Resources/detailsRollover.bin"));
        details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillingDetails addBillings = new BillingDetails("", false, false, false, new Dimension(400, 500));
                addBillings.setVisible(true);
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillingEdit editBilling = null;
                try {
                    editBilling = new BillingEdit("", false, false, false, new Dimension(400, 420));
                } catch (SQLException ex) {
                    Logger.getLogger(BillingRow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BillingRow.class.getName()).log(Level.SEVERE, null, ex);
                }
                editBilling.setVisible(true);
            }
        });
        
        edit.setRolloverIcon(new ImageIcon("src/GUI/Resources/editRollover.bin"));
        delete.setRolloverIcon(new ImageIcon("src/GUI/Resources/deleteRollover.bin"));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillingDialog dialog = new BillingDialog("Are you sure ?", true, true, false, new Dimension(200, 100), id );
            }
        });
        
        pay.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        BillPay editBilling = new BillPay("", false, false, false, new Dimension(400, 300));
                        editBilling.setVisible(true);
                    }
                });
    }
}