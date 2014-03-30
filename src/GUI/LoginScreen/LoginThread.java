package GUI.LoginScreen;

import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import database.DBHelper;
import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginThread extends Thread {

    public static String userTypeCode = "";
    public String nameLogin = "";
    public static int active;
    public JLabel label;
    public String userName;
    public String password;
    public CustomFrame mainFrame;
    public CustomFrame loginFrame;
    public boolean remember;
    public boolean keeplogged;
    public boolean loginSuccessful;
    public CustomLabel loginStatus;
    public CustomLabel logo;
    public ImageIcon image;
    public CustomLabel appName;

    public LoginThread(JLabel label, String username, String password,
            CustomFrame mainFrame, CustomFrame loginFrame, boolean remember,
            boolean keepLogged, CustomLabel loginStatus, CustomLabel logo, ImageIcon image, CustomLabel appName) {
        super();
        this.label = label;
        this.userName = username;
        this.password = password;
        this.mainFrame = mainFrame;
        this.loginFrame = loginFrame;
        this.remember = remember;
        this.keeplogged = keepLogged;
        this.loginStatus = loginStatus;
        this.logo = logo;
        this.image = image;
        this.appName = appName;
        this.nameLogin = username;
    }

    @Override
    public void run() {
        super.run();
        label.setVisible(true);
        try {
            this.sleep(3000);
            label.setVisible(false);

            boolean loginSuccessful = false;
            String loginStatusText = "";

            Vector v = new Vector();
            try {
                v = Users.getAllUser();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            Users u = new Users();
            boolean flag = false;
            for (int i = 0; i < v.size(); i++) {
                u = (Users) v.get(i);
                if (u.getNameLogin().equals(userName) && u.getPassword().equals(password)) {
                    System.out.println(u.getNameLogin());
                    System.out.println("1");
                    flag = true;
                }
            }

            if (flag == true) {
                loginSuccessful = true;
            } else {
                loginSuccessful = false;
            }
            // END TODO

            try {
                FileWriter writer = new FileWriter("src/GUI/Resources/setting.bin");
                if (remember) {
                    writer.write("1\n");
                } else {
                    writer.write("0\n");
                }
                if (keeplogged && loginSuccessful) {
                    writer.write("1\n");
                } else {
                    writer.write("0\n");
                }
                writer.write(nameLogin);
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (loginSuccessful) {
                loginFrame.setVisible(false);
                mainFrame.setVisible(true);
                this.stop();
            } else {
                loginStatus.setVisible(true);
                loginStatus.setText("Username and Password not matched.");
                logo.setBounds(75, 290, image.getIconWidth(), image.getIconHeight());
                appName.setBounds(0, 340, 300, 20);
            }
            this.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
