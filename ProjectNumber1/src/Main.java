import java.util.Scanner;

public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s) {
        /** my stuff**/
        int answer = 0; // creates integer "answer" so numbers of vowels can be stored
        char ch; // creates character "ch" so letters can be stored

        /** the code **/
        for (int i = 0; i < s.length(); i++) {// sets a for loop to go through the string letter by letter
            ch=s.charAt(i);// helps pull characters from the index
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') { // if the character from the index is a vowel, proceed to next step
                answer ++;// increases answer by one
            }
        }
        return answer;// returns the answer (the number of vowels)
        }

    //Code you problem number two here
    static int problemTwo(String s){
        /** my stuff**/
        int answer = 0; // creates integer "answer" so numbers of vowels can be stored
        /** the code **/
        for (int i = 0; i < s.length() - 2; i ++) { // sets a for loop to go through the string letter by letter. subtracts 2 fom the string length to avoid an error
            if(s.substring(i, i + 3).equals("bob")) { // if three characters from the index spell bob, proceed to next step
                answer ++; // increases answer by one
            }
        }
            return answer; // returns the answer (number of times bob occurs in the string)
        }

        //Code your solution to problem number 3 here
        static String problemThree (String s){
            //your code here
            /** my stuff**/
            String longestString = ""; // "longestSubstring" will hold the longest alphabetically correct substring
            String tempString = ""; // "tempString" will hold all alphabetically correct substrings, changes throughout the loop
            int priorNums = 0; // will act as a boundry breaking the substring when it's not alphabetically correct
            int nums = 0; // holds a number

            /** the code **/
            for (int i = 0; i < s.length(); i++) { // sets a for loop to go through the string letter by letter.
                for (int k = 0; k <= 26; k++) { // sets a for loop to help assign each letter a numerical value, which the if statements helps execute
                    if (s.substring(i, i +1).equals("a")){
                        nums = 1;
                    }if (s.startsWith("b", i)) {
                        nums = 2;
                    }if (s.startsWith("c", i)) {
                        nums = 3;
                    }if (s.startsWith("d", i)) {
                        nums = 4;
                    }if (s.startsWith("e", i)) {
                        nums = 5;
                    }if (s.startsWith("f", i)) {
                        nums = 6;
                    }if (s.startsWith("g", i)) {
                        nums = 7;
                    }if (s.startsWith("h", i)) {
                        nums = 8;
                    }if (s.startsWith("i", i)) {
                        nums = 9;
                    }if (s.startsWith("j", i)) {
                        nums = 10;
                    }if (s.startsWith("k", i)) {
                        nums = 11;
                    }if (s.startsWith("l", i)) {
                        nums = 12;
                    }if (s.startsWith("m", i)) {
                        nums = 13;
                    }if (s.startsWith("n", i)) {
                        nums = 14;
                    }if (s.startsWith("o", i)) {
                        nums = 15;
                    }if (s.startsWith("p", i)) {
                        nums = 16;
                    }if (s.startsWith("q", i)) {
                        nums = 17;
                    }if (s.startsWith("r", i)) {
                        nums = 18;
                    }if (s.startsWith("s", i)) {
                        nums = 19;
                    }if (s.startsWith("t", i)) {
                        nums = 20;
                    }if (s.startsWith("u", i)) {
                        nums = 21;
                    }if (s.startsWith("v", i)) {
                        nums = 22;
                    }if (s.startsWith("w", i)) {
                        nums = 23;
                    }if (s.startsWith("x", i)) {
                        nums = 24;
                    }if (s.startsWith("y", i)) {
                        nums = 25;
                    }if (s.startsWith("z", i)) {
                        nums = 26;
                    }
                }
                if (nums >= priorNums) { // checks if "nums" is larger or equal to the previous number, "priorNums", if true proceed to the next step
                    tempString = tempString + s.substring(i, i +1); // adds the letter the for loop tests
                    priorNums = nums; // "priorNums" is assigned the value of "nums" so another check can happen

                } else if (tempString.length() > longestString.length()) { // if the alphabetically correct string that is being tested is longer than the "longestString", proceed to the next step
                    longestString = tempString; // sets "longestString" value to "tempString"
                    tempString = "" + s.substring(i, i + 1); // "tempString" is reset for the next substring
                    priorNums = nums; // "priorNums" is assigned the value of "nums"

                } else { // if the alphabetically correct string being tested is shorter or equal to the "longestString", proceed to the next step
                    tempString = "" + s.substring(i, i+ 1); // "tempString" is reset for the next substring
                    priorNums = nums; // "priorNums" is reset to the value of "nums"
                }
            }
            if (tempString.length() > longestString.length()){ // proceed to the next step if "tempString" is greater than "longestString" (essentially checks if the whole string is alphabetically correct)
                longestString = tempString;// sets "tempString" value to "longestString"
            }
            s = longestString; // assigns the value of "s" to the "longestString"
            return s; // returns the longest alphabetically correct substring
        }

        public static void main (String[]args){
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
            String s = "awercvtbynumiookjhgvlrf";
            problemOne(s);
            problemTwo(s);
            problemThree(s);
        }
}
