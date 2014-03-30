
package GUI.Order;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomTable;
import GUI.Classes.HintTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class OrderPanel extends JPanel {

    public OrderPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();

        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);

        CustomLabel titleLabel = new CustomLabel("Order manager ",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, OrderPanel.this);

        CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), OrderPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(130, 80), new Dimension(100, 30), OrderPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);

        add.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                OrderPanel.this.setEnabled(false);
                OrderNew addOrder = new OrderNew("", false, false, false, new Dimension(400, 550));
                addOrder.setVisible(true);
            }
        });
   
        HintTextField search = new HintTextField(" Search Order", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), OrderPanel.this, false);
        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), OrderPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);
        int totalWidth = d.width - 230;
        final int nameSize = totalWidth / 3;
        final int priceSize = totalWidth / 6;
        final int addressToDeliverSize = totalWidth / 3 - 20;
        final int dateOverSize = totalWidth / 6 + 20;
        final int idSize = 50;
        final int optionSize = 111;
        Color BACK_GROUND = Color.GRAY;
      
        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), OrderPanel.this);
        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), OrderPanel.this);
        CustomButton price = new CustomButton("Price", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(priceSize, 30), OrderPanel.this);
        CustomButton addressToDeliver = new CustomButton("Address to deliver", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + priceSize + idSize, 120), new Dimension(addressToDeliverSize, 30), OrderPanel.this);
        CustomButton dateOver = new CustomButton("Date over", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + priceSize + addressToDeliverSize + idSize, 120), new Dimension(dateOverSize, 30), OrderPanel.this);
        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + priceSize + addressToDeliverSize + dateOverSize + idSize, 120), new Dimension(optionSize, 30), OrderPanel.this);

        final CustomTable table = new CustomTable(new Point(40, 180), new Dimension(d.width - 40, d.height - 40), OrderPanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);

        updateTable(table, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize);

        //vector here
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                Vector<Order> loadOrder = null;
//                try {
//                    loadOrder = Medicines.getAllMedicine();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<Order> orders = new ArrayList<OrderPanel.Order>();
//                for (int i = 0; i < loadOrder.size(); i++) {
//                    orders.add(new Order(loadOrder.get(i).getMedicineCode() + "", loadOrder.get(i).getMedicineName(), loadOrder.get(i).getMedicineTypeName(), loadOrder.get(i).getSupplierName(), loadOrder.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < orders.size() - 1; i++) {
//                    for (int j = i + 1; j < orders.size(); j++) {
//                        if (nameSort) {
//                            if (orders.get(i).name.compareTo(orders.get(j).name) < 0) {
//                                swap(orders, i, j);
//                            }
//                        } else {
//                            if (orders.get(i).name.compareTo(orders.get(j).name) > 0) {
//                                swap(orders, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                table.removeAll();
//                OrderRow.white = true;
//                for (int i = 0; i < orders.size(); i++) {
//                    table.add(new OrderRow(orders.get(i).id, orders.get(i).name, orders.get(i).price, orders.get(i).addressToDeliver, orders.get(i).dateOver, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
            }
        });

        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                Vector<Order> loadOrder = null;
//                try {
//                    loadOrder = Medicines.getAllMedicine();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<Order> orders = new ArrayList<OrderPanel.Order>();
//                for (int i = 0; i < loadOrder.size(); i++) {
//                    orders.add(new Order(loadOrder.get(i).getMedicineCode() + "", loadOrder.get(i).getMedicineName(), loadOrder.get(i).getMedicineTypeName(), loadOrder.get(i).getSupplierName(), loadOrder.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < orders.size() - 1; i++) {
//                    for (int j = i + 1; j < orders.size(); j++) {
//                        if (nameSort) {
//                            if (Integer.parseInt(orders.get(i).id) < Integer.parseInt(orders.get(j).id)) {
//                                swap(orders, i, j);
//                            }
//                        } else {
//                            if (Integer.parseInt(orders.get(i).id) > Integer.parseInt(orders.get(j).id)) {
//                                swap(orders, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                table.removeAll();
//                OrderRow.white = true;
//                for (int i = 0; i < orders.size(); i++) {
//                    table.add(new OrderRow(orders.get(i).id, orders.get(i).name, orders.get(i).price, orders.get(i).addressToDeliver, orders.get(i).dateOver, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
            }
        });

        price.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                Vector<Order> loadOrder = null;
//                try {
//                    loadOrder = Medicines.getAllMedicine();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<Order> orders = new ArrayList<OrderPanel.Order>();
//                for (int i = 0; i < loadOrder.size(); i++) {
//                    orders.add(new Order(loadOrder.get(i).getMedicineCode() + "", loadOrder.get(i).getMedicineName(), loadOrder.get(i).getMedicineTypeName(), loadOrder.get(i).getSupplierName(), loadOrder.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < orders.size() - 1; i++) {
//                    for (int j = i + 1; j < orders.size(); j++) {
//                        if (nameSort) {
//                            if (orders.get(i).price.compareTo(orders.get(j).price) < 0) {
//                                swap(orders, i, j);
//                            }
//                        } else {
//                            if (orders.get(i).price.compareTo(orders.get(j).price) > 0) {
//                                swap(orders, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                System.out.println(nameSort);
//                table.removeAll();
//                OrderRow.white = true;
//                for (int i = 0; i < orders.size(); i++) {
//                    table.add(new OrderRow(orders.get(i).id, orders.get(i).name, orders.get(i).price, orders.get(i).addressToDeliver, orders.get(i).dateOver, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
            }
        });

        addressToDeliver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                Vector<Order> loadOrder = null;
