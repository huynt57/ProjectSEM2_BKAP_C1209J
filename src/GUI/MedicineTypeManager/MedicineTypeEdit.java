

package GUI.MedicineTypeManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.HintTextField;
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
import javax.swing.SwingConstants;

public class MedicineTypeEdit extends CustomFrame {

    public MedicineTypeEdit(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension, final String id) {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel("Edit medicine type",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 19),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        Dimension dim = dimension;
        final HintTextField name = new HintTextField(" Name", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 60), new Dimension(dim.width - 40, 30), contenPane, false);
        final CustomButton ok = new CustomButton("Save", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 100),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                 // Add medicine type
                String namex = name.getText();
                try {
                    MedicineTypes.editMedicineType(namex, id);
                } catch (SQLException ex) {
                    Logger.getLogger(MedicineTypeEdit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicineTypeEdit.class.getName()).log(Level.SEVERE, null, ex);
                }
                MedicineTypeEdit.this.dispose();
            }
        });

        final CustomButton cancel = new CustomButton("Cancel", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 100),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MedicineTypeEdit.this.dispose();
            }
        });
    }
}
