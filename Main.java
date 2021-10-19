/**
 * A:3 Simple game thing
 * @author Jordan Tucker
 *
 * The ability to place bets and fold has not been added yet.
 *
 */
class Main{

    /**
     * The amount of times you want to shuffle the deck.
     */
    public static final int SHUFFLE_COUNT = 1;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle(SHUFFLE_COUNT);
        Game game = new Game(deck);

        //System.out.println(deck.toString());

        // Start game
        game.start();

        // Start getting input from the players.
        game.playPlayers();

        Player winner = game.findWinner();
    }
}