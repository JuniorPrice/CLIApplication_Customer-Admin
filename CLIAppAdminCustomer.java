import java.util.ArrayList;
import java.util.Scanner;

public class CLIAppAdminCustomer{
    
    // declear variables
    static ArrayList<ArrayList<String>> tickets = new ArrayList<>();
    static String ticketNumber = "";
    static String ticketDescription = "";
    static String ticketPriority = "";
    static Scanner inputChoice = new Scanner(System.in);
    static Scanner inputTicketInfo = new Scanner(System.in);
    static String choice = "";
    static boolean count = true;

    public static void main(String[] args) {

        // display program first header
        System.out.println("=".repeat(50));
        System.out.println("        Welcom to Ticket Desk Application");
        System.out.println("=".repeat(50));

        // display main menu and proccec user choise
        while (count){
            System.out.println("\nMain menu >> Choose user type:");
            System.out.println("(1) Admin\n(2) Customer\n(3) Exit");
            System.out.print("\nEnter your user type: ");
            choice = inputChoice.nextLine();

            if (choice.equals("1")){
                adminHandler();
            }

            else if (choice.equals("2")){
                customerHandler();
            }

            else if (choice.equals("3")){
                count = false;
                System.out.println("Thank you for using this program ...GodBay!");
            }
            
            else {
                System.out.println("Invalid Input .. Please Try Again >>");
            }
        }
        
    }

    // customer menu handler
    static void customerHandler(){

    }


    // admin menu handler
    static void adminHandler(){

    }

    
    // git index numer of a record from arrayList
    static int gitIndex(ArrayList<ArrayList<String>> tickets,String ticketNumber){
        int index = -1;
        int counter = 0;
        for (ArrayList<String> ticket : tickets){
            if (ticket.get(0).equals(ticketNumber)){
                index = counter;
                return index;
            }
            
            counter++ ;
        }
        return index;
    }

}