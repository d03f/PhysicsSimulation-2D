package com.d03f.basic_snake.model.connectors.ropes.factories;

import java.util.List;

import com.d03f.basic_snake.model.connectors.ropes.Rope;
import com.d03f.basic_snake.model.nodes.Node;

public interface IRopeFactory {
	public Rope get(List<Node> allNodes);
	
	default double getDistance(Node nodeA, Node nodeB) {
		return Math.sqrt(
				Math.pow(nodeA.getX() - nodeB.getX(), 2) + 
				Math.pow(nodeA.getY() - nodeB.getY(), 2)
			);
	}
}
