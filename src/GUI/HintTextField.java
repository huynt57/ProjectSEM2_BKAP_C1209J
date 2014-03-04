package GUI;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class HintTextField extends JTextField implements FocusListener {
	  private final String hint;
	  private boolean showingHint;
	  public HintTextField(String hint, Font font, Point pos, Dimension dimendion, JPanel parentPane) {
		  super(hint);
		  this.hint = hint;
		  this.showingHint = true;
		  super.addFocusListener(this);
		  setFont(font);
		  setBounds(pos.x, pos.y, dimendion.width, dimendion.height);
		  setBorder(null);
		  parentPane.add(this);
	  }
	  public HintTextField(final String hint) {
	    super(hint);
	    this.hint = hint;
	    this.showingHint = true;
	    super.addFocusListener(this);
	  }
	  @Override
	  public void focusGained(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText("");
	      showingHint = false;
	    }
	  }
	  @Override
	  public void focusLost(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText(hint);
	      showingHint = true;
	    }
	  }
	  @Override
	  public String getText() {
	    return showingHint ? "" : super.getText();
	  }
	}