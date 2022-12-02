import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class CatalogTest
{
     private Book testBook;
     private Catalog testCatalog;

     @Before
     public void setUp() throws Exception
     {
	testBook = new Book("Dune", "Frank", "Herbert");
	testCatalog = new Catalog();
     }

 
     //Tests for Book class
     @Test
     public void testgetAuthorFirstName() throws Exception
     {
	assertEquals("Error: getAuthorFirstName()","Frank", testBook.getAuthorFirstName());
     }

     @Test
     public void testGetAuthorLastName() throws Exception
     {
	assertEquals("Error: getAuthorLastName()", "Herbert", testBook.getAuthorLastName());
     }


     @Test
     public void testGetTitle() throws Exception
     {
	assertEquals("Error: getTitle()", "Dune", testBook.getTitle());
     }
     
     //Catalog Item Class Tests
     
     @Test
     public void testGetId()
     {	
	CatalogItem book1 = new CatalogItem(testBook, "1", true);
	assertEquals("Error: getID()", "1", book1.getId());
     }

     @Test
     public void testIsAvailable() throws Exception
     {
	CatalogItem book1 = new CatalogItem(testBook, "1", true);
	assertTrue("Error: isAvailable()", book1.isAvailable());
     }

     @Test
     public void testSetAvailable() throws Exception
     {
	CatalogItem book1 = new CatalogItem(testBook, "1", false);
	book1.setAvailable();
	assertTrue("Error: setAvailable()", book1.isAvailable());
     }

     @Test
     public void testSetUnavailable() throws Exception
     {
	CatalogItem book1 = new CatalogItem(testBook, "1", true);
	book1.setUnavailable();
	assertFalse("Error: setUnavailable()", book1.isAvailable());
     }

     // Catalog class tests
     
     @Test
     public void testAddBookandGetBook() throws Exception
     {
	testCatalog.add(testBook);
	String result = testCatalog.getBook("1").getTitle();
	assertEquals("Error: addBook() and getBook()", "Dune", result);
     }

     @Test
     public void testUniqueIdForIdenticalBook() throws Exception
     {
	testCatalog.add(testBook);
	testCatalog.add(testBook);
	ArrayList<String> matches = testCatalog.search("Dune");
	assertEquals("Error: did not create unique catalog items for copy of book", 2, matches.size());
     }
     
     @Test
     public void testCheckOutAvailableBook() throws Exception
     {
	testCatalog.add(testBook);
	assertTrue("Error: checkOut", testCatalog.checkout("1"));
     }

     @Test
     public void testCheckOutUnavailableBook() throws Exception
     {
	testCatalog.add(testBook);
	testCatalog.checkout("1");
	assertFalse("Error: Check out unavailable book", testCatalog.checkout("1"));
     }

     @Test
     public void testCheckInAvailableBook() throws Exception
     {
	testCatalog.add(testBook);
	assertFalse("Error: Check in available book", testCatalog.checkin("1"));
     }

     @Test
     public void testCheckInUnavailableBook() throws Exception
     {
	testCatalog.add(testBook);
	testCatalog.checkout("1");
	assertTrue("Error: Check Out then Check In New Book", testCatalog.checkin("1"));
     }
     
     @Test
     public void testCheckInNonExistantBook() throws Exception
     {
	assertFalse("Error: Check In Non-Existant Book", testCatalog.checkin("2"));
     }

     @Test
     public void testRemove() throws Exception
     {
	testCatalog.add(testBook);
	assertTrue("Error: remove", testCatalog.remove("1"));
     }

     @Test
     public void testCheckOutandRemove() throws Exception
     {
	testCatalog.add(testBook);
	testCatalog.checkout("1");
	assertFalse("Error: cannot remove checked out book", testCatalog.remove("1"));
     }

     @Test public void testSearchByTitle() throws Exception
     {
	testCatalog.add(testBook);
     	ArrayList<String> matches = testCatalog.search("Dune");
	assertEquals("Error: Search Title", 1, matches.size());
     }
    
     @Test public void testSearchByAuthorFirstName() throws Exception
     {
	testCatalog.add(testBook);
     	ArrayList<String> matches = testCatalog.search("Frank");
	assertEquals("Error: Search Author First Name", 1, matches.size());
     }
   
     @Test public void testSearchByAuthorLastName() throws Exception
     {
	testCatalog.add(testBook);
     	ArrayList<String> matches = testCatalog.search("Herbert");
	assertEquals("Error: Search Author Last Name", 1, matches.size());
     }
     
     @Test public void testSearchWithMultipleEntries() throws Exception
     {
	Book book1 = new Book("Pride and Prejudice", "Jane", "Austen");
	Book book2 = new Book("Emma", "Jane", "Austen");
	testCatalog.add(testBook);
	testCatalog.add(book1);
	testCatalog.add(book2);
	ArrayList<String> matches = testCatalog.search("Jane");
	assertEquals("Error: Search with multiple resutls", 2, matches.size());
     }
     @Test
     public void testUploadListToCatalog() throws Exception
     {
	ArrayList<CatalogItem> bookList= new ArrayList<CatalogItem>();
	CatalogItem book1 = new CatalogItem(testBook, "1", true);
	Book testBook2 = new Book("Logan's Run", "William", "Nolan");
	CatalogItem book2 = new CatalogItem(testBook2, "2", true);
	bookList.add(book1);
	bookList.add(book2);
        Catalog catalog = new Catalog(bookList);
        assertTrue("Error: Upload List to Catalog", catalog.remove("1"));  
     }

}

