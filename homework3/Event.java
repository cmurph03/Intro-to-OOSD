import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public abstract class Event
{
    /*
     * class objects
     */
    protected GregorianCalendar startTime;
    protected GregorianCalendar endTime;
    protected Contact organizer;
    protected String description;

    public String toString()
    {
	if(startTime != null && endTime != null)
	{
	   return new String(this.description+ " Start: "+convertMYD(startTime)+ " at " 
	   +convertHM(startTime)+ " End: " +convertMYD(endTime)+ " at " +convertHM(endTime));
	}
	else
	{
	    return new String(this.description+ " not scheduled");
	}
    }

    public String convertMYD(GregorianCalendar calendar)
    {
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
	fmt.setCalendar(calendar);
	String dateFormatted = fmt.format(calendar.getTime());

	return dateFormatted;
    }

    public String convertHM(GregorianCalendar calendar)
    {
	SimpleDateFormat fmt = new SimpleDateFormat("kk:mm");
	fmt.setCalendar(calendar);
	String dateFormatted = fmt.format(calendar.getTime());

	return dateFormatted;
    }
    
    public boolean overlaps(Event e)
    {
	Event first, second;
	boolean overlap_found = true;
	if (this.startTime.compareTo(e.startTime) < 0)
	{
	    first = this;
	    second = e;
	}
	else
	{
	    first = e;
	    second = this;
	}
	if (first.endTime.compareTo(second.startTime) <= 0)
	{
	    overlap_found = false;
	}

	return overlap_found;
    }

    public abstract void schedule(GregorianCalendar calendar);

    /* 
     * returns the current date with the minutes, seconds, and ms set to 0 for comparison
     */
    public String getDate()
    {
	GregorianCalendar date = startTime;
	
	return convertMYD(date);
    }
}
