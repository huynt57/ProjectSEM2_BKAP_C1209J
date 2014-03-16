
package GUI.Classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CustomComboBox extends JComboBox {
    public CustomComboBox(Vector x, Font font, Point pos, Dimension dimendion, JPanel parentPane) {
        super(x);
        setFont(font);
        setBounds(pos.x, pos.y, dimendion.width, dimendion.height);
        setBackground(Color.WHITE);
        parentPane.add(this);
    }

  
}
