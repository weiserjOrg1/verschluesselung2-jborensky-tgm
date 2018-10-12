package Schritt2;

import java.awt.*;
import javax.swing.*;

public class CipherView extends JFrame {
	private JTextField tAlphabet;
	private JTextField tText;
	private CipherModel Model;
	private CipherPanel Panel;
	private CipherController Controller;
	public CipherView(CipherModel m, CipherController c) {
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(3,2));
		this.add(this.tText);
		this.add(this.Panel);
	}
}
