package GUI.MeasureManager;

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

public class MeasurePanel extends JPanel {

    public MeasurePanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("Measures manager",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, MeasurePanel.this);

        CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), MeasurePanel.this, SwingConstants.LEFT, SwingConstants.CENTER);

        HintTextField search = new HintTextField(" Search measures", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), MeasurePanel.this, false);
        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), MeasurePanel.this, SwingConstants.CENTER, SwingConstants.CENTER);

        int totalWidth = d.width - 180;
        final int nameSize = totalWidth / 2;
        final int idSize = totalWidth / 2;
        final int optionSize = 109;
        Color BACK_GROUND = Color.GRAY;

        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), MeasurePanel.this);
        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), MeasurePanel.this);
        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(optionSize, 30), MeasurePanel.this);

        final CustomTable table = new CustomTable(new Point(40, 150), new Dimension(d.width - 40, d.height - 40), MeasurePanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);

        Vector<Measures> loadMeasure = Measures.getAllMeasure();
        final ArrayList<MeasurePanel.Measure> measures = new ArrayList<MeasurePanel.Measure>();
        for (int i = 0; i < loadMeasure.size(); i++) {
            measures.add(new Measure(loadMeasure.get(i).getMeasureCode() + "", loadMeasure.get(i).getMeasureName()));
        }
        table.setPreferredSize(new Dimension(1000, measures.size() * 40));
        for (int i = 0; i < measures.size(); i++) {
            table.add(new MeasureRow(measures.get(i).id, measures.get(i).name, idSize, nameSize, optionSize, new Point(0, i * 40), table));
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
                MeasureRow.white = true;
                for (int i = 0; i < measures.size(); i++) {
                    table.add(new MeasureRow(measures.get(i).id, measures.get(i).name, idSize, nameSize, optionSize, new Point(0, i * 40), table));
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
                MeasureRow.white = true;
                for (int i = 0; i < measures.size(); i++) {
                    table.add(new MeasureRow(measures.get(i).id, measures.get(i).name, idSize, nameSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });
    }

    public static boolean nameSort = true;

    public void swap(ArrayList<MeasurePanel.Measure> measures, int i, int j) {
        MeasurePanel.Measure temp = new MeasurePanel.Measure(measures.get(i).id, measures.get(i).name);
        measures.get(i).id = measures.get(j).id;
        measures.get(i).name = measures.get(j).name;
    }

    public class Measure {

        String id;
        String name;

        public Measure(String id, String name) {
            this.id = id;
            this.name = name;

        }
    }
}
