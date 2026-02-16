import java.util.ArrayList;
import java.util.Scanner;

public class CLIAppAdminCustomer{
    
    // declear variables
    static ArrayList<ArrayList<String>> tickets = new ArrayList<>();
    static ArrayList<String> ticket = new ArrayList<>();
    static String ticketNumber = "";
    static String ticketDescription = "";
    static String ticketPriority = "";
    static Scanner inputChoice = new Scanner(System.in);
    static Scanner inputTicketInfo = new Scanner(System.in);
    static String choice = "";
    static boolean countinue = true;
    static String PIN = "1234";

    public static void main(String[] args) {

        // display program first header
        System.out.println("=".repeat(50));
        System.out.println("        Welcom to Ticket Desk Application");
        System.out.println("=".repeat(50));

        // display main menu and proccec user choise
        while (countinue){
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
                countinue = false;
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
        boolean coun = true;
        System.out.print("Enter PIN: ");
        String pin = inputChoice.nextLine();

        // authentication administrator access
        if (!pin.equals(PIN)){
            System.out.println("You have enterd wrong PIN ...!");
            System.out.println("Returning to main menu >>\n");
        }
        else {
            while (coun){
                // display administrator menu
                System.out.println("\nAdministrator menu >> Choose user type:");
                System.out.println("(1) View Ticket\n(2) Update Ticket Description\n(3) Back to Main Menu");
                System.out.print("\nEnter your choice: ");
                choice = inputChoice.nextLine();

                // process administrator choice
                // view ticket operation
                if (choice.equals("1")){
                    System.out.print("Enter ticket number: ");
                    ticketNumber = inputTicketInfo.nextLine();
                    if (gitIndex(tickets, ticketNumber) == -1){
                        System.out.printf("There is no ticket with (%s) ticket number ...!\n" , ticketNumber);
                    }
                    else {
                        ticket = tickets.get(gitIndex(tickets, ticketNumber));
                        System.out.println();
                        System.out.printf("Ticket Number: %s\n" , ticket.get(0));
                        System.out.printf("Ticket Description: %s\n" , ticket.get(1));
                        System.out.printf("Ticket Priority: %s\n" , ticket.get(2));
                    }
                }

                // update ticket description operation 
                else if (choice.equals("2")){
                    System.out.print("Enter ticket number: ");
                    ticketNumber = inputTicketInfo.nextLine();

                    if (gitIndex(tickets, ticketNumber) == -1){
                        System.out.printf("There is no ticket with (%s) ticket number ...!\n" , ticketNumber);
                    }

                    else {
                        ticket = tickets.get(gitIndex(tickets, ticketNumber));
                        System.out.println();
                        System.out.print("Enter New Ticket Description: ");
                        ticketDescription = inputTicketInfo.nextLine();
                        ticket.set(1, ticketDescription);
                        tickets.set(gitIndex(tickets, ticketNumber), ticket);
                        System.out.println("Ticket Description Updated ..");
                    }

                }

                // back to the main menu
                else if (choice.equals("3")){
                    System.out.println("Back to Main Menu >>>");
                    coun = false;
                }
                else {
                    System.out.println("Invalid Input .. Please Try Again >>");
                }
            }
        }

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