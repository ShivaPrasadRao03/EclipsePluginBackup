//package com.lti.nebulaexamples;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//
//import org.eclipse.jface.layout.GridDataFactory;
//import org.eclipse.nebula.widgets.nattable.NatTable;
//import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
//import org.eclipse.nebula.widgets.nattable.config.ConfigRegistry;
//import org.eclipse.nebula.widgets.nattable.config.DefaultNatTableStyleConfiguration;
//import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
//import org.eclipse.nebula.widgets.nattable.data.IColumnPropertyAccessor;
//import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
//import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
//import org.eclipse.nebula.widgets.nattable.data.ReflectiveColumnPropertyAccessor;
//import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
//import org.eclipse.nebula.widgets.nattable.extension.glazedlists.GlazedListsEventLayer;
//import org.eclipse.nebula.widgets.nattable.extension.glazedlists.filterrow.ComboBoxFilterRowHeaderComposite;
//
//import org.eclipse.nebula.widgets.nattable.extension.glazedlists.GlazedListsEventLayer;
//import com.lti.richtext.MarkupDisplayConverter;
//import com.lti.richtext.RegexMarkupValue;
//import com.lti.richtext.RichTextCellPainter;
//
//
//import org.eclipse.nebula.widgets.nattable.painter.NatTableBorderOverlayPainter;
//import org.eclipse.nebula.widgets.nattable.painter.cell.BackgroundPainter;
//import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.PaddingDecorator;
//
//	
//import org.eclipse.nebula.widgets.nattable.filterrow.combobox.ComboBoxFilterIconPainter;
//import org.eclipse.nebula.widgets.nattable.filterrow.combobox.ComboBoxFilterRowConfiguration;
//import org.eclipse.nebula.widgets.nattable.filterrow.combobox.FilterRowComboBoxCellEditor;
//import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
//import org.eclipse.nebula.widgets.nattable.grid.data.DefaultColumnHeaderDataProvider;
//import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
//import org.eclipse.nebula.widgets.nattable.grid.data.DefaultRowHeaderDataProvider;
//import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
//import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
//import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
//import org.eclipse.nebula.widgets.nattable.grid.layer.RowHeaderLayer;
//import org.eclipse.nebula.widgets.nattable.layer.AbstractLayerTransform;
//import org.eclipse.nebula.widgets.nattable.layer.CompositeLayer;
//import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
//import org.eclipse.nebula.widgets.nattable.layer.ILayer;
//import org.eclipse.nebula.widgets.nattable.painter.cell.BackgroundPainter;
//import org.eclipse.nebula.widgets.nattable.persistence.command.DisplayPersistenceDialogCommandHandler;
//import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
//import org.eclipse.nebula.widgets.nattable.ui.menu.HeaderMenuConfiguration;
//import org.eclipse.nebula.widgets.nattable.ui.menu.PopupMenuBuilder;
//import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
//import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.events.ModifyListener;
//import org.eclipse.swt.layout.GridLayout;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Text;
//import org.eclipse.ui.part.ViewPart;
//
//import com.lti.model.*;
//import com.lti.service.*;
//
//import ca.odell.glazedlists.EventList;
//import ca.odell.glazedlists.FilterList;
//import ca.odell.glazedlists.GlazedLists;
//import ca.odell.glazedlists.SortedList;
//import ca.odell.glazedlists.TransformedList;
//
//import ca.odell.glazedlists.matchers.TextMatcherEditor;
//public class FilterRowConfiguration extends ViewPart{
//
//    @Override
//    public void createPartControl(Composite parent) {
//    	 Composite panel = new Composite(parent, SWT.NONE);
//    	 Text input = new Text(panel, SWT.SINGLE | SWT.SEARCH | SWT.ICON_CANCEL);
//         input.setMessage("type filter text");
//         GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
//
//
//    	//create a new ConfigRegistry which will be needed for GlazedLists handling
//    			ConfigRegistry configRegistry = new ConfigRegistry();
//        parent.setLayout(new GridLayout());
//        
//        List<Person> myList = new ArrayList<Person>();
//		myList.add(new Person("LT-1","shivaPrasad","G","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-2","Santhosh","P","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-3","Alen","T","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-4","Vicky","R","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-5","Ram","M","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-6","Harish","Y","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-7","Sneha","T","SoftwareEngineer","Female"));
//		myList.add(new Person("LT-8","Charan","P","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-9","Rahul","L","SoftwareEngineer","Male"));
//		myList.add(new Person("LT-10","Deepa","P","SoftwareEngineer","Female"));
//
//		
//		
//        // property names of the Person class
//        String[] propertyNames = {
//                "employeeID",
//                "employeeDesignation",
//                "firstName",
//                "lastName",
//                "gender" };
//
//        // mapping from property to label, needed for column header labels
//        Map<String, String> propertyToLabelMap = new HashMap<String, String>();
//        propertyToLabelMap.put("EmployeeID", propertyNames[0]);
//        propertyToLabelMap.put("EmployeeDesignation", propertyNames[1]);
//        propertyToLabelMap.put("EmployeeFirstName", propertyNames[2]);
//        propertyToLabelMap.put("EmployeeLastName", propertyNames[3]);
//        propertyToLabelMap.put("Gender", propertyNames[4]);
//
//        IColumnPropertyAccessor<Person> columnPropertyAccessor =
//                new ReflectiveColumnPropertyAccessor<Person>(propertyNames);
//
//        //body layer stack
//        BodyLayerStack<Person> bodyLayerStack = 
//				new BodyLayerStack<Person>(myList, columnPropertyAccessor);
//        
//        // build the body layer stack
//        IDataProvider bodyDataProvider =
//                new ListDataProvider<Person>(
//                        myList,
//                        columnPropertyAccessor);
//        DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
//        SelectionLayer selectionLayer = new SelectionLayer(bodyDataLayer);
//        ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);
//
//        // build the column header layer stack
//        IDataProvider columnHeaderDataProvider =
//                new DefaultColumnHeaderDataProvider(propertyNames, propertyToLabelMap);
//        DataLayer columnHeaderDataLayer =
//                new DataLayer(columnHeaderDataProvider);
//        ILayer columnHeaderLayer =
//                new ColumnHeaderLayer(columnHeaderDataLayer, viewportLayer, selectionLayer);
//
//        
//        
//        CompositeLayer composite = new CompositeLayer(1, 2);
//        composite.setChildLayer(GridRegion.COLUMN_HEADER, columnHeaderLayer, 0, 0);
//        composite.setChildLayer(GridRegion.BODY, bodyLayerStack, 0, 1);
//
//        RegexMarkupValue regexMarkup = new RegexMarkupValue("",
//                "",
//                "");
//
//        
//        
//        NatTable natTable = new NatTable(panel, composite, false);
//        natTable.addConfiguration(new DefaultNatTableStyleConfiguration() {
//            {
//                this.cellPainter = new BackgroundPainter(
//                        new PaddingDecorator(new RichTextCellPainter(), 2));
//            }
//
//            @Override
//            public void configureRegistry(IConfigRegistry configRegistry) {
//                super.configureRegistry(configRegistry);
//
//                // markup for highlighting
//                MarkupDisplayConverter markupConverter = new MarkupDisplayConverter();
//                markupConverter.registerMarkup("highlight", regexMarkup);
//                // register markup display converter for normal displaymode in
//                // the body
//                configRegistry.registerConfigAttribute(
//                        CellConfigAttributes.DISPLAY_CONVERTER,
//                        markupConverter,
//                        DisplayMode.NORMAL,
//                        GridRegion.BODY);
//            }
//        });
//        natTable.configure();
//
//     // define a TextMatcherEditor and set it to the FilterList
//        TextMatcherEditor matcherEditor = new TextMatcherEditor<>(new TextFilterator() {
//
//            public void getFilterStrings(List<Person> myList, Person element) {
//                // add all values that should be included in filtering
//                // Note:
//                // if special converters are involved in rendering,
//                // consider using them for adding the String values
//                myList.add(element.getEmployeeID());
//                myList.add(element.getFirstName());
//                myList.add("" + element.getLastName());
//                myList.add("" + element.getEmployeeDesignation());
//                myList.add("" + element.getAge());
//                myList.add("" +element.getGender());
//                
//            }
//        });
//        matcherEditor.setMode(TextMatcherEditor.CONTAINS);
//        bodyLayerStack.getFilterList().setMatcherEditor(matcherEditor);
//
//        // connect the input field with the matcher
//        input.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
//                    String text = input.getText();
//                    matcherEditor.setFilterText(new String[] { text });
//                    regexMarkup.setRegexValue(text.isEmpty() ? "" : "(" + text + ")");
//                    natTable.refresh(false);
//                }
//            }
//        });
//
//        input.addModifyListener(new ModifyListener() {
//
//            @Override
//            public void modifyText(ModifyEvent e) {
//                String text = input.getText();
//                if (text == null || text.isEmpty()) {
//                    matcherEditor.setFilterText(new String[] {});
//                    regexMarkup.setRegexValue("");
//                    natTable.refresh(false);
//                }
//            }
//        });
//
//        return natTable;
//
//    }
//
//
//
//	@Override
//	public void setFocus() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//class BodyLayerStack<T> extends AbstractLayerTransform {
//		
//	
//	 private final FilterList filterList;
//
//     public BodyLayerStack(List values, IColumnPropertyAccessor columnPropertyAccessor) {
//         EventList eventList = GlazedLists.eventList(values);
//         TransformedList rowObjectsGlazedList = GlazedLists.threadSafeList(eventList);
//
//         this.filterList = new FilterList<>(rowObjectsGlazedList);
//
//         IDataProvider bodyDataProvider = new ListDataProvider<>(this.filterList, columnPropertyAccessor);
//         DataLayer bodyDataLayer = new DataLayer(bodyDataProvider);
//
//         bodyDataLayer.setColumnWidthByPosition(2, 70);
//         bodyDataLayer.setColumnWidthByPosition(3, 70);
//         bodyDataLayer.setColumnWidthByPosition(4, 200);
//         bodyDataLayer.setColumnWidthByPosition(8, 110);
//
//         GlazedListsEventLayer glazedListsEventLayer =
//                 new GlazedListsEventLayer<>(bodyDataLayer, this.filterList);
//
//         ViewportLayer viewportLayer = new ViewportLayer(glazedListsEventLayer);
//
//         setUnderlyingLayer(viewportLayer);
//     }
//
//     public FilterList getFilterList() {
//         return this.filterList;
//     }
//
//
//}