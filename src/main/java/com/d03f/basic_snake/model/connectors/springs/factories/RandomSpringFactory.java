package com.d03f.basic_snake.model.connectors.springs.factories;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.d03f.basic_snake.model.connectors.springs.Spring;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class RandomSpringFactory implements ISpringFactory {
	
	private final Random random = new Random();
	private static final double STIFFNESS = SimConstants.SPRING_STIFFNESS;
	private static final Optional<Double> LEGTH = SimConstants.SPRING_LENGTH;


	@Override
	public Spring get(List<Node> allNodes) {
		
		int randIdx = this.random.nextInt(0, allNodes.size());
		int nextIdx = (randIdx + 1 ) % allNodes.size();
		
		double springLength = RandomSpringFactory.LEGTH.isEmpty() ? 
				this.getDistance(allNodes.get(randIdx), allNodes.get( nextIdx )) :
					RandomSpringFactory.LEGTH.get();
		
		return new Spring(
				allNodes.get(randIdx), allNodes.get( nextIdx ), 
				springLength, RandomSpringFactory.STIFFNESS
			);
	}
	


}
