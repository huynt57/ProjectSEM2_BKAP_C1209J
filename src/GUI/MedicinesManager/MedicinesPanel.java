package GUI.MedicinesManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import GUI.AccountManager.AccountPanel;
import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomTable;
import GUI.Classes.CustomTextField;
import GUI.Classes.HintTextField;
import GUI.Classes.RemovablePanel;
import com.sun.jndi.toolkit.dir.SearchFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicinesPanel extends JPanel {

    public MedicinesPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();

        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("Medicines manager",Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),new Point(40, 20), new Dimension(d.width, 40), true,SwingConstants.LEFT, SwingConstants.CENTER, MedicinesPanel.this);
        CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), MedicinesPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(130, 80), new Dimension(100, 30), MedicinesPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MedicinesPanel.this.setEnabled(false);
                MedicineNew addMedicines = null;
                try {
                    addMedicines = new MedicineNew("", false, false, false, new Dimension(400, 550));
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                addMedicines.setVisible(true);
            }
        });

        final HintTextField search = new HintTextField(" Search Medicines", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), MedicinesPanel.this, false);
        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), MedicinesPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);
        

        
        int totalWidth = d.width - 230;
        final int nameSize = totalWidth / 3;
        final int typeSize = totalWidth / 6;
        final int supplierSize = totalWidth / 3;
        final int remainSize = totalWidth / 6;
        final int idSize = 50;
        final int optionSize = 111;
        Color BACK_GROUND = Color.GRAY;

        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), MedicinesPanel.this);
        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), MedicinesPanel.this);
        CustomButton type = new CustomButton("Type", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(typeSize, 30), MedicinesPanel.this);
        CustomButton supplier = new CustomButton("Supplier", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + idSize, 120), new Dimension(supplierSize, 30), MedicinesPanel.this);
        CustomButton remain = new CustomButton("Remain", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + supplierSize + idSize, 120), new Dimension(remainSize, 30), MedicinesPanel.this);
        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + supplierSize + remainSize + idSize, 120), new Dimension(optionSize, 30), MedicinesPanel.this);

        final CustomTable table = new CustomTable(new Point(40, 180), new Dimension(d.width - 40, d.height - 40), MedicinesPanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);

        updateTable(table, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize);

        //vector here
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Medicines> loadMedicine = null;
                try {
                    loadMedicine = Medicines.getAllMedicine();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
                for (int i = 0; i < loadMedicine.size(); i++) {
                    medicines.add(new Medicine(loadMedicine.get(i).getMedicineCode() + "", loadMedicine.get(i).getMedicineName(), loadMedicine.get(i).getMedicineTypeName(), loadMedicine.get(i).getSupplierName(), loadMedicine.get(i).getAvaiableAmount() + ""));
                }
                for (int i = 0; i < medicines.size() - 1; i++) {
                    for (int j = i + 1; j < medicines.size(); j++) {
                        if (nameSort) {
                            if (medicines.get(i).name.compareTo(medicines.get(j).name) < 0) {
                                swap(medicines, i, j);
                            }
                        } else {
                            if (medicines.get(i).name.compareTo(medicines.get(j).name) > 0) {
                                swap(medicines, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                MedicineRow.white = true;
                for (int i = 0; i < medicines.size(); i++) {
                    table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        
                searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                MedicineSearch addMedicines = new MedicineSearch("", false, false, false, new Dimension(250, 220));
//                addMedicines.setVisible(true);
                    String key = search.getText();
                      table.removeAll();

                    Vector<Medicines> loadMedicine = null;
                    try {
                        try {
                            loadMedicine = Medicines.getAllMedicine();
                        } catch (SQLException ex) {
                            Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    final ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
                    for (int i = 0; i < loadMedicine.size(); i++) {
                        if(loadMedicine.get(i).getMedicineName().equals(key) ||loadMedicine.get(i).getMedicineTypeName().equals(key)  ||loadMedicine.get(i).getSupplierName().equals(key))
                        medicines.add(new Medicine(loadMedicine.get(i).getMedicineCode() + "", loadMedicine.get(i).getMedicineName(), loadMedicine.get(i).getMedicineTypeName(), loadMedicine.get(i).getSupplierName(), loadMedicine.get(i).getAvaiableAmount() + ""));
                    }
                    table.setPreferredSize(new Dimension(1000, medicines.size() * 40));

                    for (int i = 0; i < medicines.size(); i++) {
                        table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
                    }
                    table.repaint();
            }
        });
        
        
        
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Medicines> loadMedicine = null;
                try {
                    loadMedicine = Medicines.getAllMedicine();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
                for (int i = 0; i < loadMedicine.size(); i++) {
                    medicines.add(new Medicine(loadMedicine.get(i).getMedicineCode() + "", loadMedicine.get(i).getMedicineName(), loadMedicine.get(i).getMedicineTypeName(), loadMedicine.get(i).getSupplierName(), loadMedicine.get(i).getAvaiableAmount() + ""));
                }
                for (int i = 0; i < medicines.size() - 1; i++) {
                    for (int j = i + 1; j < medicines.size(); j++) {
                        if (nameSort) {
                            if (Integer.parseInt(medicines.get(i).id) < Integer.parseInt(medicines.get(j).id)) {
                                swap(medicines, i, j);
                            }
                        } else {
                            if (Integer.parseInt(medicines.get(i).id) > Integer.parseInt(medicines.get(j).id)) {
                                swap(medicines, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                MedicineRow.white = true;
                for (int i = 0; i < medicines.size(); i++) {
                    table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Medicines> loadMedicine = null;
                try {
                    loadMedicine = Medicines.getAllMedicine();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
                for (int i = 0; i < loadMedicine.size(); i++) {
                    medicines.add(new Medicine(loadMedicine.get(i).getMedicineCode() + "", loadMedicine.get(i).getMedicineName(), loadMedicine.get(i).getMedicineTypeName(), loadMedicine.get(i).getSupplierName(), loadMedicine.get(i).getAvaiableAmount() + ""));
                }
                for (int i = 0; i < medicines.size() - 1; i++) {
                    for (int j = i + 1; j < medicines.size(); j++) {
                        if (nameSort) {
                            if (medicines.get(i).type.compareTo(medicines.get(j).type) < 0) {
                                swap(medicines, i, j);
                            }
                        } else {
                            if (medicines.get(i).type.compareTo(medicines.get(j).type) > 0) {
                                swap(medicines, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                System.out.println(nameSort);
                table.removeAll();
                MedicineRow.white = true;
                for (int i = 0; i < medicines.size(); i++) {
                    table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        supplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Medicines> loadMedicine = null;
                try {
                    loadMedicine = Medicines.getAllMedicine();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
                for (int i = 0; i < loadMedicine.size(); i++) {
                    medicines.add(new Medicine(loadMedicine.get(i).getMedicineCode() + "", loadMedicine.get(i).getMedicineName(), loadMedicine.get(i).getMedicineTypeName(), loadMedicine.get(i).getSupplierName(), loadMedicine.get(i).getAvaiableAmount() + ""));
                }
                for (int i = 0; i < medicines.size() - 1; i++) {
                    for (int j = i + 1; j < medicines.size(); j++) {
                        if (nameSort) {
                            if (medicines.get(i).supplier.compareTo(medicines.get(j).supplier) < 0) {
                                swap(medicines, i, j);
                            }
                        } else {
                            if (medicines.get(i).supplier.compareTo(medicines.get(j).supplier) > 0) {
                                swap(medicines, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                System.out.println(nameSort);
                table.removeAll();
                MedicineRow.white = true;
                for (int i = 0; i < medicines.size(); i++) {
                    table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTable(table, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize);
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        remain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Medicines> loadMedicine = null;
                try {
                    loadMedicine = Medicines.getAllMedicine();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
                for (int i = 0; i < loadMedicine.size(); i++) {
                    medicines.add(new Medicine(loadMedicine.get(i).getMedicineCode() + "", loadMedicine.get(i).getMedicineName(), loadMedicine.get(i).getMedicineTypeName(), loadMedicine.get(i).getSupplierName(), loadMedicine.get(i).getAvaiableAmount() + ""));
                }
                for (int i = 0; i < medicines.size() - 1; i++) {
                    for (int j = i + 1; j < medicines.size(); j++) {
                        if (nameSort) {
                            if (medicines.get(i).remain.compareTo(medicines.get(j).remain) < 0) {
                                swap(medicines, i, j);
                            }
                        } else {
                            if (medicines.get(i).remain.compareTo(medicines.get(j).remain) > 0) {
                                swap(medicines, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                System.out.println(nameSort);
                table.removeAll();
                MedicineRow.white = true;
                for (int i = 0; i < medicines.size(); i++) {
                    table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });
    }

    public void updateTable(CustomTable table, int idSize, int nameSize, int typeSize, int supplierSize, int remainSize, int optionSize) throws SQLException {
        table.removeAll();

        Vector<Medicines> loadMedicine = null;
        try {
            loadMedicine = Medicines.getAllMedicine();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicinesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        final ArrayList<Medicine> medicines = new ArrayList<MedicinesPanel.Medicine>();
        for (int i = 0; i < loadMedicine.size(); i++) {
            medicines.add(new Medicine(loadMedicine.get(i).getMedicineCode() + "", loadMedicine.get(i).getMedicineName(), loadMedicine.get(i).getMedicineTypeName(), loadMedicine.get(i).getSupplierName(), loadMedicine.get(i).getAvaiableAmount() + ""));
        }
        table.setPreferredSize(new Dimension(1000, medicines.size() * 40));

        for (int i = 0; i < medicines.size(); i++) {
            table.add(new MedicineRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
        }
        table.repaint();
    }
    public static boolean nameSort = true;

    public void swap(ArrayList<Medicine> medicines, int i, int j) {
        Medicine temp = new Medicine(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain);
        medicines.get(i).id = medicines.get(j).id;
        medicines.get(i).name = medicines.get(j).name;
        medicines.get(i).type = medicines.get(j).type;
        medicines.get(i).supplier = medicines.get(j).supplier;
        medicines.get(i).remain = medicines.get(j).remain;
        medicines.get(j).id = temp.id;
        medicines.get(j).name = temp.name;
        medicines.get(j).type = temp.type;
        medicines.get(j).supplier = temp.supplier;
        medicines.get(j).remain = temp.remain;
    }

    public class Medicine {

        String id;
        String name;
        String type;
        String supplier;
        String remain;

        public Medicine(String id, String name, String type, String supplier, String remain) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.supplier = supplier;
            this.remain = remain;
        }
    }
}
