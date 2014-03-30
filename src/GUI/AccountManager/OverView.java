package GUI.AccountManager;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import GUI.Classes.Configure;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OverView extends JPanel {
	public OverView(Point pos, Dimension d, JPanel parentPanel) {
		super();
		this.setBounds(pos.x, pos.y, d.width, d.height);
		setBackground(Configure.DEFAULT_RIGHT_PANEL_COLOR);
		setLayout(null);
		parentPanel.add(this);
                
        int begin = 0;
        int marginLeft = 80;
        int step = 40;
        int i = 1;
                
        CustomLabel userIdLabel = new CustomLabel("User id",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel usernameLabel = new CustomLabel("Username",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel passwordLabel = new CustomLabel("Password",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel fullNumberLabel = new CustomLabel("Full name",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel typeLabel = new CustomLabel("Type",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel activeLabel = new CustomLabel("Active",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
              new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
          CustomLabel phoneLabel = new CustomLabel("Phone",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
               new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel emailLabel = new CustomLabel("Email",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel addressLabel = new CustomLabel("Address",
               Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
               new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
                      
	}

}
