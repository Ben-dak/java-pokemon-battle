package bendak.pokemon;

public class Battle {
    private final Pokemon player;
    private final Pokemon enemy;

    // Constructor
    public Battle(Pokemon player, Pokemon enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void applyAttack(Pokemon attacker, Pokemon defender, Move move) {
        defender.receiveDamage(move.getBaseDamage());   // calls defender’s method to apply damage equal to move’s base damage.
        System.out.println(attacker.getName() + " used " + move.getName() + "!"); // Battle log
    }

    public boolean isOver() {
        boolean result = false;

        if (player.isFainted()) {
            result = true;
        }
        if (enemy.isFainted()) {
            result = true;
        }
        return result;
    }    // Ends when isFainted = true for player or enemy

    public Pokemon getWinner() {
        if (player.isFainted()) {
            return enemy;
        } else {
            return player;
        }
    }     // Returns winning Pokémon

}
