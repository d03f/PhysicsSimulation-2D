package com.d03f.basic_snake.model.systems.nodes;

import java.util.List;

import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.model.systems.IDefaultSystem;

public interface INodeSystem extends IDefaultSystem<Node>{
	
	public default void updateAll( List<Node> nodes, double dt ) {
		nodes.forEach( node -> this.update(node, dt) );
	}
	
	void update( Node node, double dt );
}
