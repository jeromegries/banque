package compte;

import com.opencsv.CSVReader;
import java.awt.Color;
import java.io.FileReader;
import javax.swing.JLabel;

public class History {

    private Csv csv = new Csv();

    public String affichehistory() throws Exception {
        
        //Compter le nombre de lignes du fichier pour connaitre le 
        // nombre d'évènement a afficher dans l'historique
        String result = "";
        int numberline = 0;

        CSVReader reader = new CSVReader(new FileReader(View.url));
        String[] nextLine;
        
        while ((nextLine = reader.readNext()) != null) {
            numberline = numberline + 1;
        }

        // On met en forme l'affichage des informations
        // Date : montant
        // Description
        for (int i = 1; i < numberline; i++) {
            String amount = new String();
            String[] historyline = csv.readCSV(View.url, numberline - i);
            if (historyline[0].equals("credit")) {
                amount = " +" + historyline[2];
            } else {
                amount = " -" + historyline[2];
            }

            result = result + " " + historyline[4] + "/" + historyline[5] + "/" + historyline[6] + "       :" + amount + "\n" + " " + historyline[1] + "\n_________________________\n";

        }
        reader.close();
        return result;
    }

}
