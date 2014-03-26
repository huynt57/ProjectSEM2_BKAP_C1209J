/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.MedicineTypeManager;

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
public class MedicineTypes {
 private int medicineTypeCode;
    private String medicineTypeName;

    public int getMedicineTypeCode() {
        return medicineTypeCode;
    }

    public void setMedicineTypeCode(int medicineTypeCode) {
        this.medicineTypeCode = medicineTypeCode;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }
    
     public static Vector getAllMedicineType() throws SQLException, ClassNotFoundException{
        Vector v = new Vector();
        try {
           Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM MedicineType");
            while(rs.next()){
                MedicineTypes objMedicineType = new MedicineTypes();
                objMedicineType.medicineTypeCode = rs.getInt(1);
                objMedicineType.medicineTypeName = rs.getString(2);
                v.add(objMedicineType);
            }
        } catch (SQLException ex) {
            
        }
        return v;        
    }   
     
     public static void insertMedicineType(String name) throws SQLException, ClassNotFoundException {
        
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("INSERT INTO MedicineType VALUES ('" + name + "')");
           
        } catch (SQLException ex) {
        }
       
    }
     
     public static void deleteMedicineType(String id) throws SQLException, ClassNotFoundException {
        
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("DELETE FROM MedicineType WHERE measureCode = "+id);
           
        } catch (SQLException ex) {
        }
       
    }
     
      public static void editMedicineType(String name, String id) throws SQLException, ClassNotFoundException {
        
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("UPDATE MedicineType VALUES ('" + name + "') WHERE medicineTypeCode = "+id);
           
        } catch (SQLException ex) {
        }
       
    }
      
      public static Vector viewMeasure(String id) throws SQLException, ClassNotFoundException {
        
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM MedicineType WHERE medicineTypeCode = "+id);
            while (rs.next()) {
                MedicineTypes objMeasure = new MedicineTypes();
                objMeasure.medicineTypeCode = rs.getInt(1);
                objMeasure.medicineTypeName = rs.getString(2);
                v.add(objMeasure);
            }
        } catch (SQLException ex) {
        }
        return v;
       
    }
}
