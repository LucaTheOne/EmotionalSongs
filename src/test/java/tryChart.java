
import java.awt.*;
import java.io.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author big
 */
public class tryChart {
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(3, "1", "1");
        dataset.addValue(2, "2", "2");
        dataset.addValue(1, "3", "3");
        dataset.addValue(5, "4", "4");
        dataset.addValue(4, "5", "5");
        
        
        JFreeChart chartBar = ChartFactory.createBarChart("Amazement Bars marks", "Mark", "Number of user \n that assigned that mark", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chartBar.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(new ChartPanel(chartBar));
        frame.setVisible(true);
        
        try {
            ChartUtilities.saveChartAsJPEG(new File("/Users/big/Desktop/chart.jpeg"), chartBar, 1000, 800);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
