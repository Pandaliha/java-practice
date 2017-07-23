public class Quersumm {
	private int zahl;
	
	Quersumm(int zahl) {
		this.zahl = zahl;
	}
	
	public int getQuersumm() {
		int zahl = this.zahl;
		int quersumme = 0;
		if (zahl <= 0){
			zahl = zahl * (-1);
			while (zahl > 0) {
				quersumme = quersumme + (zahl % 10);
				zahl = zahl / 10;
			}
		} else {
		while (zahl > 0) {
			quersumme = quersumme + (zahl % 10);
			zahl = zahl / 10;
		}
		}
		return quersumme;
	}
	public boolean isKorrekt() {
		boolean b = (zahl >= 0);
		return b;
	}
}
