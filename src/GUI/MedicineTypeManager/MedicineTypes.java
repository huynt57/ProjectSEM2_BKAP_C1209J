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
}
