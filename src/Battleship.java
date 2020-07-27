import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Battleship {
    private static String[][] sea = new String[10][10];
    public static String[][] comp = new String[10][10];
//    public static ArrayList<String> playerSea = new ArrayList<String>();
//    public static ArrayList<ArrayList<String>> compSea = new ArrayList<ArrayList<String>>(10);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("****Welcome to Battleships Game****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        drawSea();
//        generateCompBoard();
        System.out.println();
        System.out.println();
        System.out.println("Player 1 please prepare to deploy your ships: ");
        userShips();
        computerShips();
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
                System.out.print(sea[i][j]);
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

    }

}
