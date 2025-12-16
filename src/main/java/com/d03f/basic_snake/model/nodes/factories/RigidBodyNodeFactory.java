package com.d03f.basic_snake.model.nodes.factories;

import com.d03f.basic_snake.model.nodes.Node;

public class RigidBodyNodeFactory implements INodeFactory{

	private int lastBall = 1;
	
	@Override
	public Node get() {
		return new Node(lastBall * 100, lastBall,
				0, 0,
				lastBall, lastBall, lastBall, false);
	}

}
