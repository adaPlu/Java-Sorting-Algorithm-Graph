/*Project: Sort test with file output and graph display.
 * Name:Adam Pluguez
 * Date: 2/17/2017 
 * Version:1.0
 * Purpose: Tests bubble sort, insertion sort, and select sort on n = (1000-100000) integers. 
 * These are randomly sorted,then sorted, and finally reverse sorted.
 * All results are written to SortTimes.txt.
 * The results are then directly converted into three line graphs.
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


public class SortTesterCSV extends Application{
	
	private static long[] results = new long[27];
	
	public static void main(String[] args) {
		
		int k = 0;
		String dataFile = "SortTimes.csv";


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
		for(int n = 1000; n < 1000000; n*=10){

			int[] intArray = new int[n];
			int[] intArray2 = new int[n];
			int[] intArray3 = new int[n];

			//fill the array with size number of Random numbers
			for(int i = 0; i < intArray.length; i++)
				intArray[i] = (int)(Math.random()*n); 

			//fill the array with size number of Random numbers
			for(int i = 0; i < intArray2.length; i++)
				intArray2[i] = (int)(Math.random()*n); 

			//fill the array with size number of Random numbers
			for(int i = 0; i < intArray3.length; i++)
				intArray3[i] = (int)(Math.random()*n);

			outputStream.println("Sorting " + n + " random items....");
			//Tests bubble sort 
			long startTime = System.currentTimeMillis();
			BubbleSort.bubbleSort(intArray);
			long endTime = System.currentTimeMillis(); 
			results[k++] = (endTime - startTime);
			outputStream.println( n + "," + (endTime - startTime) +  ",milliseconds,Bubble Sort");


			//Tests insertions sort 			

			long startTime3 = System.currentTimeMillis();			
			InsertionSort.insertionSort(intArray2);
			long endTime3 = System.currentTimeMillis();
			results[k++] = (endTime3 - startTime3);
			outputStream.println( n + "," + (endTime3 - startTime3) +  ",milliseconds,Insertion Sort");

			
			//Tests select sort 
			
			long startTime5 = System.currentTimeMillis();
			SelectionSort.selectionSort(intArray3);
			long endTime5 = System.currentTimeMillis();
			results[k++] = (endTime5 - startTime5);
			outputStream.println( n + "," + (endTime5 - startTime5) +  ",milliseconds,Select Sort");
			outputStream.println();

		}

		for(int n = 1000; n < 1000000; n*=10){


			int[] intArray4 = new int[n];
			int[] intArray5 = new int[n];
			int[] intArray6 = new int[n];

			//fill the array with size number of sorted numbers
			for(int i = 0; i < intArray4.length; i++)
				intArray4[i] = i; 

			//fill the array with size number of sorted numbers
			for(int i = 0; i < intArray5.length; i++)
				intArray5[i] = i;

			//fill the array with size number of sorted numbers
			for(int i = 0; i < intArray6.length; i++)
				intArray6[i] = i; 

			outputStream.println("Sorting " + n + " sorted items....");
			//Tests bubble sort 
			long startTime = System.currentTimeMillis();
			BubbleSort.bubbleSort(intArray4);
			long endTime = System.currentTimeMillis(); 
			results[k++] = (endTime - startTime);
			outputStream.println( n + "," + (endTime - startTime) +  ",milliseconds,Bubble Sort");


			//Tests insertions sort 			

			long startTime3 = System.currentTimeMillis();			
			InsertionSort.insertionSort(intArray5);
			long endTime3 = System.currentTimeMillis();
			results[k++] = (endTime3 - startTime3);
			outputStream.println( n + "," + (endTime3 - startTime3) +  ",milliseconds,Insertion Sort");

			
			//Tests select sort 
			
			long startTime5 = System.currentTimeMillis();
			SelectionSort.selectionSort(intArray6);
			long endTime5 = System.currentTimeMillis();
			results[k++] = (endTime5 - startTime5);
			outputStream.println( n + "," + (endTime5 - startTime5) +  ",milliseconds,Select Sort");
			outputStream.println();



		}

		for(int n = 1000; n < 1000000; n*=10){

			int[] intArray7 = new int[n];
			int[] intArray8 = new int[n];
			int[] intArray9 = new int[n];

			
			//fill the array with size number of reversed numbers
			for(int i = 0; i < intArray7.length; i++)
				intArray7[i] = intArray7.length - i; 

			//fill the array with size number of reversed numbers
			for(int i = 0; i < intArray8.length; i++)
				intArray8[i] = intArray8.length - i; 

			//fill the array with size number of reversed numbers
			for(int i = 0; i < intArray9.length; i++)
				intArray9[i] = intArray9.length - i;

			outputStream.println("Sorting " + n + " reversed items....");
			
			//Tests bubble sort 
			long startTime = System.currentTimeMillis();
			BubbleSort.bubbleSort(intArray7);
			long endTime = System.currentTimeMillis(); 
			results[k++] = (endTime - startTime);
			outputStream.println( n + "," + (endTime - startTime) +  ",milliseconds, Bubble Sort");


			//Tests insertions sort 			

			long startTime3 = System.currentTimeMillis();			
			InsertionSort.insertionSort(intArray8);
			long endTime3 = System.currentTimeMillis();
			results[k++] = (endTime3 - startTime3);
			outputStream.println( n + "," + (endTime3 - startTime3) +  ",milliseconds, Insertion Sort");

			
			//Tests select sort 
			
			long startTime5 = System.currentTimeMillis();
			SelectionSort.selectionSort(intArray9);
			long endTime5 = System.currentTimeMillis();
			results[k++] = (endTime5 - startTime5);
			outputStream.println( n + "," + (endTime5 - startTime5) +  ",milliseconds, Select Sort");
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
		lineChart.setTitle("Random (Average Case)");
		lineChart2.setTitle("Sorted Numbers (Best Case)");
		lineChart3.setTitle("Reversed Numbers (Worst Case)");
		
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
		series.setName("Bubble Sort");
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Select Sort");
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Insertion Sort");
		//Sorted Data
		XYChart.Series series4 = new XYChart.Series();
		series4.setName("Bubble Sort");
		XYChart.Series series5 = new XYChart.Series();
		series5.setName("Select Sort");
		XYChart.Series series6 = new XYChart.Series();
		series6.setName("Insertion Sort");
		//Reversed Data
		XYChart.Series series7 = new XYChart.Series();
		series7.setName("Bubble Sort");
		XYChart.Series series8 = new XYChart.Series();
		series8.setName("Select Sort");
		XYChart.Series series9 = new XYChart.Series();
		series9.setName("Insertion Sort");

		//Populates each series with data.
		//Random Data
		series.getData().add(new XYChart.Data(1000, results[0]));
		series.getData().add(new XYChart.Data(10000, results[3]));
		series.getData().add(new XYChart.Data(100000, results[6]));		
		series3.getData().add(new XYChart.Data(1000, results[1]));
		series3.getData().add(new XYChart.Data(10000, results[4]));
		series3.getData().add(new XYChart.Data(100000, results[7]));
		series2.getData().add(new XYChart.Data(1000, results[2]));
		series2.getData().add(new XYChart.Data(10000, results[5]));
		series2.getData().add(new XYChart.Data(100000, results[8]));
		//Sorted Data
		series4.getData().add(new XYChart.Data(1000, results[9]));
		series4.getData().add(new XYChart.Data(10000, results[12]));
		series4.getData().add(new XYChart.Data(100000, results[15]));		
		series6.getData().add(new XYChart.Data(1000, results[10]));
		series6.getData().add(new XYChart.Data(10000, results[13]));
		series6.getData().add(new XYChart.Data(100000, results[16]));		
		series5.getData().add(new XYChart.Data(1000, results[11]));
		series5.getData().add(new XYChart.Data(10000, results[14]));
		series5.getData().add(new XYChart.Data(100000, results[17]));
		//Reversed Data
		series7.getData().add(new XYChart.Data(1000, results[18]));
		series7.getData().add(new XYChart.Data(10000, results[21]));
		series7.getData().add(new XYChart.Data(100000, results[24]));		
		series9.getData().add(new XYChart.Data(1000, results[19]));
		series9.getData().add(new XYChart.Data(10000, results[22]));
		series9.getData().add(new XYChart.Data(100000, results[25]));		
		series8.getData().add(new XYChart.Data(1000, results[20]));
		series8.getData().add(new XYChart.Data(10000, results[23]));
		series8.getData().add(new XYChart.Data(100000, results[26]));

		//Creates flowpane to put all three graphs on scene
		FlowPane root = new FlowPane();
		root.getChildren().addAll(lineChart, lineChart2, lineChart3);
		Scene scene = new Scene(root, 800, 600);

		//Adds data to the charts
		lineChart.getData().add(series);
		lineChart.getData().add(series2);
		lineChart.getData().add(series3);
		lineChart2.getData().add(series4);
		lineChart2.getData().add(series5);
		lineChart2.getData().add(series6);
		lineChart3.getData().add(series7);
		lineChart3.getData().add(series8);
		lineChart3.getData().add(series9);

		//Set title and main window size
		primaryStage.setTitle("Sorting Data Chart");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
