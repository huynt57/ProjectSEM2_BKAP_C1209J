package GUI.Report;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportPanel extends JPanel {

    public ReportPanel(JPanel parentPanel, Point pos, Dimension d) throws SQLException, ClassNotFoundException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setLayout(null);
        parentPanel.add(this);
        
        CustomLabel titleLabel = new CustomLabel("Report",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 20), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, ReportPanel.this);

      
        HintTextField search = new HintTextField(" Search report", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 12), new Point(d.width - 280, 80), new Dimension(200, 30), ReportPanel.this, false);
        CustomButton searchButton = new CustomButton(new ImageIcon("src/GUI/Resources/search.png"), "", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), false, false, Color.GRAY, true, new Point(d.width - 72, 80), new Dimension(40, 30), ReportPanel.this, SwingConstants.CENTER, SwingConstants.CENTER);

        int totalWidth = d.width - 118;
        final int billTypeSize = totalWidth / 6 ;
        final int customerNameSize = totalWidth / 6;
        final int relationshipSize = totalWidth / 6 + 10 ;
        final int creatorSize = totalWidth / 6;
        final int priceSize = totalWidth / 6 ;
        final int statusSize = totalWidth / 6 - 13 ;
        final int idSize = 50;
        Color BACK_GROUND = Color.GRAY;

        CustomButton id = new CustomButton("ID", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40, 120), new Dimension(idSize, 30), ReportPanel.this);
        CustomButton customerName = new CustomButton("Customer", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + idSize, 120), new Dimension(customerNameSize, 30), ReportPanel.this);
        CustomButton billType = new CustomButton("Billtype", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + customerNameSize + idSize, 120), new Dimension(billTypeSize, 30), ReportPanel.this);
        CustomButton relationship = new CustomButton("Relationship", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + customerNameSize + billTypeSize + idSize, 120), new Dimension(relationshipSize, 30), ReportPanel.this);
        CustomButton creator = new CustomButton("Creator", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + customerNameSize +  billTypeSize + relationshipSize + idSize, 120), new Dimension(creatorSize, 30), ReportPanel.this);
        CustomButton price = new CustomButton("Price", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + customerNameSize + creatorSize + billTypeSize + relationshipSize + idSize, 120), new Dimension(priceSize, 30), ReportPanel.this);
        CustomButton status = new CustomButton("Status", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15), false, false, BACK_GROUND, true, new Point(40 + customerNameSize + relationshipSize + creatorSize + billTypeSize +priceSize + idSize, 120), new Dimension(statusSize, 30), ReportPanel.this);

        final CustomTable table = new CustomTable(new Point(40, 150), new Dimension(d.width - 40, d.height - 40), ReportPanel.this);
        JScrollPane x = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        x.setBounds(40, 150, d.width - 70, d.height - 170);
        this.add(x);
        

        final ArrayList<Report> reports = new ArrayList<Report>();
