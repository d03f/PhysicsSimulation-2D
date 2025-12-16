package com.d03f.basic_snake.model.systems.nodes;

import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public class NodeDragSystem  implements INodeSystem{
	
	private static final double K = SimConstants.DRAG_COEFFICIENT;

	@Override
	public void update(Node node, double dt) {
		
		double vx = node.getVX();
		double vy = node.getVY();
		
		double dragForceX = - ( K * vx );
		double dragForceY = - ( K * vy );
		
		node.addForce(dragForceX, dragForceY);
		
	}

}
