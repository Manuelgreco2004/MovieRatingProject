import java.util.Scanner;


// Main Class
public class MovieRatingSystem {
    public static void main(String[] args) {
        // Use only one scanner for all inputs; name, movies, numbers, genre.
        Scanner scanner = new Scanner(System.in);

        // Step 1: Implement User Input Handling
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Step 2: Accept and Validate Movie Ratings
        int numMovies = 5;
        String[] movieNames = new String[numMovies];
        int[] movieRatings = new int[numMovies];

        for (int i = 0; i < numMovies; i++) {
            System.out.print("\nEnter the name of movie #" + (i + 1) + ": ");
            movieNames[i] = scanner.nextLine();

            int rating = 0;
            boolean isValid = false;
            while (!isValid) {
                System.out.print("Rate '" + movieNames[i] + "' (scale 1 to 10): ");
                if (scanner.hasNextInt()) {
                    rating = scanner.nextInt();
                    if (rating >= 1 && rating <= 10) {
                        isValid = true;
                    } else {
                        System.out.println("Invalid input. Please enter a whole number.");
                    }
                }
            }

            movieRatings[i] = rating;
            scanner.nextLine(); 
        }

        // Step 3: Calculate the Average Rating
        double sum = 0;
        for (int rating : movieRatings) {
            sum += rating;
        }
        double averageRating = sum / numMovies;
        System.out.printf("\nHello, %s. Your average movie rating is: %.2f\n", userName, averageRating);

        // Step 4: Implement Rating Classification (if-else Statements)
        if (averageRating >= 9) {
            System.out.println("You are a cinephile!");
        } else if (averageRating >= 7) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (averageRating >= 5) {
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        // Step 5: Check for a Favorite Movie (Nested if Statements)
        boolean hasMasterpiece = false;
        boolean hasLowRating = false;

        for (int rating : movieRatings) {
            if (rating == 10) {
                hasMasterpiece = true;
            }
            if (rating < 4) {
                hasLowRating = true;
            }
        }

        if (hasMasterpiece) {
            System.out.println("Wow! You found a masterpiece.");
        }
        if (hasLowRating) {
            System.out.println("That movie didn’t impress you much.");
        }

        // Step 6: Use Logical Operators to Identify Consistent Ratings
        boolean allHigh = true;
        boolean anyVeryLow = false;

        for (int rating : movieRatings) {
            if (rating < 7) {
                allHigh = false;
            }
            if (rating < 3) {
                anyVeryLow = true;
            }
        }

        if (allHigh) {
            System.out.println("You seem to enjoy most movies.");
        } else if (anyVeryLow) {
            System.out.println("You have strong opinions on movies!");
        }

        // Step 7: Implement a switch Statement for Genre Preferences
        System.out.print("\nEnter your favorite movie genre (Action, Comedy, Horror, Drama, Sci-Fi): ");
        String genre = scanner.nextLine().trim();


        // Switch statement providing response depending choice
        switch (genre.toLowerCase()) {
            case "action":
                System.out.println("You love excitement and thrills!");
                break;
            case "comedy":
                System.out.println("You enjoy a good laugh.");
                break;
            case "horror":
                System.out.println("You have a taste for fear!");
                break;
            case "drama":
                System.out.println("You appreciate deep storytelling.");
                break;
            case "sci-fi":
            case "scifi":
                System.out.println("You love futuristic and imaginative worlds!");
                break;
            default:
                System.out.println("That's an interesting genre choice!");
                break;
        }

        // Step 8: Use the Conditional Operator to Display a Movie Recommendation

        // Horror Recommendation
        String horror = genre.equalsIgnoreCase("Horror") || genre.equalsIgnoreCase("SciFi") 
                ? "It" 
                : "War Machine";
        System.out.println("Recommended Movie for you: " + horror);


        scanner.close();
    }
}