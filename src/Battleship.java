import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Battleship {
    private static String[][] sea = new String[10][10];
    public static String[][] comp = new String[10][10];
    public static int userShips = 5;
    public static int compShips = 5;
/*    public static ArrayList<String> playerSea = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> compSea = new ArrayList<ArrayList<String>>(10); */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("****Welcome to Battleships Game****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        drawSea();
        System.out.println();
        System.out.println();
        System.out.println("Player 1 please prepare to deploy your ships: ");
        userShips();
        computerShips();
        battle();
    }

    public static void drawSea() {
        System.out.println("   0123456789");
        for (int i = 0; i < sea.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < sea[i].length; j++) {
                sea[i][j] = " ";
                System.out.print(sea[i][j]);
            }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println("   0123456789");
    }

    public static void printSea() {
        System.out.println("   0123456789");
        for (int i = 0; i < sea.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < sea[i].length; j++) {
                if (sea[i][j].equals("#")) {
                    System.out.print(" ");
                }
                else {
                    System.out.print(sea[i][j]);
                }
            }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println("   0123456789");
    }

 /*   public static void generateCompBoard() {
        for (int i = 0; i < comp.length; i++) {
//            System.out.print(i + " |");
            for (int j = 0; j < sea[i].length; j++) {
//                sea[i][j] = comp[i][j];
                comp[i][j] = " ";
//                System.out.print(comp[i][j]);
            }
//            System.out.print("| " + i);
//            System.out.println();
        }
    } */

 /*   public static void printCompSea() {
        System.out.println("   0123456789");
        for (int i = 0; i < comp.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < comp[i].length; j++) {
                System.out.print(comp[i][j]);
            }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println("   0123456789");
    } */

    public static void userShips() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter x coordinate for ship "+ (i+1));
            int x = input.nextInt();
            if (x < 0 || x > 9) {
                System.out.println("Invalid choice. Please enter a number from 0-9");
                x = input.nextInt();
            }
            System.out.println("Please enter a y coordinate for ship "+ (i+1));
            int y = input.nextInt();
            if (y < 0 || y > 9) {
                System.out.println("Invalid choice. Please enter a number from 0-9");
                y = input.nextInt();
            }
            sea[x][y] = "@";
        }
        System.out.println("The Player has deployed their ships!");
        printSea();
    }

    public static void computerShips() {
        Random r = new Random();
        System.out.println("The computer is deploying its ships");
        for (int i = 0; i < 5; i++) {
            int x = r.nextInt(10);
            int y = r.nextInt(10);
            sea[x][y] = "#";
            System.out.println("The computer has deployed ship "+ (i+1));
            while (!sea[x][y].equals(" ")) {
                x = r.nextInt(10);
                y = r.nextInt(10);
            }
        }
        System.out.println("The Computer has deployed its ships!");
        printSea();
    }

    public static void battle() {
        System.out.println("It's time for battle! Player, you will go first: ");

        while (compShips != 0 && userShips != 0) {
            userTurn();
            compTurn();
        }
        if (compShips == 0 && userShips > 0) {
            System.out.println("The Player has won the game with "+ userShips +" ships remaining.");
            System.out.println();
            System.out.println("Thanks for playing!");
        }
        else {
            System.out.println("Oh no! The Computer is victorious with "+ compShips +" ships remaining.");
            System.out.println();
            System.out.println("Better luck next time!");
        }
    }
    public static void userTurn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select an x coordinate for your guess: ");
        int px = input.nextInt();
        System.out.println("Please select a y coordinate for your guess: ");
        int py = input.nextInt();

        if (sea[px][py].equals("#")) {
            System.out.println("Direct hit! You have sunk one of the Computer's ships!");
            compShips--;
            System.out.println("The Computer has " + compShips + " ships left.");
            sea[px][py] = "!";
            printSea();
        } else if (sea[px][py].equals("@")) {
            System.out.println("Oh no! You sunk your own ship!");
            userShips--;
            System.out.println("Player has " + userShips + " ships left.");
            sea[px][py] = "X";
            printSea();
        } else if (sea[px][py].equals("!") || sea[px][py].equals("X") || sea[px][py].equals("-")) {
            System.out.println("These coordinates have already been checked!");
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Oops! It looks like you missed! Better luck next time.");
            sea[px][py] = "-";
            printSea();
        }
    }

    public static void compTurn() {
        Random n = new Random();
        System.out.println("It's time for the Computer to take their shot!");
        System.out.println();
        int x = n.nextInt(10);
        int y = n.nextInt(10);
        System.out.println("The computer chose (" + x + "," + y + ").");

        if (sea[x][y].equals("@")) {
            System.out.println("Direct hit! The Player has lost a ship!");
            userShips--;
            System.out.println("Player has " + userShips + " ships left.");
            sea[x][y] = "X";
            printSea();
        } else if (sea[x][y].equals("#")) {
            System.out.println("Oops! It looks like the Computer has hit its own ship!");
            compShips--;
            System.out.println("The Computer has " + compShips + " ships left.");
            sea[x][y] = "!";
            printSea();
        } else if (sea[x][y].equals("!") || sea[x][y].equals("X") || sea[x][y].equals("-")) {
            System.out.println("These coordinates have already been checked!");
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Oops! It looks like the Computer missed! Better luck next time.");
            sea[x][y] = "-";
            printSea();
        }
    }

}
