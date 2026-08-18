import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of subjects
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int total = 0;

        // Take marks for each subject
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();

            total = total + marks;
        }

        // Calculate average percentage
        double average = (double) total / subjects;

        // Calculate grade
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n----- RESULT -----");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}


OUTPUT

  Enter number of subjects: 5
Enter marks for subject 1: 72
Enter marks for subject 2: 85
Enter marks for subject 3: 91
Enter marks for subject 4: 87
Enter marks for subject 5: 89

----- RESULT -----
Total Marks: 424
Average Percentage: 84.8%
Grade: B

