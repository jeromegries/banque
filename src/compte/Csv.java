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
    
    
    
    
    
    public void newCount(String s, String[] t)throws Exception
   {
      String csv = View.urlRep+"/"+s+".csv";
      CSVWriter writer = new CSVWriter(new FileWriter(csv));
      String[] record = t;
      writer.writeNext(record);
      writer.close();
   }
    
    
    public void credit(String[] t) throws Exception
   {
      String csv = View.url;
      CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
        
      //Tete du Csv   credit,description,montant,catégorie,day,month,year,total
      String[] record = t;
      writer.writeNext(record);
      writer.close();
   }
    
    public void debit(String [] t) throws Exception
   {
      String csv = View.url;
      CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
        
      //Tete du Csv   debit,description,montant,catégorie,day,month,year,total
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
            br.close();
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
       File[] files = new File(View.urlRep).listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null. 

            for (File file : files) {
                if (file.isFile()) {
                    listComponent.addElement(file.getName());
                  }
            }
           
     return listComponent;
    }
   
   public int FileCount(){
       int result = 0;
       File[] files = new File(View.urlRep).listFiles();
       result = files.length;
       return result;
   }
   
   public int LineCount(String url){
        int lineNumber = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(url));
            while ((br.readLine()) != null) {
               lineNumber++;
            }
            br.close();
        }catch(Exception ex){
            
        }
        return lineNumber;
   }
}
