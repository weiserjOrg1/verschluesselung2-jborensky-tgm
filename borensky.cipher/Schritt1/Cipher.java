package Schritt1;
/** Festlegen der Syntax
 * @author BORJR
 * @version 2018-10-20
 */
public interface Cipher {
	//legt die Syntax, die für die beiden Methoden zu beachten ist, fest. 
	public String encrypt(String text);
	public String decrypt(String text);
}
