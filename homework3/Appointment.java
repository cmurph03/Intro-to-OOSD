import java.util.GregorianCalendar;
import java.util.Calendar;

public class Appointment extends Event
{
    /*
     * class objects
     */
    private int startBuffer;

    /* 
     * instantiate
     */

    public Appointment(Contact contact, String description)
    {
	super();
	this.organizer = contact;
	this.description = description;
    }

    /*
     * methods
     */

    public void setStartBuffer(int startBuffer)
    {
	this.startBuffer = startBuffer;
    }

    public void schedule(GregorianCalendar calendar)
    {
	if (calendar != null)
	{
	    GregorianCalendar temp = (GregorianCalendar)calendar.clone();
	    this.startTime = calendar; 
	    this.endTime = temp;
	    this.endTime.add(Calendar.HOUR_OF_DAY, 1);
	    this.startTime.add(Calendar.MINUTE, -startBuffer);
	}
	else
	{
	    this.startTime = null;
	    this.endTime = null;
	}
    }
    
}
