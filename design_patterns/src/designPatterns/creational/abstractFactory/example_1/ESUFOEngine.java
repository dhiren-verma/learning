package designPatterns.creational.abstractFactory.example_1;

//Strategy Design Pattern is being used here, as we can vary ESEngine
//Implementations dynamically
public class ESUFOEngine implements ESEngine {
	
	@Override
	public String getSpeed() {
		return "1,000 mph";
	}

}
