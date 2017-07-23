import junit.framework.TestCase;


public class BinaersucheJUnitTest extends TestCase {
	public void testSucheIterativ1() {
		int[] a = {2, 7, 11, 12, 13, 123, 231, 247, 274, 303, 307, 370};
		Binaersuche b = new Binaersuche(a);
		//int w = b.sucheIterativ(2);
		assertEquals(0, b.sucheIterativ(2));

	}
	public void testSucheIterativ2() {
		int[] a = {99, 999, 9999, 99999, 999999, 9999999};
		Binaersuche b = new Binaersuche(a);
		//int w = b.sucheIterativ(999);
		assertEquals(1, b.sucheIterativ(999));

	}

}
