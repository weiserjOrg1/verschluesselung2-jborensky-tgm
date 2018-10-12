package Schritt2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CipherController implements ActionListener {
	private CipherModel m1;
	private CipherView v1;
	private SubstitutionCipher s1;
	public CipherController(SubstitutionCipher s) {
		this.s1 = s;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
