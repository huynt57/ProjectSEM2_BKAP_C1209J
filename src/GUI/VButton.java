package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Configure;

public class VButton extends JPanel implements MouseMotionListener, MouseListener{
	public static JFrame parentFrame;
	public String text;
	public Color textColor = Configure.DEFAULT_TEXT_COLOR;
	public Color buttonColor = Configure.DEFAULT_BUTTON_COLOR;
	public Color buttonRolloverColor = Configure.DEFAULT_BUTTON_ROLLOVER_COLOR;
	public Color buttonClickedColor = Configure.DEFAULT_BUTTON_CLICKED_COLOR;
	public String animationType = "DropLeft";
	public String fontName = "Segue-UI.ttf";
	public int fontSize = 10;
	public int fontType = Font.PLAIN;
	public static boolean startAnimation = false;
	
	public static int index = 0;
	
	public static int status = 1; // Status = 2 button rollover, status = 3 button clicked, status = 4 start animation && not 3

	public VButton(String text, Color textColor, String fontName, int fontSize,
			int fontType, JFrame parentFrame, int width,
			int height, String animationType, Color buttonColor,
			Color buttonRolloverColor, Color buttonClickedColor) {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
		this.parentFrame = parentFrame;
		this.buttonClickedColor = buttonClickedColor;
		this.buttonColor = buttonColor;
		this.buttonRolloverColor = buttonRolloverColor;
		this.text = text;
		this.textColor = textColor;
		this.fontName = fontName + ".ttf" ;
		this.fontSize = fontSize;
		this.fontType = fontType;
		try {
			if (!animationType.equals("DropLeft") &&
				!animationType.equals("DropRight") &&
				!animationType.equals("DropUp") &&
				!animationType.equals("DropDown"))
			throw new Exception("Animation type not suitable !");
			else this.animationType = animationType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(width, height);
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(startAnimation) status = 4;
		System.out.println(status);
		if(status == 1) {
			g.setColor(buttonColor); 
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		else if(status == 4) {
			g.setColor(buttonRolloverColor);
			g.fillRect(0, 0, index++, getHeight());
			g.setColor(buttonColor);
			g.fillRect(index-1, 0, index-1, getHeight());
			try {
				Thread.sleep(1);
				if(index <= getWidth()) repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			status = 2;
		}
		else if(status == 5) {
			g.setColor(buttonColor);
			g.fillRect(0, 0, index--, getHeight());
			g.setColor(buttonColor);
			g.fillRect(index, 0, getWidth(), getHeight());
			try {
				Thread.sleep(1);
				if(index >= 0) repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			status = 1;
			index = 0;
		}
		else if(status == 2) {
			System.out.println("2222");
			g.setColor(buttonRolloverColor);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		else if(status == 3){
			g.setColor(buttonClickedColor);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		
		g.setColor(textColor);
		g.setFont(CustomFont.getFont(fontName, fontType, fontSize));
		System.out.println(fontName);
		g.drawString(text, 16, 25);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		status = 2;
		repaint();
		System.out.println("Set action here");
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		status = 4;
		startAnimation = true;
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		status = 5;
		repaint();
		startAnimation = false;
		index = getWidth();
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		status = 3;
		startAnimation = false;
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		status = 2;
		repaint();
	}
}
