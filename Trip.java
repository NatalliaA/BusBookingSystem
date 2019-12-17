import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
/**
 * Coach Trip Booking System
 * The class Trip represents trips to different destinations organized by a coach company.
 * The company has a number of coaches for trips.
 * Each trip object has a booking list with customers' dates.
 * Children can also travel with adults. They are charged half the adult price.
 *   
 * @author Natallia Akulenka
 * @version 09.11.2013
 */
public class Trip
{
    // The trip's code 
    private String code;
    // The trip's price for an adult 
    private double price;
    // The trip's day
    private int day;
    // The trip's month
    private int month;
    // The trip's year
    private int year;
    // The list of bookings for this trip
    private ArrayList<Booking> bookings;
    // The number of seats in the coach provided for this trip
    private static final int SEATS = 32;

    /**
     * Create a new trip.
     * @param code presents the trip's code;
     * @param price presents the trip's price for an adult;
     * @param day presents the trip's day;
     * @param month presents the trip's month;
     * @param year presents the trip's year;
     */
    public Trip(String code, double price, int day, int month, int year)
    {
        this.code = code; 
        this.price = price;
        this.day = day;
        this.month = month;
        this.year = year; 
        bookings = new ArrayList<Booking>();
    }

    /**
     * Add a new booking to the trip.
     * @param c The booking to be added to the list of bookings.
     */
    public void addBooking(Booking c)
    {
        boolean correctBooking = true;
        // Do error checking, if any errors, change CorrectBooking = false

        if (bookings.contains(c) == true)
        {
            correctBooking = false;
            System.out.println("Adding the same booking twice is not allowed!");
        }

        if (c.howManySeats() > freeSeats())
        {
            correctBooking = false;
            System.out.println("Tried to reserve " + c.howManySeats() + " seats. Only have " + freeSeats()+ " seats available!" );            
        }

        Boolean SomeSeatsAlreadyTaken = false;
        // Find all seats already taken (and print an error for each of them)
        ArrayList<Integer> AllBookedSeatsAdults = getAllBookedSeatsAdults();
        ArrayList<Integer> AllBookedSeatsChildren = getAllBookedSeatsChildren();

        int[] ArraySeatsAdults = c.ArraySeatsAdults();
        for(int index = 0; index < ArraySeatsAdults.length; index++)
        {
            int WantedSeat = ArraySeatsAdults[index];
            if (AllBookedSeatsAdults.contains(WantedSeat) == true || AllBookedSeatsChildren.contains(WantedSeat) == true)
            {
                System.out.println("Seat " + WantedSeat + " is already booked by an adult!\n");    
                SomeSeatsAlreadyTaken = true;
            }            
        }

        int[] ArraySeatsChildren= c.ArraySeatsChildren();
        for(int index = 0; index < ArraySeatsChildren.length; index++)
        {
            int WantedSeat = ArraySeatsChildren[index];
            if (AllBookedSeatsAdults.contains(WantedSeat) == true || AllBookedSeatsChildren.contains(WantedSeat) == true)
            {
                System.out.println("Seat " + WantedSeat + " is already booked by a child!\n");    
                SomeSeatsAlreadyTaken = true;
            }            
        }

        if (SomeSeatsAlreadyTaken)
        {
            correctBooking = false;
        }

        if (correctBooking)
        {
            bookings.add(c);
        }
    }

    /**
     * Return the list with the booked seat numbers for adults.
     * @return The list with the booked seat numbers for adults should be displayed.
     */
    private ArrayList<Integer> getAllBookedSeatsAdults()
    {
        ArrayList<Integer> AllBookedSeatsAdults = new ArrayList<Integer>();
        int[] TempArray;
        int TempSeat;
        Iterator<Booking> iter = bookings.iterator();
        while (iter.hasNext())
        {
            Booking TempBooking = iter.next();
            TempArray = TempBooking.ArraySeatsAdults();
            for(int index = 0; index < TempArray.length; index++)
            {
                TempSeat = TempArray[index];
                AllBookedSeatsAdults.add(TempSeat);
            }
        }
        return AllBookedSeatsAdults;
    }

