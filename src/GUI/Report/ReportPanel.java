package GUI.Report;

import GUI.CustomersManager.*;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.Vector;

public class ReportPanel extends JPanel {

    public ReportPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("Reports manager",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, ReportPanel.this);


    }
}
