import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        /** Word encryption process **/
        Scanner scan = new Scanner (System.in);// allows user to input their answer
        System.out.println("Please insert a word to scramble!");// asks user to input a word to scramble

        String userInput = scan.next();// scans the word the user chose and stores it under the string "userInput"

        String encryptedLast = userInput.substring(userInput.length() -1);// stores the last letter of the user's input as "encryptedLast"
        String encryptRemainder = userInput.substring(0, userInput.length() -1);/* takes the remainder of the users input (other than the last letter)
         and stores it as encryptedRemainder */
        String encryptedWord = encryptedLast + encryptRemainder + "ay";/* stores and combines the last letter of the user's input
        the remainder of the user's input and "ay" as the encrypted word */

        System.out.println(encryptedWord);// prints the encrypted word

        /** Word decryption process **/
        String decryptedLast = encryptedWord.substring(0, 1);// stores the first letter (originally the last letter of the user's input) as "decryptedLast"
        String decryptedRemainder = encryptedWord.substring(1, encryptedWord.length() -2);/* stores the encrypted word while subtracting the last two
       letters ("ay") as decryptedRemainder */
        String decryptedWord = decryptedRemainder + decryptedLast;/* effectively decrypts the word by storing the result of adding the first letter of the
        encrypted word and the remainder of the encrypted word, storing it as dycrypted word */

        System.out.println(decryptedWord);// prints the decrypted word
    }

}
