/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.UserManager;

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
public class Users {

    private int userCode;
    private String nameLogin;

    private String password;
    private String fullName;

    private String userTypeCode;

    private String userAddress;

    public Users(int userCode, String nameLogin, String password, String fullName, String userTypeCode, String userAddress, String userPhone, String userEmail, int userActive, String firstname, String lastname) {
        this.userCode = userCode;
        this.nameLogin = nameLogin;
        this.password = password;
        this.fullName = fullName;
        this.userTypeCode = userTypeCode;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userActive = userActive;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    private String userPhone;
    private String userEmail;
    private int userActive;
    private String firstname;
    private String lastname;

    public Users(int userCode, String nameLogin, String password, String fullName, String userTypeCode, String userAddress, String userPhone, String userEmail, int userActive) {
        this.userCode = userCode;
        this.nameLogin = nameLogin;
        this.password = password;
        this.fullName = fullName;
        this.userTypeCode = userTypeCode;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getUserActive() {
        return userActive;
    }

    public void setUserActive(int userActive) {
        this.userActive = userActive;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static Vector getAllUser() throws SQLException, ClassNotFoundException {
        Vector v = new Vector();
        try {

            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                Users objUser = new Users();
                objUser.userCode = rs.getInt(1);
                objUser.nameLogin = rs.getString(2);
                objUser.password = rs.getString(3);
                objUser.fullName = rs.getString(4);
                objUser.userTypeCode = rs.getString(5);
                objUser.userAddress = rs.getString(6);
                objUser.userPhone = rs.getString(7);
                objUser.userEmail = rs.getString(8);
                objUser.userActive = rs.getInt(9);
                v.add(objUser);
            }
        } catch (SQLException ex) {

        }
        return v;
    }

    public static Users getUserById(String id) throws SQLException, ClassNotFoundException {
        Users objUser = new Users();
        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            ResultSet rs = sta.executeQuery("SELECT * FROM Users join UserType ON Users.userTypeCode = UserType.userTypeCode WHERE userCode = '" + id + "'");
            while (rs.next()) {

                objUser.userCode = rs.getInt(1);
                objUser.nameLogin = rs.getString(2);
                objUser.password = rs.getString(3);
                objUser.fullName = rs.getString(4);
                objUser.userTypeCode = rs.getString(5);
                objUser.userAddress = rs.getString(6);
                objUser.userPhone = rs.getString(7);
                objUser.userEmail = rs.getString(8);
                objUser.userActive = rs.getInt(9);

            }
        } catch (SQLException ex) {

        }
        return objUser;
    }

    public static void DeleteUser(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBHelper.connect();
        Statement sta = con.createStatement();

        sta.execute("DELETE FROM Uses WHERE userCode = " + id);

    }

    public static void editUsers(String name, String pass, String type, String add, String phone, String mail, String active, String ava, String fname, String lname, String id) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();

            String sqlutype = "SELECT userTypeCode FROM UserType WHERE userTypeName = '" + type + "'";
            ResultSet rsm = sta.executeQuery(sqlutype);

            int usertype = 0;
            while (rsm.next()) {
                usertype = rsm.getInt("userTypeCode");
            }

            sta.execute("UPDATE Users SET  nameLogin ='" + name + "', password ='" + pass + "', userTypeCode ='" + usertype + "', userAddress ='" + add + "', userphone ='" + phone + "', userEmail ='" + mail + "', userActive ='" + active + "', userAva ='" + ava + "', firstName ='" + fname + "', lastName = '" + lname + "' WHERE userCode = " + id);

        } catch (SQLException ex) {
        }

    }

    public static void insertUser(String name, String pass, String type, String add, String phone, String mail, String active, String ava, String fname, String lname) throws SQLException, ClassNotFoundException {

        try {
            Connection con = DBHelper.connect();
            Statement sta = con.createStatement();
            String sql = "INSERT INTO Users VALUES ('" + name + "','" + pass + "','" + type + "','" + add + "','" + phone + "','" + mail + "'," + active + ",'" + ava + "','" + fname + "','" + lname + "')";
            sta.execute(sql);
            System.out.println(sql);
            

        } catch (SQLException ex) {
        }

    }
}
