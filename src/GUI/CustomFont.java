package GUI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class CustomFont {
	public static Font getFont(String fontName, int fontType, int fontSize) {
		InputStream is = CustomButton.class.getClassLoader().getResourceAsStream(fontName + ".bin");
	    Font fontBase = null;
		try {
			fontBase = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    Font fontReal = fontBase.deriveFont(fontType, fontSize);
	    return fontReal;
	}
}
