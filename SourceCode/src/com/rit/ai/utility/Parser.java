package com.rit.ai.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.rit.ai.bo.Node;

public class Parser {
public static void main(String[] args){
	new Parser().parseFile("dataset1.txt");
}
	
	public ArrayList<Node> parseFile(String fileName) {
		// TODO Auto-generated method stub
		ArrayList<Node> nodeList = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String readLine;
			
			
			int i=0, nodeCounter = 0;
			Node node1 = null;
			StringTokenizer st = null;
			br.readLine();
			while(nodeCounter<3){
				 node1 = new Node();
				 
				nodeCounter++;
				while(((readLine = br.readLine()) != null) && i<10){
					i++;
					st = new StringTokenizer(readLine);
					
						node1.getPhSensor().getValues().add(Float.parseFloat(st.nextToken()));
						node1.getSalinitySensor().getValues().add(Float.parseFloat(st.nextToken()));
						node1.getTempSensor().getValues().add(Integer.parseInt(st.nextToken()));
						node1.getConductivity().getValues().add(Float.parseFloat(st.nextToken()));
						node1.getDissolvedOxySensor().getValues().add(Float.parseFloat(st.nextToken()));
						
						node1.getTimeLastCalibration().add(Float.parseFloat(st.nextToken()));
						node1.getTimeLastMaintainence().add(Float.parseFloat(st.nextToken()));
					
				}
				nodeList.add(node1);
				i=0;
			
				
			}
			System.out.println("dddd "+node1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		return nodeList;
	}

}
