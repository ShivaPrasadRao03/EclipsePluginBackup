package com.lti.nebulaexamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.DefaultNatTableStyleConfiguration;
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
import org.eclipse.nebula.widgets.nattable.persistence.command.DisplayPersistenceDialogCommandHandler;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.ui.menu.HeaderMenuConfiguration;
import org.eclipse.nebula.widgets.nattable.ui.menu.PopupMenuBuilder;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.lti.model.*;
import com.lti.service.*;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.TransformedList;
public class NatTableGridExamplePart extends ViewPart{

    @Override
    public void createPartControl(Composite parent) {
    	
    	//create a new ConfigRegistry which will be needed for GlazedLists handling
    			ConfigRegistry configRegistry = new ConfigRegistry();
        parent.setLayout(new GridLayout());
        
        List<Person> myList = new ArrayList<Person>();
		myList.add(new Person("LT-1","shivaPrasad","G","SoftwareEngineer","Male"));
		myList.add(new Person("LT-2","Santhosh","P","SoftwareEngineer","Male"));
		myList.add(new Person("LT-3","Alen","T","SoftwareEngineer","Male"));
		myList.add(new Person("LT-4","Vicky","R","SoftwareEngineer","Male"));
		myList.add(new Person("LT-5","Ram","M","SoftwareEngineer","Male"));
		myList.add(new Person("LT-6","Harish","Y","SoftwareEngineer","Male"));
		myList.add(new Person("LT-7","Sneha","T","SoftwareEngineer","Female"));
		myList.add(new Person("LT-8","Charan","P","SoftwareEngineer","Male"));
		myList.add(new Person("LT-9","Rahul","L","SoftwareEngineer","Male"));
		myList.add(new Person("LT-10","Deepa","P","SoftwareEngineer","Female"));

		
		
        // property names of the Person class
        String[] propertyNames = {
                "employeeID",
                "employeeDesignation",
                "firstName",
                "lastName",
                "gender" };

        // mapping from property to label, needed for column header labels
        Map<String, String> propertyToLabelMap = new HashMap<String, String>();
        propertyToLabelMap.put("EmployeeID", propertyNames[0]);
        propertyToLabelMap.put("EmployeeDesignation", propertyNames[1]);
        propertyToLabelMap.put("EmployeeFirstName", propertyNames[2]);
        propertyToLabelMap.put("EmployeeLastName", propertyNames[3]);
        propertyToLabelMap.put("Gender", propertyNames[4]);

        IColumnPropertyAccessor<Person> columnPropertyAccessor =
                new ReflectiveColumnPropertyAccessor<Person>(propertyNames);

        //body layer stack
        BodyLayerStack<Person> bodyLayerStack = 
				new BodyLayerStack<Person>(myList, columnPropertyAccessor);
        
        // build the body layer stack
        IDataProvider bodyDataProvider =
                new ListDataProvider<Person>(
                        myList,
                        columnPropertyAccessor);
        DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
        SelectionLayer selectionLayer = new SelectionLayer(bodyDataLayer);
        ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);

        // build the column header layer stack
        IDataProvider columnHeaderDataProvider =
                new DefaultColumnHeaderDataProvider(propertyNames, propertyToLabelMap);
        DataLayer columnHeaderDataLayer =
                new DataLayer(columnHeaderDataProvider);
        ILayer columnHeaderLayer =
                new ColumnHeaderLayer(columnHeaderDataLayer, viewportLayer, selectionLayer);

        
      //example on how to configure a different icon if a filter is applied
      		ComboBoxFilterRowHeaderComposite<Person> filterRowHeaderLayer =
      				new ComboBoxFilterRowHeaderComposite<Person>(
      						bodyLayerStack.getFilterList(), bodyLayerStack.getBodyDataLayer(), bodyLayerStack.getSortedList(), 
      						columnPropertyAccessor, columnHeaderLayer, columnHeaderDataProvider, configRegistry, false);
      		final IComboBoxDataProvider comboBoxDataProvider = filterRowHeaderLayer.getComboBoxDataProvider();
      		filterRowHeaderLayer.addConfiguration(new ComboBoxFilterRowConfiguration() {
      			{
      				this.cellEditor = new FilterRowComboBoxCellEditor(comboBoxDataProvider, 5);
      				this.filterIconPainter = new ComboBoxFilterIconPainter(comboBoxDataProvider, GUIHelper.getImage("filter"), null);
      			}
      		});
      		
      	
        
        // build the row header layer stack
        IDataProvider rowHeaderDataProvider =
                new DefaultRowHeaderDataProvider(bodyDataProvider);
        DataLayer rowHeaderDataLayer =
                new DataLayer(rowHeaderDataProvider, 40, 20);
        ILayer rowHeaderLayer =
                new RowHeaderLayer(rowHeaderDataLayer, viewportLayer, selectionLayer);

        // build the corner layer stack
        ILayer cornerLayer = new CornerLayer(
                new DataLayer(
                        new DefaultCornerDataProvider(columnHeaderDataProvider, rowHeaderDataProvider)),
                rowHeaderLayer,
                columnHeaderLayer);

        
        
        // create the grid layer composed with the prior created layer stacks
        GridLayer gridLayer =
                new GridLayer(viewportLayer, columnHeaderLayer, rowHeaderLayer, cornerLayer);

        NatTable natTable = new NatTable(parent, gridLayer);
        
        

        GridDataFactory.fillDefaults().grab(true, true).applyTo(natTable);
    }



	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
class BodyLayerStack<T> extends AbstractLayerTransform {
		
		private final SortedList<T> sortedList;
		private final FilterList<T> filterList;
		
		private final IDataProvider bodyDataProvider;
		private final DataLayer bodyDataLayer;
		
		private final SelectionLayer selectionLayer;
		
		public BodyLayerStack(List<T> values, IColumnPropertyAccessor<T> columnPropertyAccessor) {
			//wrapping of the list to show into GlazedLists
			//see http://publicobject.com/glazedlists/ for further information
			EventList<T> eventList = GlazedLists.eventList(values);
			TransformedList<T, T> rowObjectsGlazedList = GlazedLists.threadSafeList(eventList);
			
			//use the SortedList constructor with 'null' for the Comparator because the Comparator
			//will be set by configuration
			this.sortedList = new SortedList<T>(rowObjectsGlazedList, null);
			// wrap the SortedList with the FilterList
			this.filterList = new FilterList<T>(getSortedList());
			
			this.bodyDataProvider = 
				new ListDataProvider<T>(filterList, columnPropertyAccessor);
			this.bodyDataLayer = new DataLayer(getBodyDataProvider());
			
			//layer for event handling of GlazedLists and PropertyChanges
			GlazedListsEventLayer<T> glazedListsEventLayer = 
				new GlazedListsEventLayer<T>(bodyDataLayer, filterList);

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

}