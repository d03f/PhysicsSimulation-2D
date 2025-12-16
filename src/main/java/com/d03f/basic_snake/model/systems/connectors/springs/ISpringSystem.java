package com.d03f.basic_snake.model.systems.connectors.springs;

import java.util.List;

import com.d03f.basic_snake.model.connectors.springs.Spring;
import com.d03f.basic_snake.model.systems.IDefaultSystem;

public interface ISpringSystem extends IDefaultSystem<Spring>{
	
	public default void updateAll( List<Spring> springs, double dt ) {
		springs.forEach( spring -> this.update(spring, dt) );
	}
	
	void update( Spring node, double dt );
}
