package GUI.CustomersManager;

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

public class CustomersPanel extends JPanel {

    public CustomersPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);
        
        CustomLabel titleLabel = new CustomLabel("Customers manager",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, CustomersPanel.this);

        CustomButton add = new CustomButton(new ImageIcon("src/GUI/Resources/add.bin"), "Add", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(40, 80), new Dimension(80, 30), CustomersPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        CustomButton refresh = new CustomButton(new ImageIcon("src/GUI/Resources/refresh.bin"), "Refresh", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(130, 80), new Dimension(100, 30), CustomersPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CustomersPanel.this.setEnabled(false);
                CustomerNew addCustomers = new CustomerNew("", false, false, false, new Dimension(400, 340));
                addCustomers.setVisible(true);
            }
        });
        HintTextField search = new HintTextField(" Search customer", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), CustomersPanel.this, false);
        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), CustomersPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);

        int totalWidth = d.width - 230;
        final int nameSize = totalWidth / 3;
        final int typeSize = totalWidth / 6;
        final int addressSize = totalWidth / 3;
        final int phoneSize = totalWidth / 6;
        final int idSize = 50;
        final int optionSize = 111;
        Color BACK_GROUND = Color.GRAY;

        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), CustomersPanel.this);
        CustomButton name = new CustomButton("Name", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(nameSize, 30), CustomersPanel.this);
        CustomButton type = new CustomButton("Type", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + idSize, 120), new Dimension(typeSize, 30), CustomersPanel.this);
        CustomButton address = new CustomButton("Address", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + idSize, 120), new Dimension(addressSize, 30), CustomersPanel.this);
        CustomButton phone = new CustomButton("Phone", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + idSize, 120), new Dimension(phoneSize, 30), CustomersPanel.this);
        CustomButton options = new CustomButton("Options", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + nameSize + typeSize + addressSize + phoneSize + idSize, 120), new Dimension(optionSize, 30), CustomersPanel.this);

        final CustomTable table = new CustomTable(new Point(40, 150), new Dimension(d.width - 40, d.height - 40), CustomersPanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);
        
        Vector<Customers> loadCustomer = Customers.getAllCustomer();
 
        final ArrayList<CustomersPanel.Customer> customers = new ArrayList<CustomersPanel.Customer>();
        for(int i=0; i<loadCustomer.size(); i++) customers.add(new Customer(loadCustomer.get(i).getCustomerCode() + "", loadCustomer.get(i).getCustomerName(), loadCustomer.get(i).getCustomerType() + "", loadCustomer.get(i).getCustomerAddress() , loadCustomer.get(i).getCustomerPhone()));   
        table.setPreferredSize(new Dimension(1000, customers.size() * 40));	
        for(int i=0; i<customers.size(); i++)
        table.add(new CustomerRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
        table.setPreferredSize(new Dimension(1000, customers.size() * 40));
       
        name.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<customers.size()-1; i++)
                            for(int j=i+1; j<customers.size(); j++) 
                                if(nameSort) {
                                    if(customers.get(i).name.compareTo(customers.get(j).name) < 0) {
                                        swap(customers, i, j);
                                    } 
                                } else {
                                    if(customers.get(i).name.compareTo(customers.get(j).name) > 0) {
                                       swap(customers, i, j);
                                    } 
                                }      
                        nameSort = !nameSort;
                        table.removeAll();
                        CustomerRow.white = true;
                        for(int i=0; i<customers.size(); i++)
                	table.add(new MedicineRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize , phoneSize, optionSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        
        id.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<customers.size()-1; i++)
                            for(int j=i+1; j<customers.size(); j++) 
                                if(nameSort) {
                                    if(Integer.parseInt(customers.get(i).id) < Integer.parseInt(customers.get(j).id)) {
                                        swap(customers, i, j);
                                    } 
                                } else {
                                    if(Integer.parseInt(customers.get(i).id) > Integer.parseInt(customers.get(j).id)) {
                                       swap(customers, i, j);
                                    } 
                                }      
                        nameSort = !nameSort;
                        table.removeAll();
                        CustomerRow.white = true;
                        for(int i=0; i<customers.size(); i++)
                	table.add(new MedicineRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize , phoneSize, optionSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        
        type.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<customers.size()-1; i++)
                            for(int j=i+1; j<customers.size(); j++) 
                                if(nameSort) {
                                    if(customers.get(i).type.compareTo(customers.get(j).type) < 0) {
                                        swap(customers, i, j);
                                    } 
                                } else {
                                    if(customers.get(i).type.compareTo(customers.get(j).type) > 0) {
                                       swap(customers, i, j);
                                    } 
                                }      
                        nameSort = !nameSort;
                        table.removeAll();
                        CustomerRow.white = true;
                        for(int i=0; i<customers.size(); i++)
                	table.add(new MedicineRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize , phoneSize, optionSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        
        address.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<customers.size()-1; i++)
                            for(int j=i+1; j<customers.size(); j++) 
                                if(nameSort) {
                                    if(customers.get(i).address.compareTo(customers.get(j).address) < 0) {
                                        swap(customers, i, j);
                                    } 
                                } else {
                                    if(customers.get(i).address.compareTo(customers.get(j).address) > 0) {
                                       swap(customers, i, j);
                                    } 
                                }      
                        nameSort = !nameSort;
                        table.removeAll();
                        CustomerRow.white = true;
                        for(int i=0; i<customers.size(); i++)
                	table.add(new MedicineRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize , phoneSize, optionSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        
        phone.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<customers.size()-1; i++)
                            for(int j=i+1; j<customers.size(); j++) 
                                if(nameSort) {
                                    if(customers.get(i).phone.compareTo(customers.get(j).phone) < 0) {
                                        swap(customers, i, j);
                                    } 
                                } else {
                                    if(customers.get(i).phone.compareTo(customers.get(j).phone) > 0) {
                                       swap(customers, i, j);
                                    } 
                                }      
                        nameSort = !nameSort;
                        table.removeAll();
                        CustomerRow.white = true;
                        for(int i=0; i<customers.size(); i++)
                	table.add(new MedicineRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize , phoneSize, optionSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        
       refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTable(table, idSize,nameSize, typeSize, addressSize, phoneSize, optionSize);
                } catch (SQLException ex) {
                    Logger.getLogger(CustomersPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    public static boolean nameSort = true;
    
    public void updateTable(CustomTable table, int idSize, int nameSize, int typeSize, int addressSize, int phoneSize, int optionSize) throws SQLException, ClassNotFoundException {
        table.removeAll();
        Vector<Customers> loadCustomer = Customers.getAllCustomer();
        final ArrayList<CustomersPanel.Customer> customers = new ArrayList<CustomersPanel.Customer>();
        for(int i=0; i<loadCustomer.size(); i++) customers.add(new Customer(loadCustomer.get(i).getCustomerCode() + "", loadCustomer.get(i).getCustomerName(), loadCustomer.get(i).getCustomerType() + "", loadCustomer.get(i).getCustomerAddress() , loadCustomer.get(i).getCustomerPhone()));   
        table.setPreferredSize(new Dimension(1000, customers.size() * 40));	
        for(int i=0; i<customers.size(); i++)
        table.add(new CustomerRow(customers.get(i).id, customers.get(i).name, customers.get(i).type, customers.get(i).address, customers.get(i).phone, idSize, nameSize, typeSize, addressSize, phoneSize, optionSize, new Point(0, i * 40), table));
        table.repaint();
    }
    
        public void swap(ArrayList<CustomersPanel.Customer> customers, int i, int j) {
            CustomersPanel.Customer temp = new CustomersPanel.Customer(customers.get(i).id,customers.get(i).name,customers.get(i).type,customers.get(i).address,customers.get(i).phone);
            customers.get(i).id = customers.get(j).id;
            customers.get(i).name = customers.get(j).name;
            customers.get(i).type = customers.get(j).type;
            customers.get(i).address = customers.get(j).address;
            customers.get(i).phone = customers.get(j).phone;
            customers.get(j).id = temp.id;
            customers.get(j).name = temp.name;
            customers.get(j).type = temp.type;
            customers.get(j).address = temp.address;
            customers.get(j).phone = temp.phone;
        }
    public class Customer {

        String id;
        String name;
        String type;
        String address;
        String phone;

        public Customer(String id, String name, String type, String address, String phone) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.address = address;
            this.phone = phone;
        }
    }
}
