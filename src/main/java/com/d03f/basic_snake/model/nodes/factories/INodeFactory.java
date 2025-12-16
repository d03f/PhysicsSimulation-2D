package com.d03f.basic_snake.model.nodes.factories;

import java.util.Arrays;
import java.util.function.Supplier;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

public interface INodeFactory extends Supplier<Node>{
	
	 @Override
	 Node get();
	 
	 default boolean isNodeFixed(int nodeIdx) {
		 return Arrays.stream(SimConstants.FIXED_NODES).anyMatch(x -> x==nodeIdx);
	 }

}
