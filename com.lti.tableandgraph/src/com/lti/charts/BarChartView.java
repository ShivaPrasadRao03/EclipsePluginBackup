package com.lti.charts;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
import org.jfree.experimental.chart.swt.ChartComposite;

public class BarChartView extends ViewPart {

Control control;	

@Override
 public void createPartControl(Composite parent) {
	 
	
	 
   CategoryDataset dataset = createDataset();
   JFreeChart barchart = createChart(dataset, "BarGraph");
   
   new ChartComposite(parent, SWT.COLOR_BLUE, barchart); 
 
 }


 
 
 public CategoryDataset createDataset( ) {
          
      DefaultCategoryDataset dataset = 
     new DefaultCategoryDataset();  
     final String fiat = "FIAT";        
     final String audi = "AUDI";        
     final String ford = "FORD";        
     final String speed = "Speed";        
     final String millage = "Millage";        
     final String userrating = "User Rating";        
     final String safety = "safety";        
     

     dataset.addValue( 1.0 , fiat , speed );        
     dataset.addValue( 3.0 , fiat , userrating );        
     dataset.addValue( 5.0 , fiat , millage ); 
     dataset.addValue( 5.0 , fiat , safety );           

     dataset.addValue( 5.0 , audi , speed );        
     dataset.addValue( 6.0 , audi , userrating );       
     dataset.addValue( 10.0 , audi , millage );        
     dataset.addValue( 4.0 , audi , safety );

     dataset.addValue( 4.0 , ford , speed );        
     dataset.addValue( 2.0 , ford , userrating );        
     dataset.addValue( 3.0 , ford , millage );        
     dataset.addValue( 6.0 , ford , safety );    

     return dataset;           

     
  }

 
 
 public org.jfree.chart.JFreeChart createChart(final CategoryDataset dataset, final String title) {
	 
	 JFreeChart barChart = ChartFactory.createBarChart3D(
		         title,           
		         "Category",            
		         "Score",            
		         dataset,          
		         PlotOrientation.VERTICAL,           
		         true, true, false);
	 
	  
	
	 // JFrame frame = new ChartFrame("Bar chart", barchart); 
	  ChartPanel chartPanel = new ChartPanel(barChart);
	  chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	    setContentPane(chartPanel);
	    return barChart;
	    

	 }
 
 
 
  
 
 private void setContentPane(ChartPanel chartPanel) {
	// TODO Auto-generated method stub
	
}



@Override
 public void setFocus() {
 }
}