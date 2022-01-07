package learning.autoboxing;

public class AutoboxingPOC {
	
	public static void main(String[] args) {
		//Auto-boxing - Similar concept as String Pooling:
		//For all the conversions from Primitive to Wrapper Classes
		//Integer#valueOf(int value) method is called
		//*Following behavior is implemented in this method:
		// Java maintains cache of Integer within the range of
		// '-128' to '127'
		// & if the given Primitive int value lies in this Range(both
		// values inclusive), the same Reference from Cache is returned,
		// but if its out or Range, then First its created & then returned.
		
		//This high value of '127' can be modified using VM Argument:
		// -XX:AutoBoxCacheMax=size
		
		//So if the value is a boolean, a byte or a char in the range
		// '\u0000' to '\u007f' or a short or int in the range, then
		// this Cache Store's Number reference is returned
		Integer a = 127;	//Auto-boxing - Integer a = Integer.valueOf(127);
		Integer b = 127;	//Auto-boxing - Integer b = Integer.valueOf(127);
		
		//But if the value is out of range, then it might get cached or may
		// return new Integer(value):
		Integer c = 128;	//Auto-boxing - Integer c = Integer.valueOf(128);
		Integer d = 128;	//Auto-boxing - Integer d = Integer.valueOf(128);
		
		System.out.println(a==b);
		System.out.println(c==d);
		System.out.println(a.equals(b));
		System.out.println(c.equals(d));
		
		//Auto-unboxing:
		int x = a%2;		//Auto-unboxing - int x = a.intValue()%2;
							//Reason behind this is Operator like Unary Plus(+)
							//and Modulus(%) only work on Primitive, so Java
							//converts these wrapper class instances to
							//corresponding primitives in an intrinsic way,
							//which is called Auto-unboxing.
		
		++a;				//First the value of 'a' is Auto-unboxed, then
							// incremented, then Auto-boxed
		
		//Personal Simulation of how AutoBoxing is accomplished:
		Integer e = CustomAutoboxer.valueOf(127);
		Integer f = CustomAutoboxer.valueOf(127);
		
		Integer g = CustomAutoboxer.valueOf(128);
		Integer h = CustomAutoboxer.valueOf(128);
		System.out.println(e==f);
		System.out.println(g==h);
		
	}
	
}
