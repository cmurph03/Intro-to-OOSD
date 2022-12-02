import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class PolynomialTest
{
     @Test
     public void testGetCoefficient()
     {
	double [] coeff = {3.5,4};
	int [] exp = {1,2};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getCoefficient does not work", 3.5, test.getCoefficient(1), 0);
     }

     @Test
     public void testGetMaxDegree()
     {
	double [] coeff = {3.5,4,2};
	int [] exp = {1,8,55};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getMaxDegree does not work", 55, test.getMaxDegree());
     }

     @Test
     public void testMaxDegreeWith0Coeff()
     {
	double [] coeff = {3.5,4,0};
	int [] exp = {1,8,55};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getMaxDegree does not work with 0 Coeff", 8, test.getMaxDegree());
     }

     @Test
     public void testGetCoefficientWithoutOrder()
     {
        double [] coeff = {3.5,4,0};
	int [] exp = {5, 2, 8};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getCoefficient does not work without order", 4, test.getCoefficient(2),0);
     }

     @Test
     public void testMaxDegreeWitoutOrder()
     {
        double [] coeff = {3.5,4,0};
	int [] exp = {5, 2, 8};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getMaxDegree does not work without order", 5, test.getMaxDegree());
     }

     @Test
     public void testEval()
     {
	double [] coeff = {3.5,4,0};
	int [] exp = {2, 5, 8};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("Eval does not work", 142, test.eval(2),0);
     }
   
     @Test
     public void testGetCoefficientWhen0()
     {
	double [] coeff = {3.5,4,0};
	int [] exp = {2, 5, 8};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getCoefficient does not work when 0", 0, test.getCoefficient(8),0);
     }

     @Test
     public void testEvalWithoutOrder()
     {
	double [] coeff = {3.5,4,1};
	int [] exp = {2, 8, 5};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("Eval does not work without order", 263224, test.eval(4),0);
     }

     @Test
     public void testMaxDegreeWithNegative()
     {
	double [] coeff = {3.5,4,1};
	int [] exp = {5, 2, -8};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getMaxDegree does not work negative", 5, test.getMaxDegree());
     }

     @Test
     public void testGetCoefficientWithNegative()
     {	
     	double [] coeff = {-3.5,4,1};
	int [] exp = {2, 8, 5};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("getCoefficient does not work with negative", -3.5, test.getCoefficient(2),0);
     }


     @Test
     public void testEvalWithNegativeExp()
     {
	double [] coeff = {3.5,4,1};
	int [] exp = {2, 1, -2};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("Eval does not work with negative exponent", 72.0625, test.eval(4),0);
     }

     @Test
     public void testEvalWithNegCoeff()
     {
	double [] coeff = {3.5,-4,1};
	int [] exp = {2, 1, 5};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("Eval does not work with negative coeff", 1064, test.eval(4),0);
     }

     @Test
     public void testEvalWithBothNeg()
     {	
     	double [] coeff = {3.5,4,-1};
	int [] exp = {2, 1, -2};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("Eval does not work with two negatives", 71.9375, test.eval(4),0);
     }

     @Test
     public void testEvalWithNegInput()
     {
     	double [] coeff = {3.5,4,-1};
	int [] exp = {3, -1, 2};
	Polynomial test = new Polynomial(coeff, exp);
	assertEquals("Eval does not work with a negative input", -241, test.eval(-4),0);
     }


}