//                try {
//                    loadOrder = Medicines.getAllMedicine();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<Order> orders = new ArrayList<OrderPanel.Order>();
//                for (int i = 0; i < loadOrder.size(); i++) {
//                    orders.add(new Order(loadOrder.get(i).getMedicineCode() + "", loadOrder.get(i).getMedicineName(), loadOrder.get(i).getMedicineTypeName(), loadOrder.get(i).getSupplierName(), loadOrder.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < orders.size() - 1; i++) {
//                    for (int j = i + 1; j < orders.size(); j++) {
//                        if (nameSort) {
//                            if (orders.get(i).addressToDeliver.compareTo(orders.get(j).addressToDeliver) < 0) {
//                                swap(orders, i, j);
//                            }
//                        } else {
//                            if (orders.get(i).addressToDeliver.compareTo(orders.get(j).addressToDeliver) > 0) {
//                                swap(orders, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                System.out.println(nameSort);
//                table.removeAll();
//                OrderRow.white = true;
//                for (int i = 0; i < orders.size(); i++) {
//                    table.add(new OrderRow(orders.get(i).id, orders.get(i).name, orders.get(i).price, orders.get(i).addressToDeliver, orders.get(i).dateOver, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTable(table, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize);
                } catch (SQLException ex) {
                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        dateOver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                Vector<Order> loadOrder = null;
//                try {
//                    loadOrder = Medicines.getAllMedicine();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                final ArrayList<Order> orders = new ArrayList<OrderPanel.Order>();
//                for (int i = 0; i < loadOrder.size(); i++) {
//                    orders.add(new Order(loadOrder.get(i).getMedicineCode() + "", loadOrder.get(i).getMedicineName(), loadOrder.get(i).getMedicineTypeName(), loadOrder.get(i).getSupplierName(), loadOrder.get(i).getAvaiableAmount() + ""));
//                }
//                for (int i = 0; i < orders.size() - 1; i++) {
//                    for (int j = i + 1; j < orders.size(); j++) {
//                        if (nameSort) {
//                            if (orders.get(i).dateOver.compareTo(orders.get(j).dateOver) < 0) {
//                                swap(orders, i, j);
//                            }
//                        } else {
//                            if (orders.get(i).dateOver.compareTo(orders.get(j).dateOver) > 0) {
//                                swap(orders, i, j);
//                            }
//                        }
//                    }
//                }
//                nameSort = !nameSort;
//                System.out.println(nameSort);
//                table.removeAll();
//                OrderRow.white = true;
//                for (int i = 0; i < orders.size(); i++) {
//                    table.add(new OrderRow(orders.get(i).id, orders.get(i).name, orders.get(i).price, orders.get(i).addressToDeliver, orders.get(i).dateOver, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize, new Point(0, i * 40), table));
//                }
//                table.repaint();
            }
        });
    }

    public void updateTable(CustomTable table, int idSize, int nameSize, int priceSize, int addressToDeliverSize, int dateOverSize, int optionSize) throws SQLException {
        table.removeAll();

//        Vector<Order> loadOrder = null;
//        try {
//            loadOrder = Medicines.getAllMedicine();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(OrderPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        final ArrayList<Order> orders = new ArrayList<OrderPanel.Order>();
//        for (int i = 0; i < loadOrder.size(); i++) {
//            orders.add(new Order(loadOrder.get(i).getMedicineCode() + "", loadOrder.get(i).getMedicineName(), loadOrder.get(i).getMedicineTypeName(), loadOrder.get(i).getSupplierName(), loadOrder.get(i).getAvaiableAmount() + ""));
//        }
//        table.setPreferredSize(new Dimension(1000, orders.size() * 40));
//
//        for (int i = 0; i < orders.size(); i++) {
//            table.add(new OrderRow(orders.get(i).id, orders.get(i).name, orders.get(i).price, orders.get(i).addressToDeliver, orders.get(i).dateOver, idSize, nameSize, priceSize, addressToDeliverSize, dateOverSize, optionSize, new Point(0, i * 40), table));
//        }
//        table.repaint();
    }
    public static boolean nameSort = true;

    public void swap(ArrayList<Order> orders, int i, int j) {
        Order temp = new Order(orders.get(i).id, orders.get(i).name, orders.get(i).price, orders.get(i).addressToDeliver, orders.get(i).dateOver);
        orders.get(i).id = orders.get(j).id;
        orders.get(i).name = orders.get(j).name;
        orders.get(i).price = orders.get(j).price;
        orders.get(i).addressToDeliver = orders.get(j).addressToDeliver;
        orders.get(i).dateOver = orders.get(j).dateOver;
        orders.get(j).id = temp.id;
        orders.get(j).name = temp.name;
        orders.get(j).price = temp.price;
        orders.get(j).addressToDeliver = temp.addressToDeliver;
        orders.get(j).dateOver = temp.dateOver;
    }

    public class Order {

        String id;
        String name;
        String price;
        String addressToDeliver;
        String dateOver;

        public Order(String id, String name, String price, String addressToDeliver, String dateOver) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.addressToDeliver = addressToDeliver;
            this.dateOver = dateOver;
        }
    }
}
