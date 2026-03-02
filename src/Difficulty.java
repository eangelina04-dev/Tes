public class Difficulty {

    private int maxNumber;

    public void setDifficulty(int level) {
        if (level == 1) maxNumber = 50;
        else if (level == 2) maxNumber = 100;
        else if (level == 3) maxNumber = 200;
    }

    public int generateNumber() {
        return (int) (Math.random() * maxNumber) + 1;
    }
}