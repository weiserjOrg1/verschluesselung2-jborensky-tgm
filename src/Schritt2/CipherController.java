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
		this.s1 = new SubstitutionCipher(" ");
	}
	
}
