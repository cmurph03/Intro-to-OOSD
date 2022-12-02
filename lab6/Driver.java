import java.io.IOException;

public class Driver
{
    public static void main(String[] args)
    {  
 	try 
	{
            Plot2D p = new Plot2D();
            Random2D f = new Random2D(-3, 3);
            p.plot(f);
            p.saveImage("random.png");
	}
	catch (IOException e)
	{
	   System.out.println("Could not save image"); 
	}

    }  
}
