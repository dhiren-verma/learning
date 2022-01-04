package designPatterns.creational.builder;

/**
 * This Class represents the Concrete Builder Class in
 * the Builder Design Pattern
 * 
 * @author Dhirendra Verma
 * 
 */
public class OldRobotBuilder implements RobotBuilder {
	
	private Robot robot;
	
	public OldRobotBuilder() {
		robot = new Robot();
	}
	
	@Override
	public void buildRobotHead() {
		robot.setRobotHead("Tin Head");
	}
	
	@Override
	public void buildRobotTorso() {
		robot.setRobotTorso("Tin Torso");
	}
	
	@Override
	public void buildRobotArms() {
		robot.setRobotArms("Blowtorch Arms");
	}
	
	@Override
	public void buildRobotLegs() {
		robot.setRobotLegs("Roller Skates");
	}
	
	@Override
	public Robot getRobot() {
		return robot;
	}
	
}