 package com.lti.tableandgraph.views;

import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;

import com.lti.model.ModelProvider;
import com.lti.model.Person;


@SuppressWarnings("restriction")
public class BackupTableView extends ViewPart {
   // public static final String ID = "de.vogella.jface.tableviewer.view";

    private TableViewer viewer;
    private FormToolkit toolkit;
    private Form form;

    // We use icons
//    private static final Image CHECKED = Activator.getImageDescriptor(
//            "icons/checked.gif").createImage();
//    private static final Image UNCHECKED = Activator.getImageDescriptor(
//            "icons/unchecked.gif").createImage();

    public void createPartControl(Composite parent) {
        GridLayout layout1 = new GridLayout(2, false);
        parent.setLayout(layout1);
       // Label searchLabel = new Label(parent, SWT.NONE);
       // searchLabel.setText("Search: ");
        toolkit = new FormToolkit(parent.getDisplay());
        form = toolkit.createForm(parent);
        form.setText("Employee Information");
        TableWrapLayout layout = new TableWrapLayout();
        form.getBody().setLayout(layout);
        Hyperlink link = toolkit.createHyperlink(form.getBody(),"Click here.", SWT.WRAP);
        link.addHyperlinkListener(new HyperlinkAdapter() {
         public void linkActivated(HyperlinkEvent e) {
          System.out.println("Link activated!");
         }
        });
        link.setText("This is an example of a form that is much longer and will need to wrap.");
        
        
        layout.numColumns = 2;
        TableWrapData td = new TableWrapData();
        td.colspan = 2;
        link.setLayoutData(td);
        
        Label label = toolkit.createLabel(form.getBody(), "Text field label:");
        
        Text text = toolkit.createText(form.getBody(), "");
        td = new TableWrapData(TableWrapData.FILL_GRAB);
        text.setLayoutData(td);
        // Check boxx
        //Button button = toolkit.createButton(form.getBody(), "A checkbox in a form", SWT.CHECK);
        td = new TableWrapData();
        td.colspan = 2;
        //button.setLayoutData(td);
        
        
        
        // Search filter
        /*searchLabel.setText("Search: ");
        final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
        searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                | GridData.HORIZONTAL_ALIGN_FILL));*/
        createViewer(parent);
    }

    private void createViewer(Composite parent) {
    	
    	
    	
        viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        createColumns(parent, viewer);
        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        viewer.setContentProvider(new ArrayContentProvider());
        // Get the content for the viewer, setInput will call getElements in the
        // contentProvider
        viewer.setInput(ModelProvider.INSTANCE.getPersons());
        // make the selection available to other views
        getSite().setSelectionProvider(viewer);
        // Set the sorter for the table
        
        
        // Layout the viewer
        GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.FILL;
        gridData.horizontalSpan = 2;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;
        viewer.getControl().setLayoutData(gridData);
           }

    public TableViewer getViewer() {
        return viewer;
    }

    // This will create the columns for the table
    private void createColumns(final Composite parent, final TableViewer viewer) {
    	
    	 viewer.setContentProvider(ArrayContentProvider.getInstance());
         viewer.setInput("Employee Information");
        
    	
        String[] titles = {"Employee ID","Employee Designation", "First name", "Last name", "Gender", "Married" };
        int[] bounds = { 100, 100, 100, 100, 100, 100 };
        

        // First column is for the Employee ID
        TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return p.getEmployeeID();
            }
        });
        
        
     // Second column is for the Employee Designation
         col = createTableViewerColumn(titles[1], bounds[0], 0);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return p.getEmployeeDesignation();
            }
        });
        
        

        // Third column is for the first name
         col = createTableViewerColumn(titles[2], bounds[0], 0);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return p.getFirstName();
            }
        });

        // Fourth column is for the last name
        col = createTableViewerColumn(titles[3], bounds[1], 1);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return p.getLastName();
            }
        });

        // now the gender
        col = createTableViewerColumn(titles[4], bounds[2], 2);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return p.getGender();
            }
        });

        /* now the status married
        col = createTableViewerColumn(titles[5], bounds[3], 3);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return null;
            }
            */

//            @Override
//            public Image getImage(Object element) {
//                if (((Person) element).isMarried()) {
//                    return CHECKED;
//                } else {
//                    return UNCHECKED;
//                }
//            }
        //});

    }

    private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
       
    	
    	final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
                SWT.NONE);
        final TableColumn column = viewerColumn.getColumn();
        
        
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        return viewerColumn;

    }

    /**
     * Passing the focus request to the viewer's control.
     */
    public void setFocus() {
        viewer.getControl().setFocus();
    }
}