package GUI.Classes;

import GUI.MedicinesManager.MedicineNew;
import GUI.MedicinesManager.Medicines;
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

public class MedicineDialog extends CustomFrame {

    public MedicineDialog(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dim, final String id) {
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
                try {
                    Medicines.DeleteMedicine(id);
                } catch (SQLException ex) {
                    Logger.getLogger(MedicineDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicineDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                MedicineDialog.this.dispose();
            }
        });
        final CustomButton cancel = new CustomButton("No", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 50),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MedicineDialog.this.dispose();
            }
        });
        
    }

}
