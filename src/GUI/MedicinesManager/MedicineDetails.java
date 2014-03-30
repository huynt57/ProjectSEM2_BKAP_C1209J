
package GUI.MedicinesManager;

import GUI.AccountManager.AccountPanel;
import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomComboBox;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.HintTextField;
import GUI.Classes.RemovablePanel;
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

public class MedicineDetails extends CustomFrame {

    public MedicineDetails( String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension, String id) throws SQLException, ClassNotFoundException {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel("Medicine details",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        Dimension dim = dimension;

        CustomLabel nameLabel = new CustomLabel("Name",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 70), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel priceLabel = new CustomLabel("Price",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 110), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel userLabel = new CustomLabel("Used",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 190), new Dimension(100, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel registerNumberLabel = new CustomLabel("Register number",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(205, 150), new Dimension((dim.width - 40) / 2 - 5, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel numberLabel = new CustomLabel("Number",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 150), new Dimension((dim.width - 40) / 2 - 5, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel termOfUseLabel = new CustomLabel("Term of use",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
               new Point(205, 110), new Dimension((dim.width - 40) / 2 , 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
          CustomLabel supplierLabel = new CustomLabel("Supplier",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
               new Point(20, 230), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel measureLabel = new CustomLabel("Measure",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 270), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel typeLabel = new CustomLabel("Type",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 310), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel origineLabel = new CustomLabel("Origin",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 350), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel userGuideLabel = new CustomLabel("User guide",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
               new Point(20, 390), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
       
        
//        supplierLabel.setText("Supplier: " + xxx);
        
Medicines medicineDetails = Medicines.getMedicineById(id);

        //System.out.println(id);


        nameLabel.setText("Name: "+medicineDetails.getMedicineName());
        priceLabel.setText("Price: "+medicineDetails.getPricePerUnit() + "");
        termOfUseLabel.setText("Term of use: "+medicineDetails.getTermsOfUse());
        userLabel.setText("Available: "+medicineDetails.getAvaiableAmount() + "");
        registerNumberLabel.setText("Register number: "+medicineDetails.getRegisterNumber());
        userGuideLabel.setText("User guide: "+medicineDetails.getUseGuide());
        origineLabel.setText("Origin: "+medicineDetails.getOrigin());
        typeLabel.setText("Type Medicine: "+medicineDetails.getMedicineTypeName());
        measureLabel.setText("Measure: "+medicineDetails.getMeasureName());
        supplierLabel.setText("Supplier: "+medicineDetails.getSupplierName());
        
        final CustomButton ok = new CustomButton("OK", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 450),
                new Dimension(100, 30), contenPane);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MedicineDetails.this.dispose();
            }
        });

    }

    
}
