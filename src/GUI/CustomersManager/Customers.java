package GUI.CustomersManager;

import database.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Customers {

    private int customerCode;
    private String customerName;
    private String customerType;
    private String customerPhone;
    private String customerFax;
    private String customerEmail;
    private String customerAddress;
    private String customerRelationship;

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerFax() {
        return customerFax;
    }

    public void setCustomerFax(String customerFax) {
        this.customerFax = customerFax;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerRelationship() {
        return customerRelationship;
    }

    public void setCustomerRelationship(String customerRelationship) {
        this.customerRelationship = customerRelationship;
    }

    public Customers(int customerCode, String customerName, String customerType, String customerPhone, String customerFax, String customerEmail, String customerAddress, String customerRelationship) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerType = customerType;
        this.customerPhone = customerPhone;
        this.customerFax = customerFax;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerRelationship = customerRelationship;
    }

    public Customers() {
    }

    public static Vector getAllCustomer() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Customer");

            while (rs.next()) {
                Customers objCustomer = new Customers();
                objCustomer.customerCode = rs.getInt("customerCode");
                objCustomer.customerName = rs.getString("customerName");
                objCustomer.customerType = rs.getString("customerType");
                objCustomer.customerPhone = rs.getString("customerPhone");
                objCustomer.customerAddress = rs.getString("customerAddress");
                v.add(objCustomer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public static Customers viewCustomer(String id) throws SQLException, ClassNotFoundException {
        Customers objCustomer = new Customers();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Customer WHERE customerCode = " + id);

            while (rs.next()) {

                objCustomer.customerCode = rs.getInt("customerCode");
                objCustomer.customerName = rs.getString("customerName");
                objCustomer.customerType = rs.getString("customerType");
                objCustomer.customerPhone = rs.getString("customerPhone");
                objCustomer.customerEmail = rs.getString("customerEmail");
                objCustomer.customerFax = rs.getString("customerFax");
                objCustomer.customerRelationship = rs.getString("customerRelationship");
                objCustomer.customerAddress = rs.getString("customerAddress");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objCustomer;
    }

    public static void DeleteCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBHelper.connect();
        Statement sta = con.createStatement();
        sta.execute("DELETE FROM Orders WHERE customerCode = " + id);
        sta.execute("DELETE FROM Customer WHERE customerCode = " + id);
    }

    public static void insertCustomer(String name, String type, String phone, String fax, String email, String address, String rel) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeUpdate("INSERT INTO Customer VALUES ('" + name + "','" + type + "','" + phone + "','" + fax + "','" + email + "','" + address + "','" + rel + "')");

        } catch (SQLException ex) {
        }

    }

    public static void editCustomer(String name, String type, String phone, String fax, String email, String address, String rel, String id) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            String sql = "UPDATE    Customer SET              customerName ='" + name + "', customerType ='" + type + "', customerPhone ='" + phone + "', customerFax ='" + fax + "', customerEmail ='" + email + "', customerAddress ='" + address + "', customerRelationship ='" + rel + "' WHERE customerCode = '" + id + "'";
            sta.executeUpdate(sql);

        } catch (SQLException ex) {
        }

    }

}
