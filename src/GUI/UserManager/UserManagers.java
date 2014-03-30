
package GUI.UserManager;

import database.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class UserManagers {

    private int customerCode;
    private String customerName;
    private String customerType;
    private String customerPhone;
    private String customerFax;
    private String customerEmail;
    private String customerAddress;
    private String customerRelationship;

    public int getUserManagerCode() {
        return customerCode;
    }

    public void setUserManagerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getUserManagerName() {
        return customerName;
    }

    public void setUserManagerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUserManagerType() {
        return customerType;
    }

    public void setUserManagerType(String customerType) {
        this.customerType = customerType;
    }

    public String getUserManagerPhone() {
        return customerPhone;
    }

    public void setUserManagerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUserManagerFax() {
        return customerFax;
    }

    public void setUserManagerFax(String customerFax) {
        this.customerFax = customerFax;
    }

    public String getUserManagerEmail() {
        return customerEmail;
    }

    public void setUserManagerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getUserManagerAddress() {
        return customerAddress;
    }

    public void setUserManagerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getUserManagerRelationship() {
        return customerRelationship;
    }

    public void setUserManagerRelationship(String customerRelationship) {
        this.customerRelationship = customerRelationship;
    }

    public UserManagers(int customerCode, String customerName, String customerType, String customerPhone, String customerFax, String customerEmail, String customerAddress, String customerRelationship) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerType = customerType;
        this.customerPhone = customerPhone;
        this.customerFax = customerFax;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerRelationship = customerRelationship;
    }

    public UserManagers() {
    }

    public static Vector getAllUserManager() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Customer");

            while (rs.next()) {
                UserManagers objUserManager = new UserManagers();
                objUserManager.customerCode = rs.getInt("customerCode");
                objUserManager.customerName = rs.getString("customerName");
                objUserManager.customerType = rs.getString("customerType");
                objUserManager.customerPhone = rs.getString("customerPhone");
                objUserManager.customerAddress = rs.getString("customerAddress");
                v.add(objUserManager);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public static Vector viewUserManager(String id) throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM UserManager WHERE customerCode = " + id);

            while (rs.next()) {
                UserManagers objUserManager = new UserManagers();
                objUserManager.customerCode = rs.getInt("customerCode");
                objUserManager.customerName = rs.getString("customerName");
                objUserManager.customerType = rs.getString("customerType");
                objUserManager.customerPhone = rs.getString("customerPhone");

                objUserManager.customerAddress = rs.getString("customerAddress");

                v.add(objUserManager);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public static void DeleteUserManager(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBHelper.connect();
        Statement sta = con.createStatement();

        sta.execute("DELETE FROM UserManager WHERE customerCode = " + id);
    }

    public static void insertUserManager(String name, String type, String phone, String fax, String email, String address, String rel) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("INSERT INTO UserManager VALUES ('" + name + "','" + type + "'," + phone + "','" + fax + "','" + email + "','" + address + "','" + rel + "')");

        } catch (SQLException ex) {
        }

    }

    public static void editUserManager(String name, String type, String phone, String fax, String email, String address, String rel, String id) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("Update UserManager VALUES ('" + name + "','" + type + "'," + phone + "','" + fax + "','" + email + "','" + address + "','" + rel + "') WHERE customerCode = " + id);

        } catch (SQLException ex) {
        }

    }

}
