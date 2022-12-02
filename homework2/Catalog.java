import java.util.ArrayList;

public class Catalog
{
   private ArrayList<CatalogItem> catalogItems;
   private int nextId;

   /**
    * Instantiate an empty list of catalog itemss
    */
   public Catalog()
   {
      catalogItems = new ArrayList<CatalogItem>();
      nextId = 0;
   }
   
   //instantiate a list of catalog items using a given list
   public Catalog (ArrayList<CatalogItem> myItems) throws IllegalArgumentException
   {
	boolean unique = uniqueIDs(myItems);
	if (!unique)
	{
	    throw new IllegalArgumentException("IDs must be unique");
	}
		
	catalogItems = myItems;
   }

   //walk through items and check if ids are unique
   private boolean uniqueIDs(ArrayList<CatalogItem> items)
   {
	boolean unique = true;
	for (int i = 0; i<items.size(); i++)
	{
	    String itemId = items.get(i).getId();
	    for(int j = i+1; j<items.size(); j++)
	    {
		if(itemId.equals(items.get(j).getId()))
		{
		    unique = false;
		}
	    }
	}
	return unique;
   }
   /**
    * Adds a book to the catalog
    */
   public void add(Book b)
   {
      nextId = findLargestID() + 1;
      String bookId = String.valueOf(nextId);
      addBookWithId(b, bookId);
   }

   //If possible, converts the Id from a string to an int
   private int convertToNumber(String id)
   {
      int idNumber;
      try
      {
	 idNumber = Integer.parseInt(id);
      }
      catch (NumberFormatException e)
      {
	  idNumber = 0;
      }
      return idNumber;
   }

   //Finds the largest ID number in the current catalog
   private int findLargestID()
   {
      int largest = 0;
      for (CatalogItem item: this.catalogItems)
     {
	int currentNum = convertToNumber(item.getId());
	if(largest < currentNum)
	{
	   largest = currentNum;
	}
     }
     return largest;
   }
   /**
    * If the book with the specified id is in the catalog's book collection and is available for checkout, 
    * the Catalog class marks this book as unavailable and returns True (meaning, checkout was successful). 
    * Otherwise, the method returns false.
    */
   public boolean checkout(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the book is available, make it not available
      // checkout is successful
      if (matchedItem != null && matchedItem.isAvailable())
      {
         matchedItem.setUnavailable();
         retValue = true;
      }

      return retValue;
   }

   /**
    * If the book with the specified id is in the catalog's book collection and is currently checked out, 
    * the Catalog marks this book as available and returns true (meaning, the return was successful). 
    * Otherwise, the method returns false. 
    */
   public boolean checkin(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the book is found and is currently unavailable, mark it as available
      if (matchedItem != null && !matchedItem.isAvailable())
      {
         matchedItem.setAvailable();
         retValue = true;
      }

      return retValue;
   }

   /*
    * Searches the book catalog for books that match the searchTerm exactly (equals) in the 
    * Title, First Name, or Last name attributes of the Book class. Returns the ArrayList of 
    * String objects - ids of the items that matched the searchTerm
    **/
   public ArrayList<String> search(String searchTerm)
   {
      ArrayList<String> retValue = new ArrayList<String>();

      // go through every book int the catalog and check if it matches the searchTerm
      // look at title, author first name, and author last name 
      for (CatalogItem item: this.catalogItems)
      { 
         Book book = item.getBook();

         if (book.getTitle().equals(searchTerm) ||
             book.getAuthorFirstName().equals(searchTerm) ||
             book.getAuthorLastName().equals(searchTerm))
         {
             retValue.add(item.getId());
         }
      }

      return retValue;
   }

   public Book getBook(String id)
   {
      CatalogItem item = findItem(id);
      Book retValue = null;
      if (item != null)
      {
         retValue = item.getBook();
      }
      return retValue;
   }
   /*
    * If the book with the specified bookId is in the Catalog's book collection and is available for checkout, 
    * removes the book from the collection and returns true. Otherwise, returns false.
    **/
   public boolean remove(String id)
   {
      CatalogItem item = findItem(id);
      boolean retValue = false;

      if (item != null && item.isAvailable())
      {
         this.catalogItems.remove(item);
         retValue = true;
      }
      return retValue;
   }


   private void addBookWithId(Book b, String id)
   {
      CatalogItem item = new CatalogItem(b, id, true);
      catalogItems.add(item);
   }


   private CatalogItem findItem(String id)
   {
      CatalogItem matchedItem   = null;

      // find the book with the specified id
      for (CatalogItem item: this.catalogItems)
      {
         if (item.getId().equals(id))
         {
            matchedItem = item;
            break;
         }
      }
      return matchedItem;
   }

}
