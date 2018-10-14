package Schritt1;

public class InException extends NumberFormatException{
	/* Der Konstruktor der Exception legt mittels eines Parameters den Ausgabetext fest.
	 * @param s der übergebene Ausgabe-Text
	 */
	public InException(String s) {
		super(s);
	}
}