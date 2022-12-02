import java.util.ArrayList;
import java.util.Iterator;

public class CatalogController 
{
    private Catalog catalog;
    private CatalogUserInterface userInterface;

    public CatalogController(Catalog catalog, CatalogUserInterface ui)
    {
	this.catalog = catalog;
	this.userInterface = ui;
    }

    public void Search(String searchTerm)
    {
	ArrayList<Book> results = new ArrayList<Book>();
	ArrayList<String> searchResults = this.catalog.search(searchTerm);
	for (String item: searchResults)
	{
	    results.add(this.catalog.getBook(item));
	}
	userInterface.showBooks(results);
    }

    public void showAll()
    {
	ArrayList<Book> results = new ArrayList<Book>();
	for (CatalogItem item: this.catalog)
	{
	    results.add(item.getBook());
	} 
	userInterface.showBooks(results);
    }
}
