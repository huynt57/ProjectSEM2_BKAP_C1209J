package GUI.MedicinesManager;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import GUI.AccountManager.AccountPanel;
import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomTable;
import GUI.Classes.CustomTextField;
import GUI.Classes.HintTextField;
import GUI.Classes.RemovablePanel;

public class MedicinesPanel extends JPanel {
	public MedicinesPanel(JPanel parentPanel, Point pos, Dimension d) {
		super();
		this.setBounds(pos.x, pos.y, d.width, d.height);
		setLayout(null);
		parentPanel.add(this);
		
		CustomLabel titleLabel = new CustomLabel("Medicines manager",
				Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
				new Point(40, 20), new Dimension(d.width, 40), true,
				SwingConstants.LEFT, SwingConstants.CENTER, MedicinesPanel.this);
		
		CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.ORANGE, true, new Point(40, 100), new Dimension(100, 30), MedicinesPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.BLUE, true, new Point(150, 100), new Dimension(100, 30), MedicinesPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		CustomButton sort = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Sort", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(260, 100), new Dimension(100, 30), MedicinesPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
		
		HintTextField search = new HintTextField(" Search medicine", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width-280, 100), new Dimension(200, 30), MedicinesPanel.this, false);
		
		int totalWidth = d.width - 230;
		int nameSize = totalWidth / 3;
		int typeSize = totalWidth / 6;
		int supplierSize = totalWidth / 3;
		int remainSize = totalWidth / 6;
		int idSize = 50;
		int optionSize = 111;
		Color BACK_GROUND = Color.GRAY; 
		
		CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 150), new Dimension(idSize, 30), MedicinesPanel.this);
		CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 150), new Dimension(nameSize, 30), MedicinesPanel.this);
		CustomButton type = new CustomButton("Type", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize +idSize, 150), new Dimension(typeSize, 30), MedicinesPanel.this);
		CustomButton supplier = new CustomButton("Supplier", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + idSize, 150), new Dimension(supplierSize, 30), MedicinesPanel.this);
		CustomButton remain = new CustomButton("Remain", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + supplierSize + idSize, 150), new Dimension(remainSize, 30), MedicinesPanel.this);
		CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + supplierSize + remainSize + idSize, 150), new Dimension(optionSize, 30), MedicinesPanel.this);
		
		CustomTable table = new CustomTable(new Point(40, 180), new Dimension(d.width-40, d.height-40), MedicinesPanel.this);
		JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		x.setBounds(40, 180, d.width - 70, d.height-200);
		this.add(x);
		
		
		
		ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
		for(int i=0; i<50; i++) medicines.add(new Medicine("id " + i, "Name " + i, "Type" + i, "Supplier" + i, "Remain" + i));
		
		
		table.setPreferredSize(new Dimension(1000, medicines.size() * 40));
		
		for(int i=0; i<medicines.size(); i++)
		table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).id, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
		
	}
	public class Medicine {
		String id;
		String name;
		String type;
		String supplier;
		String remain;
		public Medicine(String id, String name, String type, String supplier, String remain) {
			this.id = id;
			this.name = name;
			this.type = type;
			this.supplier = supplier;
			this.remain = remain;
		}
	}
}
