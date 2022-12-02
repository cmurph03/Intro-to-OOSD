import java.util.*;

public class Polynomial implements Function2D
{
     private double[] coeff;
     private int[] exponents;

     public Polynomial(double[] coefficients, int[] exponents)
     {
	this.coeff = coefficients;
	this.exponents = exponents;
     }

     public double getCoefficient(int degree)
     {
	
	for(int i = 0; i<this.exponents.length; i++)
	{
	     if (exponents[i] == degree)
	     {
		return this.coeff[i];
	
	     }
	}
	return 0;
     }

     public int getMaxDegree()
     {     
	/* 
	 * need to account for if the the exponents are listed from
	 * smallest to largest or the reverse, are out or order
	 * or have a 0 coefficient. Thus the comparison and stepping
	 * through the list
	 */
	int degree=0;

	for (int i=0; i<exponents.length; i++)
	{
	    if(exponents[i] > degree && coeff[i] !=0)
		    degree = exponents[i];
	}
	return degree;
     }
     
     public double eval(double x)
     {
	double sum = 0;
	for (int i = 0; i<this.exponents.length; i++)
	{
	    sum += this.coeff[i]*Math.pow(x,this.exponents[i]);
	}
	return sum;
     }
}
