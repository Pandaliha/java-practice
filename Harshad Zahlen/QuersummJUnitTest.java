import junit.framework.TestCase;

public class QuersummJUnitTest extends TestCase{
	 public void testGetQuersumm1() {
		 Quersumm quersumm = new Quersumm(0);;
	    	assertEquals(0, quersumm.getQuersumm());
	    }
	 public void testGetQuersumm2() {
		 Quersumm quersumm = new Quersumm(100);;
	    	assertEquals(1, quersumm.getQuersumm());
	    }
	 public void testGetQuersumm3() {
		 Quersumm quersumm = new Quersumm(333);;
	    	assertEquals(9, quersumm.getQuersumm());
	    }
	 public void testGetQuersumm4() {
		 Quersumm quersumm = new Quersumm(7);;
	    	assertEquals(7, quersumm.getQuersumm());
	    }
	 public void testGetQuersumm5() {
		 Quersumm quersumm = new Quersumm(96837651);;
	    	assertEquals(45, quersumm.getQuersumm());
	    }
}