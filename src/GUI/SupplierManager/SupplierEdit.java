package GUI.SupplierManager;

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
import java.util.Vector;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import GUI.Classes.Configure;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

public class SupplierEdit extends CustomFrame {

    public SupplierEdit(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension, final String id) throws SQLException, ClassNotFoundException {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel("Edit supplier",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        Dimension dim = dimension;
        final HintTextField name = new HintTextField(" Name", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 70), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField fullname = new HintTextField(" Fullname", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 110), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField address = new HintTextField(" Address", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 150), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField phone = new HintTextField(" Phone", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField fax = new HintTextField(" Fax", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField email = new HintTextField(" Email", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 230), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField web = new HintTextField(" Website", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 230), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);

        Suppliers suppliertemp = Suppliers.getSupplierbyId(id);

        name.setText(suppliertemp.getSupplierName());
        fullname.setText(suppliertemp.getSupplierfullName());
        address.setText(suppliertemp.getSupplierAddress());
        phone.setText(suppliertemp.getSupplierPhone());
        fax.setText(suppliertemp.getSupplierFax());
        email.setText(suppliertemp.getSupplierEmail());
        web.setText(suppliertemp.getSupplierWebsite());

        final CustomButton ok = new CustomButton("Save", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 280),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                String namex = name.getText().toString();
                String fullnamex = fullname.getText().toString();
                String addressx = address.getText().toString();
                String phonex = phone.getText().toString();
                String faxx = fax.getText().toString();
                String emailx = email.getText().toString();
                String webx = web.getText().toString();   
                
                    Suppliers.editSuppliers(namex, fullnamex, addressx, phonex, faxx, emailx, webx, id);
                } catch (SQLException ex) {
                    Logger.getLogger(SupplierEdit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SupplierEdit.class.getName()).log(Level.SEVERE, null, ex);
                }
                SupplierEdit.this.dispose();
            }
        });

        final CustomButton cancel = new CustomButton("Cancel", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 280),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SupplierEdit.this.dispose();
            }
        });
    }

}
