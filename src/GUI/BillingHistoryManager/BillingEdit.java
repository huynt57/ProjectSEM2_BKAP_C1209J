
package GUI.BillingHistoryManager;


import GUI.AccountManager.AccountPanel;
import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomComboBox;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.HintTextField;
import GUI.Classes.RemovablePanel;
import GUI.CustomersManager.Customers;
import GUI.MeasureManager.Measures;
import GUI.MedicinesManager.Medicines;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class BillingEdit extends CustomFrame {

    public BillingEdit( String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension) throws SQLException, ClassNotFoundException {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
//        type, supplier, measure,,  origine,  user guide, 
        CustomLabel titleLabel = new CustomLabel("Edit bill",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        Vector medicinesVt = new Vector();
        Vector measuresVt = new Vector();
        Vector customersVt = new Vector();
        medicinesVt.add("Choose medicine");
        measuresVt.add("Choose measure");
        customersVt.add("Choose customer");
        
        
        
        
       Vector<Medicines> medicinetemp = GUI.MedicinesManager.Medicines.getAllMedicine();
        for (int i = 0; i < medicinetemp.size(); i++) {
            medicinesVt.add(medicinetemp.get(i).getMedicineName());
        }
        
        Vector<Customers> custemp = GUI.CustomersManager.Customers.getAllCustomer();
        for (int i = 0; i < custemp.size(); i++) {
            customersVt.add(custemp.get(i).getCustomerName());
        }
        
        
        Vector<Measures> measuretemp = GUI.MeasureManager.Measures.getAllMeasure();
        for (int i = 0; i < measuretemp.size(); i++) {
            measuresVt.add(measuretemp.get(i).getMeasureName());
        }
        
        Dimension dim = dimension;
         final  CustomComboBox customerName = new CustomComboBox(customersVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),  new Point(20, 70), new Dimension(dim.width - 40, 30), contenPane);
        final HintTextField billType = new HintTextField(" Bill type", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 110), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField addressToDeliver = new HintTextField(" Address", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 150), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField dateStart = new HintTextField(" Start date", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField expiredDate = new HintTextField(" Expired date", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField tax = new HintTextField(" Tax", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 230), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField price = new HintTextField(" Price", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 230), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
         final HintTextField quantity = new HintTextField(" Quantity", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 230), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField status = new HintTextField(" Status", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 270), new Dimension((dim.width - 40), 30), contenPane, false);
        
        final  CustomComboBox medicices = new CustomComboBox(medicinesVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),  new Point(20, 310), new Dimension((dim.width - 40) / 2 - 5, 30 ), contenPane);
        final  CustomComboBox measures = new CustomComboBox(measuresVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),  new Point(205, 310), new Dimension((dim.width - 40) / 2 - 5, 30 ), contenPane);
       
        final CustomButton ok = new CustomButton("Save", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 360),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                
                
                
                
                // DB 
                
                
                
                
                
                BillingEdit.this.dispose();
            }
        });

        final CustomButton cancel = new CustomButton("Cancel", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 360),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BillingEdit.this.dispose();
            }
        });
    }

    
}

