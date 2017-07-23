public class Quersumme {

	public static void main(String[] args) {
		long i = 14632;

		if (i >= 0) {
			System.out.println(quersumme(i));

		} else {
			System.out.print("Bitte positive Zahl angeben!");
		}       
	}

	/**
	 * Durch die Modulo Rechnung wird immer die letzte Ziffer der Zahl
	 * abgetrennt und zu quersumm addiert. Dies wird so lange gemacht, 
	 * bis i = 0 und quersumm die Addition aller Ziffern von i ist.
	 * 
	 * @param i
	 * @return quersumm
	 */
	public static long quersumme(long i) {
		long quersumme = 0;
		while (i > 0) {
			quersumme = quersumme + (i % 10);
			i = i / 10;
		}
		return quersumme;
	}

}