package GUI.AccountManager;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import GUI.Classes.Configure;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.Util;
import GUI.LoginScreen.Users;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.SwingConstants;

public class OverView extends JPanel {

    public OverView(Point pos, Dimension d, JPanel parentPanel) throws ClassNotFoundException, SQLException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setBackground(Configure.DEFAULT_RIGHT_PANEL_COLOR);
        setLayout(null);
        parentPanel.add(this);

        int begin = 0;
        int marginLeft = 80;
        int step = 40;
        int i = 1;

        String sql = "SELECT * FROM Users WHERE Users.nameLogin ='" + Util.getId() + "'";
        Connection con = database.DBHelper.connect();
        Statement sta = con.createStatement();
        //  System.out.println(sql);
        ResultSet rs;
        Vector v = new Vector();
        rs = sta.executeQuery(sql);
        Users objUser;

//        // TODO: Update DB with new user's info 
//        objUser = new Users();
//        while (rs.next()) {
//            objUser.nameLogin = rs.getString("nameLogin");
//            objUser.password = rs.getString("password");
//            objUser.userCode = rs.getInt("userCode");
//            objUser.userActive = rs.getInt("userActive");
//            objUser.firstName = rs.getString("firstName");
//            objUser.lastName = rs.getString("lastName");
//            objUser.userAddress = rs.getString("userAddress");
//            objUser.userPhone = rs.getString("userPhone");
//            objUser.userEmail = rs.getString("userEmail");
//            objUser.userType = rs.getString("userType");
//            v.add(objUser);
//        }
//        Users u = null;
//        for (int j = 0; j < v.size(); j++) {
//            u = (Users) v.get(j);
//        }
        
        CustomLabel userIdLabel = new CustomLabel("User id",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel usernameLabel = new CustomLabel("Username",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel passwordLabel = new CustomLabel("Password",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel fullNumberLabel = new CustomLabel("Full name",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel typeLabel = new CustomLabel("Type",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel activeLabel = new CustomLabel("Active",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel phoneLabel = new CustomLabel("Phone",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel emailLabel = new CustomLabel("Email",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        CustomLabel addressLabel = new CustomLabel("Address",
                Color.GRAY, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(marginLeft, begin + step * i++), new Dimension(d.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, this);
        
//        userIdLabel.setText("ID: " + u.getUserCode());
//        usernameLabel.setText("username: " + u.getNameLogin());
//        passwordLabel.setText("password: " + u.getPassword());
//        fullNumberLabel.setText("fullname: " + u.getFirstName() + " " + u.getLastName());
//        typeLabel.setText("Type: " + u.getUserTypeCode());
//        activeLabel.setText("Active: " + u.getUserActive());
//        phoneLabel.setText("Phone: " + u.getUserPhone());
//        emailLabel.setText("Email: " + u.getUserEmail());
//        addressLabel.setText("Address: " + u.getUserAddress());

    }

}
