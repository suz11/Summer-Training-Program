package application;
/*
 * Class: CMSC201 
 * Instructor:
 * Description:  Write a program that prompts the user to enter a year, month, and day of the month, and displays the name of the day of the week. 
 * Due: 07/15/2018
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Sebastian Ulloa
*/

//Import libraries
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.ObservableList;

public class Project_7 extends Application {
	//declare variables
	static double height = 200.0;
	static double width = 400.0;
	static double xCenter = 200.0;
	static double yCenter = 100.0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//declare variables for x axis content string 
			String[] coordinates = new String[] {"-2\u03c0", "-\u03c0", "0" , "\u03c0", "2\u03c0"};
			int text = 0;
			
			//create the window
			Pane Window = new Pane();
			
			//create two polylines 
			//call the methods to create the axis
	        Polyline xAxis = new Polyline();
	        Polyline yAxis = new Polyline();
	        drawXAxis(Window, xAxis);
	        drawYAxis(Window, yAxis);
	        
	        //proceed to create your sine and cosine polylines
	        Polyline polylineSine = new Polyline();
	        Polyline polylineConsine = new Polyline();
	        
	        //proceed to create a third polyline for the sine
	        polylineSine.setStroke(Color.RED);
	        //create the list for the points
	        ObservableList<Double> list = polylineSine.getPoints();
	        for (int x = -170; x <= 170; x++) {
	            list.add(x + xCenter);
	            list.add(yCenter - 50 * Math.sin((x / 100.0) * 2 * Math.PI));	  
	            }
	        //draw the sine
	        int x2 = -170;
	        for (double i = 99.6; i <= 100.03; i = i + 0.1) {
	        x2 = x2 + 55;
	        Text text1 = new Text(x2 + xCenter, yCenter / 0.9, coordinates[text++]);
	        Window.getChildren().add(text1);
	        }
	        //same process as above
	        polylineConsine.setStroke(Color.BLUE);
	        ObservableList<Double> list2 = polylineConsine.getPoints();
	        
	        for (int x = -170; x <= 170; x++) {
	            list2.addAll(x + xCenter);
	            list2.addAll(yCenter - 50 * Math.cos((x / 100.0) * 2 * Math.PI));

	        }
	        
	        //put all the lines together 
	        Window.getChildren().addAll(xAxis, yAxis,polylineSine,polylineConsine);
	        
	       //create the stage(scene)
	        primaryStage.setScene(new Scene(Window, width, height));
	        primaryStage.setTitle("Project 11");
	        primaryStage.show();
			
			
		} catch(Exception e) {
			System.out.println("Error has occured");
			e.printStackTrace();
		}
		}
		
	private static void drawXAxis(Pane Window, Polyline xAxis) {
		//array list for the points of the x axis
        ObservableList<Double>xAxisL = xAxis.getPoints();
        //limit so that it doesnt do pass the window
        double limit = width * 0.9;
        for (double i = 0; i < limit; i++) {
        	xAxisL.addAll(i);
        	xAxisL.addAll(yCenter);
        }
        //create the line for the axis
        //they at two line but they overlap each other expect for the end since 
        //they needed to slip like an arrow 
        Line firstLine = new Line(limit, yCenter, limit - width * 0.05, yCenter * 0.870);
        Line secondLine = new Line(limit, yCenter, limit - width * 0.05, yCenter / 0.870);
        Text text = new Text(limit + width, yCenter, "x");

        //drawn the line
        Window.getChildren().addAll(firstLine, secondLine,text);
    }

    private static void drawYAxis(Pane Window, Polyline yAxis) {
    	//another array list with the contents of the drawing 
        ObservableList<Double>yAxisL = yAxis.getPoints();
        //limits of the axis to make sure they don't go pass the window
        double limit = height * 0.9;
        for (double i = 0; i < limit; i++) {
        	yAxisL.add(xCenter);
        	yAxisL.add(i + height * 0.1);
        }
        //set the axis
        Line firstLine = new Line(xCenter, height * 0.1, xCenter - width * 0.05, height * 0.19);
        Line secondLine = new Line(xCenter, height * 0.1, xCenter + width * 0.05, height * 0.19);
        Text text = new Text(limit + width , height * 0.1, "y");
        
        //draw the line 
        Window.getChildren().addAll(firstLine, secondLine,text);
    }
	public static void main(String[] args) {
		//launch program
		launch(args);
	}
}
