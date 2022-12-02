import java.util.ArrayList;

public class Catalog {
	private ArrayList<CatalogItem> catalog;
	
	public Catalog()
	{
		this.catalog = new ArrayList<CatalogItem>();
	}
	public void add(Book book)
	{
		int idNum = catalog.size(); //determines the unique id for the new book using the size of the array
		String id = Integer.toString(idNum);
		boolean availability = true;
		
		CatalogItem item = new CatalogItem(book, id, availability);
		catalog.add(item);
	}
	
	public boolean checkout(String id)
	{
		int idNum = Integer.parseInt(id);  //convert the id back to an int
		
		if (idNum < catalog.size())   //make sure book is in the catalog
		{
			CatalogItem item = catalog.get(idNum); //call the specific catalog item
			
			if (item.isAvailable() == true)  //check out the book if it's available
			{								
				item.setUnavailable();
				return true;
			}
			else      //book unavailable so return false
			{
				return false;
			}
		}
		return false;		
	}
	
	public boolean checkin(String id)
	{
		int idNum = Integer.parseInt(id);  //convert the id back to an int
		
		if (idNum < catalog.size())   //make sure book is in the catalog
		{
			CatalogItem item = catalog.get(idNum); //call the specific catalog item
			
			if (item.isAvailable() == false)  //check in the book if it's already checked out
			{								
				item.setAvailable();
				return true;
			}
			else      //book is available/already checked in so return false
			{
				return false;
			}
		}
		return false;
	}
	
	public ArrayList<String> search(String searchTerm)
	{
		ArrayList<String> results = new ArrayList<String>(); //create the list for all the matching ids
		
		for (CatalogItem i : catalog) //loop through the catalog to find matching results
		{
			String id = i.getId(); //find the id for the current item
			Book book = i.getBook(); //book associated with current catalog item
			String title = book.getTitle();
			String firstName = book.getAuthorFirstName();
			String lastName = book.getAuthorLastName();
			
			if (title.equals(searchTerm))
			{
				results.add(id);
			}
			else if (firstName.equals(searchTerm))
			{
				results.add(id);
			}
			else if (lastName.equals(searchTerm))
			{
				results.add(id);
			}
		}
		return results;
	}
	
	public Book getBook(String id)
	{
		int idNum = Integer.parseInt(id);  //convert the id back to an int
		
		if (idNum < catalog.size())   //make sure book is in the catalog
		{
			CatalogItem item = catalog.get(idNum);
			return item.getBook();
		}
		else
		{ 
			return null;
		}		
	}
	
	public boolean remove(String id)
	{
		int idNum = Integer.parseInt(id);  //convert the id back to an int
		
		if (idNum < catalog.size())   //make sure book is in the catalog
		{
			CatalogItem item = catalog.get(idNum); //pull the specific catalog item
			if (item.isAvailable() == true)  //make sure book is available
			{
				catalog.remove(idNum);   //remove the catalog item from the catalog
				return true;
			}
		}
		else
		{ 
			return false;
		}
		return false;		
	}
}

