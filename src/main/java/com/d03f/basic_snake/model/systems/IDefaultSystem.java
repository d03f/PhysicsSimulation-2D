package com.d03f.basic_snake.model.systems;

import java.util.List;

public interface IDefaultSystem <T>{
	public default void updateAll( List<T> items, double dt ) {
		items.forEach( item -> this.update(item, dt) );
	}
	
	void update( T node, double dt );

}
