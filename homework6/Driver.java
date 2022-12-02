import javax.swing.*;
import java.io.IOException;

public class Driver
{
     public static void main(String[] args)
     {
	Random2D r = new Random2D (-6, 0);
	Constant2D c = new Constant2D(5);
	double []coeff = {1};
	int []exponent = {2};
	Polynomial p = new Polynomial(coeff, exponent);
	Plot2D myPlot = new Plot2D();
	myPlot.plot(p);
	myPlot.plot(c);
	myPlot.plot(r);

	try
	{
	     myPlot.saveImage("Homework 6");
	}
	catch (IOException e)
	{
	    System.out.println("Error occured when saving image");
	}

	myPlot.close();
     }
     
}