    /**
     * Return the list with the booked seat numbers for children.
     * @return The list with the booked seat numbers for children should be displayed.
     */
    private ArrayList<Integer> getAllBookedSeatsChildren()
    {
        ArrayList<Integer> AllBookedSeatsChildren = new ArrayList<Integer>();
        int[] TempArray;
        int TempSeat;
        Iterator<Booking> iter = bookings.iterator();
        while (iter.hasNext())
        {
            Booking TempBooking = iter.next();
            TempArray = TempBooking.ArraySeatsChildren();
            for(int index = 0; index < TempArray.length; index++)
            {
                TempSeat = TempArray[index];
                AllBookedSeatsChildren.add(TempSeat);
            }
        }
        return AllBookedSeatsChildren;
    }

    /**
     * Return a string with a representation of the booked seats.
     * "*" represents a free seat and A and C are used for adult and cilde occupants. 
     * @return The string with the plan of the coach seats to return
     */
    public String getCoachPlan()
    {
        String CoachPlan = "FRONT\n";
        ArrayList<Integer> AllBookedSeatsAdults = getAllBookedSeatsAdults();
        ArrayList<Integer> AllBookedSeatsChildren = getAllBookedSeatsChildren();

        for(int index = 1; index <= 32; index++)
        {
            if (AllBookedSeatsAdults.contains(index) == true)
            {
                CoachPlan += "A";
            }else if (AllBookedSeatsChildren.contains(index) == true)
            {
                CoachPlan += "C";
            }else
            {
                CoachPlan += "*";
            }

            if (index % 4 == 0) // Change the row of seats
            {
                CoachPlan += "\n";
            }else if (index % 2 == 0) // Add two spaces
            {
                CoachPlan += "  ";
            }
        }
        CoachPlan += "BACK\n";
        return CoachPlan;
    }

    /**
     * Remove the booking and releasesthe seats booked by this booking.
     * @param c The booking to be removed from the booking list.
     */    
    public void cancelBooking(Booking c)
    {
        bookings.remove(c);        
    }

    /**
     * Return the trip's code
     * @return The trip's code should be displayed
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Return the date of the trip.
     * @return The date as a string in the format "16/4/2009" to return
     */
    public String getDate()
    {
        return (day + "/" + month + "/" + year);
    }

    /**
     * Return the price of an adult fare.
     * @return The trip's price
     */
    public double getPrice() 
    {
        return price;
    }

    /**
     * Test whether the booking is already made on this trip.
     * @param The booking to be checked
     * @return True if booked, false otherwise
     */
    public boolean isBooking(Booking c)
    {
        return(bookings.contains(c)); 
    }

    /**
     * Count how many persons booked the trip.
     * @return The number of persons(adults and children)on the booking list for this trip to return
     */
    private int countPersonsInTrip()
    {
        int sum = 0;
        Iterator<Booking> iter = bookings.iterator();
        while (iter.hasNext())
        {
            Booking persons = iter.next();
            sum = sum + persons.howManyAdults()+ persons.howManyChildren();
        }
        return sum;
    }

    /**
     * Count the number of seats which are not booked yet for this trip. 
     * @return The number of free seats on the couch for this trip
     */
    private int freeSeats()
    {
        int freeSeats = SEATS - countPersonsInTrip();
        return freeSeats;

    }

    /**
     * Test whether all seats are booked or not.
     * @return True if all seats booked, false otherwise
     */    
    public boolean isFull()
    {
        return(countPersonsInTrip()== SEATS);
    }

    /**
     * Calculate the total of the fares charged for the booked seats.
     * @return The amount of the fares charged for the booked seats sould be displayed
     */
    public double getTotalMoneyCollected()
    {
        double sum = 0;
        Iterator<Booking> iter = bookings.iterator();
        while (iter.hasNext())
        {
            Booking currentBooking = iter.next();
            sum = sum + (currentBooking.howManyAdults()+0.5*currentBooking.howManyChildren())* price;
        }
        return sum; 
    }

    /**
     * Create and return a string containing details of the trip including the list of the bookings made.
     * @return The string of details should be displayed.
     */
    public String toString()
    {
        String result = "Trip code: " + code + '\n' + "Date: " + day + "/" + month + "/" + year + 
            '\n' + "Price: $" + price + '\n' + "Bookings:" + '\n' + '\n';
        Iterator<Booking> iter = bookings.iterator();
        while (iter.hasNext())
        {
            Booking nextBooking = iter.next();
            result += nextBooking.toString()+ '\n';
        }
        return result; 
    }

}
