
package GUI.Order;

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
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;

public class OrderRow extends JPanel {

    public static boolean white = true;

    public OrderRow(final String id, String name, String price, String addressToDeliver, String overDate, int idSize, int nameSize, int priceSize, int addressToDeliverSize, int overDateSize, int optionSize, Point pos, final JPanel parentPanel) {
        super();
        setLayout(null);
        Color BackGround = null;
        if (white) {
            BackGround = Color.WHITE;
        } else {
            BackGround = Color.getHSBColor(20, 12, 21);
        }
        setBackground(BackGround);
        white = !white;
        setBounds(pos.x, pos.y, idSize + nameSize + priceSize + addressToDeliverSize + overDateSize + optionSize, 40);
        CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel nameLabel = new CustomLabel(name, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(nameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel priceLabel = new CustomLabel(price, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + nameSize, pos.y), new Dimension(priceSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel addressToDeliverLabel = new CustomLabel(addressToDeliver, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + priceSize + nameSize, pos.y), new Dimension(addressToDeliverSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel ramainLabel = new CustomLabel(overDate, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + priceSize + addressToDeliverSize + nameSize, pos.y), new Dimension(overDateSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + nameSize + priceSize + addressToDeliverSize + overDateSize + optionSize, 1), parentPanel);

        CustomButton details = new CustomButton(new ImageIcon("src/GUI/Resources/details.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + priceSize + addressToDeliverSize + overDateSize + (optionSize - 80) / 2, 5), new Dimension(20, 30), OrderRow.this, SwingConstants.CENTER, SwingConstants.CENTER);
        details.setRolloverIcon(new ImageIcon("src/GUI/Resources/detailsRollover.bin"));
        details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderDetails addOrders = new OrderDetails("", false, false, false, new Dimension(400, 500));
                addOrders.setVisible(true);
            }
        });
        CustomButton edit = new CustomButton(new ImageIcon("src/GUI/Resources/edit.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + priceSize + addressToDeliverSize + overDateSize + (optionSize - 80) / 2 + 25, 5), new Dimension(20, 30), OrderRow.this, SwingConstants.CENTER, SwingConstants.CENTER);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Vector x = new Vector();
                for (int i = 1; i <= 10; i++) {
                    x.add(i);
                }
                OrderEdit editOrder = new OrderEdit("", false, false, false, new Dimension(400, 550), x, x, x);
                editOrder.setVisible(true);

            }
        });

        edit.setRolloverIcon(new ImageIcon("src/GUI/Resources/editRollover.bin"));
        CustomButton delete = new CustomButton(new ImageIcon("src/GUI/Resources/delete.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + priceSize + addressToDeliverSize + overDateSize + (optionSize - 80) / 2 + 48, 5), new Dimension(20, 30), OrderRow.this, SwingConstants.CENTER, SwingConstants.CENTER);
        delete.setRolloverIcon(new ImageIcon("src/GUI/Resources/deleteRollover.bin"));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderDialog dialog = new OrderDialog("Are you sure ?", true, true, false, new Dimension(200, 100), id );
            }
        });
    }
}
