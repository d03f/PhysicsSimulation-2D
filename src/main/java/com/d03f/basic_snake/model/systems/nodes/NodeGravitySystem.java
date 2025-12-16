package com.d03f.basic_snake.model.systems.nodes;

import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class NodeGravitySystem implements INodeSystem{

	private static final double G = SimConstants.GRAVITY;
	
	//F= m * G
	@Override
	public void update(Node node, double dt) {
		node.addForce(0, node.getMass() * NodeGravitySystem.G);

	}
	

}
