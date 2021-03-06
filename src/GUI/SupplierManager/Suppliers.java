/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.SupplierManager;

import database.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Suppliers {

    private int supplierCode;
    private String supplierName;
    private String supplierfullName;
    private String supplierAddress;
    private String supplierPhone;
    private String supplierFax;
    private String supplierEmail;
    private String supplierWebsite;

    public int getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(int supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierfullName() {
        return supplierfullName;
    }

    public void setSupplierfullName(String supplierfullName) {
        this.supplierfullName = supplierfullName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierFax() {
        return supplierFax;
    }

    public void setSupplierFax(String supplierFax) {
        this.supplierFax = supplierFax;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierWebsite() {
        return supplierWebsite;
    }

    public void setSupplierWebsite(String supplierWebsite) {
        this.supplierWebsite = supplierWebsite;
    }

    public Suppliers() {
    }

    public static Vector getAllSupplier() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Supplier");
            while (rs.next()) {
                Suppliers objSupplier = new Suppliers();
                objSupplier.supplierCode = rs.getInt(1);
                objSupplier.supplierName = rs.getString(2);
                objSupplier.supplierfullName = rs.getString(3);
                objSupplier.supplierAddress = rs.getString(4);
                objSupplier.supplierPhone = rs.getString(5);
                objSupplier.supplierFax = rs.getString(6);
                objSupplier.supplierEmail = rs.getString(7);
                objSupplier.supplierWebsite = rs.getString(8);
                v.add(objSupplier);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public static Suppliers getSupplierbyId(String id) throws SQLException, ClassNotFoundException {
        Suppliers objSupplier = new Suppliers();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Supplier WHERE supplierCode = '" + id + "'");
            while (rs.next()) {

                objSupplier.supplierCode = rs.getInt(1);
                objSupplier.supplierName = rs.getString(2);
                objSupplier.supplierfullName = rs.getString(3);
                objSupplier.supplierAddress = rs.getString(4);
                objSupplier.supplierPhone = rs.getString(5);
                objSupplier.supplierFax = rs.getString(6);
                objSupplier.supplierEmail = rs.getString(7);
                objSupplier.supplierWebsite = rs.getString(8);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objSupplier;
    }

    public static void insertSupplier(String name, String fullname, String address, String phone, String fax, String email, String website) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.execute("INSERT INTO Supplier VALUES ('" + name + "', '" + fullname + "','" + address + "','" + phone + "','" + fax + "','" + email + "','" + website + "')");

        } catch (SQLException ex) {
        }

    }

    public static void deleteSupplier(String id) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            sta.execute("DELETE FROM Medicine WHERE supplierCode = " + id);
            sta.execute("DELETE FROM Supplier WHERE supplierCode = " + id);

        } catch (SQLException ex) {
        }

    }

    public static void editSuppliers(String name, String fullname, String address, String phone, String fax, String email, String website, String id) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            String sql = "UPDATE    Supplier SET supplierName ='" + name + "', fullName ='" + fullname + "', supplierAddress ='" + address + "', supplierPhone ='" + phone + "', supplierFax ='" + fax + "', supplierEmail ='" + email + "', supplierWebsite ='" + website + "' WHERE supplierCode = " + id;
            sta.executeUpdate(sql);

        } catch (SQLException ex) {
        }

    }

}
