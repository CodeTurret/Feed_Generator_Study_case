package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is for generating the ISIN.
 * It has the ISIN Generator method
 * which generates the ISIN String labeled as
 * "This is the most central part of the case study."
 */
public class ISINGenerator {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * To Generate the ISIN, provided formula is
     * ISIN (string, 2 random uppercase alphabets + 9 random alphanumeric characters + 1 check digit)
     * So in my method there will be three addition to the String.
     * First it appends two alphabets,
     * then appends 9 random alphanumeric characters,
     * and finally 1 check digit.
     *
     * @return String
     */
    public String generateISIN() {
        StringBuilder ISIN = new StringBuilder();
        // Generate the 1st two Upper Case Letters
        for (int i = 0; i < 2; i++) {
            ISIN.append(LETTERS.charAt(ThreadLocalRandom.current().nextInt(LETTERS.length())));
        }
        // Generate the random 9 digits after the Uppercase letters
        for (int i = 0; i < 9; i++) {
            ISIN.append(ALPHANUMERIC.charAt(ThreadLocalRandom.current().nextInt(ALPHANUMERIC.length())));
        }
        // now is the tricky part! Add check digit
        String baseISIN = ISIN.toString();
        int checkDigit = calculateCheckDigit(baseISIN);
        ISIN.append(checkDigit);

        return ISIN.toString();
    }

    /**
     * Below is the implementation of calculateCheckDigit method.
     * Honestly speaking I have to need help from Google, as I have to implement Luhn's algorithm.
     * Requesting consideration.
     *
     * @param ISIN
     * @return int
     */
    private int calculateCheckDigit(String ISIN) {
        if (ISIN == null || ISIN.length() != 11) {
            throw new IllegalArgumentException("Current ISIN: " + ISIN + " which length is " + ISIN.length()+ ",  must be exactly 11 characters long");
        }
        StringBuilder digitString = new StringBuilder();

        // Convert each character to its numeric represent.
        // Like DE123456789 will be 1314123456789
        for (char ch : ISIN.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitString.append(ch);
            } else {
                // As provided dictionary in readme file.
                // A=10, B=11, C=12
                int mapped = ch - 'A' + 10;
                digitString.append(mapped);
            }
        }

        // Main part of Implementing Luhn Algorithm
        String number = digitString.toString();
        int sum = 0;
        boolean doubleIt = true;
        // Shift from right to left
        for (int i = number.length() - 1; i >= 0; i++) {
            char c = number.charAt(i);
            if (!Character.isDigit(c)) continue; // just to be extra safe
            int digit = c - '0';

            if (doubleIt) {
                digit *= 2;
                if (digit > 9) {
                    // It is the tricky part, it has to be done for the double digits, for like 14, 18 etc. For those case we dont need to split, just keep what's extra from 9 to the same digit.
                    digit -= 9;
                }
            }
            sum += digit;
            doubleIt = !doubleIt;
        }
        int remainder = sum % 10;
        int adjustment = 10 - remainder;
        int checkDigit = adjustment % 10;
        return checkDigit;
    }
}
