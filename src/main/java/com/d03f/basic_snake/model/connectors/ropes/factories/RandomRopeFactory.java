package com.d03f.basic_snake.model.connectors.ropes.factories;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.d03f.basic_snake.model.connectors.ropes.Rope;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class RandomRopeFactory implements IRopeFactory {
	
	private final Random random = new Random();
	private static final double STIFFNESS = SimConstants.ROPE_STIFFNESS;
	private static final Optional<Double> LEGTH = SimConstants.ROPE_LENGTH;
	private static final double DAMPENING = SimConstants.ROPE_DAMPENING;


	@Override
	public Rope get(List<Node> allNodes) {
		
		int randIdx = this.random.nextInt(0, allNodes.size());
		int nextIdx = (randIdx + 1 ) % allNodes.size();
		
		double ropeLength = RandomRopeFactory.LEGTH.isEmpty() ? 
				getDistance(allNodes.get(randIdx), allNodes.get( nextIdx )) :
					RandomRopeFactory.LEGTH.get();
	

		return new Rope(
				allNodes.get(randIdx), allNodes.get( (randIdx + 1 ) % allNodes.size() ), 
				ropeLength, RandomRopeFactory.STIFFNESS, DAMPENING
			);
	}

}
