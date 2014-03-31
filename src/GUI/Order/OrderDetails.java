package GUI.Order;

import GUI.AccountManager.AccountPanel;
import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomComboBox;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.HintTextField;
import GUI.Classes.RemovablePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class OrderDetails extends CustomFrame {

    public OrderDetails(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension, String id) throws SQLException, ClassNotFoundException {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel("Order details",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        Dimension dim = dimension;

        CustomLabel nameLabel = new CustomLabel("Name",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 70), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel dateOrder = new CustomLabel("Price",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 110), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel addressToDeliver = new CustomLabel("Used",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 190), new Dimension(100, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel price = new CustomLabel("Register number",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(205, 150), new Dimension((dim.width - 40) / 2 - 5, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel quantity = new CustomLabel("Number",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 150), new Dimension((dim.width - 40) / 2 - 5, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel medinices = new CustomLabel("Term of use",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(205, 110), new Dimension((dim.width - 40) / 2 - 5, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel measures = new CustomLabel("Supplier",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 230), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel customers = new CustomLabel("Measure",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 270), new Dimension(100, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel relationship = new CustomLabel("Type",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 310), new Dimension(100, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

//        supplierLabel.setText("Supplier: " + xxx);
        Orders ordertemp = Orders.getOrderbyId(id);

        nameLabel.setText("Customer code: " + ordertemp.getcustomerCode() + "");
        dateOrder.setText("Date order: " + ordertemp.getdateOrder());
        addressToDeliver.setText("Address: " + ordertemp.getaddressToDeliver());
        price.setText("Price: " + ordertemp.getpriceOrder() + "");
        quantity.setText("Quantity: " + ordertemp.getquantity() + "");
        medinices.setText("Medicine code: " + ordertemp.getmedicineCode() + "");
        measures.setText("Measure code: " + ordertemp.getmeasureCode() + "");
        customers.setText("Customer code: " + ordertemp.getcustomerCode() + "");
        relationship.setText("Relationship: familiar");

        final CustomButton ok = new CustomButton("OK", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 450),
                new Dimension(100, 30), contenPane);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                OrderDetails.this.dispose();
            }
        });

    }

}
