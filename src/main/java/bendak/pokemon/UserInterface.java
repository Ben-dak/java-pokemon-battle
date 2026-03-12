package bendak.pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {                      // Handles all console input and turn flow
    private Scanner myScanner = new Scanner(System.in);

    public void battleStart() {
        Move shadowBall = new Move("Shadow Ball", 30); // Creates a new move object

        // Build Gengar's move list
        ArrayList<Move> gengarMoves = new ArrayList<>();     // Creates a new "Move" array list for Gengar
        gengarMoves.add(shadowBall);                    // Adds Shadow Ball to the "Move" array list

        // Build Nidorino's move list
        ArrayList<Move> nidorinoMoves = new ArrayList<>();   // Creates a new "Move" array list for Nidorino
        nidorinoMoves.add(new Move("Horn Attack", 25)); // Adds Horn Attack to the array list
        nidorinoMoves.add(new Move("Take Down", 60)); // Adds Take Down Attack to the array list

        // Create Pokémon with names, starting HP, and their moves
        Pokemon gengar = new Pokemon("Gengar", 100, new ArrayList<>(gengarMoves)); // Copy list for safety
        Pokemon nidorino = new Pokemon("Nidorino", 100, new ArrayList<>(nidorinoMoves)); // Ditto

        // Create the battle context with both Pokémon
        Battle battle = new Battle(gengar, nidorino);    // Puts combatants into a battle

        System.out.println("A wild Nidorino appeared!"); // Announce encounter
        System.out.println("Go! Gengar!");                // Send out player Pokémon

        // Main turn loop
        while (!battle.isOver()) {                        // Continue until someone faints
            showStatus(gengar, nidorino);                // Display current HP for both (before and after battle

            Move chosen = promptForMove(gengar.getMoves()); // Read a validated move choice

            battle.applyAttack(gengar, nidorino, chosen);

            if (battle.isOver()) break;                   // If enemy fainted, stop before counterattack

            // Enemy’s turn: simple AI uses first move
            Collections.shuffle(nidorinoMoves);
            Move enemyMove = nidorinoMoves.get(0); // Get first move (now random after shuffle)
            battle.applyAttack(nidorino, gengar, enemyMove);// Enemy attacks back
        }

        // After loop, announce who won
        System.out.println("Winner: " + battle.getWinner().getName()); // Print winner’s name
        // Note: not closing scanner here—closing System.in can affect the JVM for subsequent reads
    }

    // Displays both Pokémon HP totals on one line
    private void showStatus(Pokemon p1, Pokemon p2) {
        System.out.println(p1.getName() + " HP: " + p1.getHp() + " | " + p2.getName() + " HP: " + p2.getHp());
        // Example: "Gengar HP: 75 | Nidorino HP: 50"
    }

    // Prompts the player to select a valid move and returns it
    private Move promptForMove(List<Move> moves) {
        while (true) {                                    // Keep asking until valid selection
            System.out.println("=== Choose an attack ==="); // Header line
            for (int i = 0; i < moves.size(); i++) {      // List all moves with numbers
                System.out.println((i + 1) + ") " + moves.get(i).getName()
                        + " (" + moves.get(i).getBaseDamage() + " dmg)"); // Show name and damage
            }

            System.out.print("Enter number: ");           // Prompt for choice
            String input = myScanner.next().trim();         // Read token and trim whitespace

            try {
                int choice = Integer.parseInt(input);     // Convert to integer
                if (choice >= 1 && choice <= moves.size()) { // Validate range
                    return moves.get(choice - 1);         // Return the selected move (1-based -> 0-based)
                }
            } catch (NumberFormatException ignored) {     // Handle non-numeric input gracefully
                // Fall through to "Invalid choice" message
            }

            System.out.println("Invalid choice. Try again."); // Feedback and loop again
        }
    }

}
