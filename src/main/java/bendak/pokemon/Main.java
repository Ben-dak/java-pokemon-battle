package bendak.pokemon;                          // Declares the package this class belongs to

public class Main {                               // Defines the Main class (entry point holder)

    public static void main(String[] args) {      //  entry point method
        optionMenu();                             // Calls the optionMenu method that calls Userinterface
    }
    public static void optionMenu() {             // added this as a test for my understanding

        new UserInterface().start();
    }

}