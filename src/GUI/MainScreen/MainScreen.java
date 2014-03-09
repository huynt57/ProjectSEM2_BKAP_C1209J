package GUI.MainScreen;

import GUI.Classes.Configure;
import java.awt.Dimension;
import GUI.Classes.CustomFrame;
import GUI.Classes.RemovablePanel;
import java.sql.SQLException;

public class MainScreen extends CustomFrame {
    public MainScreen(String title, boolean visible, boolean undecorate, boolean resizeable, Dimension dimension) throws ClassNotFoundException, SQLException {
        super(title, visible, undecorate, resizeable, dimension);
        MainPanel mainPanel = new MainPanel(this, Configure.DEFAULT_SIZE);
        this.setContentPane(mainPanel);
        
        mainPanel.setSize(Configure.DEFAULT_SIZE);
        
//        mainPanel.setBackground(Configure.BACKGROUND_COLOR);
    }
}
