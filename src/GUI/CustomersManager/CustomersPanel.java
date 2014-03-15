package GUI.CustomersManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

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
import GUI.MedicinesManager.MedicineRow;
import GUI.MedicinesManager.MedicinesPanel;
import GUI.MedicinesManager.MedicinesPanel.Medicine;

public class CustomersPanel extends JPanel {
	public CustomersPanel(JPanel parentPanel, Point pos, Dimension d) {
		super();
		this.setBounds(pos.x, pos.y, d.width, d.height);
		setLayout(null);
		parentPanel.add(this);
		
		CustomLabel titleLabel = new CustomLabel("Customers manager",
				Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
				new Point(40, 20), new Dimension(d.width, 40), true,
				SwingConstants.LEFT, SwingConstants.CENTER, CustomersPanel.this);
		
		CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.ORANGE, true, new Point(40, 80), new Dimension(100, 30), CustomersPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.BLUE, true, new Point(150, 80), new Dimension(100, 30), CustomersPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		CustomButton sort = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Sort", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(260, 80), new Dimension(100, 30), CustomersPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		
		HintTextField search = new HintTextField(" Search customer", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width-280, 80), new Dimension(200, 30), CustomersPanel.this, false);
		
		int totalWidth = d.width - 230;
		int nameSize = totalWidth / 3;
		int typeSize = totalWidth / 6;
		int addressSize = totalWidth / 3;
		int phoneSize = totalWidth / 6;
		int idSize = 50;
		int optionSize = 111;
		Color BACK_GROUND = Color.GRAY; 
		
		CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), CustomersPanel.this);
		CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), CustomersPanel.this);
		CustomButton type = new CustomButton("Type", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize +idSize, 120), new Dimension(typeSize, 30), CustomersPanel.this);
		CustomButton address = new CustomButton("Address", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + idSize, 120), new Dimension(addressSize, 30), CustomersPanel.this);
		CustomButton phone = new CustomButton("Phone", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + idSize, 120), new Dimension(phoneSize, 30), CustomersPanel.this);
		CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + phoneSize + idSize, 120), new Dimension(optionSize, 30),CustomersPanel.this);
		
		
		
		CustomTable table = new CustomTable(new Point(40, 150), new Dimension(d.width-40, d.height-40), CustomersPanel.this);
		JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		x.setBounds(40, 150, d.width - 70, d.height-170);
		this.add(x);
		
		ArrayList<Customer> customers = new ArrayList<CustomersPanel.Customer>();
		for(int i=0; i<50; i++) customers.add(new Customer("" + i, "Name " + i, "Type" + i, "Address" + i, "Phone" + i));
		
		
		table.setPreferredSize(new Dimension(1000, customers.size() * 40));
		
		for(int i=0; i<customers.size(); i++)
		table.add(new CustomerRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
		
	}
	public class Customer {
		String id;
		String name;
		String type;
		String address;
		String phone;
		public Customer(String id, String name, String type, String address, String phone) {
			this.id = id;
			this.name = name;
			this.type = type;
			this.address = address;
			this.phone = phone;
		}
	}
}
