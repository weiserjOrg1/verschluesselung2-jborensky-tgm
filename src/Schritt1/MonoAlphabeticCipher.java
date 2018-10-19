package Schritt1;

import Schritt1.InException;

public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;//Variable f�r das secretAlphabet/Verschl�sselungsalphabet  
	/**
	 * Der Konstruktor der Klasse MonoAlphabeticCipher setzt einfach das Standard-Verschl�sselungsalphabet.
	 */
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}
	/**
	 * Getter-Methode des SectetAlphabet-Attributes
	 * @return gibt das Attribut SecretAlphabet zur�ck
	 */
	public String getSecretAlphabet(){
		return this.secretAlphabet;
	}
	/**
	 * Mithilfe dieser Methode wird zuerst �ber zwei Hilfsmethoden gepr�ft, ob das �bergebene Alphabet den
	 * Anforderungen entspricht und wird dementsprechend dann als neues Verschl�sselungsalphabet gesetzt oder nicht. 
	 * @param newSA -> �bergebenes Verschl�sselungsalphabet
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
	 * Ein Buchstabe darf im Verschl�sselungsalphabet nur einmal vorkommen.
	 * Ob das der Fall ist, wird mit dieser Methode gepr�ft. 
	 * @param SA �bernimmt das neue Verschl�sselungsalphabet
	 * @return gibt false zur�ck, wenn das neue Alphabet nicht den Regeln entspricht, true wenn schon.
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
	 * Hier wird �berpr�ft, ob ein neues Verschl�sselungsalphabet den gegebenen Anforderungen entspricht.
	 * @param SA �bernimmt das neue Verschl�sselungsalphabet
	 * @return gibt false zur�ck, wenn das Alphabet nicht den Regeln entspricht, true wenn schon.
	 */
	private boolean containsLetters(String secretAlphabet) {
		String a1 = "abcdefghijklmnopqrstuvwxyz����";
		for(int i = 0; i < secretAlphabet.length(); i++) {
			if(secretAlphabet.indexOf(a1.charAt(i)) == -1){
				return false;
			}
		}
		return true;
	}
	/**
	 * Diese Methode verschl�sselt den �bergebenen Text und gibt ihn zur�ck
	 * @param s1 �bernimmt den zu verschl�sselnden Text
	 * @return gibt den verschl�sselten s1 zur�ck
	 */
	@Override
	public String encrypt(String s1) throws InException{
		String t1 = "";
		if(s1 == null || s1 == "") {
			InException in1 = new InException(2);
			throw in1;
		}else {
			s1 = s1.toLowerCase();
			String a2 = "abcdefghijklmnopqrstuvwxyz����";
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
	 * Diese Methode entschl�sselt den �bergebenen Text und gibt ihn dann zur�ck.
	 * @param s1 �bernimmt den verschl�sselten Text
	 * @return gibt den entschl�sselten Text zur�ck 
	 */
	@Override
	public String decrypt(String s1) throws InException{
		String t1 = "";
		if(s1 == null || s1 == "") {
			InException in1 = new InException(2);
			throw in1;
		}else {
			s1 = s1.toLowerCase();
			String a2 = "abcdefghijklmnopqrstuvwxyz����";
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
