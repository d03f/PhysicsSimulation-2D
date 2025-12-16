package com.d03f.basic_snake.model.systems.nodes;

import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class NodeBoundaryBounceSystem implements INodeSystem {
	
	private static final double elasticity = SimConstants.ELASTICITY;

	@Override
	public void update(Node node, double dt) {
		double nodeRad = node.getRadius();
		
		if (node.getX() < nodeRad) {
			node.setX(nodeRad);
			node.setVX(-node.getVX() * NodeBoundaryBounceSystem.elasticity);
		}
		if (node.getX() > SimConstants.WIDTH - SimConstants.RADIUS ) {
			node.setX(SimConstants.WIDTH - SimConstants.RADIUS);
			node.setVX(-node.getVX() * NodeBoundaryBounceSystem.elasticity);
		}
		
		if (node.getY() < nodeRad) {
			node.setY(nodeRad);
			node.setVY(-node.getVY() * NodeBoundaryBounceSystem.elasticity);
		}
		if (node.getY() > SimConstants.HEIGHT - SimConstants.RADIUS ) {
			node.setY(SimConstants.HEIGHT - SimConstants.RADIUS);
			node.setVY(-node.getVY() * NodeBoundaryBounceSystem.elasticity );
		}
	}

}
