
public class FahrenheitToCelsius extends Converter
{
    //private double from;
    //private double to;
    
    public FahrenheitToCelsius()
    {
        super();
    }
    public void setFrom(double from)
    {
        super.setFrom(from);
    }
    public void convert()
    {
        to = (from - 32) * 5d/9d;
    }
    public double getConversionResult()
    {
        return super.getConversionResult();
    }
}

