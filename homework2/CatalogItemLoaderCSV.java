import java.util.ArrayList;
import java.io.*;

public class CatalogItemLoaderCSV extends CatalogItemLoader
{
    private File inputFile;
    //private ArrayList<CatalogItem> catalogItems;
    private String title;
    private String firstName;
    private String lastName;
    private String id;
    private String available;
    private boolean availability;
	
	
    //constructor
    public CatalogItemLoaderCSV(String fileName)
    {
	super();
	this.inputFile = new File(fileName);
    }

    public ArrayList<CatalogItem> getBooks()
    {
        return super.getBooks();
    }
    
    //read the given file line by line and add to an array list
    public ArrayList<CatalogItem> loadItems()
    {
	try 
	{
  	    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	    
	    String currentLine;
	    try
	    {
		while ((currentLine = reader.readLine()) != null)
		{
		     String[] currentLineArray = currentLine.split(",");

		     if(currentLineArray.length == 5)
		     {
			title = currentLineArray[0];
			firstName = currentLineArray[1];
			lastName = currentLineArray[2];
			id = currentLineArray[3];
			available = currentLineArray[4];
					
			if (available == "1")
			{
			    availability = true;   
			}
			else
			{
			    availability = false;
			}
			Book book = new Book (title, firstName, lastName);
			CatalogItem item = new CatalogItem(book, id, availability);
			catalogItems.add(item);
			 }
		}
	    }
	    catch (IOException e)
	    {
		System.out.println("Error reading file");
	    }
	}
	catch (FileNotFoundException e)
	{
	    System.out.println("File not found");
	}
	return catalogItems;
    }

}

