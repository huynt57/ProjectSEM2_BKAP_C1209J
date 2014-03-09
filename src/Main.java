import GUI.Classes.Configure;
import GUI.LoginScreen.LoginScreen;
import GUI.MainScreen.MainScreen;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String args[]) {
    	
    	LoginScreen loginFrame = null;
    	MainScreen mainFrame = null;

    	String rememberState = "0";
    	String keepLogged = "0";
    	try {
	    	File inFile = new File("src/GUI/Resources/setting.bin");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader reader = new BufferedReader(fileReader);
			rememberState = reader.readLine();
			keepLogged = reader.readLine();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(keepLogged.equals("0")) {
	    	mainFrame = new MainScreen("MSB Portal", false, true, false, Configure.DEFAULT_SIZE);
	    	if(rememberState.equals("0")) loginFrame = new LoginScreen("Login", false, true, false, new Dimension(300, 380), mainFrame, false, false);
	    	else loginFrame = new LoginScreen("Login", false, true, false, new Dimension(300, 380), mainFrame, true, false);
    	} else {
    		mainFrame = new MainScreen("MSB Portal", true, true, false, Configure.DEFAULT_SIZE);    		
    	}
	}
}
