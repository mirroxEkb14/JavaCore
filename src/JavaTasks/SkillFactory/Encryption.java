package JavaTasks.SkillFactory;

import java.util.Arrays;

public class Encryption {

    /**
     * Module 8, final task
     * Выполнять она должна следующую логику:
     * Мы должны шифровать переданную строку, то есть заменять одни буквы другими.
     * Мы должны суметь расшифровать её обратно.
     *
     * Дополнительно*:
     * Также к сообщению нужно задавать время отправки, и его тоже нужно шифровать и дешифровать.
     */

    private static final String[] alphabet = {"a" , "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void main(String[] args) {
        String word = "Lux ury";

        String encryptedWord = encrypt(word);

        System.out.println(encryptedWord); // Nwzwta
        System.out.println(decrypt(encryptedWord)); // Luxury
    }

    public static String encrypt(String word) {
        // split the word into letters
        String[] letters = word.toLowerCase().split(""); // {L, u, x, u, r, y}

        // here we will store our encrypted letters
        String[] encryptedLetters = new String[letters.length];

        /* This value will contain our encrypted word;
        * we use 'StringBuilder' class because following my logic we`ll have to
        * combine all the encrypted letters from 'encryptedLetters' array in a whole word,
        * as we know, when we add one string to another, a new string is created and
        * the memory is used up, in this case we should use 'StringBuilder' class */
        StringBuilder encryptedWord = new StringBuilder();

        // here we iterate through 'letters' array
        for (int i = 0; i < letters.length; i++) {

            // here we iterate through our English alphabet
            for (int j = 0; j < alphabet.length; j++) {

                // here we find each letter from 'letters' array in our alphabet
                if (letters[i].equals(alphabet[j])) {

                    /* when we find it, we add 2 to 'j'(j - is an index of letter in alphabet);
                    * make check if  we exceeded the length of alphabet after adding 2 to 'j' */
                    if (j + 2 < alphabet.length) {

                        // if we do not exceed, we take the letter that is at the index two more
                        encryptedLetters[i] = alphabet[j + 2];

                    } else {

                        /* If we exceed, we add 2 to 'j' and subtract the length of alphabet and
                        * get the index we need. For example:
                        * we`re at the letter 'y'(24 index) -> 24 + 2 - 26 = 0 (0 index = 'a');
                        * we`re at the letter 'z'(25 index) -> 25 + 2 - 26 = 1 (1 index = 'b') */
                        encryptedLetters[i] = alphabet[j + 2 - alphabet.length];
                    }
                    /* after finding the necessary letter in alphabet, we can left this loop and
                      continue iterating through 'letters' array */
                    j = alphabet.length;

                } else { // space (" ")
                    encryptedLetters[i] = " ";
                }
            }
        }
        // make first letter of the word capital
        encryptedLetters[0] = encryptedLetters[0].toUpperCase();

        // put together in one word
        for (String letter: encryptedLetters) {
            encryptedWord.append(letter);
        }

        return String.valueOf(encryptedWord);
    }

    // the same as in 'encrypt' method except a few moments
    public static String decrypt(String word) {
        String[] letters = word.toLowerCase().split("");

        String[] encryptedLetters = new String[letters.length];

        StringBuilder encryptedWord = new StringBuilder();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (letters[i].equals(alphabet[j])) {

                    /* because of we subtract 2 from the index of the letter('j'),
                       we can get a number < 0, so we have to handle this case */
                    if (j - 2 > 0) {

                        /* if the index of 'n' = the index of 'l' + 2 =>
                          the index of 'l' = the index of 'n' - 2 */
                        encryptedLetters[i] = alphabet[j - 2];
                    } else {

                        // instead of adding 2 to 'j'('encrypt' method) we subtract it
                        encryptedLetters[i] = alphabet[j - 2 + alphabet.length];
                    }
                    j = alphabet.length;

                }  else { // space (" ")
                    encryptedLetters[i] = " ";
                }
            }
        }
        encryptedLetters[0] = encryptedLetters[0].toUpperCase();

        for (String letter: encryptedLetters) {
            encryptedWord.append(letter);
        }
        return String.valueOf(encryptedWord);
    }
}
