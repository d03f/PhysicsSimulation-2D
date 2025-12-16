package com.d03f.basic_snake.model.systems.factories;

public class PhysicsConfig {
	
	private boolean useGravity = false;
	private boolean useBoundaryBounce = false;
	private boolean useMovement = false;
	private boolean useDrag = false;
	
	private boolean useSprings = false;
	private boolean useRopes = false;

	
	public PhysicsConfig withGravity(boolean enabled) { 
		this.useGravity = enabled;
		return this;
	}
	
	public PhysicsConfig withBoundaryBounce(boolean enabled) {
		this.useBoundaryBounce = enabled;
		return this;
	}
	
	public PhysicsConfig withMovement(boolean enabled) {
		this.useMovement = enabled;
		return this;
	}
	
	public PhysicsConfig withDrag(boolean enabled) {
		this.useDrag = enabled;
		return this;
	}
	
	public PhysicsConfig withSprings(boolean enabled) {
		this.useSprings = enabled;
		return this;
	}
	
	public PhysicsConfig withRopes(boolean enabled) {
		this.useRopes = enabled;
		return this;
	}
	
	public boolean isUseGravity() { return this.useGravity; }
	public boolean isUseBoundaryBounce() { return this.useBoundaryBounce; }
	public boolean isUseMovement() {return this.useMovement; }
	public boolean isUseDrag() { return this.useDrag; }
	public boolean isUseSprings() { return this.useSprings; }
	public boolean isUseRopes() { return this.useRopes; }
	

	
	
}
