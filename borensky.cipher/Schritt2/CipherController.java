package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Schritt1.MonoAlphabeticCipher;
import Schritt1.SubstitutionCipher;
import Schritt3.KeywordCipher;
import Schritt3.TranspositionCipher;
/** Der Controller wird zur Ereignisverarbeitung und zum Erstellen anderer Objekte verwendet.
 * @author BORJR
 * @version 2018-10-19
 */
public class CipherController implements ActionListener, ItemListener {
	
	private CipherModel Model;
	private CipherView View;
	private MonoAlphabeticCipher c1;
	private TranspositionCipher t1;
	private boolean TcT; //sagt aus, ob ein TranspositionCipher verwendet wird
	
	/** 
	 * Der Konstruktor der CipherController-Klasse erstellt eine Model- u. eine View-Klasse.
	 */
	public CipherController() {
		this.Model = new CipherModel();
		this.View = new CipherView(this.Model, this);
		this.View.lock(0);
	}

	@Override
	/**
	 * Methode zur Verarbeitung von Ereignissen in der GUI
	 * @param ActionEvent e aufgerufenes ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		//Substitution-Cipher verwenden
		if(this.View.klickSA(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setText();
			this.c1 = new SubstitutionCipher(this.Model.getAlphabet());
			this.TcT = false;
		}
		
		//ShiftCipher verwenden
		if (this.View.klickShA(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setWert();
			this.c1 = new ShiftCipher(this.Model.getVer());
			this.TcT = false;
		}
		
		//KeywordCipher verwenden
		if (this.View.klickUKW(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setKW();
			this.c1 = new KeywordCipher(this.Model.getKeyWord());
			this.TcT = false;
		}
		
		//TranspositionCipher verwenden
		if (this.View.klickTS(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setVal();
			this.t1 = new TranspositionCipher(this.Model.getLev());
			this.TcT = true; 
		}
		
		//Entschlüsseln
		if(this.View.klickDe(e)) {
			this.View.setDe(); 
			if (this.TcT) {
				this.Model.setDtext(this.t1.decrypt(this.Model.getDtext()));
			} else {
				this.Model.setDtext(this.c1.decrypt(this.Model.getDtext()));
			}
			this.View.refresh();
		}
		
		//Verschlüsseln
		if(this.View.klickEn(e)) {
			this.View.setEn();
			if (this.TcT) {
				this.Model.setEtext(this.t1.encrypt(this.Model.getEtext()));
			} else {
				this.Model.setEtext(this.c1.encrypt(this.Model.getEtext()));
			}
			this.View.refresh();
		}
		
	}
	@Override
	/*
	 * Methode zur Verarbeitung einer Eingabe in der Button-Group
	 * @param ItemEvent arg0 aufgerufenens ItemEvent
	 */
	public void itemStateChanged(ItemEvent arg0) {
		int i = this.View.getButton();
		this.View.lock(i);
	}
	
}
