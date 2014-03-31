/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserType;

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
public class UserTypes {
    public int userTypeCode;
    public String userTypeName;

    public int getUsertypeCode() {
        return userTypeCode;
    }

    public void setUsertypeCode(int usertypeCode) {
        this.userTypeCode = usertypeCode;
    }

    public String getUsertypename() {
        return userTypeName;
    }

    public void setUsertypename(String usertypename) {
        this.userTypeName = usertypename;
    }

    public UserTypes(int usertypeCode, String usertypename) {
        this.userTypeCode = usertypeCode;
        this.userTypeName = usertypename;
    }

    public UserTypes() {
    }
    
    
 public static Vector getAllUserType() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {

            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM UserType");
            while (rs.next()) {
                UserTypes objUser = new  UserTypes();
                objUser.userTypeCode = rs.getInt("userTypeCode");
                objUser.userTypeName = rs.getString("userTypeName");
               
                v.add(objUser);
            }
        } catch (SQLException ex) {

        }
        return v;
    }
}
