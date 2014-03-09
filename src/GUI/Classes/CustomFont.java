package GUI.Classes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomFont {
	public static Font getFont(String fontName, int fontType, int fontSize) {
		Font myFont = null;
		File fontFile = new File("src/GUI/Resources/" + fontName + ".bin");
		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(fontType, fontSize);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return myFont;
	}
}
