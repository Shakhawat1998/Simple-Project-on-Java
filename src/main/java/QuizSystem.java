import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class QuizSystem {
    public static void adminMenu(Scanner scanner) throws IOException {
        while (true) {
            System.out.println("System: Please create new questions in the question bank.");
            System.out.println("System:> Input your question: ");
            String questionText = scanner.nextLine();

            System.out.println("System: Input option 1: ");
            String option1 = scanner.nextLine();
            System.out.println("System: Input option 2: ");
            String option2 = scanner.nextLine();
            System.out.println("System: Input option 3: ");
            String option3 = scanner.nextLine();
            System.out.println("System: Input option 4: ");
            String option4 = scanner.nextLine();

            System.out.println("System: What is the answer key? ");
//          int answerKey = Integer.parseInt(scanner.nextLine());
            String answerKey = scanner.nextLine();

            JSONObject question = new JSONObject();
            question.put("question", questionText);
            question.put("option 1", option1);
            question.put("option 2", option2);
            question.put("option 3", option3);
            question.put("option 4", option4);
            question.put("answerkey", answerKey);

            FileSystem.addQuestion(question);

            System.out.println("System:> Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
        }
    }

    public static void studentQuiz(Scanner scanner) {
        System.out.println("System:> Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' for start.");
        String start = scanner.nextLine();

        if (start.equalsIgnoreCase("s")) {
            JSONArray questions = FileSystem.getQuestions();

            int[] index = new int[questions.size()];
            for (int i = 0; i < questions.size(); i++) {
                index[i] = i;
            }
            Random random = new Random();
            for (int i = 0; i < index.length; i++) {
                int j = random.nextInt(i + 1);
                int temp = index[i];
                index[i] = index[j];
                index[j] = temp;
            }

            int score = 0;

            for (int i = 0; i < Math.min(10, index.length); i++) {
                JSONObject q = (JSONObject) questions.get(index[i]);
                System.out.println("[Question " + (i + 1) + "] " + q.get("question"));
                System.out.println("1. " + q.get("option 1"));
                System.out.println("2. " + q.get("option 2"));
                System.out.println("3. " + q.get("option 3"));
                System.out.println("4. " + q.get("option 4"));

                System.out.print("Student:> ");

                try {
                    String answer = scanner.nextLine();
                    String correctAnswer = q.get("answerkey").toString();

                    if (answer.equals(correctAnswer)) {
                        score++;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, moving to next question.");
                }

            }

            displayResult(score, scanner);
        }
    }

    private static void displayResult(int score, Scanner scanner) {
        if (score >= 8) {
            System.out.println("Excellent! You have got " + score + " out of 10");
        } else if (score >= 5) {
            System.out.println("Good. You have got " + score + " out of 10");
        } else if (score >= 2) {
            System.out.println("Very poor! You have got " + score + " out of 10");
        } else {
            System.out.println("Very sorry you are failed. You have got " + score + " out of 10");
        }

        System.out.println("Would you like to start again? Press 's' for start or 'q' for quit");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("s")) {
            studentQuiz(scanner);
        }
    }
}
