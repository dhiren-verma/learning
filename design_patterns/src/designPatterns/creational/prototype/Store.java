package designPatterns.creational.prototype;

public interface Store extends Cloneable{

	Store clone() throws CloneNotSupportedException;

}