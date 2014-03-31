/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.LoginScreen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import database.DBHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Users {

    public int userCode;
    public String nameLogin;
    public String password;
    public String firstName;
    public String lastName;
    public String userTypeCode;
    public String userAddress;
 public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
 public String userType;
    public String userPhone;
    public String userEmail;
    public String userAva;
    public int userActive;

    public Users(int userCode, String nameLogin, String password, String firstName, String lastName, String userTypeCode, String userAddress, String userPhone, String userEmail, String userAva, int userActive) {
        this.userCode = userCode;
        this.nameLogin = nameLogin;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userTypeCode = userTypeCode;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userAva = userAva;
        this.userActive = userActive;
    }

    public Users() {

    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getNameLogin() {
        return nameLogin;
    }

    public void setNameLogin(String nameLogin) {
        this.nameLogin = nameLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAva() {
        return userAva;
    }

    public void setUserAva(String userAva) {
        this.userAva = userAva;
    }

    public int getUserActive() {
        return userActive;
    }

    public void setUserActive(int userActive) {
        this.userActive = userActive;
    }

    public static Vector getAllUser() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs;
            String sql = "SELECT * FROM Users";
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                Users objUser = new Users();
                objUser.userCode = rs.getInt(1);
                objUser.nameLogin = rs.getString(2);
                objUser.password = rs.getString(3);
                objUser.firstName = rs.getString(10);
                objUser.lastName = rs.getString(11);
                objUser.userTypeCode = rs.getString(4);
                objUser.userAddress = rs.getString(5);
                objUser.userPhone = rs.getString(6);
                objUser.userEmail = rs.getString(7);
                objUser.userActive = rs.getInt(8);
                objUser.userAva = rs.getString(9);
                v.add(objUser);
            }
        } catch (SQLException ex) {

        }
        return v;
    }

    Object getnameLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
