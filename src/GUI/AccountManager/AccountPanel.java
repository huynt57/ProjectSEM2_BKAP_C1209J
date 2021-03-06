package GUI.AccountManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomLabel;
import GUI.Classes.CustomTextField;
import GUI.Classes.RemovablePanel;
import GUI.LoginScreen.LoginScreen;
import GUI.MainScreen.MainPanel;
import GUI.MainScreen.MainScreen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountPanel extends JPanel {
    public final MainPanel parentPanel;
    public AccountPanel(MainPanel PARENT, final JPanel parentPanel, Point pos, Dimension d) throws ClassNotFoundException, SQLException {
        super();
        setLayout(null);
        this.parentPanel = PARENT;
        this.setBounds(pos.x, pos.y, d.width, d.height);
        parentPanel.add(this);
        ImageIcon avatarIcon = new ImageIcon("src/GUI/Resources/avatar200.bin");
        CustomLabel avatar = new CustomLabel(avatarIcon, new Point(40, 95), new Dimension(200, 200), true, AccountPanel.this);

        CustomLabel titleLabel = new CustomLabel("Your Account's informations",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 35),
                new Point(40, 17), new Dimension(d.width, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, AccountPanel.this);

        final CustomButton logout = new CustomButton(" Log out", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(d.width - 120, 20),
                new Dimension(100, 30), AccountPanel.this);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LogoutDialog logoutDialog = new LogoutDialog("Are you sure ?", true, true, false, new Dimension(200, 100), "10" );
            }
        });

        final UpdateProfile updateProfile = new UpdateProfile(new Point(240, 95), new Dimension(d.width - 260, d.height - 110), AccountPanel.this);
        updateProfile.setVisible(false);
        final OverView overView = new OverView(new Point(240, 95), new Dimension(d.width - 260, d.height - 110), AccountPanel.this);
        overView.setVisible(true);
        final ChangePassword changePassword = new ChangePassword(new Point(240, 95), new Dimension(d.width - 260, d.height - 110), AccountPanel.this);
        changePassword.setVisible(false);

        final CustomButton overview = new CustomButton(new ImageIcon("src/GUI/Resources/settingWhiteIcon.bin"), " Overview", Color.WHITE, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14), false, false, Color.ORANGE, true, new Point(40, 340), new Dimension(200, 30), AccountPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        final CustomButton profile = new CustomButton(new ImageIcon("src/GUI/Resources/settingWhiteIcon.bin"), " Update profile", Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14), false, false, Color.WHITE, true, new Point(40, 370), new Dimension(200, 30), AccountPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);
        final CustomButton changePass = new CustomButton(new ImageIcon("src/GUI/Resources/lockGrayIcon.bin"), "  Change password", Color.GRAY, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14), false, false, Color.WHITE, true, new Point(40, 400), new Dimension(200, 30), AccountPanel.this, SwingConstants.LEFT, SwingConstants.CENTER);

        overview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(overview, profile, changePass, overView, updateProfile, changePassword);
            }
        });

        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(profile, overview, changePass, updateProfile, overView, changePassword);
            }
        });

        changePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeState(changePass, overview, profile, changePassword, updateProfile, overView);
                changePass.setIcon(new ImageIcon("src/GUI/Resources/lockWhiteIcon.bin"));
            }
        });


    }

    public void changeState(JButton b1, JButton b2, JButton b3, JPanel p1, JPanel p2, JPanel p3) {
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.WHITE);
        p1.setVisible(true);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.GRAY);
        p2.setVisible(false);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.GRAY);
        p3.setVisible(false);

    }
}
