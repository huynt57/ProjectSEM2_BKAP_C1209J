/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Util {
    public static String getId() {
        String rememberState = "0";
    	String keepLogged = "0";
        String nameLogin = "NoName";
    	try {
	    	File inFile = new File("src/GUI/Resources/setting.bin");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader reader = new BufferedReader(fileReader);
			rememberState = reader.readLine();
			keepLogged = reader.readLine();
                        nameLogin = reader.readLine();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        return nameLogin;
    }
}
