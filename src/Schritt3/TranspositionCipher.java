package Schritt3;

import Schritt1.Cipher;

public class TranspositionCipher implements Cipher{
	private int transLevel;
	public TranspositionCipher (int transpositionLevel) {
		this.setTransLevel(transpositionLevel);
	}
	@Override
	public String encrypt(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String text) {
		// TODO Auto-generated method stub
		return null;
	}
	public void setTransLevel(int transpositionLevel) {
		this.transLevel = transpositionLevel;
	}
	
}
