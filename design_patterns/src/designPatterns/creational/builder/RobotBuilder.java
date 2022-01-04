package designPatterns.creational.builder;

/**
 * This Interface represents the Builder Interface in
 * the Builder Design Pattern
 * 
 * @author Dhirendra Verma
 * 
 */
public interface RobotBuilder {
	
	public void buildRobotHead();
	public void buildRobotTorso();
	public void buildRobotArms();
	public void buildRobotLegs();
	public Robot getRobot();
	
}