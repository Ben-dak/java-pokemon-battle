public class Battle {
    private Pokemon player;
    private Pokemon enemy;

    public void applyAttack(Pokemon attacker, Pokemon defender, Move move) {
        // later: randomness/crit; for now, subtract baseDamage
        defender.receiveDamage(move.getBaseDamage());
    }
    public boolean isOver() { return player.isFainted() || enemy.isFainted(); }
    public Pokemon getWinner() { return player.isFainted() ? enemy : player; }
}
