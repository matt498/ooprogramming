package ex09;

/**
 * Develop two classes, namely ArrayPoly and ListPoly, for managing polynomials.
 * More specifically, the two classes must exhibit the same functionalities
 * but using internally different mechanisms. Please refer to Interface Poly 
 * for a description of required functionalities.
 * 
 * ArrayPoly stores a polynomial using an array of doubles for storing the coefficients (c0..c_n).
 * c0 + c_1 * x + c_2 * x^2 + ... + c_n * x^n
 * 
 * ListPoly stores a monomial using a List of objects.
 * 
 * The two classes must work with the main method provided below.
 *   
 * @author Nicola Bicocchi
 *
 */
public class TestApp { 
    public static void main(String[] args) { 
    
    Poly ap = new ArrayPoly(new double[]{1,3,4});
    Poly lp = new ListPoly(new double[]{1,3,6,8});

    System.out.println("ap = " + ap.toString());
    System.out.println("lp = " + lp.toString());

    if (ap.equals(lp) && lp.equals(ap)) 
        System.out.println("ap == lp");
    else 
        System.out.println("ap != lp");

    ap = ap.derivative(); 
    System.out.println("ap' = " + ap.toString());

    ap = ap.derivative(); 
    System.out.println("ap'' = " + ap.toString());

    lp = lp.derivative(); 
    System.out.println("lp' = " + lp.toString());

    lp = lp.derivative(); 
    System.out.println("lp'' = " + lp.toString());

    }
}
