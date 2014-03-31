/*
 * Bills.java
 *
 
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package GUI.BillingHistoryManager;

import database.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author chiennv
 */
public class Bills {

    /**
     * Creates a new instance of Bills
     */
    private int billCode;
    private String billType;
    private int customerCode;
    private String addressToDeliver;
    private String dateStart;
    private String expiredTime;
    private float tax;
    private float price;
    private String status;
    private int userCode;

    private int medicineCode;
    private int measureCode;
    private int quantity;

    private float payedMoney;
    private String datePay;

    private String customerName;
    private String userName;
    private String relationship;

    public Bills() {
    }

    public int getmedicineCode() {
        return medicineCode;
    }

    public void setmedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public int getmeasureCode() {
        return measureCode;
    }

    public void setmeasureCode(int measureCode) {
        this.measureCode = measureCode;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    //-------------------------------
    public int getbillCode() {
        return billCode;
    }

    public void setbillCode(int billCode) {
        this.billCode = billCode;
    }

    //-------------------------------
    public int getcustomerCode() {
        return customerCode;
    }

    public void setcustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    //-------------------------------
    public String getaddressToDeliver() {
        return addressToDeliver;
    }

    public void setaddressToDeliver(String addressToDeliver) {
        this.addressToDeliver = addressToDeliver;
    }

    //-------------------------------
    public String getdateStart() {
        return dateStart;
    }

    public void setdateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    //-------------------------------
    public String getexpiredTime() {
        return expiredTime;
    }

    public void setexpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }

    //-------------------------------
    public float gettax() {
        return tax;
    }

    public void settax(float tax) {
        this.tax = tax;
    }

    //-------------------------------
    public float getprice() {
        return price;
    }

    public void setprice(float price) {
        this.price = price;
    }

    //-------------------------------
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    //-------------------------------
    public int getuserCode() {
        return userCode;
    }

    public void setuserCode(int userCode) {
        this.userCode = userCode;
    }

    //------------
    //-------------------------------
    public String getbillType() {
        return billType;
    }

    public void setbillType(String billType) {
        this.billType = billType;
    }

    public float getpayedMoney() {
        return payedMoney;
    }

    public void setpayedMoney(float payedMoney) {
        this.payedMoney = payedMoney;
    }

    public String getdatePay() {
        return datePay;
    }

    public void setdatePay(String datePay) {
        this.datePay = datePay;
    }

    public String getcustomerName() {
        return customerName;
    }

    public void setcustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getrelationship() {
        return relationship;
    }

    public void setrelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public static Vector getAllBill() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Bill join BillDetails ON Bill.billCode = BillDetails.billCode");

            while (rs.next()) {
                Bills objCustomer = new Bills();
                objCustomer.billCode = rs.getInt("customerCode");
                objCustomer.addressToDeliver = rs.getString("addressToDeliver");
                objCustomer.billType = rs.getString("billType");
                objCustomer.customerCode = rs.getInt("customerCode");
                objCustomer.price = rs.getInt("price");
                objCustomer.status = rs.getString("status");

                v.add(objCustomer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public static void insertBill() throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.execute("INSERT INTO Bill (billType, customerCode, addressToDeliver, dateStart, expiredTime, tax, price, status, userCode) VALUES     ('import',4,'hanoi',1/1/2014,2/1/2014,1,100,1,1)");
            String sql3 = "SELECT MAX (billCode) AS billCode FROM Bill";

            ResultSet rs = sta.executeQuery(sql3);

            int code = 0;
            while (rs.next()) {
                code = rs.getInt("billCode");
            }
            sta.execute("INSERT INTO BillDetails (billCode, medicineCode, measureCode, quantity) VALUES     ('" + code + "','47','1','100')");

        } catch (SQLException ex) {
        }

    }

    public static void deleteBill(String id) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.execute("DELETE FROM Bill WHERE billCode = " + id);
            sta.execute("DELETE FROM BillDetails WHERE billCode = " + id);

        } catch (SQLException ex) {
        }

    }
}
