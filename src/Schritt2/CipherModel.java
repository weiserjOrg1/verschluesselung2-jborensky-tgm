package Schritt2;

public class CipherModel {
	private String etext;
	private String dtext;
	private String alphabet;
	public CipherModel() {
		this.etext = " ";
		this.dtext = " ";
		this.alphabet = " ";
	}
	public String getEtext() {
		return etext;
	}
	public void setEtext(String etext) {
		this.etext = etext;
	}
	public String getDtext() {
		return dtext;
	}
	public void setDtext(String dtext) {
		this.dtext = dtext;
	}
	public String getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}
	
}
