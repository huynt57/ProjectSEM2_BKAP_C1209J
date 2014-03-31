package GUI.Order;

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
import java.util.Vector;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class OrderNew extends CustomFrame {

    public OrderNew( String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension) {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
//        type, supplier, measure,,  origine,  user guide, 
        CustomLabel titleLabel = new CustomLabel("Add new order",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        Vector medicinesVt = new Vector();
        Vector measuresVt = new Vector();
        Vector customersVt = new Vector();
        Vector relationshipVt = new Vector();
        relationshipVt.add("Familiar");
        relationshipVt.add("Unfamiliar");
        medicinesVt.add("Choose medicine");
        measuresVt.add("Choose measure");
        customersVt.add("Choose customer");
        
        
        
        
        // ADD DATA TO COMBOBOX
        for(int i=0; i<100; i++) {
            medicinesVt.add(i);
            measuresVt.add(i);
            customersVt.add(i);
        }
        
        Dimension dim = dimension;
        final HintTextField customerName = new HintTextField(" Customer name", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 70), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField dateOrder = new HintTextField(" Date order", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 110), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField addressToDeliver = new HintTextField(" Address", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 150), new Dimension(dim.width - 40, 30), contenPane, false);
        final HintTextField price = new HintTextField(" Price", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField quantity = new HintTextField(" Quantity", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        
        final  CustomComboBox medinices = new CustomComboBox(medicinesVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),  new Point(20, 230), new Dimension((dim.width - 40) / 2 - 5, 30 ), contenPane);
        final  CustomComboBox measures = new CustomComboBox(measuresVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),  new Point(205, 230), new Dimension((dim.width - 40) / 2 - 5, 30 ), contenPane);
        final  CustomComboBox customers = new CustomComboBox(customersVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),  new Point(20, 270), new Dimension((dim.width - 40) / 2 - 5, 30 ), contenPane);
        final  CustomComboBox relationship = new CustomComboBox(relationshipVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),  new Point(205, 270), new Dimension((dim.width - 40) / 2 - 5, 30 ), contenPane);
       
        final CustomButton ok = new CustomButton("Save", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 320),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                
                String customerx = customerName.getText().toString();
                String datex = dateOrder.getText().toString();
                
                
                
                // ADD TO DB
                
                
                
                
                
                OrderNew.this.dispose();
            }
        });

        final CustomButton cancel = new CustomButton("Cancel", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 320),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                OrderNew.this.dispose();
            }
        });
    }

    
}
