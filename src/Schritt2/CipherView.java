package Schritt2;

import java.awt.*;
import javax.swing.*;

public class CipherView extends JFrame {
	private JTextField tAlphabet;
	private JTextField tText;
	private JButton setAlphabet;
	private CipherModel Model;
	private CipherPanel Panel;
	private CipherController Controller;
	public CipherView(CipherModel m, CipherController c) {
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(3,2));
		this.tText = new JTextField("verschlüsselten Text eingeben");
		this.add(this.tText);
		this.add(this.Panel);
		this.setAlphabet = new JButton("neues Alphabet verwenden");
		this.add(this.setAlphabet);
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
