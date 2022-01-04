package designPatterns.creational.builder;

/**
 * Doesn't represent anything specific in Builder Design Pattern.
 * Just a convenience Interface for Robot
 * 
 * @author Dhirendra Verma
 */
public interface RobotPlan {
	
	public void setRobotHead(String head);
	public void setRobotTorso(String torso);
	public void setRobotArms(String arms);
	public void setRobotLegs(String legs);
	
}
