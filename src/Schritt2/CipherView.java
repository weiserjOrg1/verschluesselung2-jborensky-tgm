package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.print.attribute.AttributeSet;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class CipherView extends JFrame {
	private JTextField tAlphabet;
	private JTextField tTexten;
	private JTextField tTextde;
	private JTextField iShift;
	private JButton setAlphabet;
	private Container EnDeT;
	private Container newA;
	private JButton en;
	private JButton de;
	private CipherModel Model;
	private CipherPanel Panel;
	private CipherController Controller;
	private JButton setShAlphabet;
	private Container SetA;
	private Container kCipher;
	private JTextField keyWord;
	private JButton UseKeyW;
	private Container setTC;
	private JTextField setLevV;
	private JButton setLev;
	public CipherView(CipherModel m, CipherController c) {
		this.setTitle("Cipher");
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(4,2));
		this.EnDeT = new Container();
		this.EnDeT.setLayout(new GridLayout(2,1));
		this.tTexten = new JTextField("entschlüsselten Text eingeben", SwingConstants.CENTER);
		this.tTextde = new JTextField("verschlüsselter Text eingeben", SwingConstants.CENTER);
		this.tTexten.setFont(new Font("Arial", Font.PLAIN, 18)); this.tTexten.setForeground(Color.RED);
		this.tTextde.setFont(new Font("Arial", Font.PLAIN, 18)); this.tTextde.setForeground(Color.BLUE);
		this.tTextde.setHorizontalAlignment(JTextField.CENTER);
		this.tTexten.setHorizontalAlignment(JTextField.CENTER);
		this.tTextde.setBackground(this.Panel.getBackground());
		this.tTexten.setBackground(this.Panel.getBackground());
		this.EnDeT.add(this.tTexten);
		this.EnDeT.add(this.tTextde);
		this.add(this.EnDeT);
		this.add(this.Panel);
		this.newA = new Container();
		this.newA.setLayout(new GridLayout(2,1));
		this.tAlphabet = new JTextField("Alphabet eingeben");
		//this.tAlphabet.setDocument(createNumericDocumentWithMaxLength(30));
		this.setAlphabet = new JButton("neues Alphabet verwenden");
		this.newA.add(this.tAlphabet);
		this.newA.add(this.setAlphabet);
		this.add(newA);
		this.SetA = new Container();
		this.SetA.setLayout(new GridLayout(2,1));
		this.iShift = new JTextField("Geben Sie eine Zahl zwischen 1 und 30 ein!");
		this.setShAlphabet = new JButton("Alphabet mit eingegebenem Wert erstellen.");
		this.SetA.add(this.iShift);
		this.SetA.add(this.setShAlphabet);
		this.add(this.SetA);
		this.kCipher = new Container();
		this.kCipher.setLayout(new GridLayout(2,1));
		this.keyWord = new JTextField("Geben Sie ein Keyword ein!");
		this.UseKeyW = new JButton("Alphabet mit Keyword erstellen!");
		this.kCipher.add(this.keyWord);
		this.kCipher.add(this.UseKeyW);
		this.add(this.kCipher);
		this.setTC = new Container();
		this.setTC.setLayout(new GridLayout(2,1));
		this.setLevV = new JTextField("Verschiebungsfaktor zwischen 1 und 5 eingeben!");
		this.setLev = new JButton("Transposition verwenden!");
		this.setTC.add(this.setLevV);
		this.setTC.add(this.setLev);
		this.add(this.setTC);
		this.en = new JButton("Verschlüsseln");
		this.de = new JButton("Entschlüsseln");
		this.en.setFont(new Font("Segoe", Font.PLAIN, 18)); 
		this.de.setFont(new Font("Segoe", Font.PLAIN, 18));
		this.en.setBackground(Color.RED); this.en.setForeground(Color.WHITE);
		this.de.setBackground(Color.BLUE); this.de.setForeground(Color.WHITE);
		this.add(this.en);
		this.add(this.de);
		this.setLev.addActionListener(this.Controller);
		this.UseKeyW.addActionListener(this.Controller);
		this.en.addActionListener(this.Controller);
		this.de.addActionListener(this.Controller);
		this.setAlphabet.addActionListener(this.Controller);
		this.setShAlphabet.addActionListener(this.Controller);
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
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
	public boolean klickUKW(ActionEvent e) {
		if (e.getSource() == this.UseKeyW) return true;
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
	public boolean klickShA(ActionEvent e) {
		if (e.getSource() == this.setShAlphabet) return true;
		return false;
	}
	public void setWert() {
		String s = this.iShift.getText();
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Geben Sie eine korrekte Zahl ein!");
		}
		if (i > 0 && i<= 30) {
			this.Model.setVer(i);
		} else {
			JOptionPane.showMessageDialog(null, "Geben Sie eine korrekte Zahl ein!");
		}
	}
	public void setKW() {
		this.Model.setKeyword(this.keyWord.getText());
		
	}
	public void setVal() {
		int value = 0;
		String s = this.setLevV.getText();
		try {
			value = Integer.parseInt(s);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Geben Sie eine korrekte Zahl ein!");
		}
		if (value > 0 && value<= 5) {
			this.Model.setLev(value);
		} else {
			JOptionPane.showMessageDialog(null, "Geben Sie eine korrekte Zahl ein!");
		}
	}
	public boolean klickTS(ActionEvent e) {
		if(e.getSource() == this.setLev) return true;
		return false;
	}
	/*private Document createNumericDocumentWithMaxLength(final int maxLength){
	     
	      Document doc = new PlainDocument(){
	         @Override
	         public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws BadLocationException {
	            if(getLength() + str.length() > maxLength)
	               return;
	            if(!str.matches("^[\\d]*$"))
	               return;
	           
	           
	            super.insertString(offs, str, a);
	         }
	      };
	      return doc;
	     
	   } 
	   */
}
