public class HarshadZahl {
	public static void main(String[] args) {
		/*
		 * 
		 * Für die Zahlen zwischen 1 und 100 wird geprüft, ob sie die
		 * Eigenschaften einer Harshad Zahl besitzen.
		 */
		for (long i = 1; i <= 100; i++) {
			if (harshad(i)) {
				System.out.println(i);
			}
		}
	}

	/**
	 * i wird durch die bereits errechnete Quersumme dividiert. Der boolsche
	 * Ausdruck wird nur dann wahr, wenn dabei der Rest 0 bleibt.
	 * 
	 * @param i
	 * @return istHarshad
	 */
	public static boolean harshad(long i) {
		boolean istHarshad = (i % Quersumme.quersumme(i) == 0);
		return istHarshad;
	}
}
