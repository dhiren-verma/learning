package designPatterns.creational.abstractFactory.example_1;

public class EnemyShipTesting {

	public static void main(String[] args) {
		// EnemyShipBuilding handles orders for new EnemyShips
        // You send it a code using the orderTheShip method &
        // it sends the order to the right factory for creation
		EnemyShipBuilding makeUFO = new UFOEnemyShipBuilding();
		
		EnemyShip theGrunt = makeUFO.orderTheShip("UFO");
		System.out.println(theGrunt);
		
		EnemyShip theBoss = makeUFO.orderTheShip("BOSS UFO");
		System.out.println(theBoss);
	}

}
