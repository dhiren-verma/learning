package designPatterns.creational.builder;

public class TestBuilderDesignPattern {
	
	public static void main(String[] args) {
		RobotBuilder oldRobotBuilder = new OldRobotBuilder();
		
		RobotEngineer robotEngineer = new RobotEngineer(oldRobotBuilder);
		
		robotEngineer.makeRobot();
		
		Robot oldRobot = robotEngineer.getRobot();
		
		System.out.println("Robot constructed is: "+oldRobot);
	}
	
}