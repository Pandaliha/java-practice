
public class Datum {
	private int tag;
	private int monat;
	private int jahr;
	
	Datum(int tag, int monat, int jahr){
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
		
	}
	
	
	public boolean isKorrekt() {
		boolean b = (tag >= 1 && tag <= 31) && (monat >= 1 && monat <= 12)
				&& (jahr > 0);
		return b;
	}
		//Methoden getTag getMonat getJahr geben Datum zurück
		public int getTag() {
			if (isKorrekt() == true) {
				return tag;
			} else{
				return -1;
			}
		}
		public int getMonat() {
			if (isKorrekt() == true) {
				return monat;
			} else{
				return -1;
		}
	} 
		public int getJahr() {
			if (isKorrekt() == true) {
				return jahr;
			} else{
				return -1;
			}
		}
		//Methode isSchaltjahr gibt true falls jahr Schaltjahr ist
		public boolean isSchaltjahr() {
			int jahr = this.jahr;
			boolean variableSchaltjahr;
		    if ((jahr % 4 == 0) && ((jahr % 100 != 0) 
                    || (jahr % 400 == 0))){
		    	variableSchaltjahr = true;
		    } else {
		    	variableSchaltjahr = false;
		    }
		    return variableSchaltjahr;
		}
		//Methode toString gibt Datum lesbar zurück
		public String toString(){
			int tag = this.tag;
			int monat = this.monat;
			int jahr = this.jahr;
			String schaltjahrString = "";
			String monatString = "default";
			switch (monat){
			case 1: monatString = "Januar";
			break;
			case 2: monatString = "Februar";
			break;
			case 3: monatString = "März";
			break;
			case 4: monatString = "April";
			break;
			case 5: monatString = "Mai";
			break;
			case 6: monatString = "Juni";
			break;
			case 7: monatString = "Juli";
			break;
			case 8: monatString = "August";
			break;
			case 9: monatString = "September";
			break;
			case 10: monatString =" Oktober";
			break;
			case 11: monatString = "November";
			break;
			case 12: monatString = "Dezember";
			break;
			}
			if (isSchaltjahr() == true){
				schaltjahrString = "Schaltjahr";
			} else {
				schaltjahrString = "kein Schaltjahr";
			}
			String datumIsKorrekt = tag + ". " + monatString + " " + jahr + " / " 
			                        + schaltjahrString;
			String datumIsFalse = "ungültiges Datum";
			if (isKorrekt() == true){
				return datumIsKorrekt;
			} else {
				return datumIsFalse;
			}
		}
		

}
