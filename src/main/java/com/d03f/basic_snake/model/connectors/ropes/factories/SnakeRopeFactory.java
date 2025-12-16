package com.d03f.basic_snake.model.connectors.ropes.factories;

import java.util.List;

import com.d03f.basic_snake.model.connectors.ropes.Rope;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class SnakeRopeFactory implements IRopeFactory{
	private int lastBallLiked = 0;

	@Override
	public Rope get(List<Node> allNodes) {
		
		int idx = this.lastBallLiked;
		int nextIdx = ++this.lastBallLiked;
		
		double springLength = SimConstants.ROPE_LENGTH.isEmpty() ? 
				this.getDistance(allNodes.get( idx ), allNodes.get( nextIdx )) :
					SimConstants.ROPE_LENGTH.get();

		return new Rope(
				allNodes.get(idx), allNodes.get(nextIdx), 
				springLength, SimConstants.ROPE_STIFFNESS, SimConstants.ROPE_DAMPENING
				);
	}

}