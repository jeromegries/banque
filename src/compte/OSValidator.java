package compte;

import java.io.File;

public class OSValidator {

    private String OS = System.getProperty("os.name").toLowerCase();
    private String username = System.getProperty("user.name");

    public String osTest() {
        String result = new String();
        if (isWindows()) {
            File fb = new File("C:/Users/" + username + "/AppData/Local/SuiviBancaire");
            fb.mkdirs();
            result = "C:/Users/" + username + "/AppData/Local/SuiviBancaire";
            return result;
        } else if (isMac()) {
            File fb = new File(username + "/Library/Preferences/SuiviBancaire");
            fb.mkdirs();
            result = username + "/Library/Preferences/SuiviBancaire";
            return result;
        } else if (isUnix()) {
            File fb = new File("/home/" + username + "/SuiviBancaire");
            fb.mkdirs();
            result = "/home/" + username + "/SuiviBancaire";
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

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }

}
