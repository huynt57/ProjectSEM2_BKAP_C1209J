package GUI.AccountManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomTextField;
import GUI.Classes.Util;
import static GUI.LoginScreen.LoginThread.nameLogin;
import GUI.LoginScreen.Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateProfile extends JPanel {

    public UpdateProfile(Point pos, Dimension d, JPanel parentPanel) throws ClassNotFoundException, SQLException {
        super();
        this.setBounds(pos.x, pos.y, d.width, d.height);
        setBackground(Configure.DEFAULT_RIGHT_PANEL_COLOR);
        setLayout(null);
        parentPanel.add(this);

        int beginPos = 5;
        int step = 35;
        int posLeft = 50;

        Connection con = database.DBHelper.connect();
        Statement sta = con.createStatement();
        String sql = "SELECT * FROM Users WHERE Users.nameLogin ='" + Util.getId() + "'";
        //  System.out.println(sql);
        ResultSet rs;
        Vector v = new Vector();
        rs = sta.executeQuery(sql);
        Users objUser;

        // TODO: Update DB with new user's info 
        objUser = new Users();
        while (rs.next()) {
            objUser.firstName = rs.getString(1);
            objUser.lastName = rs.getString(2);

            objUser.userAddress = rs.getString(3);
            objUser.userPhone = rs.getString(4);
            objUser.userEmail = rs.getString(5);

            v.add(objUser);
        }
        Users u = null;
        for (int i = 0; i < v.size(); i++) {
            u = (Users) v.get(i);
        }
        final String first = u.getFirstName();
        final String last = u.getLastName();
        final String email = u.getUserEmail();
        final String address = u.getUserAddress();
        final String phone = u.getUserPhone();
//        final String first = "";
//        final String last = "";
//        final String email = "";
//        final String address ="";
//        final String phone = "";

        CustomLabel firstNameLabel = new CustomLabel("First name: ",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                new Point(posLeft, beginPos), new Dimension(150, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, UpdateProfile.this);

        final CustomTextField firstName = new CustomTextField(" " + first,
                Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
                        Font.PLAIN, 13), new Point(posLeft, beginPos + step - 5), new Dimension(
                        d.width - posLeft * 2, 30), UpdateProfile.this);

        CustomLabel lastNameLabel = new CustomLabel("Last name: ",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                new Point(posLeft, beginPos + step * 2), new Dimension(150, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, UpdateProfile.this);

        final CustomTextField lastName = new CustomTextField(" " + last,
                Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
                        Font.PLAIN, 13), new Point(posLeft, beginPos + step * 3 - 5), new Dimension(
                        d.width - posLeft * 2, 30), UpdateProfile.this);

        CustomLabel emailLabel = new CustomLabel("Email: ",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                new Point(posLeft, beginPos + step * 4), new Dimension(150, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, UpdateProfile.this);

        final CustomTextField emailField = new CustomTextField(" " + email,
                Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
                        Font.PLAIN, 13), new Point(posLeft, beginPos + step * 5 - 5), new Dimension(
                        d.width - posLeft * 2, 30), UpdateProfile.this);

        CustomLabel phoneLabel = new CustomLabel("Phone: ",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                new Point(posLeft, beginPos + step * 6), new Dimension(150, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, UpdateProfile.this);

        final CustomTextField phoneField = new CustomTextField(" " + phone,
                Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
                        Font.PLAIN, 13), new Point(posLeft, beginPos + step * 7 - 5), new Dimension(
                        d.width - posLeft * 2, 30), UpdateProfile.this);

        CustomLabel addressLabel = new CustomLabel("Address: ",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                new Point(posLeft, beginPos + step * 8), new Dimension(150, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, UpdateProfile.this);

        final CustomTextField addressField = new CustomTextField(" " + address,
                Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT,
                        Font.PLAIN, 13), new Point(posLeft, beginPos + step * 9 - 5), new Dimension(
                        d.width - posLeft * 2, 30), UpdateProfile.this);

        CustomButton submit = new CustomButton("Submit", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(posLeft, beginPos + step * 10 + 10),
                new Dimension(80, 30), UpdateProfile.this);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                firstName.getText();
                lastName.getText();
                emailField.getText();
                phoneField.getText();
                addressField.getText();
                //  System.out.println(firstName.getText());
                try {
                    Connection con = database.DBHelper.connect();
                    Statement sta = con.createStatement();
                    String sql = "UPDATE    Users "
                            + "SET              userAddress ='" + addressField.getText() + "', userphone ='" + phoneField.getText() + "', userEmail ='" + emailField.getText() + "', firstName ='" + firstName.getText() + "', lastName = '" + lastName.getText() + "' WHERE nameLogin = '" + Util.getId() + "'";
                    // System.out.println(sql);
                    sta.executeUpdate(sql);

                    // TODO: Update DB with new user's info 
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        CustomButton clear = new CustomButton("Clear", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(posLeft + 90, beginPos + step * 10 + 10),
                new Dimension(80, 30), UpdateProfile.this);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName.setText("");
                lastName.setText("");
                emailField.setText("");
                addressField.setText("");
                phoneField.setText("");
            }
        });

    }

}
