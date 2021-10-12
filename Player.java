public class Player {

    private String name;
    private int bet;
    private Card card;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    /**
     * Set the players card
     * @param card The card you want to give them
     */
    public void setCard(Card card) {
        this.card = card;
    }

    public void viewCard(){
        System.out.println("You currently have: "+this.card.toString());
    }

    public Card getCard() {
        return card;
    }
}
