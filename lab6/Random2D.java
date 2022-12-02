import java.util.Random;
public class Random2D implements Function2D
{
   private double min;
   private double max;
   Random randomGenerator;   
   public Random2D(double min, double max)
   {
      randomGenerator = new Random();
      this.min = min;
      this.max = max;
   }

   public double eval(double x)
   {
	boolean scale = randomGenerator.nextBoolean();
	double factor = randomGenerator.nextDouble();

	if (scale)
	{
	     return this.max*factor;
	}
	else
	{
	     return this.min*factor;
	}
   }

}
