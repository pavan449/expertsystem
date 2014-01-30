package com.rit.ai.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartPanel;

import com.rit.ai.graph.GenerateGraph;

public class VisitLogsUtil {

	public static HashMap<String, Integer> locationGraphData;

	public ChartPanel generateLocationGraphForPH() {

		Map<String, Integer> graphData = new HashMap<String, Integer>();
		graphData.put("node1", locationGraphData.get("phsensor1"));
		graphData.put("node2", locationGraphData.get("phsensor2"));
		graphData.put("node3", locationGraphData.get("phsensor3"));
		GenerateGraph demo = new GenerateGraph("Location Based Pie Chart");
		ChartPanel graphPanel = demo
				.generateLocationBasedGraph(graphData);
		return graphPanel;
	}
	
	public ChartPanel generateLocationGraphForConductivity() {

		Map<String, Integer> graphData = new HashMap<String, Integer>();
		graphData.put("node1", locationGraphData.get("conductivitysensor1"));
		graphData.put("node2", locationGraphData.get("conductivitysensor2"));
		graphData.put("node3", locationGraphData.get("conductivitysensor3"));
		GenerateGraph demo = new GenerateGraph("Location Based Pie Chart");
		ChartPanel graphPanel = demo
				.generateLocationBasedGraph(graphData);
		return graphPanel;
	}
	
	public ChartPanel generateLocationGraphForSalinity() {

		Map<String, Integer> graphData = new HashMap<String, Integer>();
		graphData.put("node1", locationGraphData.get("salinitysensor1"));
		graphData.put("node2", locationGraphData.get("salinitysensor2"));
		graphData.put("node3", locationGraphData.get("salinitysensor3"));
		GenerateGraph demo = new GenerateGraph("Location Based Pie Chart");
		ChartPanel graphPanel = demo
				.generateLocationBasedGraph(graphData);
		return graphPanel;
	}
	
	public ChartPanel generateLocationGraphForDissolvedOxy() {

		Map<String, Integer> graphData = new HashMap<String, Integer>();
		graphData.put("node1", locationGraphData.get("oxygonsensor1"));
		graphData.put("node2", locationGraphData.get("oxygonsensor2"));
		graphData.put("node3", locationGraphData.get("oxygonsensor3"));
		GenerateGraph demo = new GenerateGraph("Location Based Pie Chart");
		ChartPanel graphPanel = demo
				.generateLocationBasedGraph(graphData);
		return graphPanel;
	}
	
	public ChartPanel generateLocationGraphForTemp() {

		Map<String, Integer> graphData = new HashMap<String, Integer>();
		graphData.put("node1", locationGraphData.get("temperaturesensor1"));
		graphData.put("node2", locationGraphData.get("temperaturesensor2"));
		graphData.put("node3", locationGraphData.get("temperaturesensor3"));
		GenerateGraph demo = new GenerateGraph("Location Based Pie Chart");
		ChartPanel graphPanel = demo
				.generateLocationBasedGraph(graphData);
		return graphPanel;
	}

}
