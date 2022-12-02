import java.util.ArrayList;

public class Driver
{
   public static int testAddAndSearch()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      Book book = new Book("Java for all", "Kate", "Holdener");
      catalog.add(book);

      ArrayList<String> matches = catalog.search("Kate");
      if (matches.size() != 1)
      {
         System.out.println("ERROR (testAddAndSearch): could not find the book");
         numErrors++;
      }

      return numErrors;
   }

   public static int testSearchManyMatches()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      Book book = new Book("Java for all", "Kate", "Holdener");
      catalog.add(book);

      book = new Book("Kate", "Java for all", "Holdener");
      catalog.add(book);

      book = new Book("Holdener", "Kate", "Java for all");
      catalog.add(book);

      book = new Book("Hello World", "Joe", "Bob");
      catalog.add(book);

      ArrayList<String> matches = catalog.search("Java for all");
      if (matches.size() != 3)
      {
         System.out.println("ERROR (testSearchManyMatches): found " +
            matches.size() + "books, expected 3");
         numErrors++;
      }

      return numErrors;
   }

   public static int testAddSearchAndGetBook()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      Book book = new Book("Java for all", "Kate", "Holdener");
      catalog.add(book);

      ArrayList<String> matches = catalog.search("Kate");
      if (matches.size() != 1)
      {
         System.out.println("ERROR (testAddSearchAndGetBook): could not find the book");
         numErrors++;
      }
      else
      {
         Book bookFound = catalog.getBook(matches.get(0));
         if ( !bookFound.getTitle().equals(book.getTitle()) )
         {
            System.out.println("ERROR (testAddSearchAndGetBook): book title does not match.");
            numErrors++;
         }
      }
      return numErrors;
   }

   public static int testCheckout()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      Book book = new Book("Java for all", "Kate", "Holdener");
      catalog.add(book);

      ArrayList<String> matches = catalog.search("Kate");
      if (matches.size() != 1)
      { 
         System.out.println("ERROR (testCheckout): Failed to find the book");
         numErrors++;
      }
      else
      {
         boolean checkoutSuccess = catalog.checkout(matches.get(0));
         if ( !checkoutSuccess )
         {
            System.out.println("ERROR (testCheckout): Failed to check out a book");
            numErrors++;
         }
      }

      return numErrors;
   }

   public static int testCheckoutTwice()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      Book book = new Book("Java for all", "Kate", "Holdener");
      catalog.add(book);

      ArrayList<String> matches = catalog.search("Kate");
      if (matches.size() != 1)
      { 
         System.out.println("ERROR (testCheckoutTwice): Failed to find the book");
         numErrors++;
      }
      else
      {
         boolean checkoutSuccess = catalog.checkout(matches.get(0));
         checkoutSuccess = catalog.checkout(matches.get(0));
         if ( checkoutSuccess )
         {
            System.out.println("ERROR (testCheckoutTwice): Checked out the same id twice");
            numErrors++;
         }
      }

      return numErrors;
   }

   public static int testCheckinToEmptyCatalog()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      boolean checkinSuccess = catalog.checkin("1");
      if ( checkinSuccess )
      {
         System.out.println("ERROR (testCheckinToEmptyCatalog): successfully checked in non-existent ID");
         numErrors++;
      }
      return numErrors;
   }

   public static int testCheckin()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      Book book = new Book("Java for all", "Kate", "Holdener");
      catalog.add(book);

      ArrayList<String> matches = catalog.search("Kate");
      if (matches.size() != 1)
      {
         System.out.println("ERROR (testCheckin): could not find the book");
         numErrors++;
      }
      else
      {
         boolean checkoutSuccess = catalog.checkout(matches.get(0));
         if ( !checkoutSuccess )
         {
            System.out.println("ERROR (testCheckin): could not checkout book");
            numErrors++;
         }
         else
         {

            boolean checkinSuccess = catalog.checkin(matches.get(0));
            if ( !checkinSuccess )
            {
               System.out.println("ERROR (testCheckin): could not checkin book");
               numErrors++;
            }
         }
      }

      return numErrors;
   }


   public static int testRemove()
   {
      int numErrors = 0;

      Catalog catalog = new Catalog();
      Book book = new Book("Java for all", "Kate", "Holdener");

      // adding the same book instance will result in two unique catalog items
      catalog.add(book);
      catalog.add(book);

      ArrayList<String> matches = catalog.search("Kate");
      if (matches.size() != 2)
      {
         System.out.println("ERROR (testRemove): could not find the book");
         numErrors++;
      }
      else
      {
         boolean removeSuccess = catalog.remove(matches.get(0));
         if ( !removeSuccess )
         {
            System.out.println("ERROR (testRemove): could not remove book");
            numErrors++;
         }
         else
         {
            // Should not be able to remove the same unique id the second time
            removeSuccess = catalog.remove(matches.get(0));
            if ( removeSuccess )
            {
               System.out.println("ERROR (testRemove): managed to remove the same id twice");
               numErrors++;
            }
         }
      }

      return numErrors;
   }


   public static void main(String []args)
   {
      int numErrors = 0;
      numErrors += testAddAndSearch();
      numErrors += testSearchManyMatches();
      numErrors += testAddSearchAndGetBook();
      numErrors += testCheckout();
      numErrors += testCheckoutTwice();
      numErrors += testCheckinToEmptyCatalog();
      numErrors += testCheckin();
      numErrors += testRemove();

      if (numErrors > 0)
      {
         System.out.println("Found " + numErrors + " errors");
      }
      else
      {
         System.out.println("No errors found!");
      }
   }
}
