package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is for generating the ISIN.
 * It has the ISIN Generator method
 * which generates the ISIN String labeled as
 * "This is the most central part of the case study."
 */
public class ISINGenerator {
    private static final String Letter_And_Number = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

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
        for(int i = 0; i<2; i++){
            ISIN.append(Letter_And_Number.charAt(ThreadLocalRandom.current().nextInt(26)));
        }
        // Generate the random 9 digits after the Uppercase letters
        for(int i = 0; i<9; i++){
            ISIN.append(Letter_And_Number.charAt(ThreadLocalRandom.current().nextInt(Letter_And_Number.length())));
        }
        /**
         * now is the tricky part! have fun
         * Add check digit
         */
        int checkDigit = calculateCheckDigit(ISIN.toString());
        ISIN.append(checkDigit);

        return ISIN.toString();
    }

    private int calculateCheckDigit(String string) {
        return 1;
    }
}
