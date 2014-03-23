package GUI.Classes;

import GUI.MedicinesManager.AddFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CustomDialog extends CustomFrame {

    public CustomDialog(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dim, ActionListener okAction) {
        super(title, visible, undecorate, resizeable, dim);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.GRAY;
        contenPane.setBackground(Color.getHSBColor(20, 12, 21));
        this.setContentPane(contenPane);
        setLocationRelativeTo(null);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel(title,
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 10), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final CustomButton ok = new CustomButton("Yes", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 50),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        ok.addActionListener(okAction);

        final CustomButton cancel = new CustomButton("No", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 50),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CustomDialog.this.dispose();
            }
        });

        
    }

}
