package Schritt3;

import Schritt1.Cipher;
/** Der TranspositionCipher wird zur Verschl�sselung u. Entschl�sselung von Texten mit der
 * Gartenzaunmethode verwendet.
 * @author BORJR
 * @version 2018-10-19
 */
public class TranspositionCipher implements Cipher{
	private int level; //Transpositionslevel
	private String text; //String zum Bearbeiten (Ver- u. Entschl�sseln)
	
	/** Der Konstruktor der TranspositionCipher-Klasse �bernimmt das Transpositionslevel.
	 * @param int level Transpositionslevel
	 */
	public TranspositionCipher(int level) {
		this.level = level;
	}
	
	/** Diese Methode setzt das Transpositionslevel, dass verwendet wird.
	 * @param level Transpositionslevel
	 */
	public void setTranspositionLevel(int level) { 
		if (level >= 1 && level <= 5) this.level = level;
	}

	/**
	 * Getter-Methode f�r den verarbeiteten Text
	 * @return String verarbeiteter Text
	 */
	public String getInhalt() {
		return this.text;
	}
	/**
	 * Setter-Methode f�r den zu verarbeitenden Text
	 * @param String t zu verarbeitender Text
	 */
	public void setInhalt(String t) {
		this.text = t;
	}
	
	@Override
	/** Methode zum Verschl�sseln eines Texts nach dem Transpositionsprinzip.
	 * @param String text Text, der entschl�sselt werden soll
	 */
	public String encrypt(String text) {
		String text1 = text.replaceAll("\\s", ""); 
		char[][] table = new char[this.level][text1.length()]; //Matrix zur Verschl�sselung
		
		//Matrix mit Punkten auff�llen
		for (int i = 0; i < this.level; i++) {
			for (int j = 0; j < text1.length(); j++) {
				table[i][j] = '.';
			}
		}
		
		//eigentliche Verschl�sselung ausf�hren
		int line = 0;
		int check = 0;
		for (int i = 0; i < text1.length(); i++) {
			if (check == 0) {
				table[line][i] = text1.charAt(i);
				line++;
					if (line == this.level) {
						check = 1;
						line--;
					}
			} else if (check == 1) {
				line--;
				table[line][i] = text1.charAt(i);
				if (line == 0) {
					check = 0;
					line = 1;
				}
			}
		}
		
		//String f�r die Ausgabe erstellen
		String temp ="";
		for (int i = 0; i < this.level; i++) {
			for (int j = 0; j < text1.length(); j++) {
				temp += table[i][j];
			}
		}
		temp = temp.replaceAll("\\.", ""); //Punkte ersetzen
		this.text = temp;
		return temp;
	}

	@Override
	/** Methode zum Entschl�sseln eines nach dem Transpositionsprinzip verschl�sselten Texts.
	 * @param String text Text, der entschl�sselt werden soll
	 */
	public String decrypt(String text) {
		String text1 = text.replaceAll("\\s", "");
		char[][] table = new char[this.level][text1.length()]; //Matrix zur Entschl�sselung erzeugen
				
		//zuvor erzeugte Matrix mit Punkten auff�llen
		for (int i = 0; i < this.level; i++) {
			for (int j = 0; j < text1.length(); j++) {
				table[i][j] = '.';
			}
		}

		//eigentliche Entschl�sselung des Textes
		int line = 0;
		int check = 0;
		for (int i = 0; i < text1.length(); i++) {
			if (check == 0) {
				table[line][i] = text1.charAt(i);
				line++;
				if (line == this.level) {
					check = 1;
					line--;
				}
			} else if (check == 1) {
				line--;
				table[line][i] = text1.charAt(i);
				if (line == 0) {
					check = 0;
					line = 1;
				}
			}
		}
		
		int order = 0;
		for (int i = 0; i < this.level; i++) {
			for (int j = 0; j < text1.length(); j++) {
				String temp = table [i][j] + "";
				if (temp.matches("\\.")) {
					continue;
				}else {
					table[i][j] = text1.charAt(order);
					order++;
				}
			}
		}
		
		//Text f�r die Ausgabe konvertieren
		String temp = "";
		int check1 = 0;
		int line1 = 0;
		
		for (int i = 0; i < text1.length(); i++) {
			if (check1 == 0) {
				temp += table[line1][i];
				line1++;
				if (line1 == this.level) {
					check1 = 1;
					line1--;
				}
				} else if (check1 == 1) {
					line1--;
					temp += table[line1][i];
					if (line1 == 0) {
						check1 = 0;
						line1 = 1;
				}
			}
		}
			
		//Zuvor eingef�gt Punkte l�schen
		temp = temp.replaceAll("\\.", "");
		this.text = temp;
		return temp;
	}
	
}
