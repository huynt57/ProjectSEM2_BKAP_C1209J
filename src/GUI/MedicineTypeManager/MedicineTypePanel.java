package GUI.MedicineTypeManager;

import GUI.MeasureManager.*;
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
import GUI.MedicinesManager.MedicineRow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.Vector;

public class MedicineTypePanel extends JPanel {

    public MedicineTypePanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("Medicine types manager",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, MedicineTypePanel.this);

        CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), MedicineTypePanel.this, SwingConstants.LEFT, SwingConstants.CENTER);

        HintTextField search = new HintTextField(" Search medicine types", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), MedicineTypePanel.this, false);
CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), MedicineTypePanel.this, SwingConstants.CENTER, SwingConstants.CENTER);

        int totalWidth = d.width - 180;
        final int nameSize = totalWidth / 2;
        final int idSize = totalWidth / 2;
        final int optionSize = 109;
        Color BACK_GROUND = Color.GRAY;

        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), MedicineTypePanel.this);
        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), MedicineTypePanel.this);
        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(optionSize, 30), MedicineTypePanel.this);

        final CustomTable table = new CustomTable(new Point(40, 150), new Dimension(d.width - 40, d.height - 40), MedicineTypePanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);

//        Vector<Customers> loadMedicineTypes;
        final ArrayList<MedicineTypePanel.MedicineType> measures = new ArrayList<MedicineTypePanel.MedicineType>();
//        for (int i = 0; i < loadMedicineType.size(); i++) {
//            measures.add(new MedicineType(loadMedicineType.get(i).getMedicineTypeCode() + "", loadMedicineType.get(i).getMedicineTypeName(), loadMedicineType.get(i).getMedicineTypeType() + "", loadMedicineType.get(i).getMedicineTypeAddress(), loadMedicineType.get(i).getMedicineTypePhone()));
//        }
        table.setPreferredSize(new Dimension(1000, measures.size() * 40));
        for (int i = 0; i < measures.size(); i++) {
            table.add(new MedicineTypeRow(measures.get(i).id, measures.get(i).name, idSize, nameSize, optionSize, new Point(0, i * 40), table));
        }
        table.setPreferredSize(new Dimension(1000, measures.size() * 40));

        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < measures.size() - 1; i++) {
                    for (int j = i + 1; j < measures.size(); j++) {
                        if (nameSort) {
                            if (measures.get(i).name.compareTo(measures.get(j).name) < 0) {
                                swap(measures, i, j);
                            }
                        } else {
                            if (measures.get(i).name.compareTo(measures.get(j).name) > 0) {
                                swap(measures, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                MedicineTypeRow.white = true;
                for (int i = 0; i < measures.size(); i++) {
                    table.add(new MedicineTypeRow(measures.get(i).id, measures.get(i).name, idSize, nameSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < measures.size() - 1; i++) {
                    for (int j = i + 1; j < measures.size(); j++) {
                        if (nameSort) {
                            if (measures.get(i).id.compareTo(measures.get(j).id) < 0) {
                                swap(measures, i, j);
                            }
                        } else {
                            if (measures.get(i).id.compareTo(measures.get(j).id) > 0) {
                                swap(measures, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                MedicineTypeRow.white = true;
                for (int i = 0; i < measures.size(); i++) {
                    table.add(new MedicineTypeRow(measures.get(i).id, measures.get(i).name, idSize, nameSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });
    }

    public static boolean nameSort = true;

    public void swap(ArrayList<MedicineTypePanel.MedicineType> measures, int i, int j) {
        MedicineTypePanel.MedicineType temp = new MedicineTypePanel.MedicineType(measures.get(i).id, measures.get(i).name);
        measures.get(i).id = measures.get(j).id;
        measures.get(i).name = measures.get(j).name;
    }

    public class MedicineType {

        String id;
        String name;

        public MedicineType(String id, String name) {
            this.id = id;
            this.name = name;

        }
    }
}
