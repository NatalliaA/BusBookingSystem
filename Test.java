
/**
 * Coach Trip Booking System
 * Test driver for the Trip class
 * 
 * @author Natallia Akulenka
 * @version 09.11.2013
 */
public class Test
{
    // The Trip object being tested.
    private Trip trip1;

    // Clear the terminal
    private void clearScreen()
    {
        System.out.print('\u000C');
    }

    // Testing methods of the Trip class
    public void test()
    {
        clearScreen();
        // test 1
        System.out.println('\n' + "------Test 1-----");
        System.out.println("A new Trip object without any bookings included should be created." + '\n');
        // Create a Trip object that can be used in testing.
        Trip trip1 = new Trip ("mi", 600.0, 2, 12, 2013);
        System.out.println(trip1.toString());
        
        // test 1a
        System.out.println('\n' + "------Test 1a-----");
        System.out.println("It should return false, that all seats are booked." + '\n');
        trip1.isFull();
        System.out.println(trip1.isFull());
        
        // test1b
        System.out.println('\n' + "------Test 1b-----");
        System.out.println("The total amount of collected money 0.0 should be displayed." + '\n');
        trip1.getTotalMoneyCollected();
        System.out.println(trip1.getTotalMoneyCollected());

        // test2
        System.out.println('\n' + "------Test 2-----");
        System.out.println("A booking should be added to the trip."  + '\n');
        int[] ad1 = {1};
        int[] ch1 = {};
        Booking booking1 = new Booking("Tom", "404404", 1, 0, ad1, ch1);
        trip1.addBooking(booking1);
        System.out.println(trip1.toString());

        // test 3
        System.out.println('\n' + "------Test 3-----");
        System.out.println("Tries to add the same booking twice, which should return an error message without adding the booking again."  + '\n');
        trip1.addBooking(booking1);
        System.out.println(" ");
        System.out.println(trip1.toString());

        // test4
        System.out.println('\n' + "------Test 4-----");
        System.out.println("A new different booking should be added."  + '\n');
        int[] ad2 = {2,3};
        int[] ch2 = {4,5};
        Booking booking2 = new Booking("Ana", "404412", 2, 2, ad2, ch2);
        trip1.addBooking(booking2); 
        System.out.println(trip1.toString());
        
        // test4a
        System.out.println('\n' + "------Test 4a-----");
        System.out.println("The total amount of collected money 2400.0 should be displayed." + '\n');
        trip1.getTotalMoneyCollected();
        System.out.println(trip1.getTotalMoneyCollected());
        
        // test 4b
        System.out.println('\n' + "------Test 4b-----");
        System.out.println("Tries to add a new booking with a seat number for an adult which is already taken." + '\n'
                            + "Should return an error message."  + '\n');
        int[] ad8 = {5,6};
        int[] ch8 = {7};
        Booking booking = new Booking("Eva", "808412", 2, 1, ad8, ch8);
        trip1.addBooking(booking); 
        System.out.println(trip1.toString());
        
        
        // test 4c
        System.out.println('\n' + "------Test 4c-----");
        System.out.println("Tries to add a new booking with a seat number for a child which is already taken." + '\n'
                            + "Should return an error message."  + '\n');
        int[] adult = {6};
        int[] child = {4};
        Booking booking6 = new Booking("Ton", "807412", 1, 1, adult, child);
        trip1.addBooking(booking6); 
        System.out.println(trip1.toString());

        // test5
        System.out.println('\n' + "------Test 5-----");
        System.out.println("A new booking should be added leaving only one vacant seat."  + '\n');
        int[] ad3 = {6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        int[] ch3 = {26,27,28,29,30,31};
        Booking booking3 = new Booking("Joe", "404303", 20, 6, ad3, ch3);
        trip1.addBooking(booking3); 
        System.out.println(trip1.toString());

        // test6
        System.out.println('\n' + "------Test 6-----");
        System.out.println("Tries to add a new booking requiring more seats than there are left." + '\n' + 
                            "Should return an error message.");
        int[] ad4 = {31,32};
        int[] ch4 = {};
        Booking booking4 = new Booking("Bill", "505303", 2, 0, ad4, ch4);
        trip1.addBooking(booking4); 
        System.out.println(" ");
        System.out.println(trip1.toString());
        
        // test 6a
        System.out.println('\n' + "------Test 6a-----");
        System.out.println("It should return false, that all seats are booked." + '\n');
        trip1.isFull();
        System.out.println(trip1.isFull());

        // test7
        System.out.println('\n' + "------Test 7-----");
        System.out.println("A new booking should be added filling the remaining seats."  + '\n');
        int[] ad5 = {30};
        int[] ch5 = {};
        Booking booking5 = new Booking("Dana", "202202", 1, 0, ad5, ch5);
        trip1.addBooking(booking5);
        System.out.println(trip1.toString());
                      
        // test8
        System.out.println('\n' + "------Test 8-----");
        System.out.println("The trip's code should be displayed." + '\n');
        trip1.getCode();
        System.out.println(trip1.getCode());
        
        // test 9
        System.out.println('\n' + "------Test 9-----");
        System.out.println("The trip's date should be displayed in the format 2/12/2013." + '\n');
        trip1.getDate();
        System.out.println(trip1.getDate());
        
        // test 10
        System.out.println('\n' + "------Test 10-----");
        System.out.println("It should return true, that the booking1 is already made on this trip" + '\n');
        trip1.isBooking(booking1);
        System.out.println(trip1.isBooking(booking1));
        
        // test11
        System.out.println('\n' + "------Test 11-----");
        System.out.println("It should return false. The booking10 is not made on this trip." + '\n');
        int[] ad = {2,3};
        int[] ch = {4,5};
        Booking booking10 = new Booking("Nata", "604404", 2, 2, ad, ch);
        trip1.isBooking(booking10);
        System.out.println(trip1.isBooking(booking10));
        
         // test12
        System.out.println('\n' + "------Test 12-----");
        System.out.println("It should return true, that all seats are booked." + '\n');
        trip1.isFull();
        System.out.println(trip1.isFull());
        
        // test13
        System.out.println('\n' + "------Test 13-----");
        System.out.println("The booking3 with the name Joe should be removed from the trip."  + '\n');
        trip1.cancelBooking(booking3);
        System.out.println(trip1.toString());
        
        // test 14
        System.out.println('\n' + "------Test 14-----");
        System.out.println("The plan of the coach should be displayed. The first string should be FRONT." + 
                            "The last string should be BACK." + '\n' +
                            "* means a free seat and A(seat numbers 1,2,3,30,31,32) and C (seat numbers 4,5) mean adult and child occupants."  + '\n');
        trip1.getCoachPlan();
        System.out.println(trip1.getCoachPlan());
          

       
    }
}

