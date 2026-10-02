import java.util.Scanner;

public class QuizScorecard {
    private boolean[] results;
    private final int totalQuestions;
    private int recordedAnswers;

    public QuizScorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
        recordedAnswers = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedAnswers < totalQuestions) {
            results[recordedAnswers] = correct;
            recordedAnswers++;
        } else {
            System.out.println("Answer rejected: question limit reached");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < recordedAnswers; i++) {
            if (results[i])
                score++;
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();

        QuizScorecard scorecard = new QuizScorecard(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Answer " + (i + 1) + " correct? (true/false): ");
            scorecard.recordAnswer(sc.nextBoolean());
        }

        System.out.println("Final score: " + scorecard.getScore());
    }
}