/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import GUI.MeasureManager.Measures;
import GUI.MedicineTypeManager.MedicineTypes;
import GUI.SupplierManager.Suppliers;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Boolean.TRUE;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MedicineEdit extends CustomFrame {

    public MedicineEdit(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension, final String id) throws SQLException, ClassNotFoundException {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
//        type, supplier, measure,,  origine,  user guide, 
        CustomLabel titleLabel = new CustomLabel("Edit medicine",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
//        Vector supplierVt = new Vector();
//        supplierVt = GUI.SupplierManager.Suppliers.getAllSupplier();
//        Vector typeVt = new Vector();
//        typeVt = GUI.MedicineTypeManager.MedicineTypes.getAllMedicineType();
//        Vector measureVt = new Vector();
//        measureVt = GUI.MeasureManager.Measures.getAllMeasure();

        Dimension dim = dimension;
        final HintTextField name = new HintTextField(" Name", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 70), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField price = new HintTextField(" Price", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 110), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField termOfUse = new HintTextField(" Term of user", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 110), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField number = new HintTextField(" Available amount", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 150), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField registerNumber = new HintTextField(" Register number", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 150), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField used = new HintTextField(" Used", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 190), new Dimension(dim.width - 40, 30), contenPane, false);

        Medicines medicineDetails = Medicines.getMedicineById(id);

        //System.out.println(id);
        name.setText(medicineDetails.getMedicineName());
        price.setText(medicineDetails.getPricePerUnit() + "");
        termOfUse.setText(medicineDetails.getTermsOfUse());
        number.setText(medicineDetails.getAvaiableAmount() + "");
        registerNumber.setText(medicineDetails.getRegisterNumber());
        used.setText(medicineDetails.getUsed());

        Vector<String> supplierVt = new Vector<String>();
        Vector<Suppliers> supplierTemp = GUI.SupplierManager.Suppliers.getAllSupplier();
        for (int i = 0; i < supplierTemp.size(); i++) {
            supplierVt.add(supplierTemp.get(i).getSupplierName());
        }
        Vector<String> typeVt = new Vector<String>();
        Vector<MedicineTypes> metypeTemp = GUI.MedicineTypeManager.MedicineTypes.getAllMedicineType();
        for (int i = 0; i < metypeTemp.size(); i++) {
            typeVt.add(metypeTemp.get(i).getMedicineTypeName());
        }
        Vector<String> measureVt = new Vector<String>();
        Vector<Measures> measuretemp = GUI.MeasureManager.Measures.getAllMeasure();
        for (int i = 0; i < measuretemp.size(); i++) {
            measureVt.add(measuretemp.get(i).getMeasureName());
        }

        CustomLabel supplierLabel = new CustomLabel("Supplier",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point(20, 230), new Dimension(100, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final CustomComboBox supplier = new CustomComboBox(supplierVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(100, 230), new Dimension(dim.width - 120, 30), contenPane);
        CustomLabel measureLabel = new CustomLabel("Measure",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point(20, 270), new Dimension(100, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final CustomComboBox measure = new CustomComboBox(measureVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(100, 270), new Dimension(dim.width - 120, 30), contenPane);
        CustomLabel typeLabel = new CustomLabel("Type",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point(20, 310), new Dimension(100, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final CustomComboBox type = new CustomComboBox(typeVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(100, 310), new Dimension(dim.width - 120, 30), contenPane);

        supplier.setSelectedItem(medicineDetails.getSupplierName());
        measure.setSelectedItem(medicineDetails.getMeasureName());
        type.setSelectedItem(medicineDetails.getMedicineTypeName());

        final JRadioButton domestic = new JRadioButton("");
        domestic.setFont(CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13));
        domestic.setBounds(100, 350, 20, 20);
        domestic.setBackground(BackGround);
        contenPane.add(domestic);
        CustomLabel domesticLabel = new CustomLabel("Domestic",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point(120, 350), new Dimension(60, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final JRadioButton foreign = new JRadioButton("");
        foreign.setFont(CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13));
        foreign.setBounds((dim.width - 40) / 2 + 10, 350, 20, 20);
        foreign.setBackground(BackGround);
        contenPane.add(foreign);
        CustomLabel foreignLabel = new CustomLabel("Foreign",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point((dim.width - 40) / 2 + 30, 350), new Dimension(60, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        domestic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                foreign.setSelected(false);
            }
        });
        foreign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                domestic.setSelected(false);
            }
        });
        final HintTextField userGuide = new HintTextField(" User guide", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 380), new Dimension(dim.width - 40, 100), contenPane, false);

        userGuide.setText(medicineDetails.getUseGuide());
        if (medicineDetails.getOrigin().equals("domestic"))
        {
            domestic.setSelected(TRUE);
        }
        else{
            foreign.setSelected(TRUE);
        }
        final CustomButton ok = new CustomButton("Save", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 500),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String namex = name.getText().toString();
                    String supplierx = supplier.getSelectedItem().toString();
                    String pricex = price.getText();
                    String termofUsed = termOfUse.getText().toString();
                    String regNum = registerNumber.getText().toString();
                    String num = number.getText().toString();
                    String usedx = used.getText().toString();
                    String measurex = measure.getSelectedItem().toString();
                    String typex = type.getSelectedItem().toString();
                    String origin;
                    if (domestic.isSelected()) {
                        origin = "domestic";
                    } else {
                        origin = "foreign";
                    }
                    String guide = userGuide.getText().toString();
                    Medicines.UpdateMedicine(namex, supplierx, pricex, termofUsed, num, regNum, usedx, measurex, typex, origin, guide, id);

                    MedicineEdit.this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicineEdit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MedicineEdit.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        final CustomButton cancel = new CustomButton("Cancel", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 500),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MedicineEdit.this.dispose();
            }
        });
    }

}
