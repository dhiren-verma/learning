package designPatterns.creational.builder;

public class ModernRobotBuilder implements RobotBuilder {

	private Robot robot;
	
	public ModernRobotBuilder() {
		robot = new Robot();
	}
	
	@Override
	public void buildRobotHead() {
		robot.setRobotHead("Bionic Head");
	}

	@Override
	public void buildRobotTorso() {
		robot.setRobotTorso("Bionic Torso");
	}

	@Override
	public void buildRobotArms() {
		robot.setRobotArms("Biomechanical Arms");
	}

	@Override
	public void buildRobotLegs() {
		robot.setRobotLegs("Biomechanical Legs");
	}

	@Override
	public Robot getRobot() {
		return robot;
	}

}
