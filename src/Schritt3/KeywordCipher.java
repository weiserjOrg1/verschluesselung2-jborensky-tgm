package Schritt3;

import Schritt1.MonoAlphabeticCipher;

public class KeywordCipher extends MonoAlphabeticCipher{
	private String keyword;
	public KeywordCipher(String keyword) {
		this.setKeyword(keyword);
		this.createAlphabet();
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void createAlphabet() {
		String Alphabet = "";
		
		super.setSecretAlphabet(Alphabet);
	}
}
