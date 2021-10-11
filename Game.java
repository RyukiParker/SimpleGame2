import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    public Game(){

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
        this.generatePlayers(playerCount);
    }

    /**
     * Creates each player and adds them to the games player list.
     * @param playerCount The amount of players.
     */
    private void generatePlayers(int playerCount){
        for(int i = 0; i<playerCount; i++){
            System.out.println("Please enter a name for player "+(i+1)+": ");
            Scanner userIn = new Scanner(System.in);

            Player player = new Player(userIn.next());

            this.players.add(player);

        }
    }
}
