package com.lti.tableandgraph.views;


import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.util.Vector;

import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.nebula.visualization.xygraph.dataprovider.CircularBufferDataProvider;
import org.eclipse.nebula.visualization.xygraph.dataprovider.Sample;
import org.eclipse.nebula.visualization.xygraph.figures.ToolbarArmedXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.PointStyle;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.nebula.visualization.xygraph.util.XYGraphMediaFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;


public class GraphView extends ViewPart {

    private Button button;
       
    
    

    public GraphView() {	
        super();
    }

    public void createPartControl(Composite parent) {
    	parent.setLayout(new GridLayout(1, false));
    	//Canvas canvas = new Canvas(parent, SWT.NONE);
    	/* Code for the Graph View with the canvas*/
    	/*Canvas canvas = new Canvas(parent, SWT.NONE);
    	canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    	LightweightSystem lws = new LightweightSystem(canvas);*/
    	
    	
    	
    	/* code for the Graph view with the Shell */
    	/*final Shell shell = new Shell();
		shell.setSize(800, 500);
	    shell.open();
	    LightweightSystem lws = new LightweightSystem(shell);
    	XYGraphTest xyGraph = new XYGraphTest();
    	lws.setContents(xyGraph);*/
//    	
    	
//    	canvas = new Canvas(parent,SWT.DEFAULT);
//    	XYGraphTest xyGraph = new XYGraphTest();
//    	canvas.setLayoutData(xyGraph);
    	
    	/*************/
    	

//    
//        // Create the layout.
//        RowLayout layout = new RowLayout();
//        // Optionally set layout fields.
//        layout.wrap = true;
//        // Set the layout into the composite.
//        parent.setLayout(layout);
//        // Create the children of the composite.
//        new Button(parent, SWT.PUSH).setText("B1");
//        new Button(parent, SWT.PUSH).setText("Wide Button 2");
//        new Button(parent, SWT.PUSH).setText("Button 3");
//       
//        
//        
//    
//    	/* Button view */
//        button=new Button(parent,SWT.DEFAULT);
//        button.setText("Click for graph");
//        button.setSize(50, 50);
//        button.setLocation(10,75);
//
//        /*Table*/
//        parent.setLayout(new GridLayout(2, false));
//		
//		Label nameLabel = new Label(parent, SWT.NONE);
//		nameLabel.setText("Name:");
//		
//		Text nameText = new Text(parent, SWT.BORDER);
//		GridData gridData = new GridData();
//		gridData.horizontalAlignment = SWT.FILL;
//		gridData.grabExcessHorizontalSpace = true;
//		nameText.setLayoutData(gridData);
//		nameText.setText("Text grows horizontally");
//		
//		Label addressLabel = new Label(parent, SWT.NONE);
//		addressLabel.setText("Address:");
//		gridData = new GridData();
//		gridData.verticalAlignment = SWT.TOP;
//		addressLabel.setLayoutData(gridData);
//		
//		Text addressText = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
//		gridData = new GridData();
//		gridData.horizontalAlignment = SWT.FILL;
//		gridData.grabExcessHorizontalSpace = true;
//		gridData.verticalAlignment = SWT.FILL;
//		gridData.grabExcessVerticalSpace = true;
//		addressText.setLayoutData(gridData);
//		addressText.setText("This text field and the List\nbelow share any excess space.");
//
//		Label sportsLabel = new Label(parent, SWT.NONE);
//		sportsLabel.setText("Sports played:");
//		gridData = new GridData();
//		gridData.horizontalSpan = 2;
//		sportsLabel.setLayoutData(gridData);
//		
//		List sportsList = new List(parent, SWT.BORDER | SWT.MULTI);
//		gridData = new GridData();
//		gridData.horizontalSpan = 2;
//		gridData.horizontalAlignment = SWT.FILL;
//		gridData.grabExcessHorizontalSpace = true;
//		gridData.verticalAlignment = SWT.FILL;
//		gridData.grabExcessVerticalSpace = true;
//		sportsList.setLayoutData(gridData);
//		sportsList.add("Hockey");
//		sportsList.add("Street Hockey");
				

		/* To get the full data*/

    	
    	
    }

    @Override
    public void setFocus() {
        button.setFocus();
    }

}
