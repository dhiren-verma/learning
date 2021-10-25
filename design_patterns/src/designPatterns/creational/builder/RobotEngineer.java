package designPatterns.creational.builder;

/**
 * This Class represents the Director in the Builder Design Pattern
 * 
 * @author Dhirendra Verma
 * 
 */
public class RobotEngineer {
	
	private RobotBuilder robotBuilder;
	
	public RobotEngineer(RobotBuilder robotBuilder) {
		this.robotBuilder = robotBuilder;
	}
	
	public void makeRobot() {
		robotBuilder.buildRobotHead();
		robotBuilder.buildRobotTorso();
		robotBuilder.buildRobotArms();
		robotBuilder.buildRobotLegs();
	}
	
	public Robot getRobot() {
		return robotBuilder.getRobot();
	}
	
}