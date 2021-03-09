package com.lti.charts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.GlazedListsEventLayer;
import org.eclipse.nebula.widgets.nattable.extension.glazedlists.filterrow.ComboBoxFilterRowHeaderComposite;
import org.eclipse.nebula.widgets.nattable.filterrow.combobox.ComboBoxFilterIconPainter;
import org.eclipse.nebula.widgets.nattable.filterrow.combobox.ComboBoxFilterRowConfiguration;
import org.eclipse.nebula.widgets.nattable.filterrow.combobox.FilterRowComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultRowHeaderDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.RowHeaderLayer;
import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.PaintMap;
import org.jfree.chart.axis.ColorBar;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.lti.model.FileList;
import com.lti.model.Person;
import com.lti.service.ReadJSONFromFile;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.TransformedList;

public class DataTableandGraph extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {

		// create a new ConfigRegistry which will be needed for GlazedLists handling
		ConfigRegistry configRegistry = new ConfigRegistry();

		/* Line Graph */
		// Create dataset
		DefaultCategoryDataset dataset = createDataset();
		// Create chart
		JFreeChart linechart = createChart(dataset, "Method Coverage by Test Cases");
		XYPlot xyplot = linechart.getXYPlot();
	    xyplot.setForegroundAlpha(0.7F);
	   
	   
		new ChartComposite(parent, SWT.COLOR_CYAN, linechart);

		parent.setLayout(new GridLayout());

		// Get the json data

		// File inputJson= new
		// File("."+File.separator+"dashboard_getCodeCoverage.json");
		JSONObject CodeCoverageData = null;
		try {
			CodeCoverageData = ReadJSONFromFile
					.getJSONFromFile("C:\\Users\\SHIVAPRASAD\\Documents\\JSON\\dashboard_getCodeCoverage.json");
		} catch (Exception e) {
			System.out.println("Error in processing input json " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("COMPLETE JSON  DATA.." + CodeCoverageData.toJSONString());
		//Get the chartData to populate in the table
		JSONArray chartData = (JSONArray) ((JSONObject) CodeCoverageData.get("codeCoverageTrend")).get("chartData");
		System.out.println("ChartData " + chartData);
		//Declare for the column Names
		String[] propertyNames = { "fileName", "noOfCommits", "builds", "mode", "methods", "classLoc", "covered" };
		
		Map<String, String> propertyToLabelMap = new HashMap<String, String>();
		
		List<FileList> myList = new ArrayList<FileList>();

		JSONArray myListArray = new JSONArray();
		
		Map<String,List<FileList>> TableMap = new HashMap<String,List<FileList>>();
		
		for (int i = 0; i < chartData.size(); i++) {
			
			JSONArray fileList = (JSONArray) ((JSONObject) chartData.get(i)).get("fileList");
			
			List<FileList> releaseList = new ArrayList<FileList>();
			//			myList.add(fileList);
			for(int j=0; j<fileList.size();j++) {
				
				JSONObject propertyObj = (JSONObject) fileList.get(j);
				
				myListArray.add(propertyObj);
				
				propertyToLabelMap.put(propertyObj.get(propertyNames[0]).toString(), propertyNames[0].toUpperCase());
				propertyToLabelMap.put(propertyObj.get(propertyNames[1])==null?"0":propertyObj.get(propertyNames[1]).toString(), propertyNames[1].toUpperCase());
				propertyToLabelMap.put(propertyObj.get(propertyNames[2])==null?"0":propertyObj.get(propertyNames[2]).toString(), propertyNames[2].toUpperCase());
				propertyToLabelMap.put(propertyObj.get(propertyNames[3])==null?"0":propertyObj.get(propertyNames[3]).toString(), propertyNames[3].toUpperCase());
				propertyToLabelMap.put(propertyObj.get(propertyNames[4])==null?"0":propertyObj.get(propertyNames[4]).toString(), propertyNames[4].toUpperCase());
				propertyToLabelMap.put(propertyObj.get(propertyNames[5])==null?"0":propertyObj.get(propertyNames[5]).toString(), propertyNames[5].toUpperCase());
				propertyToLabelMap.put(propertyObj.get(propertyNames[6])==null?"0":propertyObj.get(propertyNames[6]).toString(), propertyNames[6].toUpperCase());
				//data will be loaded to FileList Object and then to TableMap with Release Name as key and Object as value
				FileList fileListObj = new FileList();
				fileListObj.setFileName(propertyObj.get(propertyNames[0]).toString());
				fileListObj.setNoOfCommits(propertyObj.get(propertyNames[1])==null?0:Integer.parseInt(propertyObj.get(propertyNames[1]).toString()));
				fileListObj.setBuilds(propertyObj.get(propertyNames[2])==null?0:Integer.parseInt(propertyObj.get(propertyNames[2]).toString()));
				fileListObj.setMode(propertyObj.get(propertyNames[3])==null?0:Integer.parseInt(propertyObj.get(propertyNames[3]).toString()));
				fileListObj.setMethods(propertyObj.get(propertyNames[4])==null?"":(propertyObj.get(propertyNames[4]).toString()));
				fileListObj.setClassLoc(propertyObj.get(propertyNames[5])==null?0:Integer.parseInt(propertyObj.get(propertyNames[5]).toString()));
				fileListObj.setCovered(propertyObj.get(propertyNames[6])==null?false:(boolean)(propertyObj.get(propertyNames[6])));
				releaseList.add(fileListObj);
				myList.add(fileListObj);
			}
			TableMap.put(((JSONObject) chartData.get(i)).get("release").toString(), releaseList);
		}
		System.out.println("FileList " + myList);

		/* Nat Table layers */

		IColumnPropertyAccessor<FileList> columnPropertyAccessor = new ReflectiveColumnPropertyAccessor<FileList>(
				propertyNames);

		// build the body layer stack
		IDataProvider bodyDataProvider = new ListDataProvider<FileList>(myList, columnPropertyAccessor);
		DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
		SelectionLayer selectionLayer = new SelectionLayer(bodyDataLayer);
		ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);

		// build the column header layer stack
		IDataProvider columnHeaderDataProvider = new DefaultColumnHeaderDataProvider(propertyNames, propertyToLabelMap);
		DataLayer columnHeaderDataLayer = new DataLayer(columnHeaderDataProvider);
		ILayer columnHeaderLayer = new ColumnHeaderLayer(columnHeaderDataLayer, viewportLayer, selectionLayer);



		// build the row header layer stack
		IDataProvider rowHeaderDataProvider = new DefaultRowHeaderDataProvider(bodyDataProvider);
		DataLayer rowHeaderDataLayer = new DataLayer(rowHeaderDataProvider, 40, 20);
		ILayer rowHeaderLayer = new RowHeaderLayer(rowHeaderDataLayer, viewportLayer, selectionLayer);

		// build the corner layer stack
		ILayer cornerLayer = new CornerLayer(
				new DataLayer(new DefaultCornerDataProvider(columnHeaderDataProvider, rowHeaderDataProvider)),
				rowHeaderLayer, columnHeaderLayer);

		// create the grid layer composed with the prior created layer stacks
		GridLayer gridLayer = new GridLayer(viewportLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer);

		NatTable natTable = new NatTable(parent, gridLayer);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);

		FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.VERTICAL;
		parent.setLayout(fillLayout);
	}

	//Method to create a Graph
	private DefaultCategoryDataset createDataset() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		String series1 = "Covered";
		String series2 = "Not Covered";
		

		//Get the json data
		JSONObject CodeCoverageData = null;
		try {
			CodeCoverageData = ReadJSONFromFile
					.getJSONFromFile("C:\\Users\\SHIVAPRASAD\\Documents\\JSON\\dashboard_getCodeCoverage.json");
		} catch (Exception e) {
			System.out.println("Error in processing input json " + e.getMessage());
			e.printStackTrace();
		}

		//System.out.println("COMPLETE JSON  DATA.." + CodeCoverageData.toJSONString());
		JSONArray chartData = (JSONArray) ((JSONObject) CodeCoverageData.get("codeCoverageTrend")).get("chartData");
		System.out.println("ChartData " + chartData);

		for(int i=0;i<chartData.size();i++) {
			JSONObject data =(JSONObject) chartData.get(i);
			String release = data.get("release").toString();
			JSONArray seriesData = (JSONArray)data.get("data");
			
			dataset.addValue(Integer.parseInt(seriesData.get(1).toString()), series2, release);
			dataset.addValue(Integer.parseInt(seriesData.get(0).toString()), series1, release);
			
		}

		//		dataset.addValue(200, series1, "2016-12-19");

		return dataset;
	}

	/*Create Graph */

	private org.jfree.chart.JFreeChart createChart(final DefaultCategoryDataset dataset, final String title) {

		JFreeChart linechart = ChartFactory.createLineChart(title, // Chart title
				"X Axis", // X-Axis Label
				"Y Axis", // Y-Axis Label
				dataset);
		
		
		
		ChartPanel chartPanel = new ChartPanel(linechart);
		chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));
		chartPanel.setBackground(java.awt.Color.WHITE);


		return linechart;
	}

	private void setContentPane(ChartPanel chartPanel) {
		// TODO Auto-generated method stub

	}

	class BodyLayerStack<T> extends AbstractLayerTransform {

		private final SortedList<T> sortedList;
		private final FilterList<T> filterList;

		private final IDataProvider bodyDataProvider;
		private final DataLayer bodyDataLayer;

		private final SelectionLayer selectionLayer;

		public BodyLayerStack(List<T> values, IColumnPropertyAccessor<T> columnPropertyAccessor) {
			// wrapping of the list to show into GlazedLists
			// see http://publicobject.com/glazedlists/ for further information
			EventList<T> eventList = GlazedLists.eventList(values);
			TransformedList<T, T> rowObjectsGlazedList = GlazedLists.threadSafeList(eventList);

			// use the SortedList constructor with 'null' for the Comparator because the
			// Comparator
			// will be set by configuration
			this.sortedList = new SortedList<T>(rowObjectsGlazedList, null);
			// wrap the SortedList with the FilterList
			this.filterList = new FilterList<T>(getSortedList());

			this.bodyDataProvider = new ListDataProvider<T>(filterList, columnPropertyAccessor);
			this.bodyDataLayer = new DataLayer(getBodyDataProvider());

			// layer for event handling of GlazedLists and PropertyChanges
			GlazedListsEventLayer<T> glazedListsEventLayer = new GlazedListsEventLayer<T>(bodyDataLayer, filterList);

			this.selectionLayer = new SelectionLayer(glazedListsEventLayer);
			ViewportLayer viewportLayer = new ViewportLayer(getSelectionLayer());

			setUnderlyingLayer(viewportLayer);
		}

		public SelectionLayer getSelectionLayer() {
			return selectionLayer;
		}

		public SortedList<T> getSortedList() {
			return sortedList;
		}

		public FilterList<T> getFilterList() {
			return this.filterList;
		}

		public IDataProvider getBodyDataProvider() {
			return bodyDataProvider;
		}

		public DataLayer getBodyDataLayer() {
			return bodyDataLayer;
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
