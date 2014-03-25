package GUI.MedicinesManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.MedicineDialog;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;

public class MedicineRow extends JPanel {

    public static boolean white = true;

    public MedicineRow(final String id, String name, String type, String supplier, String remain, int idSize, int nameSize, int typeSize, int supplierSize, int remainSize, int optionSize, Point pos, final JPanel parentPanel) {
        super();
        setLayout(null);
        Color BackGround = null;
        if (white) {
            BackGround = Color.WHITE;
        } else {
            BackGround = Color.getHSBColor(20, 12, 21);
        }
        setBackground(BackGround);
        white = !white;
        setBounds(pos.x, pos.y, idSize + nameSize + typeSize + supplierSize + remainSize + optionSize, 40);
        CustomLabel idLabel = new CustomLabel(id, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x, pos.y), new Dimension(idSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel nameLabel = new CustomLabel(name, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize, pos.y), new Dimension(nameSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel typeLabel = new CustomLabel(type, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + nameSize, pos.y), new Dimension(typeSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel supplierLabel = new CustomLabel(supplier, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + typeSize + nameSize, pos.y), new Dimension(supplierSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomLabel ramainLabel = new CustomLabel(remain, Color.GRAY, Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(pos.x + idSize + typeSize + supplierSize + nameSize, pos.y), new Dimension(remainSize, 40), true, SwingConstants.CENTER, SwingConstants.CENTER, parentPanel);
        CustomButton devider = new CustomButton("", Color.WHITE, null, false, false, Color.LIGHT_GRAY, true, new Point(pos.x, pos.y + 39), new Dimension(idSize + nameSize + typeSize + supplierSize + remainSize + optionSize, 1), parentPanel);

        CustomButton details = new CustomButton(new ImageIcon("src/GUI/Resources/details.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + supplierSize + remainSize + (optionSize - 80) / 2, 5), new Dimension(20, 30), MedicineRow.this, SwingConstants.CENTER, SwingConstants.CENTER);
        details.setRolloverIcon(new ImageIcon("src/GUI/Resources/detailsRollover.bin"));
        details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicineDetails addMedicines = new MedicineDetails("", false, false, false, new Dimension(400, 500));
                addMedicines.setVisible(true);
            }
        });
        CustomButton edit = new CustomButton(new ImageIcon("src/GUI/Resources/edit.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + supplierSize + remainSize + (optionSize - 80) / 2 + 25, 5), new Dimension(20, 30), MedicineRow.this, SwingConstants.CENTER, SwingConstants.CENTER);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Vector x = new Vector();
                for (int i = 1; i <= 10; i++) {
                    x.add(i);
                }
                MedicineEdit editMedicine = new MedicineEdit("", false, false, false, new Dimension(400, 550), x, x, x);
                editMedicine.setVisible(true);

            }
        });

        edit.setRolloverIcon(new ImageIcon("src/GUI/Resources/editRollover.bin"));
        CustomButton delete = new CustomButton(new ImageIcon("src/GUI/Resources/delete.bin"), "", Color.WHITE, null, false, false, BackGround, true, new Point(idSize + nameSize + typeSize + supplierSize + remainSize + (optionSize - 80) / 2 + 48, 5), new Dimension(20, 30), MedicineRow.this, SwingConstants.CENTER, SwingConstants.CENTER);
        delete.setRolloverIcon(new ImageIcon("src/GUI/Resources/deleteRollover.bin"));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicineDialog dialog = new MedicineDialog("Are you sure ?", true, true, false, new Dimension(200, 100), id );
            }
        });
    }
}
