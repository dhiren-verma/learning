package designPatterns.creational.builder;

public class TestBuilderDesignPattern {
	
	public static void main(String[] args) {
		//Builder
		RobotBuilder oldRobotBuilder = new OldRobotBuilder();
		
		//Director
		RobotEngineer robotEngineer = new RobotEngineer(oldRobotBuilder);
		
		robotEngineer.makeRobot();
		
		Robot oldRobot = robotEngineer.getRobot();
		
		System.out.println("Robot constructed is: "+oldRobot);
	}
	
}