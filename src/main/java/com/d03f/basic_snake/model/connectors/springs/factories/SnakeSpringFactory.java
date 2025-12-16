package com.d03f.basic_snake.model.connectors.springs.factories;

import java.util.List;

import com.d03f.basic_snake.model.connectors.springs.Spring;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class SnakeSpringFactory implements ISpringFactory{
	private int lastBallLiked = 0;

	@Override
	public Spring get(List<Node> allNodes) {
		
		int idx = this.lastBallLiked;
		int nextIdx = ++this.lastBallLiked;
		
		double springLength = SimConstants.SPRING_LENGTH.isEmpty() ? 
				this.getDistance(allNodes.get( idx ), allNodes.get( nextIdx )) :
					SimConstants.SPRING_LENGTH.get();
		
		return new Spring(
				allNodes.get(idx), allNodes.get(nextIdx), 
				springLength, SimConstants.SPRING_STIFFNESS
				);
	}

}
