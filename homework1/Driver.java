import java.util.ArrayList;

public class Driver {
    /*tests the functionality of all the methods in Catalog.java. This also
    tests all the methods in CatalogItem and Book since Catalog depends on them
    */ 
    
    public static int numErrors = 0;
    public static Catalog catalog = new Catalog();
    public static Book book = new Book("Introduction to Java Programming", "Kate", "Holdener");
    
    public static int testAdd()
    {
         catalog.add(book);

         ArrayList< String > foundBooks = catalog.search("Kate");

         if (foundBooks.size() != 1)

         {
         System.out.println("Error: search method should have found one book");
         numErrors++;
         }
         return numErrors;
 }

    public static int testCheckout()
    {
         if (catalog.checkout("0") != true)
         {
         System.out.println("Error: Book should be checked out.");
         numErrors++;
         }

         return numErrors;
    }
    
    public static int testCheckin()
    {
        catalog.checkout("0");
         
         if (catalog.checkin("0") != true)
         {
         System.out.println("Error: Book should be checked in.");
         numErrors++;
         }
         return numErrors;
    }
    
    
    public static int testSearch()
    {
         Book book2 = new Book("Kate", "Claudia", "Joseph"); 
         
         catalog.add(book);
         catalog.add(book2);
         ArrayList< String > foundBooks = catalog.search("Kate");
             
         if (foundBooks.size() != 2)
         {
         System.out.println("Error: Search function did not recognize both Author and Title.");
         System.out.println(foundBooks.size());
         numErrors++;
         }
         return numErrors;
    }
    
    public static int testGetBook()
    {
        if (catalog.getBook("0") != book)
         {
         System.out.println("Error: Cannot return .getBook properly.");
         numErrors++;
         }
         return numErrors;
    }
    
    public static int testRemove()
    {
         if (catalog.remove("0") != true)
         {
         System.out.println("Error: Book not removed properly.");
         numErrors++;
         }
         return numErrors;
    }

    public static void main(String []args)
    {

        int numErrors = 0;
        numErrors += testAdd();
        numErrors +=testCheckout();
        numErrors +=testCheckin();
        numErrors +=testGetBook();
        numErrors +=testRemove();
        numErrors +=testSearch();
        

        if (numErrors > 0)
        {
        System.out.println("Fix your errors");
        }
        else
        {
        System.out.println("No errors were found");
        }
    }
}

