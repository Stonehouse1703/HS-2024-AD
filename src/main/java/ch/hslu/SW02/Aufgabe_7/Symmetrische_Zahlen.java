package ch.hslu.SW02.Aufgabe_7;

public class Symmetrische_Zahlen {

    public static void main(String[] args) {
        System.out.println(isSymmetric("0110"));
        System.out.println(nextHigher("999"));
    }

    private static boolean isSymmetric(String number) {
        int length = number.length();

        for (int i = 0; i < length / 2; i++) {
            if (number.charAt(i) != number.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private static String nextHigher(String number) {
        int length = number.length();

        // Get the first half of the number and increment it
        int firstHalfInt = Integer.parseInt(number.substring(0, (length + 1) / 2));
        firstHalfInt++;  // Increment the first half

        // Convert the incremented first half back to a string
        String firstHalf = Integer.toString(firstHalfInt);

        // Start constructing the full number with the incremented first half
        StringBuilder fullNumber = new StringBuilder(firstHalf);

        // Mirror the first half to the second half
        for (int i = (length / 2) - 1; i >= 0; i--) {
            fullNumber.append(firstHalf.charAt(i));
        }

        // Return the newly formed palindrome
        return fullNumber.toString();
    }


}
