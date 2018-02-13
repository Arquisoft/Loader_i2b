package main.asw.util;
/**
 * 
 * @author Sergio Faya Fernandez
 * The intend of this class is to group all common field checking methods,
 *  that most of the times will throw runtime exception in case of failure.
 */
public class Checker {

	public static void isEmpty(String str) {		
		if(str.isEmpty()) {
			throw new RuntimeException("Value cannot be empty");
		}
	}
	
	public static void isNull(Object o) {
		if (o == null) {
			throw new RuntimeException("Value cannot be empty");
		}
	}
}
