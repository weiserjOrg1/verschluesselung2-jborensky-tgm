package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.print.attribute.AttributeSet;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import Schritt1.InException;

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
	private JRadioButton setS;
	private JRadioButton setM;
	private JRadioButton setT;
	private ButtonGroup setSMT;
	private JRadioButton setK;
	private Container BGroup;
	public CipherView(CipherModel m, CipherController c) {
		//Fenster 
		this.setTitle("Cipher");
		this.Model = m;
		this.Controller = c;
		this.Panel = new CipherPanel(this, this.Model);
		this.setLayout(new GridLayout(5,1));
		this.EnDeT = new Container();
		this.EnDeT.setLayout(new GridLayout(2,1));
		this.tTexten = new JTextField("entschl�sselten Text eingeben", SwingConstants.CENTER);
		this.tTextde = new JTextField("verschl�sselter Text eingeben", SwingConstants.CENTER);
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
		this.en = new JButton("Verschl�sseln");
		this.de = new JButton("Entschl�sseln");
		this.en.setFont(new Font("Segoe", Font.PLAIN, 18)); 
		this.de.setFont(new Font("Segoe", Font.PLAIN, 18));
		this.en.setBackground(Color.RED); this.en.setForeground(Color.WHITE);
		this.de.setBackground(Color.BLUE); this.de.setForeground(Color.WHITE);
		this.add(this.en);
		this.add(this.de);
		this.setS = new JRadioButton("ShiftCipher verwenden");
		this.setM = new JRadioButton("MonoalphabeticCipher mit eigenem Alphabet verwenden");
		this.setT = new JRadioButton("TranspositionCipher verwenden");
		this.setK = new JRadioButton("KeywordCipher verwenden");
		this.setSMT = new ButtonGroup();
		this.setSMT.add(this.setS);
		this.setSMT.add(this.setM);
		this.setSMT.add(this.setT);
		this.setSMT.add(this.setK);
		this.BGroup = new Container();
		this.BGroup.setLayout(new GridLayout(3,1));
		this.BGroup.add(this.setS);
		this.BGroup.add(this.setM);
		this.BGroup.add(this.setT);
		this.BGroup.add(this.setK);
		this.add(this.BGroup);
		this.setS.addItemListener(this.Controller);
		this.setM.addItemListener(this.Controller);
		this.setT.addItemListener(this.Controller);
		this.setK.addItemListener(this.Controller);
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
	public boolean setS(ActionEvent e) {
		if (e.getSource() == this.setS) return true;
		return false;
	}
	public boolean setT(ActionEvent e) {
		if (e.getSource() == this.setT) return true;
		return false;
	}
	public boolean setK(ActionEvent e) {
		if (e.getSource() == this.setK) return true;
		return false;
	}
	public boolean setM(ActionEvent e) {
		if (e.getSource() == this.setM) return true;
		return false;
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
	public void setWert() throws InException{
		String s = this.iShift.getText();
		InException in1 = new InException(3);
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw in1;
		}
		if (i > 0 && i<= 30) {
			this.Model.setVer(i);
		} else {
			throw in1;
		}
	}
	public void setKW() {
		this.Model.setKeyword(this.keyWord.getText());
		
	}
	public void setVal() throws InException{
		int value = 0;
		InException in1 = new InException(3);
		String s = this.setLevV.getText();
		try {
			value = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw in1;
		}
		if (value > 0 && value<= 5) {
			this.Model.setLev(value);
		} else {
			throw in1;
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
	public void lock(int i) {
		switch(i) {
			case 1: this.iShift.setEditable(true); this.setShAlphabet.setEnabled(true);
					this.setLev.setEnabled(false); this.setLevV.setEditable(false);
					this.keyWord.setEditable(false); this.UseKeyW.setEnabled(false);
					this.tAlphabet.setEditable(false); this.setAlphabet.setEnabled(false);
					break;
					
			case 2: this.iShift.setEditable(false); this.setShAlphabet.setEnabled(false);
					this.setLev.setEnabled(false); this.setLevV.setEditable(false);
					this.keyWord.setEditable(false); this.UseKeyW.setEnabled(false);
					this.tAlphabet.setEditable(true); this.setAlphabet.setEnabled(true);
					break; 
					
			case 3: this.iShift.setEditable(false); this.setShAlphabet.setEnabled(false);
					this.setLev.setEnabled(true); this.setLevV.setEditable(true);
					this.keyWord.setEditable(false); this.UseKeyW.setEnabled(false);
					this.tAlphabet.setEditable(false); this.setAlphabet.setEnabled(false);
					break;
					
			case 4: this.iShift.setEditable(false); this.setShAlphabet.setEnabled(false);
					this.setLev.setEnabled(false); this.setLevV.setEditable(false);
					this.keyWord.setEditable(true); this.UseKeyW.setEnabled(true);
					this.tAlphabet.setEditable(false); this.setAlphabet.setEnabled(false);
					break;
					
			default:	this.iShift.setEditable(false); this.setShAlphabet.setEnabled(false);
						this.setLev.setEnabled(false); this.setLevV.setEditable(false);
						this.keyWord.setEditable(false); this.UseKeyW.setEnabled(false);
						this.tAlphabet.setEditable(false); this.setAlphabet.setEnabled(false);
						break;
		}
		
	}
	public int getButton() {
		int i = 0;
		if (this.setK.isSelected()) i = 4;
		if (this.setT.isSelected()) i = 3;
		if (this.setM.isSelected()) i = 2;
		if (this.setS.isSelected()) i = 1;
		return i;
	}
}
