package designPatterns.creational.abstractFactory.example_1;

//Strategy Design Pattern is being used here, as we can vary ESEngine
//Implementations dynamically
public class ESBossUFOEngine implements ESEngine {

	@Override
	public String getSpeed() {
		return "2,000 mph";
	}

}
