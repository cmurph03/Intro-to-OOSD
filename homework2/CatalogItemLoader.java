import java.util.ArrayList;

public class CatalogItemLoader 
{
	protected ArrayList<CatalogItem> catalogItems;

	public CatalogItemLoader()
	{
            catalogItems = new ArrayList<CatalogItem>();
	}
	
	public ArrayList<CatalogItem> getBooks()
	{
	    return this.catalogItems;
	}
}
