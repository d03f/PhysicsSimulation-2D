package com.d03f.basic_snake.utils;

import java.util.Optional;

import javafx.scene.paint.Color;


public class SimConstants {
	
	//Sim systems
	public static final boolean WITH_MOVEMENT = true;
	public static final boolean WITH_GRAVITY = true;
	public static final boolean WITH_DRAG = true;
	
	
	public static final boolean WITH_BOUNDARYBOUNCE = true;
	
	public static final boolean WITH_SPRINGS = true;
	public static final boolean WITH_ROPES = true;
	
	
	//Node Atribs
	public static final double WIDTH = 1000;
	public static final double HEIGHT = 1000;
	public static final double MAX_SPEED = 550.0;
	
	public static final double MAX_MASS = 1;
	public static final double ELASTICITY = 0.3;
	
	public static final int RADIUS = 20;
	
	public static final int[] FIXED_NODES = new int[] {1};

	

	public static final Color NodeColor = Color.GREEN;
	public static final int N_NODES = 2;

	//Spring Atribs
	public static final int N_SPRINGS = 0;
	public static final double SPRING_STIFFNESS = 4000;
	public static final Optional<Double> SPRING_LENGTH = Optional.of(.10);
	
	public static final Color SPRING_COLOR = Color.BLUE;
	public static final int SPRING_WIDTH = 5;
	
	
	//Rope atribs
	public static final int N_ROPES = 1;
	public static final double ROPE_STIFFNESS = 10;
	public static final double ROPE_DAMPENING = 20;
	public static final Optional<Double> ROPE_LENGTH = Optional.of(600.0);
	
	
	public static final Color ROPE_COLOR = Color.RED;
	public static final int ROPE_WIDTH = 5;
	
	
	//Constants
	public static final double GRAVITY = 980.0;
	public static final Color bgColor = Color.BLACK;
	public static final double DRAG_COEFFICIENT = 0.1;
	
	
	private SimConstants() {}

}
