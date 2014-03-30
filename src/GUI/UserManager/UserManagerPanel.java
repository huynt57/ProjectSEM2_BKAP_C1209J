package GUI.UserManager;

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

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserManagerPanel extends JPanel {

    public UserManagerPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();

        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("User manager ",
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
                UserManagerNew addUserManager = new UserManagerNew("", false, false, false, new Dimension(400, 550));
                addUserManager.setVisible(true);
            }
        });
    }
//        HintTextField search = new HintTextField(" Search UserManager", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), UserManagerPanel.this, false);
//        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), UserManagerPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);
//        int totalWidth = d.width - 230;
//        final int nameSize = totalWidth / 3;
//        final int typeSize = totalWidth / 6;
//        final int supplierSize = totalWidth / 3;
//        final int remainSize = totalWidth / 6;
//        final int idSize = 50;
//        final int optionSize = 111;
//        Color BACK_GROUND = Color.GRAY;
//
//        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), UserManagerPanel.this);
//        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), UserManagerPanel.this);
//        CustomButton type = new CustomButton("Type", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(typeSize, 30), UserManagerPanel.this);
//        CustomButton supplier = new CustomButton("Supplier", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + idSize, 120), new Dimension(supplierSize, 30), UserManagerPanel.this);
//        CustomButton remain = new CustomButton("Remain", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + supplierSize + idSize, 120), new Dimension(remainSize, 30), UserManagerPanel.this);
//        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + supplierSize + remainSize + idSize, 120), new Dimension(optionSize, 30), UserManagerPanel.this);
//
//        final CustomTable table = new CustomTable(new Point(40, 180), new Dimension(d.width - 40, d.height - 40), UserManagerPanel.this);
//        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        x.setBounds(40, 150, d.width - 70, d.height - 170);
//        this.add(x);
//
//        updateTable(table, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize);
//
//        //vector here
//        name.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Vector<UserManager> loadUserManager = null;
//                try {
//                    loadUserManager = UserManager.getAllUserManager();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<UserManager> medicines = new ArrayList<UserManagerPanel.UserManager>();
//                for (int i = 0; i < loadUserManager.size(); i++) {
//                    medicines.add(new UserManager(loadUserManager.get(i).getUserManagerCode() + "", loadUserManager.get(i).getUserManagerName(), loadUserManager.get(i).getUserManagerTypeName(), loadUserManager.get(i).getSupplierName(), loadUserManager.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < medicines.size() - 1; i++) {
//                    for (int j = i + 1; j < medicines.size(); j++) {
//                        if (nameSort) {
//                            if (medicines.get(i).name.compareTo(medicines.get(j).name) < 0) {
//                                swap(medicines, i, j);
//                            }
//                        } else {
//                            if (medicines.get(i).name.compareTo(medicines.get(j).name) > 0) {
//                                swap(medicines, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                table.removeAll();
//                UserManagerRow.white = true;
//                for (int i = 0; i < medicines.size(); i++) {
//                    table.add(new UserManagerRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
//            }
//        });
//
//        id.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Vector<UserManager> loadUserManager = null;
//                try {
//                    loadUserManager = UserManager.getAllUserManager();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<UserManager> medicines = new ArrayList<UserManagerPanel.UserManager>();
//                for (int i = 0; i < loadUserManager.size(); i++) {
//                    medicines.add(new UserManager(loadUserManager.get(i).getUserManagerCode() + "", loadUserManager.get(i).getUserManagerName(), loadUserManager.get(i).getUserManagerTypeName(), loadUserManager.get(i).getSupplierName(), loadUserManager.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < medicines.size() - 1; i++) {
//                    for (int j = i + 1; j < medicines.size(); j++) {
//                        if (nameSort) {
//                            if (Integer.parseInt(medicines.get(i).id) < Integer.parseInt(medicines.get(j).id)) {
//                                swap(medicines, i, j);
//                            }
//                        } else {
//                            if (Integer.parseInt(medicines.get(i).id) > Integer.parseInt(medicines.get(j).id)) {
//                                swap(medicines, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                table.removeAll();
//                UserManagerRow.white = true;
//                for (int i = 0; i < medicines.size(); i++) {
//                    table.add(new UserManagerRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
//            }
//        });
//
//        type.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Vector<UserManager> loadUserManager = null;
//                try {
//                    loadUserManager = UserManager.getAllUserManager();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<UserManager> medicines = new ArrayList<UserManagerPanel.UserManager>();
//                for (int i = 0; i < loadUserManager.size(); i++) {
//                    medicines.add(new UserManager(loadUserManager.get(i).getUserManagerCode() + "", loadUserManager.get(i).getUserManagerName(), loadUserManager.get(i).getUserManagerTypeName(), loadUserManager.get(i).getSupplierName(), loadUserManager.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < medicines.size() - 1; i++) {
//                    for (int j = i + 1; j < medicines.size(); j++) {
//                        if (nameSort) {
//                            if (medicines.get(i).type.compareTo(medicines.get(j).type) < 0) {
//                                swap(medicines, i, j);
//                            }
//                        } else {
//                            if (medicines.get(i).type.compareTo(medicines.get(j).type) > 0) {
//                                swap(medicines, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                System.out.println(nameSort);
//                table.removeAll();
//                UserManagerRow.white = true;
//                for (int i = 0; i < medicines.size(); i++) {
//                    table.add(new UserManagerRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
//            }
//        });
//
//        supplier.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Vector<UserManager> loadUserManager = null;
//                try {
//                    loadUserManager = UserManager.getAllUserManager();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<UserManager> medicines = new ArrayList<UserManagerPanel.UserManager>();
//                for (int i = 0; i < loadUserManager.size(); i++) {
//                    medicines.add(new UserManager(loadUserManager.get(i).getUserManagerCode() + "", loadUserManager.get(i).getUserManagerName(), loadUserManager.get(i).getUserManagerTypeName(), loadUserManager.get(i).getSupplierName(), loadUserManager.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < medicines.size() - 1; i++) {
//                    for (int j = i + 1; j < medicines.size(); j++) {
//                        if (nameSort) {
//                            if (medicines.get(i).supplier.compareTo(medicines.get(j).supplier) < 0) {
//                                swap(medicines, i, j);
//                            }
//                        } else {
//                            if (medicines.get(i).supplier.compareTo(medicines.get(j).supplier) > 0) {
//                                swap(medicines, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                System.out.println(nameSort);
//                table.removeAll();
//                UserManagerRow.white = true;
//                for (int i = 0; i < medicines.size(); i++) {
//                    table.add(new UserManagerRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
//            }
//        });
//
//        refresh.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    updateTable(table, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize);
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//
//        remain.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Vector<UserManager> loadUserManager = null;
//                try {
//                    loadUserManager = UserManager.getAllUserManager();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<UserManager> medicines = new ArrayList<UserManagerPanel.UserManager>();
//                for (int i = 0; i < loadUserManager.size(); i++) {
//                    medicines.add(new UserManager(loadUserManager.get(i).getUserManagerCode() + "", loadUserManager.get(i).getUserManagerName(), loadUserManager.get(i).getUserManagerTypeName(), loadUserManager.get(i).getSupplierName(), loadUserManager.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < medicines.size() - 1; i++) {
//                    for (int j = i + 1; j < medicines.size(); j++) {
//                        if (nameSort) {
//                            if (medicines.get(i).remain.compareTo(medicines.get(j).remain) < 0) {
//                                swap(medicines, i, j);
//                            }
//                        } else {
//                            if (medicines.get(i).remain.compareTo(medicines.get(j).remain) > 0) {
//                                swap(medicines, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                System.out.println(nameSort);
//                table.removeAll();
//                UserManagerRow.white = true;
//                for (int i = 0; i < medicines.size(); i++) {
//                    table.add(new UserManagerRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
//            }
//        });
//    }
//
//    public void updateTable(CustomTable table, int idSize, int nameSize, int typeSize, int supplierSize, int remainSize, int optionSize) throws SQLException {
//        table.removeAll();
//
//        Vector<UserManager> loadUserManager = null;
//        try {
//            loadUserManager = UserManager.getAllUserManager();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(UserManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        final ArrayList<UserManager> medicines = new ArrayList<UserManagerPanel.UserManager>();
//        for (int i = 0; i < loadUserManager.size(); i++) {
//            medicines.add(new UserManager(loadUserManager.get(i).getUserManagerCode() + "", loadUserManager.get(i).getUserManagerName(), loadUserManager.get(i).getUserManagerTypeName(), loadUserManager.get(i).getSupplierName(), loadUserManager.get(i).getAvaiableAmount() + ""));
//        }
//        table.setPreferredSize(new Dimension(1000, medicines.size() * 40));
//
//        for (int i = 0; i < medicines.size(); i++) {
//            table.add(new UserManagerRow(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain, idSize, nameSize, typeSize, supplierSize, remainSize, optionSize, new Point(0, i * 40), table));
//        }
//        table.repaint();
//    }
//    public static boolean nameSort = true;
//
//    public void swap(ArrayList<UserManager> medicines, int i, int j) {
//        UserManager temp = new UserManager(medicines.get(i).id, medicines.get(i).name, medicines.get(i).type, medicines.get(i).supplier, medicines.get(i).remain);
//        medicines.get(i).id = medicines.get(j).id;
//        medicines.get(i).name = medicines.get(j).name;
//        medicines.get(i).type = medicines.get(j).type;
//        medicines.get(i).supplier = medicines.get(j).supplier;
//        medicines.get(i).remain = medicines.get(j).remain;
//        medicines.get(j).id = temp.id;
//        medicines.get(j).name = temp.name;
//        medicines.get(j).type = temp.type;
//        medicines.get(j).supplier = temp.supplier;
//        medicines.get(j).remain = temp.remain;
//    }
//
//    public class UserManager {
//
//        String id;
//        String name;
//        String type;
//        String supplier;
//        String remain;
//
//        public UserManager(String id, String name, String type, String supplier, String remain) {
//            this.id = id;
//            this.name = name;
//            this.type = type;
//            this.supplier = supplier;
//            this.remain = remain;
//        }
//    }
}