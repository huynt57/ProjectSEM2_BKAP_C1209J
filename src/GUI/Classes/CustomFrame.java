package GUI.Classes;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CustomFrame extends JFrame {
	public static Dimension dimension = new Dimension();
	public static Point pos = new Point();
	public CustomFrame(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension) {
		super(title);
		setUndecorated(undecorate);
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-dimension.width)/2,(screenSize.height- dimension.height)/2, dimension.width, dimension.height);
		pos.x = (screenSize.width-dimension.width)/2;
		pos.y = (screenSize.height-dimension.height)/2;
		setVisible(visible);
		this.dimension = dimension;
		setResizable(resizeable);
		setSize(new java.awt.Dimension(dimension.width, CustomFrame.dimension.height));
		setPreferredSize(new java.awt.Dimension(dimension.width, CustomFrame.dimension.height));
	}
}
