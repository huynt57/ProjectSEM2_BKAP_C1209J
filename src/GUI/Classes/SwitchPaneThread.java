package GUI.Classes;


import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Classes.CustomFrame;
import GUI.Classes.CustomLabel;

public class SwitchPaneThread extends Thread {
	public CustomLabel progress;
	public JPanel newPane;
	public JPanel p1;
	public JPanel p2;
	public JPanel p3;
	public SwitchPaneThread(CustomLabel progress, JPanel newPane, JPanel p1, JPanel p2, JPanel p3) {
		super();
		this.progress = progress;
		this.newPane = newPane;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	@Override
	public void run() {
		super.run();
		try {
			this.sleep(2000);
			progress.setVisible(false);
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			newPane.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
}