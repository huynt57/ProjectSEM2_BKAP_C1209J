package GUI.MainScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.AccountManager.AccountPanel;
import GUI.BillingHistoryManager.BillingHistoryPanel;
import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.RemovablePanel;
import GUI.Classes.SwitchPaneThread;
import GUI.CustomersManager.CustomersPanel;
import GUI.MedicinesManager.MedicinesPanel;
import java.sql.SQLException;
import GUI.MeasureManager.MeasurePanel;
import GUI.MedicineTypeManager.MedicineTypePanel;
import GUI.Order.OrderPanel;
import GUI.Report.ReportPanel;
import GUI.SupplierManager.SuppliersPanel;
import GUI.UserManager.UserManagerPanel;

class TimeThread extends Thread {

    CustomLabel dateTime;

    public TimeThread(CustomLabel dateTime) {
        super();
        this.dateTime = dateTime;
    }

    @Override
    public void run() {
        while (1 == 1) {
            dateTime.setText(MainPanel.getDate());
        }
    }
}

public class MainPanel extends RemovablePanel {

    public CustomFrame parentFrame;
    public Dimension dimension;
    public Color leftPanelColor = Color.GRAY;
    public Color rightPanelColor = Color.GRAY;
    public int leftPanelWidth = 200;

    public MainPanel(final CustomFrame parentFrame, Dimension dimension) throws ClassNotFoundException, SQLException {
        super(parentFrame);

        this.dimension = Configure.DEFAULT_SIZE;
        setLayout(null);
        parentFrame.setSize(Configure.DEFAULT_SIZE);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(leftPanelColor);
        leftPanel.setBounds(0, 0, leftPanelWidth, dimension.height);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(rightPanelColor);
        rightPanel.setBounds(leftPanelWidth, 0, dimension.width - leftPanelWidth, dimension.height);


//		TimeThread dateTimeThread = new TimeThread(new CustomLabel(getDate(), Color.WHITE,
//				leftPanelColor, CustomFont.getFont(Configure.DEFAULT_FONT, Font.BOLD, 11),
//				new Point(0, 13), new Dimension(leftPanelWidth, 30), true,
//				SwingConstants.CENTER, SwingConstants.CENTER, leftPanel));
//		dateTimeThread.start();

        CustomButton close = new CustomButton(new ImageIcon(
                "src/GUI/Resources/Closes.bin"), "", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 10),
                false, false, rightPanelColor, true, new Point(
                dimension.width - 227, 0), new Dimension(20, 20),
                rightPanel, SwingConstants.CENTER, SwingConstants.CENTER);
        close.setRolloverIcon(new ImageIcon(
                "src/GUI/Resources/CloseRollover.bin"));

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        CustomButton minimize = new CustomButton(new ImageIcon(
                "src/GUI/Resources/Minimize.bin"), "", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 10),
                false, false, rightPanelColor, true, new Point(
                dimension.width - 247, 0), new Dimension(20, 20),
                rightPanel, SwingConstants.CENTER, SwingConstants.CENTER);
        minimize.setRolloverIcon(new ImageIcon(
                "src/GUI/Resources/MinimizeRollover.bin"));

        minimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.setState(parentFrame.ICONIFIED);
            }
        });

        final AccountPanel accountManager = new AccountPanel(this, rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        accountManager.setBackground(Color.WHITE);
        accountManager.setVisible(false);

        final MedicinesPanel medicinesManager = new MedicinesPanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        medicinesManager.setBackground(Color.WHITE);
        medicinesManager.setVisible(true);

        final CustomersPanel customersManager = new CustomersPanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        customersManager.setBackground(Color.WHITE);
        customersManager.setVisible(false);

        final SuppliersPanel suppliersManager = new SuppliersPanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        suppliersManager.setBackground(Color.WHITE);
        suppliersManager.setVisible(false);


        final MeasurePanel measureManager = new MeasurePanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        measureManager.setBackground(Color.WHITE);
        measureManager.setVisible(false);

        final MedicineTypePanel medicinetypeManager = new MedicineTypePanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        medicinetypeManager.setBackground(Color.WHITE);
        medicinetypeManager.setVisible(false);
        
        final UserManagerPanel userManagerManager = new UserManagerPanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        userManagerManager.setBackground(Color.WHITE);
        userManagerManager.setVisible(false);
        
         final OrderPanel orderManager = new OrderPanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        orderManager.setBackground(Color.WHITE);
        orderManager.setVisible(false);
        
        final ReportPanel reportPanel = new ReportPanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        reportPanel.setBackground(Color.WHITE);
        reportPanel.setVisible(false);


        final BillingHistoryPanel billingHistoryManager = new BillingHistoryPanel(rightPanel, new Point(0, 20), new Dimension(rightPanel.getWidth() - 10, rightPanel.getHeight() - 50));
        billingHistoryManager.setBackground(Color.WHITE);
        billingHistoryManager.setVisible(false);

        leftPanel.setLayout(null);
        leftPanel.setBackground(leftPanelColor);
        leftPanel.setBounds(0, 0, leftPanelWidth, dimension.height);

        ImageIcon avatarIcon = new ImageIcon("src/GUI/Resources/avatar.bin");
        CustomLabel avatar = new CustomLabel(avatarIcon, new Point(leftPanelWidth - 65, 25), new Dimension(40, 40), true, leftPanel);

        CustomLabel lastName = new CustomLabel("Rosen", Color.WHITE,
                leftPanelColor, CustomFont.getFont(Configure.DEFAULT_FONT,
                Font.PLAIN, 18), new Point(20, 20), new Dimension(leftPanelWidth - 95,
                30), true, SwingConstants.RIGHT,
                SwingConstants.CENTER, leftPanel);

        CustomLabel firstName = new CustomLabel("Kenneth Suzuki", Color.WHITE,
                leftPanelColor, CustomFont.getFont(Configure.DEFAULT_FONT,
                Font.PLAIN, 13), new Point(20, 40), new Dimension(leftPanelWidth - 95,
                30), true, SwingConstants.RIGHT,
                SwingConstants.CENTER, leftPanel);

        int numberOfTab = 11;
        int step = 40;
        int begin = (dimension.height - numberOfTab * step) / 2 + 10;
        int i = 0;

        final CustomButton medicines = new CustomButton("Medicines", leftPanelColor,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                Color.WHITE, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);


        final CustomButton customers = new CustomButton("Customers", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        final CustomButton suppliers = new CustomButton("Suppliers", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        final CustomButton measure = new CustomButton("Measure", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        final CustomButton medicinetype = new CustomButton("Medicine Type", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        final CustomButton billingHistory = new CustomButton("Bill", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        final CustomButton order = new CustomButton("Order", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
         final CustomButton report = new CustomButton("Report", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        final CustomButton account = new CustomButton("My Account", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        final CustomButton userManager = new CustomButton("User Manager", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 20), false, false,
                leftPanelColor, true, new Point(0, begin + step * (i++)),
                new Dimension(leftPanelWidth, 40), leftPanel);
        JPanel progressPanel = new JPanel();
        progressPanel.setBounds(leftPanelWidth, 550, dimension.width - leftPanelWidth - 10, 40);
        progressPanel.setBackground(Configure.DEFAULT_RIGHT_PANEL_COLOR);
        ImageIcon progressIcon = new ImageIcon("src/GUI/Resources/progress.bin");
        final CustomLabel progress = new CustomLabel(progressIcon, new Point(0, 0), new Dimension(dimension.width - leftPanelWidth - 20, 40), false, progressPanel);
        MainPanel.this.add(progressPanel);

        medicines.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(medicines, account, customers, suppliers,report, userManager, order, measure, medicinetype, billingHistory);
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, medicinesManager, reportPanel,customersManager, billingHistoryManager, accountManager, suppliersManager, measureManager, medicinetypeManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();

            }
        });

        customers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(customers, account, medicines, suppliers,report,userManager, order, measure, medicinetype, billingHistory);
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, customersManager,reportPanel, medicinesManager, billingHistoryManager, accountManager, suppliersManager, measureManager, medicinetypeManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });

        suppliers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(suppliers, account, medicines, userManager, report,order, customers, measure, medicinetype, billingHistory);
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, suppliersManager,reportPanel, medicinesManager, customersManager, billingHistoryManager, accountManager, measureManager, medicinetypeManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });

        measure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(measure, account, medicines, userManager,report, order, customers, suppliers, medicinetype, billingHistory);
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, measureManager, reportPanel,medicinesManager, customersManager, billingHistoryManager, accountManager, suppliersManager, medicinetypeManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });

        medicinetype.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(medicinetype, account, medicines, report,userManager, order, customers, suppliers, measure, billingHistory);
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, medicinetypeManager,reportPanel, medicinesManager, customersManager, billingHistoryManager, accountManager, suppliersManager, measureManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });

        billingHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(billingHistory, account, medicines,report, userManager, order, customers, suppliers, measure, medicinetype);
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, billingHistoryManager,reportPanel, medicinesManager, customersManager, accountManager, suppliersManager, measureManager, medicinetypeManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });

        account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(account, medicines, customers,report, suppliers, measure, medicinetype, billingHistory, userManager, order );
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, accountManager,reportPanel, medicinesManager, customersManager, billingHistoryManager, suppliersManager, measureManager, medicinetypeManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });
        
         report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(report, account, medicines, customers, suppliers, measure, medicinetype, billingHistory, userManager, order );
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, reportPanel,accountManager, medicinesManager, customersManager, billingHistoryManager, suppliersManager, measureManager, medicinetypeManager, orderManager, userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });
        
        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(order, account, medicines, customers,report, suppliers, measure, medicinetype, billingHistory, userManager );
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, orderManager,reportPanel, accountManager, medicinesManager, customersManager, billingHistoryManager, suppliersManager, measureManager, medicinetypeManager,  userManagerManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });
        
        userManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(userManager, account, medicines, customers, report,suppliers, measure, medicinetype, billingHistory, order );
                parentFrame.setSize(Configure.DEFAULT_SIZE);
                SwitchPaneThread switchPane = new SwitchPaneThread(progress, reportPanel,  userManagerManager, accountManager, medicinesManager, customersManager, billingHistoryManager, suppliersManager, measureManager, medicinetypeManager, orderManager);
                progress.setVisible(true);
                switchPane.start();
            }
        });


        final ImageIcon image = new ImageIcon("src/GUI/Resources/msb.bin");
        final CustomLabel logo = new CustomLabel(image, new Point(25, 513),
                new Dimension(image.getIconWidth(), image.getIconHeight()),
                true, leftPanel);

        final CustomLabel appName = new CustomLabel("Medical Store Billing",
                Color.WHITE, Configure.LOGIN_SCREEN_COLOR, CustomFont.getFont(
                Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(0,
                563), new Dimension(leftPanelWidth, 20), true,
                SwingConstants.CENTER, SwingConstants.CENTER, leftPanel);

        this.add(leftPanel);


        ImageIcon closeIcon = new ImageIcon("src/GUI/Resources/close.bin");
        JButton closes = new JButton(closeIcon);
        closes.setRolloverIcon(new ImageIcon("src/GUI/Resources/closeRollover.bin"));
        closes.setBackground(rightPanelColor);
        closes.setFocusPainted(false);
        closes.setBorderPainted(false);


        closes.setBounds(leftPanelWidth + 5, 5, closeIcon.getIconWidth(), closeIcon.getIconHeight());
        closes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                parentFrame.setSize(Configure.MINIMIZE_SIZE);
                changeState(account, medicines, customers, suppliers, measure, medicinetype, billingHistory, order, userManager, report);
                medicines.setBackground(leftPanelColor);
                medicines.setForeground(Color.WHITE);
                medicines.setEnabled(true);
            }
        });
        MainPanel.this.add(closes);
        this.add(rightPanel);

    }

    public void changeState(JButton bt1, JButton bt2, JButton bt3, JButton bt4, JButton bt5, JButton bt6, JButton bt7, JButton bt8, JButton bt9, JButton bt10) {
        bt1.setBackground(Color.WHITE);
        bt1.setForeground(leftPanelColor);
        bt1.setEnabled(false);
        bt2.setBackground(leftPanelColor);
        bt2.setForeground(Color.WHITE);
        bt2.setEnabled(true);
        bt3.setBackground(leftPanelColor);
        bt3.setForeground(Color.WHITE);
        bt3.setEnabled(true);
        bt4.setBackground(leftPanelColor);
        bt4.setForeground(Color.WHITE);
        bt4.setEnabled(true);
        bt5.setBackground(leftPanelColor);
        bt5.setForeground(Color.WHITE);
        bt5.setEnabled(true);
        bt6.setBackground(leftPanelColor);
        bt6.setForeground(Color.WHITE);
        bt6.setEnabled(true);
        bt7.setBackground(leftPanelColor);
        bt7.setForeground(Color.WHITE);
        bt7.setEnabled(true);
        bt8.setBackground(leftPanelColor);
        bt8.setForeground(Color.WHITE);
        bt8.setEnabled(true);
        bt9.setBackground(leftPanelColor);
        bt9.setForeground(Color.WHITE);
        bt9.setEnabled(true);
        bt10.setBackground(leftPanelColor);
        bt10.setForeground(Color.WHITE);
        bt10.setEnabled(true);
    }

    public static String getDate() {
        String year = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        String month = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        String date = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        String ss = new SimpleDateFormat("ss").format(Calendar.getInstance().getTime());
        String hh = new SimpleDateFormat("hh").format(Calendar.getInstance().getTime());
        String mm = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
        if (month.equals("01")) {
            month = "Jan";
        } else if (month.equals("02")) {
            month = "Feb";
        } else if (month.equals("03")) {
            month = "Mar";
        } else if (month.equals("04")) {
            month = "Apr";
        } else if (month.equals("05")) {
            month = "May";
        } else if (month.equals("06")) {
            month = "Jun";
        } else if (month.equals("07")) {
            month = "July";
        } else if (month.equals("08")) {
            month = "Aug";
        } else if (month.equals("09")) {
            month = "Sep";
        } else if (month.equals("10")) {
            month = "Oct";
        } else if (month.equals("11")) {
            month = "Nov";
        } else if (month.equals("12")) {
            month = "Dec";
        }
        String dateTime = hh + ":" + mm + ":" + ss + "  -  " + month + " " + date + " " + year;
        return dateTime;
    }
}
