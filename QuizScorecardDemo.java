class Scorecard {
    private final boolean[] answers;
    private final int totalQuestions;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.answers = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount >= totalQuestions) {
            System.out.println("Rejected: All " + totalQuestions + " questions have already been recorded.");
            return;
        }
        answers[recordedCount] = isCorrect;
        recordedCount++;
    }

    public int getScore() {
        int correctCount = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }
}

public class QuizScorecardDemo {

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Total Score: " + sc.getScore());
    }
}