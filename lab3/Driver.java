/* Java program to read a file name from the command line
 * and output the data in the file line by line */

import java. io.*;
public class Driver
{
     public static void main(String []args)throws Exception
     {
	int numArgs = args.length;

	if (numArgs>0)
	{
	    File inputFile = new File(args[0]);

	    BufferedReader reader = new BufferedReader(new FileReader(inputFile));

	    String currentLine;
	    while ((currentLine = reader.readLine()) != null)
		    System.out.println(currentLine);
	}
	else 
	{
	    System.out.println("No command line arguments.");
	}
     }
}
