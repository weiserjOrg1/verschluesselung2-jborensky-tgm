package Schritt1;

public class SubstitutionCipher extends MonoAlphabeticCipher {
	/**
	 * Der Konstruktor der Klasse SubstitutionCipher setzt das �bergebene Verschl�sselungsalphabet als
	 * neues Verschl�sselungsalphabet
	 * @param s1 �bernimmt das zum Verschl�sseln ben�tigte SecretAlphabet
	 */
	public SubstitutionCipher(String s1) {
		setSecretAlphabet(s1);
	}
	/**
	 * diese Methode setzt das Verschl�sselungsalphabet indem sie die Methode der
	 * parent-Klasse aufruft.
	 * siehe MonoAlphabeticCipher -> setSecretAlphabet(text:String):void
	 * @param s1 neues Verschl�sselungsalphabet
	 */
	public void setSecretAlphabet(String s1) {
		super.setSecretAlphabet(s1);
	}
}
