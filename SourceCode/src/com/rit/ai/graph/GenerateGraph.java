package com.rit.ai.graph;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

public class GenerateGraph extends ApplicationFrame {

	public GenerateGraph(String title) {
		super(title);

	}

	public ChartPanel generateRequestBasedGraph(
			Map<String, ArrayList<String>> parsedData) {
		XYDataset dataset = createDataset(parsedData);
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart, false);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		chartPanel.setMouseZoomable(true, false);
		return chartPanel;
	}

	public ChartPanel generateLocationBasedGraph(Map<String, Integer> pieData) {

		JFreeChart chart = createPieChart(createPieDataset(pieData));
		return new ChartPanel(chart);

	}

	private PieDataset createPieDataset(Map<String, Integer> pieData) {
		 DefaultPieDataset dataset = new DefaultPieDataset();
	     Iterator it = pieData.entrySet().iterator();
	     while (it.hasNext()) {
	    	 	  Map.Entry pairs = (Map.Entry) it.next();
				  String location=pairs.getKey().toString();
				  int numberOfIp=Integer.parseInt(pairs.getValue().toString());
				  dataset.setValue(location, numberOfIp);
		}
		 return dataset;
	}

	private JFreeChart createPieChart(PieDataset dataset) {

		JFreeChart chart = ChartFactory.createPieChart(
				"Error rate of a sensor", // chart title
				dataset, // data
				true, // include legend
				true, false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.02);
		return chart;

	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            a dataset.
	 * 
	 * @return A chart.
	 */
	private static JFreeChart createChart(XYDataset dataset) {

		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"Number Of request per minute", // title
				"Date", // x-axis label
				"Number of request", // y-axis label
				dataset, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);

		chart.setBackgroundPaint(Color.white);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

		return chart;

	}

	/**
	 * Creates a dataset, consisting of two series of monthly data.
	 * 
	 * @param parsedData
	 * 
	 * @return The dataset.
	 */
	private static XYDataset createDataset(
			Map<String, ArrayList<String>> parsedData) {

		TimeSeries s2 = new TimeSeries(" Number Of request per Minute");
		Iterator it = parsedData.entrySet().iterator();

		while (it.hasNext()) {

			Map.Entry pairs = (Map.Entry) it.next();
			SimpleDateFormat dateParser = new SimpleDateFormat(
					"dd'/'MMM'/'yyyy':'HH':'mm");
			Date d = null;
			try {
				d = dateParser.parse(pairs.getKey().toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count = ((ArrayList<String>) pairs.getValue()).size();
		//	System.out.println("   aa  " + new Day(d));

			s2.add(new Millisecond(d), count);

		}

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s2);
		return dataset;

	}

	/**
	 * Starting point for the demonstration application.
	 * 
	 * @param args
	 *            ignored.
	 */
	public static void main(String[] args) {

		/*
		 * TimeSeriesChartDemo1 demo = new TimeSeriesChartDemo1(
		 * "Time Series Chart Demo 1" ); demo.pack();
		 * RefineryUtilities.centerFrameOnScreen(demo); demo.setVisible(true);
		 */
	}

}