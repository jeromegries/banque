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
    
    private Csv csv = new Csv();
    
    
    public String affichehistory() throws Exception
  	 {
       //Compter le nombre de lignes du fichier
       String result = "";
       int numberline=0;
       
       CSVReader reader = new CSVReader(new FileReader(View.url));
       String [] nextLine;
       while ((nextLine = reader.readNext()) != null){ numberline=numberline+1;}

       for(int i = 1; i<numberline; i++){
        
            String[] historyline = csv.readCSV(View.url, numberline-i);
            result =result+historyline[4]+"/"+historyline[5]+"/"+historyline[6]+"       :"+historyline[2]+"\n"+historyline[1]+"\n_____________________________\n";
                
               }
       
       return result;
      }
    
        
    }
    


                       
 
        

