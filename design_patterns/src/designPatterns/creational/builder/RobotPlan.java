package designPatterns.creational.builder;

/**
 * This Interface is just a convenience Interface for our Robot,
 * its doesn't map to anything mentioned by the Builder Design Pattern
 * 
 * @author Dhirendra Verma
 * 
 */
public interface RobotPlan {
	
	public void setRobotHead(String head);
	public void setRobotTorso(String torso);
	public void setRobotArms(String arms);
	public void setRobotLegs(String legs);
	
}