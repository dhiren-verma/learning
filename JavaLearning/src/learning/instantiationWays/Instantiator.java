package learning.instantiationWays;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Instantiator {

	public static void main(String[] args) throws InstantiationException,
		IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
		InvocationTargetException, CloneNotSupportedException, NoSuchMethodException,
		SecurityException, IOException {
		//Method 1: Using new Keyword:
		MyClass firstMyClassIns = new MyClass();
		System.out.println("First Instance: " + firstMyClassIns);
		
		//Method 2: Using 'Class.forName()' method"
		//This method always uses ClassLoader associated with the calling
		//class, i.e. Instantiator:
		//*Deprecated as this method propagates any exception thrown by the
	    // nullary(no-arg) constructor, including a checked exception. 
		// Use of this method effectively bypasses the compile-time
		// exception checking that would otherwise be performed by the
		// compiler.
		//*The java.lang.reflect.Constructor#newInstance(java.lang.Object...)
	    // method avoids this problem by wrapping any exception thrown
		// by the constructor in a
		// (checked) java.lang.reflect.InvocationTargetException.
		MyClass secondMyClassIns = (MyClass) Class.forName(MyClass.class.getName()).newInstance();
		System.out.println("Second Instance: " + secondMyClassIns);
		
		//Method 3: Using Reflection API(java.lang.reflect.Constructor):
		Constructor<MyClass> myClassConstructor =
				(Constructor<MyClass>) MyClass.class.getDeclaredConstructors()[0];
		MyClass thirdMyClassIns = myClassConstructor.newInstance();
		System.out.println("Third Instance: " + thirdMyClassIns);
		
		//Method 4: Using ClassLoader#newInstance() Method:
		//*Similar to Class.forNAme, just that the ClassLoader
		// used is of the mentioned Class, here MyClass:
		MyClass fourthMyClassIns = (MyClass) MyClass.class.getClassLoader().
				loadClass(MyClass.class.getName()).newInstance();
		System.out.println("Fourth Instance: " + fourthMyClassIns);
		
		//Method 5: If Class is Cloneable, then using clone Method:
		// If the Class is not Cloneable, then we will get java.lang.CloneNotSupportedException
//		MyClass fifthMyClassIns = (MyClass) firstMyClassIns.clone();
		//OR
		Method restrictedCloneMethod = MyClass.class.getDeclaredMethod("clone", null);
		restrictedCloneMethod.setAccessible(true);
		MyClass fifthMyClassIns = (MyClass) restrictedCloneMethod.invoke(firstMyClassIns, null);
		System.out.println("Fifth Instance: " + fifthMyClassIns);
		
		//Method 6: If Class is Serializable, then using Serialization-Deserailization:
		// If the Class is not Serializable, then we will get java.io.NotSerializableException
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myClassHolder"));
		oos.writeObject(firstMyClassIns);
		oos.flush();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myClassHolder"));
		MyClass sixthMyClassObj = (MyClass) ois.readObject();
		System.out.println("Sixth Instance: " + sixthMyClassObj);
		
	}
}
