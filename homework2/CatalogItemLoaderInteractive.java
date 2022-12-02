import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


public class CatalogItemLoaderInteractive extends CatalogItemLoader
 {
    private ArrayList<CatalogItem> catalogItems;
    private CatalogItem newItem;
    private String title;
    private String firstName;
    private String lastName;
    private String id;
    private String available;
    private boolean availability;
    private String userInput;
	
    public CatalogItemLoaderInteractive()
    {
	super();
	catalogItems = new ArrayList<CatalogItem>();
    }
		
    public ArrayList<CatalogItem> getBooks()
    {
	return super.getBooks();
    }
	
    public ArrayList<CatalogItem> loadItems()
    {
	Scanner input = new Scanner(System.in);
				
	boolean done = false;
	try
	{
    	    while (!done)
	    {
		System.out.println("A - add book ");
		System.out.println("D - done ");
		userInput = input.nextLine();
					
		if (userInput.equals("A"))
		{					
		    newItem = promptUser();
		    catalogItems.add(newItem);														
		}
		else if (userInput.equals("D"))
		{
		    done = true;
		}
	    }
	    input.close();
	    
	    return catalogItems;
	}
	catch (InputMismatchException e)
	{
	    System.err.println("Error when loading items");
	}
	return null;
    }
	
    //Separate method for call and response to create the catalog item
    public CatalogItem promptUser()
    {
	Scanner input = new Scanner(System.in);
	try
	{					
	    //get information  from user
	    System.out.println("Enter title: ");
	    title = input.nextLine();
			
	    System.out.println("Enter author's first name: ");
	    firstName = input.nextLine();
			
	    System.out.println("Enter author's last name: ");
	    lastName = input.nextLine();
			
	    System.out.println("Enter library catalog id: ");
	    id = input.nextLine();
			
	    System.out.println("Is the book available? Y/N ");
	    available = input.nextLine();
					
	    //create Book object, create CatalogItem
	    Book book = new Book(title, firstName, lastName);
	
	    if (available == "Y")
	    {
		availability = true;
	    }
	    else
	    {
		availability = false;
	    }
			

	    CatalogItem item = new CatalogItem(book, id, availability);
			
	    return item;
	}
	catch (InputMismatchException e)
	{
	    System.err.println("Error inputing data");
	}
	return null;
    }
}

