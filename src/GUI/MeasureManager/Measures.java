/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.MeasureManager;

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
public class Measures {

    private int measureCode;
    private String measureName;

    public int getMeasureCode() {
        return measureCode;
    }

    public void setMeasureCode(int measureCode) {
        this.measureCode = measureCode;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public Measures(int measureCode, String measureName) {
        this.measureCode = measureCode;
        this.measureName = measureName;
    }

    public Measures() {
    }

    public static Vector getAllMeasure() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Measure");
            while (rs.next()) {
                Measures objMeasure = new Measures();
                objMeasure.measureCode = rs.getInt(1);
                objMeasure.measureName = rs.getString(2);
                v.add(objMeasure);
            }
        } catch (SQLException ex) {
        }
        return v;
    }
    
    public static Measures getMeasureById(String id) throws SQLException, ClassNotFoundException {
       Measures objMeasure = new Measures();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Measure WHERE measureCode = '"+id+"'");
            while (rs.next()) {
                
                objMeasure.measureCode = rs.getInt(1);
                objMeasure.measureName = rs.getString(2);
                
            }
        } catch (SQLException ex) {
        }
        return objMeasure;
    }
    
     public static void insertMeasure(String name) throws SQLException, ClassNotFoundException {
        
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("INSERT INTO Measure VALUES ('" + name + "')");
           
        } catch (SQLException ex) {
        }
       
    }
     
     public static void deleteMeasure(String id) throws SQLException, ClassNotFoundException {
        
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("DELETE FROM Measure WHERE measureCode = "+id);
           
        } catch (SQLException ex) {
        }
       
    }
     
      public static void editMeasure(String name, String id) throws SQLException, ClassNotFoundException {
        
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            sta.executeQuery("UPDATE Measure SET measureName = '"+name+"' WHERE measureCode = "+id);
           
        } catch (SQLException ex) {
        }
       
    }
      
      public static Vector viewMeasure(String id) throws SQLException, ClassNotFoundException {
        
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Measure WHERE measureCode = "+id);
            while (rs.next()) {
                Measures objMeasure = new Measures();
                objMeasure.measureCode = rs.getInt(1);
                objMeasure.measureName = rs.getString(2);
                v.add(objMeasure);
            }
        } catch (SQLException ex) {
        }
        return v;
       
    }

}
