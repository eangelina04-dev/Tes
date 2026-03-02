public class Score {
    private int highScore = 0;

    public int calculateScore(int attempts, int difficulty) {
        int baseScore = Math.max(0, 100 - (attempts * 10));
        return baseScore + (difficulty * 100);
    }

    public void updateHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            System.out.println("New HighScore: " + highScore);
        }
    }

    public int getHighScore() {
        return highScore;
    }
}