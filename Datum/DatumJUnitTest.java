/*
 * Nach Kopieren dieser Klasse in das Verzeichnis, wo
 * die Implementierung der Datumsklasse vorhanden ist,
 * müssen noch wie folgt die Klassen des JUnit
 * Testframeworks zum Projekt hinzugefügt werden:
 * In dieser Klasse Linksklick links von fehlerhafter Zeile
 * und entsprechende auswählbare Aktion zum Hinzufügen
 * der JUnit Testklassen auswählen.
 * 
 * Zum Ausführen der Tests dieser Klasse:
 * Klasse in Package Explorer anwählen, Rechtsklick und
 * Run -> JUnit Test auswählen.
 * 
 * Es kann noch sein, dass dieser Klasse noch die Packagedeklaration
 * haben muss, die ihre Klasse Datum hat.
 *
 * Wenn keine Fehler auftreten passiert nichts.
 * Falls noch Fehler auftreten wechselt Eclipse
 * automatisch in die JUnit Sicht.
 */


import junit.framework.TestCase;

/**
 * JUnit Testklasse für Klasse Datum (objekt-orientierte Version).
 * Es werden alle öffentlichen Methoden und Konstruktoren überprüft (bis auf toString()).
 * Leider sind alle Methoden unkommentiert. Sie sind allerdings
 * allessamt sehr einfach.
 */
public class DatumJUnitTest extends TestCase {

    public void testKonstruktor() {
       Datum datum = new Datum(1, 1, 2000);
       
       assertTrue(datum != null);
    }
    
    public void testIsSchaltjahr1() {
       Datum datum = new Datum(1, 1, 2000);
       
       assertTrue(datum.isSchaltjahr());
    }
    
    public void testIsSchaltjahr2() {
      Datum datum = new Datum(1, 1, 2001);
      
      assertTrue(! datum.isSchaltjahr());
    }

    public void testIsSchaltjahr3() {
      Datum datum = new Datum(1, 1, 500);
      
      assertTrue(! datum.isSchaltjahr());
    }

    public void testIsKorrekt1() {
      Datum datum = new Datum(15, 12, 2001);
      
      assertTrue(datum.isKorrekt());
    }
    
    public void testIsKorrekt2() {
      Datum datum = new Datum(-1, 12, 2001);
      
      assertTrue(! datum.isKorrekt());
    }
    
    public void testIsKorrekt3() {
      Datum datum = new Datum(15, 12, -999);
      
      assertTrue(! datum.isKorrekt());
    }
    
    public void testIsKorrekt4() {
      Datum datum = new Datum(15, 99, 2001);
      
      assertTrue(! datum.isKorrekt());
    }
    
    public void testIsKorrekt5() {
      Datum datum = new Datum(29, 2, 2000);
      
      assertTrue(datum.isKorrekt());
    }

    public void testIsKorrekt6() {
      Datum datum = new Datum(15, 12, 1996);
      
      assertTrue(datum.isKorrekt());
    }

    public void testGetTag1() {
      Datum datum = new Datum(15, 12, 1996);
      
      assertEquals(15, datum.getTag());
    }

    public void testGetTag2() {
      Datum datum = new Datum(15, 12, -1996);
      
      assertEquals(-1,  datum.getTag());
    }
    
    public void testGetMonat1() {
      Datum datum = new Datum(15, 12, 1996);
      
      assertEquals(12, datum.getMonat());
    }

    public void testGetMonat2() {
      Datum datum = new Datum(31, 4, 2001);
      
      assertEquals(4,  datum.getMonat());
    }

    public void testGetJahr1() {
      Datum datum = new Datum(15, 12, 1996);
      
      assertEquals(1996, datum.getJahr());
    }

    public void testGetJahr2() {
      Datum datum = new Datum(15, 13, 1996);
      
      assertEquals(-1,  datum.getJahr());
    }
    public void testToString1() {
    	Datum datum = new Datum(01, 1, 2000);
    	assertEquals("1. Januar 2000 / Schaltjahr", datum.toString());
    }
    public void testToString2() {
    	Datum datum = new Datum(05, 8, 1999);
    	assertEquals("5. August 1999 / kein Schaltjahr", datum.toString());
    }
}
