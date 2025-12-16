package com.d03f.basic_snake.view;

import java.util.List;

import com.d03f.basic_snake.model.connectors.ropes.Rope;
import com.d03f.basic_snake.model.connectors.springs.Spring;
import com.d03f.basic_snake.model.nodes.Node;
import com.d03f.basic_snake.utils.SimConstants;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasRenderer {
	private final double width;
	private final double height;
	
	private static final Color NodeColor = SimConstants.NodeColor;
	private static final Color SpringColor = SimConstants.SPRING_COLOR;
	private static final Color RopeColor = SimConstants.ROPE_COLOR;
	private static final Color bgColor = SimConstants.bgColor;
	
	private static final int SPRING_WIDTH = SimConstants.SPRING_WIDTH;
	private static final int ROPE_WIDTH = SimConstants.ROPE_WIDTH;
	
	public CanvasRenderer(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void renderAll(GraphicsContext gc, 
			List<Node> nodes, List<Spring> springs, List<Rope> ropes) {
		this.cleanScreen(gc);
		
		this.renderSprings(gc, springs);
		this.renderNodes(gc, nodes);
		this.renderRopes(gc, ropes);
		
	}
	
	 private void renderNodes(GraphicsContext gc, List<Node> nodes) {
		 
		 gc.setFill(CanvasRenderer.NodeColor);
		 
		 nodes.stream().forEach( (node) -> gc.fillOval(
				 node.getX() - node.getRadius(),
				 node.getY() - node.getRadius(),
				 node.getRadius() * 2, node.getRadius() * 2) );
	 }
	 
	 private void renderSprings(GraphicsContext gc, List<Spring> springs) {
		 
		 gc.setStroke(CanvasRenderer.SpringColor);
		 gc.setLineWidth(CanvasRenderer.SPRING_WIDTH);
		 
		 springs.stream().forEach( (spring) -> gc.strokeLine(
				 spring.getNodeA().getX(), spring.getNodeA().getY() ,
				 spring.getNodeB().getX(), spring.getNodeB().getY()
				 ) );
	 }
	 
	 private void renderRopes(GraphicsContext gc, List<Rope> ropes) {
		 gc.setStroke(CanvasRenderer.RopeColor);
		 gc.setLineWidth(ROPE_WIDTH);
		 
		 ropes.stream().forEach(rope -> gc.strokeLine(
				 rope.getNodeA().getX(), rope.getNodeA().getY() ,
				 rope.getNodeB().getX(), rope.getNodeB().getY() )
			 );
		 
	 }
	 
	 private void cleanScreen(GraphicsContext gc) {
		 gc.setFill(CanvasRenderer.bgColor);
		 gc.fillRect(0, 0, this.width, this.height);
		 
	 }
}
