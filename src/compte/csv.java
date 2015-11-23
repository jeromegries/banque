package compte;

import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
public class csv {
    
    
    
    
    
    public void newCount(String s, String[] t)throws Exception
   {
      String csv = view.urlRep+"/"+s+".csv";
      CSVWriter writer = new CSVWriter(new FileWriter(csv));
      String[] record = t;
      writer.writeNext(record);
      writer.close();
   }
    
    
    public void credit(String[] t) throws Exception
   {
      String csv = view.url;
      CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
        
      //Tete du csv   credit,description,montant,catégorie,day,month,year,total
      String[] record = t;
      writer.writeNext(record);
      writer.close();
   }
    
    public void debit(String [] t) throws Exception
   {
      String csv = view.url;
      CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
        
      //Tete du csv   debit,description,montant,catégorie,day,month,year,total
      String[] record = t;
      writer.writeNext(record);
      writer.close();
   }
    
    public String[] readCSV(String path, int i) throws Exception
    {
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
        String[] result = new String[8];

	try {

		br = new BufferedReader(new FileReader(path));
                int lineNumber = 0;
		while ((line = br.readLine()) != null) {
		        if(lineNumber == i){
                            result = line.split(cvsSplitBy);
                        }
                        lineNumber++;
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} 
        
        //On retire les guillemets qui se trouve autour de chaque composent
        for(int j = 0; j < result.length; j++){
            String tmp = result[j];
            result[j] = tmp.substring(1, tmp.length()-1);
        }
        return result;
    }
    
   public DefaultComboBoxModel liste(){
       
       DefaultComboBoxModel listComponent = new DefaultComboBoxModel();
       File[] files = new File("/home/jerome/SuiviBancaire").listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null. 

            for (File file : files) {
                if (file.isFile()) {
                    listComponent.addElement(file.getName());
                  }
            }
            

     
     return listComponent;
    }
}
