import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApplication {

    static Scanner sc = new Scanner(System.in);

    static String[] questions = {
        "Which language is used for Android development?",
        "Which keyword is used to create a class in Java?",
        "Which of these is not a programming language?",
        "What is the size of an int in Java?"
    };

    static String[][] options = {
        {"1. Java", "2. HTML", "3. CSS", "4. SQL"},
        {"1. function", "2. class", "3. define", "4. new"},
        {"1. Python", "2. Java", "3. HTML", "4. C++"},
        {"1. 2 bytes", "2. 4 bytes", "3. 8 bytes", "4. 16 bytes"}
    };

    static int[] correctAnswers = {1, 2, 3, 2};

    public static void main(String[] args) {

        int score = 0;
        int correct = 0;
        int incorrect = 0;

        System.out.println("=================================");
        System.out.println("       QUIZ APPLICATION");
        System.out.println("=================================");
        System.out.println("You have 10 seconds for each question.\n");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("---------------------------------");
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (1-4): ");

            ExecutorService executor = Executors.newSingleThreadExecutor();

            Future<String> future = executor.submit(() -> sc.nextLine());

            try {
                String answer = future.get(10, TimeUnit.SECONDS);

                int selectedAnswer;

                try {
                    selectedAnswer = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    selectedAnswer = -1;
                }

                if (selectedAnswer == correctAnswers[i]) {
                    System.out.println("Correct Answer!");
                    score++;
                    correct++;
                } else {
                    System.out.println("Incorrect Answer!");
                    System.out.println(
                        "Correct answer: " + correctAnswers[i]
                    );
                    incorrect++;
                }

            } catch (TimeoutException e) {

                System.out.println("\nTime's up!");
                System.out.println(
                    "Correct answer: " + correctAnswers[i]
                );
                incorrect++;

            } catch (Exception e) {

                System.out.println("An error occurred.");

            } finally {
                executor.shutdownNow();
            }
        }

        System.out.println("\n=================================");
        System.out.println("          QUIZ RESULT");
        System.out.println("=================================");

        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + correct);
        System.out.println("Incorrect Answers : " + incorrect);
        System.out.println("Final Score     : " + score + "/" + questions.length);

        double percentage =
                ((double) score / questions.length) * 100;

        System.out.println("Percentage      : " + percentage + "%");

        if (percentage >= 80) {
            System.out.println("Result: Excellent!");
        } else if (percentage >= 50) {
            System.out.println("Result: Good Job!");
        } else {
            System.out.println("Result: Keep Practicing!");
        }

        System.out.println("=================================");
    }
}


Output
=================================
       QUIZ APPLICATION
=================================
You have 10 seconds for each question.

---------------------------------
Question 1: Which language is used for Android development?
1. Java
2. HTML
3. CSS
4. SQL
Enter your answer (1-4): 1
Correct Answer!
---------------------------------
Question 2: Which keyword is used to create a class in Java?
1. function
2. class
3. define
4. new
Enter your answer (1-4): 3
Incorrect Answer!
Correct answer: 2
---------------------------------
Question 3: Which of these is not a programming language?
1. Python
2. Java
3. HTML
4. C++
Enter your answer (1-4): 2
Incorrect Answer!
Correct answer: 3
---------------------------------
Question 4: What is the size of an int in Java?
1. 2 bytes
2. 4 bytes
3. 8 bytes
4. 16 bytes
Enter your answer (1-4): 1
Incorrect Answer!
Correct answer: 2

=================================
          QUIZ RESULT
=================================
Total Questions : 4
Correct Answers : 1
Incorrect Answers : 3
Final Score     : 1/4
Percentage      : 25.0%
Result: Keep Practicing!
=================================
