package BattleShipDAO;

import BattleShipDAO.BattleShipModules.BattleShipBoard;
import BattleShipDAO.BattleShipModules.RulesOfTheGame;
import BattleShipDAO.BattleShipModules.Targeting;
import BattleShipDAO.BattleShipModules.WarShips;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BattleShipActivity {

    private BattleShipBoard battleShipBoard;

    private WarShips warShips;

    private Targeting targeting;

    public BattleShipActivity() {

    }

    public BattleShipActivity(BattleShipBoard battleShipBoard, WarShips warShips, Targeting targeting) {
        this.battleShipBoard = battleShipBoard;
        this.warShips = warShips;
        this.targeting = targeting;
    }

    // Method that Introduces the player on the rules and game play.
    public void introduceTheGame() throws InterruptedException {
        Scanner player = new Scanner(System.in);
        RulesOfTheGame rulesOfTheGame = new RulesOfTheGame();
        int playerChoice;
        String nameOfUser = null;
        boolean userLeftItEmpty = true;

        // The User will name themselves... if empty, will print out a message saying they will need to try again.
        while (userLeftItEmpty) {
            System.out.println("\nPlease type in a name");
            nameOfUser = UserInputHelper.getStringUserInput();
            if (nameOfUser.isEmpty()) {
                System.out.println("Sorry it seems you didn't put anything in, Try again.");
                TimeUnit.SECONDS.sleep(1);
            } else {
                userLeftItEmpty = false;
            }
        }

        do {
            System.out.println("\nHello " + nameOfUser + " and welcome! This game is called Battleship and your goal is to destroy your enemy." +
                    "\n --------------------------------------" +
                    "\n 1: Rules of the Game." +
                    "\n 2: Play the Game." +
                    "\n -------------------------------------" +
                    "\n Please make your choice");
            playerChoice = player.nextInt();

            switch (playerChoice) {
                // This case will show the player the rules of the game.
                case 1:
                    rulesOfTheGame.Rules();
                    System.out.println("\nWhen you are ready to go back to the main menu any key.");
                    UserInputHelper.getStringUserInput();
                    break;
                case 2:
                    // This will start the game and wish the player good luck!
                    System.out.println("Good luck player! May your shots be in your favor.");
                    TimeUnit.SECONDS.sleep(5);
                    break;
                // Let the player know they can not make this selection
                default:
                    System.out.println("I am sorry, but option " + playerChoice + " is not an option. Try again.");
            }
        } while (playerChoice != 2);
    }


    // Method that sets up the board
    public void setUpTheBoard(BattleShipBoard battleShipBoard) {
        int rows = 0;
        int columns = 0;
        //       int[] numbers = new int[10];
        //     int[] letters = new int[10];
        // private String fogOfWar = "?"; // warships
        for (rows = 0; rows < 10; rows++) { // represents the letters on the board
            for (columns = 0; columns < 10; columns++) { // represents the numbers on the board.
                battleShipBoard.getNumbers()[rows] = -1;
                battleShipBoard.getLetters()[columns] = -1;
                // -1 will be unknown, 0 is a miss and 1 is a hit.
                // I will need to add a fogOfWar to each number in the number array;
                // each letter should have 10 numbers in it.
                // each one of hardcoded for 10, so it won't go out of bounds.
                // After the iteration is done, print the grid out.
            }
        }
        System.out.println("\t A \tB \tC \tD \tE \tF \tG \tH \tI \tJ");
        System.out.println("\t1" +
                "\n\t2" +
                "\n\t3" +
                "\n\t4" +
                "\n\t5" +
                "\n\t6" +
                "\n\t7" +
                "\n\t8" +
                "\n\t9" +
                "\n\t10");
    }

    // Method that places the warShips // Randomly at this time, just can't be on top of each other ??? possible Nodes?.
    public void placementOfWarships() {

    }

    // Method that lets the player choose where to fire, letting them choose a column and row... possible instructions on this.
    // This Method will need a way to let the player they sunk a ship // TODO will I need to return something?
    public void targetTheWarShips() {

    }

    // Method for when the game ends with either player losing all their ships // Give them an option to go again?
    public void gameOver() {

    }

}
