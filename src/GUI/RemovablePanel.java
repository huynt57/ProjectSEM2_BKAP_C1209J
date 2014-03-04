package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class RemovablePanel extends JPanel implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private CustomFrame parentFrame;
	private Point beginPoint, endPoint;
	public static boolean canRemove = false;
	public RemovablePanel(CustomFrame parentFrame) {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
		this.parentFrame = parentFrame;
		beginPoint = new Point();
		endPoint = new Point();
		setLayout(new BorderLayout());
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(canRemove) {
			endPoint = new Point(e.getX(), e.getY());
			if(endPoint.x > beginPoint.x) endPoint.x = beginPoint.x + Configure.SMOOTHLY; else endPoint.x = beginPoint.x - Configure.SMOOTHLY;
			if(endPoint.y > beginPoint.y) endPoint.y = beginPoint.y + Configure.SMOOTHLY; else endPoint.y = beginPoint.y - Configure.SMOOTHLY;
			parentFrame.pos.x = parentFrame.pos.x + endPoint.x - beginPoint.x;
			parentFrame.pos.y = parentFrame.pos.y + endPoint.y - beginPoint.y;
			parentFrame.setBounds(parentFrame.pos.x, parentFrame.pos.y, parentFrame.getPreferredSize().width, parentFrame.getPreferredSize().height);
			beginPoint = endPoint;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		canRemove = true;
		beginPoint = new Point(e.getX(), e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		canRemove = false;
	}

}
