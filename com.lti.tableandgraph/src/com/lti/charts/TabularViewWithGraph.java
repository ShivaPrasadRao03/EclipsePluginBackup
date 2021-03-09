package com.lti.charts;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Text;
import com.lti.model.Student;
import org.eclipse.swt.widgets.TableItem;
import java.util.ArrayList;
import java.util.List;

public class TabularViewWithGraph extends ViewPart {
	private Table table;
	private Text txt_search;
	private TableViewer tableViewer;


	@Override
	public void createPartControl(Composite parent) {
		
		

		CategoryDataset dataset = createDataset();
		JFreeChart barchart = createChart(dataset, "BarGraph");

		new ChartComposite(parent, SWT.COLOR_BLUE, barchart); 

		


		//        //Search Text
		//        txt_search = new Text(parent, SWT.BORDER);
		//        txt_search.setBounds(21, 10, 238, 19);
		//TableViewer
		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		// table.setBounds(21, 47, 290, 213);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		//Table(Student): TableViewerColumn Names

		String[] Col_names={"Student ID","Student Name","Gender","Branches"};
		for(int i=0;i<Col_names.length;i++)
		{
			TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
			TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
			tblclmnNewColumn.setWidth(100);
			tblclmnNewColumn.setText(Col_names[i]);


		}
		//Table(Student) Item List
		List<Student> std=new ArrayList<Student>();
		std.add(new Student("110","AAA","Male","ECE"));
		std.add(new Student("111","FFF","Female","CSE"));
		std.add(new Student("112","MMM","Male","ECE"));
		std.add(new Student("113","MOO","Male","CSE"));
		std.add(new Student("114","SPP","Female","ECE"));
		std.add(new Student("115","KOL","Male","CSE"));
		std.add(new Student("116","DFD","Male","ECE"));
		std.add(new Student("117","MDP","Female","CSE"));
		std.add(new Student("118","OIU","Male","ECE"));
		std.add(new Student("119","KJW","Female","ECE"));
		std.add(new Student("120","OIH","Male","CSE"));


		for(Student s:std)
		{
			TableItem std_item=new TableItem(table, SWT.NONE);
			std_item.setText(0,s.getStd_id());
			std_item.setText(1,s.getStd_nm());
			std_item.setText(2,s.getStd_gender());
			std_item.setText(3,s.getStd_branch());
			//                  System.out.println(s);  
		}

		FillLayout fillLayout = new FillLayout();

	       fillLayout.type = SWT.VERTICAL;

	       
	       

		parent.setLayout(fillLayout);
		
	}
	public TableViewer getViewer() {
		return tableViewer;
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
		tableViewer.getControl().setFocus();

	}
}