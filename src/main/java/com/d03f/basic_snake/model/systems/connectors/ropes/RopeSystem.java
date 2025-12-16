package com.d03f.basic_snake.model.systems.connectors.ropes;

import com.d03f.basic_snake.model.connectors.ropes.Rope;
import com.d03f.basic_snake.model.nodes.Node;

public class RopeSystem implements IRopeSystem{

	@Override
	public void update(Rope rope, double dt) {
		Node a = rope.getNodeA();
		Node b = rope.getNodeB();
		
		double dx = a.getX() - b.getX();
		double dy = a.getY() - b.getY();
		
		double distance = Math.sqrt(dx*dx + dy*dy);
		
		double displacement = distance - rope.getRestLegth();
		double forceElastic = -rope.getStiffness() * displacement;

		if (displacement <= 0) { return; }
		
		
		double unitX = dx / distance;
		double unitY = dy / distance;
		
		//Damping force, to kill oscilation
		//Relative velocity (va -vb)
		double dvx = a.getVX() - b.getVX();
		double dvy = a.getVY() - b.getVY();
		
		//Rate of change on the length
		double L_dot = (dvx * unitX) + (dvy * unitY);
		
		double forceDamping = -rope.getDampening() * L_dot;
		
		
		double forceMagnitude = forceElastic + forceDamping;
		
		a.addForce(forceMagnitude * unitX, forceMagnitude * unitY);
		b.addForce(-forceMagnitude * unitX, -forceMagnitude * unitY);
		

		
		
		
		
	}

}
