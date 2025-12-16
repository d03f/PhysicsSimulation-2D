package com.d03f.basic_snake;

import com.d03f.basic_snake.controller.SimulationLoop;
import com.d03f.basic_snake.utils.SimConstants;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	private static final int WIDTH = (int) SimConstants.WIDTH;
	private static final int HEIGHT = (int) SimConstants.HEIGHT;
	public static void main(String[] args) {
		launch();
	}
	
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {
    	Canvas canvas = new Canvas(WIDTH, HEIGHT);
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	
    	StackPane root = new StackPane(canvas);
    	Scene scene = new Scene(root, WIDTH, HEIGHT);
    	
    	stage.setScene(scene);
    	stage.setTitle("PhysicSimulator 2d");
    	stage.show();
    	
    	
    	SimulationLoop loop = new SimulationLoop(gc);
        loop.start();
    }

    

}
