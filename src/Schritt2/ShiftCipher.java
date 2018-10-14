package Schritt2;

import javax.swing.JOptionPane;

import Schritt1.MonoAlphabeticCipher;

public class ShiftCipher extends MonoAlphabeticCipher{
	public char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
			   'u','v','w','x','y','z','ä','ö','ü','ß'};
	private int shiftValue;
	public ShiftCipher(int i) {
		this.setShiftValue(i);
		this.cycle();
	}
	
	public void setShiftValue(int i) {
		if (i>0&&i<=30) {
			this.shiftValue = i;
		} else {
			JOptionPane.showMessageDialog(null, "Geben Sie einen korrekten Wert ein!");
		}
	}
	
	private void cycle(){
		int i = this.shiftValue;
		char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
					   'u','v','w','x','y','z','ä','ö','ü','ß'};
		char[] newAlph = new char[this.alph.length];
		for(int j = 0; j < i; j++) {
			newAlph[0] = this.alph[this.alph.length-1];
			for(int x = 1; x < this.alph.length; x++) {
				newAlph[x] = this.alph[x-1];
			}
			this.alph = newAlph;
			if(j != i-1) {
				newAlph = new char[this.alph.length];
			}
			
		}
		String alphabet = "";
		for(int y = 0; y < newAlph.length; y++) {
			alphabet += newAlph[y]+"";
		}
		super.setSecretAlphabet(alphabet);
	}
}