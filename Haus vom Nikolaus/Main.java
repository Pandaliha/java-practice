public class Main {
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
