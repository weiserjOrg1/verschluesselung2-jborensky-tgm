package Schritt1;

import Schritt1.InException;

public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;//Variable für das secretAlphabet/Verschlüsselungsalphabet  
	/**
	 * Der Konstruktor der Klasse MonoAlphabeticCipher setzt einfach das Standard-Verschlüsselungsalphabet.
	 */
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	/**
	 * Getter-Methode des SectetAlphabet-Attributes
	 * @return gibt das Attribut SecretAlphabet zurück
	 */
	public String getSecretAlphabet(){
		return this.secretAlphabet;
	}
	/**
	 * Mithilfe dieser Methode wird zuerst über zwei Hilfsmethoden geprüft, ob das übergebene Alphabet den
	 * Anforderungen entspricht und wird dementsprechend dann als neues Verschlüsselungsalphabet gesetzt oder nicht. 
	 * @param newSA -> übergebenes Verschlüsselungsalphabet
	 */
	protected void setSecretAlphabet(String newSA) throws InException{
		newSA.toLowerCase();
		if(secretAlphabet.length() == this.secretAlphabet.length() && checkNumbOfLetters(newSA) == false && containsLetters(newSA) == true){
			this.secretAlphabet = newSA;
		}else {
			InException in1 = new InException(1);
			throw in1;
		}
	}
	/**
	 * Ein Buchstabe darf im Verschlüsselungsalphabet nur einmal vorkommen.
	 * Ob das der Fall ist, wird mit dieser Methode geprüft. 
	 * @param SA übernimmt das neue Verschlüsselungsalphabet
	 * @return gibt false zurück, wenn das neue Alphabet nicht den Regeln entspricht, true wenn schon.
	 */
	private boolean checkNumbOfLetters(String SA) {
		for(int i = 0; i < SA.length(); i++){
			if(SA.indexOf(SA.charAt(i)) == SA.lastIndexOf(SA.charAt(i))){
				return false;
			}
		}
		return true;
	}
	/**
	 * Hier wird überprüft, ob ein neues Verschlüsselungsalphabet den gegebenen Anforderungen entspricht.
	 * @param SA übernimmt das neue Verschlüsselungsalphabet
	 * @return gibt false zurück, wenn das Alphabet nicht den Regeln entspricht, true wenn schon.
	 */
	private boolean containsLetters(String secretAlphabet) {
		String a1 = "abcdefghijklmnopqrstuvwxyzäöüß";
		for(int i = 0; i < secretAlphabet.length(); i++) {
			if(secretAlphabet.indexOf(a1.charAt(i)) == -1){
				return false;
			}
		}
		return true;
	}
	/**
	 * Diese Methode verschlüsselt den übergebenen Text und gibt ihn zurück
	 * @param s1 übernimmt den zu verschlüsselnden Text
	 * @return gibt den verschlüsselten s1 zurück
	 */
	@Override
	public String encrypt(String s1) throws InException{
		String t1 = "";
		if(s1 == null || s1 == "") {
			InException in1 = new InException(2);
			throw in1;
		}else {
			s1 = s1.toLowerCase();
			String a2 = "abcdefghijklmnopqrstuvwxyzäöüß";
			for(int i = 0; i < s1.length(); i++) {
				try {
					t1 += this.secretAlphabet.charAt(a2.indexOf(s1.charAt(i)));
				}catch(StringIndexOutOfBoundsException e) {
					t1 += s1.charAt(i)+"";
				}
			}
		}
		return t1;	
	}
	/**
	 * Diese Methode entschlüsselt den übergebenen Text und gibt ihn dann zurück.
	 * @param s1 übernimmt den verschlüsselten Text
	 * @return gibt den entschlüsselten Text zurück 
	 */
	@Override
	public String decrypt(String s1) throws InException{
		String t1 = "";
		if(s1 == null || s1 == "") {
			InException in1 = new InException(2);
			throw in1;
		}else {
			s1 = s1.toLowerCase();
			String a2 = "abcdefghijklmnopqrstuvwxyzäöüß";
			for(int i = 0; i < s1.length(); i++) {
				try {
					t1 += a2.charAt(this.secretAlphabet.indexOf(s1.charAt(i)));
				}catch(StringIndexOutOfBoundsException e) {
					t1 += s1.charAt(i)+"";
				}
			}
		}
		return t1;
	}
}
