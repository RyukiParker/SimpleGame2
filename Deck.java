import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();

    /**
     * Construct a new deck and populate it with cards
     */
    public Deck(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(j, Suite.values()[i]));
            }
        }
    }

    /**
     * Shuffles the cards in the deck.
     * @param times The amount of times you want the cards shuffled.
     */
    public void shuffle(int times){
        for(int i = 0; i < times; i++){
            // Found this useful method! I am very lazy!
            Collections.shuffle(this.deck);
        }
    }

    /**
     * Pulls a random card from the deck.
     * @return The random card pulled.
     */
    public Card getRandomCard(){
        Random rand = new Random();
        Card card = deck.get(rand.nextInt(deck.size()));
        deck.remove(card);
        return card;
    }

    /**
     * Prints all the cards in the deck to make sure they're all there!
     */
    public void debugCards() {
        deck.forEach(card -> {
            System.out.println(card);
        });
    }
}
