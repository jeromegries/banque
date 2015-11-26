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
    
    public  void affichehistory () throws Exception
		{
 
	     CSVReader reader = new CSVReader(new FileReader(View.url));
    		String [] nextLine;
   			 while ((nextLine = reader.readNext()) != null)
   			 	 {
                   for(String valeur:nextLine)
                   		System.out.print (valeur);
                                //sauter une ligne
                                System.out.println ();
    		    }
 
        }
    
}
