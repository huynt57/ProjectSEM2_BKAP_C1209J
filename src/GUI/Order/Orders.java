package GUI.Order;

import GUI.MeasureManager.Measures;
import GUI.MedicinesManager.Medicines;
import GUI.SupplierManager.Suppliers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import database.DBHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class Orders {

    private int orderCode;
    private String orderName;
    private int orderTypeCode;
    private int supplierCode;
    private String termsOfUse;
    private int measure;
    private float pricePerUnit;

    private int avaiableAmount;
    private String registerNumber;
    private String Origin;
    private String used;
    private String useGuide;

    private String orderTypeName;
    private String supplierName;
    private String measureName;

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(int orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public int getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(int supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public int getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
        this.measure = measure;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getAvaiableAmount() {
        return avaiableAmount;
    }

    public void setAvaiableAmount(int avaiableAmount) {
        this.avaiableAmount = avaiableAmount;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getUseGuide() {
        return useGuide;
    }

    public void setUseGuide(String useGuide) {
        this.useGuide = useGuide;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public Orders(int orderCode, String orderName, int orderTypeCode, int supplierCode, String termsOfUse, int measure, float pricePerUnit, int avaiableAmount, String registerNumber, String Origin, String used, String useGuide, String orderTypeName, String supplierName, String measureName) {
        this.orderCode = orderCode;
        this.orderName = orderName;
        this.orderTypeCode = orderTypeCode;
        this.supplierCode = supplierCode;
        this.termsOfUse = termsOfUse;
        this.measure = measure;
        this.pricePerUnit = pricePerUnit;
        this.avaiableAmount = avaiableAmount;
        this.registerNumber = registerNumber;
        this.Origin = Origin;
        this.used = used;
        this.useGuide = useGuide;
        this.orderTypeName = orderTypeName;
        this.supplierName = supplierName;
        this.measureName = measureName;
    }

    public Orders() {
    }

    public static void InsertOrder(String name, String supplier, String price, String termofuse, String num, String regnum, String used, String measure, String type, String origin, String guide) throws SQLException, ClassNotFoundException {
        try {
            Vector v = new Vector();
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            

            String sqlmeasure = "SELECT measureCode FROM Measure WHERE measureName = '" + measure+"'";
            ResultSet rsm = sta.executeQuery(sqlmeasure);

            int measurecode = 0;
            while (rsm.next()) {
                measurecode = rsm.getInt("measureCode");
            }

            String sqlmetype = "SELECT orderTypeCode FROM OrderType WHERE orderTypeName = '" + type+"'";
            ResultSet rsmetype = sta.executeQuery(sqlmetype);

            int ordertypecode = 0;
            while (rsmetype.next()) {
                ordertypecode = rsmetype.getInt("orderTypeCode");
            }

            String sqlsupplier = "SELECT supplierCode FROM Supplier WHERE supplierName = '" + supplier+"'";
            ResultSet rssupplier = sta.executeQuery(sqlsupplier);

            int suppliercode = 0;
            while (rssupplier.next()) {
                suppliercode = rssupplier.getInt("supplierCode");
            }
            
            String sql1 = "INSERT INTO Order VALUES ('" + name + "'," + ordertypecode + "," + suppliercode + ")";
            sta.execute(sql1);
            String sql3 = "SELECT MAX (orderCode) AS orderCode  FROM Order";

            ResultSet rs = sta.executeQuery(sql3);

            int code = 0;
            while (rs.next()) {
                code = rs.getInt("orderCode");
            }
            String sql2 = "INSERT INTO OrderDetails VALUES (" + code + "," + measurecode + "," + price + "," + num + ",'" + regnum + "','" + origin + "'," + used + ",'" + termofuse + "',	'" + guide + "')";
           
            System.out.println("fcsdkjhf");
            sta.execute(sql2);
            System.out.println(sql2);
        } catch (SQLException ex) {

        }

    }

    public static void UpdateOrder(String name, String supplier, String price, String termofuse, String num, String regnum, String used, String measure, String type, String origin, String guide, String id) throws SQLException, ClassNotFoundException {
        try {
            Vector v = new Vector();
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            String sql1 = "UPDATE Order VALUES ('" + name + "'," + type + "," + supplier + ") WHERE orderCode = " + id;
            sta.execute(sql1);
            String sql3 = "SELECT orderCode FROM Order WHERE orderName = '" + name + "'";
            ResultSet rs = sta.executeQuery(sql3);

            int code = 0;
            while (rs.next()) {
                code = rs.getInt("orderCode");
            }

            String sql2 = "UPDATE OrderDetails VALUES (" + code + "," + measure + "," + price + "," + num + "," + regnum + ",'" + origin + "',		" + used + "," + termofuse + ",		'" + guide + "') WHERE orderCode = " + id;
            sta.execute(sql2);

        } catch (SQLException ex) {

        }

    }

    public static Vector getAllOrder() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Order join OrderDetails ON Order.orderCode = OrderDetails.orderCode join Supplier ON Order.SupplierCode = Supplier.SupplierCode join OrderType ON Order.orderTypeCode = OrderType.orderTypeCode");
            while (rs.next()) {
                Orders objOrder = new Orders();
                objOrder.orderCode = rs.getInt("orderCode");
                objOrder.orderName = rs.getString("orderName");
                objOrder.orderTypeName = rs.getString("orderTypeName");
                objOrder.supplierName = rs.getString("supplierName");
                objOrder.avaiableAmount = rs.getInt("avaiableAmount");
                v.add(objOrder);
            }
        } catch (SQLException ex) {

        }
        return v;
    }

    public static void DeleteOrder(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBHelper.connect();
        Statement sta = con.createStatement();

        sta.execute("DELETE FROM Order WHERE orderCode = " + id);
        sta.execute("DELETE FROM OrderDetails WHERE orderCode = " + id);
    }

    public static Vector viewOrder(String id) throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Order join OrderDetails ON Order.orderCode = OrderDetails.orderCode join Supplier ON Order.SupplierCode = Supplier.SupplierCode join OrderType ON Order.orderTypeCode = OrderType.orderTypeCode WHERE orderCode = " + id);
            while (rs.next()) {
                Orders objOrder = new Orders();
                objOrder.orderCode = rs.getInt("orderCode");
                objOrder.orderName = rs.getString("orderName");
                objOrder.orderTypeName = rs.getString("orderTypeName");
                objOrder.supplierName = rs.getString("supplierName");
                objOrder.avaiableAmount = rs.getInt("avaiableAmount");
                v.add(objOrder);
            }
        } catch (SQLException ex) {

        }
        return v;
    }
}
