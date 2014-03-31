package GUI.UserManager;

import GUI.Classes.Configure;
import GUI.Classes.CustomButton;
import GUI.Classes.CustomComboBox;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

public class UserManagerNew extends CustomFrame {

    public UserManagerNew(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension) throws SQLException, ClassNotFoundException {
        super(title, visible, undecorate, resizeable, dimension);
        setUndecorated(true);
        RemovablePanel contenPane = new RemovablePanel(this);
        Color BackGround = Color.getHSBColor(20, 12, 21);
        contenPane.setBackground(BackGround);
        this.setContentPane(contenPane);
        setLayout(null);
        CustomLabel titleLabel = new CustomLabel("Add new user",
                Color.BLACK, Configure.DEFAULT_RIGHT_PANEL_COLOR,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 24),
                new Point(20, 17), new Dimension(360, 40), true,
                SwingConstants.LEFT, SwingConstants.CENTER, contenPane);

        Dimension dim = dimension;
        final HintTextField username = new HintTextField(" Username", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 70), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField password = new HintTextField(" Password", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point((dim.width - 40) / 2 + 25, 70), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField name = new HintTextField(" Full name", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 110), new Dimension(dim.width - 40, 30), contenPane, false);

        Vector typeVt = new Vector();
        typeVt.add("Choose user type");
        Vector<UserType.UserTypes> utypeTemp = UserType.UserTypes.getAllUserType();
        for (int i = 0; i < utypeTemp.size(); i++) {
            typeVt.add(utypeTemp.get(i).getUsertypename());
        }

        final CustomComboBox type = new CustomComboBox(typeVt, CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 150), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane);
        final HintTextField phone = new HintTextField(" Phone", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField active = new HintTextField(" Active", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 150), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField email = new HintTextField(" Email", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(205, 190), new Dimension((dim.width - 40) / 2 - 5, 30), contenPane, false);
        final HintTextField address = new HintTextField(" Address", CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 13), new Point(20, 230), new Dimension(dim.width - 40, 30), contenPane, false);

        final CustomButton ok = new CustomButton("Save", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.GRAY, true, new Point(20, 280),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String usernamex = username.getText().toString();
                String pass = password.getText().toString();
                String namex = name.getText().toString();
                String typex = type.getSelectedItem().toString();
                String phonex = phone.getText().toString();
                String activex = active.getText().toString();
                String emailx = email.getText().toString();
                String add = address.getText().toString();
                try {
                    Users.insertUser(usernamex, pass, typex, add, phonex, emailx, activex, "noava", namex, namex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserManagerNew.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserManagerNew.class.getName()).log(Level.SEVERE, null, ex);
                }
                UserManagerNew.this.dispose();
            }
        });

        final CustomButton cancel = new CustomButton("Cancel", Color.WHITE,
                CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
                false, false, Color.LIGHT_GRAY, true, new Point(20 + 10 + (dim.width - 50) / 2, 280),
                new Dimension((dim.width - 50) / 2, 30), contenPane);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UserManagerNew.this.dispose();
            }
        });
    }

}
