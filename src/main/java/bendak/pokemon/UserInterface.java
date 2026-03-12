public class UserInterface {
    public class UserInterface {
        private final Scanner scanner = new Scanner(System.in);

        public void start() {
            // setup fixed battle per your spec:
            Pokemon gengar = /* ...HP, moves... */;
            Pokemon nidorino = /* ...HP, moves... */;
            Battle battle = new Battle(gengar, nidorino);

            System.out.println("A wild Nidorino appeared!");
            System.out.println("Go! Gengar!");

            while (!battle.isOver()) {
                showStatus(gengar, nidorino);
                Move chosen = promptForMove(gengar.getMoves()); // while/switch work
                battle.applyAttack(gengar, nidorino, chosen);
                if (battle.isOver()) break;

                // Simple enemy choice: pick first available move for now
                battle.applyAttack(nidorino, gengar, nidorino.getMoves()[0]);
            }
            System.out.println("Winner: " + battle.getWinner().getName());
        }

        private Move promptForMove(Move[] moves) {
            // loop until valid; use equals() for String checks where needed
            // and handle Scanner line issues per workbook guidance.
        }
    }
}
