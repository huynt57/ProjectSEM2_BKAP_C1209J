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

    private int measureCode;
    private int orderCode;

    private int customerCode;
    private String dateOrder;
    private int userCode;
    private String addressToDeliver;
    private float priceOrder;

    private int medicineCode;
    private String medicineName;
    private String medicineTypeName;
    private String measureName;
    private float pricePerUnit;
    private int quantity;

    /**
     * Creates a new instance of Orders
     */
    public Orders() {
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public float getpricePerUnit() {
        return pricePerUnit;
    }

    public void setpricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getmedicineCode() {
        return medicineCode;
    }

    public void setmedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getmedicineName() {
        return medicineName;
    }

    public void setmedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getmedicineTypeName() {
        return medicineTypeName;
    }

    public void setmedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }

    public int getmeasureCode() {
        return measureCode;
    }

    public void setmeasureCode(int measureCode) {
        this.measureCode = measureCode;
    }

    public String getmeasureName() {
        return measureName;
    }

    public void setmeasureName(String measureName) {
        this.measureName = measureName;
    }

    //-------------------------------------------------
    public int getOderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public int getcustomerCode() {
        return customerCode;
    }

    public void setcustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    //----------------------
    public int getuserCode() {
        return userCode;
    }

    public void setuserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getdateOrder() {
        return dateOrder;
    }

    public void setdateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getaddressToDeliver() {
        return addressToDeliver;
    }

    public void setaddressToDeliver(String addressToDeliver) {
        this.addressToDeliver = addressToDeliver;
    }

    public float getpriceOrder() {
        return priceOrder;
    }

    public void setpriceOrder(float priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Orders(int measureCode, int orderCode, int customerCode, String dateOrder, int userCode, String addressToDeliver, float priceOrder, int medicineCode, String medicineName, String medicineTypeName, String measureName, float pricePerUnit, int quantity) {
        this.measureCode = measureCode;
        this.orderCode = orderCode;
        this.customerCode = customerCode;
        this.dateOrder = dateOrder;
        this.userCode = userCode;
        this.addressToDeliver = addressToDeliver;
        this.priceOrder = priceOrder;
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        this.medicineTypeName = medicineTypeName;
        this.measureName = measureName;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public static void InsertOrder(String customer, String dateorder, String usercode, String address, String medicine, String measure, String quantity, String price) throws SQLException, ClassNotFoundException {
        try {
            Vector v = new Vector();
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            String sqlmeasure = "SELECT measureCode FROM Measure WHERE measureName = '" + measure + "'";
            ResultSet rsm = sta.executeQuery(sqlmeasure);

            int measurecode = 0;
            while (rsm.next()) {
                measurecode = rsm.getInt("measureCode");
            }

            String sqlmetype = "SELECT medicineCode FROM Medicine WHERE medicineName = '" + medicine + "'";
            ResultSet rsmetype = sta.executeQuery(sqlmetype);

            int medicinecode = 0;
            while (rsmetype.next()) {
                medicinecode = rsmetype.getInt("medicineCode");
            }

            String sqlcustomner = "SELECT customerCode FROM Customer WHERE customerName = '" + customer + "'";
            ResultSet rssupplier = sta.executeQuery(sqlcustomner);

            int customercode = 0;
            while (rssupplier.next()) {
                customercode = rssupplier.getInt("customerCode");
            }

            String sql1 = "INSERT INTO Orders VALUES ('" + customercode + "'," + dateorder + "," + usercode + ", '" + address + "')";
            sta.execute(sql1);
            String sql3 = "SELECT MAX (orderCode) AS orderCode  FROM Orders";

            ResultSet rs = sta.executeQuery(sql3);

            int code = 0;
            while (rs.next()) {
                code = rs.getInt("orderCode");
            }
            String sql2 = "INSERT INTO OrderDetails VALUES (" + code + "," + medicinecode + "," + measurecode + "," + quantity + ",'" + price + "')";

            // System.out.println("fcsdkjhf");
            sta.execute(sql2);
            System.out.println(sql2);
        } catch (SQLException ex) {

        }

    }

    public static void UpdateOrder(String customer, String dateorder, String usercode, String address, String medicine, String measure, String quantity, String price, String id) throws SQLException, ClassNotFoundException {
        try {
            Vector v = new Vector();
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            String sqlmeasure = "SELECT measureCode FROM Measure WHERE measureName = '" + measure + "'";
            ResultSet rsm = sta.executeQuery(sqlmeasure);

            int measurecode = 0;
            while (rsm.next()) {
                measurecode = rsm.getInt("measureCode");
            }

            String sqlmetype = "SELECT medicineCode FROM Medicine WHERE medicineName = '" + medicine + "'";
            ResultSet rsmetype = sta.executeQuery(sqlmetype);

            int medicinecode = 0;
            while (rsmetype.next()) {
                medicinecode = rsmetype.getInt("medicineCode");
            }

            String sqlcustomner = "SELECT customerCode FROM Customer WHERE customerName = '" + customer + "'";
            ResultSet rssupplier = sta.executeQuery(sqlcustomner);

            int customercode = 0;
            while (rssupplier.next()) {
                customercode = rssupplier.getInt("customerCode");
            }

            String sql1 = "UPDATE    Orders SET customerCode ='" + customercode + "', userCode ='" + usercode + "', dateOrder ='" + dateorder + "', addressToDeliver ='" + address + "', price ='" + price + "' WHERE orderCode = " + id;
            sta.execute(sql1);
//            String sql3 = "SELECT MAX (orderCode) AS orderCode  FROM Orders";
//
//            ResultSet rs = sta.executeQuery(sql3);
//
//            int code = 0;
//            while (rs.next()) {
//                code = rs.getInt("orderCode");
//            }
            String sql2 = "UPDATE    OrderDetails SET              orderCode ='" + id + "', medicineCode ='" + medicinecode + "', measureCode ='" + measurecode + "', quantity ='" + quantity + "'";

            // System.out.println("fcsdkjhf");
            sta.execute(sql2);
            System.out.println(sql2);
        } catch (SQLException ex) {

        }

    }

    public static Vector getAllOrder() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Orders join OrderDetails ON Orders.orderCode = OrderDetails.orderCode");
            while (rs.next()) {
                Orders objOrder = new Orders();
                objOrder.orderCode = rs.getInt("orderCode");
                objOrder.customerCode = rs.getInt("customerCode");
                objOrder.dateOrder = rs.getString("dateOrder");
                objOrder.addressToDeliver = rs.getString("addressToDeliver");
                objOrder.priceOrder = rs.getInt("price");
                v.add(objOrder);
            }
        } catch (SQLException ex) {

        }
        return v;
    }

    public static void DeleteOrder(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBHelper.connect();
        Statement sta = con.createStatement();

        sta.execute("DELETE FROM Orders WHERE orderCode = '" + id+"'");
        sta.execute("DELETE FROM OrderDetails WHERE orderCode = '" + id+"'");
    }

//    public static Vector viewOrder(String id) throws SQLException, ClassNotFoundException {
//        Vector v = new Vector();
//        try {
//            Connection con = DBHelper.connect();
//            Statement sta = con.createStatement();
//
//            ResultSet rs = sta.executeQuery("SELECT * FROM Order join OrderDetails ON Order.orderCode = OrderDetails.orderCode join Supplier ON Order.SupplierCode = Supplier.SupplierCode join OrderType ON Order.orderTypeCode = OrderType.orderTypeCode WHERE orderCode = " + id);
//            while (rs.next()) {
//                Orders objOrder = new Orders();
//                objOrder.orderCode = rs.getInt("orderCode");
//                objOrder.orderName = rs.getString("orderName");
//                objOrder.orderTypeName = rs.getString("orderTypeName");
//                objOrder.supplierName = rs.getString("supplierName");
//                objOrder.avaiableAmount = rs.getInt("avaiableAmount");
//                v.add(objOrder);
//            }
//        } catch (SQLException ex) {
//
//        }
//        return v;
//    }
}
