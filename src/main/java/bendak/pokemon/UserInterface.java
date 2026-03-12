package bendak.pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner = new Scanner(System.in);

    public void start() {
        System.out.println("You find yourself in the mystical region of Kanto!");
        System.out.print("What is your name: ");
        String playerName = myScanner.nextLine().trim();

        ArrayList<Move> gengarMoves = new ArrayList<>();
        gengarMoves.add(new Move("Shadow Ball", 30));
        gengarMoves.add(new Move("Lick", 10));
        gengarMoves.add(new Move("Dream Eater", 40));
        gengarMoves.add(new Move("Night Shade", 20));

        Pokemon gengar = new Pokemon("Gengar", 100, gengarMoves);
        Player player = new Player(playerName, gengar);

        System.out.println();
        System.out.println("Welcome to Kanto, " + player.getName() + "!");

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("Where would you like to go?");
            System.out.println("1) Tall Grass");
            System.out.println("2) Pokemon Center");
            System.out.println("3) Quit");
            System.out.print("Enter number: ");

            String input = myScanner.nextLine().trim();

            switch (input) {
                case "1":
                    battleStart(player);
                    break;
                case "2":
                    visitPokemonCenter(player);
                    break;
                case "3":
                    System.out.println("Thanks for playing, " + player.getName() + "!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void battleStart(Player player) {
        Pokemon playerPokemon = player.getPokemon();

        ArrayList<Move> nidorinoMoves = new ArrayList<>();
        nidorinoMoves.add(new Move("Horn Attack", 25));
        nidorinoMoves.add(new Move("Take Down", 60));
        nidorinoMoves.add(new Move("Poison Sting", 15));
        nidorinoMoves.add(new Move("Double Kick", 30));

        Pokemon nidorino = new Pokemon("Nidorino", 100, nidorinoMoves);

        Battle battle = new Battle(playerPokemon, nidorino);

        System.out.println();
        System.out.println("A wild Nidorino appeared!");
        System.out.println("Go! " + playerPokemon.getName() + "!");

        while (!battle.isOver()) {
            showStatus(playerPokemon, nidorino);

            Move chosen = promptForMove(playerPokemon.getMoves());

            battle.applyAttack(playerPokemon, nidorino, chosen);

            if (battle.isOver()) break;

            Collections.shuffle(nidorinoMoves);
            Move enemyMove = nidorinoMoves.get(0);
            battle.applyAttack(nidorino, playerPokemon, enemyMove);
        }

        System.out.println();
        System.out.println("Winner: " + battle.getWinner().getName());
    }

    private void visitPokemonCenter(Player player) {
        System.out.println();
        System.out.println("Welcome to the Pokemon Center!");
        player.getPokemon().heal();
        System.out.println("Your " + player.getPokemon().getName() + " has been fully healed!");
        System.out.println(player.getPokemon().getName() + " HP: " + player.getPokemon().getHp() + "/" + player.getPokemon().getMaxHp());
    }

    private void showStatus(Pokemon p1, Pokemon p2) {
        System.out.println(p1.getName() + " HP: " + p1.getHp() + " | " + p2.getName() + " HP: " + p2.getHp());
    }

    private Move promptForMove(List<Move> moves) {
        while (true) {
            System.out.println("=== Choose an attack ===");
            for (int i = 0; i < moves.size(); i++) {
                System.out.println((i + 1) + ") " + moves.get(i).getName()
                        + " (" + moves.get(i).getBaseDamage() + " dmg)");
            }

            System.out.print("Enter number: ");
            String input = myScanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= moves.size()) {
                    return moves.get(choice - 1);
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Invalid choice. Try again.");
        }
    }
}
