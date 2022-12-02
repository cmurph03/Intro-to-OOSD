import java.util.Calendar;
import java.util.GregorianCalendar;
public class EventTest
{
   public static void testOverlapsExpectTrue()
   {
      Contact organizer = new Contact("Kate", 123456789);
      GregorianCalendar dateTime = new GregorianCalendar(2020, 8, 7, 12, 0, 0);
      Appointment a = new Appointment(organizer, "code testing");
      Appointment b = new Appointment(organizer, "take a quiz");
      // create two overlapping appointments
      // assuming Appointment's schedule method works correctly
      a.schedule(dateTime);
      b.schedule(dateTime);
      // We expect this call to return true
      boolean result = a.overlaps(b);
      if (result == false)
      {
         System.out.println("ERROR: overlaps returned false, when true was expected\n." + 
                            "The two appointments are\n"+a+"and\n"+b);
      }
   }


   public static void testGetStartTime()
   {
      Contact organizer = new Contact("Kate", 123456789);
      GregorianCalendar dateTime = new GregorianCalendar(2020, 8, 7, 20, 0, 0);
      Appointment a = new Appointment(organizer, "code testing");

      // assuming Appointment's schedule method works correctly
      a.schedule(dateTime);
      // We expect a.getStartTime() to produce the same date/time value
      // as dateTime
      if (a.getStartTime().compareTo(dateTime) != 0)
      {
         System.out.println("ERROR: getStartTime() returned unexpected time\n");
      }
   }

   public static void testGetEndTime()
   {
      Contact organizer = new Contact("Kate", 123456789);
      GregorianCalendar dateTime = new GregorianCalendar(2020, 8, 7, 20, 0, 0);
      Appointment a = new Appointment(organizer, "code testing");
      
      // We expect a.getEndTime() to be an hour after dateTime
      GregorianCalendar expectedEndTime = new GregorianCalendar(
         dateTime.get(Calendar.YEAR),
         dateTime.get(Calendar.MONTH),
         dateTime.get(Calendar.DAY_OF_MONTH),
         dateTime.get(Calendar.HOUR_OF_DAY),
         dateTime.get(Calendar.MINUTE),
         dateTime.get(Calendar.SECOND)
      );
      expectedEndTime.add(Calendar.HOUR_OF_DAY,1);

      // assuming Appointment's schedule method works correctly
      a.schedule(dateTime);
      if (a.getEndTime().compareTo(expectedEndTime) != 0)
      {
         System.out.println("ERROR: getEndTime() returned unexpected time\n");
      }
   }


   public static void main(String []args)
   {
      testGetStartTime();
      testGetEndTime();
      testOverlapsExpectTrue();
   }
}
