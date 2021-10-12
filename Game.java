import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Card>  deck =  new ArrayList<Card>();
    private final Suite[] suites = new Suite[]{Suite.CLUB, Suite.DIAMOND, Suite.HEART, Suite.SPADE};

    /**
     * This constructor will populate the deck.
     */
    public Game(){
        for (int i = 0; i<4; i++){
            for(int j = 0; j <13; j++){
                deck.add(new Card(j,suites[i]));
            }
        }
    }

    public void debugCards(){
        deck.forEach(card ->{
            System.out.println(card);
        });
    }
    public void start(){
        int playerCount = 0;

        while (!(playerCount > 0 && playerCount <= 52)){
            Scanner userIn = new Scanner(System.in);

            System.out.print("How many people are playing? ");

            // Make sure the character the user enters ins an int
            if(userIn.hasNextInt()){
                playerCount = userIn.nextInt();
            }else{
                // Repeat the loop if there is no int
                System.out.println("Please input a valid integer!");
                continue;
            }

            // Check to make sure there are no more players than the amount of cards.
            if(playerCount == 0 || playerCount > 52){
                System.out.println("There must be at least one player and no more than fifty-two players!");
            }
        }
        System.out.println();
        this.registerPlayers(playerCount);
        this.playPlayers();
        this.findWinner();
    }

    /**
     * Finds the person with the highest card.
     */
    public void findWinner(){
        Card high = this.players.get(0).getCard();
        Player winner = this.players.get(0);

        for(int i = 1; i<this.players.size(); i++){
            Player player = this.players.get(i);
            if(player.getCard().getValue() > high.getValue()){
                high = player.getCard();
                winner = player;
            }
        }

        System.out.println();
        System.out.println(winner.getName()+" won with a "+high.toString()+"!");

    }

    /**
     * Creates each player and adds them to the games player list.
     * @param playerCount The amount of players.
     */
    private void registerPlayers(int playerCount){
        for(int i = 0; i<playerCount; i++){
            System.out.print("Please enter a name for player "+(i+1)+": ");
            Scanner userIn = new Scanner(System.in);

            Player player = new Player(userIn.next());
            Random rand = new Random();
            Card card = deck.get(rand.nextInt(deck.size()));
            player.setCard(card);
            deck.remove(card);
            this.players.add(player);

        }
    }

    public void playPlayers(){
        this.players.forEach(player -> {
            Scanner userIn = new Scanner(System.in);
            System.out.println(player.getName()+", it is your turn!");

            boolean isPlaying = true;

            while (isPlaying){
                System.out.print("Your options are to (b)et, (v)iew card, (c)ontinue to next player, or (f)old: ");

                char response = userIn.next().charAt(0);

                switch (response){
                    case 'b':
                        System.out.print("Betting");
                        break;
                    case 'v':
                        player.viewCard();
                        break;
                    case 'c':
                        isPlaying = false;
                        break;
                    case 'f':
                        System.out.print("Folding");
                        break;
                    default:
                        System.out.println("Please enter \"b\" for betting, \"v\" for viewing your card, \"c\" to continue to the next player, or \"f\" for folding.");
                        break;
                }
            }

            // Crappy way to prevent players from seeing other players cards.
            for(int i = 0; i<50; i++){
                System.out.println("-");
            }
        });
    }
}
