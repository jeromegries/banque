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

public class JFreeChartComponent {

    // Histogramme fonctionnel mais non attribuer à une action de l'interface.
    // Pourra être exploité de la même manière que le diagramme circulaire
    public ChartPanel barPanel() {
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();

        // On remplis notre objet des informations a afficher
        barChartData.setValue(20000, "Contribution Amount", "January");
        barChartData.setValue(15000, "Contribution Amount", "February");
        barChartData.setValue(30000, "Contribution Amount", "March");

        // On définit le nom du graphe ainsi que des axes
        JFreeChart barChart = ChartFactory.createBarChart("Projet Contribution", "Monthly", "Contribution Amount", barChartData, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);

        ChartPanel barPanel = new ChartPanel(barChart);
        return barPanel;
    }

    
    public ChartPanel graphPanel() {
        TimeSeries Amount = new TimeSeries("Contribution Amount", Day.class);
        try {

            BufferedReader br = new BufferedReader(new FileReader(View.url));
            int lineNumber = 0;
            while ((br.readLine()) != null) {
                String[] line = new Csv().readCSV(View.url, lineNumber);

                // On compare les dates existantes avec celle qui l'on souhaite rajouter
                // Si une entrée possède la même date on la supprime pour ne concerver que la dernière entrée
                // De ce fait on verra le total du compte après la dernière action de chaque journée
                if (Amount.getTimePeriods().contains(new Day(Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6])))) {
                    Amount.delete(new Day(Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6])));
                }

                // On utilise le total par rapport à une date que l'on crée (JJ/MM/AA)
                Amount.add(new Day(Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6])), Integer.parseInt(line[7]));
                lineNumber++;
            }
            br.close();
        } catch (Exception e) {
            return null;            // Always must return something
        }

        // On définit le nom du graphe ainsi que des axes
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(Amount);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Total Amount / Date", "Date", "Amount", dataset, true, true, false);

        ChartPanel graphPanel = new ChartPanel(chart);
        graphPanel.setMouseZoomable(true, false);
        return graphPanel;
    }

    public ChartPanel piePanel() {
        DefaultPieDataset pieChartData = new DefaultPieDataset();

        int categoriesAmount[] = new int[10];

        try {

            BufferedReader br = new BufferedReader(new FileReader(View.url));
            int lineNumber = 0;
            while ((br.readLine()) != null) {
                String[] line = new Csv().readCSV(View.url, lineNumber);
                
                // On doit faire le total des dépenses (débit uniquement) en fonction de
                // la catégorie (évalué par le switch case)
                switch (line[3]) {
                    case "Logement / Chauffage / Eclairage":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[0] = categoriesAmount[0] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Transport":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[1] = categoriesAmount[1] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Alimentation":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[2] = categoriesAmount[2] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Loisirs / Culture":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[3] = categoriesAmount[3] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Mobiliers":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[4] = categoriesAmount[4] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Habillements":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[5] = categoriesAmount[5] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Santé":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[6] = categoriesAmount[6] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Communication":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[7] = categoriesAmount[7] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Education":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[8] = categoriesAmount[8] + Integer.parseInt(line[2]);
                        };
                        break;
                    case "Autre":
                        if ("debit".equals(line[0])) {
                            categoriesAmount[9] = categoriesAmount[9] + Integer.parseInt(line[2]);
                        };
                        break;
                    default:

                }
                lineNumber++;
            }
            br.close();
        } catch (Exception e) {
            return null;            // Always must return something
        }

        // Chaque catégorie avec son propre total est rajouter au graphe
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
