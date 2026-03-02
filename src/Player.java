import java.util.Scanner;

public class Player {
    private int attempts = 0;
    private final Scanner scanner = new Scanner(System.in);

    public int guessNumber() {
        System.out.print("Enter your guess: ");
        attempts++;
        return scanner.nextInt();
    }

    public int getAttempts() {
        return attempts;
    }

    public void resetAttempts() {
        attempts = 0;
    }
}