//        for(int i=0; i<=20; i++)
//        reports.add(new Report(i+"", i+"", i+"", i+"", i+"", i+"", i+""));
        Vector<Reports> loadReport = Reports.getAllReport();

       final ArrayList<ReportPanel.Report> customers = new ArrayList<ReportPanel.Report>();
       for(int i=0; i<loadReport.size(); i++) customers.add(new Report(loadReport.get(i).getbillCode()+ "", loadReport.get(i).getcustomerCode()+"", loadReport.get(i).getbillType()+ "", loadReport.get(i).getrelationship(), loadReport.get(i).getuserCode()+"",loadReport.get(i).getprice()+"",loadReport.get(i).getstatus()) );   
        table.setPreferredSize(new Dimension(1000, reports.size() * 40));	
        for(int i=0; i<reports.size(); i++)
        table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
        table.repaint();
   
        customerName.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<reports.size()-1; i++)
                            for(int j=i+1; j<reports.size(); j++) 
                                if(customerNameSort) {
                                    if(reports.get(i).customerName.compareTo(reports.get(j).customerName) < 0) {
                                        swap(reports, i, j);
                                    } 
                                } else {
                                    if(reports.get(i).customerName.compareTo(reports.get(j).customerName) > 0) {
                                       swap(reports, i, j);
                                    } 
                                }      
                        customerNameSort = !customerNameSort;
                        table.removeAll();
                        ReportRow.white = true;
                        for(int i=0; i<reports.size(); i++)
                	table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        id.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<reports.size()-1; i++)
                            for(int j=i+1; j<reports.size(); j++) 
                                if(customerNameSort) {
                                    if(reports.get(i).id.compareTo(reports.get(j).id) < 0) {
                                        swap(reports, i, j);
                                    } 
                                } else {
                                    if(reports.get(i).id.compareTo(reports.get(j).id) > 0) {
                                       swap(reports, i, j);
                                    } 
                                }      
                        customerNameSort = !customerNameSort;
                        table.removeAll();
                        ReportRow.white = true;
                        for(int i=0; i<reports.size(); i++)
                	table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        billType.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<reports.size()-1; i++)
                            for(int j=i+1; j<reports.size(); j++) 
                                if(customerNameSort) {
                                    if(reports.get(i).billType.compareTo(reports.get(j).billType) < 0) {
                                        swap(reports, i, j);
                                    } 
                                } else {
                                    if(reports.get(i).billType.compareTo(reports.get(j).billType) > 0) {
                                       swap(reports, i, j);
                                    } 
                                }      
                        customerNameSort = !customerNameSort;
                        table.removeAll();
                        ReportRow.white = true;
                       for(int i=0; i<reports.size(); i++)
                	table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        relationship.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<reports.size()-1; i++)
                            for(int j=i+1; j<reports.size(); j++) 
                                if(customerNameSort) {
                                    if(reports.get(i).relationship.compareTo(reports.get(j).relationship) < 0) {
                                        swap(reports, i, j);
                                    } 
                                } else {
                                    if(reports.get(i).relationship.compareTo(reports.get(j).relationship) > 0) {
                                       swap(reports, i, j);
                                    } 
                                }      
                        customerNameSort = !customerNameSort;
                        table.removeAll();
                        ReportRow.white = true;
                      for(int i=0; i<reports.size(); i++)
                	table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        price.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<reports.size()-1; i++)
                            for(int j=i+1; j<reports.size(); j++) 
                                if(customerNameSort) {
                                    if(reports.get(i).price.compareTo(reports.get(j).creator) < 0) {
                                        swap(reports, i, j);
                                    } 
                                } else {
                                    if(reports.get(i).price.compareTo(reports.get(j).creator) > 0) {
                                       swap(reports, i, j);
                                    } 
                                }      
                        customerNameSort = !customerNameSort;
                        table.removeAll();
                        ReportRow.white = true;
                        for(int i=0; i<reports.size(); i++)
                	table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        creator.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<reports.size()-1; i++)
                            for(int j=i+1; j<reports.size(); j++) 
                                if(customerNameSort) {
                                    if(reports.get(i).creator.compareTo(reports.get(j).creator) < 0) {
                                        swap(reports, i, j);
                                    } 
                                } else {
                                    if(reports.get(i).creator.compareTo(reports.get(j).creator) > 0) {
                                       swap(reports, i, j);
                                    } 
                                }      
                        customerNameSort = !customerNameSort;
                        table.removeAll();
                        ReportRow.white = true;
                        for(int i=0; i<reports.size(); i++)
                	table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
        status.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        for(int i=0; i<reports.size()-1; i++)
                            for(int j=i+1; j<reports.size(); j++) 
                                if(customerNameSort) {
                                    if(reports.get(i).status.compareTo(reports.get(j).status) < 0) {
                                        swap(reports, i, j);
                                    } 
                                } else {
                                    if(reports.get(i).status.compareTo(reports.get(j).status) > 0) {
                                       swap(reports, i, j);
                                    } 
                                }      
                        customerNameSort = !customerNameSort;
                        table.removeAll();
                        ReportRow.white = true;
                        for(int i=0; i<reports.size(); i++)
                	table.add(new ReportRow(reports.get(i).id, reports.get(i).customerName, reports.get(i).billType, reports.get(i).relationship, reports.get(i).creator, reports.get(i).creator, reports.get(i).status, idSize, customerNameSize, billTypeSize, relationshipSize, creatorSize , creatorSize, statusSize, new Point(0, i * 40), table));
                        table.repaint();
                    }
                });
      
    }

        public static boolean customerNameSort = true;
    
   
        public void swap(ArrayList<ReportPanel.Report> reports, int i, int j) {
            ReportPanel.Report temp = new ReportPanel.Report(reports.get(i).id,reports.get(i).customerName,reports.get(i).billType,reports.get(i).relationship,reports.get(i).creator,reports.get(i).price,reports.get(i).status );
            reports.get(i).id = reports.get(j).id;
            reports.get(i).customerName = reports.get(j).customerName;
            reports.get(i).billType = reports.get(j).billType;
            reports.get(i).relationship = reports.get(j).relationship;
            reports.get(i).creator = reports.get(j).creator;
            reports.get(i).price = reports.get(j).price;
            reports.get(i).status = reports.get(j).status;
            reports.get(j).id = temp.id;
            reports.get(j).customerName = temp.customerName;
            reports.get(j).billType = temp.billType;
            reports.get(j).relationship = temp.relationship;
            reports.get(j).creator = temp.creator;
            reports.get(j).price= temp.price;
            reports.get(j).status = temp.status;

                        
        }
    public class Report {

       String id;
       String customerName;
       String billType;
       String relationship;
       String creator;
       String price;
       String status;
        public Report(String id, String customerName, String billType, String relationship, String price, String creator, String status) {
            this.id = id;
            this.customerName = customerName;
            this.billType = billType;
            this.relationship = relationship;
            this.creator = creator;
            this.price = creator;
            this.status = status;
        }
 
    }
}
