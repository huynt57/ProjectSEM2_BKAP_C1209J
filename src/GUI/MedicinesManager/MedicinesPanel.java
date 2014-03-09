package GUI.MedicinesManager;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.ScrollPane;

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
		
		CustomTable table = new CustomTable(new Point(40, 180), new Dimension(d.width-40, d.height-40), MedicinesPanel.this);
		
		JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		x.setBounds(40, 180, d.width - 70, d.height-210);
		this.add(x);
		
	}
}
