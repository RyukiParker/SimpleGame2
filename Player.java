import java.util.Scanner;

public class Player {

    private String name;
    private int balance = 1000;
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

    public int getBet(){
      Scanner userIn = new Scanner(System.in);
      while(true){
        System.out.print("Your balance is $"+this.balance+". How much would you like to bet? ");
        if(userIn.hasNextInt()){
          int bet = userIn.nextInt();
          if(this.balance >= bet){
            this.balance -= bet;
            return bet;
          }else{
            System.out.println("Sorry, you don't have enough money for that bet.");
            return 0;
          }

        }else{
          System.out.println("Please input an integer.");
        }
      }
    }
}
