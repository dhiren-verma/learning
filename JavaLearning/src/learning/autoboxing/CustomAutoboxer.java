package learning.autoboxing;

public class CustomAutoboxer {
	
	/**
     * Returns an {@code Integer} instance representing the specified
     * {@code int} value.  If a new {@code Integer} instance is not
     * required, this method should generally be used in preference to
     * the constructor {@link #Integer(int)}, as this method is likely
     * to yield significantly better space and time performance by
     * caching frequently requested values.
     *
     * This method will always cache values in the range -128 to 127,
     * inclusive, and may cache other values outside of this range.
     *
     * @param  i an {@code int} value.
     * @return an {@code Integer} instance representing {@code i}.
     */
	public static Integer valueOf(int value) {
		if (value >= IntegerCache.low && value <= IntegerCache.high)
			return IntegerCache.cache[value+(-IntegerCache.low)];
		
		return Integer.valueOf(value);
	}
	
	/**
     * Cache to support the object identity semantics of auto-boxing for values between
     * -128 and 127 (inclusive) as required by JLS.
     * The cache is initialized on first usage.
     */
	private static class IntegerCache {
		static final int low = -128;
		static final int high;
		static final Integer[] cache;
		
		static {
			int h = 127;
			//high value may be configured by Property:
			String integerCacheHighPropValue = "127";
			
			if (integerCacheHighPropValue!=null) {
				try {
					int i = Integer.parseInt(integerCacheHighPropValue);
					i = Math.max(i, 127);
					h = Math.min(i, Integer.MAX_VALUE-(-low)-1);
				} catch (NumberFormatException nfe) {
					//if the String value can't be parsed into Integer, ignore it: 
				}
			}
			
			high = h;
			cache = new Integer[(high-low)+1];
			int j = low;
			
			for (int  k=0; k<cache.length; k++) {
				cache[k] = Integer.valueOf(j++);
			}
			
			//range [-128, 127] must be interned (JLS7 5.1.7)
			assert IntegerCache.high >= 127;
			
//			System.out.println("Integer Cache:");
//			Arrays.stream(cache).forEach(System.out::println);
		}
		
		private IntegerCache() {}
		
	}
	
}
