import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
    }

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */

    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        HandSign computerMove = null; 

        // code using n to select
        // a HandSign
        if (n == 0){
            computerMove = HandSign.ROCK;
        } else if (n == 1) {
            computerMove = HandSign.PAPER;
        } else if (n == 2) {
            computerMove = HandSign.SCISSORS;
        }


        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = true;
        HandSign playerHandSign = null;
        do {// repeat until valid input
            validInput = true;

            // Add your code to give some description about what input the
            //  users are supposed to give
            System.out.println("ROCK (r), PAPER (p), SCISSORS (s) or QUIT (q)?\n");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            //outputs players hand
            switch(inChar){
                case 'r':
                    playerHandSign = HandSign.ROCK;
                    break;
                case 'p':
                    playerHandSign = HandSign.PAPER;
                    break;
                case 's':
                    playerHandSign = HandSign.SCISSORS;
                    break;
                case 'q':
                    System.out.println("GAME OVER");
                    break;
                default:
                    validInput = false;
            }

        } while(!validInput);
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2){
        int winner = 0; 

        if (h1.equals(h2)){
            winner = 0;
        } else if (h1 == HandSign.ROCK){
            if (h2 == HandSign.PAPER){
                winner = -1;
            }
            else if (h2 == HandSign.SCISSORS){
                winner = 1;
            }
        } else if (h1 == HandSign.PAPER){
            if (h2 == HandSign.SCISSORS){
                winner = -1;
            }
            else if (h2 == HandSign.ROCK){
                winner = 1;
            }
        } else if (h1 == HandSign.SCISSORS){
            if (h2 == HandSign.ROCK){
                winner = -1;
            }
            else if (h2 == HandSign.PAPER){
                winner = 1;
            }
        }

        return winner;
    }
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;// player’s sign from keyboard
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver){
            // repeat this process till the user quits
            //Step1: Get the player move from the keyboard input
            playerMove = getPlayerMove();

            if (playerMove == null){
                gameOver = true;
            }

            if (gameOver == false){
                //Step2: Get the computer’s move (randomly generated)
                computerMove = getComputerMove();

                //Step3: Check who wins
                checkwin = whoWins(playerMove,computerMove);

                //Step4: Output who played what and who won the round
                System.out.println("Players move: "+playerMove);
                System.out.println("Computers move:"+ computerMove);
                if (checkwin == 0){
                    System.out.println("DRAW");
                } else if (checkwin == -1){
                    System.out.println("COMPUTER WINS");
                    computerScore += 1;
                } else if (checkwin == 1){
                    System.out.println("PLAYER WINS");
                    playerScore += 1;
                }

                //Step5: Update and print player/computer scores
                System.out.println("Players score:" + playerScore);
                System.out.println("Computers score:" + computerScore);
            }
        }
    }
}
