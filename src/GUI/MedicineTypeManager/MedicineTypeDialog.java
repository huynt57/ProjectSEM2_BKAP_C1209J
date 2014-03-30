
package GUI.MedicineTypeManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.RemovablePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MedicineTypeDialog extends CustomFrame {

    public MedicineTypeDialog(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dim, final String id) {
        super(title, visible, undecorate, resizeable, dim);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.GRAY;
        contenPane.setBackground(Color.getHSBColor(20, 12, 21));
        this.setContentPane(contenPane);
        setLocationRelativeTo(null);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel(title,
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 10), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final CustomButton ok = new CustomButton("Yes", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 50),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        ok.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                //
                
                MedicineTypeDialog.this.dispose();
            }
        });
        final CustomButton cancel = new CustomButton("No", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 50),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MedicineTypeDialog.this.dispose();
            }
        });
        
    }

}
