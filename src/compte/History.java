/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compte;

import com.opencsv.CSVReader;
import java.io.FileReader;



/**
 *
 * @author jerome
 */
public class History {
    
    Csv csv = new Csv();
    
    
    public  String[] affichehistory () throws Exception
		{
                int i=0;
                
                CSVReader reader = new CSVReader(new FileReader(View.url));
    		String [] nextLine;
                
                //compter le nombre de lignes dans le fichier csv;
                while ((nextLine = reader.readNext()) != null){ i=i+1;}
                //stocker les lignes du csv dans un tableau
                String[] result = new String[i];
                
                int c=0;
                while ((nextLine = reader.readNext()) != null)
                    {
                   for(String valeur:nextLine){
                   		System.out.print (valeur);
                                //sauter une ligne
                                
                                System.out.println ();
                                result[c]=valeur;
                                c++;
                        }    
                        //return result;        
    		    }
                    return result;
                }
}
                       
 
        


