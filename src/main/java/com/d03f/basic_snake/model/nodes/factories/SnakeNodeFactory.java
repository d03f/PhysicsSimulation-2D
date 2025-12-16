package com.d03f.basic_snake.model.nodes.factories;

import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class SnakeNodeFactory implements INodeFactory {

	private double spaceBetweenNodes;
	private int lastBallNumber = 0;

	public SnakeNodeFactory(int nNodes) {
		this.spaceBetweenNodes = SimConstants.WIDTH / nNodes;
	}
	
	@Override
	public Node get() {
		return new Node(this.spaceBetweenNodes * this.lastBallNumber++, 10,
				0, 0, 
				SimConstants.RADIUS, SimConstants.MAX_MASS, SimConstants.ELASTICITY, 
				this.isNodeFixed(lastBallNumber-1));
	}

}
