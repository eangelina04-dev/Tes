import java.util.Scanner;

public class Game {
    private final Difficulty difficulty = new Difficulty();
    private final Player player = new Player();
    private final Score score = new Score();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean playAgain;

        do {
            System.out.println("Welcome to Guess The Number!");
            System.out.println("High Score: " + score.getHighScore());
            System.err.println("Level 1 = 1-50");
            System.err.println("Level 2 = 1-100");
            System.err.println("Level 3 = 1-200");
            int level = chooseDifficulty();
            difficulty.setDifficulty(level);
            int numberToGuess = difficulty.generateNumber();

            playRound(numberToGuess, level);

            playAgain = askPlayAgain();

        } while (playAgain);
    }

    private int chooseDifficulty() {
        int level;
        do {
            System.out.print("Choose difficulty (1-3): ");
            level = scanner.nextInt();
        } while (level < 1 || level > 3);
        return level;
    }

    private void playRound(int numberToGuess, int level) {
        player.resetAttempts();
        int guess;

        do {
            guess = player.guessNumber();

            if (guess < numberToGuess)
                System.out.println("Too low!");
            else if (guess > numberToGuess)
                System.out.println("Too high!");
            else {
                System.out.println("Correct!");
                int finalScore = score.calculateScore(player.getAttempts(), level);
                System.out.println("Your score: " + finalScore);
                score.updateHighScore(finalScore);
            }

        } while (guess != numberToGuess);
    }

   private boolean askPlayAgain() {
        int newGame;

        do {
            System.out.println("Do you want to play again? ");
            System.out.println("1 = yes ");
            System.out.println("2 = no ");
            System.out.print("Enter your choice: ");

            newGame = scanner.nextInt();

            if (newGame == 1) return true;
            if (newGame == 2) return false;

        } while (true);
    }
}