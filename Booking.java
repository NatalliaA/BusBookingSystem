import java.util.Arrays;
/**
 * Coach Trip Booking System
 * The Booking class includes information about customers who booked the trip
 * (name, phone number, how many adults and how many children are going to the trip).
 * 
 * @author Natallia Akulenka
 * @version 09.11.2013
 */
public class Booking
{
    // The name of the booking customer
    private String bookingName;
    // The phone number of the booking customer
    private String phoneNumber;
    // The number of the booking adults
    private int numberOfAdults;
    // The number of the booking children
    private int numberOfChildren;
    // The list with the seat numbers for the booking adults
    private int[] seatsAdults;
    // The list with the seat numbers for the booking children
    private int[] seatsChildren;

    /**
     * Create a new booking.
     * @param name presents the name of the booking customer
     * @param phone presents the phone number of the booking customer
     * @param adults presents the number of the booking adults
     * @param children presents the number of the booking children
     * @param seatsAdults presents the list with the seat numbers for the booking adults
     * @param seatsChildren presents the list with the seat numbers for the booking children
     */
    public Booking(String name, String phone, int adults, int children, int[] seatsAdults, int[] seatsChildren)
    {
        bookingName = name;
        phoneNumber = phone;
        numberOfAdults = adults;
        numberOfChildren = children;
        this.seatsAdults = seatsAdults;
        this.seatsChildren = seatsChildren;
    }

    /**
     * Return the number of booking adults.
     * @return The number of booking adults should be displayed
     */
    public int howManyAdults()
    {
        return numberOfAdults;
    }

    /**
     * Return the number of booking children.
     * @return The number of booking children should be displayed
     */
    public int howManyChildren()
    {
        return numberOfChildren; 
    }

    /**
     * Return the number of all booked seats.
     * @return The number of all booked seats should be displayed
     */
    public int howManySeats()
    {
        return numberOfAdults + numberOfChildren; 
    }

    /**
     * Return the list with the seat numbers for booking adults.
     * @return The list with the seat numbers for booking adults should be displayed
     */
    public int[] ArraySeatsAdults()
    {
        return seatsAdults; 
    }

    /**
     * Return the list with the seat numbers for booking children.
     * @return The list with the seat numbers for booking children should be displayed
     */
    public int[] ArraySeatsChildren()
    {
        return seatsChildren; 
    }

    /**
     * Create and return a string containing details of the booking.
     * @return The string of details should be displayed.
     */
    public String toString()
    {
        String booking = bookingName + ", " + phoneNumber + ", " +  
            numberOfAdults + " adult(s), " +  numberOfChildren + " child(ren)" + '\n'
            + "The seat numbers for adults: " + Arrays.toString(seatsAdults) + '\n' 
            + "The seat numbers for children: " +  Arrays.toString(seatsChildren) + '\n'; 
        return booking;
    }

}
