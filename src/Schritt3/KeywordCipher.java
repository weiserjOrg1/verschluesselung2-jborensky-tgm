package Schritt3;

import Schritt1.MonoAlphabeticCipher;

public class KeywordCipher extends MonoAlphabeticCipher{
	private String keyword;
	private String newAlph;
	public KeywordCipher(String keyword) {
		super();
		this.setKeyword(keyword);
		this.createAlphabet();
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void createAlphabet() {
		String Alphabet = "";
		String keyword = "";
		this.keyword.toLowerCase();
		while(true) {
			if (checkForMoreThanOne(this.keyword)) break;
			checkNumbOfLetters(this.keyword);
		}
		Alphabet = this.keyword + this.setnewAlph();
		super.setSecretAlphabet(Alphabet);
	}
	
	private String setnewAlph() {
		char[] alph = this.getSecretAlphabet().toCharArray();
		char[] word = this.keyword.toCharArray();
		int w = 1;
		for (int j = 0; j < word.length; j++) {
			for (int i=w; i<alph.length; i++) {
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
			w++;
		}
		return String.valueOf(alph);
	}
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
