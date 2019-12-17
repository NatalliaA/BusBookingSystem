/**
 * Coach Trip Booking System
 * Test driver for the addBooking method of the Trip class.
 * Implemention of the black-box test plan.
 * 
 * @author Natallia Akulenka
 * @version 09.11.2013
 */
public class addBookingTester
{
    // The Trip object being tested.
    private Trip trip1;

    // Clear the terminal
    private void clearScreen()
    {
        System.out.print('\u000C');
    }

    // Testing the addBooking method of the Trip class
    public void test()
    {
        clearScreen();
        // test 1
        System.out.println('\n' + "------Test 1-----");
        System.out.println("A new Trip object without any bookings included should be created." + '\n' + '\n' + 
            "The output expected:" + '\n' +
            "Trip code: mi, Date: 2/12/2013, Price: $600.0" + '\n' + "Bookings:" + '\n');
        System.out.println(" ");
        System.out.println("The actual output:");  
        // Create a Trip object that can be used in testing.
        Trip trip1 = new Trip ("mi", 600.0, 2, 12, 2013);
        System.out.println(trip1.toString());

        // test2
        System.out.println('\n' + "------Test 2-----");
        System.out.println("A booking should be added to the trip."  + '\n' + '\n' + 
            "The output expected:" + '\n' +
            "Trip code: mi, Date: 2/12/2013, Price: $600.0" + '\n' + "Bookings:" + '\n' + 
            "Tom, 404404, 1 adult(s), 0 child(ren)" + '\n' +
            "The seat numbers for adults: [1], The seat numbers for children: []");
        System.out.println(" ");
        System.out.println("The actual output:");      
        int[] ad1 = {1};
        int[] ch1 = {};
        Booking booking1 = new Booking("Tom", "404404", 1, 0, ad1, ch1);
        trip1.addBooking(booking1);
        System.out.println(trip1.toString());

        // test 3
        System.out.println('\n' + "------Test 3-----");
        System.out.println("Tries to add the same booking twice."  + '\n' + '\n' + 
            "The output expected:" + '\n' +
            "Trip code: mi, Date: 2/12/2013, Price: $600.0" + '\n' + "Bookings:" + '\n' + 
            "Tom, 404404, 1 adult(s), 0 child(ren)" + '\n' +
            "The seat numbers for adults: [1], The seat numbers for children: []");
        System.out.println(" ");
        System.out.println("The actual output:");      
        trip1.addBooking(booking1);
        System.out.println(trip1.toString());

        // test4
        System.out.println('\n' + "------Test 4-----");
        System.out.println("A new different booking should be added." + '\n' + '\n' + 
            "The output expected:" + '\n' +
            "Trip code: mi, Date: 2/12/2013, Price: $600.0" + '\n' + "Bookings:" + '\n' + 
            "Tom, 404404, 1 adult(s), 0 child(ren)" + '\n' +
            "The seat numbers for adults: [1], The seat numbers for children: []" + '\n' + 
            "Ana, 404412, 2 adult(s), 2 child(ren)" + '\n' + 
            "The seat numbers for adults: [2, 3], The seat numbers for children: [4, 5]");
        System.out.println(" ");
        System.out.println("The actual output:");      
        int[] ad2 = {2,3};
        int[] ch2 = {4,5};
        Booking booking2 = new Booking("Ana", "404412", 2, 2, ad2, ch2);
        trip1.addBooking(booking2); 
        System.out.println(trip1.toString());

        // test5
        System.out.println('\n' + "------Test 5-----");
        System.out.println("A new booking should be added leaving only one vacant seat." + '\n' + '\n' + 
            "The output expected:" + '\n' +
            "Trip code: mi, Date: 2/12/2013, Price: $600.0" + '\n' + "Bookings:" + '\n' + 
            "Tom, 404404, 1 adult(s), 0 child(ren)" + '\n' +
            "The seat numbers for adults: [1], The seat numbers for children: []" + '\n' + 
            "Ana, 404412, 2 adult(s), 2 child(ren)" + '\n' + 
            "The seat numbers for adults: [2, 3], The seat numbers for children: [4, 5]" + 
            '\n' + "Joe, 404303, 20 adult(s), 6 child(ren)" + '\n' +
            "The seat numbers for adults: [6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25], The seat numbers for children: [26,27,28,29,30,31]");
        System.out.println(" ");
        System.out.println("The actual output:");      
        int[] ad3 = {6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int[] ch3 = {26,27,28,29,30,31};
        Booking booking3 = new Booking("Joe", "404303", 20, 6, ad3, ch3);
        trip1.addBooking(booking3); 
        System.out.println(trip1.toString());

        // test6
        System.out.println('\n' + "------Test 6-----");
        System.out.println("Tries to add a new booking requiring more seats than there are left."  + '\n');
        int[] ad4 = {31,32};
        int[] ch4 = {};
        Booking booking4 = new Booking("Bill", "505303", 2, 0, ad4, ch4);
        trip1.addBooking(booking4); 
        System.out.println(" ");
        System.out.println(trip1.toString());

        // test7
        System.out.println('\n' + "------Test 7-----");
        System.out.println("A new booking should be added filling the remaining seats."  + '\n'+ '\n' + 
            "The output expected:" + '\n' +
            "Trip code: mi, Date: 2/12/2013, Price: $600.0" + '\n' + "Bookings:" + '\n' + 
            "Tom, 404404, 1 adult(s), 0 child(ren)" + '\n' +
            "The seat numbers for adults: [1], The seat numbers for children: []" + '\n' + 
            "Ana, 404412, 2 adult(s), 2 child(ren)" + '\n' + 
            "The seat numbers for adults: [2, 3], The seat numbers for children: [4, 5]" + 
            '\n' + "Joe, 404303, 20 adult(s), 6 child(ren)" + '\n' +
            "The seat numbers for adults: [6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25], The seat numbers for children: [26,27,28,29,30,31]" + '\n' + 
            "Tom, 404404, 1 adult(s), 0 child(ren)" + '\n' +
            "The seat numbers for adults: [1], The seat numbers for children: []" + '\n' + 
            "Dana, 202202, 1 adult(s), 0 child(ren), The seat numbers for adults: [32], The seat numbers for children: [0]");
        int[] ad5 = {32};
        int[] ch5 = {};
        Booking booking5 = new Booking("Dana", "202202", 1, 0, ad5, ch5);
        trip1.addBooking(booking5);
        System.out.println(trip1.toString());

    }
}
