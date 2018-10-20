package Schritt1;
/* Kindklasse der MonoAlphabeticCipher, die bei der Erstellung ein Alphabet festlegt
 * @author BORJR
 * @version 2018-10-20
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {
	/**
	 * Der Konstruktor der Klasse SubstitutionCipher setzt das übergebene Verschlüsselungsalphabet als
	 * neues Verschlüsselungsalphabet
	 * @param s1 übernimmt das zum Verschlüsseln benötigte SecretAlphabet
	 */
	public SubstitutionCipher(String s1) {
		setSecretAlphabet(s1);
	}
	/**
	 * diese Methode setzt das Verschlüsselungsalphabet indem sie die Methode der
	 * parent-Klasse aufruft.
	 * siehe MonoAlphabeticCipher -> setSecretAlphabet(text:String):void
	 * @param s1 neues Verschlüsselungsalphabet
	 */
	public void setSecretAlphabet(String s1) {
		super.setSecretAlphabet(s1);
	}
}
