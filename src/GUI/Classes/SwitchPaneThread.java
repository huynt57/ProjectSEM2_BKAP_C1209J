package GUI.Classes;

import GUI.AccountManager.AccountPanel;
import GUI.BillingHistoryManager.BillingHistoryPanel;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.CustomersManager.CustomersPanel;
import GUI.MeasureManager.MeasurePanel;
import GUI.MedicineTypeManager.MedicineTypePanel;
import GUI.MedicinesManager.MedicinesPanel;
import GUI.SupplierManager.SuppliersPanel;

public class SwitchPaneThread extends Thread {

    public CustomLabel progress;
    public JPanel newPane;
    public JPanel p1;
    public JPanel p2;
    public JPanel p3;
    public JPanel p4;
    public JPanel p5;
    public JPanel p6;
      //  public JPanel p7;

    public SwitchPaneThread(CustomLabel progress, JPanel newPane, JPanel p1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6) {
        super();
        this.progress = progress;
        this.newPane = newPane;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
    }

    @Override
    public void run() {
        super.run();
        try {
            this.sleep(2000);
            progress.setVisible(false);
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            // p7.setVisible(false);
            newPane.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
