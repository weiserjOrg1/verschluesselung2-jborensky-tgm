package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CipherController implements ActionListener {
	private CipherModel Model;
	private CipherView View;
	private SubstitutionCipher s1;
	public CipherController() {
		this.Model = new CipherModel();
		this.View = new CipherView(this.Model, this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.View.klickSA(e)) {
			this.View.refresh();
			this.View.setText();
			this.s1 = new SubstitutionCipher(this.Model.getAlphabet());
		}
		if(this.View.klickDe(e)) {
			this.View.setDe();
			this.Model.setDtext(this.s1.decrypt(this.Model.getDtext()));
			this.View.refresh();
		}
		if(this.View.klickEn(e)) {
			this.View.setEn();
			this.Model.setEtext(this.s1.encrypt(this.Model.getEtext()));
			this.View.refresh();
		}
	}
	
}
