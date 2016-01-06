package compte;

import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.DefaultComboBoxModel;

public class Csv {
    
    // on crée le fichier qui contiendra les informations du compte à l'aide
    // du chemin de base + du nom du compte ( s )
    public void newCount(String s, String[] t) throws Exception {
        
        String csv = View.urlRep + "/" + s + ".csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        String[] record = t;
        writer.writeNext(record);
        writer.close();
    }

    // On utilise un nouveau fichier temporaire pour introduire les actions
    // antérieurs, puis la nouvelle action, puis les actions suivantes.
    // On supprime ensuite le premier fichier et on renomme le temporaire
    // pour retrouver le compte avec la nouvelle entrée bien triée par date
    public void writeCSV(String[] t) throws Exception {
        
        String csv = View.url;
        // Création du fichier temporaire
        String tmpcsv = View.urlRep + "/tmp.csv";
        // On récupère la ligne où il faut rajouter la nouvelle entrée
        int lineToWrite = this.lineToWrite(t[4], t[5], t[6]);
        CSVWriter tmpWriter = new CSVWriter(new FileWriter(tmpcsv, true));
        int i = 0;
        int total = 0;
        // On réécrit simplement toutes les actions antérieurs dans le tmp
        while (i != lineToWrite) {
            String[] line = this.readCSV(csv, i);
            total = Integer.parseInt(line[7]);
            tmpWriter.writeNext(line);
            i++;
        }
        // On recalcul la valeur du total présente dans la ligne de la nouvelle 
        // entrée (elle doit se cumulé avec le total précédant
        if (t[0].equals("credit")) {
            total = total + Integer.parseInt(t[2]);
        } else {
            total = total - Integer.parseInt(t[2]);
        }
        t[7] = Integer.toString(total);
        tmpWriter.writeNext(t);
        while (i <= this.lineCount(csv) - 1) {
            String[] line = this.readCSV(csv, i);
            if (line[0].equals("credit")) {
                total = total + Integer.parseInt(line[2]);
            } else {
                total = total - Integer.parseInt(line[2]);
            }
            line[7] = Integer.toString(total);
            tmpWriter.writeNext(line);
            i++;
        }
        tmpWriter.close();

        File csvFile = new File(csv);
        csvFile.delete();

        File tmpFile = new File(tmpcsv);
        tmpFile.renameTo(new File(csv));

    }

    public String[] readCSV(String path, int i) throws Exception {
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] result = new String[8];

        try {
            br = new BufferedReader(new FileReader(path));
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                if (lineNumber == i) {
                    // On décompose chaque ligne en tableau, les cellules sont
                    // les strings entre ","
                    result = line.split(cvsSplitBy);
                }
                lineNumber++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // On retire les guillemets de chaque cellule (qui entoure chaque string)
        for (int j = 0; j < result.length; j++) {
            String tmp = result[j];
            result[j] = tmp.substring(1, tmp.length() - 1);
        }
        return result;
    }

    // Retour un comboBoxModel composé du nom de tous les fichiers
    // afin de pouvoir selectionner le compte sur lequel travailler
    public DefaultComboBoxModel liste() {

        DefaultComboBoxModel listComponent = new DefaultComboBoxModel();
        File[] files = new File(View.urlRep).listFiles();
      
        for (File file : files) {
            if (file.isFile()) {
                listComponent.addElement(file.getName());
            }
        }

        return listComponent;
    }

    // On récupère le nombre de compte (de fichier)
    public int fileCount() {
        
        int result = 0;
        File[] files = new File(View.urlRep).listFiles();
        result = files.length;
        return result;
    }

    // On récupère le nombre de ligne d'un fichier
    public int lineCount(String url) {
       
        int lineNumber = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(url));
            while ((br.readLine()) != null) {
                lineNumber++;
            }
            br.close();
        } catch (Exception ex) {

        }
        return lineNumber;
    }

    // On récupère la ligne pour l'insertion chronologique d'une nouvelle
    // entrée
    public int lineToWrite(String dd, String mm, String yy) {
        
        int result = 0;
        
        try {
            String[] line = this.readCSV(View.url, result);
            while (Integer.parseInt(line[6]) < Integer.parseInt(yy)) {
                result++;
                line = this.readCSV(View.url, result);
            }
            if (Integer.parseInt(line[6]) > Integer.parseInt(yy)) {
                return result;
            }
            while (Integer.parseInt(line[5]) < Integer.parseInt(mm)) {
                result++;
                line = this.readCSV(View.url, result);
            }
            if (Integer.parseInt(line[5]) > Integer.parseInt(yy)) {
                return result;
            }
            while (Integer.parseInt(line[4]) < Integer.parseInt(dd)) {
                result++;
                line = this.readCSV(View.url, result);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }
}
