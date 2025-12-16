package com.d03f.basic_snake.model.connectors.springs.factories;

import java.util.List;

import com.d03f.basic_snake.model.connectors.springs.Spring;
import com.d03f.basic_snake.model.nodes.Node;

public interface ISpringFactory {

	public Spring get(List<Node> allNodes);
	
	default double getDistance(Node nodeA, Node nodeB) {
		return Math.sqrt(
				Math.pow(nodeA.getX() - nodeB.getX(), 2) + 
				Math.pow(nodeA.getY() - nodeB.getY(), 2)
			);
	}
}
