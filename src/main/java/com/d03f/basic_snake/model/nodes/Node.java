package com.d03f.basic_snake.model.nodes;

public class Node {
	
	private double x, y;
	private double vx, vy;
	private double forceX, forceY;
	private double mass;
	
	private double elasticity;
	
	private double radius;
	
	private boolean isFixed;
	
	public Node(double x, double y, double vx, double vy, double radius, double mass, double elasticity, boolean isFixed) {
		this.x = x; this.y = y;
		this.vx = vx; this.vy = vy;
		this.radius = radius;
		
		this.forceX = this.forceY = 0;
		this.mass = mass;
		this.elasticity = elasticity;
		
		this.isFixed = isFixed;
	}
	
	//Getters
	public double getX() { return this.x;}
	public double getY() { return this.y;}
	
	public double getVX() { return this.vx;}
	public double getVY() { return this.vy;}
	
	public double getForceX() { return this.forceX;}
	public double getForceY() { return this.forceY;}
	
	public double getMass() { return this.mass; }
	public double getElasticity() { return this.elasticity; }
	
	public double getRadius() { return this.radius;}
	
	public boolean isFixed() { return this.isFixed; }
	
	//Setters
	public void setX(double x) { this.x = x;}
	public void setY(double y) { this.y = y;}
	
	public void setVX(double vx) { this.vx = vx;}
	public void setVY(double vy) { this.vy = vy;}
	
	public void setForceX(double forceX) { this.forceX = forceX;}
	public void setForceY(double forceY) { this.forceY = forceY;}
	
	public void addForce(double forceX, double forceY) { this.forceX += forceX; this.forceY += forceY; }
	
	public void setMass(double mass) { this.mass = mass; }
	public void setElasticity(double elasticity) { this.elasticity = elasticity; }
	
	public void setRadius(double radius) { this.radius = radius; }
	
	public void setIsFixed(boolean isFixed) { this.isFixed = isFixed; }
	
	
	//Overrides
	@Override
	public String toString() {
		return String.format("Node - X: %f, Y: %f,  VX: %f, VY: %f, Rad: %f", 
				this.x, this.y, this.vx, this.vy, this.radius);
	}

}
