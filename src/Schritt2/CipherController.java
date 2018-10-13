package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CipherController implements ActionListener {
	private CipherModel Model;
	private CipherView View;
	private SubstitutionCipher s1;
	private ShiftCipher sh1;
	private boolean alphT;
	public CipherController() {
		this.alphT = false;
		this.Model = new CipherModel();
		this.View = new CipherView(this.Model, this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.View.klickSA(e)) {
			this.View.refresh();
			this.View.setText();
			this.s1 = new SubstitutionCipher(this.Model.getAlphabet());
			this.alphT = true;
		}
		if (this.View.klickShA(e)) {
			this.View.refresh();
			this.View.setWert();
			this.sh1 = new ShiftCipher(this.Model.getVer());
		}
		if(this.View.klickDe(e)) {
			this.View.setDe();
			if (this.alphT) {
				this.Model.setDtext(this.s1.decrypt(this.Model.getDtext()));
			} else {
				this.Model.setDtext(this.sh1.decrypt(this.Model.getDtext()));
			}
			this.View.refresh();
		}
		if(this.View.klickEn(e)) {
			this.View.setEn();
			if (this.alphT) {
				this.Model.setEtext(this.s1.encrypt(this.Model.getEtext()));
			} else {
				this.Model.setEtext(this.sh1.encrypt(this.Model.getEtext()));
			}
			this.View.refresh();
		}
	}
	
}
