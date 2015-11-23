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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
        DefaultCategoryDataset graphChartData = new DefaultCategoryDataset();
        try{
            
            BufferedReader br = new BufferedReader(new FileReader(view.url));
            int lineNumber = 0;
		while ((br.readLine()) != null) {   
                    String[] line = new csv().readCSV(view.url, lineNumber);
                    graphChartData.setValue(Integer.parseInt(line[7]),line[4],line[5]);
                    lineNumber++;
		}
            
        }catch(Exception e){
            return null;            // Always must return something
        }
        /*  Remplissage manuel du graphe
        graphChartData.setValue(500, "2015", "January");
        graphChartData.setValue(1500, "2015", "February");
        graphChartData.setValue(1000, "2015", "March");
        graphChartData.setValue(750, "2015", "April");
        graphChartData.setValue(2000, "2015", "May");
        */
        JFreeChart graphChart = ChartFactory.createLineChart("Graph Amount/Mounth","Monthly", "Contribution Amount", graphChartData);
        ChartPanel graphPanel = new ChartPanel(graphChart);
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