package Schritt1;

import javax.swing.JOptionPane;
/** Exception zur Verabeitung bei Benutzereingaben
 * @author BORJR
 * @version 2018-10-20
 */
public class InException extends NumberFormatException{
	/** Der Konstruktor der Exception legt mittels eines Parameters den Ausgabetext fest.
	 * @param s der �bergebene Ausgabe-Text
	 */
	public InException(int i) {
		switch(i) {
			case 1: JOptionPane.showMessageDialog(null, "Geben Sie ein g�ltiges Alphabet ein!");
			case 2: JOptionPane.showMessageDialog(null, "Geben Sie einen g�ltigen Text ein!");
			case 3: JOptionPane.showMessageDialog(null, "Geben Sie eine korrekte Zahl ein!");
			default:
		}
	}
}