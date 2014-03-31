

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
import java.util.Vector;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class MedicineSearch extends CustomFrame {

    public static int searchtype;
    
    public MedicineSearch(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension ) {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
 
        Dimension dim = dimension;
        
         CustomLabel titleLabel = new CustomLabel("Search medicine",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 19),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
         
        final JRadioButton name = new JRadioButton("");
        name.setFont(CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13));
        name.setBounds(20, 70, 20, 20);
        name.setBackground(BackGround);
        contenPane.add(name);
        CustomLabel nameLabel = new CustomLabel("Name search",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point(50, 70), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        
        final JRadioButton type = new JRadioButton("");
        type.setFont(CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13));
        type.setBounds(20, 100, 20, 20);
        type.setBackground(BackGround);
        contenPane.add(type);
        CustomLabel typeLabel = new CustomLabel("Type search",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point(50, 100), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        
        final JRadioButton suppliername = new JRadioButton("");
        suppliername.setFont(CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13));
        suppliername.setBounds(20, 130, 20, 20);
        suppliername.setBackground(BackGround);
        contenPane.add(suppliername);
        CustomLabel supplierLabel = new CustomLabel("Supplier search",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13),
                new Point(50, 130), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
  
        final CustomButton ok = new CustomButton("Search", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(60, 170),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
 
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(name.isSelected()) searchtype = 1;
                if(type.isSelected()) searchtype = 2;
                if(suppliername.isSelected()) searchtype = 3;
                
                MedicineSearch.this.dispose();
            }
        });

        final CustomButton cancel = new CustomButton("Cancel", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 500),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MedicineSearch.this.dispose();
            }
        });
    }

}
