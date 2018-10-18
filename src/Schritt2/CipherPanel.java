package Schritt2;

import java.awt.*;
import javax.swing.*;

public class CipherPanel extends JPanel{
	private CipherModel m1;
	private CipherView v1;
	public CipherPanel (CipherView v, CipherModel m) {
		this.m1 = m;
		this.v1 = v;
	}
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
