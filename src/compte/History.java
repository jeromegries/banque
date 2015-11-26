/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compte;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;



/**
 *
 * @author jerome
 */
public class History {
    
    Csv csv = new Csv();
    
    
    public String[] affichehistory() throws Exception
  	 {
       //Compter le nombre de lignes du fichier
       int i=0;
       CSVReader reader = new CSVReader(new FileReader(View.url));
       String [] nextLine;
       while ((nextLine = reader.readNext()) != null){ i=i+1;}
       
        String[] history = new String[i];
        int j =0;
        
        BufferedReader br = new BufferedReader(new FileReader(View.url));
        String ligne = null;
        
        while ((ligne = br.readLine()) != null)
         {
                // Retourner la ligne dans un tableau
                String[] data = ligne.split("\n");

                // Afficher le contenu du tableau
                for (String val : data)
                {
                  //System.out.println(val);
                  history[j]=val;
                  //System.out.println(history[j]);
                  j++;
                }
        }
        
        br.close();
        return history;
      }
    
        
    }
    


                       
 
        


