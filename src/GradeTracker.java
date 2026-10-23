import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Only running totals and counters are stored (no arrays)
        double assignmentPoints = 0;
        int assignmentCount = 0;
        double examPoints = 0;
        int examCount = 0;

        int choice = 0;

        while (choice != 4) {
            System.out.println("===== SEMESTER GRADE TRACKER =====");
            System.out.println();
            System.out.println("1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid option. Please choose from 1 to 4.");
                System.out.println();
                continue;
            }
            choice = scanner.nextInt();
            System.out.println();

            if (choice == 1 || choice == 2) {
                if (choice == 1) {
                    System.out.print("Enter assignment score: ");
                } else {
                    System.out.print("Enter exam score: ");
                }

                if (!scanner.hasNextDouble()) {
                    scanner.next();
                    System.out.println();
                    System.out.println("Invalid score. Enter a value from 0 to 100.");
                    System.out.println();
                    continue;
                }
                double score = scanner.nextDouble();
                System.out.println();

                if (score < 0 || score > 100) {
                    System.out.println("Invalid score. Enter a value from 0 to 100.");
                    System.out.println();
                    continue; // totals and counters unchanged
                }

                if (choice == 1) {
                    assignmentPoints += score;
                    assignmentCount++;
                    System.out.println("Assignment score added.");
                } else {
                    examPoints += score;
                    examCount++;
                    System.out.println("Exam score added.");
                }
                System.out.println();

            } else if (choice == 3) {
                if (assignmentCount == 0 && examCount == 0) {
                    System.out.println("No results available yet.");
                    System.out.println();
                    continue;
                }

                double assignmentAverage = 0;
                double examAverage = 0;
                if (assignmentCount > 0) {
                    assignmentAverage = assignmentPoints / assignmentCount;
                }
                if (examCount > 0) {
                    examAverage = examPoints / examCount;
                }

                double overallAverage;
                String note = "";
                if (assignmentCount > 0 && examCount > 0) {
                    overallAverage = assignmentAverage * 0.50 + examAverage * 0.50;
                } else if (assignmentCount > 0) {
                    overallAverage = assignmentAverage;
                    note = "Note: No exam results yet. Overall average is based on assignments only.";
                } else {
                    overallAverage = examAverage;
                    note = "Note: No assignment results yet. Overall average is based on exams only.";
                }

                String grade;
                if (overallAverage >= 90) {
                    grade = "A";
                } else if (overallAverage >= 80) {
                    grade = "B";
                } else if (overallAverage >= 70) {
                    grade = "C";
                } else if (overallAverage >= 60) {
                    grade = "D";
                } else {
                    grade = "F";
                }
                String status;
                if (overallAverage >= 60) {
                    status = "Passing";
                } else {
                    status = "Failing";
                }

                System.out.println("===== CURRENT RESULTS =====");
                System.out.println();
                System.out.println("Assignments completed: " + assignmentCount);
                if (assignmentCount > 0) {
                    System.out.printf("Assignment average: %.1f%n", assignmentAverage);
                } else {
                    System.out.println("Assignment average: no results yet");
                }
                System.out.println();
                System.out.println("Exams completed: " + examCount);
                if (examCount > 0) {
                    System.out.printf("Exam average: %.1f%n", examAverage);
                } else {
                    System.out.println("Exam average: no results yet");
                }
                System.out.println();
                System.out.printf("Overall average: %.1f%n", overallAverage);
                System.out.println("Grade: " + grade);
                System.out.println("Status: " + status);
                if (!note.isEmpty()) {
                    System.out.println();
                    System.out.println(note);
                }
                System.out.println();

            } else if (choice == 4) {
                System.out.println("Grade tracker closed.");

            } else {
                System.out.println("Invalid option. Please choose from 1 to 4.");
                System.out.println();
            }
        }

        scanner.close();
    }
}