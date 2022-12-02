//A class to represent a book
public class Book {
	
	private String title;
	private String firstName;  //first name of the author
	private String lastName;  //last name of the author
	
	public Book(String title, String firstName, String lastName) 
	{ //Constructor for the book class
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public String getAuthorFirstName()
	{
		return firstName;
	}
	
	public String getAuthorLastName()
	{
		return lastName;
	}
	
	public String toString()
	{
		String val = title+", "+lastName+", "+firstName;
		return val;
	}
}

