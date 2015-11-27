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
    private String username = System.getProperty("user.name");

    
   public String osTest() {
                String result = new String();
		if (isWindows()) {
                    File AppData = new File("C:/Users/"+username+"/AppData/Local");
                    if(AppData.exists()){
                        File fb = new File("C:/Users/"+username+"/AppData/Local/SuiviBancaire"); 
                        fb.mkdirs();
                        result = "C:/Users/"+username+"/AppData/Local/SuiviBancaire";
                    }
                    
                    return result;
		} else if (isMac()) {
			return "mac";
		} else if (isUnix()) {
                        File fb = new File("/home/"+username+"/SuiviBancaire"); 
                        fb.mkdirs();
                        result = "/home/"+username+"/SuiviBancaire";
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
