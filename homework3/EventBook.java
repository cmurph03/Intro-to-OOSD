import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class EventBook
{
   private ArrayList<Event> eventsList;

   /*
    * Instantiate an empty list of events
    */
   public EventBook()
   {
	this.eventsList = new ArrayList<Event>();
   }

   /*
    * Seach through current event list to find if any events overlap
    * if not, add to list and return true. Any overlaps will return 
    * false
    */
   public boolean addEvent(Event event, GregorianCalendar calendar)
   {
	event.schedule(calendar);
	for (Event e: this.eventsList)
	{
	    if (e.overlaps(event))
	    {
		event.schedule(null);
		return false;
	    }
	}
	eventsList.add(event);
	return true;
   }

   public ArrayList<Event> getEventsForDate(GregorianCalendar calendar)
   {
	ArrayList<Event> daysEvents = new ArrayList<Event>();
	/*
	 * for some reason convertMYD from Event doesn't work even though getDate
	 * (also from Event) does. So there's one spot of repetative code
	 */
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
	fmt.setCalendar(calendar);
	String dateFormatted = fmt.format(calendar.getTime());

	
	for (Event e: this.eventsList)
	{
	    if (e.getDate().equals(dateFormatted))
	    { 
		daysEvents.add(e);
	    }
	}
	return daysEvents;
   }
}
