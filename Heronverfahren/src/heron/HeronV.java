package heron;

public class HeronV {

	public void main(String[] args) {
		
		System.out.println(calculateRoot (2, 2));
		
	}
	
	double calculateRoot (int k, double x) {
		double prec = Math.pow(1, -10);
		double root = x / 2;
		double previousRoot = 0;
		
		while (Math.abs(root-previousRoot) <= prec) {
		previousRoot = root;
		root = ((k-1) * Math.pow(previousRoot, k) + x) / k * Math.pow(previousRoot, k-1);
		}
		return root;
	}

}
