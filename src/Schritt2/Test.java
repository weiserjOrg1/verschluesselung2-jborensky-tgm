package Schritt2;

import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) {
		String s1 = JOptionPane.showInputDialog(null, "Geben Sie einen Text zur Verschl�sselung ein!");
		String s2 = "����zyxwvutsrqponmlkjihgfedcba"; //Neues Verschl�sselungsalphabet -> ansonsten w�rde nichts verschl�sselt werden
		SubstitutionCipher c1 = new SubstitutionCipher(s2);
        String enc = c1.encrypt(s1);
        System.out.println("Encoded: " + enc); //verschl�sselter Text wird angzeigt
        System.out.println("\nDecoded: " + c1.decrypt(enc)); //Text wird wieder entschl�sselt und angezeigt.
    }
}
