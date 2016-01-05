/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compte;

import com.opencsv.CSVReader;
import java.awt.Color;
import java.io.FileReader;
import javax.swing.JLabel;



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
        String amount = new String();
            String[] historyline = csv.readCSV(View.url, numberline-i);
            if(historyline[0].equals("credit"))
            {
                amount = " +"+historyline[2];
            }else{
                amount = " -"+historyline[2];
            }
            
            
            result = result+" "+historyline[4]+"/"+historyline[5]+"/"+historyline[6]+"       :"+amount+"\n"+" "+historyline[1]+"\n_________________________\n";
                
               }
       
       return result;
      }
        
    }
    


                       
 
        

