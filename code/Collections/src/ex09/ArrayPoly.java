package ex09;

/**
 * Class representing a polynomial with coefficients stored as on array of doubles
 * @author Nicola Bicocchi
 *
 */
public class ArrayPoly extends AbstractPoly implements Poly { 

	private double[] coeffs; 
    
	public ArrayPoly(double[] coeffs) { 
		if (coeffs == null || coeffs.length == 0) {
			return;
		}

		this.coeffs = new double[coeffs.length];
		for (int i = 0; i < coeffs.length; i++) 
			this.coeffs[i] = coeffs[i];
	}

	@Override
	public int degree() { 
		return coeffs.length - 1;
	}

	@Override
	public Poly derivative() { 
		double[] cs = new double[Math.max(1,coeffs.length - 1)];

		for (int i = 1; i < coeffs.length; i++) 
			cs[i-1] = i * coeffs[i];

		return new ArrayPoly(cs);
	}

	@Override
	public double coefficient(int degree) { 
		if (degree > degree() || degree < 0) return 0.0;
		else return coeffs[degree];
	}

}
