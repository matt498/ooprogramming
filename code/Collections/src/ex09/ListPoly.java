package ex09;
import java.util.ArrayList;

class Monomio {
	double coeff;
	int exp;

	public Monomio(double d, int i) {
		coeff = d;   exp = i;
	}
}

/**
 * Class representing a polynomial with coefficients stored as a list of monomial.
 * @author Nicola Bicocchi
 *
 */
public class ListPoly extends AbstractPoly implements Poly {

	private ArrayList<Monomio> coeffs;

	public ListPoly(double[] coeffs) {
		if (coeffs == null || coeffs.length == 0) {
			return;
		}

		this.coeffs = new ArrayList<Monomio>();
		for (int i = 0; i < coeffs.length; i++)
			if (coeffs[i] != 0.0) this.coeffs.add(new Monomio(coeffs[i], i));
	}
	
	public ListPoly(ArrayList<Monomio> coeffs) {
		this.coeffs = coeffs;
	}

	@Override
	public int degree() {
		return coeffs.size() - 1;
	}

	@Override
	public Poly derivative() {
		ArrayList<Monomio> ts = new ArrayList<Monomio>();
		if (coeffs.size() == 0) 
			return new ListPoly(ts);

		for (Monomio m : coeffs) {
			if (m.exp > 0) 
				ts.add(new Monomio(m.coeff * m.exp, m.exp - 1));    
		}
		return new ListPoly(ts);
	}

	@Override
	public double coefficient(int degree) { 
		if (degree > degree() || degree < 0) return 0.0;

		for (Monomio m : coeffs) 
			if (m.exp == degree) 
				return m.coeff;
		return 0.0;
	}

}
