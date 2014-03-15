
package GUI.Classes;

import GUI.AccountManager.AccountPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dialog2Button extends JFrame {

    public Dialog2Button(Dimension dimension, JFrame parentFrame)  {
        super();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setSize(dimension);
        parentFrame.setEnabled(false);
        setVisible(true);
        JPanel content = new JPanel();
        this.setContentPane(content);
        final CustomButton ok = new CustomButton("OK", Color.WHITE,
				CustomFont.getFont(Configure.DEFAULT_FONT, Font.PLAIN, 14),
				false, false, Color.GRAY, true, new Point(dimension.width-120, 20),
				new Dimension(dimension.width/2-20, 40), content);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                            
			}
		});
        }

    public Dialog2Button(Dimension dimension, AccountPanel aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
