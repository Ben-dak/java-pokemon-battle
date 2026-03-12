package bendak.pokemon;

public class Player {
    private final String name;
    private final Pokemon pokemon;

    public Player(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
