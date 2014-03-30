/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MedicinesManager;

import GUI.MeasureManager.Measures;
import GUI.MedicineTypeManager.MedicineTypes;
import GUI.SupplierManager.Suppliers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import database.DBHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class Medicines {

    private int medicineCode;
    private String medicineName;
    private int medicineTypeCode;
    private int supplierCode;
    private String termsOfUse;
    private int measure;
    private float pricePerUnit;

    private int avaiableAmount;
    private String registerNumber;
    private String Origin;
    private String used;
    private String useGuide;

    private String medicineTypeName;
    private String supplierName;
    private String measureName;

    public int getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicineTypeCode() {
        return medicineTypeCode;
    }

    public void setMedicineTypeCode(int medicineTypeCode) {
        this.medicineTypeCode = medicineTypeCode;
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

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
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

    public Medicines(int medicineCode, String medicineName, int medicineTypeCode, int supplierCode, String termsOfUse, int measure, float pricePerUnit, int avaiableAmount, String registerNumber, String Origin, String used, String useGuide, String medicineTypeName, String supplierName, String measureName) {
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        this.medicineTypeCode = medicineTypeCode;
        this.supplierCode = supplierCode;
        this.termsOfUse = termsOfUse;
        this.measure = measure;
        this.pricePerUnit = pricePerUnit;
        this.avaiableAmount = avaiableAmount;
        this.registerNumber = registerNumber;
        this.Origin = Origin;
        this.used = used;
        this.useGuide = useGuide;
        this.medicineTypeName = medicineTypeName;
        this.supplierName = supplierName;
        this.measureName = measureName;
    }

    public Medicines() {
    }

    public static void InsertMedicine(String name, String supplier, String price, String termofuse, String num, String regnum, String used, String measure, String type, String origin, String guide) throws SQLException, ClassNotFoundException {
        try {
            Vector v = new Vector();
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            String sql1 = "INSERT INTO Medicine VALUES ('" + name + "'," + type + "," + supplier + ")";
            sta.execute(sql1);
            String sql3 = "SELECT MAX (medicineCode) FROM Medicine";
            ResultSet rs = sta.executeQuery(sql3);

            int code = 0;
            while(rs.next())
                   {
                       code = rs.getInt("medicineCode");
            }

            String sql2 = "INSERT INTO MedicineDetails VALUES ("+code+"," + measure + "," + price + "," + num + "," + regnum + ",'" + origin + "',		" + used + "," + termofuse + ",		'" + guide + "')";
            sta.execute(sql2);

        } catch (SQLException ex) {

        }

    }
    
     public static void UpdateMedicine(String name, String supplier, String price, String termofuse, String num, String regnum, String used, String measure, String type, String origin, String guide, String id) throws SQLException, ClassNotFoundException {
        try {
            Vector v = new Vector();
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            String sql1 = "UPDATE Medicine VALUES ('" + name + "'," + type + "," + supplier + ") WHERE medicineCode = "+id;
            sta.execute(sql1);
            String sql3 = "SELECT medicineCode FROM Medicine WHERE medicineName = '" + name + "'";
            ResultSet rs = sta.executeQuery(sql3);

            int code = 0;
            while(rs.next())
                   {
                       code = rs.getInt("medicineCode");
            }

            String sql2 = "UPDATE MedicineDetails VALUES ("+code+"," + measure + "," + price + "," + num + "," + regnum + ",'" + origin + "',		" + used + "," + termofuse + ",		'" + guide + "') WHERE medicineCode = "+id;
            sta.execute(sql2);

        } catch (SQLException ex) {

        }

    }

    public static Vector getAllMedicine() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Medicine join MedicineDetails ON Medicine.medicineCode = MedicineDetails.medicineCode join Supplier ON Medicine.SupplierCode = Supplier.SupplierCode join MedicineType ON Medicine.medicineTypeCode = MedicineType.medicineTypeCode");
            while (rs.next()) {
                Medicines objMedicine = new Medicines();
                objMedicine.medicineCode = rs.getInt("medicineCode");
                objMedicine.medicineName = rs.getString("medicineName");
                objMedicine.medicineTypeName = rs.getString("medicineTypeName");
                objMedicine.supplierName = rs.getString("supplierName");
                objMedicine.avaiableAmount = rs.getInt("avaiableAmount");
                v.add(objMedicine);
            }
        } catch (SQLException ex) {

        }
        return v;
    }
 
    public static void DeleteMedicine(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBHelper.connect();
        Statement sta = con.createStatement();

        sta.execute("DELETE FROM Medicine WHERE medicineCode = " + id);
        sta.execute("DELETE FROM MedicineDetails WHERE medicineCode = " + id);
    }

   public static Vector viewMedicine(String id) throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Medicine join MedicineDetails ON Medicine.medicineCode = MedicineDetails.medicineCode join Supplier ON Medicine.SupplierCode = Supplier.SupplierCode join MedicineType ON Medicine.medicineTypeCode = MedicineType.medicineTypeCode WHERE medicineCode = "+id);
            while (rs.next()) {
                Medicines objMedicine = new Medicines();
                objMedicine.medicineCode = rs.getInt("medicineCode");
                objMedicine.medicineName = rs.getString("medicineName");
                objMedicine.medicineTypeName = rs.getString("medicineTypeName");
                objMedicine.supplierName = rs.getString("supplierName");
                objMedicine.avaiableAmount = rs.getInt("avaiableAmount");
                v.add(objMedicine);
            }
        } catch (SQLException ex) {

        }
        return v;
    }
   
   
