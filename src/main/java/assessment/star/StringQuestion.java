package assessment.star;

import java.io.FileNotFoundException;

/**
 *
 * @author Kanagarajan
 */
public final class StringQuestion {
    //Base value
    private static final int BASE = 2;

    private StringQuestion(){}

    public static String starString(int n) {

        // Check if the input is negative
        if (n < 0) {
            throw new IllegalArgumentException("Should not be negative value. Please try with zero or positive number");
        }

        // Calculate 2^n using a while loop
        int computedResult = 1;

        while (n > 0) {
            computedResult = BASE * computedResult;
            n--;
        }

        // Create a StringBuilder to construct the star string
        final StringBuilder starsSb = new StringBuilder(computedResult);

        // Append the stars using a while loop
        while (computedResult > 0) {
            starsSb.append("*");
            computedResult--;
        }

        // transform the StringBuilder to a String and return it
        return starsSb.toString();
    }
}