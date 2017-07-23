public class Datummm {
	public static void main(String[] args) {
		int tag = 19;
		int monat = 11;
		int jahr = 2014;

		if (Datummm.isKorrekt(tag, monat, jahr) & Datummm.isSchaltjahr(jahr)) {
			System.out.println(tag + ". " + Datummm.toString(monat) + " " + jahr
					+ "/ Schaltjahr");
		} else if (Datummm.isKorrekt(tag, monat, jahr)
				& !(Datummm.isSchaltjahr(jahr))) {
			System.out.println(tag + ". " + Datummm.toString(monat) + " " + jahr
					+ "/ kein Schaltjahr");
		} else {
			System.out.println(Datummm.getTag(tag, monat, jahr) + "."
					+ Datummm.getMonat(tag, monat, jahr) + "."
					+ Datummm.getJahr(tag, monat, jahr) + " / ungültiges Datum");
		}

	}
	public static boolean isSchaltjahr(int jahr) {
		boolean a = ((jahr % 4 == 0) && ((jahr % 100 != 0) 
				                          || (jahr % 400 == 0)));
		return a;
	}

	public static boolean isKorrekt(int tag, int monat, int jahr) {
		boolean b = (tag >= 1 && tag <= 31) && (monat >= 1 && monat <= 12)
				&& (jahr > 0);
		return b;
	}

	public static String toString(int monat) {
		if (monat == 1)
			return "Januar";
		else if (monat == 2)
			return "Februar";
		else if (monat == 3)
			return "Maerz";
		else if (monat == 4)
			return "April";
		else if (monat == 5)
			return "Mai";
		else if (monat == 6)
			return "Juni";
		else if (monat == 7)
			return "Juli";
		else if (monat == 8)
			return "August";
		else if (monat == 9)
			return "September";
		else if (monat == 10)
			return "Oktober";
		else if (monat == 11)
			return "November";
		else if (monat == 12)
			return "Dezember";

		return "";

	}

	public static int getTag(int tag, int monat, int jahr) {
		if (isKorrekt(tag, monat, jahr)) {
			return tag;
		} else
			return -1;
	}

	public static int getMonat(int tag, int monat, int jahr) {
		if (isKorrekt(tag, monat, jahr)) {
			return monat;
		} else
			return -1;
	}

	public static int getJahr(int tag, int monat, int jahr) {
		if (isKorrekt(tag, monat, jahr)) {
			return jahr;
		} else
			return -1;
	}
}
