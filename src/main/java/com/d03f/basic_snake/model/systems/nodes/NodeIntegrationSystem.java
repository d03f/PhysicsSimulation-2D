package com.d03f.basic_snake.model.systems.nodes;

import com.d03f.basic_snake.model.nodes.Node;

public class NodeIntegrationSystem implements INodeSystem{

	@Override
	public void update(Node node, double dt) {
		
		//Euler calculation
		double mass = node.getMass();
		if (mass <= 0 ){ node.setForceX(0); node.setForceY(0); return; }
		
		if (node.isFixed()) { node.setVX(0); node.setVY(0);   node.setForceX(0);node.setForceY(0); return; }
		
		//a = F / m
		double accelerationX = node.getForceX() / mass;
		double accelerationY = node.getForceY() / mass;
		
		node.setVX(node.getVX() + accelerationX * dt);
		node.setVY(node.getVY() + accelerationY * dt);
		
		node.setX( node.getX() + node.getVX() * dt );
		node.setY( node.getY() + node.getVY() * dt );
		
		node.setForceX(0); node.setForceY(0);
	}
	

}
