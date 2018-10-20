package Schritt2;

import javax.swing.JOptionPane;

import Schritt1.MonoAlphabeticCipher;
/** Die ShiftCipher-Klasse ist eine Kindklasse von MonoAlphabeticCipher und erzeugt ein eigenes Alphabet aus einem eingegebenen Zahlenwert.
 * @author BORJR
 * @version 2018-10-20
 */
public class ShiftCipher extends MonoAlphabeticCipher{
	public char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
			   'u','v','w','x','y','z','ä','ö','ü','ß'};
	private int shiftValue;
	
	/** Konstruktor der ShiftCipher-Klasse
	 * @param int i Verschiebewert
	 */
	public ShiftCipher(int i) {
		this.setShiftValue(i);
		this.cycle();
	}
	
	/** Setter-Methode zum Setzen des Verschiebewerts
	 * @param int i Verschiebewert
	 */
	public void setShiftValue(int i) {
		if (i>0&&i<=30) {
			this.shiftValue = i;
		} else {
			JOptionPane.showMessageDialog(null, "Geben Sie einen korrekten Wert ein!");
		}
	}
	
	/**
	 * Methode zum Erstellen des eigentlichen Alphabets
	 */
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