/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MedicinesManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import database.DBHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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

    public static int insertMedicine(Medicines objMedicine) throws SQLException {
        int i = 0;
        try {
            Vector paramList = new Vector();
            paramList.addElement(objMedicine.medicineName);
            paramList.addElement(objMedicine.medicineTypeCode);
            paramList.addElement(objMedicine.supplierCode);
            i = DBHelper.executeUpdate("spInsertMedicine", paramList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }

    public static int insertMedicineDetails(Medicines objMedicine) throws SQLException {
        int i = 0;
        try {
            Vector paramList = new Vector();
            paramList.addElement(objMedicine.medicineCode);
            paramList.addElement(objMedicine.measure);
            paramList.addElement(objMedicine.pricePerUnit);
            paramList.addElement(objMedicine.avaiableAmount);
            paramList.addElement(objMedicine.registerNumber);
            paramList.addElement(objMedicine.Origin);
            paramList.addElement(objMedicine.used);
            paramList.addElement(objMedicine.termsOfUse);
            paramList.addElement(objMedicine.useGuide);
            i = DBHelper.executeUpdate("spInsertMedicineDetails", paramList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
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
    
    public static void DeleteMedicine(String id) throws SQLException, ClassNotFoundException
    {
       Connection con = DBHelper.connect();
          Statement sta = con.createStatement();

             sta.execute("DELETE FROM Medicine WHERE medicineCode = "+id); 
    }

     public static void AddMedicine(String name, String supplier, String price, String term, String regnum, String num, String used, String measure, String type, String origin) throws SQLException, ClassNotFoundException
    {
       Connection con = DBHelper.connect();
          Statement sta = con.createStatement();
String sql = "UPDATE";
             sta.execute(sql); 
    }

    

    
}
