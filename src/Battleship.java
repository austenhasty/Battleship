import java.util.Scanner;

public class Battleship {
    private static String[][] sea = new String[10][10];
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
    }

    public static void drawSea() {
        System.out.println("   0123456789");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++) {
                sea[i][j] = " ";
                System.out.print(sea[i][j]);
            }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println("   0123456789");
    }

    public static void userShips() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter x coordinate for ship "+ i+1);
            int x = input.nextInt();
            if (x < 0 || x > 9) {
                System.out.println("Invalid choice. Please enter a number from 0-9");
                x = input.nextInt();
            }
            System.out.println("Please enter a y coordinate for ship "+ i+1);
            int y = input.nextInt();
            if (y < 0 || y > 9) {
                System.out.println("Invalid choice. Please enter a number from 0-9");
                y = input.nextInt();
            }
            sea[x][y] = "@"
        }
        System.out.println("The Player has deployed their ship!");
        drawSea();
    }


}
