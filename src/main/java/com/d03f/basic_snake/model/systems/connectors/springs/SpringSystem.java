package com.d03f.basic_snake.model.systems.connectors.springs;

import com.d03f.basic_snake.model.connectors.springs.Spring;
import com.d03f.basic_snake.model.nodes.Node;

public class SpringSystem implements ISpringSystem {

	@Override
	public void update(Spring spring, double dt) {
		
		Node a = spring.getNodeA();
		Node b = spring.getNodeB();
		
		//Calculate vector and dist
		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();
		
		double distance = Math.sqrt( dx*dx + dy*dy );
		
		if (distance == 0) return;
		
		//Calculate diference between curr and target length
		double displacement = distance - spring.getRestLegth();
		
		//Calculate teh force mag
		double forceMagnitude = spring.getStiffness() * displacement;
		
		//Calculate the unit vector, legth = 1
		double unitX = dx / distance;
		double unitY = dy / distance;
		
		//Calculate the force based ont he unit (direction) and the force magnitude
		double forceX = unitX * forceMagnitude;
		double forceY = unitY * forceMagnitude;
		
		
		a.addForce(-forceX, -forceY);
		b.addForce(forceX, forceY);
		
		
	}

}
