/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.sun.rowset.CachedRowSetImpl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DBHelper {

    private static Connection conn = null;
    public static String message = "";
    public static Connection con;

    /*
     Method to connect database
     */
    public static Connection connect() throws ClassNotFoundException, SQLException {

        //configServer();
        Properties p = new Properties();

        FileInputStream fin = null;
        try {
            fin = new FileInputStream("connection.cfg");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            p.load(fin);
        } catch (IOException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        String server = p.getProperty("ServerID");
        String instance = p.getProperty("Instance");
        String port = p.getProperty("Port");
        String databaseName = p.getProperty("Database");
        String username = p.getProperty("Username");
        String password = p.getProperty("Password");

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //B2: Tao connection
        con = DriverManager.getConnection("jdbc:sqlserver://" + server + ";databasename=" + databaseName + "", "" + username + "", "" + password + "");

        return con;
    }

    public static ResultSet executeQuery(String spName) throws SQLException {
        if (conn != null) {
            CallableStatement cs = conn.prepareCall("{call " + spName + "}");
            return cs.executeQuery();
        }
        return null;
    }

    public static ResultSet executeQuery(String spName, Vector paramList) throws SQLException {
        if (conn != null) {
            String strQ = "{call " + spName + "(";
            int t = 0;
            for (Object obj : paramList) {
                if (t != 0) {
                    strQ += ",";
                }
                if (obj instanceof Integer) {
                    Integer i = (Integer) obj;
                    strQ += i.toString();
                } else if (obj instanceof String) {
                    String s = (String) obj;
                    strQ += "'" + s + "'";
                }
                t++;
            }
            strQ += ")}";

            CallableStatement cst = conn.prepareCall(strQ);
            return cst.executeQuery();
        }
        return null;
    }

    public static int executeUpdate(String spName, Vector paramList) throws SQLException {
        if (conn != null) {
            String strQ = "{call " + spName + "(";

            int t = 0;
            for (Object obj : paramList) {
                if (t != 0) {
                    strQ += ",";
                }
                if (obj instanceof Integer) {
                    Integer i = (Integer) obj;
                    strQ += i.toString();
                } else if (obj instanceof Float) {
                    Float f = (Float) obj;
                    strQ += f.toString();
                } else if (obj instanceof String) {
                    String s = (String) obj;
                    strQ += "'" + s + "'";
                }
                t++;
            }
            strQ += ")}";

            CallableStatement cst = conn.prepareCall(strQ);
            return cst.executeUpdate();
        }
        return -1;
    }
}
