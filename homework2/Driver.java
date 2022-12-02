import java.util.ArrayList;
import java.io.*;

public class Driver {
		
	public static void main (String[] args) 
	{
		int numArgs = args.length;
		CatalogItemLoader loader = null;
		ArrayList<CatalogItem> itemList;
		if (numArgs > 0)
		{
			itemList = loadCSV(args[0]);
		}
		else
		{
			
			itemList = loadInteractive();						
		}
		Catalog catalog = setUpCatalog(itemList);			
		
		ArrayList<String> searchResults = catalog.search("Kate");
		
		System.out.println("Books by Kate");
		
		for (String item: searchResults)
		{
			Book book = catalog.getBook(item);
			
			System.out.println(book.getTitle()+", "+book.getAuthorFirstName()+", "+book.getAuthorLastName());
		}
	}
	public static Catalog setUpCatalog(ArrayList<CatalogItem> itemList)
	{
		try
		{
			Catalog catalog = new Catalog(itemList);
			return catalog;
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Error creating the catalog");
		}
		return null;
	}
	
	public static ArrayList<CatalogItem> loadCSV(String fileName)
	{
		CatalogItemLoaderCSV csvLoader = new CatalogItemLoaderCSV(fileName);
		ArrayList<CatalogItem> csvItems;
		
		//try              got an error when I tried catching the exception...
		//{
			csvItems = csvLoader.loadItems();
		//}
		/*catch (IOException e)
		{
			System.out.println("Error loading csv catalog items");
		}*/
		return csvItems;
	}
	
	public static ArrayList<CatalogItem> loadInteractive()
	{
		
		CatalogItemLoaderInteractive interactiveLoader = new CatalogItemLoaderInteractive();
		ArrayList<CatalogItem> interactiveItems;
		
		//try
		//{
			interactiveItems = interactiveLoader.loadItems();
			return interactiveItems;
		/*}
		catch (IOException e)
		{
			System.out.println("Error loading interactive catalog items");
		}
		return null; */
	}
}

