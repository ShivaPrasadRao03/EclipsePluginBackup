package com.lti.charts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.util.Rotation;

public class LineChartView extends ViewPart {

 @Override
 public void createPartControl(Composite parent) {
	 
	
	// Create dataset  
	    DefaultCategoryDataset dataset = createDataset();  
	    // Create chart  
	    JFreeChart linechart = createChart(dataset, "LineGraph");
	    
	    new ChartComposite(parent, SWT.COLOR_BLUE, linechart); 
	 
 }

 private DefaultCategoryDataset createDataset() {

	 DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

	 String series1 = "Visitor";  
  String series2 = "Unique Visitor";  
  dataset.addValue(200, series1, "2016-12-19");  
  dataset.addValue(150, series1, "2016-12-20");  
  dataset.addValue(100, series1, "2016-12-21");  
  dataset.addValue(210, series1, "2016-12-22");  
  dataset.addValue(240, series1, "2016-12-23");  
  dataset.addValue(195, series1, "2016-12-24");  
  dataset.addValue(245, series1, "2016-12-25");  

  dataset.addValue(150, series2, "2016-12-19");  
  dataset.addValue(130, series2, "2016-12-20");  
  dataset.addValue(95, series2, "2016-12-21");  
  dataset.addValue(195, series2, "2016-12-22");  
  dataset.addValue(200, series2, "2016-12-23");  
  dataset.addValue(180, series2, "2016-12-24");  
  dataset.addValue(230, series2, "2016-12-25");  
return dataset;
 }

 private org.jfree.chart.JFreeChart createChart(final DefaultCategoryDataset dataset, final String title) {
 
  JFreeChart linechart = ChartFactory.createLineChart(  
	        title, // Chart title  
	        "Date", // X-Axis Label  
	        "Number of Visitor", // Y-Axis Label  
	        dataset  
	        );  
  
  ChartPanel chartPanel = new ChartPanel(linechart);
  chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
    
  
  return linechart;
 }

 @Override
 public void setFocus() {
 }
}