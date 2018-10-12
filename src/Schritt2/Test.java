package Schritt2;

import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) {
		String s1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text zur Verschlüsselung ein!");
		String s2 = "ßüöäzyxwvutsrqponmlkjihgfedcba"; //Neues Verschlüsselungsalphabet -> ansonsten würde nichts verschlüsselt werden
		SubstitutionCipher c1 = new SubstitutionCipher(s2);
        String enc = c1.encrypt(s1);
        System.out.println("Encoded: " + enc); //verschlüsselter Text wird angzeigt
        System.out.println("\nDecoded: " + c1.decrypt(enc)); //Text wird wieder entschlüsselt und angezeigt.
    }
}
