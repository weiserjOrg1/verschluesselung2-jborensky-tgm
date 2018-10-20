package Schritt2;

import java.awt.*;
import javax.swing.*;
/**
 * Die CipherPanel-Klasse erstellt eine Zeichenoberfläche auf dem der verwendete und bearbeitete Text eingegeben wird.
 * @author BORJR
 * @version 2018-10-20
 */
public class CipherPanel extends JPanel{
	private CipherModel m1;
	
	/**
	 * Der Konstruktor der Panel-Klasse greift auf die Model-Klasse zu, um die Daten nutzen zu können.
	 * @param CipherModel m verwendete Model-Klasse
	 */
	public CipherPanel (CipherModel m) {
		this.m1 = m;
	}
	
	/**
	 * Diese Methode gibt den Text aus der Model-Klasse aus.
	 * @param Graphics g Grafikobjekt
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.setColor(Color.RED);
		g.drawString("Verschlüsselter Text: ", 5, 30);
		g.setColor(Color.BLUE);
		g.drawString(this.m1.getEtext(), 200, 30);
		g.setColor(Color.RED);
		g.drawString("Entschlüsselter Text: ", 5, 60);
		g.setColor(Color.BLUE);
		g.drawString(this.m1.getDtext(), 200, 60);
	}
}
