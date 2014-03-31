package GUI.UserManager;

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

public class UserManagerPanel extends JPanel {

    public UserManagerPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("Users manager",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, UserManagerPanel.this);

        CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), UserManagerPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(130, 80), new Dimension(100, 30), UserManagerPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UserManagerPanel.this.setEnabled(false);
                UserManagerNew addUserManager = null;
                try {
                    addUserManager = new UserManagerNew("", false, false, false, new Dimension(400, 340));
                } catch (SQLException ex) {
                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                addUserManager.setVisible(true);
            }
        });
        HintTextField search = new HintTextField(" Search user", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), UserManagerPanel.this, false);
        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), UserManagerPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);

        int totalWidth = d.width - 230;
        final int nameSize = totalWidth / 3;
        final int typeSize = totalWidth / 6;
        final int addressSize = totalWidth / 3;
        final int phoneSize = totalWidth / 6;
        final int idSize = 50;
        final int optionSize = 111;
        Color BACK_GROUND = Color.GRAY;

        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), UserManagerPanel.this);
        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), UserManagerPanel.this);
        CustomButton type = new CustomButton("Type", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(typeSize, 30), UserManagerPanel.this);
        CustomButton address = new CustomButton("Address", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + idSize, 120), new Dimension(addressSize, 30), UserManagerPanel.this);
        CustomButton phone = new CustomButton("Phone", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + idSize, 120), new Dimension(phoneSize, 30), UserManagerPanel.this);
        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + phoneSize + idSize, 120), new Dimension(optionSize, 30), UserManagerPanel.this);

        final CustomTable table = new CustomTable(new Point(40, 150), new Dimension(d.width - 40, d.height - 40), UserManagerPanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);

        Vector<Users> loadUserManager = Users.getAllUser();

        final ArrayList<UserManagerPanel.UserManager> users = new ArrayList<UserManagerPanel.UserManager>();
        for (int i = 0; i < loadUserManager.size(); i++) {
            users.add(new UserManager(loadUserManager.get(i).getUserCode() + "", loadUserManager.get(i).getNameLogin(), loadUserManager.get(i).getUserTypeCode() + "", loadUserManager.get(i).getUserAddress(), loadUserManager.get(i).getUserPhone()));
        }
        table.setPreferredSize(new Dimension(1000, users.size() * 40));
        for (int i = 0; i < users.size(); i++) {
            table.add(new UserManagerRow(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
        }
        table.setPreferredSize(new Dimension(1000, users.size() * 40));

        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < users.size() - 1; i++) {
                    for (int j = i + 1; j < users.size(); j++) {
                        if (nameSort) {
                            if (users.get(i).name.compareTo(users.get(j).name) < 0) {
                                swap(users, i, j);
                            }
                        } else {
                            if (users.get(i).name.compareTo(users.get(j).name) > 0) {
                                swap(users, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                UserManagerRow.white = true;
                for (int i = 0; i < users.size(); i++) {
                    table.add(new MedicineRow(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < users.size() - 1; i++) {
                    for (int j = i + 1; j < users.size(); j++) {
                        if (nameSort) {
                            if (Integer.parseInt(users.get(i).id) < Integer.parseInt(users.get(j).id)) {
                                swap(users, i, j);
                            }
                        } else {
                            if (Integer.parseInt(users.get(i).id) > Integer.parseInt(users.get(j).id)) {
                                swap(users, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                UserManagerRow.white = true;
                for (int i = 0; i < users.size(); i++) {
                    table.add(new MedicineRow(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < users.size() - 1; i++) {
                    for (int j = i + 1; j < users.size(); j++) {
                        if (nameSort) {
                            if (users.get(i).type.compareTo(users.get(j).type) < 0) {
                                swap(users, i, j);
                            }
                        } else {
                            if (users.get(i).type.compareTo(users.get(j).type) > 0) {
                                swap(users, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                UserManagerRow.white = true;
                for (int i = 0; i < users.size(); i++) {
                    table.add(new MedicineRow(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        address.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < users.size() - 1; i++) {
                    for (int j = i + 1; j < users.size(); j++) {
                        if (nameSort) {
                            if (users.get(i).address.compareTo(users.get(j).address) < 0) {
                                swap(users, i, j);
                            }
                        } else {
                            if (users.get(i).address.compareTo(users.get(j).address) > 0) {
                                swap(users, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                UserManagerRow.white = true;
                for (int i = 0; i < users.size(); i++) {
                    table.add(new MedicineRow(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        phone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < users.size() - 1; i++) {
                    for (int j = i + 1; j < users.size(); j++) {
                        if (nameSort) {
                            if (users.get(i).phone.compareTo(users.get(j).phone) < 0) {
                                swap(users, i, j);
                            }
                        } else {
                            if (users.get(i).phone.compareTo(users.get(j).phone) > 0) {
                                swap(users, i, j);
                            }
                        }
                    }
                }
                nameSort = !nameSort;
                table.removeAll();
                UserManagerRow.white = true;
                for (int i = 0; i < users.size(); i++) {
                    table.add(new MedicineRow(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
                }
                table.repaint();
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTable(table, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize);
                } catch (SQLException ex) {
                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static boolean nameSort = true;

    public void updateTable(CustomTable table, int idSize, int nameSize, int typeSize, int addressSize, int phoneSize, int optionSize) throws SQLException, ClassNotFoundException {
        table.removeAll();
        Vector<Users> loadUserManager = Users.getAllUser();
        final ArrayList<UserManagerPanel.UserManager> users = new ArrayList<UserManagerPanel.UserManager>();
        for (int i = 0; i < loadUserManager.size(); i++) {
            users.add(new UserManager(loadUserManager.get(i).getUserCode() + "", loadUserManager.get(i).getNameLogin(), loadUserManager.get(i).getUserTypeCode() + "", loadUserManager.get(i).getUserAddress(), loadUserManager.get(i).getUserPhone()));
        }
        table.setPreferredSize(new Dimension(1000, users.size() * 40));
        for (int i = 0; i < users.size(); i++) {
            table.add(new UserManagerRow(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
        }
        table.setPreferredSize(new Dimension(1000, users.size() * 40));
        table.repaint();
    }

    public void swap(ArrayList<UserManagerPanel.UserManager> users, int i, int j) {
        UserManagerPanel.UserManager temp = new UserManagerPanel.UserManager(users.get(i).id, users.get(i).name, users.get(i).type, users.get(i).address, users.get(i).phone);
        users.get(i).id = users.get(j).id;
        users.get(i).name = users.get(j).name;
        users.get(i).type = users.get(j).type;
        users.get(i).address = users.get(j).address;
        users.get(i).phone = users.get(j).phone;
        users.get(j).id = temp.id;
        users.get(j).name = temp.name;
        users.get(j).type = temp.type;
        users.get(j).address = temp.address;
        users.get(j).phone = temp.phone;
    }

    public class UserManager {

        String id;
        String name;
        String type;
        String address;
        String phone;

        public UserManager(String id, String name, String type, String address, String phone) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.address = address;
            this.phone = phone;
        }
    }
}
