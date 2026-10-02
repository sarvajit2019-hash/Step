import java.util.Scanner;

public class ExaminationQuestionGrader {

    static abstract class Question {
        String questionText;
        String correctAnswer;
        String studentAnswer;
        double points;

        Question(String questionText, String correctAnswer, String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double grade();
    }

    static class MCQ extends Question {
        MCQ(String q, String correct, String student, double points) {
            super(q, correct, student, points);
        }

        double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class TrueFalse extends Question {
        TrueFalse(String q, String correct, String student, double points) {
            super(q, correct, student, points);
        }

        double grade() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class Essay extends Question {
        Essay(String q, String correct, String student, double points) {
            super(q, correct, student, points);
        }

        double grade() {
            String[] keywords = correctAnswer.split(",");
            int found = 0;

            String answer = studentAnswer.toLowerCase();

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase()))
                    found++;
            }

            if (found >= 2)
                return points * 0.75;
            if (found == 1)
                return points * 0.50;
            return 0;
        }
    }

    static String[] parseFields(String line) {
        java.util.ArrayList<String> fields = new java.util.ArrayList<>();
        java.util.regex.Matcher matcher =
                java.util.regex.Pattern.compile(""([^"]*)"").matcher(line);

        while (matcher.find())
            fields.add(matcher.group(1));

        String type = line.substring(0, line.indexOf(' '));
        String remaining = line.substring(line.lastIndexOf('"') + 1).trim();

        fields.add(0, type);
        fields.add(remaining);

        return fields.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();
        sc.nextLine();

        Question[] questions = new Question[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] fields = parseFields(line);

            String type = fields[0];
            String questionText = fields[1];
            String correctAnswer = fields[2];
            String studentAnswer = fields[3];
            double points = Double.parseDouble(fields[4]);

            if (type.equals("MCQ"))
                questions[i] = new MCQ(questionText, correctAnswer, studentAnswer, points);
            else if (type.equals("TF"))
                questions[i] = new TrueFalse(questionText, correctAnswer, studentAnswer, points);
            else
                questions[i] = new Essay(questionText, correctAnswer, studentAnswer, points);
        }

        for (Question question : questions) {
            double score = question.grade();
            total += score;
            System.out.printf("%s: %.2f%n", question.getClass().getSimpleName(), score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}