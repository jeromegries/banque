/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compte;

import java.awt.BorderLayout;
import java.io.File;

/**
 *
 * @author Fabien
 */
public class OSValidator {
    
    private String OS = System.getProperty("os.name").toLowerCase();
    
    public String osTest() {
                String result = new String();
		if (isWindows()) {
                    File AppData = new File("C:\\Users\\Fabien\\AppData\\Local");
                    if(AppData.exists()){
                        File fb = new File("C:\\Users\\Fabien\\AppData\\Local\\Suivi Bancaire"); 
                        fb.mkdirs();
                        result = "C:\\Users\\Fabien\\AppData\\Local\\Suivi Bancaire";
                    }
                    
                    return result;
		} else if (isMac()) {
			return "mac";
		} else if (isUnix()) {
                        System.out.println("On est sur un Unix");
                        File fb = new File("/home/jerome/SuiviBancaire"); 
                        fb.mkdirs();
                        result = "/home/jerome/SuiviBancaire";
			return result;
		} else {
			return "Your OS is not support!!";
		}
    }
    public boolean isWindows() {

	return (OS.indexOf("win") >= 0);

    }

    public boolean isMac() {

	return (OS.indexOf("mac") >= 0);
    }

    public boolean isUnix() {

	return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	
    }



}
