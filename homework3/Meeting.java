import java.util.GregorianCalendar;
import java.util.Calendar;

public class Meeting extends Event
{
    /*
     * class objects
     */
    private int endBuffer;

    /*
     * instantiate
     */

    public Meeting(Contact contact, String description)
    {
	super();
	this.organizer = contact;
	this.description = description;
    }

    /*
     * methods
     */

    public void setEndBuffer(int endBuffer)
    {
	this.endBuffer = endBuffer;
    }

    public void schedule(GregorianCalendar c)
    {
	if (c != null)
	{
		GregorianCalendar temp = (GregorianCalendar)c.clone();
	    this.startTime = c; 
	    this.endTime = temp;
	    this.endTime.add(Calendar.HOUR_OF_DAY, 1);
	    this.endTime.add(Calendar.MINUTE, endBuffer);

	}
	else
	{
	    this.startTime = null;
	    this.endTime = null;
	}
   }
}
