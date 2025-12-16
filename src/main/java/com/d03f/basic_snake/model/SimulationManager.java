package com.d03f.basic_snake.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.d03f.basic_snake.model.connectors.ropes.Rope;
import com.d03f.basic_snake.model.connectors.ropes.factories.IRopeFactory;
import com.d03f.basic_snake.model.connectors.ropes.factories.SnakeRopeFactory;
import com.d03f.basic_snake.model.connectors.springs.Spring;
import com.d03f.basic_snake.model.connectors.springs.factories.ISpringFactory;
import com.d03f.basic_snake.model.connectors.springs.factories.SnakeSpringFactory;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.model.nodes.factories.INodeFactory;
import com.d03f.basic_snake.model.nodes.factories.SnakeNodeFactory;
import com.d03f.basic_snake.model.systems.IDefaultSystem;
import com.d03f.basic_snake.model.systems.connectors.ropes.IRopeSystem;
import com.d03f.basic_snake.model.systems.connectors.springs.ISpringSystem;
import com.d03f.basic_snake.model.systems.factories.PhysicsConfig;
import com.d03f.basic_snake.model.systems.factories.PhysicsSystemBuilder;
import com.d03f.basic_snake.model.systems.nodes.INodeSystem;
import com.d03f.basic_snake.utils.SimConstants;

public class SimulationManager {
	
	private final List<IDefaultSystem<?>> simulationSystems;
	private final List<Node> nodes;
	private final List<Spring> springs;
	private final List<Rope> ropes;
	
	public SimulationManager() { this( new ArrayList<>(), new ArrayList<>() , new ArrayList<>() ); }
	public SimulationManager(List<Node> nodes, List<Spring> springs, List<Rope> ropes) {
		this.nodes = nodes;
		this.springs = springs;
		this.ropes = ropes;
		
		this.simulationSystems = new PhysicsSystemBuilder(
					new PhysicsConfig()
						.withMovement(SimConstants.WITH_MOVEMENT)
						.withBoundaryBounce(SimConstants.WITH_BOUNDARYBOUNCE)
						.withGravity(SimConstants.WITH_GRAVITY)
						.withDrag(SimConstants.WITH_DRAG)
						.withSprings(SimConstants.WITH_SPRINGS)
						.withRopes(SimConstants.WITH_ROPES)
				).createSystems();
	}
	
	public void generateItems(int nNodes, int nSprings, int nRopes) {
		INodeFactory nodeFactory = new SnakeNodeFactory(nNodes);
		ISpringFactory springFactory = new SnakeSpringFactory();
		IRopeFactory ropeFactory = new SnakeRopeFactory();
		
		List<Node> tempNodes = Stream.generate(nodeFactory).limit(nNodes).toList();
		this.nodes.addAll(tempNodes);
		
		for (int i=0; i<nSprings; i++) { this.springs.add(springFactory.get(this.nodes)); }
		for (int i=0; i<nRopes; i++) { this.ropes.add(ropeFactory.get(this.nodes)); }
	}
	
	public void updateItems(double dt) {
		this.simulationSystems.forEach( system -> {
			if (system instanceof INodeSystem nodeSystem) {
				nodeSystem.updateAll(this.nodes, dt);				
			} else if (system instanceof ISpringSystem springSystem) {
				springSystem.updateAll(this.springs, dt);
				
			} else if (system instanceof IRopeSystem ropeSystem) {
				ropeSystem.updateAll(this.ropes, dt);
			}
			
		});
	}
	
	public List<Node> getNodes(){ return this.nodes; }
	public List<Spring> getSprings() { return this.springs; }
	public List<Rope> getRopes() { return this.ropes; }

}
