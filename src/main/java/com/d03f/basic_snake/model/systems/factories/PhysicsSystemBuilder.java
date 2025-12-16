package com.d03f.basic_snake.model.systems.factories;

import java.util.ArrayList;
import java.util.List;

import com.d03f.basic_snake.model.systems.IDefaultSystem;
import com.d03f.basic_snake.model.systems.connectors.ropes.RopeSystem;
import com.d03f.basic_snake.model.systems.connectors.springs.SpringSystem;
import com.d03f.basic_snake.model.systems.nodes.NodeBoundaryBounceSystem;
import com.d03f.basic_snake.model.systems.nodes.NodeDragSystem;
import com.d03f.basic_snake.model.systems.nodes.NodeGravitySystem;
import com.d03f.basic_snake.model.systems.nodes.NodeIntegrationSystem;

public class PhysicsSystemBuilder {
	
	private final PhysicsConfig config;
	
	public PhysicsSystemBuilder(PhysicsConfig config) { this.config = config; }
	
	public List<IDefaultSystem<?>> createSystems(){
		List<IDefaultSystem<?>> result = new ArrayList<>();
		
		if (config.isUseBoundaryBounce()) { result.add(new NodeBoundaryBounceSystem()); }
		
		if (config.isUseGravity()) { result.add(new NodeGravitySystem()); }
		if (config.isUseDrag()) { result.add(new NodeDragSystem()); }
		
		if(config.isUseSprings()) { result.add(new SpringSystem()); }
		if(config.isUseRopes()) { result.add(new RopeSystem()); }
		
		//Last step
		if (config.isUseMovement()) { result.add(new NodeIntegrationSystem()); }
		
		
		
		return result;
	}
	
	

}
