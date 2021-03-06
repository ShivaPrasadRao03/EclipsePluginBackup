package com.lti.charts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.util.Rotation;

public class PieChartView extends ViewPart {

 @Override
 public void createPartControl(Composite parent) {
  final PieDataset dataset = createDataset();
  final JFreeChart chart = createChart(dataset, "Operating Systems");

  new ChartComposite(parent, SWT.NONE, chart, true);
 }

 private PieDataset createDataset() {
  final DefaultPieDataset result = new DefaultPieDataset();
  result.setValue("Linux", 29);
  result.setValue("Mac", 20);
  result.setValue("Windows", 51);
  return result;
 }

 private org.jfree.chart.JFreeChart createChart(final PieDataset dataset, final String title) {
  final JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
 
  final PiePlot3D plot = (PiePlot3D) chart.getPlot();
  plot.setStartAngle(290);
  plot.setDirection(Rotation.CLOCKWISE);
  plot.setForegroundAlpha(0.5f);
  return chart;
 }

 @Override
 public void setFocus() {
 }
}