

public abstract class Converter 
{
    protected double from;
    protected double to;
    
    public void setFrom(double from)
    {
        this.from = from;
    }
    public double getConversionResult()
    {
        return to;
    }
	
    public abstract void convert();	
}

