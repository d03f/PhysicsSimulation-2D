package com.d03f.basic_snake.model.nodes.factories;

import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class FixedNodeFactory implements INodeFactory{

	private double x, y;
	private double vx, vy;
	private int radius = 10;

	public FixedNodeFactory(double x, double y, double vx, double vy, int radius) {
		this.x = x; this.y = y;
		this.vx = vx; this.vy = vy;
		this.radius = radius;
	}
	
	@Override
	public Node get() {
		return new Node(x, y, vx, vy, radius, SimConstants.MAX_MASS, SimConstants.ELASTICITY, false);
	}

}
