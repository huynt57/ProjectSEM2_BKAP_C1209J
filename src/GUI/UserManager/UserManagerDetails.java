package GUI.UserManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.HintTextField;
import GUI.Classes.RemovablePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

public class UserManagerDetails extends CustomFrame {

    public UserManagerDetails(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension, String id) throws SQLException, SQLException, SQLException, SQLException, SQLException, SQLException {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel("User details",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        Dimension dim = dimension;

        CustomLabel userIdLabel = new CustomLabel("User id",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 70), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel usernameLabel = new CustomLabel("Username",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 110), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel passwordLabel = new CustomLabel("Password",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 150), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel fullNumberLabel = new CustomLabel("Full name",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 190), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel typeLabel = new CustomLabel("Type",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 230), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel activeLabel = new CustomLabel("Active",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 270), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel phoneLabel = new CustomLabel("Phone",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 310), new Dimension(dim.width - 40, 20), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel emailLabel = new CustomLabel("Email",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 350), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        CustomLabel addressLabel = new CustomLabel("Address",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 390), new Dimension(dim.width - 40, 30), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final CustomButton ok = new CustomButton("OK", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 440),
                new Dimension(100, 30), contenPane);

        userIdLabel.setText("User ID: "+id);
        try {
            usernameLabel.setText("Name Login: " + Users.getUserById(id).getNameLogin());
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            passwordLabel.setText("Password: " + Users.getUserById(id).getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fullNumberLabel.setText("Fullname: " + Users.getUserById(id).getFirstname()+Users.getUserById(id).getLastname());
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            typeLabel.setText("User Type: " + Users.getUserById(id).getUserTypeCode());
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            activeLabel.setText("User active: " + Users.getUserById(id).getUserActive() + "");
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            phoneLabel.setText("User phone: " + Users.getUserById(id).getUserPhone());
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            emailLabel.setText("User email: " + Users.getUserById(id).getUserEmail());
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            addressLabel.setText("User address: " + Users.getUserById(id).getUserAddress());
        } catch (SQLException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserManagerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                UserManagerDetails.this.dispose();
            }
        });

    }

}
