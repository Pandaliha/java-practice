public class Binaersuche {

	// Attribute
	int[] feld; // speichert das zu durchsuchende Array
	int l; // linke Grenze des Suchbereichs
	int r; // rechte Grenze des Suchbereichs
	int m; // Mitte
	int s; // das zu suchende Element

	// Konstruktor
	public Binaersuche(int[] feld) {

		this.feld = feld;
		s = l = r = m = 0;

	}


	public int sucheIterativ(int s) {

		// Array null oder leer?
		if (feld == null || feld.length == 0)
			return -1; // Fehlerwert zurückgeben

		// Variablen initialisieren
		l = 0;
		r = feld.length - 1;
		this.s = s;

		while (l <= r) {

			m = (r + l) / 2;
			print();

			if (s < feld[m])
				r = m - 1;
			else if (s > feld[m])
				l = m + 1;
			else
				return m;

		}

		return -1;

	}

	// gibt den aktuellen Status der Suche auf
	// der Konsole aus
	public void print() {

		// gibt zuerst den Inhalt des Arrays aus
		for (int i = 0; i < feld.length; i++)
			System.out.print(feld[i] + " ");

		System.out.println();

		// zeigt die Positionen der einzelnen "Zeiger"
		// innerhalb des Arrays an
		for (int i = 0; i < feld.length; i++) {

			if (i == m)
				System.out.print("m");
			else if (i == l)
				System.out.print("l");
			else if (i == r)
				System.out.print("r");
			else
				System.out.print(" ");

			System.out.print(" ");

		}

		// zusätzliche Leerzeilen ausgeben
		System.out.println('\n');

	}

	public static void main(String[] args) {

		int[] a = {2, 7, 11, 12, 13, 123, 231, 247, 274, 303, 307, 370};

		Binaersuche b = new Binaersuche(a);

		int w = b.sucheIterativ(2);

		System.out.println(w);

	}
}