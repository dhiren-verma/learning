package designPatterns.creational.builder;

/**
 * This Class represents the Product that is to be built
 * using the Builder Design Pattern
 * 
 * @author Dhirendra Verma
 * 
 */
public class Robot implements RobotPlan{
	
	private String robotHead;
	private String robotTorso;
	private String robotArms;
	private String robotLegs;
	
	@Override
	public void setRobotHead(String head) {
		robotHead = head;
	}
	
	public String getRobotHead() {
		return robotHead;
	}
	
	@Override
	public void setRobotTorso(String torso) {
		robotTorso = torso;
	}

	public String getRobotTorso() {
		return robotTorso;
	}
	
	@Override
	public void setRobotArms(String arms) {
		robotArms = arms;
	}

	public String getRobotArms() {
		return robotArms;
	}
	
	@Override
	public void setRobotLegs(String legs) {
		robotLegs = legs;
	}

	public String getRobotLegs() {
		return robotLegs;
	}
	
	@Override
	public String toString() {
		return "Robot [robotHead=" + robotHead + ", robotTorso=" + robotTorso + ", robotArms=" + robotArms
				+ ", robotLegs=" + robotLegs + "]";
	}
	
}