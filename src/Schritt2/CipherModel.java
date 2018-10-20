package Schritt2;

public class CipherModel {
	private String etext;
	private String dtext;
	private String alphabet;
	private int Ver;
	public String keyWord;
	private int lev;
	
	/*
	 * Der Konstruktor der CipherModel-Klasse initialisiert die Startwerte der Attribute.
	 */
	public CipherModel() {
		this.etext = "";
		this.dtext = "";
		this.alphabet = "";
		this.keyWord = "";
		this.Ver = 0;
		this.lev = 0;
	}
	
	/*
	 * Getter-Methode f�r das etext-Attribut
	 * @return String etext vom Benutzer eingegebener Text
	 */
	public String getEtext() {
		return etext;
	}
	/*
	 * Setter-Methode f�r das etext-Attribut
	 * @param String etext eingegebener Text
	 */
	public void setEtext(String etext) {
		this.etext = etext;
	}
	
	/*
	 * Getter-Methode f�r das dtext-Attribut
	 * @return String dtext vom Benutzer eingegebener Text
	 */
	public String getDtext() {
		return dtext;
	}
	/*
	 * Setter-Methode f�r das dtext-Attribut
	 * @param String dtext eingegebener Text
	 */
	public void setDtext(String dtext) {
		this.dtext = dtext;
	}
	
	/*
	 * Getter-Methode f�r das alphabet-Attribut
	 * @return String alphabet eingegebenes Alphabet
	 */
	public String getAlphabet() {
		return alphabet;
	}
	/*
	 * Setter-Methode f�r das alphabet-Attribut
	 * @param String alphabet eingegebenes Alphabet
	 */
	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	/*
	 * Getter-Methode f�r das Ver-Attribut
	 * @return int ver eingegebenes Verschiebelevel
	 */
	public int getVer() {
		return Ver;
	}
	/*
	 * Setter-Methode f�r das ver-Attribut
	 * @param int ver eingegebenes Verschiebelevel
	 */
	public void setVer(int ver) {
		Ver = ver;
	}
	
	/*
	 * Getter-Methode f�r das etext-Attribut
	 * @return String keyWord Schl�sselwort
	 */
	public String getKeyWord() {
		return this.keyWord;
	}
	/*
	 * Setter-Methode f�r das KeyWord-Attribut
	 * @param String KeyWord eingegebenes Keyword
	 */
	public void setKeyword(String KeyWord) {
		this.keyWord = KeyWord;
	}
	
	/*
	 * Diese Methode resetet alle Attributwerte
	 */
	public void refresh() {
		this.etext = "";
		this.dtext = "";
		this.alphabet = "";
		this.keyWord = "";
		this.Ver = 0;
		this.lev = 0;
	}
	
	/*
	 * Getter-Methode f�r das lev-Attribut
	 * @return int lev eingegebenes Transpositionslevel
	 */
	public int getLev() {
		return this.lev;
	}
	/*
	 * Setter-Methode f�r das lev-Attribut
	 * @param String lev eingegebenes Transpositionslevel
	 */
	public void setLev(int lev) {
		this.lev = lev;
	}
}
