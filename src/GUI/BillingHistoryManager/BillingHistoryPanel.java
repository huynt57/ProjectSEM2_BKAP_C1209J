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
import GUI.MedicinesManager.MedicineRow;
import GUI.MedicinesManager.MedicinesPanel;
import java.util.ArrayList;

public class BillingHistoryPanel extends JPanel {
	public BillingHistoryPanel(JPanel parentPanel, Point pos, Dimension d) {
		super();
		this.setBounds(pos.x, pos.y, d.width, d.height);
		setLayout(null);
		parentPanel.add(this);
		
		CustomLabel titleLabel = new CustomLabel("Billing History",
				Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
				new Point(40, 20), new Dimension(d.width, 40), true,
				SwingConstants.LEFT, SwingConstants.CENTER, BillingHistoryPanel.this);
		
		CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.ORANGE, true, new Point(40, 100), new Dimension(100, 30), BillingHistoryPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.BLUE, true, new Point(150, 100), new Dimension(100, 30), BillingHistoryPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		CustomButton sort = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Sort", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(260, 100), new Dimension(100, 30), BillingHistoryPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		
		HintTextField search = new HintTextField(" Search bill", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width-280, 100), new Dimension(200, 30), BillingHistoryPanel.this, false);
		
		int totalWidth = d.width - 230;
		int nameSize = totalWidth / 4;
		int typeSize = totalWidth / 6;
		int addressSize = totalWidth / 4;
		int priceSize = totalWidth / 6;
                int statusSize = totalWidth / 6;
		int idSize = 50;
		int optionSize = 111;
		Color BACK_GROUND = Color.GRAY; 
		
		CustomTable table = new CustomTable(new Point(40, 180), new Dimension(d.width-40, d.height-40), BillingHistoryPanel.this);
		
		JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		x.setBounds(40, 180, d.width - 70, d.height-200);
		this.add(x);
                
                ArrayList<BillingHistoryPanel.Billing> billing = new ArrayList<BillingHistoryPanel.Billing>();
		for(int i=0; i<50; i++) billing.add(new BillingHistoryPanel.Billing("" + i, "Name " + i, "Type " + i, "Address " + i, "Price " + i, "Status" + i));
		
		
		table.setPreferredSize(new Dimension(1000, billing.size() * 40));
		
		for(int i=0; i<billing.size(); i++)
		table.add(new BillingRow(billing.get(i).id, billing.get(i).name, billing.get(i).type, billing.get(i).address, billing.get(i).price, billing.get(i).status, idSize, nameSize, typeSize, addressSize, priceSize, statusSize, optionSize, new Point(0, i * 40), table));
		
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
