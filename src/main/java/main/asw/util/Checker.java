package main.asw.util;
/**
 * 
 * @author Sergio Faya Fernandez
 * The intend of this class is to group all common field checking methods,
 *  that most of the times will throw runtime exception in case of failure.
 */
public class Checker {

	public static void isEmpty(String str) throws WrongParameterException {		
		if(str.isEmpty()) {
			throw new WrongParameterException("Value cannot be empty");
		}
	}
	
	public static void isNull(Object o) throws WrongParameterException {
		if (o == null) {
			throw new WrongParameterException("Value cannot be empty");
		}
	}
}
