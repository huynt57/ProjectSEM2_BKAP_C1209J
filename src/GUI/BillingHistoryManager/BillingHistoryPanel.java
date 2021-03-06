package GUI.BillingHistoryManager;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomTable;
import GUI.Classes.HintTextField;
import GUI.CustomersManager.CustomersPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingHistoryPanel extends JPanel {
	public BillingHistoryPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
		super();
		this.setBounds(pos.x, pos.y, d.width, d.height);
		setLayout(null);
		parentPanel.add(this);

		CustomLabel titleLabel = new CustomLabel("Bills",
                            Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                            CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                            new Point(40, 20), new Dimension(d.width, 40), true,
                            SwingConstants.LEFT, SwingConstants.CENTER, BillingHistoryPanel.this);

		CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), BillingHistoryPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                         BillingNew addOrder = null;
                        try {
                            addOrder = new BillingNew("", false, false, false, new Dimension(400, 420));
                        } catch (SQLException ex) {
                            Logger.getLogger(BillingHistoryPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(BillingHistoryPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         addOrder.setVisible(true);
                    }
                });
		HintTextField search = new HintTextField(" Search bill", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width-280, 80), new Dimension(200, 30), BillingHistoryPanel.this, false);
                CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), BillingHistoryPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);
        
		int totalWidth = d.width - 250;
		int nameSize = totalWidth / 4;
		int typeSize = totalWidth / 6;
		int addressSize = totalWidth / 4;
		int priceSize = totalWidth / 6;
                int statusSize = totalWidth / 6;
		int idSize = 50;
		int optionSize = 131;
		Color BACK_GROUND = Color.GRAY; 

                CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), BillingHistoryPanel.this);
		CustomButton name = new CustomButton("Customer", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30),BillingHistoryPanel.this);
		CustomButton type = new CustomButton("Type", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize +idSize, 120), new Dimension(typeSize, 30), BillingHistoryPanel.this);
		CustomButton address = new CustomButton("Address", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + idSize, 120), new Dimension(addressSize, 30), BillingHistoryPanel.this);
		CustomButton price = new CustomButton("Price", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + idSize, 120), new Dimension(priceSize, 30), BillingHistoryPanel.this);
                CustomButton status = new CustomButton("Status", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + idSize + priceSize, 120), new Dimension(priceSize, 30), BillingHistoryPanel.this);
		CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + priceSize + idSize + statusSize, 120), new Dimension(optionSize, 30),BillingHistoryPanel.this);

		CustomTable table = new CustomTable(new Point(40, 180), new Dimension(d.width-40, d.height-40), BillingHistoryPanel.this);
		JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		x.setBounds(40, 150, d.width - 70, d.height-170);
		this.add(x);
                
                /////////////////////
                /// GET DATA
                 Vector<Bills> loadbill =  Bills.getAllBill();
                ArrayList<BillingHistoryPanel.Billing> billing = new ArrayList<BillingHistoryPanel.Billing>();
		for(int i=0; i<50; i++) billing.add(new BillingHistoryPanel.Billing("" + i, "Name " + i, "Type " + i, "Address " + i, "Price " + i, "Status" + i));
		table.setPreferredSize(new Dimension(1000, billing.size() * 40));
		for(int i=0; i<loadbill.size(); i++)
		table.add(new BillingRow(loadbill.get(i).getbillCode()+"", loadbill.get(i).getcustomerCode()+"", loadbill.get(i).getbillType(), loadbill.get(i).getaddressToDeliver(), loadbill.get(i).getprice()+"", loadbill.get(i).getstatus(), idSize, nameSize, typeSize, addressSize, priceSize, statusSize, optionSize, new Point(0, i * 40), table));
                /////////////////////////////////////////
	}
        public class Billing {
		String id;
		String name;
		String type;
		String address;
		String price;
                String status;
		public Billing(String id, String name, String type, String address, String price, String status) {
			this.id = id;
			this.name = name;
			this.type = type;
			this.address = address;
			this.price = price;
                        this.status = status;
		}
	}
}