//    public static void InsertBill(String billtype, String customercode, String address, String datestart, String expiretime, String tax, String price, String status, String usercode, String medicinecode, String measurecode, String quantity) throws SQLException, ClassNotFoundException {
//        try {
//            Vector v = new Vector();
//            Connection con = DBHelper.connect();
//            Statement sta = con.createStatement();
//            String sql1 = "INSERT INTO Bill VALUES ('" + billtype + "','" + customercode + "','" + address + "','"+datestart+"','"+expiretime+"','"+tax+"','"+price+"','"+status+"','"+usercode+"')";
//            sta.execute(sql1);
//            String sql3 = "SELECT Bill FROM Medicine WHERE addressToDeliver = '" + address + "'";
//            ResultSet rs = sta.executeQuery(sql3);
//
//            int code = 0;
//            while(rs.next())
//                   {
//                       code = rs.getInt("billCode");
//            }
//
//            String sql2 = "INSERT INTO MedicineDetails VALUES ("+code+"," + medicinecode + "," + measurecode + "," + quantity + ")";
//            sta.execute(sql2);
//
//        } catch (SQLException ex) {
//
//        }
//
//    }
//    
//      public static void UpdateBill(String billtype, String customercode, String address, String datestart, String expiretime, String tax, String price, String status, String usercode, String medicinecode, String measurecode, String quantity, String id) throws SQLException, ClassNotFoundException {
//        try {
//            Vector v = new Vector();
//            Connection con = DBHelper.connect();
//            Statement sta = con.createStatement();
//            String sql1 = "UPDATE Bill VALUES ('" + billtype + "','" + customercode + "','" + address + "','"+datestart+"','"+expiretime+"','"+tax+"','"+price+"','"+status+"','"+usercode+"') WHERE billCode = "+id;
//            sta.execute(sql1);
//            String sql3 = "SELECT Bill FROM Medicine WHERE addressToDeliver = '" + address + "'";
//            ResultSet rs = sta.executeQuery(sql3);
//
//            int code = 0;
//            while(rs.next())
//                   {
//                       code = rs.getInt("billCode");
//            }
//
//            String sql2 = "UPDATE BillDetails VALUES ("+code+"," + medicinecode + "," + measurecode + "," + quantity + ") WHERE billCode = "+id;
//            sta.execute(sql2);
//
//        } catch (SQLException ex) {
//
//        }
//
//    }
//
//    public static Vector getAlBill() throws SQLException, ClassNotFoundException {
//        Vector v = new Vector();
//        try {
//            Connection con = DBHelper.connect();
//            Statement sta = con.createStatement();
//
//            ResultSet rs = sta.executeQuery("SELECT * FROM Bill join BillDetails ON Bill.billCode = BillDetails.billCode");
//            while (rs.next()) {
//                Medicines objMedicine = new Medicines();
//                objMedicine.medicineCode = rs.getInt("medicineCode");
//                objMedicine.medicineName = rs.getString("medicineName");
//                objMedicine.medicineTypeName = rs.getString("medicineTypeName");
//                objMedicine.supplierName = rs.getString("supplierName");
//                objMedicine.avaiableAmount = rs.getInt("avaiableAmount");
//                v.add(objMedicine);
//            }
//        } catch (SQLException ex) {
//
//        }
//        return v;
//    }
//
//    public static void DeleteBill(String id) throws SQLException, ClassNotFoundException {
//        Connection con = DBHelper.connect();
//        Statement sta = con.createStatement();
//
//        sta.execute("DELETE FROM Bill WHERE billCode = " + id);
//        sta.execute("DELETE FROM BillDetails WHERE billCode = " + id);
//    }
//
//   public static Vector viewBill(String id) throws SQLException, ClassNotFoundException {
//        Vector v = new Vector();
//        try {
//            Connection con = DBHelper.connect();
//            Statement sta = con.createStatement();
//
//            ResultSet rs = sta.executeQuery("SELECT * FROM Medicine join MedicineDetails ON Medicine.medicineCode = MedicineDetails.medicineCode join Supplier ON Medicine.SupplierCode = Supplier.SupplierCode join MedicineType ON Medicine.medicineTypeCode = MedicineType.medicineTypeCode WHERE medicineCode = "+id);
//            while (rs.next()) {
//                Medicines objMedicine = new Medicines();
//                objMedicine.medicineCode = rs.getInt("medicineCode");
//                objMedicine.medicineName = rs.getString("medicineName");
//                objMedicine.medicineTypeName = rs.getString("medicineTypeName");
//                objMedicine.supplierName = rs.getString("supplierName");
//                objMedicine.avaiableAmount = rs.getInt("avaiableAmount");
//                v.add(objMedicine);
//            }
//        } catch (SQLException ex) {
//
//        }
//        return v;
//    }

}
