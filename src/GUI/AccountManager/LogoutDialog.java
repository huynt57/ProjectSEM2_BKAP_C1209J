package GUI.AccountManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomFont;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import GUI.Classes.RemovablePanel;
import GUI.LoginScreen.LoginScreen;
import static GUI.LoginScreen.LoginThread.nameLogin;
import GUI.MainScreen.MainScreen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

public class LogoutDialog extends CustomFrame {

    public LogoutDialog(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dim, final String id) {
        super(title, visible, undecorate, resizeable, dim);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.GRAY;
        contenPane.setBackground(Color.getHSBColor(20, 12, 21));
        this.setContentPane(contenPane);
        setLocationRelativeTo(null);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel(title,
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 15),
                new Point(20, 10), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);
        final CustomButton ok = new CustomButton("Yes", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 50),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LoginScreen loginFrame = null;
                MainScreen mainFrame = null;

                String rememberState = "0";
                String keepLogged = "0";
                try {
                    File inFile = new File("src/GUI/Resources/setting.bin");
                    FileReader fileReader = new FileReader(inFile);
                    BufferedReader reader = new BufferedReader(fileReader);
                    rememberState = reader.readLine();
                    keepLogged = reader.readLine();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                keepLogged = "0";

                try {
                    mainFrame = new MainScreen("MSB Portal", false, true, false, Configure.DEFAULT_SIZE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rememberState.equals("0")) {
                    loginFrame = new LoginScreen("Login", false, true, false, new Dimension(300, 380), mainFrame, false, false);
                } else {
                    loginFrame = new LoginScreen("Login", false, true, false, new Dimension(300, 380), mainFrame, true, false);
                }
                
                 try {
                FileWriter writer = new FileWriter("src/GUI/Resources/setting.bin");
                if (rememberState == "1") {
                    writer.write("1\n");
                } else {
                    writer.write("0\n");
                }
                    writer.write("0\n");
                writer.write(nameLogin);
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

                LogoutDialog.this.dispose();
                System.exit(0);
            }
        });
        final CustomButton cancel = new CustomButton("No", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 50),
                new Dimension((dim.width - 50) / 2, 30), contenPane);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LogoutDialog.this.dispose();
            }
        });

    }
}
