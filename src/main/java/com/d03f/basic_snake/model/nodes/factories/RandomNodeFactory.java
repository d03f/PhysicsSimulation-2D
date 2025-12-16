package com.d03f.basic_snake.model.nodes.factories;

import java.util.Random;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class RandomNodeFactory implements INodeFactory{
	
	private final Random random = new Random();
	private int currIdx = 0;

	@Override
	public Node get() {
		return new Node(
				random.nextDouble(1, SimConstants.WIDTH),
				random.nextDouble(1, SimConstants.HEIGHT),
				
				this.getRandomNonZeroVelocity(-SimConstants.MAX_SPEED, SimConstants.MAX_SPEED),
				this.getRandomNonZeroVelocity(-SimConstants.MAX_SPEED, SimConstants.MAX_SPEED),

				SimConstants.RADIUS, SimConstants.MAX_MASS, SimConstants.ELASTICITY, this.isNodeFixed(currIdx++));
	}
	
	private double getRandomNonZeroVelocity(double minValue, double maxValue) {
		double result;
		do { 
			result = random.nextDouble(minValue, maxValue);
		} while (result == 0);
		
		return result;
	}

}
