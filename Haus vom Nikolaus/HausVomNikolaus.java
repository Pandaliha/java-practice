public class HausVomNikolaus {

	private static final int KEINE_KANTE = 0;
	private static final int KANTE = 1;
	private static final int KANTE_GEZEICHNET = 2;
	private int position = 0;

	private int haus[][] = { { 0, KANTE, KANTE, KANTE, 0 },
			{ KANTE, 0, KANTE, KANTE, 0 }, { KANTE, KANTE, 0, KANTE, KANTE },
			{ KANTE, KANTE, KANTE, 0, KANTE }, { 0, 0, KANTE, KANTE, 0 } };

	private static final int DEFAULT[][] = { { 0, KANTE, KANTE, KANTE, 0 },
			{ KANTE, 0, KANTE, KANTE, 0 }, { KANTE, KANTE, 0, KANTE, KANTE },
			{ KANTE, KANTE, KANTE, 0, KANTE }, { 0, 0, KANTE, KANTE, 0 } };

	private void reset() {
		haus = DEFAULT;
		this.loesung = new int[8];
	}

	private int loesung[] = new int[8]; // ggf. 9 statt 8

	// weitere Eigenschaften, Methoden

	/**
	 * Markiert eine Kante als Gezeichnet
	 * 
	 * @param x
	 * @param y
	 */
	private void streicheWeg(int x, int y) {
		haus[x][y] = KANTE_GEZEICHNET;
		haus[y][x] = KANTE_GEZEICHNET;
	}

	/**
	 * Gibt eine Kante wieder frei
	 * 
	 * @param x
	 * @param y
	 */
	private void schrittRueckgaengig(int x, int y) {
		haus[x][y] = KANTE;
		haus[y][x] = KANTE;
	}

	public int sucheAnfang() {
		int i = (int) (Math.random() * 10) % 5;
		return i;
	}

	/**
	 * Prüft ob ein gültiger Schritt vorliegt
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean gueltigerSchritt(int x, int y) {
		if (haus[x][y] == KANTE) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hatWeitereStartwerte() {
		return (position < DEFAULT.length);

	}

	/**
	 * Sucht eine Rekursive Lösung für das Haus vom Nikolaus im Backtracking
	 * verfahren (Rekursiv)
	 * 
	 * @param alt
	 * @param zaehler
	 * @return true wenn lösung gefunden
	 */
	private boolean sucheLoesung(int alt, int zaehler) {
		for (int i = 0; i < haus.length; i++) {
			int neu = i;
			if (gueltigerSchritt(alt, neu)) {
				loesung[zaehler] = neu;
				streicheWeg(alt, i);
				if (zaehler < loesung.length - 1) {
					if (sucheLoesung(neu, zaehler + 1)) {
						return true;
					} else {
						loesung[zaehler] = 0;
						schrittRueckgaengig(alt, i);
					}
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public int[] sucheLoesung() {
		int[] ret = null;

		if (this.sucheLoesung(position++, 0)) {
			ret = (int[]) loesung.clone();

		}
		reset();
		return ret;
	}

	public static void main(String argsv[]) {
		HausVomNikolaus haus = new HausVomNikolaus();
		while (haus.hatWeitereStartwerte()) {
			int[] loesung = haus.sucheLoesung();
			if (loesung != null) {
				for (int j = 0; j < loesung.length; j++) {
					System.out.print(loesung[j] + " ");

				}
				System.out.println();
			}
		}
		/*
		 * boolean t = haus.sucheLoesung(haus.sucheAnfang(), 0); if (t) {
		 * System.out.println("Haus = " + t); for (int j = 0; j <
		 * haus.loesung.length; j++) { System.out.print(haus.loesung[j] + " ");
		 * haus.reset();
		 * 
		 * } }
		 */
	}

}
