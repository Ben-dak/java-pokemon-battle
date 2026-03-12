package bendak.pokemon;

import java.util.ArrayList;

public class Pokemon {                            // Represents a Pokémon with a name, HP, and moves
    private final String name;                    // Immutable Pokémon name
    private int hp;                               // Current hit points (mutable)
    private final ArrayList<Move> moves;          // List of available moves (immutable reference)

    // Constructor: sets up a Pokémon's initial state
    public Pokemon(String name, int hp, ArrayList<Move> moves) {
        this.name = name;                         // Initialize name
        this.hp = hp;                             // Initialize HP
        this.moves = moves;                       // Store reference to provided moves list
    }

    // Getter methods (encapsulation best-practice)
    public String getName() {
        return name; }      // Returns the Pokémon’s name
    public int getHp() {
        return hp; }             // Returns current HP
    public ArrayList<Move> getMoves() { return moves; } // Returns the move list

    public boolean isFainted() {
        return hp <= 0; }       // True if HP is 0 or below

    public void receiveDamage(int amount) {              // Reduces HP by non-negative damage
        hp = Math.max(0, hp - Math.max(0, amount));     // Prevents negative damage and negative HP
    }

    @Override
    public String toString() {
        return name; }    // For printing: show the name


}
