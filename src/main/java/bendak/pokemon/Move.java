package bendak.pokemon;

public class Move {                               // Represents a single attack move
    private final String name;                    // Move name (immutable)
    private final int baseDamage;                 // Base damage value (immutable)

    public Move(String name, int baseDamage) {    // Constructor for a move
        this.name = name;                         // Initialize move name
        this.baseDamage = baseDamage;             // Initialize damage
    }

    public String getName() {
        return name; }      // Read move name
    public int getBaseDamage() {
        return baseDamage; } // Read damage amount
}

