package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class CipherView extends JFrame {
	private JTextField tAlphabet;
	private JTextField tTexten;
	private JTextField tTextde;
	private JButton setAlphabet;
	private Container EnDe;
	private JButton en;
	private JButton de;
	private CipherModel Model;
	private CipherPanel Panel;
	private CipherController Controller;
	public CipherView(CipherModel m, CipherController c) {
		this.setTitle("Cipher");
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(3,2));
		this.tTexten = new JTextField("entschlüsselter Text eingeben");
		this.add(this.tTexten);
		this.tTextde = new JTextField("verschlüsselter Text eingeben");
		this.add(this.tTextde);
		this.tAlphabet = new JTextField("Alphabet eingeben");
		this.add(this.tAlphabet);
		this.add(this.Panel);
		this.setAlphabet = new JButton("neues Alphabet verwenden");
		this.add(this.setAlphabet);
		this.EnDe = new Container();
		this.EnDe.setLayout(new GridLayout(2,1));
		this.en = new JButton("Verschlüsseln");
		this.de = new JButton("Entschlüsseln");
		this.EnDe.add(this.en);
		this.EnDe.add(this.de);
		this.add(this.EnDe);
		this.en.addActionListener(this.Controller);
		this.de.addActionListener(this.Controller);
		this.setAlphabet.addActionListener(this.Controller);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	public boolean klickSA(ActionEvent e) {
		if (e.getSource() == this.setAlphabet) return true;
		return false;
	}
	public boolean klickEn(ActionEvent e) {
		if (e.getSource() == this.en) return true;
		return false;
	}
	public boolean klickDe(ActionEvent e) {
		if (e.getSource() == this.de) return true;
		return false;
	}
	public void refresh() {
		this.repaint();
	}
	public void setText() {
		this.Model.setAlphabet(this.tAlphabet.getText());
	}
	public void setDe() {
		this.Model.setDtext(this.tTextde.getText());
	}
	public void setEn() {
		this.Model.setEtext(this.tTexten.getText());
	}
}
