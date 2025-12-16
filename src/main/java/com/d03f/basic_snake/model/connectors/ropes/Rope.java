package com.d03f.basic_snake.model.connectors.ropes;

import com.d03f.basic_snake.model.connectors.IConnector;
import com.d03f.basic_snake.model.nodes.Node;

public class Rope implements IConnector{
	
	private Node nodeA;
	private Node nodeB;
	
	private double restLength;
	private double stiffness;
	
	private double dampening;
	
	public Rope(Node nodeA, Node nodeB, double restLength, double stiffness, double dampening) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.restLength = restLength;
		this.stiffness = stiffness;
		this.dampening = dampening;
	}

	@Override public Node getNodeA() { return this.nodeA; }
	@Override public Node getNodeB() { return this.nodeB; }

	@Override public double getRestLegth() { return this.restLength; }
	public double getStiffness() { return this.stiffness; }
	public double getDampening() { return this.dampening; }

	
	@Override public void setNodeA(Node nodeA) { this.nodeA = nodeA; 	}
	@Override public void setNodeB(Node nodeB) { this.nodeB = nodeB; }

	@Override public void setRestLegth(double restLength) { this.restLength = restLength; }
	public void setStiffness(double bounciness) { this.stiffness = bounciness; }
	public void setDampening(double dampening) { this.dampening = dampening; }

}
