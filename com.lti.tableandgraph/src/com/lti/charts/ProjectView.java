package com.lti.charts;


import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.util.Rotation;

public class ProjectView extends ViewPart {

	  private TableViewer viewer;
	    private FormToolkit toolkit;
	    private Form form;
	@Override
	public void createPartControl(Composite parent) {

//		  	toolkit = new FormToolkit(parent.getDisplay());
//	        form = toolkit.createForm(parent);
//	        form.setText("Repo Branch :Development");
	        
	        
		/* PieChart for File Distribution */ 
		final PieDataset dataset = createDataset();
		final JFreeChart fileDistributionChart = createChart(dataset, "File Distribution");
		new ChartComposite(parent, SWT.NONE, fileDistributionChart, true);


		/* PieChart for Active Users*/ 
		final PieDataset dataset1 = createDataset1();
		final JFreeChart activeUsersChart = createChart1(dataset1, "Active Users");
		new ChartComposite(parent, SWT.NONE, activeUsersChart, true);


		/* Bar chart for commit timeline */
		CategoryDataset dataset2 = createDataset2();
		JFreeChart barChart = createChart2(dataset2, "Commit timeline");
		new ChartComposite(parent, SWT.COLOR_BLUE, barChart); 
		
		


	}

	/* File Distribution Dataset and Chart*/
	private PieDataset createDataset() {
		final DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Module1", 25);
		result.setValue("Module2", 20);
		result.setValue("Module3", 30);
		result.setValue("Module3", 25);

		return result;
	}


	private org.jfree.chart.JFreeChart createChart(final PieDataset dataset, final String title) {
		final JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);

		final PiePlot plot = (PiePlot) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		//for the background color
		chart.getPlot().setBackgroundPaint(java.awt.Color.WHITE);
		
		//Font increase
		java.awt.Font font = new java.awt.Font("Dialog", java.awt.Font.PLAIN, 25);
        
		//legend font
		
		return chart;
	}
	/* close file chart*/

	/* Active Users Dataset and Chart*/
	private PieDataset createDataset1() {
		final DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Shiva", 29);
		result.setValue("Suresh", 20);
		result.setValue("Geetha", 31);
		result.setValue("Rahul", 20);

		return result;
	}

	private org.jfree.chart.JFreeChart createChart1(final PieDataset dataset, final String title) {
		final JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);

		final PiePlot plot = (PiePlot) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		
		chart.getPlot().setBackgroundPaint(java.awt.Color.WHITE);
		//Font increase
		java.awt.Font font = new java.awt.Font("Dialog", java.awt.Font.PLAIN, 25);
        
		//legend font
		
		
		return chart;
	}

	/* Close active users chart*/


	/* Barchart Dataset and graph */
	public CategoryDataset createDataset2( ) {

		DefaultCategoryDataset dataset = 
				new DefaultCategoryDataset();  
		final String initialCommitment = "Initial Commitment";        
		final String finalCommitment = "Final Commitment";        
		final String added = "Added work";   
		final String removed = "Removed work";   
		final String completed = "Completed work"; 
		
		
		
		final String sprint1 = "Sprint1";        
		final String sprint2 = "Sprint2";        
		final String sprint3 = "Sprint3";        
		final String sprint4 = "Sprint4";        

		
		
		dataset.addValue( 30 , initialCommitment , sprint1 );        
		dataset.addValue( 40 , finalCommitment , sprint1 );        
		dataset.addValue( 5 , added , sprint1 ); 
		dataset.addValue( 5, removed , sprint1 );  
		dataset.addValue( 35, completed , sprint1 );  
		
		
		dataset.addValue( 40 , initialCommitment , sprint2 );        
		dataset.addValue( 30 , finalCommitment , sprint2 );        
		dataset.addValue( 10 , removed , sprint2 ); 
		dataset.addValue( 20, completed , sprint1 );  
		
		dataset.addValue( 50 , initialCommitment , sprint3 );        
		dataset.addValue( 55 , finalCommitment , sprint3 );        
		dataset.addValue( 5 , added , sprint3 ); 
		dataset.addValue( 45, completed , sprint3 );

		

		return dataset;           


	}



	public org.jfree.chart.JFreeChart createChart2(final CategoryDataset dataset, final String title) {

		JFreeChart barChart = ChartFactory.createBarChart3D(
				title,           
				"Category",            
				"Story Points",            
				dataset,          
				PlotOrientation.VERTICAL,           
				true, true, false);



		// JFrame frame = new ChartFrame("Bar chart", barchart); 
		ChartPanel chartPanel = new ChartPanel(barChart);
		barChart.getPlot().setBackgroundPaint(java.awt.Color.WHITE);
		
		//Font increase
				java.awt.Font font = new java.awt.Font("Dialog", java.awt.Font.PLAIN, 30);
		        CategoryPlot plot1 = barChart.getCategoryPlot();
				plot1.getDomainAxis().setTickLabelFont(font);
				plot1.getRangeAxis().setLabelFont(font);
				
		chartPanel.setPreferredSize(new java.awt.Dimension( 400 , 250 ) );        
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