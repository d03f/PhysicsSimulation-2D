package com.d03f.basic_snake.model.connectors.springs;

import com.d03f.basic_snake.model.connectors.IConnector;
import com.d03f.basic_snake.model.nodes.Node;

public class Spring implements IConnector{
	private Node nodeA;
	private Node nodeB;
	
	private double restLegth; //Target distance to maintain
	private double stiffness;
	
	public Spring(Node nodeA, Node nodeB, double restLegth, double stiffness) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.restLegth = restLegth;
		this.stiffness = stiffness;
	}

	public Node getNodeA() { return nodeA; }
	public Node getNodeB() { return nodeB; }

	public double getRestLegth() { return restLegth; }
	public double getStiffness() { return stiffness; }

	
	public void setNodeA(Node nodeA) { this.nodeA = nodeA; }
	public void setNodeB(Node nodeB) { this.nodeB = nodeB; }

	public void setRestLegth(double restLegth) { this.restLegth = restLegth; }
	public void setStiffness(double stiffness) {this.stiffness = stiffness; }
	
	
	

}
