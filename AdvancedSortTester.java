/*Project: Advanced sort test with file output and graph display.
 * Name:Adam Pluguez
 * Date: 3/21/2017 
 * Version:1.0
 * Purpose: Tests Merge sort and Quick sort on n = (10000-1000000) integers. 
 * These are randomly sorted,then sorted, and finally reverse sorted.
 * All results are written to AdvancedSortTimes.txt.
 * The results are then directly converted into three line graphs and displayed on screen.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class AdvancedSortTester extends Application{
	
	private static long[] results = new long[24];
	
	public static void main(String[] args) {
		
		int k = 0;
		String dataFile = "AdvancedSortTimes.csv";


		//open the file  PrintWriter
		PrintWriter outputStream = null;

		//Exception catching
		try{
			outputStream = new PrintWriter(dataFile);
		}
		catch (FileNotFoundException e){
			System.out.println("Error opening the file " + dataFile);
			System.exit(0);
		}
		outputStream.println(",Random Items");
		outputStream.println("NumberOfElements, MergeSort, QuickSort");
		for(int n = 10000; n <= 10000000; n*=10){

			int[] intArray = new int[n];
			int[] intArray2 = new int[n];

			//fill the array with size number of Random numbers
			for(int i = 0; i < intArray.length; i++)
				intArray[i] = (int)(Math.random()*n); //random

			//fill the array with size number of Sorted numbers
			for(int i = 0; i < intArray2.length; i++)
				intArray2[i] = (int)(Math.random()*n); //random

	
			//Tests Merge sort sort 
			long startTime = System.currentTimeMillis();			
			MergeSort.mergeSort(intArray);
			long endTime = System.currentTimeMillis();
			results[k++] = (endTime - startTime);
			outputStream.print(n + "," + (endTime - startTime)  + ",");

			//Tests Quick sort 			
			long startTime3 = System.currentTimeMillis();			
			QuickSort.quickSort(intArray2);
			long endTime3 = System.currentTimeMillis();
			results[k++] = (endTime3 - startTime3);
			outputStream.print((endTime3 - startTime3) + ", milliseconds");
			outputStream.println();
			

		}
		
		outputStream.println(",Sorted Items");
		outputStream.println("NumberOfElements, MergeSort, QuickSort");
		for(int n = 10000; n <= 10000000; n*=10){

			int[] intArray4 = new int[n];
			int[] intArray5 = new int[n];
	

			//fill the array with size number of sorted numbers
			for(int i = 0; i < intArray4.length; i++)
				intArray4[i] = i; //random

			//fill the array with size number of sorted numbers
			for(int i = 0; i < intArray5.length; i++)
				intArray5[i] = i; //random
		
			//Tests mergesort sort 
			long startTime = System.currentTimeMillis();			
			MergeSort.mergeSort(intArray4);
			long endTime = System.currentTimeMillis();
			results[k++] = (endTime - startTime);
			outputStream.print(n + "," + (endTime - startTime) + ","); 

			//Tests Quick sort 			
			
			long startTime3 = System.currentTimeMillis();			
			QuickSort.quickSort(intArray5);
			long endTime3 = System.currentTimeMillis();
			results[k++] = (endTime3 - startTime3);
			outputStream.print((endTime3 - startTime3) + ", milliseconds");
			outputStream.println();

		}
		
		outputStream.println(",Reversed Items");
		outputStream.println("NumberOfElements, MergeSort, QuickSort");
		for(int n = 10000; n <= 10000000; n*=10){

			int[] intArray7 = new int[n];
			int[] intArray8 = new int[n];
			
			//fill the array with size number of reversed numbers
			for(int i = 0; i < intArray7.length; i++)
				intArray7[i] = intArray7.length - i; 

			//fill the array with size number of reversed numbers
			for(int i = 0; i < intArray8.length; i++)
				intArray8[i] = intArray8.length - i; 


			//Tests mergesort sort 
			long startTime = System.currentTimeMillis();			
			MergeSort.mergeSort(intArray7);
			long endTime = System.currentTimeMillis();
			results[k++] = (endTime - startTime);
			outputStream.print(n + "," + (endTime - startTime) + ","); 

			//Tests Quick sort 			

			long startTime3 = System.currentTimeMillis();			
			QuickSort.quickSort(intArray8);
			long endTime3 = System.currentTimeMillis();
			results[k++] = (endTime3 - startTime3);
			outputStream.print((endTime3 - startTime3) + ", milliseconds");
			outputStream.println();

		}
		System.out.println("All timing data has been written to " + dataFile + ".");
		outputStream.close();

		//Launches Graphs
		launch(args);

	}//End Main

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage primaryStage) {

		//Defines the x and y axis for all three line charts
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Number of Items");
		yAxis.setLabel("Milliseconds Passed");
		NumberAxis xAxis2 = new NumberAxis();
		NumberAxis yAxis2 = new NumberAxis();
		xAxis2.setLabel("Number of Items");
		yAxis2.setLabel("Milliseconds Passed");
		NumberAxis xAxis3 = new NumberAxis();
		NumberAxis yAxis3 = new NumberAxis();
		xAxis3.setLabel("Number of Items");
		yAxis3.setLabel("Milliseconds Passed");

		//Creates Three Line Charts and sets titles
		LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
		LineChart<Number, Number> lineChart2 = new LineChart<Number,Number>(xAxis2,yAxis2);
		LineChart<Number, Number> lineChart3 = new LineChart<Number,Number>(xAxis3,yAxis3);
		lineChart.setTitle("Random Numbers");
		lineChart2.setTitle("Sorted Numbers");
		lineChart3.setTitle("Reverse Ordered Numbers");
		
		//Graph Size Adjustment
		lineChart.setMinSize(375, 375);
		lineChart.setMaxSize(375, 375);
		lineChart2.setMinSize(375, 375);
		lineChart2.setMaxSize(375, 375);
		lineChart3.setMinSize(375, 375);
		lineChart3.setMaxSize(375, 375);

		//Defining all data  for each series.
		//Random Data
		XYChart.Series series = new XYChart.Series();
		series.setName("Merge Sort");
		
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Quick Sort");
		//Sorted Data
		XYChart.Series series4 = new XYChart.Series();
		series4.setName("Merge Sort");
		
		XYChart.Series series6 = new XYChart.Series();
		series6.setName("Quick Sort");
		//Reversed Data
		XYChart.Series series7 = new XYChart.Series();
		series7.setName("Merge Sort");
		
		XYChart.Series series9 = new XYChart.Series();
		series9.setName("Quick Sort");

		//Populates each series with data.
		//Random Data
		series.getData().add(new XYChart.Data(10000, results[0]));
		series.getData().add(new XYChart.Data(100000, results[2]));
		series.getData().add(new XYChart.Data(1000000, results[4]));	
		series.getData().add(new XYChart.Data(10000000, results[6]));
		
		series3.getData().add(new XYChart.Data(10000, results[1]));
		series3.getData().add(new XYChart.Data(100000, results[3]));
		series3.getData().add(new XYChart.Data(1000000, results[5]));
		series3.getData().add(new XYChart.Data(10000000, results[7]));
		

		//Sorted Data
		series4.getData().add(new XYChart.Data(10000, results[8]));
		series4.getData().add(new XYChart.Data(100000, results[10]));
		series4.getData().add(new XYChart.Data(1000000, results[12]));	
		series4.getData().add(new XYChart.Data(10000000, results[14]));	
		
		series6.getData().add(new XYChart.Data(10000, results[9]));
		series6.getData().add(new XYChart.Data(100000, results[11]));
		series6.getData().add(new XYChart.Data(1000000, results[13]));		
		series6.getData().add(new XYChart.Data(10000000, results[15]));
		
		//Reversed Data
		series7.getData().add(new XYChart.Data(10000, results[16]));
		series7.getData().add(new XYChart.Data(100000, results[18]));
		series7.getData().add(new XYChart.Data(1000000, results[20]));
		series7.getData().add(new XYChart.Data(10000000, results[22]));
		
		series9.getData().add(new XYChart.Data(10000, results[17]));
		series9.getData().add(new XYChart.Data(100000, results[19]));
		series9.getData().add(new XYChart.Data(1000000, results[21]));
		series9.getData().add(new XYChart.Data(10000000, results[23]));


		//Creates flowpane to put all three graphs on scene
		FlowPane root = new FlowPane();
		root.getChildren().addAll(lineChart, lineChart2, lineChart3);
		Scene scene = new Scene(root, 800, 600);

		//Adds data to the charts
		lineChart.getData().add(series);

		lineChart.getData().add(series3);
		lineChart2.getData().add(series4);

		lineChart2.getData().add(series6);
		lineChart3.getData().add(series7);

		lineChart3.getData().add(series9);

		//Set title and main window size
		primaryStage.setTitle("Advanced Sorting Data Chart");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

