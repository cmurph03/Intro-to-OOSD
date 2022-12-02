public class Contact
{
    /*
     *class variables
     */
    
    private String name;
    private int phoneNumber;

    /*
     * instantiate class
     */

    public Contact(String name, int phoneNumber)
    {
	this.name = name;
	this.phoneNumber = phoneNumber;
    }

    /* 
     * methods
     */

    public String getName()
    {
	return this.name;
    }

    public int getPhone()
    {
	return this.phoneNumber;
    }
}
