package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Schritt1.SubstitutionCipher;
import Schritt3.KeywordCipher;
import Schritt3.TranspositionCipher;

public class CipherController implements ActionListener, ItemListener {
	private CipherModel Model;
	private CipherView View;
	private SubstitutionCipher s1;
	private ShiftCipher sh1;
	private boolean alphT;
	private boolean shT;
	private boolean kCT;
	private KeywordCipher kC;
	private TranspositionCipher TC;
	private boolean TcT;
	public CipherController() {
		this.alphT = false;
		this.Model = new CipherModel();
		this.View = new CipherView(this.Model, this);
		this.View.lock(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.View.klickSA(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setText();
			this.s1 = new SubstitutionCipher(this.Model.getAlphabet());
			this.alphT = true; this.shT = false; this.kCT = false; this.TcT = false;
		}
		if (this.View.klickShA(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setWert();
			this.sh1 = new ShiftCipher(this.Model.getVer());
			this.shT = true; this.alphT = false; this.kCT = false; this.TcT = false;
		}
		if (this.View.klickUKW(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setKW();
			this.kC = new KeywordCipher(this.Model.getKeyWord());
			this.kCT = true; this.alphT = false; this.shT = false; this.TcT = false;
		}
		if (this.View.klickTS(e)) {
			this.View.repaint();
			this.Model.refresh();
			this.View.refresh();
			this.View.setVal();
			this.TC = new TranspositionCipher(this.Model.getLev());
			this.TcT = true; this.kCT = false; this.alphT = false; this.shT = false;
		}
		if(this.View.klickDe(e)) {
			this.View.setDe();
			if (this.alphT) this.Model.setDtext(this.s1.decrypt(this.Model.getDtext()));
			if (this.shT) this.Model.setDtext(this.sh1.decrypt(this.Model.getDtext()));
			if (this.kCT) this.Model.setDtext(this.kC.decrypt(this.Model.getDtext()));
			if (this.TcT) this.Model.setDtext(this.TC.decrypt(this.Model.getDtext()));
			this.View.refresh();
		}
		if(this.View.klickEn(e)) {
			this.View.setEn();
			if (this.alphT) this.Model.setEtext(this.s1.encrypt(this.Model.getEtext()));
			if (this.shT) this.Model.setEtext(this.sh1.encrypt(this.Model.getEtext()));
			if (this.kCT) this.Model.setEtext(this.kC.encrypt(this.Model.getEtext()));
			if (this.TcT) this.Model.setEtext(this.TC.encrypt(this.Model.getEtext()));
			this.View.refresh();
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		int i = this.View.getButton();
		this.View.lock(i);
	}
	
}
