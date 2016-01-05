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
    
    public ChartPanel GraphPanel(){        
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
        
        int categoriesAmount[] = new int[10];
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader(View.url));
            int lineNumber = 0;
		while ((br.readLine()) != null) {   
                    String[] line = new Csv().readCSV(View.url, lineNumber);
                    switch(line[3]) {
                        case "Logement / Chauffage / Eclairage":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[0] = categoriesAmount[0] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Transport":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[1] = categoriesAmount[1] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Alimentation":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[2] = categoriesAmount[2] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Loisirs / Culture":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[3] = categoriesAmount[3] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Mobiliers":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[4] = categoriesAmount[4] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Habillements":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[5] = categoriesAmount[5] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Santé":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[6] = categoriesAmount[6] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Communication":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[7] = categoriesAmount[7] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Education":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[8] = categoriesAmount[8] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        case "Autre":
                            if("debit".equals(line[0]))
                            {
                                categoriesAmount[9] = categoriesAmount[9] + Integer.parseInt(line[2]);
                            }else
                            {
                                System.out.println("Erreur de saisie dans le fichier csv de type credit/debit");
                            };
                        break;
                        default:
                       
                    }
                    lineNumber++;
		}
            
        }catch(Exception e){
            return null;            // Always must return something
        }
        
        pieChartData.setValue("Logement / Chauffage / Eclairage", categoriesAmount[0]);
        pieChartData.setValue("Transport", categoriesAmount[1]);
        pieChartData.setValue("Alimentation", categoriesAmount[2]);
        pieChartData.setValue("Loisirs / Culture", categoriesAmount[3]);
        pieChartData.setValue("Mobiliers", categoriesAmount[4]);
        pieChartData.setValue("Habillements", categoriesAmount[5]);
        pieChartData.setValue("Santé", categoriesAmount[6]);
        pieChartData.setValue("Communication", categoriesAmount[7]);
        pieChartData.setValue("Education", categoriesAmount[8]);
        pieChartData.setValue("Autre", categoriesAmount[9]);
        
        JFreeChart pieChart = ChartFactory.createPieChart("Expense/Category", pieChartData);
        ChartPanel piePanel = new ChartPanel(pieChart);
        return piePanel;
        
    }
    
}