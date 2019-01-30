package ex09;

/**
 * Interface representing a polynomial with arbitrary grade
 * @author Nicola Bicocchi
 *
 */
public interface Poly { 
     
    /**
     * Returns the degree of the polynomial
     * @return
     */
    public int degree(); 

    /** 
     *  Returns an new polynomial which is the derivative of the current object
     *  More specifically, the call invoked on object (1), returns object (2)
     *  (1) c0 + c_1 * x + c_2 * x^2 + ... + c_n * x^n 
     *  (2) c1 + 2c_2 * x + ... + nc_n * x^(n-1)
     * @return
     */
    public Poly derivative();
    

    /**
     * True if p equals the current object
     * @param p
     * @return
     */
    public boolean equals(Poly p);


    /** 
     * Returns the coefficient of the monomial with the specified degree 
     * @param degree
     * @return
     */
    double coefficient(int degree);
}

