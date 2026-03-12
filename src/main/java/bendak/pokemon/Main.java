import java.util.Scanner;

public class Main {
    static Pokemon p1 = new Pokemon("Eevee");

    public static void main(String[] args) {
        optionMenu();
    }
    public static void optionMenu() {

        new UserInterface().start();
//        Scanner myScanner = new Scanner(System.in); // Creates a scanner object to read input
//        String userInput;  // Variable to store options
//        do {               //do-while loop
//            System.out.println("""
//                    === Choose an option ===
//                    F) Fight
//                    P) Pokemon
//                    B) Bag
//                    R) Run
//                    """);//Displays main menu text
//            System.out.print("What will" + p1 + "do?");
//            userInput = myScanner.next().trim();//reads input then moves to next input
//
//            switch (userInput) { //checks what user enters then performs action
//                case "F" -> {
//                    System.out.println("""
//                    === Choose an attack ===
//                    A) Tackle
//                    """); //Displays attacks
//                    userInput = myScanner.next().trim();
////                    battleMenu();// collects info from attack
//                }
//                case "R" -> System.out.println("You successfully fled from battle.");
//                default -> System.out.println("Invalid option. Please try again.");
//            }
//        } while (!userInput.equals("R")); // Keep looping until user chooses R
//    }
//    public static void battleMenu() {

    }
}
