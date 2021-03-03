package com.lti.charts;


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.experimental.chart.swt.ChartComposite;

public class XYLineChartView extends ViewPart {

 @Override
 public void createPartControl(Composite parent) {
	
	 
   XYDataset dataset = createDataset();
   JFreeChart xylinechart = createChart(dataset, "XY Line Graph");
   
   new ChartComposite(parent, SWT.COLOR_BLUE, xylinechart); 
 
 }

 
 
 
 private XYDataset createDataset( ) {
     final XYSeries firefox = new XYSeries( "Firefox" );          
     firefox.add( 1.0 , 1.0 );          
     firefox.add( 2.0 , 4.0 );          
     firefox.add( 3.0 , 3.0 );          
     
     final XYSeries chrome = new XYSeries( "Chrome" );          
     chrome.add( 1.0 , 4.0 );          
     chrome.add( 2.0 , 5.0 );          
     chrome.add( 3.0 , 6.0 );          
     
     final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
     iexplorer.add( 3.0 , 4.0 );          
     iexplorer.add( 4.0 , 5.0 );          
     iexplorer.add( 5.0 , 4.0 );          
     
     final XYSeriesCollection dataset = new XYSeriesCollection( );          
     dataset.addSeries( firefox );          
     dataset.addSeries( chrome );          
     dataset.addSeries( iexplorer );
     return dataset;
  }

 
 
 private org.jfree.chart.JFreeChart createChart(final XYDataset dataset, final String title) {
	 
	 JFreeChart xylineChart = ChartFactory.createXYLineChart(
	         title ,
	         "Category" ,
	         "Score" ,
	         dataset,
	         PlotOrientation.VERTICAL ,
	         true , true , false);
	  
	
	  ChartPanel chartPanel = new ChartPanel(xylineChart);
	  chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	    setContentPane(chartPanel);
	    return xylineChart;
	    

	 }
 
 
 
  
 
 private void setContentPane(ChartPanel chartPanel) {
	// TODO Auto-generated method stub
	
}



@Override
 public void setFocus() {
 }
}