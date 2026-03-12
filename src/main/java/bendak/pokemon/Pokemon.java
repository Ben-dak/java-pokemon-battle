package bendak.pokemon;

import java.util.ArrayList;

public class Pokemon {
    private final String name;
    private final int maxHp;
    private int hp;
    private final ArrayList<Move> moves;

    public Pokemon(String name, int hp, ArrayList<Move> moves) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.moves = moves;
    }

    // Getter methods (encapsulation best-practice)
    public String getName() {
        return name; }      // Returns the Pokémon’s name
    public int getHp() {
        return hp; }             // Returns current HP
    public ArrayList<Move> getMoves() { return moves; } // Returns the move list

    public boolean isFainted() {
        return hp <= 0; }       // True if HP is 0 or below

    public void receiveDamage(int amount) {
        hp = Math.max(0, hp - Math.max(0, amount));
    }

    public void heal() {
        hp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public String toString() {
        return name; }    // For printing: show the name


}
