/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
        Tutoriel d'utilisation de la class JFreeChartCOmponent

Dans l'implémentation de l'action d'un composent(bouton ou autre) incorporé :

        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());
        chartPanel.add(chart.PiePanel(), BorderLayout.CENTER);
        chartPanel.validate();

La première ligne retire ce qui se trouvait préalablement à l'interieur du composent.
La deuxieme intore un type de positionnement
La troisieme ajout le composent JFreeChart à afficher (ici un pie, voir les autres fonctions disponible) puis positionne ce composent(ici placé au centre)
La quatrieme actualise l'affichage
*/
package compte;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Fabien
 */
public class JFreeChartComponent {
    
    public ChartPanel BarPanel()
    {
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
        barChartData.setValue(20000,"Contribution Amount", "January");
        barChartData.setValue(15000,"Contribution Amount", "February");
        barChartData.setValue(30000,"Contribution Amount", "March");

        JFreeChart barChart = ChartFactory.createBarChart("Projet Contribution", "Monthly", "Contribution Amount", barChartData, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        
        ChartPanel barPanel = new ChartPanel(barChart);
        return barPanel;
    }
    
    public ChartPanel GraphPanel()
    {
        /*
        DefaultCategoryDataset graphChartData = new DefaultCategoryDataset();
        try{
            
            BufferedReader br = new BufferedReader(new FileReader(View.url));
            int lineNumber = 0;
		while ((br.readLine()) != null) {   
                    String[] line = new Csv().readCSV(View.url, lineNumber);
                    graphChartData.setValue(Integer.parseInt(line[7]),line[6],line[5]);
                    lineNumber++;
		}
            
        }catch(Exception e){
            return null;            // Always must return something
        }
        JFreeChart graphChart = ChartFactory.createLineChart("Graph Amount/Mounth","Monthly", "Contribution Amount", graphChartData);
        */
        
        TimeSeries Amount = new TimeSeries("Contribution Amount", Day.class);
        try{
            
            BufferedReader br = new BufferedReader(new FileReader(View.url));
            int lineNumber = 0;
		while ((br.readLine()) != null) {   
                    String[] line = new Csv().readCSV(View.url, lineNumber);
                    Amount.add(new Day(Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6])), Integer.parseInt(line[7]));
                    lineNumber++;
		}
            
        }catch(Exception e){
            return null;            // Always must return something
        }
        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(Amount);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Total Amount / Date","Date","Amount",dataset,true,true,false);
        
        ChartPanel graphPanel = new ChartPanel(chart);
        graphPanel.setMouseZoomable(true, false);
        return graphPanel;
    }
    
    public ChartPanel PiePanel()
    {
        DefaultPieDataset pieChartData = new DefaultPieDataset();
        
        pieChartData.setValue("Loisir", 150);
        pieChartData.setValue("Logement", 500);
        pieChartData.setValue("Nourriture", 200);
        pieChartData.setValue("Transport", 50);
        pieChartData.setValue("Autre", 75);
        
        JFreeChart pieChart = ChartFactory.createPieChart("Expense/Category", pieChartData);
        ChartPanel piePanel = new ChartPanel(pieChart);
        return piePanel;
        
    }
    
}