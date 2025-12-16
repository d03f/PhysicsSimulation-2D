package com.d03f.basic_snake.controller;

import com.d03f.basic_snake.model.SimulationManager;
import com.d03f.basic_snake.utils.SimConstants;
import com.d03f.basic_snake.view.CanvasRenderer;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class SimulationLoop extends AnimationTimer{
	
	private final CanvasRenderer renderer;
	private final SimulationManager simulationManager;
	private final GraphicsContext gc;
	
	
	private long lastNanoTime = System.nanoTime();
	
	public SimulationLoop(GraphicsContext gc) {
		this.renderer = new CanvasRenderer(SimConstants.WIDTH, SimConstants.HEIGHT);
		this.simulationManager = new SimulationManager();
		
		this.gc = gc;
		
		this.simulationManager.generateItems(SimConstants.N_NODES, SimConstants.N_SPRINGS, SimConstants.N_ROPES);
		
		
	}

	@Override
	public void handle(long currentNanoTime) {
		double dt = (currentNanoTime - lastNanoTime) / 1000_000_000.0;
		lastNanoTime = currentNanoTime;
		
		this.simulationManager.updateItems(dt);
		
		
		this.renderer.renderAll(gc,
				this.simulationManager.getNodes(),
				this.simulationManager.getSprings(),
				this.simulationManager.getRopes() 
				);
	}

}
