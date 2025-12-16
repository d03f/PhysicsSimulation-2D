package com.d03f.basic_snake.model.connectors;

import com.d03f.basic_snake.model.nodes.Node;

public interface IConnector {

	public Node getNodeA();
	public Node getNodeB();
	
	public double getRestLegth();
	
	
	public void setNodeA(Node nodeA);
	public void setNodeB(Node nodeB);

	public void setRestLegth(double restLength);
}
