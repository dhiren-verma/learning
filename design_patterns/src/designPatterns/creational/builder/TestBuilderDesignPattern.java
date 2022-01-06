package designPatterns.creational.builder;

public class TestBuilderDesignPattern {
	
	public static void main(String[] args) {
		//Builder
//		RobotBuilder robotBuilder = new OldRobotBuilder();
		
		//other Builder:
		RobotBuilder robotBuilder = new ModernRobotBuilder();
		
		//Director
		RobotEngineer robotEngineer = new RobotEngineer(robotBuilder);
		
		robotEngineer.makeRobot();
		
		Robot oldRobot = robotEngineer.getRobot();
		
		System.out.println("Robot constructed is: "+oldRobot);
	}
	
}