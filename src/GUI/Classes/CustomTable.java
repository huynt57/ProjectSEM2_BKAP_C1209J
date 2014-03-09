package GUI.Classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CustomTable extends JPanel {
	public Point pos;
	public Dimension dim;
	public CustomTable(Point pos, Dimension dim, JPanel parentPane) {
		super();
		this.pos = pos;
		this.dim = dim;
		setBounds(pos.x, pos.y, dim.width, dim.height);
		parentPane.add(this);
		setPreferredSize(new Dimension(dim.width, 1000));
		
//		JScrollPane scroll = new JScrollPane(CustomTable.this);
		
		setBackground(Color.WHITE);
	}
}
