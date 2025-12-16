package com.d03f.basic_snake.model.systems.connectors.ropes;

import java.util.List;

import com.d03f.basic_snake.model.connectors.ropes.Rope;
import com.d03f.basic_snake.model.systems.IDefaultSystem;

public interface IRopeSystem extends IDefaultSystem<Rope>{
	
	public default void updateAll( List<Rope> ropes, double dt ) {
		ropes.forEach( rope -> this.update(rope, dt) );
	}
	
	void update( Rope rope, double dt );
}
