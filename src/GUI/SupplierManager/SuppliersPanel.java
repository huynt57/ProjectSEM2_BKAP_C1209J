package GUI.SupplierManager;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuppliersPanel extends JPanel {

    public SuppliersPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("Suppliers manager",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, SuppliersPanel.this);
        CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(130, 80), new Dimension(100, 30), SuppliersPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);

        CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), SuppliersPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                SupplierNew addSupplier = new SupplierNew("", false, false, false, new Dimension(400, 330));
                addSupplier.setVisible(true);
            }
        });
        HintTextField search = new HintTextField(" Search Suppliers", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), SuppliersPanel.this, false);
        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), SuppliersPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);

        int totalWidth = d.width - 230;
        final int nameSize = totalWidth / 5;
        final int emailSize = totalWidth / 15 * 4;
        final int addressSize = totalWidth / 15 * 4;
        final int phoneSize = totalWidth / 15 * 4;
        final int idSize = 50;
        final int optionSize = 113;
        Color BACK_GROUND = Color.GRAY;

        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), SuppliersPanel.this);
        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), SuppliersPanel.this);
        CustomButton address = new CustomButton("Address", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(emailSize, 30), SuppliersPanel.this);
        CustomButton phone = new CustomButton("Phone", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + emailSize + idSize, 120), new Dimension(addressSize, 30), SuppliersPanel.this);
        CustomButton email = new CustomButton("Email", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + emailSize + addressSize + idSize, 120), new Dimension(phoneSize, 30), SuppliersPanel.this);
        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + emailSize + addressSize + phoneSize + idSize, 120), new Dimension(optionSize, 30), SuppliersPanel.this);

        final CustomTable table = new CustomTable(new Point(40, 150), new Dimension(d.width - 40, d.height - 40), SuppliersPanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);

        updateTeable(table, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize);

        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Suppliers> loadSupplier = null;
                try {
                    loadSupplier = Suppliers.getAllSupplier();
                } catch (SQLException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<SuppliersPanel.Supplier> suppliers = new ArrayList<SuppliersPanel.Supplier>();
                for (int i = 0; i < loadSupplier.size(); i++) {
                    suppliers.add(new Supplier(loadSupplier.get(i).getSupplierCode() + "", loadSupplier.get(i).getSupplierName() + "", loadSupplier.get(i).getSupplierAddress(), loadSupplier.get(i).getSupplierPhone(), loadSupplier.get(i).getSupplierEmail() + ""));
                }

                for (int i = 0; i < suppliers.size() - 1; i++) {
                    for (int j = i + 1; j < suppliers.size(); j++) {
                        if (nameSort) {
                            if (suppliers.get(i).name.compareTo(suppliers.get(j).name) < 0) {
                                swap(suppliers, i, j);
                            }
                        } else {
                            if (suppliers.get(i).name.compareTo(suppliers.get(j).name) > 0) {
                                swap(suppliers, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                SupplierRow.white = true;
                for (int i = 0; i < suppliers.size(); i++) {
                    table.add(new MedicineRow(suppliers.get(i).id, suppliers.get(i).name, suppliers.get(i).email, suppliers.get(i).address, suppliers.get(i).phone, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Suppliers> loadSupplier = null;
                try {
                    loadSupplier = Suppliers.getAllSupplier();
                } catch (SQLException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<SuppliersPanel.Supplier> suppliers = new ArrayList<SuppliersPanel.Supplier>();
                for (int i = 0; i < loadSupplier.size(); i++) {
                    suppliers.add(new Supplier(loadSupplier.get(i).getSupplierCode() + "", loadSupplier.get(i).getSupplierName() + "", loadSupplier.get(i).getSupplierAddress(), loadSupplier.get(i).getSupplierPhone(), loadSupplier.get(i).getSupplierEmail() + ""));
                }

                for (int i = 0; i < suppliers.size() - 1; i++) {
                    for (int j = i + 1; j < suppliers.size(); j++) {
                        if (nameSort) {
                            if (Integer.parseInt(suppliers.get(i).id) < Integer.parseInt(suppliers.get(j).id)) {
                                swap(suppliers, i, j);
                            }
                        } else {
                            if (Integer.parseInt(suppliers.get(i).id) > Integer.parseInt(suppliers.get(j).id)) {
                                swap(suppliers, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                SupplierRow.white = true;
                for (int i = 0; i < suppliers.size(); i++) {
                    table.add(new MedicineRow(suppliers.get(i).id, suppliers.get(i).name, suppliers.get(i).email, suppliers.get(i).address, suppliers.get(i).phone, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        email.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Suppliers> loadSupplier = null;
                try {
                    loadSupplier = Suppliers.getAllSupplier();
                } catch (SQLException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<SuppliersPanel.Supplier> suppliers = new ArrayList<SuppliersPanel.Supplier>();
                for (int i = 0; i < loadSupplier.size(); i++) {
                    suppliers.add(new Supplier(loadSupplier.get(i).getSupplierCode() + "", loadSupplier.get(i).getSupplierName() + "", loadSupplier.get(i).getSupplierAddress(), loadSupplier.get(i).getSupplierPhone(), loadSupplier.get(i).getSupplierEmail() + ""));
                }

                for (int i = 0; i < suppliers.size() - 1; i++) {
                    for (int j = i + 1; j < suppliers.size(); j++) {
                        if (nameSort) {
                            if (suppliers.get(i).email.compareTo(suppliers.get(j).email) < 0) {
                                swap(suppliers, i, j);
                            }
                        } else {
                            if (suppliers.get(i).email.compareTo(suppliers.get(j).email) > 0) {
                                swap(suppliers, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                SupplierRow.white = true;
                for (int i = 0; i < suppliers.size(); i++) {
                    table.add(new MedicineRow(suppliers.get(i).id, suppliers.get(i).name, suppliers.get(i).email, suppliers.get(i).address, suppliers.get(i).phone, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        address.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Suppliers> loadSupplier = null;
                try {
                    loadSupplier = Suppliers.getAllSupplier();
                } catch (SQLException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<SuppliersPanel.Supplier> suppliers = new ArrayList<SuppliersPanel.Supplier>();
                for (int i = 0; i < loadSupplier.size(); i++) {
                    suppliers.add(new Supplier(loadSupplier.get(i).getSupplierCode() + "", loadSupplier.get(i).getSupplierName() + "", loadSupplier.get(i).getSupplierAddress(), loadSupplier.get(i).getSupplierPhone(), loadSupplier.get(i).getSupplierEmail() + ""));
                }

                for (int i = 0; i < suppliers.size() - 1; i++) {
                    for (int j = i + 1; j < suppliers.size(); j++) {
                        if (nameSort) {
                            if (suppliers.get(i).address.compareTo(suppliers.get(j).address) < 0) {
                                swap(suppliers, i, j);
                            }
                        } else {
                            if (suppliers.get(i).address.compareTo(suppliers.get(j).address) > 0) {
                                swap(suppliers, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                SupplierRow.white = true;
                for (int i = 0; i < suppliers.size(); i++) {
                    table.add(new MedicineRow(suppliers.get(i).id, suppliers.get(i).name, suppliers.get(i).email, suppliers.get(i).address, suppliers.get(i).phone, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    updateTeable(table, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize);
                } catch (SQLException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        phone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<Suppliers> loadSupplier = null;
                try {
                    loadSupplier = Suppliers.getAllSupplier();
                } catch (SQLException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuppliersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                final ArrayList<SuppliersPanel.Supplier> suppliers = new ArrayList<SuppliersPanel.Supplier>();
                for (int i = 0; i < loadSupplier.size(); i++) {
                    suppliers.add(new Supplier(loadSupplier.get(i).getSupplierCode() + "", loadSupplier.get(i).getSupplierName() + "", loadSupplier.get(i).getSupplierAddress(), loadSupplier.get(i).getSupplierPhone(), loadSupplier.get(i).getSupplierEmail() + ""));
                }

                for (int i = 0; i < suppliers.size() - 1; i++) {
                    for (int j = i + 1; j < suppliers.size(); j++) {
                        if (nameSort) {
                            if (suppliers.get(i).phone.compareTo(suppliers.get(j).phone) < 0) {
                                swap(suppliers, i, j);
                            }
                        } else {
                            if (suppliers.get(i).phone.compareTo(suppliers.get(j).phone) > 0) {
                                swap(suppliers, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                SupplierRow.white = true;
                for (int i = 0; i < suppliers.size(); i++) {
                    table.add(new MedicineRow(suppliers.get(i).id, suppliers.get(i).name, suppliers.get(i).email, suppliers.get(i).address, suppliers.get(i).phone, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });
    }

    public void updateTeable(CustomTable table, int idSize, int nameSize, int emailSize, int addressSize, int phoneSize, int optionSize) throws SQLException, ClassNotFoundException {
        table.removeAll();
        Vector<Suppliers> loadSupplier = Suppliers.getAllSupplier();
        final ArrayList<SuppliersPanel.Supplier> suppliers = new ArrayList<SuppliersPanel.Supplier>();
        for (int i = 0; i < loadSupplier.size(); i++) {
            suppliers.add(new Supplier(loadSupplier.get(i).getSupplierCode() + "", loadSupplier.get(i).getSupplierName() + "", loadSupplier.get(i).getSupplierAddress(), loadSupplier.get(i).getSupplierPhone(), loadSupplier.get(i).getSupplierEmail() + ""));
        }
        table.setPreferredSize(new Dimension(1000, suppliers.size() * 40));
        for (int i = 0; i < suppliers.size(); i++) {
            table.add(new SupplierRow(suppliers.get(i).id, suppliers.get(i).name, suppliers.get(i).email, suppliers.get(i).address, suppliers.get(i).phone, idSize, nameSize, emailSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
        }
        table.setPreferredSize(new Dimension(1000, suppliers.size() * 40));
        table.repaint();
    }
    public static boolean nameSort = true;

    public void swap(ArrayList<SuppliersPanel.Supplier> suppliers, int i, int j) {
        SuppliersPanel.Supplier temp = new SuppliersPanel.Supplier(suppliers.get(i).id, suppliers.get(i).name, suppliers.get(i).email, suppliers.get(i).address, suppliers.get(i).phone);
        suppliers.get(i).id = suppliers.get(j).id;
        suppliers.get(i).name = suppliers.get(j).name;
        suppliers.get(i).email = suppliers.get(j).email;
        suppliers.get(i).address = suppliers.get(j).address;
        suppliers.get(i).phone = suppliers.get(j).phone;
        suppliers.get(j).id = temp.id;
        suppliers.get(j).name = temp.name;
        suppliers.get(j).email = temp.email;
        suppliers.get(j).address = temp.address;
        suppliers.get(j).phone = temp.phone;
    }

    public class Supplier {

        String id;
        String name;
        String email;
        String address;
        String phone;

        public Supplier(String id, String name, String email, String address, String phone) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.address = address;
            this.phone = phone;
        }
    }
}
