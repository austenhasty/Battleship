import java.util.Scanner;

public class Battleship {
    private static String[][] sea = new String[10][10];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("****Welcome to Battleships Game****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        drawSea();


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


}
