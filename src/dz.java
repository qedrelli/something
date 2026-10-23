import java.util.Scanner;

public class dz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int socialTime = 0;
        int gamingTime = 0;
        int studyingTime = 0;
        int streamingTime = 0;
        int totalScreenTime = 0;
        int sessionCount = 0;

        int choice = 0;

        while (choice != 6) {
            System.out.println("===== SCREEN-TIME TRACKER =====");
            System.out.println();
            System.out.println("1. Add social media time");
            System.out.println("2. Add gaming time");
            System.out.println("3. Add studying time");
            System.out.println("4. Add video or streaming time");
            System.out.println("5. View statistics");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid option. Please choose from 1 to 6.");
                System.out.println();
                continue;
            }
            choice = scanner.nextInt();
            System.out.println();

            if (choice >= 1 && choice <= 4) {
                if (choice == 1) {
                    System.out.print("Enter social media minutes: ");
                } else if (choice == 2) {
                    System.out.print("Enter gaming minutes: ");
                } else if (choice == 3) {
                    System.out.print("Enter studying minutes: ");
                } else {
                    System.out.print("Enter video or streaming minutes: ");
                }

                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println();
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                    System.out.println();
                    continue;
                }
                int minutes = scanner.nextInt();
                System.out.println();

                if (minutes <= 0) {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                    System.out.println();
                    continue; // statistics unchanged
                }

                if (choice == 1) {
                    socialTime += minutes;
                } else if (choice == 2) {
                    gamingTime += minutes;
                } else if (choice == 3) {
                    studyingTime += minutes;
                } else {
                    streamingTime += minutes;
                }
                totalScreenTime += minutes;
                sessionCount++;

                System.out.println("Time added successfully!");
                System.out.println();

            } else if (choice == 5) {
                System.out.println("===== TODAY'S SCREEN TIME =====");
                System.out.println();
                System.out.println("Social media: " + socialTime + " minutes");
                System.out.println("Gaming: " + gamingTime + " minutes");
                System.out.println("Studying: " + studyingTime + " minutes");
                System.out.println("Streaming: " + streamingTime + " minutes");
                System.out.println();
                System.out.println("Total screen time: " + totalScreenTime + " minutes");
                System.out.println("Recorded sessions: " + sessionCount);
                System.out.println();

                // Productive vs. entertainment
                int entertainmentTime = socialTime + gamingTime + streamingTime;
                if (studyingTime > entertainmentTime) {
                    System.out.println("Study screen time is greater than entertainment screen time. Good balance!");
