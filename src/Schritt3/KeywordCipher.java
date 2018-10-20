package Schritt3;

import Schritt1.MonoAlphabeticCipher;
/* Der KeywordCipher erbt von der Klasse des MonoAlphabeticCiphers und erstellt ein
 * Verschlüsselungsalphabet mithilfe eines Schlüsselworts.
 * @author BORJR
 * @version 2018-10-20
 */
public class KeywordCipher extends MonoAlphabeticCipher{
	private String keyword; //Keyword zu Erstellung des Alphabets
	private String newAlph;
	
	/*
	 * Der Konstruktor der KeywordCipher-Klasse legt das Keyword fest und erstellt zugleich das neue Alphabet mithilfe von zwei Methoden.
	 * @param String keyword übergebenes Schlüsselwort
	 */
	public KeywordCipher(String keyword) {
		super();
		this.setKeyword(keyword);
		this.createAlphabet();
	}
	
	/*
	 * Getter-Methode für das Keyword-Attribut
	 * @param String keyword zu setztendes Schlüsselwort
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/*
	 * Methode, die das neue Verschlüsselungsalphabet erstellt.
	 */
	public void createAlphabet() {
		String Alphabet = "";
		String keyword = "";
		this.keyword = this.keyword.toLowerCase();
		while(true) {
			if (checkForMoreThanOne(this.keyword)) break;
			checkNumbOfLetters(this.keyword);
		}
		Alphabet = this.keyword + this.setnewAlph();
		super.setSecretAlphabet(Alphabet);
	}
	
	/*
	 * Methode, die den Zusatz zum Schlüsselwort generiert, damit das Alphabet vervollständigt
	 * werden kann.
	 * @return String neues Alphabet
	 */
	private String setnewAlph() {
		char[] alph = this.getSecretAlphabet().toCharArray();
		char[] word = this.keyword.toCharArray();
		for (int j = 0; j < word.length; j++) {
			for (int i=0; i<alph.length; i++) {
				if (word[j] == alph[i]) {
					char[] hilfe = new char[alph.length-1];
					for (int k = 0, l=0; k < hilfe.length; k++, l++) {
						if (l!=i) {
							hilfe[k] = alph[l];
						} else {
							k--;
						}
					}
					alph = hilfe;
				}
			}
		}
		return String.valueOf(alph);
	}
	
	/*
	 * Methode, die das öftere Vorkommen eines Buchstabens in dem Alphabet verhindert, indem sie
	 * doppelte Buchstaben löscht.
	 * @param String key zu bearbeitendes Alphabet
	 */
	public void checkNumbOfLetters(String key) {
		char[] keyword = key.toCharArray();
		int w = 1;
		for(int i = 0; i < keyword.length; i++){
			for (int j = w; j<=keyword.length-1; j++) {
				if((keyword[i]) == (keyword[j])){
					char[] hilfe = new char[keyword.length-1];
					for(int k = 0, l=0; k < keyword.length-1; k++, l++) {
						if(l!=j-1) {
							hilfe[k] = keyword[l];
						} else {
							k--;
						}
					}
					keyword = hilfe;
				}
			}
			w++;
		}
		this.keyword = String.valueOf(keyword);
	}
	
	/*
	 * Methode, die das doppelte Vorkommen von Buchstaben in einem Alphabet prüft.
	 * @param String s1 zu prüfendes Alphabet
	 * @return boolean b1 Alphabet ok oder nicht ok
	 */
	public boolean checkForMoreThanOne(String s1) {
		boolean b1 = false;
		for(int i = 0; i < s1.length(); i++){
			if(s1.indexOf(s1.charAt(i)) == s1.lastIndexOf(s1.charAt(i))){
				b1 = true;
			} else {
				return false;
			}
		}
		return b1;
	}
}
